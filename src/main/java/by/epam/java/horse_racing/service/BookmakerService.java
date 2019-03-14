package by.epam.java.horse_racing.service;

import by.epam.java.horse_racing.bean.Bet;
import by.epam.java.horse_racing.bean.BetStatus;
import by.epam.java.horse_racing.bean.BetType;
import by.epam.java.horse_racing.bean.Event;
import by.epam.java.horse_racing.dao.BetDaoMySql;
import by.epam.java.horse_racing.dao.EventDaoMySql;
import by.epam.java.horse_racing.dao.HorseDaoMySql;
import by.epam.java.horse_racing.dao.UserDaoMySql;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.service.exceptions.GetExpressBetsException;
import by.epam.java.horse_racing.service.exceptions.GetNearestEventException;
import by.epam.java.horse_racing.service.exceptions.SetStatusInExpressException;
import by.epam.java.horse_racing.service.impl.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The type Bookmaker service.
 */
public class BookmakerService extends Thread implements Service {
    /**
     * The constant FIRST.
     */
    private static final String FIRST = "FIRST_RIDER_";
    /**
     * The constant SECOND.
     */
    private static final String SECOND = "SECOND_RIDER_";
    /**
     * The constant THIRD.
     */
    private static final String THIRD = "THIRD_RIDER_";
    /**
     * The constant FOURTH.
     */
    private static final String FOURTH = "FOURTH_RIDER_";
    /**
     * The constant PLACE.
     */
    private static final String PLACE = "_PLACE";
    /**
     * The constant BOOKMAKERSERVICELOGGER.
     */
    private static final Logger BOOKMAKERSERVICELOGGER = LogManager.getLogger(HorseDaoMySql.class.getName());;
    /**
     * The New event inserted. Set true, when new event has inserted to check this event if it can be next playing event.
     */
    private boolean newEventInserted;

    /**
     * The type Bookmaker service holder.
     */
    private static class BookmakerServiceHolder {
        private static final BookmakerService INSTANCE = new BookmakerService();
    }

    private BookmakerService() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static BookmakerService getInstance() {
        return BookmakerServiceHolder.INSTANCE;
    }

    /**
     * Is new event inserted boolean.
     *
     * @return the boolean
     */
    public boolean isNewEventInserted() {
        return newEventInserted;
    }

    /**
     * Sets new event inserted.
     *
     * @param newEventInserted the new event inserted
     */
    public void setNewEventInserted(boolean newEventInserted) {
        this.newEventInserted = newEventInserted;
    }

    /**
     * Infinity cycle get next playing event, if it exists, otherwise sleep on 10 sec.
     * If next event not null, it wait for its time, and in the same time check for new event.
     * When date and time of next event less than now, it random positions of riders of this event and check every bet on this event for win/loose.
     */
    @Override
    public void run() {
        Event event = null;
        boolean isNeedNewIvent = true;
        while (true) {
            try {
                if (isNeedNewIvent || newEventInserted) {
                    event = EventService.getInstance().getNearestEvent();
                    newEventInserted = false;
                }
                if (event == null) {
                    TimeUnit.SECONDS.sleep(10);
                    isNeedNewIvent = true;
                } else {
                    if (LocalDateTime.of(event.getDate() , event.getTime()).compareTo(LocalDateTime.now()) <= 0) {
                        List<Integer> randomResult = getRandomList(4);
                        EventDaoMySql.getInstance().setPositionsOnEvent(event.getId() , randomResult.get(0), randomResult.get(1),
                                randomResult.get(2), randomResult.get(3));
                        checkResults(event, randomResult);
                        isNeedNewIvent = true;
                    } else {
                        TimeUnit.SECONDS.sleep(5);
                        isNeedNewIvent = false;
                    }
                }
            } catch (DaoException | SetStatusInExpressException | InterruptedException | GetExpressBetsException | GetNearestEventException e) {
                BOOKMAKERSERVICELOGGER.fatal("Bookmaker service can not function" , e);
            }
        }
    }

    /**
     * Gets random list with 4 different numbers for random positions of riders.
     *
     * @param size the size
     * @return the random list
     */
    public List<Integer> getRandomList(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < size ; i++) {
            result.add(i + 1);
        }
        Collections.shuffle(result);
        return result;
    }

    /**
     * Check results.
     * Form list of BetType in depends of results.
     * If bet is express, it win then and only then, when bet type in this express the same, otherwise loose.
     * One bet win then and only then, when bet type of this bet the same, otherwise loose
     *
     * @param event   the event
     * @param results the results
     * @throws DaoException                the dao exception
     * @throws SetStatusInExpressException the set status in express exception
     * @throws GetExpressBetsException     the get express bets exception
     */
    public synchronized void checkResults(Event event, List<Integer> results) throws DaoException, SetStatusInExpressException, GetExpressBetsException {
        List<Bet> bets = BetDaoMySql.getInstance().getBetsWithCurrentIvent(event.getId());
        List<Bet> formBets = BetService.getInstance().formBets(bets);
        List<BetType> enumResults = new ArrayList<>();
        for (int i = 0 ; i < results.size() ; i++) {
            StringBuffer result = new StringBuffer();
            if (i == 0) {
                result.append(FIRST);
                result.append(results.get(i));
            }
            if (i == 1) {
                result.append(SECOND);
                result.append(results.get(i));
            }
            if (i == 2) {
                result.append(THIRD);
                result.append(results.get(i));
            }
            if (i == 3) {
                result.append(FOURTH);
                result.append(results.get(i));
            }
            result.append(PLACE);
            enumResults.add(BetType.valueOf(result.toString()));
        }
        for (Bet bet : formBets) {
            List<BetType> betTypeList = bet.getTypeList();
            int count = 0;
            for (BetType betType : betTypeList) {
                if (enumResults.contains(betType)) {
                    count++;
                }
            }
            if (count == betTypeList.size()) {
                BetService.getInstance().setStatusInExpress(BetStatus.WIN , bet);
                double wonMoney = (double)Math.round(bet.getCoefficient() * bet.getMoney() * 100d) / 100d;
                UserDaoMySql.getInstance().changeBalance(bet.getUser().getLogin() , bet.getUser().getBalance() + wonMoney);
            } else {
                BetService.getInstance().setStatusInExpress(BetStatus.LOSS , bet);
            }
        }
    }
}
