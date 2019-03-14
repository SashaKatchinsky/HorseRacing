package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.command.impl.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Sets russian language.
 */
public class SetRussianLanguageCommand extends ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = request.getRequestURI();
        if (!request.getSession().getAttribute("language").equals("ru")) {
            request.getSession().removeAttribute("language");
            request.getSession().setAttribute("language" , "ru");
        }
        return page;
    }
}
