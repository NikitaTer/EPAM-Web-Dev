package by.epam.app.validations;

import by.epam.app.entity.Cone;

public class DataValidator {

    //private static final String REGEX1 = "-?[0-9].?[0-9]? -?[0-9].?[0-9]? -?[0-9].?[0-9]? -?[0-9].?[0-9]? -?[0-9].?[0-9]?";

    public static boolean check(String string) {

        for (char c : string.toCharArray()) {

            if (c != ' ' && c != '.' &&  c != '-' && (c < '0' || c > '9')) {
                return false;
            }
        }

        String[] strings = string.split(" ");

        if (strings.length != 5) {
            return false;
        }

        return !(Double.parseDouble(strings[3]) < 0) && !(Double.parseDouble(strings[4]) < 0);
    }

    public static boolean isCone(Cone cone) {
        return cone.getRadius() > 0 && cone.getHigh() > 0;
    }
}
