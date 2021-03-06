package by.epam.java.horse_racing.dao.exceptions;

/**
 * The type Close statement exception.
 */
public class CloseStatementException extends DaoException {

    private static final long serialVersionUID = -532563520941911301L;

    /**
     * Instantiates a new Close statement exception.
     */
    public CloseStatementException() {
    }

    /**
     * Instantiates a new Close statement exception.
     *
     * @param message the message
     */
    public CloseStatementException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Close statement exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public CloseStatementException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Close statement exception.
     *
     * @param cause the cause
     */
    public CloseStatementException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Close statement exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public CloseStatementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
