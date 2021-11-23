
package modelo;

/**
 *
 * @author Froyd-Melanie
 */
public class Doctor {
    
    private int codigo;
    private String especialidad;
    
    public Doctor(){
        this.codigo=0;
        this.especialidad="";
    }
    /**
     * Constructor de objetos de tipo Doctor
     * @param codigo, representa el código del doctor
     * @param especialidad, es la especialidad del doctor
     */
    public Doctor(int codigo, String especialidad) {
        this.codigo = codigo;
        this.especialidad = especialidad;
    }
    /**
     * Métodos accesores
     *  
     */
    public int getCodigo() {
        return codigo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
}
