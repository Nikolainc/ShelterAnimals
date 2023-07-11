package core.model;

public class Command {

    private String _command;
    private String _description;
    private boolean _newCommand = false;
    private int _id;

    public Command(String command, String description, boolean isNew) {

        this(command, description);
        this._newCommand = isNew;

    }
    
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

    public int getId(){
        return this._id;
    }

    public boolean isNew() {
        return this._newCommand;
    }

    @Override
    public String toString() {

        return String.format("Command: %s, Description: %s", this._command, this._description);

    }
    
}
