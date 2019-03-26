package by.epam.java.horse_racing.service;

import by.epam.java.horse_racing.bean.*;
import by.epam.java.horse_racing.dao.BetDaoMySql;
import by.epam.java.horse_racing.dao.EventDaoMySql;
import by.epam.java.horse_racing.dao.connection.ConnectionPool;
import by.epam.java.horse_racing.dao.exceptions.CloseStatementException;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.dao.exceptions.GetConnectionException;
import by.epam.java.horse_racing.service.exceptions.DeleteBetException;
import by.epam.java.horse_racing.service.exceptions.DoBetException;
import by.epam.java.horse_racing.service.exceptions.GetExpressBetsException;
import by.epam.java.horse_racing.service.exceptions.SetStatusInExpressException;
import by.epam.java.horse_racing.service.impl.Service;
import by.epam.java.horse_racing.validation.BetValidation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * The type Bet service.
 */
public class BetService implements Service {
    /**
     * The constant SQL_INSERT_BET.
     */
    private static final String SQL_INSERT_BET = "INSERT INTO Bets(BetID, UserLogin , Coefficient , Money , Date , Time , BetType , BetStatus , IventID) VALUES(? , ? , ? , ? , ? , ? , ? , ? , ?)";
    /**
     * The constant SQL_UPDATE_BALANCE_OF_USER_BY_KEY.
     */
    private static final String SQL_UPDATE_BALANCE_OF_USER_BY_KEY = "UPDATE Users Set Balance=? WHERE Login=?";
    /**
     * The constant SQL_DELETE_BET_BY_KEY.
     */
    private static final String SQL_DELETE_BET_BY_KEY = "DELETE FROM Bets WHERE BetId=?";

    private static class BetServiceHolder {
        private static final BetService INSTANCE = new BetService();
    }

    private BetService() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static BetService getInstance() {
        return BetServiceHolder.INSTANCE;
    }

