package by.epam.java.horse_racing.validation;

import by.epam.java.horse_racing.bean.Event;
import by.epam.java.horse_racing.bean.Rider;
import by.epam.java.horse_racing.dao.EventDaoMySql;
import by.epam.java.horse_racing.dao.exceptions.DaoException;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Rider validation.
 */
public class RiderValidation {
    private static class RiderValidationHolder {
        private static final RiderValidation INSTANCE = new RiderValidation();
    }

    private RiderValidation() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static RiderValidation getInstance() {
        return RiderValidationHolder.INSTANCE;
    }

    /**
     * Is valid for delete boolean.
     *
     * @param riderId the rider id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public boolean isValidForDelete(int riderId) throws DaoException {
        List<Rider> ridersOfAllEvents = new ArrayList<>();
        List<Event> events = EventDaoMySql.getInstance().getAllEvents();
        for (Event event : events) {
            ridersOfAllEvents.add(event.getRider1());
            ridersOfAllEvents.add(event.getRider2());
            ridersOfAllEvents.add(event.getRider3());
            ridersOfAllEvents.add(event.getRider4());
        }
        boolean isValidForDelete = true;
        for (Rider rider : ridersOfAllEvents) {
            if (rider.getId() == riderId) {
                isValidForDelete = false;
                break;
            }
        }
        return isValidForDelete;
    }
}
