package by.epam.model.builder;

import by.epam.entity.Courier;
import by.epam.model.CurrentDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourierBuilder {
    public static List<Courier> createCouriers(ResultSet set, CurrentDAO dao) throws SQLException {
        List<Courier> couriers = new ArrayList<>();

        while (set.next()) {
            Courier courier = new Courier();
            courier.setLogin(set.getString("login"));
            courier.setPassword(set.getString("password"));
            courier.setSalt(set.getString("salt"));
            courier.setInUse(set.getBoolean("inUse"));
            courier.setName(set.getString("name"));
            courier.setVehicle(dao.getVehicle(set.getInt("vehicle_id")));

            couriers.add(courier);
        }

        return couriers;
    }
}
