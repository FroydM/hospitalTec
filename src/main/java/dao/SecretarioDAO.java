/**
 *
 * @author Froyd - Melanie
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import modelo.Area;
import modelo.Secretario;
import modelo.LinkedList;
import modelo.TipoFuncionario;

public class SecretarioDAO {
    public static void insertar(int identificacion,String nombre,String apellido1,String apellido2,
            TipoFuncionario tipo,LocalDate fechaIngreso,int areaTrabajo) throws SQLException{
        try {
            String urlConsulta = "{? = CALL insertarSecretario(?,?,?,?,?,?,?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setInt("identificacion", identificacion);
            exe.setString("nombre", nombre);
            exe.setString("apellido1", apellido1);
            exe.setString("apellido2", apellido2);
            Date parseDate = Date.valueOf(fechaIngreso);
            exe.setDate("fechaIngreso", parseDate);
            exe.setString("tipo", "Enfermero");
            exe.setInt("areaTrabajo", areaTrabajo);
            exe.registerOutParameter(1, java.sql.Types.INTEGER);
            exe.execute();
            if(exe.getInt(1) ==0) {
                throw new SQLException("Ya existe este secretario");
            }
            
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
    
    public static LinkedList<Secretario> obtener() throws SQLException{
        try {
            String urlConsulta = "{CALL allSecretarios}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            ResultSet res = exe.executeQuery();
            LinkedList<Secretario> listado = null;
            if(res != null) {
                listado = new LinkedList<>();
                while(res.next()) {
                    Secretario tempSecreatio = new Secretario();
                    tempSecreatio.setCedula(res.getInt("identificacion"));
                    tempSecreatio.setNombre(res.getString("nombre"));
                    tempSecreatio.setApellido1(res.getString("apellido1"));
                    tempSecreatio.setApellido2(res.getString("apellido2"));
                    tempSecreatio.setFechaIngreso(res.getDate("fechaIngreso").toLocalDate());
                    tempSecreatio.setTipo(TipoFuncionario.SECRETARIO);
                    tempSecreatio.setArea(new Area(res.getInt("idArea"),res.getString("nombreArea")));
                    listado.append(tempSecreatio);
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
