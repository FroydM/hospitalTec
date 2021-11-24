/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
import dao.PacienteDAO;
import dao.AreaTrabajoDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import modelo.Doctor;
import modelo.Area;
import modelo.LinkedList;
import dao.TribunalSupremoEleccionesDAO;
/**
 *
 * @author march
 */
public class Aplicacion {
    public static void main(String[] args){
        
        try {
            PacienteDAO.annadirTelefono(117960697, 86875359);
            LinkedList<Integer> listado = PacienteDAO.obtenerTelefonosById(117960697);
            for(int index = 0; index < listado.getSize();index++) {
                System.out.println(listado.getElement(index).toString());
            }
            //TribunalSupremoEleccionesDAO.obtenerPacienteInfoByIdentificacion(117960697);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
