package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Update rider exception.
 */
public class UpdateRiderException extends ServiceException {
    /**
     * Instantiates a new Update rider exception.
     */
    public UpdateRiderException() {
        super();
    }

    /**
     * Instantiates a new Update rider exception.
     *
     * @param message the message
     */
    public UpdateRiderException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Update rider exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UpdateRiderException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Update rider exception.
     *
     * @param cause the cause
     */
    public UpdateRiderException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Update rider exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public UpdateRiderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
