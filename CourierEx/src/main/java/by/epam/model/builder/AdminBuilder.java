package by.epam.model.builder;

import by.epam.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminBuilder {

    public static List<Admin> createAdmin(ResultSet set) throws SQLException {
        List<Admin> clients = new ArrayList<>();

        while (set.next()) {
            Admin admin = new Admin();
            admin.setLogin(set.getString("login"));
            admin.setPassword(set.getString("password"));
            admin.setSalt(set.getString("salt"));
            admin.setName(set.getString("name"));

            clients.add(admin);
        }

        return clients;
    }
}
