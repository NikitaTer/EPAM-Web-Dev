package by.epam.action.logic;

import by.epam.entity.User;
import by.epam.model.builder.UsersBuilder;
import by.epam.model.dao.UserDAO;

import java.util.Optional;

public class SignUpLogic {

    private User user = null;
    private boolean isExist = false;
    private boolean isPasswordCorrect;

    public SignUpLogic(String login, String password, String repeatPassword, String email, boolean isCourier) {
        Optional<User> user = UserDAO.getInstance().find(login);
        if (user.isPresent()) {
            isExist = true;
        }

        isPasswordCorrect = password.equals(repeatPassword);
        this.user = UsersBuilder.build(login, password, email, isCourier);
    }

    public boolean isUserExist() {
        return isExist;
    }

    public boolean isPasswordCorrect() {
        return isPasswordCorrect;
    }

    public User getUser() {
        return user;
    }
}
