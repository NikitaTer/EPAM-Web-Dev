package by.epam.action.logic;

import by.epam.action.EncryptionLogic;
import by.epam.entity.User;
import by.epam.model.dao.UserDAO;

import java.util.Arrays;
import java.util.Optional;

public class LoginLogic {

    private User user = null;
    private String password;

    public LoginLogic(String login, String password) {
        Optional<User> user = UserDAO.getInstance().find(login);
        user.ifPresent(value -> this.user = value);
        this.password = password;
    }

    public boolean isUserExist() {
        return user != null;
    }

    public boolean checkPassword() {
        if (user != null) {
            return Arrays.equals(user.getPassword(), EncryptionLogic.encrypt(password, user.getSalt()));
        } else {
            return false;
        }
    }
}
