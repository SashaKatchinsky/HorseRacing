package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.bean.User;
import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.service.BetService;
import by.epam.java.horse_racing.service.exceptions.DoBetException;
import by.epam.java.horse_racing.util.ConfigurationManager;
import by.epam.java.horse_racing.validation.BetValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Do bet command.
 */
public class DoBetCommand extends ActionCommand {
    /**
     * The constant EVENT.
     */
    private static final String EVENT = "event";
    /**
     * The constant RIDER_1_POSITION.
     */
    private static final String RIDER_1_POSITION = "rider1position";
    /**
     * The constant RIDER_2_POSITION.
     */
    private static final String RIDER_2_POSITION = "rider2position";
    /**
     * The constant RIDER_3_POSITION.
     */
    private static final String RIDER_3_POSITION = "rider3position";
    /**
     * The constant RIDER_4_POSITION.
     */
    private static final String RIDER_4_POSITION = "rider4position";
    /**
     * The constant BETAMOUNT.
     */
    private static final String BETAMOUNT = "betamount";
    /**
     * The constant DOBETCOMMANDLOGGER.
     */
    private static final Logger DOBETCOMMANDLOGGER = LogManager.getLogger(DoBetCommand.class);

    /**
     * Parse request and do bet.
     *
     * @see by.epam.java.horse_racing.bean.Bet
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty(PAGE_MAIN);
        String strId = request.getParameter(EVENT);
        if (strId != null) {
            int eventId = Integer.parseInt(strId);
            int rider1Position = Integer.parseInt(request.getParameter(RIDER_1_POSITION));
            int rider2Position = Integer.parseInt(request.getParameter(RIDER_2_POSITION));
            int rider3Position = Integer.parseInt(request.getParameter(RIDER_3_POSITION));
            int rider4Position = Integer.parseInt(request.getParameter(RIDER_4_POSITION));
            int countOfRiders = 0;
            if (rider1Position != 0) {
                countOfRiders++;
            }
            if (rider2Position != 0) {
                countOfRiders++;
            }
            if (rider3Position != 0) {
                countOfRiders++;
            }
            if (rider4Position != 0) {
                countOfRiders++;
            }
            if (BetValidation.getInstance().isRidersValid(rider1Position, rider2Position, rider3Position, rider4Position , countOfRiders)) {
                double betAmount = Double.parseDouble(request.getParameter(BETAMOUNT));
                List<Integer> betsInfo = new ArrayList<>();
                betsInfo.add(rider1Position);
                betsInfo.add(rider2Position);
                betsInfo.add(rider3Position);
                betsInfo.add(rider4Position);
                try {
                    BetService.getInstance().doBet(eventId, betsInfo, (User) request.getSession().getAttribute("user"), betAmount);
                } catch (DoBetException | SQLException e) {
                    DOBETCOMMANDLOGGER.warn("Can not do bet on event " + eventId, e);
                }
            }
        }
        return page;
    }
}
