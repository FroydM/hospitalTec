/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

/**
 *
 * @author march
 */
public class DoctorDAO {
    public static void insertar(int identificacion,String nombre,String apellido1,String apellido2,
            String tipo,LocalDate fechaIngreso,int areaTrabajo,
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
            exe.setString("tipo", tipo);
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
            
        }
    }
    
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
                    tempDoctor.setTipo(res.getString("tipo"));
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
}
