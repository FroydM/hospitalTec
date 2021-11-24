
package modelo;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.time.LocalDateTime;


/**
 *
 * @author Froyd-Melanie
 */
public class Cita {
    
    private int id;
    private Area especialidad;
    private LocalDateTime fechaAtencion;
    private String nota;
    private String estado;
    private Paciente paciente;
    public Cita(){
        this.id=0;
        this.especialidad= new Area();
        this.fechaAtencion=null;
        this.nota="";
        this.estado="";
        this.paciente = new Paciente();
    }
    /**
     * Constructor de objetos tipo Cita
     * @param id
     * @param especialidad
     * @param fechaAtencion
     * @param nota
     * @param estado
     * @param paciente
     */
    public Cita(int id, Area especialidad, LocalDateTime fechaAtencion, String nota, String estado,Paciente paciente) {
        this.id = id;
        this.especialidad = especialidad;
        this.fechaAtencion = fechaAtencion;
        this.nota = nota;
        this.estado = estado;
        this.paciente = paciente;
        
    }
   
    
    /**
     * Métodos accesores
     * @return 
     */
    public int getId() {
        return id;
    }

    public Area getEspecialidad() {
        return especialidad;
    }

    public LocalDateTime getFechaAtencion() {
        return fechaAtencion;
    }

    public String getNota() {
        return nota;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEspecialidad(Area especialidad) {
        this.especialidad = especialidad;
    }

    public void setFechaAtencion(LocalDateTime fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
    
    
    
    
}
