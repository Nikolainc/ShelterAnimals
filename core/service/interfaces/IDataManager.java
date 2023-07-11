package core.service.interfaces;

import java.util.Map;

import core.model.Animal;

public interface IDataManager<T extends Animal> {

    public Map<Integer, T> getList();

    public boolean save(T objects);

    public boolean IsPass(String InputPass);
    
}
