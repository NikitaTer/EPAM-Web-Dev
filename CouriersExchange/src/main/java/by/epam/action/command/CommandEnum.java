package by.epam.action.command;

public enum  CommandEnum {
    LOGIN {{this.command = new LogInCommand();}},
    LOGOUT {{this.command = new LogOutCommand();}},
    SIGNUP {{this.command = new SignUpCommand();}},
    VERIFY {{this.command = new SignUpCommand();}},
    ADD_REQUEST {{this.command = new AddRequestCommand();}};

    ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
