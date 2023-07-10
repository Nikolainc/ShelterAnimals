package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.service.IDataProvider;

public class ConnectionDB implements IDataProvider {

    private StringBuilder _stringBuilder;

    public ConnectionDB() {

        this._stringBuilder = new StringBuilder();

    }

    @Override
    public String getRawData(ConfigData conf) {

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            return e.toString();

        }

        
        
        String connectionUrl = "jdbc:mysql://" + conf.DATABASE_IP + ":" + conf.DATABASE_PORT + "/" + conf.USERS_DATABASE + "?serverTimezone=UTC";
        String sqlSelectAll = conf.USERS_GETDATA;
        
        try (Connection conn = DriverManager.getConnection(connectionUrl, conf.USER, conf.USER_PASSWORD); 
            
            PreparedStatement ps = conn.prepareStatement(sqlSelectAll); 
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                this._stringBuilder.append(rs.getString("id") + ";" + rs.getString("name") 
                + ";" + rs.getString("type") + ";" + rs.getString("group") + ";" + rs.getString("command") 
                + ";" + rs.getString("description") + "\n");

            }

            return this._stringBuilder.toString();

        } catch (SQLException e) {

            return e.toString();

        }

    }

    @Override
    public String setRawData(ConfigData conf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRawData'");
    }

}
