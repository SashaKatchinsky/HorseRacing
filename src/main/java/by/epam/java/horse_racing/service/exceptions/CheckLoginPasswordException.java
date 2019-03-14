package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Check login password exception.
 */
public class CheckLoginPasswordException extends ServiceException {
    /**
     * Instantiates a new Check login password exception.
     */
    public CheckLoginPasswordException() {
        super();
    }

    /**
     * Instantiates a new Check login password exception.
     *
     * @param message the message
     */
    public CheckLoginPasswordException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Check login password exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public CheckLoginPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Check login password exception.
     *
     * @param cause the cause
     */
    public CheckLoginPasswordException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Check login password exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public CheckLoginPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
