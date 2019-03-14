package by.epam.java.horse_racing.dao.connection;

import by.epam.java.horse_racing.dao.exceptions.OpenDBPropFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Database handler.
 */
public class DBHandler {
    private static final Logger dbHandlerLogger = LogManager.getLogger(DBHandler.class.getName());

    /**
     * Database url.
     */
    private String url;

    /**
     * Username
     */
    private String username;

    /**
     * User's password.
     */
    private String password;

    /**
     * Database properties file name
     */
    private String dBPropName;

    /**
     * Count of connections int the connection pool
     *
     * @see ConnectionPool
     */
    private int connectionCount;

    private Properties properties = new Properties();
    private FileInputStream fileInputStream;

    /**
     * Instantiates a new Db handler.
     */
    public DBHandler() {

    }

    /**
     * Open database properties file.
     *
     * @param dBPropName the database prop file name
     * @throws OpenDBPropFileException the open database prop file exception
     */
    public void open(String dBPropName) throws OpenDBPropFileException {
        this.dBPropName = dBPropName;
        try {
            fileInputStream = new FileInputStream(DBHandler.class.getResource("/" + dBPropName).getPath());
            properties.load(fileInputStream);
        } catch (IOException e) {
            dbHandlerLogger.fatal("Невозможно отерыть файл настроек базы данных");
            throw new OpenDBPropFileException(e);
        }
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        connectionCount = Integer.parseInt(properties.getProperty("connectionCount"));
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets db prop name.
     *
     * @return the db prop name
     */
    public String getDBPropName() {
        return dBPropName;
    }

    /**
     * Gets connection count.
     *
     * @return the connection count
     */
    public int getConnectionCount() {
        return connectionCount;
    }
}
