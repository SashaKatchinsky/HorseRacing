package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.bean.User;
import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.dao.UserDaoMySql;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.service.UserService;
import by.epam.java.horse_racing.util.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The type Login user command.
 */
public class LoginUserCommand extends ActionCommand {
    /**
     * The constant LOGIN.
     */
    private static final String LOGIN = "loginL";
    /**
     * The constant PASSWORD.
     */
    private static final String PASSWORD = "passwordL";
    /**
     * The constant USER.
     */
    private static final String USER = "user";
    /**
     * The constant ISAUTHORIZED.
     */
    private static final String ISAUTHORIZED = "isAuthorized";
    /**
     * The constant GET_PARAM_ERROR_LOGIN.
     */
    private static final String GET_PARAM_ERROR_LOGIN = "?errorLoginPassMessage=true";
    /**
     * The constant LOGINUSERCOMMANDLOGGER.
     */
    private static final Logger LOGINUSERCOMMANDLOGGER = LogManager.getLogger(LoginUserCommand.class);

    /**
     * Check users's info and log in if it is correct.
     *
     * @see User
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request){
        String page = null;
        String login = request.getParameter(LOGIN);
        char[] password = request.getParameter(PASSWORD).toCharArray();
        try {
            if (UserService.getInstance().checkLoginPassword(login , password)) {
                HttpSession session = request.getSession();
                User user = UserDaoMySql.getInstance().getUserByLogin(login);
                session.setAttribute(USER, user);
                session.setAttribute(ISAUTHORIZED , true);
                page = ConfigurationManager.getInstance().getProperty(PAGE_MAIN);
            } else {
                page = ConfigurationManager.getInstance().getProperty(PAGE_START);
                page += GET_PARAM_ERROR_LOGIN;
            }
        } catch (DaoException e) {
            LOGINUSERCOMMANDLOGGER.warn("Can not login user " + login , e);
        }
        return page;
    }
}
