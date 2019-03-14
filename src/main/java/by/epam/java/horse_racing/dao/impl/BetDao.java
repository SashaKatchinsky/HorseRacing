package by.epam.java.horse_racing.dao.impl;

import by.epam.java.horse_racing.bean.Bet;
import by.epam.java.horse_racing.bean.BetStatus;
import by.epam.java.horse_racing.dao.exceptions.DaoException;

import java.sql.Statement;
import java.util.List;

/**
 * The interface Bet dao.
 */
public interface BetDao {
    /**
     * Gets all bets.
     *
     * @return the all bets
     * @throws DaoException the dao exception
     */
    List<Bet> getAllBets() throws DaoException;

    /**
     * Gets all users bets.
     *
     * @param login the login
     * @return the all users bets
     * @throws DaoException the dao exception
     */
    List<Bet> getAllUsersBets(String login) throws DaoException;

    /**
     * Gets bet by id.
     *
     * @param id the id
     * @return the bet by id
     * @throws DaoException the dao exception
     */
    Bet getBetById(int id) throws DaoException;

    /**
     * Delete bet.
     *
     * @param id the id
     * @throws DaoException the dao exception
     */
    void deleteBet(int id) throws DaoException;

    /**
     * Insert bet.
     *
     * @param bet the bet
     * @throws DaoException the dao exception
     */
    void insertBet(Bet bet) throws DaoException;

    /**
     * Update bet.
     *
     * @param replaceableId the replaceable id
     * @param replacement   the replacement
     * @throws DaoException the dao exception
     */
    void updateBet(int replaceableId, Bet replacement) throws DaoException;

    /**
     * Delete all users bets.
     *
     * @param userLogin the user login
     * @throws DaoException the dao exception
     */
    void deleteAllUsersBets(String userLogin) throws DaoException;

    /**
     * Gets bets with current ivent.
     *
     * @param iventid the iventid
     * @return the bets with current ivent
     * @throws DaoException the dao exception
     */
    List<Bet> getBetsWithCurrentIvent(int iventid) throws DaoException;

    /**
     * Sets bet status.
     *
     * @param betId  the bet id
     * @param status the status
     * @throws DaoException the dao exception
     */
    void setBetStatus(int betId , BetStatus status) throws DaoException;

    /**
     * Close statement.
     *
     * @param statement the statement
     * @throws DaoException the dao exception
     */
    void closeStatement(Statement statement) throws DaoException;
}
