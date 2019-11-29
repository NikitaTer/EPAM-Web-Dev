package by.epam.action.command;

import javax.servlet.http.HttpServletRequest;

public class VerifyCommand implements ActionCommand{

    private final static String PARAM_NAME_LOGIN = "login";
    private final static String PARAM_NAME_PASSWORD = "password";
    private final static String PARAM_NAME_NAME = "name";
    private final static String PARAM_NAME_EMAIL = "email";
    private final static String PARAM_NAME_USERTYPE = "userType";

    @Override
    public String execute(HttpServletRequest request) {
        return "";
    }
}
