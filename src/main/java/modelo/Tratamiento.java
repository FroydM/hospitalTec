
package modelo;

/**
 *
 * @author SITARE
 */
public class Tratamiento {
    
    private String nombre;
    private int dosis;
    private TipoTratamiento tratamiento;
    
    public Tratamiento(){
        this.nombre="";
        this.dosis=0;
        this.tratamiento=null;
    }

    public Tratamiento(String nombre, int dosis, TipoTratamiento tratamiento) {
        this.nombre = nombre;
        this.dosis = dosis;
        this.tratamiento = tratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDosis() {
        return dosis;
    }

    public TipoTratamiento getTratamiento() {
        return tratamiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public void setTratamiento(TipoTratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }
    
    
}
