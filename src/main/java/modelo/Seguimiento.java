
package modelo;

import java.time.LocalDate;

/**
 *
 * @author SITARE
 */
public class Seguimiento {
    
    private LocalDate fechaSeguimiento;
    private Funcionario funcionario;
    private String observacion;
    private Tratamiento tratamiento;
    
    public Seguimiento(){
        this.fechaSeguimiento=null;
        this.funcionario=null;
        this.observacion="";
        this.tratamiento=null;
    }

    public Seguimiento(LocalDate fechaSeguimiento, Funcionario funcionario, String observacion, Tratamiento tratamiento) {
        this.fechaSeguimiento = fechaSeguimiento;
        this.funcionario = funcionario;
        this.observacion = observacion;
        this.tratamiento = tratamiento;
    }

    public LocalDate getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getObservacion() {
        return observacion;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setFechaSeguimiento(LocalDate fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }
    
    
    
}
