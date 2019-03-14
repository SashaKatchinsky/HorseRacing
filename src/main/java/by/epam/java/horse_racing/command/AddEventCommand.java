package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.service.EventService;
import by.epam.java.horse_racing.service.exceptions.AddEventException;
import by.epam.java.horse_racing.util.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The type Add event command.
 */
public class AddEventCommand extends ActionCommand {
    /**
     * The constant NAME.
     */
    private static final String NAME = "name";

    /**
     * The constant DATE.
     */
    private static final String DATE = "date";

    /**
     * The constant TIME.
     */
    private static final String TIME = "time";

    /**
     * The constant RIDER_1.
     */
    private static final String RIDER_1 = "rider1";

    /**
     * The constant RIDER_2.
     */
    private static final String RIDER_2 = "rider2";

    /**
     * The constant RIDER_3.
     */
    private static final String RIDER_3 = "rider3";

    /**
     * The constant RIDER_4.
     */
    private static final String RIDER_4 = "rider4";

    /**
     * The constant ISRANDOMCOEF.
     */
    private static final String ISRANDOMCOEF = "isRandomCoef";

    /**
     * The constant R1_P1.
     */
    private static final String R1_P1 = "1-1";

    /**
     * The constant R1_P2.
     */
    private static final String R1_P2 = "1-2";

    /**
     * The constant R1_P3.
     */
    private static final String R1_P3 = "1-3";

    /**
     * The constant R1_P4.
     */
    private static final String R1_P4 = "1-4";

    /**
     * The constant R2_P1.
     */
    private static final String R2_P1 = "2-1";

    /**
     * The constant R2_P2.
     */
    private static final String R2_P2 = "2-2";

    /**
     * The constant R2_P3.
     */
    private static final String R2_P3 = "2-3";

    /**
     * The constant R2_P4.
     */
    private static final String R2_P4 = "2-4";

    /**
     * The constant R3_P1.
     */
    private static final String R3_P1 = "3-1";

    /**
     * The constant R3_P2.
     */
    private static final String R3_P2 = "3-2";

    /**
     * The constant R3_P3.
     */
    private static final String R3_P3 = "3-3";

    /**
     * The constant R3_P4.
     */
    private static final String R3_P4 = "3-4";

    /**
     * The constant R4_P1.
     */
    private static final String R4_P1 = "4-1";

    /**
     * The constant R4_P2.
     */
    private static final String R4_P2 = "4-2";

    /**
     * The constant R4_P3.
     */
    private static final String R4_P3 = "4-3";

    /**
     * The constant R4_P4.
     */
    private static final String R4_P4 = "4-4";

    /**
     * The constant ADDEVENTCOMMANDLOGGER.
     */
    private static final Logger ADDEVENTCOMMANDLOGGER = LogManager.getLogger(AddEventCommand.class);

    /**
     * Parse the request and add new event.
     * Parse coefficients on this event, if flag is false, otherwise other method generate random coefficients.
     *
     * @see by.epam.java.horse_racing.bean.Event
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty(PAGE_MAIN);
        String name = request.getParameter(NAME);
        LocalDate date = LocalDate.parse(request.getParameter(DATE));
        LocalTime time = LocalTime.parse(request.getParameter(TIME));
        int rider1Id = Integer.parseInt(request.getParameter(RIDER_1));
        int rider2Id = Integer.parseInt(request.getParameter(RIDER_2));
        int rider3Id = Integer.parseInt(request.getParameter(RIDER_3));
        int rider4Id = Integer.parseInt(request.getParameter(RIDER_4));
        String isRandom = request.getParameter(ISRANDOMCOEF);
        if (isRandom != null) {
            try {
                EventService.getInstance().addEventWithCoefGeneration(name , date , time , rider1Id , rider2Id , rider3Id , rider4Id);
            } catch (AddEventException e) {
                ADDEVENTCOMMANDLOGGER.warn("Can not add event " + name  ,e);
            }
        } else {
            double coef1_1 = Double.parseDouble(request.getParameter(R1_P1));
            double coef1_2 = Double.parseDouble(request.getParameter(R1_P2));
            double coef1_3 = Double.parseDouble(request.getParameter(R1_P3));
            double coef1_4 = Double.parseDouble(request.getParameter(R1_P4));
            double coef2_1 = Double.parseDouble(request.getParameter(R2_P1));
            double coef2_2 = Double.parseDouble(request.getParameter(R2_P2));
            double coef2_3 = Double.parseDouble(request.getParameter(R2_P3));
            double coef2_4 = Double.parseDouble(request.getParameter(R2_P4));
            double coef3_1 = Double.parseDouble(request.getParameter(R3_P1));
            double coef3_2 = Double.parseDouble(request.getParameter(R3_P2));
            double coef3_3 = Double.parseDouble(request.getParameter(R3_P3));
            double coef3_4 = Double.parseDouble(request.getParameter(R3_P4));
            double coef4_1 = Double.parseDouble(request.getParameter(R4_P1));
            double coef4_2 = Double.parseDouble(request.getParameter(R4_P2));
            double coef4_3 = Double.parseDouble(request.getParameter(R4_P3));
            double coef4_4 = Double.parseDouble(request.getParameter(R4_P4));
            try {
                EventService.getInstance().addEventWithoutCoefGeneration(name , date , time , rider1Id , rider2Id , rider3Id , rider4Id,
                        coef1_1 , coef1_2 , coef1_3 , coef1_4 , coef2_1  ,coef2_2 , coef2_3 , coef2_4 ,
                        coef3_1 , coef3_2 , coef3_3 , coef3_4 , coef4_1 , coef4_2 , coef4_3 , coef4_4);
            } catch (AddEventException e) {
                ADDEVENTCOMMANDLOGGER.warn("Can not add event " + name  ,e);
            }
        }
        return page;
    }
}
