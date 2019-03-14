package by.epam.java.horse_racing.dao.impl;

import by.epam.java.horse_racing.bean.Horse;
import by.epam.java.horse_racing.dao.exceptions.CloseStatementException;
import by.epam.java.horse_racing.dao.exceptions.DaoException;

import java.sql.Statement;
import java.util.List;

/**
 * The interface Horse dao.
 */
public interface HorseDao {
    /**
     * Gets all horses.
     *
     * @return the all horses
     * @throws DaoException the dao exception
     */
    List<Horse> getAllHorses() throws DaoException;

    /**
     * Gets horse by id.
     *
     * @param id the id
     * @return the horse by id
     * @throws DaoException the dao exception
     */
    Horse getHorseById(int id) throws DaoException;

    /**
     * Delete horse.
     *
     * @param id the id
     * @throws DaoException the dao exception
     */
    void deleteHorse(int id) throws DaoException;

    /**
     * Insert horse.
     *
     * @param horse the horse
     * @throws DaoException the dao exception
     */
    void insertHorse(Horse horse) throws DaoException;

    /**
     * Update horse.
     *
     * @param replaceableKey the replaceable key
     * @param replacement    the replacement
     * @throws DaoException the dao exception
     */
    void updateHorse(int replaceableKey, Horse replacement) throws DaoException;

    /**
     * Close statement.
     *
     * @param statement the statement
     * @throws CloseStatementException the close statement exception
     */
    void closeStatement(Statement statement) throws CloseStatementException;
}
