package core.service;

import java.sql.SQLException;

import sql.ConfigData;


public interface IDataProvider {

    public String getRawData(ConfigData conf) throws SQLException;

    public String setRawData(ConfigData conf) throws SQLException;
    
}
