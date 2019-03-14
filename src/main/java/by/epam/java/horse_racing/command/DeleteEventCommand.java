package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.service.EventService;
import by.epam.java.horse_racing.service.exceptions.DeleteEventException;
import by.epam.java.horse_racing.util.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Delete event command.
 */
public class DeleteEventCommand extends ActionCommand {
    /**
     * The constant EVENTID.
     */
    private static final String EVENTID = "eventId";
    /**
     * The constant DELETEEVENTCOMMANDLOGGER.
     */
    private static final Logger DELETEEVENTCOMMANDLOGGER = LogManager.getLogger(DeleteEventCommand.class);


    /**
     * Delete event.
     *
     * @see by.epam.java.horse_racing.bean.Event
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty(PAGE_MAIN);
        String strId = request.getParameter(EVENTID);
        if (strId != null) {
            int eventId = Integer.parseInt(strId);
            try {
                EventService.getInstance().deleteEvent(eventId);
            } catch (DeleteEventException e) {
                DELETEEVENTCOMMANDLOGGER.warn("Can not delete event " + eventId, e);
            }
        }
        return page;
    }
}
