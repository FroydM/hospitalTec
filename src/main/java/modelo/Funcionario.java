
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Froyd-Melanie
 */
public class Funcionario extends Persona {
  
    private String tipo;
    private LocalDate fechaIngreso;
    private Area area;
   
    
    public Funcionario(){
        super(0, "", "", "");
        this.tipo="";
        this.fechaIngreso= null;
    }
    
    /**
     * Constructor de objetos tipo funcionario
     *
     * @param pTipo, es el tipo de funcionario
     * @param pFechaIngreso, la fecha cuando ingresa a trabajar
     * @param pArea, el área mediaca a la que pertenece
     */

    public Funcionario(int pCedula, String pNombre, String pApellido1, String pApellido2, String pTipo,
            LocalDate pFechaIngreso, Area pArea) {
        
        super(pCedula,pNombre,pApellido1,pApellido2);
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
        this.area = area;
    }
    /**
     * Metodos accesores
     * 
     */   

    public String getTipo() {
        return tipo;
    }

    public Area getArea() {
        return area;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
}
