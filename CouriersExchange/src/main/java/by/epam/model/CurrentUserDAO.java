package by.epam.model;

import by.epam.entity.Courier;
import by.epam.entity.User;
import by.epam.entity.UserRequest;
import by.epam.model.builder.CouriersBuilder;
import by.epam.model.builder.RequestBuilder;
import by.epam.model.builder.UsersBuilder;
import by.epam.model.dao.SQLCommands;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class CurrentUserDAO implements UserDAO {
    @Override
    public List<User> findAllUsers() {
        List<User> users = null;

        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLCommands.FIND_ALL_USERS);
            ResultSet set = statement.executeQuery();
            users = UsersBuilder.build(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public List<Courier> findAllCouriers() {
        List<Courier> couriers = null;

        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLCommands.FIND_ALL_COURIERS);
            ResultSet set = statement.executeQuery();
            couriers = CouriersBuilder.build(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return couriers;
    }

    @Override
    public Optional<Courier> findCourier(String login) {
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            Optional<Courier> courier;

            PreparedStatement statement = connection.prepareStatement(SQLCommands.FIND_COURIER);
            statement.setString(1, login);
            ResultSet set = statement.executeQuery();
            courier = Optional.of(CouriersBuilder.build(set).get(0));

            return courier;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> findUser(String login) {
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            Optional<User> user;

            PreparedStatement statement = connection.prepareStatement(SQLCommands.FIND_USER);
            statement.setString(1, login);
            ResultSet set = statement.executeQuery();
            user = Optional.of(UsersBuilder.build(set).get(0));

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<UserRequest> findRequest(int id) {
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            Optional<UserRequest> request;

            PreparedStatement statement = connection.prepareStatement(SQLCommands.FIND_REQUEST);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            request = Optional.of(RequestBuilder.build(set).get(0));

            return request;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void insert(User user) {
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(SQLCommands.INSERT_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getSalt());
            statement.setString(4, user.getName());
            statement.setInt(5, user.getRequestId());
            statement.setBoolean(6, user.isOnline());
            statement.setDate(7, Date.valueOf(user.getLastTimeSeen().toString()));
            statement.setBoolean(8, user.isAdmin());
            statement.setString(9, user.getEmail());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user, String[] params, String[] newValues) {
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {

            for (int i = 0; i < params.length; i++) {
                PreparedStatement statement = connection.prepareStatement(SQLCommands.UPDATE_USER);
                statement.setString(1, params[i]);
                statement.setString(2, newValues[i]);
                statement.setString(3, user.getLogin());
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(SQLCommands.DELETE_USER);
            statement.setString(1, user.getLogin());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addRequest(UserRequest request) {
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(SQLCommands.INSERT_REQUEST);
            statement.setInt(1, request.getId());
            statement.setString(2, request.getCargoType().toString());
            statement.setString(3, request.getCourierLogin());
            statement.setString(4, request.getVehicle());
            statement.setString(5, request.getCargoName());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
