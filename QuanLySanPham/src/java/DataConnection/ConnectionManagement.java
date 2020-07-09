/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author ASUS
 */
public class ConnectionManagement {
    private static Connection conn = null;
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if(conn != null){
            return conn;
        } else {
            Class.forName("com.mysql.jdbc.Driver");
            Properties connectionProps = new Properties();
            connectionProps.put("user","root");
            connectionProps.put("password","");
            String ConnectionString = "jdbc:mysql://localhost:3306/QuanLyHangHoa";
            conn = DriverManager.getConnection(ConnectionString, connectionProps);
            return conn;
        }
    }
}
