/**
 *
 * @author march
 */
package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import modelo.Area;
import modelo.Cita;
import modelo.LinkedList;
import modelo.Paciente;
import modelo.TransaccionCita;
import modelo.Usuario;
import modelo.Persona;


public class CitaDAO {
    public static void insertar(int idCita,int idPaciente,int area, LocalDateTime fechaHora, String observacion,int idUsuario) throws SQLException{
        try {
            String urlConsulta = "{CALL registrarCita(?,?,?,?,?,?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setInt("idCita", idCita);
            exe.setInt("idPaciente", idPaciente);
            Timestamp timestamp = Timestamp.valueOf(fechaHora);
            exe.setTimestamp(observacion, timestamp);
            exe.setString("observacion", observacion);
            exe.setInt("user", idUsuario);
            exe.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
    
    public static void actualizar(int idCita,String estado,int idUsuario) throws SQLException{
        try {
            String urlConsulta = "{ ? = CALL actualizarCita(?,?,?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setInt("idCita", idCita);
            exe.setString("estado", estado);
            exe.setInt("user", idUsuario);
            exe.registerOutParameter(1, java.sql.Types.INTEGER);
            exe.execute();
            if(exe.getInt(1) ==0) {
                throw new SQLException("La cita esta muy proxima para ser eliminada");
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
    
    public static LinkedList<Cita> obtener() throws SQLException{
        try {
            String urlConsulta = "{CALL allCitas}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            ResultSet res = exe.executeQuery();
            LinkedList<Cita> listado = null;
            if(res != null) {
                listado = new LinkedList<>();
                while(res.next()) {
                    Cita tempCita = new Cita();
                    tempCita.setId(res.getInt("idCita"));
                    Paciente currentPaciente = new Paciente();
                    currentPaciente.setCedula(res.getInt("identificacion"));
                    currentPaciente.setNombre(res.getString("nombre"));
                    currentPaciente.setApellido1(res.getString("apellido1"));
                    currentPaciente.setApellido2(res.getString("apellido2"));
                    tempCita.setPaciente(currentPaciente);
                    Area currentArea = new Area();
                    currentArea.setNombre(res.getString("nombreArea"));
                    tempCita.setEspecialidad(currentArea);
                    tempCita.setFechaAtencion(res.getTimestamp("fechaHora").toLocalDateTime());
                    tempCita.setNota(res.getString("observacion"));
                    tempCita.setEstado(res.getString("estado"));
                    listado.append(tempCita);
                }
            }
            return listado;
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
    
    public static LinkedList<Cita> obtenerByIdentificacion(int idPaciente) throws SQLException{
        try {
            String urlConsulta = "{CALL allCitasByIdentificacion(?)}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            exe.setInt("idPaciente", idPaciente);
            ResultSet res = exe.executeQuery();
            LinkedList<Cita> listado = null;
            if(res != null) {
                listado = new LinkedList<>();
                while(res.next()) {
                    Cita tempCita = new Cita();
                    tempCita.setId(res.getInt("idCita"));
                    Paciente currentPaciente = new Paciente();
                    currentPaciente.setCedula(res.getInt("identificacion"));
                    currentPaciente.setNombre(res.getString("nombre"));
                    currentPaciente.setApellido1(res.getString("apellido1"));
                    currentPaciente.setApellido2(res.getString("apellido2"));
                    tempCita.setPaciente(currentPaciente);
                    Area currentArea = new Area();
                    currentArea.setNombre(res.getString("nombreArea"));
                    tempCita.setEspecialidad(currentArea);
                    tempCita.setFechaAtencion(res.getTimestamp("fechaHora").toLocalDateTime());
                    tempCita.setNota(res.getString("observacion"));
                    tempCita.setEstado(res.getString("estado"));
                    listado.append(tempCita);
                }
            }
            return listado;
        } catch (SQLException e) {
            throw e;
        } finally {
            ConfigurationSQL.close();
        }
    }
    
    public static LinkedList<TransaccionCita> obtenerCitalog() throws SQLException{
        try {
            String urlConsulta = "{CALL allCitaLog}";
            ConfigurationSQL.open();
            CallableStatement exe = ConfigurationSQL.cn.prepareCall(urlConsulta);
            ResultSet res = exe.executeQuery();
            LinkedList<TransaccionCita> listado = null;
            if(res != null) {
                listado = new LinkedList<>();
                while(res.next()) {
                    TransaccionCita tempTrans = new TransaccionCita();
                    Cita newCita = new Cita();
                    newCita.setId(res.getInt("idCita"));
                    tempTrans.setCita(newCita);
                    tempTrans.setFechaHora(res.getTimestamp("fechaHora").toLocalDateTime());
                    tempTrans.setEstadoAnterior(res.getString("estadoAnterior"));
                    tempTrans.setEstadoActual("estadoActualizado");
                    
                    Persona currentUsuario = new Usuario();
                    currentUsuario.setNombre(res.getString("nombre"));
                    currentUsuario.setApellido1(res.getString("apellido1"));
                    tempTrans.setUser(currentUsuario);
                    listado.append(tempTrans);
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
