/**
 *
 * @author MARCHENA - MELANIE
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import modelo.Area;
import modelo.Doctor;
import modelo.LinkedList;
import modelo.TipoFuncionario;


public class DoctorDAO {
    /**
     * Este metodo se encarga de agregar un nuevo doctor a la 
     * base de dataos mediante un procedimiento de almacenado
     * @param identificacion Numero de cedula del doctor
     * @param nombre Nombre de doctor
     * @param apellido1 Primer apellido de doctor
     * @param apellido2 segundo apellido del doctor
     * @param tipo Tipo de funcionario
     * @param fechaIngreso Fecha de ingreso del funcionario
     * @param areaTrabajo Area de trabajo del funcionario
     * @param codigoMedico Codigo del doctor
     * @throws SQLException 
     */
    public static void insertar(int identificacion,String nombre,String apellido1,String apellido2,
            TipoFuncionario tipo,LocalDate fechaIngreso,int areaTrabajo,
            int codigoMedico) throws SQLException{
        try {
            String urlConsulta = "{? = CALL insertarDoctor(?,?,?,?,?,?,?,?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setInt("identificacion", identificacion);
            exe.setString("nombre", nombre);
            exe.setString("apellido1", apellido1);
            exe.setString("apellido2", apellido2);
            Date parseDate = Date.valueOf(fechaIngreso);
            exe.setDate("fechaIngreso", parseDate);
            exe.setString("tipo", "Doctor");
            exe.setInt("areaTrabajo", areaTrabajo);
            exe.setInt("codigoMedico", codigoMedico);
            exe.registerOutParameter(1, java.sql.Types.INTEGER);
            exe.execute();
            if(exe.getInt(1) ==0) {
                throw new SQLException("Ya existe doctor");
            }
            
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
    /**
     * Este metodo se encarga llamar el procedimiento de 
     * almacenado para obtener un listado de los doctores registrados
     * @return Listado de doctores registrados
     * @throws SQLException 
     */
    public static LinkedList<Doctor> obtener() throws SQLException{
        try {
            String urlConsulta = "{CALL allDoctores}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            ResultSet res = exe.executeQuery();
            LinkedList<Doctor> listado = null;
            if(res != null) {
                listado = new LinkedList<>();
                while(res.next()) {
                    Doctor tempDoctor = new Doctor();
                    tempDoctor.setCedula(res.getInt("identificacion"));
                    tempDoctor.setNombre(res.getString("nombre"));
                    tempDoctor.setApellido1(res.getString("apellido1"));
                    tempDoctor.setApellido2(res.getString("apellido2"));
                    tempDoctor.setFechaIngreso(res.getDate("fechaIngreso").toLocalDate());
                    tempDoctor.setTipo(TipoFuncionario.DOCTOR);
                    tempDoctor.setArea(new Area(res.getInt("idArea"),res.getString("nombreArea")));
                    tempDoctor.setCodigo(res.getInt("codigoMedico"));
                    listado.append(tempDoctor);
                }
            }
            return listado;
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
    /**
     * Este metodo agrega una especialidad al medico en la base de datos
     * @param codigoMedico Codigo del medico al que se realciona la especialidad
     * @param especialidad Nombre de la especialidad
     * @throws SQLException 
     */
    public static void annadirEspecialidad(int codigoMedico,String especialidad) throws SQLException {
        try {
            String urlConsulta = "{? = CALL addEspecialidadDoctor(?,?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setInt("codigoMedico", codigoMedico);
            exe.setString("nombreEspecialidad", especialidad);
            exe.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
    /**
     * Esta funcion se encarga de obtener las especialidades por medico
     * @param codigoMedico Codigo del medico para obtener las especialidades
     * @return Listado de las especialidades
     * @throws SQLException 
     */
    public static LinkedList<String> obtenerEspecialidadesByCodigoMedico(int codigoMedico) throws  SQLException {
        try {
            String urlConsulta = "{CALL allEspecialidadesByCodigoMedico(?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setInt("codigoMedico", codigoMedico);
            ResultSet res = exe.executeQuery();
            LinkedList<String> listado = null;
            if(res != null) {
                listado = new LinkedList<>();
                while(res.next()) {
                          
                    listado.append(res.getString("nombreEspecialidad"));
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
