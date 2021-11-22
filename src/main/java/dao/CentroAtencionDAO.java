/**
 *
 * @author march
 */
package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import modelo.LinkedList;
import modelo.CentroAtencion;

public class CentroAtencionDAO{
    /**
     * El metodo se encarga de llamar al procedimiento a la base de datos 
     * para almacenar la informacion del centro de atencion
     * @param pCodigo
     * @param pNombre
     * @param pLugar
     * @param pTipo
     * @param pCapacidad
     * @throws SQLException
     */
    public static void insertar(String pNombre,String pLugar,String pTipo,int pCapacidad) throws SQLException{
        try {
            String urlConsulta = "{CALL insertarCentroAtencion(?,?,?,?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setString("nombre", pNombre);
            exe.setString("tipo", pTipo);
            exe.setInt("capacidad", pCapacidad);
            exe.setString("lugar", pLugar);
            exe.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
    /**
     * 
     * @throws SQLException 
     */
    public static LinkedList<CentroAtencion> obtener() throws SQLException {
        try {
            String urlConsulta = "{CALL allCentroAtencion}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            ResultSet res = exe.executeQuery();
            LinkedList<CentroAtencion> listado = null;
            if(res != null) {
                listado = new LinkedList<>();
                while(res.next()) {
                    listado.append(new CentroAtencion(res.getInt("codigo"), res.getString("nombre"),
                            res.getString("lugar"), res.getInt("capacidad"), res.getString("tipo")));
                }
            }
            return listado;
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
}
