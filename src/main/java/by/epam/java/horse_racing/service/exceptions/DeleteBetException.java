package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Delete bet exception.
 */
public class DeleteBetException extends ServiceException {

    private static final long serialVersionUID = 3334496284903619443L;

    /**
     * Instantiates a new Delete bet exception.
     */
    public DeleteBetException() {
        super();
    }

    /**
     * Instantiates a new Delete bet exception.
     *
     * @param message the message
     */
    public DeleteBetException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Delete bet exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public DeleteBetException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Delete bet exception.
     *
     * @param cause the cause
     */
    public DeleteBetException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Delete bet exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public DeleteBetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
