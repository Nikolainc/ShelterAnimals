package core.model;

public class Command {

    private String _command;
    private String _description;

    public Command(String command, String description) {

        this._command = command;
        this._description = description;

    }

    public String gCommand() {
        return this._command;
    }

    public String gDescription() {
        return this._description;
    }

    @Override
    public String toString() {

        return String.format("Command: %s, Description: %s", this._command, this._description);

    }
    
}
