package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Get nearest event exception.
 */
public class GetNearestEventException extends ServiceException {
    /**
     * Instantiates a new Get nearest event exception.
     */
    public GetNearestEventException() {
        super();
    }

    /**
     * Instantiates a new Get nearest event exception.
     *
     * @param message the message
     */
    public GetNearestEventException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Get nearest event exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public GetNearestEventException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Get nearest event exception.
     *
     * @param cause the cause
     */
    public GetNearestEventException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Get nearest event exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public GetNearestEventException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
