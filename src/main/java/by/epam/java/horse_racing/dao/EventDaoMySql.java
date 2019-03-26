package by.epam.java.horse_racing.dao;

import by.epam.java.horse_racing.bean.Event;
import by.epam.java.horse_racing.dao.connection.ConnectionPool;
import by.epam.java.horse_racing.dao.exceptions.CloseStatementException;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.dao.exceptions.GetConnectionException;
import by.epam.java.horse_racing.dao.exceptions.RequestFailedException;
import by.epam.java.horse_racing.dao.impl.EventDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Event dao my sql.
 */
public class EventDaoMySql implements EventDao {
    private static class IventDaoMySqlHolder {
        private static EventDaoMySql INSTANCE = new EventDaoMySql();
    }

    /**
     * The constant SQL_SELECT_ALL_IVENTS.
     */
    private static final String SQL_SELECT_ALL_IVENTS = "SELECT IventID, Name , Date , Time , Rider1ID , Rider2ID , Rider3ID , Rider4ID ," +
            "Rider1Position , Rider2Position , Rider3Position , Rider4Position , " +
            "Rider1_Place1_Coefficient , Rider1_Place2_Coefficient , Rider1_Place3_Coefficient , Rider1_Place4_Coefficient ," +
            "Rider2_Place1_Coefficient , Rider2_Place2_Coefficient , Rider2_Place3_Coefficient , Rider2_Place4_Coefficient ," +
            "Rider3_Place1_Coefficient , Rider3_Place2_Coefficient , Rider3_Place3_Coefficient , Rider3_Place4_Coefficient ," +
            "Rider4_Place1_Coefficient , Rider4_Place2_Coefficient , Rider4_Place3_Coefficient , Rider4_Place4_Coefficient FROM Ivents";
    /**
     * The constant SQL_SELECT_IVENT_BY_KEY.
     */
    private static final String SQL_SELECT_IVENT_BY_KEY = "SELECT IventID, Name , Date , Time , Rider1ID , Rider2ID , Rider3ID , Rider4ID ," +
            "Rider1_Place1_Coefficient , Rider1_Place2_Coefficient , Rider1_Place3_Coefficient , Rider1_Place4_Coefficient ," +
            "Rider2_Place1_Coefficient , Rider2_Place2_Coefficient , Rider2_Place3_Coefficient , Rider2_Place4_Coefficient ," +
            "Rider3_Place1_Coefficient , Rider3_Place2_Coefficient , Rider3_Place3_Coefficient , Rider3_Place4_Coefficient ," +
            "Rider4_Place1_Coefficient , Rider4_Place2_Coefficient , Rider4_Place3_Coefficient , Rider4_Place4_Coefficient ," +
            "Rider1Position , Rider2Position , Rider3Position , Rider4Position FROM Ivents WHERE IventID=?";
    /**
     * The constant SQL_DELETE_IVENT_BY_KEY.
     */
    private static final String SQL_DELETE_IVENT_BY_KEY = "DELETE FROM Ivents WHERE IventID=?";
    /**
     * The constant SQL_INSERT_IVENT.
     */
    private static final String SQL_INSERT_IVENT = "INSERT INTO Ivents(IventID, Name , Date , Time , Rider1ID , Rider2ID , Rider3ID , Rider4ID , " +
            "Rider1_Place1_Coefficient , Rider1_Place2_Coefficient , Rider1_Place3_Coefficient , Rider1_Place4_Coefficient ," +
            "Rider2_Place1_Coefficient , Rider2_Place2_Coefficient , Rider2_Place3_Coefficient , Rider2_Place4_Coefficient ," +
            "Rider3_Place1_Coefficient , Rider3_Place2_Coefficient , Rider3_Place3_Coefficient , Rider3_Place4_Coefficient ," +
            "Rider4_Place1_Coefficient , Rider4_Place2_Coefficient , Rider4_Place3_Coefficient , Rider4_Place4_Coefficient ) " +
            "VALUES(? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
    /**
     * The constant SQL_UPDATE_IVENT_BY_KEY.
     */
    private static final String SQL_UPDATE_IVENT_BY_KEY = "UPDATE Ivents SET IventID=?, Name=? , Date=? , Time=? ," +
            "Rider1ID=? , Rider2ID=? , Rider3ID=? , Rider4ID=? , " +
            "Rider1_Place1_Coefficient=? , Rider1_Place2_Coefficient=? , Rider1_Place3_Coefficient=? , Rider1_Place4_Coefficient=? ," +
            "Rider2_Place1_Coefficient=? , Rider2_Place2_Coefficient=? , Rider2_Place3_Coefficient=? , Rider2_Place4_Coefficient=? ," +
            "Rider3_Place1_Coefficient=? , Rider3_Place2_Coefficient=? , Rider3_Place3_Coefficient=? , Rider3_Place4_Coefficient=? ," +
            "Rider4_Place1_Coefficient=? , Rider4_Place2_Coefficient=? , Rider4_Place3_Coefficient=? , Rider4_Place4_Coefficient=? WHERE IventID=?";
    /**
     * The constant SQL_UPDATE_POSITIONS.
     */
    private static final String SQL_UPDATE_POSITIONS = "UPDATE Ivents SET Rider1Position=? , Rider2Position=? , Rider3Position=? , " +
            "Rider4Position=? WHERE IventID=?";
    /**
     * The constant EVENTDAOMYSQLLOGGER.
     */
    private static final Logger EVENTDAOMYSQLLOGGER = LogManager.getLogger(EventDaoMySql.class.getName());

