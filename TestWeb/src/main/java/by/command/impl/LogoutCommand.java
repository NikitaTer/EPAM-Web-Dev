package by.command.impl;

import by.command.ActionCommand;
import by.manager.ConfigManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigManager.getProperty("path.page.index");

        request.getSession().invalidate();
        return page;
    }
}
