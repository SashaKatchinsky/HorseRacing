package by.epam.java.horse_racing.bean;

/**
 * The enum Bet status.
 */
public enum BetStatus {
    /**
     * Win bet status.
     */
    WIN("win"),
    /**
     * Loss bet status.
     */
    LOSS("loss"),
    /**
     * Notplayed bet status.
     */
    NOTPLAYED("notplayed");

    private final String val;

    BetStatus(String val) {
        this.val = val;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return val;
    }
}
