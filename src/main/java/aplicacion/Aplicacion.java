/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
import dao.PacienteDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import modelo.Paciente;
import modelo.LinkedList;
/**
 *
 * @author march
 */
public class Aplicacion {
   /** public static void main(String[] args){
        
        try {
            //PacienteDAO.insertar(301881098, "Emilio", "Loria", "Vargas", "O-", LocalDate.of(1953, 01, 8), "Costarricense", "Cartago,Paraiso", "loria.emilio07@gmail.com");
            LinkedList<Paciente> listado = PacienteDAO.obtener();
            for(int index = 0; index < listado.getSize();index++) {
                System.out.println(listado.getElement(index).toString());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }**/
}
