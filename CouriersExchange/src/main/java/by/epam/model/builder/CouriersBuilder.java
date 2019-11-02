package by.epam.model.builder;

import by.epam.entity.Courier;
import by.epam.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CouriersBuilder {
    public static List<Courier> build(ResultSet set) throws SQLException {
        List<Courier> couriers = new ArrayList<>();

        while (set.next()) {
            Courier courier = new Courier();

            courier.setLogin(set.getString(1));
            courier.setPassword(set.getString(2));
            courier.setSalt(set.getString(3));
            courier.setName(set.getString(4));
            courier.setVehocleId(set.getInt(5));
            courier.setInUse(set.getBoolean(6));
            courier.setOnline(set.getBoolean(7));
            courier.setLastTimeSeen(set.getDate(8));
            courier.setEmail(set.getString(9));

            couriers.add(courier);
        }

        return couriers;
    }
}
