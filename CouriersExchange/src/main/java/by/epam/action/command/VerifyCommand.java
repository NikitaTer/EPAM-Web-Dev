package by.epam.action.command;

import by.epam.action.logic.VerifyLogic;
import by.epam.action.manager.ConfigurationManager;
import by.epam.action.manager.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class VerifyCommand implements ActionCommand{

    private final static String PARAM_NAME_LOGIN = "login";
    private final static String PARAM_NAME_VERIFYCODE = "verifyCode";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String verifyCode = request.getParameter(PARAM_NAME_VERIFYCODE);
        String login = (String) request.getSession().getAttribute(PARAM_NAME_LOGIN);

        VerifyLogic logic = new VerifyLogic(verifyCode, login);

        if (logic.isCodeCorrect()) {

            if (logic.isLoginCorrect()) {
                logic.addNewUser();
                request.getSession().setAttribute("verified", true);
                page = ConfigurationManager.getProperty("path.page.main");
            } else {
                page = ConfigurationManager.getProperty("path.page.main");
            }

        } else {
            request.setAttribute("verifyMessage", MessageManager.getProperty("message.verify.wrongCode"));
            page = ConfigurationManager.getProperty("path.page.main");
        }

        return page;
    }
}
