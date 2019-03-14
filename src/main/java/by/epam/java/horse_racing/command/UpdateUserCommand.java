package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.bean.Access;
import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.service.UserService;
import by.epam.java.horse_racing.service.exceptions.UpdateUserException;
import by.epam.java.horse_racing.util.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Update user command.
 */
public class UpdateUserCommand extends ActionCommand {
    /**
     * The constant USER.
     */
    private static final String USER = "user";
    /**
     * The constant NAME.
     */
    private static final String NAME = "name";
    /**
     * The constant BALANCE.
     */
    private static final String BALANCE = "balance";
    /**
     * The constant ACCESS.
     */
    private static final String ACCESS = "access";
    /**
     * The constant UPDATEUSERCOMMANDLOGGER.
     */
    private static final Logger UPDATEUSERCOMMANDLOGGER = LogManager.getLogger(UpdateUserCommand.class);

    /**
     * Update user.
     *
     * @see by.epam.java.horse_racing.bean.User
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty(PAGE_MAIN);
        String login = request.getParameter(USER);
        if (login != null) {
            String name = request.getParameter(NAME);
            double balance = Double.parseDouble(request.getParameter(BALANCE));
            Access access = Access.valueOf(request.getParameter(ACCESS));
            try {
                UserService.getInstance().updateUser(login, name, balance, access);
            } catch (UpdateUserException e) {
                UPDATEUSERCOMMANDLOGGER.warn("Can not update user " + login, e);
            }
        }
        return page;
    }
}