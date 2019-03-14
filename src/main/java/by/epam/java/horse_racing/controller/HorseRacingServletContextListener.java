package by.epam.java.horse_racing.controller;

import by.epam.java.horse_racing.dao.connection.ConnectionPool;
import by.epam.java.horse_racing.dao.exceptions.CloseConnectionException;
import by.epam.java.horse_racing.dao.exceptions.DBDriverInitException;
import by.epam.java.horse_racing.dao.exceptions.GetConnectionException;
import by.epam.java.horse_racing.dao.exceptions.OpenDBPropFileException;
import by.epam.java.horse_racing.service.BookmakerService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HorseRacingServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionPool.getInstance().init("database.properties");
            BookmakerService.getInstance().start();
        } catch (DBDriverInitException | GetConnectionException | OpenDBPropFileException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            ConnectionPool.getInstance().destroy();
        } catch (CloseConnectionException closeConnectionException) {

        }
    }
}
