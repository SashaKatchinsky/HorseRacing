package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Delete event exception.
 */
public class DeleteEventException extends ServiceException {

    private static final long serialVersionUID = -5872676107191414000L;

    /**
     * Instantiates a new Delete event exception.
     */
    public DeleteEventException() {
        super();
    }

    /**
     * Instantiates a new Delete event exception.
     *
     * @param message the message
     */
    public DeleteEventException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Delete event exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public DeleteEventException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Delete event exception.
     *
     * @param cause the cause
     */
    public DeleteEventException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Delete event exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public DeleteEventException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
