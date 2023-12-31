package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import core.model.Command;
import core.model.Animal;

import core.service.interfaces.IDataProvider;

public class ConnectionDB implements IDataProvider {

    private StringBuilder _stringBuilder;

    public ConnectionDB() {

        this._stringBuilder = new StringBuilder();

    }

    @Override
    public String getRawData(ConfigData conf) {

        this._stringBuilder.setLength(0);

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());
            return e.toString();

        }

        
        
        String connectionUrl = "jdbc:mysql://" + conf.DATABASE_IP + ":" + conf.DATABASE_PORT + "/" + conf.USERS_DATABASE + "?serverTimezone=UTC";
        String sqlSelectAll = conf.USERS_GETDATA;
        
        try (Connection conn = DriverManager.getConnection(connectionUrl, conf.USER, conf.USER_PASSWORD); 
            
            PreparedStatement ps = conn.prepareStatement(sqlSelectAll); 
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                this._stringBuilder.append(rs.getString("id") + ";" + rs.getString("name") + ";" + rs.getString("Birthday") 
                + ";" + rs.getString("type") + ";" + rs.getString("group") /*+ ";" + rs.getString("command_id")
                 + ";" + rs.getString("description") */+ "\n");

            }

            return this._stringBuilder.toString();

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return e.toString();

        }

    }

    @Override
    public String getRawDataCommads(ConfigData conf) {

        this._stringBuilder.setLength(0);

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());
            return e.toString();

        }

        
        
        String connectionUrl = "jdbc:mysql://" + conf.DATABASE_IP + ":" + conf.DATABASE_PORT + "/" + conf.USERS_DATABASE + "?serverTimezone=UTC";
        String sqlSelectAll = "SELECT * FROM CommandAnimals, Commands WHERE CommandAnimals.command_id = Commands.command_id;";
        
        try (Connection conn = DriverManager.getConnection(connectionUrl, conf.USER, conf.USER_PASSWORD); 
            
            PreparedStatement ps = conn.prepareStatement(sqlSelectAll); 
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                this._stringBuilder.append(rs.getString("shelter_id") + ";" + rs.getString("command_id") + ";" + rs.getString("command") + ";" + rs.getString("description") + "\n");

            }

            return this._stringBuilder.toString();

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return e.toString();

        }

    }

    @Override
    public boolean setRawData(ConfigData conf, Animal value) {

        this._stringBuilder.setLength(0);

        if(value == null) {
            return false;
        }

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());
            return false;

        }

        String connectionUrl = "jdbc:mysql://" + conf.DATABASE_IP + ":" + conf.DATABASE_PORT + "/" + conf.USERS_DATABASE + "?serverTimezone=UTC";
        String [] sqlReq = PrepareSQLCommandInsert(conf, value).split("#");
        String sqlRequestInsert;

        for(String Request : sqlReq) {

            sqlRequestInsert = Request;
            System.out.println(Request);

            try (Connection conn = DriverManager.getConnection(connectionUrl, conf.USER, conf.USER_PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sqlRequestInsert);) {
            
                ps.executeUpdate();

            } 
            catch (SQLException e) 
            {

                System.out.println(e.getMessage());
                return false;

            }

        }

        return true;
        
    }

    private String PrepareSQLCommandInsert(ConfigData conf, Animal obj) {
        
        if(obj instanceof Animal) {

            if(obj.isNew()) {

                this._stringBuilder.append(conf.INSERT + conf.TABLE_SHELTERNIMALS + String.format("('%s','%s','%s');#", obj.gName(), obj.gType().getId(), obj.gBirthday())).toString();

            }

            for(Command com : obj.getCommands()) {

                if(com.isNew()){

                    this._stringBuilder.append(conf.INSERT + conf.TABLE_COMMANDS + String.format("('%s','%s','%s');#", com.getId(), com.gCommand(), com.gDescription()));
                    this._stringBuilder.append(conf.INSERT + conf.TABLE_ANIMALCOMMANDS + String.format("('%s','%s');", com.getAnimalId(), com.getId()));

                }

            }

            return this._stringBuilder.toString();
            
        }
        else {

            return "";

        }

    }

}
