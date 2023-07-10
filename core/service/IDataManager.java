package core.service;

import java.util.List;

import core.model.Animal;

public interface IDataManager<T extends Animal> {

    public List<T> getList();

    public boolean saveList(List<T> objects);

    public boolean IsPass(String InputPass);
    
}
