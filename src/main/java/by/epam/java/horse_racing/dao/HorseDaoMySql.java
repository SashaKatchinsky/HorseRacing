package by.epam.java.horse_racing.dao;

import by.epam.java.horse_racing.bean.Breed;
import by.epam.java.horse_racing.bean.Horse;
import by.epam.java.horse_racing.dao.connection.ConnectionPool;
import by.epam.java.horse_racing.dao.exceptions.CloseStatementException;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.dao.exceptions.RequestFailedException;
import by.epam.java.horse_racing.dao.impl.HorseDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Horse dao my sql.
 */
public class HorseDaoMySql implements HorseDao {
    private static class HorseDaoMySqlHolder {
        /**
         * The constant INSTANCE.
         */
        public static final HorseDaoMySql INSTANCE = new HorseDaoMySql();
    }

    /**
     * The constant SQL_SELECT_ALL_HORSES.
     */
    private static final String SQL_SELECT_ALL_HORSES = "SELECT HorseID , Name , Breed FROM Horses";
    /**
     * The constant SQL_SELECT_HORSE_BY_KEY.
     */
    private static final String SQL_SELECT_HORSE_BY_KEY = "SELECT Name , Breed FROM Horses WHERE HorseID=?";
    /**
     * The constant SQL_DELETE_HORSE_BY_KEY.
     */
    private static final String SQL_DELETE_HORSE_BY_KEY = "DELETE FROM Horses WHERE HorseID=?";
    /**
     * The constant SQL_INSERT_HORSE.
     */
    private static final String SQL_INSERT_HORSE = "INSERT INTO Horses(HorseID , Name , Breed) VALUES(? , ? , ?)";
    /**
     * The constant SQL_UPDATE_HORSE_BY_KEY.
     */
    private static final String SQL_UPDATE_HORSE_BY_KEY = "UPDATE Horses SET HorseID=? , Name=? , Breed=? WHERE HorseID=?";
    /**
     * The constant HORSEDAOMYSQLLOGGER.
     */
    private static final Logger HORSEDAOMYSQLLOGGER = LogManager.getLogger(HorseDaoMySql.class.getName());

    private HorseDaoMySql() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static HorseDaoMySql getInstance() {
        return HorseDaoMySqlHolder.INSTANCE;
    }

    /**
     *
     * @return list of all horses
     * @throws DaoException
     */
    @Override
    public List<Horse> getAllHorses() throws DaoException {
        List<Horse> horses = new ArrayList<>();
        Connection connection;
        Statement statement = null;
        connection = ConnectionPool.getInstance().retrieve();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_HORSES);
            while (resultSet.next()) {
                Horse horse = new Horse(resultSet.getInt("HorseID"),
                        resultSet.getString("Name"),
                        Breed.valueOf(resultSet.getString("Breed").toUpperCase()));
                horses.add(horse);
            }
            HORSEDAOMYSQLLOGGER.info("All horses got");
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(statement);
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
        return horses;
    }

    /**
     *
     * @param horseId
     * @return horse with current id
     * @throws DaoException
     */
    @Override
    public Horse getHorseById(int horseId) throws DaoException {
        Horse horse;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_SELECT_HORSE_BY_KEY);
            preparedStatement.setInt(1 , horseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            horse = new Horse(horseId,
                    resultSet.getString("Name"),
                    Breed.valueOf(resultSet.getString("Breed").toUpperCase()));
            HORSEDAOMYSQLLOGGER.info("Horse " + horse + " got");
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(preparedStatement);
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
        return horse;
    }

    /**
     * Delete horse with current id.
     *
     * @param horseId
     * @throws DaoException
     */
    @Override
    public void deleteHorse(int horseId) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_DELETE_HORSE_BY_KEY);
            preparedStatement.setInt(1 , horseId);
            preparedStatement.execute();
            HORSEDAOMYSQLLOGGER.info("Horse " + horseId + " deleted");
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
     * Insert horse.
     *
     * @param horse the horse
     * @throws DaoException
     */
    @Override
    public void insertHorse(Horse horse) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_INSERT_HORSE);
            preparedStatement.setInt(1 , horse.getId());
            preparedStatement.setString(2 , horse.getName());
            preparedStatement.setString(3 , horse.getBreed().toString().toLowerCase());
            preparedStatement.execute();
            HORSEDAOMYSQLLOGGER.info("Horse " + horse + " inserted");
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
     * Update horse with current id.
     *
     * @param replaceableId
     * @param replacement    the replacement
     * @throws DaoException
     */
    @Override
    public void updateHorse(int replaceableId, Horse replacement) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_HORSE_BY_KEY);
            preparedStatement.setInt(1 , replacement.getId());
            preparedStatement.setString(2 , replacement.getName());
            preparedStatement.setString(3 , replacement.getBreed().toString().toLowerCase());
            preparedStatement.setInt(4 , replaceableId);
            preparedStatement.executeUpdate();
            HORSEDAOMYSQLLOGGER.info("Horse updated from " + HorseDaoMySql.getInstance().getHorseById(replaceableId) + " to " + replacement);
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
