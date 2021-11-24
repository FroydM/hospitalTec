
/**
 *
 * @author Marchena and Froyd
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import modelo.LinkedList;
import modelo.Paciente;
import modelo.Vacuna;

public class PacienteDAO {
    /**
     * Este metodo se encarga de llamar el procedimiento de almacenado a la base de datos 
     * @param identificacion Numero de cedula del paciente
     * @param nombre Primero nombre del paciente
     * @param apellido1 Primero apellido del paciente
     * @param apellido2 Segundo apellido del paciente
     * @param tipoSangre Tipo de Sangre del paciente
     * @param fechaNacimiento Fecha de nacimiento del paciente
     * @param nacionalidad Nacionalidad del paciente
     * @param lugarResidencia lugar Residencia del paciente (Provincia,Distrito)
     * @param correo Correo electronico del paciente
     * @throws SQLException 
     */
    public static void insertar(int identificacion,String nombre,String apellido1,String apellido2,
            String tipoSangre,LocalDate fechaNacimiento,String nacionalidad,String lugarResidencia,String correo) throws SQLException{
        try {
            String urlConsulta = "{CALL insertPaciente(?,?,?,?,?,?,?,?,?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setInt("identificacion", identificacion);
            exe.setString("nombre", nombre);
            exe.setString("apellido1", apellido1);
            exe.setString("apellido2", apellido2);
            Date parseDate = Date.valueOf(fechaNacimiento);
            exe.setDate("fechaNacimiento", parseDate);
            exe.setString("tipoSangre", tipoSangre);
            exe.setString("nacionalidad", nacionalidad);
            exe.setString("lugarResidencia", lugarResidencia);
            exe.setString("correo", correo);
            exe.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
    /**
     * Esta metodo se encarga de agregar un numero de telefono a un paciente
     * @param identificacion Numero de cedula del paciente
     * @param numeroTelefono Numero de telefono del paciente
     * @throws SQLException 
     */
    public static void annadirTelefono(int identificacion,int numeroTelefono) throws SQLException{
        try {
            String urlConsulta = "{CALL addTelefono(?,?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setInt("identificacion", identificacion);
            exe.setInt("telefono", numeroTelefono);
            exe.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
    /**
     * Este metodo se encarga de llamar a procedimiento de almacenado 
     * para guardar la informacion de la vacunacion de un paciente
     * @param identificacion Numero de cedula del paciente
     * @param fechaAplicacion Fecha en que se aplico la vacuna
     * @param nombreVacuna Nombre de la vacuna
     * @param farmaceutica Nombre de la farmaceutica de la vacuna
     * @param numeroLote Numero de lote de la dosis
     * @throws SQLException 
     */
    public static void annadirVacuna(int identificacion, LocalDate fechaAplicacion,
            String nombreVacuna,String farmaceutica,String numeroLote) throws SQLException {
        try {
            String urlConsulta = "{CALL addVacuna(?,?,?,?,?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setInt("identificacion", identificacion);
            exe.setString("nombre ", nombreVacuna);
            exe.setString("farmaceutica", farmaceutica);
            exe.setString("numeroLote", numeroLote);
            Date parseDate = Date.valueOf(fechaAplicacion);
            exe.setDate("fechaAplicacion", parseDate);
            exe.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    
    }
    
    /**
     * Este metodo se encarga de obtener los numeros de telefono de los pacientes
     * @param identificacion Numero de cedula del paciente
     * @return Listado de los numeros de telefono
     * @throws SQLException 
     */
    public static LinkedList<Integer> obtenerTelefonosById(int identificacion) throws SQLException {
        try {
            String urlConsulta = "{CALL allTelefonosByIdentificacion(?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setInt("idPaciente", identificacion);
            ResultSet res = exe.executeQuery();
            LinkedList<Integer> listado = null;
            if(res !=null){
                listado = new LinkedList<>();
                while(res.next()){
                    listado.append(res.getInt("numeroTelefono"));
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
     * Este metodo se encarga de obtener todas las vacunas de un paciente desde la base de datos
     * @param identificacion Numero de cedula del paciente
     * @return Listado de la vacunas
     * @throws SQLException 
     */
    public static LinkedList<Vacuna> obtenerVacunasById(int identificacion) throws SQLException{
        try {
            String urlConsulta = "{CALL allVacunasByIdentificacion(?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setInt("idPaciente", identificacion);
            ResultSet res = exe.executeQuery();
            LinkedList<Vacuna> listado = null;
            if(res !=null){
                listado = new LinkedList<>();
                while(res.next()){
                    Vacuna newVacuna = new Vacuna();
                    newVacuna.setNombre(res.getString("nombre"));
                    newVacuna.setFarmaceutica(res.getString("farmaceutica"));
                    newVacuna.setLote(res.getString("numeroLote"));
                    listado.append(newVacuna);
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
     * Este metodo se encarga de llamara al procedimiento a la base 
     * de datos y obtiene la informacion de todos los pacientes 
     * @return Listado de todos los pacientes
     * @throws SQLException
     */
    public static LinkedList<Paciente> obtener() throws SQLException{
        try {
            String urlConsulta = "{CALL allPacientes}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            ResultSet res = exe.executeQuery();
            LinkedList<Paciente> listado = null;
            if(res != null) {
                listado = new LinkedList<>();
                while(res.next()) {
                    Paciente tempPaciente = new Paciente();
                    tempPaciente.setCedula(res.getInt("identificacion"));
                    tempPaciente.setNombre(res.getString("nombre"));
                    tempPaciente.setApellido1(res.getString("apellido1"));
                    tempPaciente.setApellido2(res.getString("apellido2"));
                    tempPaciente.setFechaNacimiento(res.getDate("fechaNacimiento").toLocalDate());
                    tempPaciente.setTipoSangre(res.getString("tipoSangre"));
                    tempPaciente.setNacionaliad(res.getString("nacionalidad"));
                    tempPaciente.setResidencia(res.getString("lugarResidencia"));
                    tempPaciente.setCorreo(res.getString("correo"));
                    listado.append(tempPaciente);
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
