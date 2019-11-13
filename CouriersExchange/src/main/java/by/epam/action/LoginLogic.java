package by.epam.action;

import by.epam.entity.User;
import by.epam.model.dao.UserDAO;

import java.util.Arrays;
import java.util.Optional;

public class LoginLogic {

    private User user = null;

    public LoginLogic() {

    }

    public void init(String login) {
        Optional<User> user = UserDAO.getInstance().find(login);
        user.ifPresent(value -> this.user = value);
    }

    public boolean isUserExist() {
        return user != null;
    }

    public boolean checkPassword(String password) {
        if (user != null) {
            return Arrays.equals(user.getPassword(), EncryptionLogic.encrypt(password, user.getSalt()));
        } else {
            return false;
        }
    }
}
