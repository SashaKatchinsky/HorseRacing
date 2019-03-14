package by.epam.java.horse_racing.command.impl;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Action command.
 */
public abstract class ActionCommand {
    /**
     * The constant PAGE_MAIN.
     */
    protected static final String PAGE_MAIN = "weburl.page.main";
    /**
     * The constant PAGE_START.
     */
    public static final String PAGE_START = "weburl.page.start";

    /**
     * Execute string.
     * Exists some actions depending on need
     *
     * @param request the request
     * @return the string
     */
    public abstract String execute(HttpServletRequest request);
}
