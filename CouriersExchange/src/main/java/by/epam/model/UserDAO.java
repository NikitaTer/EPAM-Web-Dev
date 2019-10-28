package by.epam.model;

import by.epam.entity.Courier;
import by.epam.entity.User;
import by.epam.entity.UserRequest;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<User> findAllUsers();
    List<Courier> findAllCouriers();
    Optional<Courier> findCourier(String login);
    Optional<User> findUser(String login);
    Optional<UserRequest> findRequest(int id);

    void insert(User user);
    void update(User user);
    void delete(User user);

    void addRequest(UserRequest request);
}
