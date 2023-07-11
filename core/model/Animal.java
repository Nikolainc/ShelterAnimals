package core.model;

import java.util.List;
import java.util.Objects;

import core.enums.AnimalGroup;
import core.enums.AnimalType;
import core.service.interfaces.ICommand;

public abstract class Animal implements ICommand {

    private final int _id;
    private final String _name;
    private final String _birthday;
    private List<Command> _commands;
    private AnimalGroup _group;
    private AnimalType _type;
    private boolean _isNew = false;

    protected Animal(int id, String name, String birthday, AnimalType type, AnimalGroup group, List<Command> commands, boolean isNew){

        this(id,name,birthday,type,group,commands);
        this._isNew = isNew;

    }

    protected Animal(int id, String name, String birthday, AnimalType type, AnimalGroup group, List<Command> commands){

        this._id = id;
        this._name = name;
        this._birthday = birthday;
        this._commands = commands;
        this._group = group;
        this._type = type;

    }

    public int getId() {
        return this._id;
    }

    public String gName() {
        return this._name;
    }

    public String gBirthday() {
        return this._birthday;
    }

    public AnimalGroup gGroup() {
        return this._group;
    }

    public AnimalType gType() {
        return this._type;
    }

    public boolean isNew() {
        return this._isNew;
    }

    @Override
    public List<Command> getCommands() {
        return this._commands;
    }

    @Override
    public String toString() {

        return String.format("[ID: %s] [Name: %s] [Birthday: %s] [Type: %s] [Group: %s] [Commands: %s]", this._id, this._name, this._birthday, this._type.toString(), this._group.toString(), this._commands.size());
        
    }

    @Override
    public int hashCode() {
        
        return 13 * Objects.hash(this._id, this._name);

    }

    @Override
    public boolean equals(Object obj) {

        if (obj != null && obj.getClass() == this.getClass()) {

            return this._id == ((Animal) obj).getId();

        }

        return false;

    }

}