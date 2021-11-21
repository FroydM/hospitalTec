
package modelo;

/**
 *
 * @author Froyd-Melanie
 */
public class Area {
    
    private int codigo;
    private String nombre;
    
    public Area (){
        this.codigo=0;
        this.nombre="";  
    }

    public Area(int pCodigo, String pNombre) {
        this.codigo = pCodigo;
        this.nombre = pNombre;
    
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
    
    
    
}
