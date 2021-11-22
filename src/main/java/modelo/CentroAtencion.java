/**
 *
 * @author march
 */
package modelo;
 import dao.CentroAtencionDAO;
import java.sql.SQLException;

public class CentroAtencion {
    private int codigo;
    private String nombre;
    private String lugar;
    private int capacidad;
    private String tipo;

    public CentroAtencion() {
        this.codigo = 0;
        this.nombre = "";
        this.lugar = "";
        this.capacidad = 0;
        this.tipo = "";
    }
    
    public CentroAtencion(int codigo, String nombre, String lugar, int capacidad, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.lugar = lugar;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }
    
    public boolean guardar() {
        try {
            CentroAtencionDAO.insertar(nombre, lugar, tipo, capacidad);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        String msg;
        msg = "Codigo: "+getCodigo()+"\n";
        msg += "Nombre: " + getNombre() +"\n";
        msg += "Lugar: " + getLugar() +"\n";
        msg += "Tipo: " + getTipo() +"\n";
        msg += "Capacidad: " + getCapacidad() +"\n";
        return msg;
    }
    
    
    
    
}
