package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Set new horses exception.
 */
public class SetNewHorsesException extends ServiceException {

    private static final long serialVersionUID = -4293504655305781906L;

    /**
     * Instantiates a new Set new horses exception.
     */
    public SetNewHorsesException() {
        super();
    }

    /**
     * Instantiates a new Set new horses exception.
     *
     * @param message the message
     */
    public SetNewHorsesException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Set new horses exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public SetNewHorsesException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Set new horses exception.
     *
     * @param cause the cause
     */
    public SetNewHorsesException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Set new horses exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public SetNewHorsesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
