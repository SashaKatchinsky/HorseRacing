package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Do bet exception.
 */
public class DoBetException extends ServiceException {
    /**
     * Instantiates a new Do bet exception.
     */
    public DoBetException() {
    }

    /**
     * Instantiates a new Do bet exception.
     *
     * @param message the message
     */
    public DoBetException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Do bet exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public DoBetException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Do bet exception.
     *
     * @param cause the cause
     */
    public DoBetException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Do bet exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public DoBetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
