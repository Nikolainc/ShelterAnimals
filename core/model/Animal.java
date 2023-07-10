package core.model;

import java.util.List;

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

    protected Animal(int id, String name, String birthday, List<Command> commands, AnimalGroup group, AnimalType type){

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

    @Override
    public List<Command> getCommands() {
        return this._commands;
    }

}