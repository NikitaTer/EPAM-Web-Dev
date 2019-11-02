package by.epam.model.dao;

import by.epam.entity.User;
import by.epam.model.ConnectionPool;
import by.epam.model.builder.UsersBuilder;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.ObjPtr;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDAO implements BasicDAO<String, User> {

    private static final UserDAO instance = new UserDAO();

    public UserDAO() {
    }

    @Override
    public List<User> findAll() {
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
    public Optional<User> find(String login) {
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLCommands.FIND_USER);
            statement.setString(1, login);
            ResultSet set = statement.executeQuery();
            Optional<User> user = Optional.of(UsersBuilder.build(set).get(0));
            return user;
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
    public Optional<User> update(User user) {
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLCommands.UPDATE_USER);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String s) {

    }
}
