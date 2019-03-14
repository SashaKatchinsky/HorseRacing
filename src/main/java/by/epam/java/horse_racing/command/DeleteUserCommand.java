package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.dao.BetDaoMySql;
import by.epam.java.horse_racing.dao.UserDaoMySql;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.util.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Delete user command.
 */
public class DeleteUserCommand extends ActionCommand {
    /**
     * The constant USER.
     */
    private static final String USER = "user";
    /**
     * The constant DELETEUSERCOMMANDLOGGER.
     */
    private static final Logger DELETEUSERCOMMANDLOGGER = LogManager.getLogger(DeleteUserCommand.class);


    /**
     * Delete user and all his bets.
     *
     * @see by.epam.java.horse_racing.bean.User
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty(PAGE_MAIN);
        String userLogin = request.getParameter(USER);
        try {
            UserDaoMySql.getInstance().deleteUser(userLogin);
            BetDaoMySql.getInstance().deleteAllUsersBets(userLogin);
        } catch (DaoException e) {
            DELETEUSERCOMMANDLOGGER.warn("Can not delete user " + userLogin , e);
        }
        return page;
    }
}
