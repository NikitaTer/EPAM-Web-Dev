package by.epam.action.command;

import by.epam.action.manager.ConfigurationManager;
import by.epam.action.logic.LoginService;
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
        LoginService service = new LoginService(login, password);

        if (service.isUserExist() && service.checkPassword()) {
            request.getSession().setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorMessage", MessageManager.getProperty("message.error.login"));
            page = ConfigurationManager.getProperty("path.page.logIn");
        }

        return page;
    }
}
