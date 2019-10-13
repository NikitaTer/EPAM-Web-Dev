package by.epam.entity;

import java.util.HashMap;
import java.util.Map;

public enum CandyType {
    IRIS, CARAMEL, CHOCOLATE_WITH, CHOCOLATE_WITHOUT;

    public static CandyType getByName(String string) {
        switch (string) {
            case "iris":
                return IRIS;

            case "caramel":
                return CARAMEL;

            case "chocolate-with":
                return CHOCOLATE_WITH;

            case "chocolate-without":
                return CHOCOLATE_WITHOUT;

            default:
                return null;
        }
    }
}
