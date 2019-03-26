package by.epam.java.horse_racing.dao.connection;

import by.epam.java.horse_racing.dao.exceptions.CloseConnectionException;
import by.epam.java.horse_racing.dao.exceptions.DBDriverInitException;
import by.epam.java.horse_racing.dao.exceptions.GetConnectionException;
import by.epam.java.horse_racing.dao.exceptions.OpenDBPropFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * The type Connection pool.
 */
public class ConnectionPool {
    private static class ConnectionPoolHolder {
        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    /**
     * Database handler.
     */
    private DBHandler dbHandler;

    /**
     * URL.
     */
    private String url;

    /**
     * Username.
     */
    private String username;

    /**
     * User's password.
     */
    private String password;

    /**
     * Name of database properties file.
     */
    private String dBPropName;

    /**
     * Count of connections in the connection pool.
     */
    private int connectionCount;

    /**
     * Available connections.
     */
    private BlockingQueue<Connection> availableConnections;

    /**
     * Used connections.
     */
    private BlockingQueue<Connection> usedConnections;

    /**
     * Logger.
     */
    private static final Logger CONNECTIONPOOLLOGGER = LogManager.getLogger(ConnectionPool.class);

    private ConnectionPool() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }

    /**
     * Init database.
     *
     * @param dBPropName the database properties file name
     * @throws DBDriverInitException   the db driver init exception
     * @throws OpenDBPropFileException the open db prop file exception
     * @throws GetConnectionException  the get connection exception
     */
    public void init(String dBPropName) throws DBDriverInitException, OpenDBPropFileException, GetConnectionException {
        this.dBPropName = dBPropName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new DBDriverInitException(e);
        }
        dbHandler = new DBHandler();
        dbHandler.open(dBPropName);
        url = dbHandler.getUrl();
        username = dbHandler.getUsername();
        password = dbHandler.getPassword();
        connectionCount = dbHandler.getConnectionCount();
        availableConnections = new ArrayBlockingQueue<>(connectionCount);
        usedConnections = new ArrayBlockingQueue<>(connectionCount);
        for (int i = 0 ; i < connectionCount ; i++) {
            Connection connection = getConnection();
            availableConnections.add(connection);
        }
        CONNECTIONPOOLLOGGER.debug("Driver initialized successfully");
    }

    /**
     * Get connection.
     *
     * @return connection
     * @throws GetConnectionException
     */
    private Connection getConnection() throws GetConnectionException {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url , username , password);
        } catch (SQLException e) {
            throw new GetConnectionException(e);
        }
        return connection;
    }

    /**
     * Retrieve connection from connection pool.
     *
     * @return the connection
     * @throws GetConnectionException the get connection exception
     */
    public Connection retrieve () throws GetConnectionException {
        Connection newConnection;
        try {
            newConnection = availableConnections.take();
        } catch (InterruptedException e) {
            throw new GetConnectionException(e);
        }
        usedConnections.add(newConnection);
        return newConnection;
    }

    /**
     * Put back connection in connection pool.
     *
     * @param connection the connection
     */
    public void putBack(Connection connection) {
        if (connection != null) {
            usedConnections.remove(connection);
            availableConnections.add(connection);
        }
    }

    /**
     * Destroy connection pool.
     *
     * @throws CloseConnectionException the close connection exception
     */
    public void destroy() throws CloseConnectionException {
        try {
            if (!availableConnections.isEmpty()) {
                for (Connection connection : availableConnections) {
                    connection.close();
                }
            }
            if (!usedConnections.isEmpty()) {
                for (Connection connection : usedConnections) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            throw new CloseConnectionException(e);
        }
    }
}
