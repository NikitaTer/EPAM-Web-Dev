package by.epam.model.builder;

import by.epam.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersBuilder {
    public static List<User> build(ResultSet set) throws SQLException {
        List<User> users = new ArrayList<>();

        while (set.next()) {
            User user = new User();

            user.setLogin(set.getString(1));
            user.setPassword(set.getBytes(2));
            user.setSalt(set.getBytes(3));
            user.setName(set.getString(4));
            user.setEmail(set.getString(5));
            user.setOnline(set.getBoolean(6));
            user.setAdmin(set.getBoolean(7));
            user.setCourier(set.getBoolean(8));
            user.setRating(set.getFloat(9));
            user.setLastTimeSeen(set.getDate(10));

            users.add(user);
        }

        return users;
    }
}
