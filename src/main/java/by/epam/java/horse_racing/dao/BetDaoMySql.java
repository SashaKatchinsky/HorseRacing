package by.epam.java.horse_racing.dao;

import by.epam.java.horse_racing.bean.Bet;
import by.epam.java.horse_racing.bean.BetStatus;
import by.epam.java.horse_racing.bean.BetType;
import by.epam.java.horse_racing.dao.connection.ConnectionPool;
import by.epam.java.horse_racing.dao.exceptions.CloseStatementException;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.dao.exceptions.RequestFailedException;
import by.epam.java.horse_racing.dao.impl.BetDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Bet dao my sql.
 */
public class BetDaoMySql implements BetDao {
    private static class BetDaoMySqlHolder {
        /**
         * The constant INSTANCE.
         */
        private static final BetDaoMySql INSTANCE = new BetDaoMySql();
    }

    /**
     * The constant SQL_SELECT_ALL_BETS.
     */
    private static final String SQL_SELECT_ALL_BETS = "SELECT BetID, UserLogin , Coefficient , Money , Date , Time , BetType , BetStatus , IventID FROM Bets";

    /**
     * The constant SQL_SELECT_ALL_USERS_BETS.
     */
    private static final String SQL_SELECT_ALL_USERS_BETS = "SELECT BetID, UserLogin , Coefficient , Money , Date , Time , BetType , BetStatus , IventID FROM Bets WHERE UserLogin=?";

    /**
     * The constant SQL_SELECT_BET_BY_KEY.
     */
    private static final String SQL_SELECT_BET_BY_KEY = "SELECT BetID , UserLogin , Coefficient , Money , Date , Time , BetType , BetStatus , IventID FROM Bets WHERE BetID=?";

    /**
     * The constant SQL_DELETE_BET_BY_KEY.
     */
    private static final String SQL_DELETE_BET_BY_KEY = "DELETE FROM Bets WHERE BetID=?";

    /**
     * The constant SQL_INSERT_BET.
     */
    private static final String SQL_INSERT_BET = "INSERT INTO Bets(BetID, UserLogin , Coefficient , Money , Date , Time , BetType , BetStatus , IventID) VALUES(? , ? , ? , ? , ? , ? , ? , ? , ?)";

    /**
     * The constant SQL_UPDATE_BET_BY_KEY.
     */
    private static final String SQL_UPDATE_BET_BY_KEY = "UPDATE Bets SET BetID=? , UserLogin=? , Coefficient=? , Money=? , Date=? , Time=? , BetType=? , BetStatus=? , IventID=? WHERE BetID=?";

    /**
     * The constant SQL_DELETE_ALL_USERS_BETS.
     */
    private static final String SQL_DELETE_ALL_USERS_BETS = "DELETE FROM Bets WHERE UserLogin=?";

    /**
     * The constant SQL_GET_BETS_WITH_CURRENT_IVENT.
     */
    private static final String SQL_GET_BETS_WITH_CURRENT_IVENT = "SELECT BetId , UserLogin , Coefficient , Money , Date , Time , BetType  ,BetStatus , IventID FROM Bets WHERE IventID=?";

    /**
     * The constant SQL_SET_STATUS.
     */
    private static final String SQL_SET_STATUS = "UPDATE Bets Set BetStatus=? WHERE BetID=?";

    /**
     * The constant BETDAOMYSQLLOGGER.
     */
    private static final Logger BETDAOMYSQLLOGGER = LogManager.getLogger(BetDaoMySql.class.getName());

    private BetDaoMySql() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static BetDaoMySql getInstance() {
        return BetDaoMySqlHolder.INSTANCE;
    }

