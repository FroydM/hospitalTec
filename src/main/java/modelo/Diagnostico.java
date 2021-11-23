
package modelo;

/**
 *
 * @author SITARE
 */
public class Diagnostico {
    
    private String nombre;
    private String nivel;
    private Tratamiento tratamiento;
    
    /**
     * Constructor de objetos tipo Diagnostico
     */
    public Diagnostico(){
        this.nombre="";
        this.nivel="";
        this.tratamiento=null;
    }

    public Diagnostico(String nombre, String nivel,Tratamiento tratamiento) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tratamiento = tratamiento;
    }
    /**
     * Métodos accesores
     *  
     */
    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    
    
}
