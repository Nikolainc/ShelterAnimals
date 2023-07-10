package core.service;

import java.util.Map;

import core.model.Animal;

public interface IDataManager<T extends Animal> {

    public Map<Integer, T> getList();

    public boolean saveList(Map<Integer, T> objects);

    public boolean IsPass(String InputPass);
    
}
