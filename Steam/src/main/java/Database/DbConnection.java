/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe DbConnection
 * @author yodemis
 */


public class DbConnection {
    private static Connection connection;
    
    public static final String URL;
    private static String USER;
    private static String PASSWORD;
    
    static {
        URL = "jdbc:oracle:thin:@//200.131.242.43:1521/IFNMGPDB";
        USER = "yjs25681";
        PASSWORD = "yjsn";
    }

    private DbConnection() {
        
    }
    
    public static Connection getConnection() throws ClassNotFoundException {
        // Registrar o driver JDBC
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        if(connection == null){
            try {
                System.out.println(">> Nova conexão com banco de dados");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex){
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }     
}


