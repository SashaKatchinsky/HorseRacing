package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Update user exception.
 */
public class UpdateUserException extends ServiceException {
    /**
     * Instantiates a new Update user exception.
     */
    public UpdateUserException() {
        super();
    }

    /**
     * Instantiates a new Update user exception.
     *
     * @param message the message
     */
    public UpdateUserException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Update user exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UpdateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Update user exception.
     *
     * @param cause the cause
     */
    public UpdateUserException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Update user exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public UpdateUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
