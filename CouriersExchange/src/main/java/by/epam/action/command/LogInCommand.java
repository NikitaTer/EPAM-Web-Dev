package by.epam.action.command;

import javax.servlet.http.HttpServletRequest;

public class LogInCommand implements ActionCommand {

    private final static String PARAM_NAME_LOGIN = "login";
    private final static String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
    }
}
