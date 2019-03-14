package by.epam.java.horse_racing.dao.exceptions;

/**
 * The type Open db prop file exception.
 */
public class OpenDBPropFileException extends DaoException {
    /**
     * Instantiates a new Open db prop file exception.
     */
    public OpenDBPropFileException() {
        super();
    }

    /**
     * Instantiates a new Open db prop file exception.
     *
     * @param message the message
     */
    public OpenDBPropFileException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Open db prop file exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public OpenDBPropFileException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Open db prop file exception.
     *
     * @param cause the cause
     */
    public OpenDBPropFileException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Open db prop file exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected OpenDBPropFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
