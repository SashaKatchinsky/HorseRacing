package by.epam.java.horse_racing.dao.impl;

import by.epam.java.horse_racing.bean.User;
import by.epam.java.horse_racing.dao.exceptions.CloseStatementException;
import by.epam.java.horse_racing.dao.exceptions.DaoException;

import java.sql.Statement;
import java.util.List;

/**
 * The interface User dao.
 */
public interface UserDao {
    /**
     * Gets all users.
     *
     * @return the all users
     * @throws DaoException the dao exception
     */
    List<User> getAllUsers() throws DaoException;

    /**
     * Gets user by login.
     *
     * @param login the login
     * @return the user by login
     * @throws DaoException the dao exception
     */
    User getUserByLogin(String login) throws DaoException;

    /**
     * Delete user.
     *
     * @param login the login
     * @throws DaoException the dao exception
     */
    void deleteUser(String login) throws DaoException;

    /**
     * Insert user.
     *
     * @param user the user
     * @throws DaoException the dao exception
     */
    void insertUser(User user) throws DaoException;

    /**
     * Update user.
     *
     * @param replaceableLogin the replaceable login
     * @param replacement      the replacement
     * @throws DaoException the dao exception
     */
    void updateUser(String replaceableLogin, User replacement) throws DaoException;

    /**
     * Is exists boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean isExists(String login) throws DaoException;

    /**
     * Change balance.
     *
     * @param userLogin the user login
     * @param balance   the balance
     * @throws DaoException the dao exception
     */
    void changeBalance(String userLogin , double balance) throws DaoException;

    /**
     * Close statement.
     *
     * @param statement the statement
     * @throws CloseStatementException the close statement exception
     */
    void closeStatement(Statement statement) throws CloseStatementException;
}
