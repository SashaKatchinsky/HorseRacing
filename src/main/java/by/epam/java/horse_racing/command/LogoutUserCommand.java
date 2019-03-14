package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The type Logout user command.
 */
public class LogoutUserCommand extends ActionCommand {

    /**
     * Log out user.
     *
     * @see by.epam.java.horse_racing.bean.User
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty("weburl.page.start");
        HttpSession session = request.getSession();
        session.setAttribute("isAuthorized" , false);
        session.removeAttribute("user");
        return page;
    }
}
