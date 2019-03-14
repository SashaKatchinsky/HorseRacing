package by.epam.java.horse_racing.dao.exceptions;

/**
 * The type Get connection exception.
 */
public class GetConnectionException extends DaoException {
    /**
     * Instantiates a new Get connection exception.
     */
    public GetConnectionException() {
    }

    /**
     * Instantiates a new Get connection exception.
     *
     * @param message the message
     */
    public GetConnectionException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Get connection exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public GetConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Get connection exception.
     *
     * @param cause the cause
     */
    public GetConnectionException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Get connection exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public GetConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}