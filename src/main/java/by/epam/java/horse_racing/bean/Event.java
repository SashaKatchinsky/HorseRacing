package by.epam.java.horse_racing.bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * The type Event.
 */
public class Event {

    /**
     * Unique number of object
     */
    private int id;

    /**
     * Name
     */
    private String name;

    /**
     * Date when event will play
     */
    private LocalDate date;

    /**
     * Time when event will play
     */
    private LocalTime time;

    /**
     * Riders in this event
     */
    private Rider rider1;
    private Rider rider2;
    private Rider rider3;
    private Rider rider4;

    /**
     * Coefficients on every rider's places
     */
    private double rider1Position1Coefficient;
    private double rider1Position2Coefficient;
    private double rider1Position3Coefficient;
    private double rider1Position4Coefficient;
    private double rider2Position1Coefficient;
    private double rider2Position2Coefficient;
    private double rider2Position3Coefficient;
    private double rider2Position4Coefficient;
    private double rider3Position1Coefficient;
    private double rider3Position2Coefficient;
    private double rider3Position3Coefficient;
    private double rider3Position4Coefficient;
    private double rider4Position1Coefficient;
    private double rider4Position2Coefficient;
    private double rider4Position3Coefficient;
    private double rider4Position4Coefficient;

    /**
     * Rider's posotions
     * generate when event end(after date and time)
     */
    private int rider1Position;
    private int rider2Position;
    private int rider3Position;
    private int rider4Position;

    /**
     * Instantiates a new Event.
     */
    public Event() { }

    /**
     * Instantiates a new Event.
     *
     * @param id                         the id
     * @param name                       the name
     * @param date                       the date
     * @param time                       the time
     * @param rider1                     the rider 1
     * @param rider2                     the rider 2
     * @param rider3                     the rider 3
     * @param rider4                     the rider 4
     * @param rider1Position1Coefficient the rider 1 position 1 coefficient
     * @param rider1Position2Coefficient the rider 1 position 2 coefficient
     * @param rider1Position3Coefficient the rider 1 position 3 coefficient
     * @param rider1Position4Coefficient the rider 1 position 4 coefficient
     * @param rider2Position1Coefficient the rider 2 position 1 coefficient
     * @param rider2Position2Coefficient the rider 2 position 2 coefficient
     * @param rider2Position3Coefficient the rider 2 position 3 coefficient
     * @param rider2Position4Coefficient the rider 2 position 4 coefficient
     * @param rider3Position1Coefficient the rider 3 position 1 coefficient
     * @param rider3Position2Coefficient the rider 3 position 2 coefficient
     * @param rider3Position3Coefficient the rider 3 position 3 coefficient
     * @param rider3Position4Coefficient the rider 3 position 4 coefficient
     * @param rider4Position1Coefficient the rider 4 position 1 coefficient
     * @param rider4Position2Coefficient the rider 4 position 2 coefficient
     * @param rider4Position3Coefficient the rider 4 position 3 coefficient
     * @param rider4Position4Coefficient the rider 4 position 4 coefficient
     * @param rider1Position             the rider 1 position
     * @param rider2Position             the rider 2 position
     * @param rider3Position             the rider 3 position
     * @param rider4Position             the rider 4 position
     */
    public Event(int id, String name, LocalDate date, LocalTime time,
                 Rider rider1, Rider rider2, Rider rider3, Rider rider4,
                 double rider1Position1Coefficient, double rider1Position2Coefficient,
                 double rider1Position3Coefficient, double rider1Position4Coefficient,
                 double rider2Position1Coefficient, double rider2Position2Coefficient,
                 double rider2Position3Coefficient, double rider2Position4Coefficient,
                 double rider3Position1Coefficient, double rider3Position2Coefficient,
                 double rider3Position3Coefficient, double rider3Position4Coefficient,
                 double rider4Position1Coefficient, double rider4Position2Coefficient,
                 double rider4Position3Coefficient, double rider4Position4Coefficient,
                 int rider1Position, int rider2Position, int rider3Position, int rider4Position) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.rider1 = rider1;
        this.rider2 = rider2;
        this.rider3 = rider3;
        this.rider4 = rider4;
        this.rider1Position1Coefficient = rider1Position1Coefficient;
        this.rider1Position2Coefficient = rider1Position2Coefficient;
        this.rider1Position3Coefficient = rider1Position3Coefficient;
        this.rider1Position4Coefficient = rider1Position4Coefficient;
        this.rider2Position1Coefficient = rider2Position1Coefficient;
        this.rider2Position2Coefficient = rider2Position2Coefficient;
        this.rider2Position3Coefficient = rider2Position3Coefficient;
        this.rider2Position4Coefficient = rider2Position4Coefficient;
        this.rider3Position1Coefficient = rider3Position1Coefficient;
        this.rider3Position2Coefficient = rider3Position2Coefficient;
        this.rider3Position3Coefficient = rider3Position3Coefficient;
        this.rider3Position4Coefficient = rider3Position4Coefficient;
        this.rider4Position1Coefficient = rider4Position1Coefficient;
        this.rider4Position2Coefficient = rider4Position2Coefficient;
        this.rider4Position3Coefficient = rider4Position3Coefficient;
        this.rider4Position4Coefficient = rider4Position4Coefficient;
        this.rider1Position = rider1Position;
        this.rider2Position = rider2Position;
        this.rider3Position = rider3Position;
        this.rider4Position = rider4Position;
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
     * Gets date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Gets rider 1.
     *
     * @return the rider 1
     */
    public Rider getRider1() {
        return rider1;
    }

