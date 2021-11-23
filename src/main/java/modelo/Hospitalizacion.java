
package modelo;

import java.time.LocalDate;

/**
 *
 * @author SITARE
 */
public class Hospitalizacion {
    
    private CentroAtencion centro;
    private Paciente paciente; // no estoy segura si así o poner nombre y cedula como dice la especificación
    private Diagnostico diagnostico;
    private LocalDate fechaHospitalizacion;
    private String especialidad;
    private Funcionario funcionario;
    private LinkedList<Seguimiento> seguimiento;
    
    public Hospitalizacion(){
        seguimiento= new LinkedList<>();
        this.centro=null;
        this.paciente=null;
        this.diagnostico=null;
        this.fechaHospitalizacion=null;
        this.especialidad="";
        this.funcionario=null;
    }

    public Hospitalizacion(CentroAtencion centro, Paciente paciente, Diagnostico diagnostico, 
            LocalDate fechaHospitalizacion, String especialidad, Funcionario funcionario, 
            Seguimiento pSeguimiento) {
        seguimiento= new LinkedList<>();
        this.centro = centro;
        this.paciente = paciente;
        this.diagnostico = diagnostico;
        this.fechaHospitalizacion = fechaHospitalizacion;
        this.especialidad = especialidad;
        this.funcionario = funcionario;
        seguimiento.append(pSeguimiento);
    }

    public CentroAtencion getCentro() {
        return centro;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public LocalDate getFechaHospitalizacion() {
        return fechaHospitalizacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public LinkedList<Seguimiento> getSeguimiento() {
        return seguimiento;
    }

    public void setCentro(CentroAtencion centro) {
        this.centro = centro;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setFechaHospitalizacion(LocalDate fechaHospitalizacion) {
        this.fechaHospitalizacion = fechaHospitalizacion;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setSeguimiento(LinkedList<Seguimiento> seguimiento) {
        this.seguimiento = seguimiento;
    }
    
    
    
    
    
    
    
}
