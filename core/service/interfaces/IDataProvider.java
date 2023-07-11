package core.service.interfaces;

import core.model.Animal;
import sql.ConfigData;


public interface IDataProvider {

    public String getRawData(ConfigData conf);

    public boolean setRawData(ConfigData conf, Animal value);

    public String getRawDataCommads(ConfigData conf);
    
}
