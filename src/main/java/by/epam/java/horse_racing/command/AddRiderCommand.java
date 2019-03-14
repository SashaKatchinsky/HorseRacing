package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.service.RiderService;
import by.epam.java.horse_racing.service.exceptions.AddRiderException;
import by.epam.java.horse_racing.util.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Add rider command.
 */
public class AddRiderCommand extends ActionCommand {

    /**
     * The constant NAME.
     */
    private static final String NAME = "name";

    /**
     * The constant HORSEID.
     */
    private static final String HORSEID = "horseId";

    /**
     * The constant ADDRIDERCOMMANDLOGGER.
     */
    private static final Logger ADDRIDERCOMMANDLOGGER = LogManager.getLogger(AddRiderCommand.class);

    /**
     * Add rider
     *
     * @see by.epam.java.horse_racing.bean.Rider
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty(PAGE_MAIN);
        String name = request.getParameter(NAME);
        int horseId = Integer.parseInt(request.getParameter(HORSEID));
        try {
            RiderService.getInstance().addRider(name , horseId);
        } catch (AddRiderException e) {
            ADDRIDERCOMMANDLOGGER.warn("Can not add rider " + name , e);
        }
        return page;
    }
}
