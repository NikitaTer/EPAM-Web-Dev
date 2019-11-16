package by.epam.action.command;

public enum  CommandEnum {
    LOGIN {{this.command = new LogInCommand();}},
    LOGOUT {{this.command = new LogOutCommand();}},
    SIGNUP {{this.command = new SignUpCommand();}};

    ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
