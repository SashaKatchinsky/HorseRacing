package by.epam.java.horse_racing.controller.exceptions;

/**
 * The type Loading application fatal exception.
 */
public class LoadingApplicationFatalException extends RuntimeException {

    private static final long serialVersionUID = -2412365495590152547L;

    /**
     * Instantiates a new Loading application fatal exception.
     */
    public LoadingApplicationFatalException() {
    }

    /**
     * Instantiates a new Loading application fatal exception.
     *
     * @param message the message
     */
    public LoadingApplicationFatalException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Loading application fatal exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public LoadingApplicationFatalException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Loading application fatal exception.
     *
     * @param cause the cause
     */
    public LoadingApplicationFatalException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Loading application fatal exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public LoadingApplicationFatalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
