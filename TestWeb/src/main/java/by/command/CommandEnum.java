package by.command;

import by.command.impl.LoginCommand;
import by.command.impl.LogoutCommand;

public enum  CommandEnum {

    LOGIN {{this.command = new LoginCommand();}},
    LOGOUT {{this.command = new LogoutCommand();}};

    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
