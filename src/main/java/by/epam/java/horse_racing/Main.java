package by.epam.java.horse_racing;

import by.epam.java.horse_racing.dao.EventDaoMySql;
import by.epam.java.horse_racing.dao.connection.ConnectionPool;
import by.epam.java.horse_racing.dao.exceptions.DaoException;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws DaoException, SQLException {
        ConnectionPool.getInstance().init("database.properties");
        EventDaoMySql.getInstance().deleteEvent(20);
    }
}
