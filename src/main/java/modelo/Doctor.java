
package modelo;

/**
 *
 * @author Froyd-Melanie
 */
public class Doctor extends Funcionario{
    
    private int codigo;
    private String especialidad;
    
    public Doctor(){
        super();
        this.codigo=0;
        this.especialidad="";
    }

    public Doctor(int codigo, String especialidad) {
        this.codigo = codigo;
        this.especialidad = especialidad;
    }

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
    @Override
    public String toString() {
        String msg = super.toString();
        msg += "Codigo de medico: " +getCodigo();
        return msg;
    }
}
