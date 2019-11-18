package by.epam.action.logic;

import by.epam.entity.User;
import by.epam.model.builder.UsersBuilder;
import by.epam.model.dao.UserDAO;

import java.util.Optional;

public class SignUpLogic {

    private User user = null;
    private boolean isExist = false;

    public SignUpLogic(String login, String password, String name, String email, boolean isCourier) {
        Optional<User> user = UserDAO.getInstance().find(login);
        if (user.isPresent()) {
            isExist = true;
        }

        this.user = UsersBuilder.build(login, password, name, email, isCourier);
    }

    public boolean isUserExist() {
        return isExist;
    }

    public void addNewUser() {
        UserDAO.getInstance().insert(user);
    }
}
