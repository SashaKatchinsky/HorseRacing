package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Update horse exception.
 */
public class UpdateHorseException extends ServiceException {

    private static final long serialVersionUID = -1168646114123490499L;

    /**
     * Instantiates a new Update horse exception.
     */
    public UpdateHorseException() {
        super();
    }

    /**
     * Instantiates a new Update horse exception.
     *
     * @param message the message
     */
    public UpdateHorseException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Update horse exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UpdateHorseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Update horse exception.
     *
     * @param cause the cause
     */
    public UpdateHorseException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Update horse exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public UpdateHorseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
