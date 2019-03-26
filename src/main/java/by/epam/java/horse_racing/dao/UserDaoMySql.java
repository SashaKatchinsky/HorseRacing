package by.epam.java.horse_racing.dao;

import by.epam.java.horse_racing.action.PasswordHasher;
import by.epam.java.horse_racing.bean.Access;
import by.epam.java.horse_racing.bean.User;
import by.epam.java.horse_racing.dao.connection.ConnectionPool;
import by.epam.java.horse_racing.dao.exceptions.CloseStatementException;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.dao.exceptions.RequestFailedException;
import by.epam.java.horse_racing.dao.impl.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type User dao my sql.
 */
public class UserDaoMySql implements UserDao {
    private static class UserDaoMySqlHolder {
        /**
         * The constant INSTANCE.
         */
        public static final UserDaoMySql INSTANCE = new UserDaoMySql();
    }

    /**
     * The constant SQL_SELECT_ALL_USERS.
     */
    private static final String SQL_SELECT_ALL_USERS = "SELECT Login , Password , Name , Balance , RegistrationDate , Access FROM Users";
    /**
     * The constant SQL_SELECT_USER_BY_KEY.
     */
    private static final String SQL_SELECT_USER_BY_KEY = "SELECT Login , Password , Name , Balance , RegistrationDate , Access FROM Users WHERE Login=?";
    /**
     * The constant SQL_DELETE_USER_BY_KEY.
     */
    private static final String SQL_DELETE_USER_BY_KEY = "DELETE FROM Users WHERE Login=?";
    /**
     * The constant SQL_INSERT_USER.
     */
    private static final String SQL_INSERT_USER = "INSERT INTO Users(Login , Password , Name , Balance , RegistrationDate , Access) VALUES(? , ? , ? , ? , ? , ?)";
    /**
     * The constant SQL_UPDATE_USER_BY_KEY.
     */
    private static final String SQL_UPDATE_USER_BY_KEY = "UPDATE Users SET Login=? , Name=? , Balance=? , RegistrationDate=? , Access=? WHERE Login=?";
    /**
     * The constant SQL_CHANGE_BALANCE.
     */
    private static final String SQL_CHANGE_BALANCE = "UPDATE Users SET Balance=? WHERE Login=?";
    /**
     * The constant USERDAOMYSQLLOGGER.
     */
    private static final Logger USERDAOMYSQLLOGGER = LogManager.getLogger(UserDaoMySql.class.getName());

    private UserDaoMySql() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static UserDaoMySql getInstance() {
        return UserDaoMySqlHolder.INSTANCE;
    }

    /**
     *
     * @return list of all users.
     * @throws DaoException
     */
    @Override
    public List<User> getAllUsers() throws DaoException {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        connection = ConnectionPool.getInstance().retrieve();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()) {
                User user = new User(resultSet.getString("Login"),
                                        resultSet.getString("Password").toCharArray(),
                                        resultSet.getString("Name"),
                                        resultSet.getDouble("Balance"),
                                        resultSet.getString("RegistrationDate"),
                                        Access.valueOf(resultSet.getString("Access").toUpperCase()));
                users.add(user);
            }
            USERDAOMYSQLLOGGER.info("All users got");
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(statement);
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
        return users;
    }

    /**
     *
     * @param login the login
     * @return user with current login
     * @throws DaoException
     */
    @Override
    public User getUserByLogin(String login) throws DaoException {
        User user;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_KEY);
            preparedStatement.setString(1 , login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = new User(resultSet.getString("Login"),
                    resultSet.getString("Password").toCharArray(),
                    resultSet.getString("Name"),
                    resultSet.getDouble("Balance"),
                    resultSet.getString("RegistrationDate"),
                    Access.valueOf(resultSet.getString("Access").toUpperCase()));
            USERDAOMYSQLLOGGER.info("User " + user + " got");
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(preparedStatement);
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
        return user;
    }

    /**
     * Delete user with current login.
     *
     * @param login the login
     * @throws DaoException
     */
    @Override
    public void deleteUser(String login) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_DELETE_USER_BY_KEY);
            preparedStatement.setString(1 , login);
            USERDAOMYSQLLOGGER.info("User " + UserDaoMySql.getInstance().getUserByLogin(login) + " deleted");
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(preparedStatement);
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
    }

    /**
     * Insert user.
     *
     * @param user the user
     * @throws DaoException
     */
    @Override
    public void insertUser(User user) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
            preparedStatement.setString(1 , user.getLogin());
            preparedStatement.setString(2 , PasswordHasher.getInstance().hash(user.getPassword()));
            preparedStatement.setString(3 , user.getName());
            preparedStatement.setDouble(4 , user.getBalance());
            preparedStatement.setString(5 , user.getRegistrationDate().toString());
            preparedStatement.setString(6 , user.getAccess().toString().toLowerCase());
            preparedStatement.execute();
            USERDAOMYSQLLOGGER.info("User " + user + " inserted");
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(preparedStatement);
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
    }

    /**
     * Update user.
     *
     * @param replaceableLogin the replaceable login
     * @param replacement      the replacement
     * @throws DaoException
     */
    @Override
    public void updateUser(String replaceableLogin, User replacement) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_BY_KEY);
            preparedStatement.setString(1 , replacement.getLogin());
            preparedStatement.setString(2 , replacement.getName());
            preparedStatement.setDouble(3 , replacement.getBalance());
            preparedStatement.setString(4 , replacement.getRegistrationDate().toString());
            preparedStatement.setString(5 , replacement.getAccess().toString());
            preparedStatement.setString(6 , replaceableLogin);
            preparedStatement.executeUpdate();
            USERDAOMYSQLLOGGER.info("User updated from " + UserDaoMySql.getInstance().getUserByLogin(replaceableLogin)
                    + " to " + replacement);
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(preparedStatement);
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
    }

    /**
     *
     * @param login the login
     * @return true, if user with current login exists, otherwise false
     * @throws DaoException
     */
    @Override
    public boolean isExists(String login) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_KEY);
            preparedStatement.setString(1 , login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            resultSet.getString("login");
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            closeStatement(preparedStatement);
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
    }

    /**
     * Change balance of user with current login.
     *
     * @param userLogin the user login
     * @param balance   the balance
     * @throws DaoException
     */
    @Override
    public synchronized void changeBalance(String userLogin, double balance) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        User user = UserDaoMySql.getInstance().getUserByLogin(userLogin);
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_CHANGE_BALANCE);
            preparedStatement.setDouble(1 , balance);
            preparedStatement.setString(2 , userLogin);
            USERDAOMYSQLLOGGER.info("Balance of user " + user + " changed from " + user.getBalance() + " to " + balance);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(preparedStatement);
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
    }

    /**
     * Close statement.
     *
     * @param statement the statement
     * @throws CloseStatementException
     */
    @Override
    public void closeStatement(Statement statement) throws CloseStatementException {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new CloseStatementException(e);
        }
    }
}
