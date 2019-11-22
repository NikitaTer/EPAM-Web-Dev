package by.command.impl;

import by.command.ActionCommand;
import by.manager.ConfigManager;
import by.manager.MessageManager;
import by.service.LoginService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        if (LoginService.checkLogin(login, pass)) {
            request.setAttribute("user", login);

            page = ConfigManager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigManager.getProperty("path.page.login");
        }
        return page;
    }
}
