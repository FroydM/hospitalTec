/**
 *
 * @author march
 */
package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;


public class TratamientoDAO {
    public static void insertar(String tratamiento,String cantidadDosis,String tipo) throws SQLException {
        try {
            String urlConsulta = "{CALL insertAreaTrabajo(?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setString("nombreTratamiento", tratamiento);
            exe.setString("nombreTratamiento", tratamiento);
            exe.setString("nombreTratamiento", tratamiento);
            exe.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
}
