package core.service.interfaces;

import java.util.List;
import java.util.Map;

import core.model.Animal;
import core.model.Command;

public interface IDataManager<T extends Animal> {

    public Map<Integer, T> getAnimalList();

    public List<Command> getCommandsList();

    public boolean save(T objects);

    public boolean IsPass(String InputPass);
    
}
