package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.service.RiderService;
import by.epam.java.horse_racing.service.exceptions.UpdateRiderException;
import by.epam.java.horse_racing.util.ConfigurationManager;
import by.epam.java.horse_racing.util.XSSAttackSecurity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Update rider command.
 */
public class UpdateRiderCommand extends ActionCommand {
    /**
     * The constant UPDATEDRIDERID.
     */
    private static final String UPDATEDRIDERID = "updatedRiderId";
    /**
     * The constant UPDATEDNAME.
     */
    private static final String UPDATEDNAME = "updatedName";
    /**
     * The constant HORSEID.
     */
    private static final String HORSEID = "horseId";
    /**
     * The constant UPDATERIDERCOMMANDLOGGER.
     */
    private static final Logger UPDATERIDERCOMMANDLOGGER = LogManager.getLogger(UpdateRiderCommand.class);

    /**
     * Update rider.
     *
     * @see by.epam.java.horse_racing.bean.Rider
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty(PAGE_MAIN);
        if (request.getParameter(UPDATEDRIDERID) != null) {
            int updatedRiderId = Integer.parseInt(request.getParameter(UPDATEDRIDERID));
            String name = request.getParameter(UPDATEDNAME);
            name = XSSAttackSecurity.getInstance().secure(name);
            if (name != null && name.length() <= 30) {
                int horseId = Integer.parseInt(request.getParameter(HORSEID));
                try {
                    RiderService.getInstance().updateRider(updatedRiderId, name, horseId);
                } catch (UpdateRiderException e) {
                    UPDATERIDERCOMMANDLOGGER.warn("Can not update rider " + updatedRiderId, e);
                }
            }
        }
        return page;
    }
}
