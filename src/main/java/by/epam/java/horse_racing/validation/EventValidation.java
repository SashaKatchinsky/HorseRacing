package by.epam.java.horse_racing.validation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.TreeSet;

/**
 * The type Event validation.
 */
public class EventValidation {
    private static class EventValidationHolder {
        private static final EventValidation INSTANCE = new EventValidation();
    }

    private EventValidation() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static EventValidation getInstance() {
        return EventValidationHolder.INSTANCE;
    }

    /**
     * Is time valid boolean.
     *
     * @param date the date
     * @param time the time
     * @return the boolean
     */
    public boolean isTimeValid(LocalDate date , LocalTime time) {
        return LocalDateTime.of(date , time).compareTo(LocalDateTime.now()) > 0;
    }

    /**
     * Is riders of event valid boolean.
     *
     * @param rider1Id the rider 1 id
     * @param rider2Id the rider 2 id
     * @param rider3Id the rider 3 id
     * @param rider4Id the rider 4 id
     * @return the boolean
     */
    public boolean isRidersValid(int rider1Id , int rider2Id , int rider3Id , int rider4Id) {
        Set<Integer> differentRiders = new TreeSet<>();
        differentRiders.add(rider1Id);
        differentRiders.add(rider2Id);
        differentRiders.add(rider3Id);
        differentRiders.add(rider4Id);
        return differentRiders.size() == 4;
    }
}
