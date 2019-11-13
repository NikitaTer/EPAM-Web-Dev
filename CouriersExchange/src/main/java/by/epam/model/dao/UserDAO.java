package by.epam.model.dao;

import by.epam.entity.User;
import by.epam.model.ConnectionPool;
import by.epam.model.builder.UsersBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDAO implements BasicDAO<String, User> {

    private static UserDAO instance = new UserDAO();
    private static final Logger logger = LogManager.getLogger();

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        return instance;
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
            logger.info("User " + user.get().getLogin() + " is found");
            return user;
        } catch (SQLException e) {
            logger.error(e.getMessage());
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
            statement.setString(5, user.getEmail());
            statement.setBoolean(6, user.isCourier());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> update(User user)  {
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLCommands.INSERT_USER);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(String s) {

    }
}
