package by.epam.java.horse_racing.service;

import by.epam.java.horse_racing.bean.Breed;
import by.epam.java.horse_racing.bean.Horse;
import by.epam.java.horse_racing.dao.HorseDaoMySql;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.service.exceptions.AddHorseException;
import by.epam.java.horse_racing.service.exceptions.UpdateHorseException;
import by.epam.java.horse_racing.service.impl.Service;

import java.util.List;

/**
 * The type Horse service.
 */
public class HorseService implements Service {
    private static class HorseServiceHolder {
        private static final HorseService INSTANCE = new HorseService();
    }

    private HorseService() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static HorseService getInstance() {
        return HorseServiceHolder.INSTANCE;
    }

    /**
     * Add horse.
     *
     * @param name  the name
     * @param breed the breed
     * @throws AddHorseException the add horse exception
     */
    public void addHorse(String name , Breed breed) throws AddHorseException {
        try {
            List<Horse> horses = HorseDaoMySql.getInstance().getAllHorses();
            boolean isExists;
            int id;
            while (true) {
                isExists = false;
                id = (int) (1000 * Math.random());
                for (Horse horse : horses) {
                    if (horse.getId() == id) {
                        isExists = true;
                        break;
                    }
                }
                if (!isExists) {
                    break;
                }
            }
            HorseDaoMySql.getInstance().insertHorse(new Horse(id, name, breed));
        } catch (DaoException e) {
            throw new AddHorseException(e);
        }
    }

    /**
     * Update horse.
     *
     * @param id    the id
     * @param name  the name
     * @param breed the breed
     * @throws UpdateHorseException the update horse exception
     */
    public void updateHorse(int id , String name , Breed breed) throws UpdateHorseException {
        try {
            Horse horse = new Horse(id, name, breed);
            HorseDaoMySql.getInstance().updateHorse(id, horse);
        } catch (DaoException e) {
            throw new UpdateHorseException(e);
        }
    }
}
