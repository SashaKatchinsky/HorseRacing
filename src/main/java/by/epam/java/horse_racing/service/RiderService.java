package by.epam.java.horse_racing.service;

import by.epam.java.horse_racing.bean.Horse;
import by.epam.java.horse_racing.bean.Rider;
import by.epam.java.horse_racing.dao.HorseDaoMySql;
import by.epam.java.horse_racing.dao.RiderDaoMySql;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.service.exceptions.AddRiderException;
import by.epam.java.horse_racing.service.exceptions.SetNewHorsesException;
import by.epam.java.horse_racing.service.exceptions.UpdateRiderException;
import by.epam.java.horse_racing.service.impl.Service;

import java.util.List;

/**
 * The type Rider service.
 */
public class RiderService implements Service {
    private static class RiderServiceHolder {
        private static final RiderService INSTANCE = new RiderService();
    }

    private RiderService() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static RiderService getInstance() {
        return RiderServiceHolder.INSTANCE;
    }

    /**
     * Add rider with random id generation.
     *
     * @param name    the name
     * @param horseId the horse id
     * @throws AddRiderException the add rider exception
     */
    public void addRider(String name , int horseId) throws AddRiderException {
        try {
            Horse horse = HorseDaoMySql.getInstance().getHorseById(horseId);
            List<Rider> riders = RiderDaoMySql.getInstance().getAllRiders();
            boolean isExists;
            int id;
            while (true) {
                isExists = false;
                id = (int) (1000 * Math.random());
                for (Rider rider : riders) {
                    if (rider.getId() == id) {
                        isExists = true;
                        break;
                    }
                }
                if (!isExists) {
                    break;
                }
            }
            RiderDaoMySql.getInstance().insertRider(new Rider(id, name, horse));
        } catch (DaoException e) {
            throw new AddRiderException(e);
        }
    }

    /**
     * Update rider.
     *
     * @param id      the id
     * @param name    the name
     * @param horseId the horse id
     * @throws UpdateRiderException the update rider exception
     */
    public void updateRider(int id , String name , int horseId) throws UpdateRiderException {
        try {
            Horse horse = HorseDaoMySql.getInstance().getHorseById(horseId);
            Rider rider = new Rider(id, name, horse);
            RiderDaoMySql.getInstance().updateRider(id, rider);
        } catch (DaoException e) {
            throw new UpdateRiderException(e);
        }
    }

    /**
     * Sets new horses to riders with horse with current id, when this horse deleted.
     *
     * @param horseId the horse id
     * @throws SetNewHorsesException the set new horses exception
     */
    public void setNewHorses(int horseId) throws SetNewHorsesException {
        try {
            List<Horse> horses = HorseDaoMySql.getInstance().getAllHorses();
            List<Rider> ridersWithThisHorse = RiderDaoMySql.getInstance().getRidersWithCurrentHorse(horseId);
            if (ridersWithThisHorse != null) {
                for (Rider rider : ridersWithThisHorse) {
                    int horseIndex = (int) (Math.random() * horses.size());
                    while (horses.get(horseIndex).getId() == horseId) {
                        horseIndex = (int) (Math.random() * horses.size());
                    }
                    RiderDaoMySql.getInstance().setHorse(rider.getId(), horses.get(horseIndex).getId());
                }
            }
        } catch (DaoException e) {
            throw new SetNewHorsesException(e);
        }
    }
}
