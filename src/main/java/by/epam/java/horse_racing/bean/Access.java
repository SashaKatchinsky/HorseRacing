package by.epam.java.horse_racing.bean;

/**
 * The enum Access.
 */
public enum Access {
    /**
     * Admin access.
     */
    ADMIN("admin"),
    /**
     * Bookmaker access.
     */
    BOOKMAKER("bookmaker"),
    /**
     * User access.
     */
    USER("user");

    private final String val;

    Access(String val) {
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
