package by.epam.action.logic;

import by.epam.entity.User;
import by.epam.model.CodeUserStorage;
import by.epam.model.dao.UserDAO;

public class VerifyLogic {

    private String verifyCode;
    private String login;
    private User user;

    public VerifyLogic(String verifyCode, String login) {
        this.verifyCode = verifyCode;
        this.login = login;

        user = CodeUserStorage.getInstance().getUser(verifyCode);
    }

    public boolean isLoginCorrect() {
        return user != null && user.getLogin().equals(login);
    }

    public boolean isCodeCorrect() {
        return user != null;
    }

    public void addNewUser() {
        UserDAO.getInstance().insert(user);
    }
}
