/**
 *
 * @author march
 */
package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;


public class CentroAtencionDAO{
    /**
     * 
     * @param pCodigo
     * @param pNombre
     * @param pLugar
     * @param pTipo
     * @param pCapacidad
     * @throws SQLException
     */
    public static void insertar(int pCodigo,String pNombre,String pLugar,String pTipo,int pCapacidad) throws SQLException{
        try {
            String urlConsulta = "{CALL insertarCentroAtencion(?,?,?,?,?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setInt("codigo", pCodigo);
            exe.setString("nombre", pNombre);
            exe.setString("tipo", pTipo);
            exe.setInt("capacidad", pCapacidad);
            exe.setString("lugar", pLugar);
            exe.execute();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static void obtener() throws SQLException {
        try {
            String urlConsulta = "{CALL getCentroAtencion()}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
        } catch (SQLException e) {
        }
    }
}
