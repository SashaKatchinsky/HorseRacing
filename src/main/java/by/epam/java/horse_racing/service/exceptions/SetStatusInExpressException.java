package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Set status in express exception.
 */
public class SetStatusInExpressException extends ServiceException {

    private static final long serialVersionUID = 2408453486503883926L;

    /**
     * Instantiates a new Set status in express exception.
     */
    public SetStatusInExpressException() {
        super();
    }

    /**
     * Instantiates a new Set status in express exception.
     *
     * @param message the message
     */
    public SetStatusInExpressException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Set status in express exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public SetStatusInExpressException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Set status in express exception.
     *
     * @param cause the cause
     */
    public SetStatusInExpressException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Set status in express exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public SetStatusInExpressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
