package by.epam.java.horse_racing.bean;

import java.util.Objects;

/**
 * The type Horse.
 */
public class Horse {

    /**
     * Unique number of object
     */
    private int id;

    /**
     * Name
     */
    private String name;

    /**
     * Breed
     *
     * @see Breed
     */
    private Breed breed;

    /**
     * Instantiates a new Horse.
     */
    public Horse() { }

    /**
     * Instantiates a new Horse.
     *
     * @param id    the id
     * @param name  the name
     * @param breed the breed
     */
    public Horse(int id, String name, Breed breed) {
        this.id = id;
        this.name = name;
        this.breed = breed;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets breed.
     *
     * @return the breed
     */
    public Breed getBreed() {
        return breed;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets breed.
     *
     * @param breed the breed
     */
    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return id == horse.id &&
                Objects.equals(name, horse.name) &&
                breed == horse.breed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, breed);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed=" + breed +
                '}';
    }
}
