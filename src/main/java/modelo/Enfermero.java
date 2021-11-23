
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Froyd-Melanie
 */
public class Enfermero extends Funcionario{
    
    private boolean personalAdjunto;
    private boolean experiencia;
    
    public Enfermero(){
        this.personalAdjunto=false;
        this.experiencia=false;
    }
    /**
     * Constructor de objetos tipo Enfermero
     * @param personalAdjunto, indica si el enfermero tiene personal a cargo.
     * @param experiencia, indica si tienen experiencia en capacitaciones.
     * @param pCedula
     * @param pNombre
     * @param pApellido1
     * @param pApellido2
     * @param pTipo
     * @param pFechaIngreso
     * @param pArea 
     */
    public Enfermero(boolean personalAdjunto, boolean experiencia, int pCedula, String pNombre, String pApellido1, String pApellido2, TipoFuncionario pTipo, LocalDate pFechaIngreso, Area pArea) {
        super(pCedula, pNombre, pApellido1, pApellido2, pTipo, pFechaIngreso, pArea);
        this.personalAdjunto = personalAdjunto;
        this.experiencia = experiencia;
    }

    public boolean getPersonalAdjunto() {
        return personalAdjunto;
    }

    public boolean getExperiencia() {
        return experiencia;
    }

    public void setPersonalAdjunto(boolean personalAdjunto) {
        this.personalAdjunto = personalAdjunto;
    }

    public void setExperiencia(boolean experiencia) {
        this.experiencia = experiencia;
    }
    
    
    
    
    
}
