
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Froyd-Melanie
 */
public class Paciente extends Persona{
    
    private LocalDate fechaNacimiento;
    private String tipoSangre;
    private String nacionaliad;
    private String residencia;
    private String telefono;
    private Vacuna vacuna;
    private String correo;
    public Paciente(){
        super(0, "", "", "");
        this.fechaNacimiento=null;
        this.tipoSangre="";
        this.nacionaliad="";
        this.residencia="";
        this.telefono="";
        this.vacuna=null;
    }

    public Paciente(LocalDate fechaNacimiento, String tipoSangre, String nacionaliad, String residencia, 
        int pCedula, String pNombre, String pApellido1, String pApellido2,String correo) {
        super(pCedula, pNombre, pApellido1, pApellido2);
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.nacionaliad = nacionaliad;
        this.residencia = residencia;
        this.telefono = null;
        this.vacuna = null;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public String getNacionaliad() {
        return nacionaliad;
    }

    public String getResidencia() {
        return residencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public void setNacionaliad(String nacionaliad) {
        this.nacionaliad = nacionaliad;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    @Override
   public String toString() {
       String msg = super.toString();
       msg += "Fecha Nacimiento: " +getFechaNacimiento().toString() + "\n";
       msg += "tipoSangre: "+getTipoSangre() + "\n";
       msg += "Nacionalidad: " +getNacionaliad() + "\n";
       msg += "Residencia: " +getResidencia() +"\n";
       msg += "Correo electronico:" + getCorreo() + "\n";
       return msg;
   }
}
