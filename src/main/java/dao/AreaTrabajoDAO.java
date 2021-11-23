/**
 *
 * @author Froyd and Melanie
 */
package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Area;
import modelo.LinkedList;


public class AreaTrabajoDAO {
    /**
     * Este metodo llamara a un procedimiento en la base de datos y inserta una area
     * @param nombre Nombre del area de trabajo
     * @throws SQLException 
     */
    public static void insertar(String nombre)throws SQLException {
        try {
            String urlConsulta = "{CALL insertAreaTrabajo(?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setString("nombre", nombre);
            exe.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
    /**
     * Este metodo llama al procedimiento en la base de datos y genera un listado de las areas existentes
     * @return Listado de areas existentes
     * @throws SQLException 
     */
    public static LinkedList<Area> obtener() throws SQLException {
        try {
            String urlConsulta = "{CALL allAreaTrabajo}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            ResultSet res = exe.executeQuery();
            LinkedList<Area> listado = null;
            if(res != null) {
                listado = new LinkedList<>();
                while(res.next()) {
                    listado.append(new Area(res.getInt("id"),res.getString("nombre")));
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
