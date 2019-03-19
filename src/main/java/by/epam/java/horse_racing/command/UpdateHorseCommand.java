package by.epam.java.horse_racing.command;

import by.epam.java.horse_racing.bean.Breed;
import by.epam.java.horse_racing.command.impl.ActionCommand;
import by.epam.java.horse_racing.service.HorseService;
import by.epam.java.horse_racing.service.exceptions.UpdateHorseException;
import by.epam.java.horse_racing.util.ConfigurationManager;
import by.epam.java.horse_racing.util.XSSAttackSecurity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Update horse command.
 */
public class UpdateHorseCommand extends ActionCommand {
    /**
     * The constant ID.
     */
    private static final String ID = "id";
    /**
     * The constant NAME.
     */
    private static final String NAME = "name";
    /**
     * The constant BREED.
     */
    private static final String BREED = "breed";
    /**
     * The constant UPDATEHORSECOMMANDLOGGER.
     */
    private static final Logger UPDATEHORSECOMMANDLOGGER = LogManager.getLogger(UpdateHorseCommand.class);

    /**
     * Updare horse.
     *
     * @see by.epam.java.horse_racing.bean.Horse
     * @param request the request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty(PAGE_MAIN);
        if (request.getParameter(ID) != null) {
            int id = Integer.parseInt(request.getParameter(ID));
            String name = request.getParameter(NAME);
            name = XSSAttackSecurity.getInstance().secure(name);
            if (name != null && name.length() <= 30) {
                Breed breed = Breed.valueOf(request.getParameter(BREED));
                try {
                    HorseService.getInstance().updateHorse(id, name, breed);
                } catch (UpdateHorseException e) {
                    UPDATEHORSECOMMANDLOGGER.warn("Can not update horse " + name, e);
                }
            }
        }
        return page;
    }
}
