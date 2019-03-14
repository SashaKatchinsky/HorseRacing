package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.bean.Access;
import by.epam.java.horse_racing.bean.User;
import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.dao.UserDaoMySql;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.util.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

/**
 * The type Register user command.
 */
public class RegisterUserCommand extends ActionCommand {
    /**
     * The constant LOGIN.
     */
    private static final String LOGIN = "loginR";
    /**
     * The constant NAME.
     */
    private static final String NAME = "name";
    /**
     * The constant PASSWORD.
     */
    private static final String PASSWORD = "passwordR";
    /**
     * The constant GET_PARAM_REG_ERROR.
     */
    private static final String GET_PARAM_REG_ERROR = "?registrationError=true";
    /**
     * The constant GET_PARAM_SUCCESS_REG.
     */
    private static final String GET_PARAM_SUCCESS_REG = "?successRegistration=true";
    /**
     * The constant REGISTERUSERCOMMANDLOGGER.
     */
    private static final Logger REGISTERUSERCOMMANDLOGGER = LogManager.getLogger(RegisterUserCommand.class);

    /**
     * Hash password and register user.
     *
     * @see by.epam.java.horse_racing.action.PasswordHasher#hash(char[])
     * @see User
     * @param request the request
     * @return
     */
    @Override
    public String execute(HttpServletRequest request)  {
        String page;
        String login = request.getParameter(LOGIN);
        String name = request.getParameter(NAME);
        char[] password = request.getParameter(PASSWORD).toCharArray();
        page = ConfigurationManager.getInstance().getProperty(PAGE_START);
        try {
            boolean isExists = UserDaoMySql.getInstance().isExists(login);
            if (isExists) {
                page += GET_PARAM_REG_ERROR;
            } else {
                UserDaoMySql.getInstance().insertUser(new User(login, password, name, 10, LocalDate.now(), Access.USER));
                page += GET_PARAM_SUCCESS_REG;
            }
        } catch (DaoException e) {
            REGISTERUSERCOMMANDLOGGER.warn("Can not register user " + login , e);
        }
        return page;
    }
}
