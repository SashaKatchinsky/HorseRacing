package by.epam.java.horse_racing.dao.impl;

import by.epam.java.horse_racing.bean.Rider;
import by.epam.java.horse_racing.dao.exceptions.CloseStatementException;
import by.epam.java.horse_racing.dao.exceptions.DaoException;

import java.sql.Statement;
import java.util.List;

/**
 * The interface Rider dao.
 */
public interface RiderDao {
    /**
     * Gets all riders.
     *
     * @return the all riders
     * @throws DaoException the dao exception
     */
    List<Rider> getAllRiders() throws DaoException;

    /**
     * Gets rider by id.
     *
     * @param id the id
     * @return the rider by id
     * @throws DaoException the dao exception
     */
    Rider getRiderById(int id) throws DaoException;

    /**
     * Delete rider.
     *
     * @param id the id
     * @throws DaoException the dao exception
     */
    void deleteRider(int id) throws DaoException;

    /**
     * Insert rider.
     *
     * @param rider the rider
     * @throws DaoException the dao exception
     */
    void insertRider(Rider rider) throws DaoException;

    /**
     * Update rider.
     *
     * @param replaceableId the replaceable id
     * @param replacement   the replacement
     * @throws DaoException the dao exception
     */
    void updateRider(int replaceableId, Rider replacement) throws DaoException;

    /**
     * Gets riders with current horse.
     *
     * @param horseId the horse id
     * @return the riders with current horse
     * @throws DaoException the dao exception
     */
    List<Rider> getRidersWithCurrentHorse(int horseId) throws DaoException;

    /**
     * Sets horse.
     *
     * @param riderId the rider id
     * @param horseId the horse id
     * @throws DaoException the dao exception
     */
    void setHorse(int riderId , int horseId) throws DaoException;

    /**
     * Close statement.
     *
     * @param statement the statement
     * @throws CloseStatementException the close statement exception
     */
    void closeStatement(Statement statement) throws CloseStatementException;
}
