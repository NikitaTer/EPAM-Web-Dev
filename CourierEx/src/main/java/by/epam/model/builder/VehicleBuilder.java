package by.epam.model.builder;

import by.epam.entity.Courier;
import by.epam.entity.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleBuilder {
    public static Vehicle createVehicle(ResultSet set) throws SQLException {
        List<Courier> couriers = new ArrayList<>();

        if (set.next()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(set.getInt("id"));
            vehicle.setCargoId(set.getString("cargo_id"));
            vehicle.setCargoType(set.getString("cargo_type"));
            vehicle.setName(set.getString("name"));
            vehicle.setInUse(set.getBoolean("inUse"));

            return vehicle;
        }

        return null;
    }
}
