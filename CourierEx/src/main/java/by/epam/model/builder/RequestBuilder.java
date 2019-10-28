package by.epam.model.builder;

import by.epam.entity.ClientsRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestBuilder {
    public static ClientsRequest createRequest(ResultSet set) throws SQLException {
        ClientsRequest request = new ClientsRequest();

        if (set.next()) {
            request.setCargoType(set.getString("cargo_type"));
            request.setCourierLogin(set.getString("courier_login"));
            request.setId(set.getInt("id"));
            request.setVehicle(set.getString("vehicle"));
        }

        return request;
    }
}
