package by.epam.action.command;

import by.epam.action.manager.ConfigurationManager;
import by.epam.action.logic.LoginLogic;
import by.epam.action.manager.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class LogInCommand implements ActionCommand {

    private final static String PARAM_NAME_LOGIN = "login";
    private final static String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        LoginLogic logic = new LoginLogic(login, password);

        if (logic.isUserExist() && logic.checkPassword()) {
            request.setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorMessage", MessageManager.getProperty("message.error.login"));
            page = ConfigurationManager.getProperty("path.page.logIn");
        }

        return page;
    }
}
