package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.bean.User;
import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.service.BetService;
import by.epam.java.horse_racing.service.exceptions.DeleteBetException;
import by.epam.java.horse_racing.service.exceptions.GetExpressBetsException;
import by.epam.java.horse_racing.util.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * The type Delete bet command.
 */
public class DeleteBetCommand extends ActionCommand {
    /**
     * The constant USER.
     */
    private static final String USER = "user";
    /**
     * The constant ID.
     */
    private static final String ID = "id";
    /**
     * The constant DELETEBETCOMMANDLOGGER.
     */
    private static final Logger DELETEBETCOMMANDLOGGER = LogManager.getLogger(DeleteBetCommand.class);


    /**
     * Delete bet
     *
     * @see by.epam.java.horse_racing.bean.Bet
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty(PAGE_MAIN);
        User user = (User)request.getSession().getAttribute(USER);
        String strId = request.getParameter(ID);
        if (strId != null) {
            int id = Integer.parseInt(strId);
            try {
                BetService.getInstance().deleteBet(id, user);
            } catch (DeleteBetException | SQLException | GetExpressBetsException e) {
                DELETEBETCOMMANDLOGGER.warn("Can not delete bet " + id, e);
            }
        }
        return page;
    }
}