    /**
     * Gets rider 2.
     *
     * @return the rider 2
     */
    public Rider getRider2() {
        return rider2;
    }

    /**
     * Gets rider 3.
     *
     * @return the rider 3
     */
    public Rider getRider3() {
        return rider3;
    }

    /**
     * Gets rider 4.
     *
     * @return the rider 4
     */
    public Rider getRider4() {
        return rider4;
    }

    /**
     * Gets rider 1 position 1 coefficient.
     *
     * @return the rider 1 position 1 coefficient
     */
    public double getRider1Position1Coefficient() {
        return rider1Position1Coefficient;
    }

    /**
     * Gets rider 1 position 2 coefficient.
     *
     * @return the rider 1 position 2 coefficient
     */
    public double getRider1Position2Coefficient() {
        return rider1Position2Coefficient;
    }

    /**
     * Gets rider 1 position 3 coefficient.
     *
     * @return the rider 1 position 3 coefficient
     */
    public double getRider1Position3Coefficient() {
        return rider1Position3Coefficient;
    }

    /**
     * Gets rider 1 position 4 coefficient.
     *
     * @return the rider 1 position 4 coefficient
     */
    public double getRider1Position4Coefficient() {
        return rider1Position4Coefficient;
    }

    /**
     * Gets rider 2 position 1 coefficient.
     *
     * @return the rider 2 position 1 coefficient
     */
    public double getRider2Position1Coefficient() {
        return rider2Position1Coefficient;
    }

    /**
     * Gets rider 2 position 2 coefficient.
     *
     * @return the rider 2 position 2 coefficient
     */
    public double getRider2Position2Coefficient() {
        return rider2Position2Coefficient;
    }

    /**
     * Gets rider 2 position 3 coefficient.
     *
     * @return the rider 2 position 3 coefficient
     */
    public double getRider2Position3Coefficient() {
        return rider2Position3Coefficient;
    }

    /**
     * Gets rider 2 position 4 coefficient.
     *
     * @return the rider 2 position 4 coefficient
     */
    public double getRider2Position4Coefficient() {
        return rider2Position4Coefficient;
    }

    /**
     * Gets rider 3 position 1 coefficient.
     *
     * @return the rider 3 position 1 coefficient
     */
    public double getRider3Position1Coefficient() {
        return rider3Position1Coefficient;
    }

    /**
     * Gets rider 3 position 2 coefficient.
     *
     * @return the rider 3 position 2 coefficient
     */
    public double getRider3Position2Coefficient() {
        return rider3Position2Coefficient;
    }

