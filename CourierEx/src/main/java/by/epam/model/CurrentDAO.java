package by.epam.model;

import by.epam.entity.*;
import by.epam.model.builder.*;

import java.sql.*;
import java.util.List;

public class CurrentDAO implements BasicDAO {

    private CurrentDAO() {

    }

    @Override
    public List<Client> getClients() {
        List<Client> clients = null;

        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLStatements.GET_ALL_CLIENTS);
            ResultSet set = statement.executeQuery();
            clients = ClientBuilder.createClients(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    @Override
    public void addClient(Client client) {
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(SQLStatements.ADD_CLIENT);
            statement.setString(1, client.getLogin());
            statement.setString(2, client.getPassword());
            statement.setString(3, client.getSalt());
            statement.setString(4, client.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public List<Courier> getCouriers() {
        List<Courier> couriers = null;

        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLStatements.GET_ALL_COURIERS);
            ResultSet set = statement.executeQuery();
            couriers = CourierBuilder.createCouriers(set, this);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return couriers;
    }

    @Override
    public void addCourier(Courier courier) {
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(SQLStatements.ADD_COURIER);
            statement.setString(1, courier.getLogin());
            statement.setString(2, courier.getPassword());
            statement.setString(3, courier.getSalt());
            statement.setString(4, courier.getName());
            statement.setInt(5, courier.getVehicle().getId());
            statement.setBoolean(6, courier.inUse());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public List<Admin> getAdmins() {
        List<Admin> admins = null;

        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLStatements.GET_ALL_ADMINS);
            ResultSet set = statement.executeQuery();
            admins = AdminBuilder.createAdmin(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admins;
    }

    @Override
    public void addAdmin(Admin admin) {
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(SQLStatements.ADD_ADMIN);
            statement.setString(1, admin.getLogin());
            statement.setString(2, admin.getPassword());
            statement.setString(3, admin.getSalt());
            statement.setString(4, admin.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public ClientsRequest getRequest(Client client) {
        ClientsRequest request = null;

        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLStatements.GET_REQUEST);
            ResultSet set = statement.executeQuery();
            request = RequestBuilder.createRequest(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return request;
    }

    @Override
    public void addRequest(ClientsRequest request) {
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(SQLStatements.ADD_REQUEST);
            statement.setInt(1, request.getId());
            statement.setString(2, request.getCargoType());
            statement.setString(3, request.getCourierLogin());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public Vehicle getVehicle(int id) {
        Vehicle vehicle = null;

        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLStatements.GET_VEHICLE);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            vehicle = VehicleBuilder.createVehicle(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicle;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {

    }
}