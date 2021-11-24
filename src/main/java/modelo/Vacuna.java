
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Froyd-Melanie
 */
public class Vacuna {
    
    private String nombre;
    private String farmaceutica;
    private String lote;
    private LocalDate fechaAplicación;
    
    public Vacuna(){
        this.nombre="";
        this.farmaceutica="";
        this.lote="";
        this.fechaAplicación= null;
    }

    public Vacuna(String nombre, String farmaceutica, String lote, LocalDate fechaAplicación) {
        this.nombre = nombre;
        this.farmaceutica = farmaceutica;
        this.lote = lote;
        this.fechaAplicación = fechaAplicación;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFarmaceutica() {
        return farmaceutica;
    }

    public String getLote() {
        return lote;
    }

    public LocalDate getFechaAplicación() {
        return fechaAplicación;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFarmaceutica(String farmaceutica) {
        this.farmaceutica = farmaceutica;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setFechaAplicación(LocalDate fechaAplicación) {
        this.fechaAplicación = fechaAplicación;
    }
    
    
    
  
    
    
}
