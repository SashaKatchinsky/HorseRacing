package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Add rider exception.
 */
public class AddRiderException extends ServiceException {

    private static final long serialVersionUID = -6764409315543713598L;

    /**
     * Instantiates a new Add rider exception.
     */
    public AddRiderException() {
        super();
    }

    /**
     * Instantiates a new Add rider exception.
     *
     * @param message the message
     */
    public AddRiderException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Add rider exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public AddRiderException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Add rider exception.
     *
     * @param cause the cause
     */
    public AddRiderException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Add rider exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public AddRiderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
