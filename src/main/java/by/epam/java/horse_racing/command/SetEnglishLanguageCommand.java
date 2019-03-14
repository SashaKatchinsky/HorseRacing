package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.command.impl.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Sets english language.
 */
public class SetEnglishLanguageCommand extends ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = request.getRequestURI();
        if (!request.getSession().getAttribute("language").equals("en")) {
            request.getSession().removeAttribute("language");
            request.getSession().setAttribute("language" , "en");
        }
        return page;
    }
}
