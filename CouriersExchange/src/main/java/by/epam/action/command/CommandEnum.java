package by.epam.action.command;

public enum  CommandEnum {
    SIGNIN {{this.command = new SignInCommand();}},
    LOGOUT {{this.command = new LogOutCommand();}},
    SIGNUP {{this.command = new SignUpCommand();}},
    VERIFY {{this.command = new VerifyCommand();}},
    ADD_REQUEST {{this.command = new AddRequestCommand();}};

    ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
