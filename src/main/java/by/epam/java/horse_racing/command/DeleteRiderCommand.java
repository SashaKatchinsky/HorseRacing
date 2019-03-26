package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.dao.RiderDaoMySql;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.util.ConfigurationManager;
import by.epam.java.horse_racing.validation.RiderValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Delete rider command.
 */
public class DeleteRiderCommand extends ActionCommand {
    /**
     * The constant DELETERIDERID.
     */
    private static final String DELETERIDERID = "deletedRiderId";
    /**
     * The constant DELETERIDERCOMMANDLOGGER.
     */
    private static final Logger DELETERIDERCOMMANDLOGGER = LogManager.getLogger(DeleteRiderCommand.class);


    /**
     * Delete rider.
     *
     * @see by.epam.java.horse_racing.bean.Rider
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty(PAGE_MAIN);
        String strId = request.getParameter(DELETERIDERID);
        if (strId != null) {
            int deletedRiderId = Integer.parseInt(strId);
            try {
                if (RiderValidation.getInstance().isValidForDelete(deletedRiderId)) {
                    RiderDaoMySql.getInstance().deleteRider(deletedRiderId);
                }
            } catch (DaoException e) {
                DELETERIDERCOMMANDLOGGER.warn("Can not delete rider " + deletedRiderId, e);
            }
        }
        return page;
    }
}
