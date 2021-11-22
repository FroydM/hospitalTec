
package modelo;

/**
 *
 * @author Froyd-Melanie
 */
public class Persona {
    private int cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    
    /**
     * Constructor de objetos tipo persona
     * @param pCedula
     * @param pNombre
     * @param pApellido1
     * @param pApellido2 
     */

    public Persona(int pCedula, String pNombre, String pApellido1, String pApellido2) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
    
    
}
