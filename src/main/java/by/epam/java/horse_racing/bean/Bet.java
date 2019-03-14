package by.epam.java.horse_racing.bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Bet.
 *
 * @author Sasha Yukhimchuk
 * @version 1.0
 */
public class Bet {
    /**
     * Unique number of object
     */
    private int id;

    /**
     * User who do bet
     * @see User
     */
    private User user;

    /**
     * Coefficient of this bet
     */
    private double coefficient;

    /**
     * Money of this bet
     * if it wins user gets money * coefficient on his balance
     */
    private double money;

    /**
     * Date of this bet
     */
    private LocalDate date;

    /**
     * Time of this bet
     */
    private LocalTime time;

    /**
     * Type enum of this bet
     *
     * @see BetType
     */
    private BetType type;

    /**
     * Status of this bet
     *
     * @see BetStatus
     */
    private BetStatus status;

    /**
     * Same as type if is is not express
     * otherwise it costists of 2 - 4 types of bets that made at the same time by the same user
     */
    private List<BetType> typeList;

    /**
     * Event of this bet
     *
     * @see Event
     */
    private Event event;


    /**
     * Instantiates a new Bet.
     */
    public Bet() {
        typeList = new ArrayList<>();
    }


    /**
     * Instantiates a new Bet.
     *
     * @param id          the id
     * @param user        the user
     * @param coefficient the coefficient
     * @param money       the money
     * @param date        the date
     * @param time        the time
     * @param type        the type
     * @param status      the status
     * @param event       the event
     */
    public Bet(int id, User user, double coefficient, double money, LocalDate date, LocalTime time, BetType type, BetStatus status, Event event) {
        this.id = id;
        this.user = user;
        this.coefficient = coefficient;
        this.money = money;
        this.date = date;
        this.time = time;
        this.type = type;
        this.status = status;
        typeList = new ArrayList<>();
        typeList.add(type);
        this.event = event;
    }

    /**
     * Gets id.
     *
     * @return id id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets user.
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Gets coefficient.
     *
     * @return the coefficient
     */
    public double getCoefficient() {
        return coefficient;
    }

    /**
     * Gets money.
     *
     * @return the money
     */
    public double getMoney() {
        return money;
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
     * Gets type.
     *
     * @return the type
     */
    public BetType getType() {
        return type;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public BetStatus getStatus() {
        return status;
    }

    /**
     * Gets type list.
     *
     * @return the type list
     */
    public List<BetType> getTypeList() {
        return typeList;
    }

    /**
     * Gets event.
     *
     * @return the event
     */
    public Event getEvent() {
        return event;
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
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Sets coefficient.
     *
     * @param coefficient the coefficient
     */
    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    /**
     * Sets money.
     *
     * @param money the money
     */
    public void setMoney(double money) {
        this.money = money;
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
     * Sets type.
     *
     * @param type the type
     */
    public void setType(BetType type) {
        this.type = type;
        typeList.add(type);
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(BetStatus status) {
        this.status = status;
    }

    /**
     * Sets type list.
     *
     * @param typeList the type list
     */
    public void setTypeList(List<BetType> typeList) {
        this.typeList = typeList;
    }

    /**
     * Sets event.
     *
     * @param event the event
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet = (Bet) o;
        return id == bet.id &&
                Double.compare(bet.coefficient, coefficient) == 0 &&
                Double.compare(bet.money, money) == 0 &&
                user.equals(bet.user) &&
                date.equals(bet.date) &&
                time.equals(bet.time) &&
                type == bet.type &&
                status == bet.status &&
                typeList.equals(bet.typeList) &&
                event.equals(bet.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, coefficient, money, date, time, type, status, typeList, event);
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", user=" + user +
                ", coefficient=" + coefficient +
                ", money=" + money +
                ", date=" + date +
                ", time=" + time +
                ", type=" + type +
                ", status=" + status +
                ", typeList=" + typeList +
                ", event=" + event +
                '}';
    }
}
