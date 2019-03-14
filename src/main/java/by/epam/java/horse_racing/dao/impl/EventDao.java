package by.epam.java.horse_racing.dao.impl;

import by.epam.java.horse_racing.bean.Event;
import by.epam.java.horse_racing.dao.exceptions.CloseStatementException;
import by.epam.java.horse_racing.dao.exceptions.DaoException;

import java.sql.Statement;
import java.util.List;

/**
 * The interface Event dao.
 */
public interface EventDao {
    /**
     * Gets all events.
     *
     * @return the all events
     * @throws DaoException the dao exception
     */
    List<Event> getAllEvents() throws DaoException;

    /**
     * Gets ivent by id.
     *
     * @param id the id
     * @return the ivent by id
     * @throws DaoException the dao exception
     */
    Event getIventById(int id) throws DaoException;

    /**
     * Delete event.
     *
     * @param key the key
     * @throws DaoException the dao exception
     */
    void deleteEvent(int key) throws DaoException;

    /**
     * Insert event.
     *
     * @param event the event
     * @throws DaoException the dao exception
     */
    void insertEvent(Event event) throws DaoException;

    /**
     * Update event.
     *
     * @param replaceableId the replaceable id
     * @param replacement   the replacement
     * @throws DaoException the dao exception
     */
    void updateEvent(int replaceableId, Event replacement) throws DaoException;

    /**
     * Sets positions on event.
     *
     * @param iventId        the ivent id
     * @param rider1Posotion the rider 1 posotion
     * @param rider2Position the rider 2 position
     * @param rider3Position the rider 3 position
     * @param rider4Position the rider 4 position
     * @throws DaoException the dao exception
     */
    void setPositionsOnEvent(int iventId , int rider1Posotion , int rider2Position , int rider3Position , int rider4Position) throws DaoException;

    /**
     * Close statement.
     *
     * @param statement the statement
     * @throws CloseStatementException the close statement exception
     */
    void closeStatement(Statement statement) throws CloseStatementException;
}
