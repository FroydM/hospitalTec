
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
    @Override
    public String toString() {
        String msg = super.toString();
        msg += "Experiencia Capacitaciones: " + getExperiencia()+"\n";
        msg += "Experiencia en adminstracion de personal: "+getPersonalAdjunto() + "\n";
        return msg;
    }
}
