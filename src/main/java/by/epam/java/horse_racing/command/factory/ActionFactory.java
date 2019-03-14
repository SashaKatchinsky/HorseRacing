package by.epam.java.horse_racing.command.factory;

import by.epam.java.horse_racing.command.client.CommandEnum;
import by.epam.java.horse_racing.command.impl.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Action factory.
 */
public class ActionFactory {
    /**
     * Define command action command.
     *
     * @see CommandEnum
     * @param request the request
     * @return the action command
     */
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand currentCommand = null;
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return null;
        } else {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            currentCommand = currentEnum.getCurrentCommand();
            return currentCommand;
        }
    }
}
