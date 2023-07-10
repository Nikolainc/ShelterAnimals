package core.model;

import java.util.List;

import core.enums.AnimalGroup;
import core.enums.AnimalType;

public class PackAnimal extends Animal {

    public PackAnimal(int id, String name, String birthday, List<Command> commands, AnimalType type) {

        super(id, name, birthday, commands, AnimalGroup.PACKANIMAL, type);

    }
    
}