    /**
     * Gets rider 3 position 3 coefficient.
     *
     * @return the rider 3 position 3 coefficient
     */
    public double getRider3Position3Coefficient() {
        return rider3Position3Coefficient;
    }

    /**
     * Gets rider 3 position 4 coefficient.
     *
     * @return the rider 3 position 4 coefficient
     */
    public double getRider3Position4Coefficient() {
        return rider3Position4Coefficient;
    }

    /**
     * Gets rider 4 position 1 coefficient.
     *
     * @return the rider 4 position 1 coefficient
     */
    public double getRider4Position1Coefficient() {
        return rider4Position1Coefficient;
    }

    /**
     * Gets rider 4 position 2 coefficient.
     *
     * @return the rider 4 position 2 coefficient
     */
    public double getRider4Position2Coefficient() {
        return rider4Position2Coefficient;
    }

    /**
     * Gets rider 4 position 3 coefficient.
     *
     * @return the rider 4 position 3 coefficient
     */
    public double getRider4Position3Coefficient() {
        return rider4Position3Coefficient;
    }

    /**
     * Gets rider 4 position 4 coefficient.
     *
     * @return the rider 4 position 4 coefficient
     */
    public double getRider4Position4Coefficient() {
        return rider4Position4Coefficient;
    }

    /**
     * Gets rider 1 position.
     *
     * @return the rider 1 position
     */
    public int getRider1Position() {
        return rider1Position;
    }

    /**
     * Gets rider 2 position.
     *
     * @return the rider 2 position
     */
    public int getRider2Position() {
        return rider2Position;
    }

    /**
     * Gets rider 3 position.
     *
     * @return the rider 3 position
     */
    public int getRider3Position() {
        return rider3Position;
    }

