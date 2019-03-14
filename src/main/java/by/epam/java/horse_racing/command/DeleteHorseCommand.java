package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.dao.HorseDaoMySql;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.service.RiderService;
import by.epam.java.horse_racing.service.exceptions.SetNewHorsesException;
import by.epam.java.horse_racing.util.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Delete horse command.
 */
public class DeleteHorseCommand extends ActionCommand {
    /**
     * The constant ID.
     */
    private static final String ID = "id";
    /**
     * The constant DELETEHORSECOMMANDLOGGER.
     */
    private static final Logger DELETEHORSECOMMANDLOGGER = LogManager.getLogger(DeleteHorseCommand.class);


    /**
     * Delete horse and set new horses to riders with this horse.
     *
     * @see by.epam.java.horse_racing.bean.Horse
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty(PAGE_MAIN);
        String strId = request.getParameter(ID);
        if (strId != null) {
            int horseId = Integer.parseInt(strId);
            try {
                RiderService.getInstance().setNewHorses(horseId);
                HorseDaoMySql.getInstance().deleteHorse(horseId);
            } catch (SetNewHorsesException | DaoException e) {
                DELETEHORSECOMMANDLOGGER.warn("Can not delete horse " + horseId, e);
            }
        }
        return page;
    }
}
