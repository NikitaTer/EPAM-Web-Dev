package by.epam.model.builder;

import by.epam.entity.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientBuilder {

    public static List<Client> createClients(ResultSet set) throws SQLException {
        List<Client> clients = new ArrayList<>();

        while (set.next()) {
            Client client = new Client();
            client.setLogin(set.getString("login"));
            client.setPassword(set.getString("password"));
            client.setSalt(set.getString("salt"));
            client.setRequestId(set.getInt("request_id"));
            client.setName(set.getString("name"));

            clients.add(client);
        }

        return clients;
    }
}