    /**
     * Gets rider 4 position.
     *
     * @return the rider 4 position
     */
    public int getRider4Position() {
        return rider4Position;
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
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Sets rider 1.
     *
     * @param rider1 the rider 1
     */
    public void setRider1(Rider rider1) {
        this.rider1 = rider1;
    }

    /**
     * Sets rider 2.
     *
     * @param rider2 the rider 2
     */
    public void setRider2(Rider rider2) {
        this.rider2 = rider2;
    }

    /**
     * Sets rider 3.
     *
     * @param rider3 the rider 3
     */
    public void setRider3(Rider rider3) {
        this.rider3 = rider3;
    }

    /**
     * Sets rider 4.
     *
     * @param rider4 the rider 4
     */
    public void setRider4(Rider rider4) {
        this.rider4 = rider4;
    }

    /**
     * Sets rider 1 position 1 coefficient.
     *
     * @param rider1Position1Coefficient the rider 1 position 1 coefficient
     */
    public void setRider1Position1Coefficient(double rider1Position1Coefficient) {
        this.rider1Position1Coefficient = rider1Position1Coefficient;
    }

    /**
     * Sets rider 1 position 2 coefficient.
     *
     * @param rider1Position2Coefficient the rider 1 position 2 coefficient
     */
    public void setRider1Position2Coefficient(double rider1Position2Coefficient) {
        this.rider1Position2Coefficient = rider1Position2Coefficient;
    }

    /**
     * Sets rider 1 position 3 coefficient.
     *
     * @param rider1Position3Coefficient the rider 1 position 3 coefficient
     */
    public void setRider1Position3Coefficient(double rider1Position3Coefficient) {
        this.rider1Position3Coefficient = rider1Position3Coefficient;
    }

    /**
     * Sets rider 1 position 4 coefficient.
     *
     * @param rider1Position4Coefficient the rider 1 position 4 coefficient
     */
    public void setRider1Position4Coefficient(double rider1Position4Coefficient) {
        this.rider1Position4Coefficient = rider1Position4Coefficient;
    }

    /**
     * Sets rider 2 position 1 coefficient.
     *
     * @param rider2Position1Coefficient the rider 2 position 1 coefficient
     */
    public void setRider2Position1Coefficient(double rider2Position1Coefficient) {
        this.rider2Position1Coefficient = rider2Position1Coefficient;
    }

    /**
     * Sets rider 2 position 2 coefficient.
     *
     * @param rider2Position2Coefficient the rider 2 position 2 coefficient
     */
    public void setRider2Position2Coefficient(double rider2Position2Coefficient) {
        this.rider2Position2Coefficient = rider2Position2Coefficient;
    }

    /**
     * Sets rider 2 position 3 coefficient.
     *
     * @param rider2Position3Coefficient the rider 2 position 3 coefficient
     */
    public void setRider2Position3Coefficient(double rider2Position3Coefficient) {
        this.rider2Position3Coefficient = rider2Position3Coefficient;
    }

    /**
     * Sets rider 2 position 4 coefficient.
     *
     * @param rider2Position4Coefficient the rider 2 position 4 coefficient
     */
    public void setRider2Position4Coefficient(double rider2Position4Coefficient) {
        this.rider2Position4Coefficient = rider2Position4Coefficient;
    }

    /**
     * Sets rider 3 position 1 coefficient.
     *
     * @param rider3Position1Coefficient the rider 3 position 1 coefficient
     */
    public void setRider3Position1Coefficient(double rider3Position1Coefficient) {
        this.rider3Position1Coefficient = rider3Position1Coefficient;
    }

    /**
     * Sets rider 3 position 2 coefficient.
     *
     * @param rider3Position2Coefficient the rider 3 position 2 coefficient
     */
    public void setRider3Position2Coefficient(double rider3Position2Coefficient) {
        this.rider3Position2Coefficient = rider3Position2Coefficient;
    }

    /**
     * Sets rider 3 position 3 coefficient.
     *
     * @param rider3Position3Coefficient the rider 3 position 3 coefficient
     */
    public void setRider3Position3Coefficient(double rider3Position3Coefficient) {
        this.rider3Position3Coefficient = rider3Position3Coefficient;
    }

    /**
     * Sets rider 3 position 4 coefficient.
     *
     * @param rider3Position4Coefficient the rider 3 position 4 coefficient
     */
    public void setRider3Position4Coefficient(double rider3Position4Coefficient) {
        this.rider3Position4Coefficient = rider3Position4Coefficient;
    }

    /**
     * Sets rider 4 position 1 coefficient.
     *
     * @param rider4Position1Coefficient the rider 4 position 1 coefficient
     */
    public void setRider4Position1Coefficient(double rider4Position1Coefficient) {
        this.rider4Position1Coefficient = rider4Position1Coefficient;
    }

    /**
     * Sets rider 4 position 2 coefficient.
     *
     * @param rider4Position2Coefficient the rider 4 position 2 coefficient
     */
    public void setRider4Position2Coefficient(double rider4Position2Coefficient) {
        this.rider4Position2Coefficient = rider4Position2Coefficient;
    }

    /**
     * Sets rider 4 position 3 coefficient.
     *
     * @param rider4Position3Coefficient the rider 4 position 3 coefficient
     */
    public void setRider4Position3Coefficient(double rider4Position3Coefficient) {
        this.rider4Position3Coefficient = rider4Position3Coefficient;
    }

    /**
     * Sets rider 4 position 4 coefficient.
     *
     * @param rider4Position4Coefficient the rider 4 position 4 coefficient
     */
    public void setRider4Position4Coefficient(double rider4Position4Coefficient) {
        this.rider4Position4Coefficient = rider4Position4Coefficient;
    }

    /**
     * Sets rider 1 position.
     *
     * @param rider1Position the rider 1 position
     */
    public void setRider1Position(int rider1Position) {
        this.rider1Position = rider1Position;
    }

    /**
     * Sets rider 2 position.
     *
     * @param rider2Position the rider 2 position
     */
    public void setRider2Position(int rider2Position) {
        this.rider2Position = rider2Position;
    }

    /**
     * Sets rider 3 position.
     *
     * @param rider3Position the rider 3 position
     */
    public void setRider3Position(int rider3Position) {
        this.rider3Position = rider3Position;
    }

    /**
     * Sets rider 4 position.
     *
     * @param rider4Position the rider 4 position
     */
    public void setRider4Position(int rider4Position) {
        this.rider4Position = rider4Position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                Double.compare(event.rider1Position1Coefficient, rider1Position1Coefficient) == 0 &&
                Double.compare(event.rider1Position2Coefficient, rider1Position2Coefficient) == 0 &&
                Double.compare(event.rider1Position3Coefficient, rider1Position3Coefficient) == 0 &&
                Double.compare(event.rider1Position4Coefficient, rider1Position4Coefficient) == 0 &&
                Double.compare(event.rider2Position1Coefficient, rider2Position1Coefficient) == 0 &&
                Double.compare(event.rider2Position2Coefficient, rider2Position2Coefficient) == 0 &&
                Double.compare(event.rider2Position3Coefficient, rider2Position3Coefficient) == 0 &&
                Double.compare(event.rider2Position4Coefficient, rider2Position4Coefficient) == 0 &&
                Double.compare(event.rider3Position1Coefficient, rider3Position1Coefficient) == 0 &&
                Double.compare(event.rider3Position2Coefficient, rider3Position2Coefficient) == 0 &&
                Double.compare(event.rider3Position3Coefficient, rider3Position3Coefficient) == 0 &&
                Double.compare(event.rider3Position4Coefficient, rider3Position4Coefficient) == 0 &&
                Double.compare(event.rider4Position1Coefficient, rider4Position1Coefficient) == 0 &&
                Double.compare(event.rider4Position2Coefficient, rider4Position2Coefficient) == 0 &&
                Double.compare(event.rider4Position3Coefficient, rider4Position3Coefficient) == 0 &&
                Double.compare(event.rider4Position4Coefficient, rider4Position4Coefficient) == 0 &&
                rider1Position == event.rider1Position &&
                rider2Position == event.rider2Position &&
                rider3Position == event.rider3Position &&
                rider4Position == event.rider4Position &&
                name.equals(event.name) &&
                date.equals(event.date) &&
                time.equals(event.time) &&
                rider1.equals(event.rider1) &&
                rider2.equals(event.rider2) &&
                rider3.equals(event.rider3) &&
                rider4.equals(event.rider4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, time, rider1, rider2, rider3, rider4, rider1Position1Coefficient, rider1Position2Coefficient, rider1Position3Coefficient, rider1Position4Coefficient, rider2Position1Coefficient, rider2Position2Coefficient, rider2Position3Coefficient, rider2Position4Coefficient, rider3Position1Coefficient, rider3Position2Coefficient, rider3Position3Coefficient, rider3Position4Coefficient, rider4Position1Coefficient, rider4Position2Coefficient, rider4Position3Coefficient, rider4Position4Coefficient, rider1Position, rider2Position, rider3Position, rider4Position);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", rider1=" + rider1 +
                ", rider2=" + rider2 +
                ", rider3=" + rider3 +
                ", rider4=" + rider4 +
                ", rider1Position1Coefficient=" + rider1Position1Coefficient +
                ", rider1Position2Coefficient=" + rider1Position2Coefficient +
                ", rider1Position3Coefficient=" + rider1Position3Coefficient +
                ", rider1Position4Coefficient=" + rider1Position4Coefficient +
                ", rider2Position1Coefficient=" + rider2Position1Coefficient +
                ", rider2Position2Coefficient=" + rider2Position2Coefficient +
                ", rider2Position3Coefficient=" + rider2Position3Coefficient +
                ", rider2Position4Coefficient=" + rider2Position4Coefficient +
                ", rider3Position1Coefficient=" + rider3Position1Coefficient +
                ", rider3Position2Coefficient=" + rider3Position2Coefficient +
                ", rider3Position3Coefficient=" + rider3Position3Coefficient +
                ", rider3Position4Coefficient=" + rider3Position4Coefficient +
                ", rider4Position1Coefficient=" + rider4Position1Coefficient +
                ", rider4Position2Coefficient=" + rider4Position2Coefficient +
                ", rider4Position3Coefficient=" + rider4Position3Coefficient +
                ", rider4Position4Coefficient=" + rider4Position4Coefficient +
                ", rider1Position=" + rider1Position +
                ", rider2Position=" + rider2Position +
                ", rider3Position=" + rider3Position +
                ", rider4Position=" + rider4Position +
                '}';
    }
}
