package by.epam.java.horse_racing.bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

/**
 * The type User.
 */
public class User {

    /**
     * Unique login of object
     */
    private String login;

    /**
     * Hash password
     *
     * @see by.epam.java.horse_racing.action.PasswordHasher
     */
    private char[] password;

    /**
     * Name
     */
    private String name;

    /**
     * Balance
     */
    private double balance;

    /**
     * Registration date
     */
    private LocalDate registrationDate;

    /**
     * Users's access
     *
     * @see Access
     */
    private Access access;

    /**
     * Instantiates a new User.
     */
    public User() {

    }

    /**
     * Instantiates a new User.
     *
     * @param login            the login
     * @param password         the password
     * @param name             the name
     * @param balance          the balance
     * @param registrationDate the registration date
     * @param access           the access
     */
    public User(String login, char[] password, String name, double balance, LocalDate registrationDate, Access access) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.balance = balance;
        this.registrationDate = registrationDate;
        this.access = access;
    }

    /**
     * Instantiates a new User.
     *
     * @param login            the login
     * @param password         the password
     * @param name             the name
     * @param balance          the balance
     * @param registrationDate the registration date
     * @param access           the access
     */
    public User(String login , char[] password, String name , double balance , String registrationDate , Access access) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.balance = balance;
        this.registrationDate = LocalDate.parse(registrationDate);
        this.access = access;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Get password char [ ].
     *
     * @return the char [ ]
     */
    public char[] getPassword() {
        return password;
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
     * Gets balance.
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets registration date.
     *
     * @return the registration date
     */
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Gets access.
     *
     * @return the access
     */
    public Access getAccess() {
        return access;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(char[] password) {
        this.password = password;
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
     * Sets balance.
     *
     * @param balance the balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Sets registration date.
     *
     * @param registrationDate the registration date
     */
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Sets registration date.
     *
     * @param registrationDate the registration date
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = LocalDate.parse(registrationDate);
    }

    /**
     * Sets registration time.
     *
     * @param registrationTime the registration time
     */
    public void setRegistrationTime(LocalTime registrationTime) {
        this.registrationDate = registrationDate;
    }

    /**
     * Sets access.
     *
     * @param access the access
     */
    public void setAccess(Access access) {
        this.access = access;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password=" + Arrays.toString(password) +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", registrationDate=" + registrationDate +
                ", access=" + access +
                '}';
    }
}
