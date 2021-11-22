/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
import dao.CentroAtencionDAO;
import java.sql.SQLException;
import modelo.CentroAtencion;
import modelo.LinkedList;
/**
 *
 * @author march
 */
public class Aplicacion {
    public static void main(String[] args){
        try {
            LinkedList<CentroAtencion> listado = CentroAtencionDAO.obtener();
            for(int index = 0; index < listado.getSize();index++) {
                System.out.println(listado.getElement(index).toString());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
