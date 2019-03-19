package by.epam.java.horse_racing.dao.exceptions;

/**
 * The type Db driver init exception.
 */
public class DBDriverInitException extends DaoException {

    private static final long serialVersionUID = 4258312058206782179L;

    /**
     * Instantiates a new Db driver init exception.
     */
    public DBDriverInitException() {
    }

    /**
     * Instantiates a new Db driver init exception.
     *
     * @param message the message
     */
    public DBDriverInitException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Db driver init exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public DBDriverInitException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Db driver init exception.
     *
     * @param cause the cause
     */
    public DBDriverInitException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Db driver init exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public DBDriverInitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
