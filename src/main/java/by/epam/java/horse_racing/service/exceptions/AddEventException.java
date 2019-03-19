package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Add event exception.
 */
public class AddEventException extends ServiceException {

    private static final long serialVersionUID = 6704323176319055799L;

    /**
     * Instantiates a new Add event exception.
     */
    public AddEventException() {
        super();
    }

    /**
     * Instantiates a new Add event exception.
     *
     * @param message the message
     */
    public AddEventException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Add event exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public AddEventException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Add event exception.
     *
     * @param cause the cause
     */
    public AddEventException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Add event exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public AddEventException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
