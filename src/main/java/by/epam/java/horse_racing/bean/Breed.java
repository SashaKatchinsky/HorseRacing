package by.epam.java.horse_racing.bean;

/**
 * The enum Breed.
 */
public enum Breed {
    /**
     * Arabian breed.
     */
    ARABIAN("arabian"),
    /**
     * Akhal teke breed.
     */
    AKHAL_TEKE("akhal-teke"),
    /**
     * Siglavi breed.
     */
    SIGLAVI("siglavi"),
    /**
     * Hadban breed.
     */
    HADBAN("hadban");

    private final String val;

    Breed(String val) {
        this.val = val;
    }

    /**
     * Gets breed.
     *
     * @return the breed
     */
    public String getBreed() {
        return val;
    }
}
