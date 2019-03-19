package by.epam.java.horse_racing.dao.exceptions;

/**
 * The type Close connection exception.
 */
public class CloseConnectionException extends DaoException{

    private static final long serialVersionUID = -1958425932504846177L;

    /**
     * Instantiates a new Close connection exception.
     */
    public CloseConnectionException() {
        super();
    }

    /**
     * Instantiates a new Close connection exception.
     *
     * @param message the message
     */
    public CloseConnectionException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Close connection exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public CloseConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Close connection exception.
     *
     * @param cause the cause
     */
    public CloseConnectionException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Close connection exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected CloseConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