    /**
     *
     * @return list of all Bets
     * @throws DaoException
     */
    @Override
    public List<Bet> getAllBets() throws DaoException {
        List<Bet> bets = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        connection = ConnectionPool.getInstance().retrieve();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_BETS);
            while (resultSet.next()) {
                Bet bet = new Bet();
                bet.setId(resultSet.getInt("BetID"));
                bet.setUser(UserDaoMySql.getInstance().getUserByLogin(resultSet.getString("UserLogin")));
                bet.setCoefficient(resultSet.getDouble("Coefficient"));
                bet.setMoney(resultSet.getDouble("Money"));
                bet.setDate(LocalDate.parse(resultSet.getString("Date")));
                bet.setTime(LocalTime.parse(resultSet.getString("Time")));
                bet.setType(BetType.valueOf(resultSet.getString("BetType")));
                bet.setStatus(BetStatus.valueOf(resultSet.getString("BetStatus")));
                bet.setEvent(EventDaoMySql.getInstance().getIventById(resultSet.getInt("IventID")));
                bets.add(bet);
            }
            BETDAOMYSQLLOGGER.info("All bets got.");
        } catch (SQLException e) {
            throw new CloseStatementException(e);
        } finally {
            closeStatement(statement);
            ConnectionPool.getInstance().putBack(connection);
        }
        return bets;
    }

    /**
     *
     * @param userLogin
     * @return list of all user's bets
     * @throws DaoException
     */
    @Override
    public List<Bet> getAllUsersBets(String userLogin) throws DaoException {
        List<Bet> bets = new ArrayList<>();
        Connection connection;
        PreparedStatement preparedStatement = null;
        connection = ConnectionPool.getInstance().retrieve();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_USERS_BETS);
            preparedStatement.setString(1 , userLogin);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bet bet = new Bet();
                bet.setId(resultSet.getInt("BetID"));
                bet.setUser(UserDaoMySql.getInstance().getUserByLogin(resultSet.getString("UserLogin")));
                bet.setCoefficient(resultSet.getDouble("Coefficient"));
                bet.setMoney(resultSet.getDouble("Money"));
                bet.setDate(LocalDate.parse(resultSet.getString("Date")));
                bet.setTime(LocalTime.parse(resultSet.getString("Time")));
                bet.setType(BetType.valueOf(resultSet.getString("BetType")));
                bet.setStatus(BetStatus.valueOf(resultSet.getString("BetStatus")));
                bet.setEvent(EventDaoMySql.getInstance().getIventById(resultSet.getInt("IventID")));
                bets.add(bet);
            }
            BETDAOMYSQLLOGGER.info("All bets of user " + userLogin + " got.");
        } catch (SQLException e) {
            throw new CloseStatementException(e);
        } finally {
            closeStatement(preparedStatement);
            ConnectionPool.getInstance().putBack(connection);
        }
        return bets;
    }

    /**
     *
     * @param betId
     * @return bet with current id
     * @throws DaoException
     */
    @Override
    public Bet getBetById(int betId) throws DaoException {
        Bet bet = new Bet();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_SELECT_BET_BY_KEY);
            preparedStatement.setInt(1 , betId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            bet.setId(resultSet.getInt("BetID"));
            bet.setUser(UserDaoMySql.getInstance().getUserByLogin(resultSet.getString("UserLogin")));
            bet.setCoefficient(resultSet.getDouble("Coefficient"));
            bet.setMoney(resultSet.getDouble("Money"));
            bet.setDate(LocalDate.parse(resultSet.getString("Date")));
            bet.setTime(LocalTime.parse(resultSet.getString("Time")));
            bet.setType(BetType.valueOf(resultSet.getString("BetType")));
            bet.setStatus(BetStatus.valueOf(resultSet.getString("BetStatus")));
            bet.setEvent(EventDaoMySql.getInstance().getIventById(resultSet.getInt("IventID")));
            BETDAOMYSQLLOGGER.info("Bet " + bet + " got.");
        } catch (SQLException e) {
            throw new CloseStatementException(e);
        } finally {
            closeStatement(preparedStatement);
            ConnectionPool.getInstance().putBack(connection);
        }
        return bet;
    }

    /**
     * Delete bet by id.
     *
     * @param betId
     * @throws DaoException
     */
    @Override
    public void deleteBet(int betId) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_DELETE_BET_BY_KEY);
            preparedStatement.setInt(1 , betId);
            BETDAOMYSQLLOGGER.info("Bet " + betId + " deleted.");
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(preparedStatement);
            ConnectionPool.getInstance().putBack(connection);
        }
    }

    /**
     * Insert bet.
     *
     * @param bet the bet
     * @throws DaoException
     */
    @Override
    public void insertBet(Bet bet) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_INSERT_BET);
            preparedStatement.setInt(1 , bet.getId());
            preparedStatement.setString(2 , bet.getUser().getLogin());
            preparedStatement.setDouble(3 , bet.getCoefficient());
            preparedStatement.setDouble(4 , bet.getMoney());
            preparedStatement.setString(5 ,bet.getDate().toString());
            preparedStatement.setString(6 , bet.getTime().toString());
            preparedStatement.setString(7 , bet.getType().toString());
            preparedStatement.setString(8 , bet.getStatus().toString());
            preparedStatement.setInt(9 , bet.getEvent().getId());
            preparedStatement.execute();
            BETDAOMYSQLLOGGER.info("Bet " + bet + " inserted");
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(preparedStatement);
            ConnectionPool.getInstance().putBack(connection);
        }
    }

    /**
     * Update bet.
     *
     * @param replaceableId the replaceable id
     * @param replacement   the replacement
     * @throws DaoException
     */
    @Override
    public void updateBet(int replaceableId, Bet replacement) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_BET_BY_KEY);
            preparedStatement.setInt(1 , replacement.getId());
            preparedStatement.setString(2 , replacement.getUser().getLogin());
            preparedStatement.setDouble(3 , replacement.getCoefficient());
            preparedStatement.setDouble(4 , replacement.getMoney());
            preparedStatement.setString(5 ,replacement.getDate().toString());
            preparedStatement.setString(6 , replacement.getTime().toString());
            preparedStatement.setString(7 , replacement.getType().toString());
            preparedStatement.setString(8 , replacement.getStatus().toString());
            preparedStatement.setInt(9 , replacement.getEvent().getId());
            BETDAOMYSQLLOGGER.info("Bet " + replaceableId + " updated to " + replacement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(preparedStatement);
            ConnectionPool.getInstance().putBack(connection);
        }
    }

    /**
     * Delete all user's bets.
     *
     * @param userLogin the user login
     * @throws DaoException
     */
    @Override
    public void deleteAllUsersBets(String userLogin) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_DELETE_ALL_USERS_BETS);
            preparedStatement.setString(1 , userLogin);
            preparedStatement.executeUpdate();
            BETDAOMYSQLLOGGER.info("All bets of user " + userLogin + " deleted");
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(preparedStatement);
            ConnectionPool.getInstance().putBack(connection);
        }
    }

    /**
     *
     * @param eventId
     * @return list of bets of current event.
     * @throws DaoException
     */
    @Override
    public synchronized List<Bet> getBetsWithCurrentIvent(int eventId) throws DaoException {
        List<Bet> bets = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_GET_BETS_WITH_CURRENT_IVENT);
            preparedStatement.setInt(1 , eventId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bet bet = new Bet();
                bet.setId(resultSet.getInt("BetID"));
                bet.setUser(UserDaoMySql.getInstance().getUserByLogin(resultSet.getString("UserLogin")));
                bet.setCoefficient(resultSet.getDouble("Coefficient"));
                bet.setMoney(resultSet.getDouble("Money"));
                bet.setDate(LocalDate.parse(resultSet.getString("Date")));
                bet.setTime(LocalTime.parse(resultSet.getString("Time")));
                bet.setType(BetType.valueOf(resultSet.getString("BetType")));
                bet.setStatus(BetStatus.valueOf(resultSet.getString("BetStatus")));
                bet.setEvent(EventDaoMySql.getInstance().getIventById(eventId));
                bets.add(bet);
                BETDAOMYSQLLOGGER.info("Bets of event " + eventId + " got");
            }
        } catch (SQLException e) {
            throw new RequestFailedException(e);
        } finally {
            closeStatement(preparedStatement);
            ConnectionPool.getInstance().putBack(connection);
        }
        return bets;
    }

    /**
     * Set bet status of bet with current id.
     *
     * @param betId  the bet id
     * @param status the status
     * @throws DaoException
     */
    @Override
    public void setBetStatus(int betId , BetStatus status) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            preparedStatement = connection.prepareStatement(SQL_SET_STATUS);
            preparedStatement.setString(1 , status.toString());
            preparedStatement.setInt(2 , betId);
            BETDAOMYSQLLOGGER.info("Status of bet " + betId + " set " + status);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(preparedStatement);
            ConnectionPool.getInstance().putBack(connection);
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
