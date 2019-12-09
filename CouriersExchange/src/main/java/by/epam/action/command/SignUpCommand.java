package by.epam.action.command;

import by.epam.action.logic.SignUpLogic;
import by.epam.action.mail.CodeGenerator;
import by.epam.action.mail.SendMail;
import by.epam.action.manager.ConfigurationManager;
import by.epam.action.manager.MessageManager;
import by.epam.model.CodeUserStorage;

import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements ActionCommand {

    private final static String PARAM_NAME_LOGIN = "login";
    private final static String PARAM_NAME_PASSWORD = "password";
    private final static String PARAM_NAME_REPEATPASSWORD = "repeatPassword";
    private final static String PARAM_NAME_EMAIL = "email";
    private final static String PARAM_NAME_USERTYPE = "userType";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String email = request.getParameter(PARAM_NAME_EMAIL);
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String repeatPassword = request.getParameter(PARAM_NAME_REPEATPASSWORD);
        String userType = request.getParameter(PARAM_NAME_USERTYPE);

        SignUpLogic logic = new SignUpLogic(login, password, repeatPassword, email, userType.equals("courier"));

        if (!logic.isPasswordCorrect()) {
            request.setAttribute("passwordMessage", MessageManager.getProperty("message.signUp.passwordMessage"));
            page = ConfigurationManager.getProperty("path.page.main");
        } else if (logic.isUserExist()) {
            request.setAttribute("loginMessage", MessageManager.getProperty("message.signUp.loginMessage"));
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            CodeGenerator generator = new CodeGenerator();
            CodeUserStorage.getInstance().putCodeUser(generator.getCode(), logic.getUser());
            SendMail.sendSignUpVerify(email,login,generator.getCode());
            request.getSession().setAttribute("login", login);
            request.getSession().setAttribute("verified", false);
            request.setAttribute("action", "forward");
            page = ConfigurationManager.getProperty("path.page.verify");
        }

        return page;
    }
}
