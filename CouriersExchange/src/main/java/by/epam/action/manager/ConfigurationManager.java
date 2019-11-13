package by.epam.action.manager;

import java.util.ResourceBundle;

public class ConfigurationManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.properties.config");

    private ConfigurationManager() {

    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
