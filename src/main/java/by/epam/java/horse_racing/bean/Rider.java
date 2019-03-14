package by.epam.java.horse_racing.bean;

import java.util.Objects;

/**
 * The type Rider.
 */
public class Rider {

    /**
     * Unique number of object
     */
    private int id;

    /**
     * Name
     */
    private String name;

    /**
     * Horse
     *
     * @see Horse
     */
    private Horse horse;

    /**
     * Instantiates a new Rider.
     */
    public Rider() { }

    /**
     * Instantiates a new Rider.
     *
     * @param id    the id
     * @param name  the name
     * @param horse the horse
     */
    public Rider(int id, String name, Horse horse) {
        this.id = id;
        this.name = name;
        this.horse = horse;
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
     * Gets horse.
     *
     * @return the horse
     */
    public Horse getHorse() {
        return horse;
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
     * Sets horse.
     *
     * @param horse the horse
     */
    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rider rider = (Rider) o;
        return id == rider.id &&
                name.equals(rider.name) &&
                horse.equals(rider.horse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, horse);
    }

    @Override
    public String toString() {
        return "Rider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", horse=" + horse +
                '}';
    }
}