    private EventDaoMySql() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static EventDaoMySql getInstance() {
        return IventDaoMySqlHolder.INSTANCE;
    }

    /**
     *
     * @return list of all events
     * @throws DaoException
     */
    @Override
    public synchronized List<Event> getAllEvents() throws DaoException {
        List<Event> events = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_IVENTS);
            while (resultSet.next()) {
                Event event = new Event();
                event.setId(resultSet.getInt("IventID"));
                event.setName(resultSet.getString("Name"));
                event.setDate(LocalDate.parse(resultSet.getString("Date")));
                event.setTime(LocalTime.parse(resultSet.getString("Time")));
                event.setRider1(RiderDaoMySql.getInstance().getRiderById(resultSet.getInt("Rider1ID")));
                event.setRider2(RiderDaoMySql.getInstance().getRiderById(resultSet.getInt("Rider2ID")));
                event.setRider3(RiderDaoMySql.getInstance().getRiderById(resultSet.getInt("Rider3ID")));
                event.setRider4(RiderDaoMySql.getInstance().getRiderById(resultSet.getInt("Rider4ID")));

                event.setRider1Position1Coefficient(resultSet.getDouble("Rider1_Place1_Coefficient"));
                event.setRider1Position2Coefficient(resultSet.getDouble("Rider1_Place2_Coefficient"));
                event.setRider1Position3Coefficient(resultSet.getDouble("Rider1_Place3_Coefficient"));
                event.setRider1Position4Coefficient(resultSet.getDouble("Rider1_Place4_Coefficient"));

                event.setRider2Position1Coefficient(resultSet.getDouble("Rider2_Place1_Coefficient"));
                event.setRider2Position2Coefficient(resultSet.getDouble("Rider2_Place2_Coefficient"));
                event.setRider2Position3Coefficient(resultSet.getDouble("Rider2_Place3_Coefficient"));
                event.setRider2Position4Coefficient(resultSet.getDouble("Rider2_Place4_Coefficient"));

                event.setRider3Position1Coefficient(resultSet.getDouble("Rider3_Place1_Coefficient"));
                event.setRider3Position2Coefficient(resultSet.getDouble("Rider3_Place2_Coefficient"));
                event.setRider3Position3Coefficient(resultSet.getDouble("Rider3_Place3_Coefficient"));
                event.setRider3Position4Coefficient(resultSet.getDouble("Rider3_Place4_Coefficient"));

                event.setRider4Position1Coefficient(resultSet.getDouble("Rider4_Place1_Coefficient"));
                event.setRider4Position2Coefficient(resultSet.getDouble("Rider4_Place2_Coefficient"));
                event.setRider4Position3Coefficient(resultSet.getDouble("Rider4_Place3_Coefficient"));
                event.setRider4Position4Coefficient(resultSet.getDouble("Rider4_Place4_Coefficient"));

                event.setRider1Position(resultSet.getInt("Rider1Position"));
                event.setRider2Position(resultSet.getInt("Rider2Position"));
                event.setRider3Position(resultSet.getInt("Rider3Position"));
                event.setRider4Position(resultSet.getInt("Rider4Position"));
                events.add(event);
            }
            EVENTDAOMYSQLLOGGER.info("All events got");
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(statement);
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
        return events;
    }

    /**
     *
     * @param eventId
     * @return event with current id
     * @throws DaoException
     */
    @Override
    public Event getIventById(int eventId) throws DaoException {
        Event event = new Event();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_SELECT_IVENT_BY_KEY);
            preparedStatement.setInt(1 , eventId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            event.setId(eventId);
            event.setName(resultSet.getString("Name"));
            event.setDate(LocalDate.parse(resultSet.getString("Date")));
            event.setTime(LocalTime.parse(resultSet.getString("Time")));
            event.setRider1(RiderDaoMySql.getInstance().getRiderById(resultSet.getInt("Rider1ID")));
            event.setRider2(RiderDaoMySql.getInstance().getRiderById(resultSet.getInt("Rider2ID")));
            event.setRider3(RiderDaoMySql.getInstance().getRiderById(resultSet.getInt("Rider3ID")));
            event.setRider4(RiderDaoMySql.getInstance().getRiderById(resultSet.getInt("Rider4ID")));
            event.setRider1Position1Coefficient(resultSet.getDouble("Rider1_Place1_Coefficient"));
            event.setRider1Position2Coefficient(resultSet.getDouble("Rider1_Place2_Coefficient"));
            event.setRider1Position3Coefficient(resultSet.getDouble("Rider1_Place3_Coefficient"));
            event.setRider1Position4Coefficient(resultSet.getDouble("Rider1_Place4_Coefficient"));
            event.setRider2Position1Coefficient(resultSet.getDouble("Rider2_Place1_Coefficient"));
            event.setRider2Position2Coefficient(resultSet.getDouble("Rider2_Place2_Coefficient"));
            event.setRider2Position3Coefficient(resultSet.getDouble("Rider2_Place3_Coefficient"));
            event.setRider2Position4Coefficient(resultSet.getDouble("Rider2_Place4_Coefficient"));
            event.setRider3Position1Coefficient(resultSet.getDouble("Rider3_Place1_Coefficient"));
            event.setRider3Position2Coefficient(resultSet.getDouble("Rider3_Place2_Coefficient"));
            event.setRider3Position3Coefficient(resultSet.getDouble("Rider3_Place3_Coefficient"));
            event.setRider3Position4Coefficient(resultSet.getDouble("Rider3_Place4_Coefficient"));
            event.setRider4Position1Coefficient(resultSet.getDouble("Rider4_Place1_Coefficient"));
            event.setRider4Position2Coefficient(resultSet.getDouble("Rider4_Place2_Coefficient"));
            event.setRider4Position3Coefficient(resultSet.getDouble("Rider4_Place3_Coefficient"));
            event.setRider4Position4Coefficient(resultSet.getDouble("Rider4_Place4_Coefficient"));
            event.setRider1Position(resultSet.getInt("Rider1Position"));
            event.setRider2Position(resultSet.getInt("Rider2Position"));
            event.setRider3Position(resultSet.getInt("Rider3Position"));
            event.setRider4Position(resultSet.getInt("Rider4Position"));
            EVENTDAOMYSQLLOGGER.info("Event " + event + " got");
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
        return event;
    }

    /**
     * Delete event.
     *
     * @param eventId
     * @throws DaoException
     */
    @Override
    public void deleteEvent(int eventId) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_DELETE_IVENT_BY_KEY);
            preparedStatement.setInt(1 , eventId);
            EVENTDAOMYSQLLOGGER.info("Event " + EventDaoMySql.getInstance().getIventById(eventId) + " deleted");
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
     * Insert event.
     *
     * @param event the event
     * @throws DaoException
     */
    @Override
    public void insertEvent(Event event) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_INSERT_IVENT);
            preparedStatement.setInt(1 , event.getId());
            preparedStatement.setString(2 , event.getName());
            preparedStatement.setString(3 , event.getDate().toString());
            preparedStatement.setString(4 , event.getTime().toString());
            preparedStatement.setInt(5 , event.getRider1().getId());
            preparedStatement.setInt(6 , event.getRider2().getId());
            preparedStatement.setInt(7 , event.getRider3().getId());
            preparedStatement.setInt(8 , event.getRider4().getId());
            preparedStatement.setDouble(9 , event.getRider1Position1Coefficient());
            preparedStatement.setDouble(10 , event.getRider1Position2Coefficient());
            preparedStatement.setDouble(11 , event.getRider1Position3Coefficient());
            preparedStatement.setDouble(12 , event.getRider1Position4Coefficient());
            preparedStatement.setDouble(13 , event.getRider2Position1Coefficient());
            preparedStatement.setDouble(14 , event.getRider2Position2Coefficient());
            preparedStatement.setDouble(15 , event.getRider2Position3Coefficient());
            preparedStatement.setDouble(16 , event.getRider2Position4Coefficient());
            preparedStatement.setDouble(17 , event.getRider3Position1Coefficient());
            preparedStatement.setDouble(18 , event.getRider3Position2Coefficient());
            preparedStatement.setDouble(19 , event.getRider3Position3Coefficient());
            preparedStatement.setDouble(20 , event.getRider3Position4Coefficient());
            preparedStatement.setDouble(21 , event.getRider4Position1Coefficient());
            preparedStatement.setDouble(22 , event.getRider4Position2Coefficient());
            preparedStatement.setDouble(23 , event.getRider4Position3Coefficient());
            preparedStatement.setDouble(24 , event.getRider4Position4Coefficient());
            preparedStatement.execute();
            EVENTDAOMYSQLLOGGER.info("Event " + event + " inserted");
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
     * Update event.
     *
     * @param replaceableId the replaceable id
     * @param replacement   the replacement
     * @throws DaoException
     */
    @Override
    public synchronized void updateEvent(int replaceableId, Event replacement) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_IVENT_BY_KEY);
            preparedStatement.setInt(1 , replacement.getId());
            preparedStatement.setString(2 , replacement.getName());
            preparedStatement.setString(3 , replacement.getDate().toString());
            preparedStatement.setString(4 , replacement.getTime().toString());
            preparedStatement.setInt(5 , replacement.getRider1().getId());
            preparedStatement.setInt(6 , replacement.getRider2().getId());
            preparedStatement.setInt(7 , replacement.getRider3().getId());
            preparedStatement.setInt(8 , replacement.getRider4().getId());
            preparedStatement.setDouble(9 , replacement.getRider1Position1Coefficient());
            preparedStatement.setDouble(10 , replacement.getRider1Position2Coefficient());
            preparedStatement.setDouble(11 , replacement.getRider1Position3Coefficient());
            preparedStatement.setDouble(12 , replacement.getRider1Position4Coefficient());
            preparedStatement.setDouble(13 , replacement.getRider2Position1Coefficient());
            preparedStatement.setDouble(14 , replacement.getRider2Position2Coefficient());
            preparedStatement.setDouble(15 , replacement.getRider2Position3Coefficient());
            preparedStatement.setDouble(16 , replacement.getRider2Position4Coefficient());
            preparedStatement.setDouble(17 , replacement.getRider3Position1Coefficient());
            preparedStatement.setDouble(18 , replacement.getRider3Position2Coefficient());
            preparedStatement.setDouble(19 , replacement.getRider3Position3Coefficient());
            preparedStatement.setDouble(20 , replacement.getRider3Position4Coefficient());
            preparedStatement.setDouble(21 , replacement.getRider4Position1Coefficient());
            preparedStatement.setDouble(22 , replacement.getRider4Position2Coefficient());
            preparedStatement.setDouble(23 , replacement.getRider4Position3Coefficient());
            preparedStatement.setDouble(24 , replacement.getRider4Position4Coefficient());
            preparedStatement.setInt(25 , replaceableId);
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
     * Set rider's positions on event with current id.
     *
     * @param eventId
     * @param rider1Position
     * @param rider2Position the rider 2 position
     * @param rider3Position the rider 3 position
     * @param rider4Position the rider 4 position
     * @throws DaoException
     */
    @Override
    public void setPositionsOnEvent(int eventId , int rider1Position , int rider2Position , int rider3Position , int rider4Position) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_POSITIONS);
            preparedStatement.setInt(1 , rider1Position);
            preparedStatement.setInt(2 , rider2Position);
            preparedStatement.setInt(3 , rider3Position);
            preparedStatement.setInt(4 , rider4Position);
            preparedStatement.setInt(5 , eventId);
            preparedStatement.executeUpdate();
            EVENTDAOMYSQLLOGGER.info("Set positions " + rider1Position + " " + rider2Position + " " + rider3Position + " " + rider4Position
                    + " of event " + EventDaoMySql.getInstance().getIventById(eventId));
        } catch (SQLException e) {
            e.printStackTrace();
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
