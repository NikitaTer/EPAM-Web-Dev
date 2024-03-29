package by.epam.action.manager;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("properties.local");

    private MessageManager() {

    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

    public static String getProperty(String key, Locale locale) {
        return resourceBundle.getString(key);
    }
}