    /**
     * Generate random unique id in range (0 , 1000).
     * Do transaction with inserting bet into db and takes away money from the user
     *
     * @param iventId   the ivent id
     * @param betsInfo  the bets info
     * @param user      the user
     * @param betAmount the bet amount
     * @throws CloseStatementException the close statement exception
     * @throws SQLException            the sql exception
     * @throws DoBetException          the do bet exception
     */
    public void doBet(int iventId, List<Integer> betsInfo, User user, double betAmount) throws SQLException, DoBetException {
        BetStatus status = BetStatus.NOTPLAYED;
        int betId;
        List<Bet> betsForInsert = new ArrayList<>();
        List<Bet> allBets;
        Event event;
        try {
            allBets = BetDaoMySql.getInstance().getAllBets();
            event = EventDaoMySql.getInstance().getIventById(iventId);
        } catch (DaoException e) {
            throw new DoBetException(e);
        }
        if (BetValidation.getInstance().isTimeValid(event)) {
            for (int i = 0; i < betsInfo.size(); i++) {
                int position = betsInfo.get(i);
                if (position != 0) {
                    int riderNumber = i + 1;
                    List<Object> coefType = getCoefTypeByRiderPosition(event, riderNumber, position);
                    double coefficient = (Double) coefType.get(0);
                    String type = (String) coefType.get(1);
                    while (true) {
                        boolean isIdExists = false;
                        betId = (int) (1000 * Math.random());
                        for (Bet bet : allBets) {
                            if (bet.getId() == betId) {
                                isIdExists = true;
                                break;
                            }
                        }
                        if (!isIdExists) {
                            break;
                        }
                    }
                    betsForInsert.add(new Bet(betId, user, coefficient, betAmount, LocalDate.now(), LocalTime.now(), BetType.valueOf(type), status, event));
                }
            }
            if (betsForInsert.size() != 0) {
                double balance = user.getBalance() - betAmount;
                Connection connection = null;
                PreparedStatement preparedStatement = null;
                try {
                    connection = ConnectionPool.getInstance().retrieve();
                    connection.setAutoCommit(false);
                    for (Bet bet : betsForInsert) {
                        preparedStatement = connection.prepareStatement(SQL_INSERT_BET);
                        preparedStatement.setInt(1, bet.getId());
                        preparedStatement.setString(2, bet.getUser().getLogin());
                        preparedStatement.setDouble(3, bet.getCoefficient());
                        preparedStatement.setDouble(4, bet.getMoney());
                        preparedStatement.setString(5, bet.getDate().toString());
                        preparedStatement.setString(6, bet.getTime().toString());
                        preparedStatement.setString(7, bet.getType().toString());
                        preparedStatement.setString(8, bet.getStatus().toString());
                        preparedStatement.setInt(9, bet.getEvent().getId());
                        preparedStatement.execute();
                    }
                    preparedStatement = connection.prepareStatement(SQL_UPDATE_BALANCE_OF_USER_BY_KEY);
                    preparedStatement.setDouble(1, balance);
                    preparedStatement.setString(2, user.getLogin());
                    preparedStatement.execute();
                    connection.commit();
                    connection.rollback();
                } catch (GetConnectionException e) {
                    throw new DoBetException(e);
                } finally {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.setAutoCommit(true);
                    }
                    if (connection != null) {
                        ConnectionPool.getInstance().putBack(connection);
                    }
                }
            }
        }
    }

    /**
     * Gather together bets with the same date, time, user and sort them by date and time.
     *
     * @param bets the bets
     * @return the list
     */
    public synchronized List<Bet> formBets (List<Bet> bets) {
        List<Bet> formBets = new ArrayList<>();
        List<List<Bet>> sortBets = new ArrayList<>();
        TreeSet<Bet> betSet = new TreeSet<>((o1, o2) -> {
            if (o1.getDate().equals(o2.getDate())) {
                return o2.getTime().compareTo(o1.getTime());
            } else {
                return o2.getDate().compareTo(o1.getDate());
            }
        });
        betSet.addAll(bets);
        for (Bet bet : betSet) {
            List<Bet> list = new ArrayList<>();
            list.add(bet);
            sortBets.add(list);
        }
        formBets.addAll(betSet);
        for (Bet bet : bets) {
            for (int i = 0 ; i < sortBets.size() ; i++) {
                if (bet.getDate().equals(sortBets.get(i).get(0).getDate()) &&
                        bet.getTime().equals(sortBets.get(i).get(0).getTime()) &&
                        bet.getUser().getLogin().equals(sortBets.get(i).get(0).getUser().getLogin()) &&
                        !sortBets.get(i).contains(bet)) {

                    formBets.get(i).getTypeList().add(bet.getType());
                    formBets.get(i).setCoefficient(formBets.get(i).getCoefficient() * bet.getCoefficient());
                }
            }
        }
        for (Bet bet : formBets) {
            bet.setCoefficient((double)Math.round(bet.getCoefficient() * 100d) / 100d);
        }
        return formBets;
    }

    /**
     * Gets played bets.
     *
     * @param bets the bets
     * @return the played bets
     */
    public List<Bet> getPlayedBets(List<Bet> bets) {
        List<Bet> playedBets = new ArrayList<>();
        for (Bet bet : bets) {
            if (bet.getEvent().getDate().equals(LocalDate.now())) {
                if (bet.getEvent().getTime().compareTo(LocalTime.now()) < 0) {
                    playedBets.add(bet);
                }
            } else {
                if (bet.getEvent().getDate().compareTo(LocalDate.now()) < 0) {
                    playedBets.add(bet);
                }
            }
        }
        return playedBets;
    }

    /**
     * Gets coming bets.
     *
     * @param bets the bets
     * @return the coming bets
     */
    public List<Bet> getComingBets(List<Bet> bets) {
        List<Bet> comingBets = new ArrayList<>();
        for (Bet bet : bets) {
            if (bet.getEvent().getDate().equals(LocalDate.now())) {
                if (bet.getEvent().getTime().compareTo(LocalTime.now()) > 0) {
                    comingBets.add(bet);
                }
            } else {
                if (bet.getEvent().getDate().compareTo(LocalDate.now()) > 0) {
                    comingBets.add(bet);
                }
            }
        }
        return comingBets;
    }

    /**
     * Delete all bets in express, it may be only 1 bet.
     *
     * @param betId the bet id
     * @param user  the user
     * @throws DeleteBetException      the delete bet exception
     * @throws SQLException            the sql exception
     * @throws GetExpressBetsException the get express bets exception
     */
    public void deleteBet(int betId , User user) throws DeleteBetException, SQLException, GetExpressBetsException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Bet> expressBets = null;
        double balance;
        try {
            expressBets = getExpressBets(betId);
            balance = user.getBalance() + expressBets.get(0).getMoney();
            connection = ConnectionPool.getInstance().retrieve();
            connection.setAutoCommit(false);
            for (Bet bet : expressBets) {
                preparedStatement = connection.prepareStatement(SQL_DELETE_BET_BY_KEY);
                preparedStatement.setInt(1 , bet.getId());
                preparedStatement.executeUpdate();
            }
            preparedStatement = connection.prepareStatement(SQL_UPDATE_BALANCE_OF_USER_BY_KEY);
            preparedStatement.setDouble(1 , balance);
            preparedStatement.setString(2 , user.getLogin());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw new DeleteBetException(e);
        } catch (DaoException e) {
            throw new DeleteBetException(e);
        } finally {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.setAutoCommit(true);
                }
            if (connection != null) {
                ConnectionPool.getInstance().putBack(connection);
            }
        }
    }

    /**
     * Sets status in express.
     *
     * @param status the status
     * @param bet    the bet
     * @throws SetStatusInExpressException the set status in express exception
     * @throws GetExpressBetsException     the get express bets exception
     */
    public void setStatusInExpress(BetStatus status , Bet bet) throws SetStatusInExpressException, GetExpressBetsException {
        try {
            List<Bet> expressBets = getExpressBets(bet.getId());

            for (Bet bet1 : expressBets) {
                BetDaoMySql.getInstance().setBetStatus(bet.getId(), status);
            }
        } catch (DaoException e) {
            throw new SetStatusInExpressException(e);
        }
    }

    /**
     * Gets list of bets, that in express with bet with current id.
     *
     * @param betId the bet id
     * @return the express bets
     * @throws GetExpressBetsException the get express bets exception
     */
    public List<Bet> getExpressBets(int betId) throws GetExpressBetsException {
        List<Bet> expressBets = null;
        try {
            Bet bet = BetDaoMySql.getInstance().getBetById(betId);
            LocalDate date = bet.getDate();
            LocalTime time = bet.getTime();
            User user = bet.getUser();
            List<Bet> allBets = BetDaoMySql.getInstance().getAllBets();
            expressBets = new ArrayList<>();
            for (Bet bet1 : allBets) {
                if (bet1.getUser().equals(user) && bet1.getTime().equals(time)
                        && bet1.getDate().equals(date)) {
                    expressBets.add(bet1);
                }
            }
        } catch (DaoException e) {
            throw new GetExpressBetsException(e);
        }
        return expressBets;
    }

    /**
     * Gets coefficient and type of bet by rider and his position.
     *
     * @param event         the event
     * @param riderNumber   the rider number
     * @param riderPosition the rider position
     * @return the coef type by rider position
     */
    public List<Object> getCoefTypeByRiderPosition (Event event, int riderNumber , int riderPosition) {
        double coefficient = 0;
        String type = null;
        switch (riderNumber) {
            case (1) : {
                switch (riderPosition) {
                    case (1) : {
                        coefficient = event.getRider1Position1Coefficient();
                        type = "FIRST_RIDER_1_PLACE";
                        break;
                    }
                    case (2) : {
                        coefficient = event.getRider1Position2Coefficient();
                        type = "FIRST_RIDER_2_PLACE";
                        break;
                    }
                    case (3) : {
                        coefficient = event.getRider1Position3Coefficient();
                        type = "FIRST_RIDER_3_PLACE";
                        break;
                    }
                    case (4) : {
                        coefficient = event.getRider1Position4Coefficient();
                        type = "FIRST_RIDER_4_PLACE";
                        break;
                    }
                }
                break;
            }
            case (2) : {
                switch (riderPosition) {
                    case (1) : {
                        coefficient = event.getRider2Position1Coefficient();
                        type = "SECOND_RIDER_1_PLACE";
                        break;
                    }
                    case (2) : {
                        coefficient = event.getRider2Position2Coefficient();
                        type = "SECOND_RIDER_2_PLACE";
                        break;
                    }
                    case (3) : {
                        coefficient = event.getRider2Position3Coefficient();
                        type = "SECOND_RIDER_3_PLACE";
                        break;
                    }
                    case (4) : {
                        coefficient = event.getRider2Position4Coefficient();
                        type = "SECOND_RIDER_4_PLACE";
                        break;
                    }
                }
                break;
            }
            case (3) : {
                switch (riderPosition) {
                    case (1) : {
                        coefficient = event.getRider3Position1Coefficient();
                        type = "THIRD_RIDER_1_PLACE";
                        break;
                    }
                    case (2) : {
                        coefficient = event.getRider3Position2Coefficient();
                        type = "THIRD_RIDER_2_PLACE";
                        break;
                    }
                    case (3) : {
                        coefficient = event.getRider3Position3Coefficient();
                        type = "THIRD_RIDER_3_PLACE";
                        break;
                    }
                    case (4) : {
                        coefficient = event.getRider3Position4Coefficient();
                        type = "THIRD_RIDER_4_PLACE";
                        break;
                    }
                }
                break;
            }
            case (4) : {
                switch (riderPosition) {
                    case (1) : {
                        coefficient = event.getRider4Position1Coefficient();
                        type = "FOURTH_RIDER_1_PLACE";
                        break;
                    }
                    case (2) : {
                        coefficient = event.getRider4Position2Coefficient();
                        type = "FOURTH_RIDER_2_PLACE";
                        break;
                    }
                    case (3) : {
                        coefficient = event.getRider4Position3Coefficient();
                        type = "FOURTH_RIDER_3_PLACE";
                        break;
                    }
                    case (4) : {
                        coefficient = event.getRider4Position4Coefficient();
                        type = "FOURTH_RIDER_4_PLACE";
                        break;
                    }
                }
            }
        }
        List coefType = new ArrayList();
        coefType.add(coefficient);
        coefType.add(type);
        return coefType;
    }
}
