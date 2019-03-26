package by.epam.java.horse_racing.dao;

import by.epam.java.horse_racing.bean.Rider;
import by.epam.java.horse_racing.dao.connection.ConnectionPool;
import by.epam.java.horse_racing.dao.exceptions.CloseStatementException;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.dao.exceptions.GetConnectionException;
import by.epam.java.horse_racing.dao.exceptions.RequestFailedException;
import by.epam.java.horse_racing.dao.impl.RiderDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Rider dao my sql.
 */
public class RiderDaoMySql implements RiderDao {
    private static class RiderDaoMySqlHolder {
        private static final RiderDaoMySql INSTANCE = new RiderDaoMySql();
    }

    /**
     * The constant SQL_SELECT_ALL_RIDERS.
     */
    private static final String SQL_SELECT_ALL_RIDERS = "SELECT RiderID , Name , HorseID FROM Riders";
    /**
     * The constant SQL_SELECT_RIDER_BY_KEY.
     */
    private static final String SQL_SELECT_RIDER_BY_KEY = "SELECT RiderID , Name , HorseID FROM Riders WHERE RiderID=?";
    /**
     * The constant SQL_DELETE_RIDER_BY_KEY.
     */
    private static final String SQL_DELETE_RIDER_BY_KEY = "DELETE FROM Riders WHERE RiderID=?";
    /**
     * The constant SQL_INSERT_RIDER.
     */
    private static final String SQL_INSERT_RIDER = "INSERT INTO Riders(RiderID , Name , HorseID) VALUES(? , ? , ?)";
    /**
     * The constant SQL_UPDATE_RIDER_BY_KEY.
     */
    private static final String SQL_UPDATE_RIDER_BY_KEY = "UPDATE Riders SET RiderID=? , Name=? , HorseID=? WHERE RiderID=?";
    /**
     * The constant SQL_GET_RIDERS_WITH_CURRENT_HORSE.
     */
    private static final String SQL_GET_RIDERS_WITH_CURRENT_HORSE = "SELECT RiderId , Name , HorseId FROM Riders WHERE HorseId=?";
    /**
     * The constant SQL_SET_HORSE.
     */
    private static final String SQL_SET_HORSE = "UPDATE Riders SET HorseId=? WHERE RiderId=?";
    /**
     * The constant RIDERDAOMYSQLOGGER.
     */
    private static final Logger RIDERDAOMYSQLOGGER = LogManager.getLogger(HorseDaoMySql.class.getName());

    private RiderDaoMySql() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static RiderDaoMySql getInstance() {
        return RiderDaoMySqlHolder.INSTANCE;
    }

    /**
     *
     * @return list of all bets
     * @throws DaoException
     */
    @Override
    public List<Rider> getAllRiders() throws DaoException {
        List<Rider> riders = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        connection = ConnectionPool.getInstance().retrieve();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_RIDERS);
            while (resultSet.next()) {
                Rider rider = new Rider();
                rider.setId(resultSet.getInt("RiderID"));
                rider.setName(resultSet.getString("Name"));
                rider.setHorse(HorseDaoMySql.getInstance().getHorseById(resultSet.getInt("HorseID")));
                riders.add(rider);
            }
            RIDERDAOMYSQLOGGER.info("All riders got");
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(statement);
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
        return riders;
    }

    /**
     *
     * @param riderId
     * @return rider with current id
     * @throws DaoException
     */
    @Override
    public Rider getRiderById(int riderId) throws DaoException {
        Rider rider = new Rider();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_SELECT_RIDER_BY_KEY);
            preparedStatement.setInt(1 , riderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            rider.setId(resultSet.getInt("RiderID"));
            rider.setName(resultSet.getString("Name"));
            rider.setHorse(HorseDaoMySql.getInstance().getHorseById(resultSet.getInt("HorseID")));
            RIDERDAOMYSQLOGGER.info("Rider " + rider + " got");
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } catch (GetConnectionException getConnectionException) {
            getConnectionException.printStackTrace();
        } finally {
            closeStatement(preparedStatement);
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
        return rider;
    }

    /**
     * Delete rider.
     *
     * @param riderId
     * @throws DaoException
     */
    @Override
    public void deleteRider(int riderId) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_DELETE_RIDER_BY_KEY);
            preparedStatement.setInt(1 , riderId);
            preparedStatement.execute();
            RIDERDAOMYSQLOGGER.info("Rider " + RiderDaoMySql.getInstance().getRiderById(riderId) + " deleted");
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
     * Insert rider.
     *
     * @param rider the rider
     * @throws DaoException
     */
    @Override
    public void insertRider(Rider rider) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_INSERT_RIDER);
            preparedStatement.setInt(1 , rider.getId());
            preparedStatement.setString(2 , rider.getName());
            preparedStatement.setInt(3 , rider.getHorse().getId());
            preparedStatement.execute();
            RIDERDAOMYSQLOGGER.info("Rider " + rider + " inserted");
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
     * Update rider.
     *
     * @param replaceableId the replaceable id
     * @param replacement   the replacement
     * @throws DaoException
     */
    @Override
    public void updateRider(int replaceableId, Rider replacement) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_RIDER_BY_KEY);
            preparedStatement.setInt(1 , replacement.getId());
            preparedStatement.setString(2 , replacement.getName());
            preparedStatement.setInt(3 , replacement.getHorse().getId());
            preparedStatement.setInt(4 , replaceableId);
            preparedStatement.executeUpdate();
            RIDERDAOMYSQLOGGER.info("Rider updated from " + RiderDaoMySql.getInstance().getRiderById(replaceableId) + " to " + replacement);
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
     * @param horseId the horse id
     * @return list of riders with current horse
     * @throws DaoException
     */
    @Override
    public List<Rider> getRidersWithCurrentHorse(int horseId) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Rider> riders = new ArrayList<>();
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_GET_RIDERS_WITH_CURRENT_HORSE);
            preparedStatement.setInt(1 , horseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Rider rider = new Rider();
                rider.setId(resultSet.getInt("RiderID"));
                rider.setName(resultSet.getString("Name"));
                rider.setHorse(HorseDaoMySql.getInstance().getHorseById(horseId));
                riders.add(rider);
            }
            RIDERDAOMYSQLOGGER.info("All riders with horse " + HorseDaoMySql.getInstance().getHorseById(horseId) + " got");
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(preparedStatement);
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
        return riders;
    }

    /**
     * Set horse with current id to rider with current id.
     *
     * @param riderId the rider id
     * @param horseId the horse id
     * @throws DaoException
     */
    @Override
    public void setHorse(int riderId, int horseId) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_SET_HORSE);
            preparedStatement.setInt(1 , horseId);
            preparedStatement.setInt(2 , riderId);
            preparedStatement.executeUpdate();
            RIDERDAOMYSQLOGGER.info("Horse of rider " + RiderDaoMySql.getInstance().getRiderById(riderId)
                    + " set as " + HorseDaoMySql.getInstance().getHorseById(horseId));
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
