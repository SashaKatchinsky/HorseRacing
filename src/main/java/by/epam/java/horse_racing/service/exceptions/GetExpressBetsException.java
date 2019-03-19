package by.epam.java.horse_racing.service.exceptions;

/**
 * The type Get express bets exception.
 */
public class GetExpressBetsException extends ServiceException {

    private static final long serialVersionUID = -4591491821507142311L;

    /**
     * Instantiates a new Get express bets exception.
     */
    public GetExpressBetsException() {
        super();
    }

    /**
     * Instantiates a new Get express bets exception.
     *
     * @param message the message
     */
    public GetExpressBetsException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Get express bets exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public GetExpressBetsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Get express bets exception.
     *
     * @param cause the cause
     */
    public GetExpressBetsException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Get express bets exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public GetExpressBetsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
