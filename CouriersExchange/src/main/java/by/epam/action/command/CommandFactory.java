package by.epam.action.command;

import by.epam.action.manager.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {

    public static ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand command = new EmptyCommand();
        String action = request.getParameter("command");

        if (action == null || action.isEmpty()) {
            return command;
        }

        try {
            command = CommandEnum.valueOf(action.toUpperCase()).getCommand();
        } catch (IllegalArgumentException ex) {
            request.setAttribute("errorMessage", action + MessageManager.getProperty("message.wrongAction"));
        }

        return command;
    }
}
