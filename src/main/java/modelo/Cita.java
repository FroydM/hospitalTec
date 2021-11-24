
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Froyd-Melanie
 */
public class Cita {
    
    private int id;
    private Area especialidad;
    private LocalDate fechaAtencion;
    private String nota;
    private String estado;
    
    public Cita(){
        this.id=0;
        this.especialidad=null;
        this.fechaAtencion=null;
        this.nota="";
        this.estado="";
    }
    /**
     * Constructor de objetos tipo Cita
     * @param id
     * @param especialidad
     * @param fechaAtencion
     * @param nota
     * @param estado 
     */
    public Cita(int id, Area especialidad, LocalDate fechaAtencion, String nota, String estado) {
        this.id = id;
        this.especialidad = especialidad;
        this.fechaAtencion = fechaAtencion;
        this.nota = nota;
        this.estado = estado;
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

    public LocalDate getFechaAtencion() {
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

    public void setFechaAtencion(LocalDate fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
}
