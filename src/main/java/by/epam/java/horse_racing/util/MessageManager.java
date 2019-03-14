package by.epam.java.horse_racing.util;

import java.util.ResourceBundle;

/**
 * The type Message manager.
 */
public class MessageManager {
    private static class MessageManagerHolder {
        private static MessageManager INSTANCE = new MessageManager();
    }

    /**
     * The constant resourceBundle.
     */
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

    private MessageManager() { }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static MessageManager getInstance() {
        return MessageManagerHolder.INSTANCE;
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
