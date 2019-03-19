package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Update event exception.
 */
public class UpdateEventException extends ServiceException {

    private static final long serialVersionUID = 4558248341826768721L;

    /**
     * Instantiates a new Update event exception.
     */
    public UpdateEventException() {
        super();
    }

    /**
     * Instantiates a new Update event exception.
     *
     * @param message the message
     */
    public UpdateEventException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Update event exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UpdateEventException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Update event exception.
     *
     * @param cause the cause
     */
    public UpdateEventException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Update event exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public UpdateEventException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
