package by.epam.model.builder;

import by.epam.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBuilder {
    public static List<User> build(ResultSet set) throws SQLException {
        List<User> users = new ArrayList<>();

        while (set.next()) {
            User user = new User();

            user.setLogin(set.getString(1));
            user.setLogin(set.getString(1));
            user.setLogin(set.getString(1));
            user.setLogin(set.getString(1));
            user.setLogin(set.getString(1));
        }
    }
}
