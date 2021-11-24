
package modelo;

import dao.CitaDAO;
import java.sql.SQLException;
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
    
    public boolean asignarCita(int idCita,int user){
        try {
            CitaDAO.actualizar(idCita, "Asignada", user);
            return true;
        } catch (SQLException e) {
            return false;
        }
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
        switch(getTipo()){
            case DOCTOR:
                msg += "Tipo: Doctor \n";
                break;
            case ENFERMERO:
                msg += "Tipo: Enfermero \n";
                break;
            case SECRETARIO:
                msg += "Tipo: Secretario \n";
                break;
        }
        
        msg += "Fecha ingreso: " + getFechaIngreso().toString() + "\n";
        msg += "Area: { " + area.toString()+"}\n";
        return msg;
    }
}
