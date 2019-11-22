package by.command.impl;

import by.command.ActionCommand;
import by.manager.ConfigManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigManager.getProperty("path.page.login");
        return page;
    }
}
