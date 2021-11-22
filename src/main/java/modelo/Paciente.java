
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
    
    public Paciente(){
        this.fechaNacimiento=null;
        this.tipoSangre="";
        this.nacionaliad="";
        this.residencia="";
        this.telefono="";
        this.vacuna=null;
    }

    public Paciente(LocalDate fechaNacimiento, String tipoSangre, String nacionaliad, String residencia, 
            String telefono, Vacuna vacuna, int pCedula, String pNombre, String pApellido1, String pApellido2) {
        super(pCedula, pNombre, pApellido1, pApellido2);
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.nacionaliad = nacionaliad;
        this.residencia = residencia;
        this.telefono = telefono;
        this.vacuna = vacuna;
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
    
    
    
    
   
    
}
