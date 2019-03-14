package by.epam.java.horse_racing.dao.exceptions;

/**
 * The type Request failed exception.
 */
public class RequestFailedException extends DaoException {
    /**
     * Instantiates a new Request failed exception.
     */
    public RequestFailedException() {
    }

    /**
     * Instantiates a new Request failed exception.
     *
     * @param message the message
     */
    public RequestFailedException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Request failed exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public RequestFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Request failed exception.
     *
     * @param cause the cause
     */
    public RequestFailedException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Request failed exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public RequestFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
