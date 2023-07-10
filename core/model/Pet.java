package core.model;

import java.util.List;

import core.enums.AnimalGroup;
import core.enums.AnimalType;

public class Pet extends Animal {

    public Pet(int id, String name, String birthday, List<Command> commands, AnimalType type) {

        super(id, name, birthday, type, AnimalGroup.PET, commands);

    }
    
}
