package by.epam.model;

import by.epam.entity.Courier;
import by.epam.entity.User;
import by.epam.entity.UserRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CurrentUserDAO implements UserDAO {
    @Override
    public List<User> findAllUsers() {
        List<User> users = null;

        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement =connection.prepareStatement(SQLCommands.GET_ALL_USERS);
            ResultSet set =statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Courier> findAllCouriers() {
        return null;
    }

    @Override
    public Optional<Courier> findCourier(String login) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findUser(String login) {
        return Optional.empty();
    }

    @Override
    public Optional<UserRequest> findRequest(int id) {
        return Optional.empty();
    }

    @Override
    public void insert(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void addRequest(UserRequest request) {

    }
}
