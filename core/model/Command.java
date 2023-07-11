package core.model;

public class Command {

    private String _command;
    private String _description;
    private boolean _newCommand = false;
    private int _animal_id;
    private int _id;

    public Command(String command, String description, boolean isNew, int animalid, int id) {

        this(command, description, isNew, animalid);
        this._id = id;

    }

    public Command(String command, String description, boolean isNew, int animalid) {

        this(command, description, isNew);
        this._animal_id = animalid;

    }

    public Command(String command, String description, boolean isNew) {

        this(command, description);
        this._newCommand = isNew;

    }
    
    public Command(String command, String description) {

        this._command = command;
        this._description = description;

    }

    public Command() {

        this._command = "Незнает команд";
        this._description = "Необученное животное";
        this._newCommand = true;
        this._animal_id = 5;

    }

    public String gCommand() {
        return this._command;
    }

    public String gDescription() {
        return this._description;
    }

    public int getAnimalId(){
        return this._animal_id;
    }

    public int getId(){
        return this._id;
    }

    public boolean isNew() {
        return this._newCommand;
    }

    @Override
    public String toString() {

        return String.format("[%s] [Animal: %s] Command: %s, Description: %s", this._id, this._animal_id, this._command, this._description);

    }
    
}
