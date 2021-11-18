/**
 *
 * @author march
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationSQL {
    protected static Connection cn;
    private static final String USER = "sa";
    private static final String PASSWORD = "Tek12345";
    
    /**
     * Metodo que abre la conexion con la base de datos
     * @throws SQLException 
     */
    protected static void open()throws SQLException{

        String url = "jdbc:sqlserver://localhost:1433;databaseName=dbSGPE;";
        
        cn = DriverManager.getConnection(url,USER,PASSWORD);     
    }
    /**
     * Metodo que cierra la conexion con la base de datos.
     * @throws SQLException 
     */
    protected static void close() {
        try {
            if(!cn.isClosed()){
                cn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
