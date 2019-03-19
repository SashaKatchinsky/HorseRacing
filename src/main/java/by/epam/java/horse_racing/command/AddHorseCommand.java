package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.bean.Breed;
import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.service.HorseService;
import by.epam.java.horse_racing.service.exceptions.AddHorseException;
import by.epam.java.horse_racing.util.ConfigurationManager;
import by.epam.java.horse_racing.util.XSSAttackSecurity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Add horse command.
 */
public class AddHorseCommand extends ActionCommand {

    /**
     * The constant NAME.
     */
    private static String NAME = "name";

    /**
     * The constant BREED.
     */
    private static String BREED = "breed";

    /**
     * The constant ADDHORSECOMMANDLOGGER.
     */
    private static Logger ADDHORSECOMMANDLOGGER = LogManager.getLogger(AddHorseCommand.class);

    /**
     * Add horse.
     *
     * @see by.epam.java.horse_racing.bean.Horse
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty(PAGE_MAIN);
        String name = request.getParameter(NAME);
        name = XSSAttackSecurity.getInstance().secure(name);
        if (name != null && name.length() <= 30) {
            Breed breed = Breed.valueOf(request.getParameter(BREED));
            try {
                HorseService.getInstance().addHorse(name, breed);
            } catch (AddHorseException e) {
                ADDHORSECOMMANDLOGGER.warn("Can not add horse " + name, e);
            }
        }
        return page;
    }
}
