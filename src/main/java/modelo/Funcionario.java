
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Froyd-Melanie
 */
public class Funcionario extends Persona {
  
    private TipoFuncionario tipo;
    private LocalDate fechaIngreso;
    private Area area;
   
    
    public Funcionario (){
        super(0, "", "", "");
        this.tipo=null;
        this.fechaIngreso= null;
    }
    
    /**
     * Constructor de objetos tipo funcionario
     *
     * @param pTipo, es el tipo de funcionario
     * @param pFechaIngreso, la fecha cuando ingresa a trabajar
     * @param pArea, el área mediaca a la que pertenece
     */

    public Funcionario(int pCedula, String pNombre, String pApellido1, String pApellido2, TipoFuncionario pTipo,
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

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public Area getArea() {
        return area;
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public LocalDate getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setArea(Area area) {
        this.area = area;
    }
    
    @Override
    public String toString() {
        String msg = super.toString();
        msg += "Tipo: " +getTipo() + "\n";
        msg += "Fecha ingreso: " + getFechaIngreso().toString() + "\n";
        msg += "Area: { " + area.toString()+"}\n";
        return msg;
    }
}
