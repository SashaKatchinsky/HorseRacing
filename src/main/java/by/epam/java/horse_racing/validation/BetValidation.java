package by.epam.java.horse_racing.validation;

import by.epam.java.horse_racing.bean.Event;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

/**
 * The type Bet validation.
 */
public class BetValidation {
    private static class BetValidationHolder {
        private static final BetValidation INSTANCE = new BetValidation();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static BetValidation getInstance() {
        return BetValidationHolder.INSTANCE;
    }

    /**
     * Check if event of bet already played.
     *
     * @param eventOfBet the event of bet
     * @return the boolean
     */
    public boolean isTimeValid(Event eventOfBet) {
        return LocalDateTime.of(eventOfBet.getDate(), eventOfBet.getTime()).compareTo(LocalDateTime.now()) > 0;
    }

    public boolean isRidersValid(int rider1Position , int rider2Position , int rider3Position , int rider4Position , int countOfRiders) {
        Set<Integer> differentRiders = new TreeSet<>();
        if (rider1Position != 0) {
            differentRiders.add(rider1Position);
        }
        if (rider2Position != 0) {
            differentRiders.add(rider2Position);
        }
        if (rider3Position != 0) {
            differentRiders.add(rider3Position);
        }
        if (rider4Position != 0) {
            differentRiders.add(rider4Position);
        }
        return differentRiders.size() == countOfRiders;
    }
}
