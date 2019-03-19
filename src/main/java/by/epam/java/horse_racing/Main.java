package by.epam.java.horse_racing;

import by.epam.java.horse_racing.dao.connection.ConnectionPool;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws DaoException, SQLException {
        Logger logger = LogManager.getLogger(Main.class);
        ConnectionPool.getInstance().init("database.properties");
    }
}
