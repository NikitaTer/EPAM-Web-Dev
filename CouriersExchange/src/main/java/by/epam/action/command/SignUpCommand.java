package by.epam.action.command;

import by.epam.action.logic.SignUpLogic;
import by.epam.action.manager.ConfigurationManager;
import by.epam.action.manager.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements ActionCommand {

    private final static String PARAM_NAME_LOGIN = "login";
    private final static String PARAM_NAME_PASSWORD = "password";
    private final static String PARAM_NAME_NAME = "name";
    private final static String PARAM_NAME_EMAIL = "email";
    private final static String PARAM_NAME_USERTYPE = "userType";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String name = request.getParameter(PARAM_NAME_NAME);
        String email = request.getParameter(PARAM_NAME_EMAIL);
        String userType = request.getParameter(PARAM_NAME_USERTYPE);

        SignUpLogic logic = new SignUpLogic(login, password, name, email, userType.equals("courier"));

        if (!logic.isUserExist()) {
            logic.addNewUser();
            request.setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorMessage", MessageManager.getProperty("message.error.signup"));
            page = ConfigurationManager.getProperty("path.page.signUp");
        }

        return page;
    }
}
