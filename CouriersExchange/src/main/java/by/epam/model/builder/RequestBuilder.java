package by.epam.model.builder;

import by.epam.entity.CargoType;
import by.epam.entity.Courier;
import by.epam.entity.User;
import by.epam.entity.UserRequest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestBuilder {
    public static List<UserRequest> build(ResultSet set) throws SQLException {
        List<UserRequest> requests = new ArrayList<>();

        while (set.next()) {
            UserRequest request = new UserRequest();

            request.setId(set.getInt(1));
            request.setCargoType(CargoType.valueOf(set.getString(2)));
            request.setCourierLogin(set.getString(3));
            request.setVehicle(set.getString(4));
            request.setCargoName(set.getString(5));

            requests.add(request);
        }

        return requests;
    }
}
