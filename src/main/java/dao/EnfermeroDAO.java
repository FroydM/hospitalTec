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
import modelo.LinkedList;
import modelo.Enfermero;
import modelo.TipoFuncionario;


public class EnfermeroDAO {
    public static void insertar(int identificacion,String nombre,String apellido1,String apellido2,
            TipoFuncionario tipo,LocalDate fechaIngreso,int areaTrabajo,
            boolean isCapacitacionExp, boolean isJefeExperiencia) throws SQLException{
        try {
            String urlConsulta = "{? = CALL insertarEnfermero(?,?,?,?,?,?,?,?,?)}";
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
            exe.setBoolean("isCapacitacionExperiencia", isCapacitacionExp);
            exe.setBoolean("isJefeExperiencia", isJefeExperiencia);
            exe.registerOutParameter(1, java.sql.Types.INTEGER);
            exe.execute();
            if(exe.getInt(1) ==0) {
                throw new SQLException("Ya existe enfermero");
            }
            
        } catch (SQLException e) {
            throw e;
        } finally {
            
        }
    }
    
    public static LinkedList<Enfermero> obtener() throws SQLException{
        try {
            String urlConsulta = "{CALL allEnfermeros}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            ResultSet res = exe.executeQuery();
            LinkedList<Enfermero> listado = null;
            if(res != null) {
                listado = new LinkedList<>();
                while(res.next()) {
                    Enfermero tempEnfermero = new Enfermero();
                    tempEnfermero.setCedula(res.getInt("identificacion"));
                    tempEnfermero.setNombre(res.getString("nombre"));
                    tempEnfermero.setApellido1(res.getString("apellido1"));
                    tempEnfermero.setApellido2(res.getString("apellido2"));
                    tempEnfermero.setFechaIngreso(res.getDate("fechaIngreso").toLocalDate());
                    tempEnfermero.setTipo(TipoFuncionario.ENFERMERO);
                    tempEnfermero.setArea(new Area(res.getInt("idArea"),res.getString("nombreArea")));
                    tempEnfermero.setExperiencia(res.getBoolean("isCapacitacionExperiencia"));
                    tempEnfermero.setPersonalAdjunto(res.getBoolean("isJefeExperiencia"));
                    listado.append(tempEnfermero);
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
