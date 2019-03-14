package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Add horse exception.
 */
public class AddHorseException extends ServiceException {
    /**
     * Instantiates a new Add horse exception.
     */
    public AddHorseException() {
        super();
    }

    /**
     * Instantiates a new Add horse exception.
     *
     * @param message the message
     */
    public AddHorseException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Add horse exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public AddHorseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Add horse exception.
     *
     * @param cause the cause
     */
    public AddHorseException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Add horse exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public AddHorseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
