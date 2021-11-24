/**
 *
 * @author Froyd-Melanie
 */
package modelo;

import dao.AreaTrabajoDAO;
import java.sql.SQLException;
public class Area {
    
    private int codigo;
    private String nombre;
    
    public Area (){
        this.codigo=0;
        this.nombre="";  
    }
    
    /**
     * Constructor de objetos tipo Área
     * @param pCodigo
     * @param pNombre 
     */
    public Area(int pCodigo, String pNombre) {
        this.codigo = pCodigo;
        this.nombre = pNombre;
    
    }

    
    /**
     * Métodos de accesoros
     * 
     */

    public boolean guardar() {
        try {
            AreaTrabajoDAO.insertar(nombre);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static LinkedList<Area> getListado() {
        try {
            return AreaTrabajoDAO.obtener();
        } catch (SQLException e) {
            return null;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString(){
        String msg = "Codigo: "+getCodigo()+"\n";
        msg += "Nombre: " +getNombre()+"\n";
        return msg;
    }
    
    
}
