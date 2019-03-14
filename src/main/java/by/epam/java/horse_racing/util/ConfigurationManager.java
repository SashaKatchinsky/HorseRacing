package by.epam.java.horse_racing.util;

import java.util.ResourceBundle;

/**
 * The type Configuration manager.
 */
public class ConfigurationManager {
    private static class ConfigurationManagerHolder {
        private static final ConfigurationManager INSTANCE = new ConfigurationManager();
    }

    /**
     * The constant resourceBundle.
     */
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    private ConfigurationManager() { }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ConfigurationManager getInstance() {
        return ConfigurationManagerHolder.INSTANCE;
    }

    /**
     * Gets property.
     *
     * @param key the key
     * @return the property
     */
    public String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
