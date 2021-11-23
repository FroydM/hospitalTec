
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Froyd-Melanie
 */
public class Paciente extends Persona{
    
    private LocalDate fechaNacimiento;
    private String tipoSangre;
    private String nacionaliad;
    private String residencia;
    private LinkedList<Integer> listaTelefono;
    private LinkedList<Vacuna> listaVacuna;
    
    public Paciente(){
        
        LinkedList<Integer> telefono = new LinkedList<>();
        LinkedList<Vacuna> vacuna = new LinkedList<>();
        
        this.fechaNacimiento=null;
        this.tipoSangre="";
        this.nacionaliad="";
        this.residencia="";
    }
    /**
     * Constructor de objetos tipo Paciente
     * @param pFechaNacimiento
     * @param pTipoSangre
     * @param pNacionaliad
     * @param pResidencia, lugar de vivienda
     * @param pTelefono
     * @param pVacuna
     * @param pCedula
     * @param pNombre
     * @param pApellido1
     * @param pApellido2 
     */

    public Paciente(LocalDate pFechaNacimiento, String pTipoSangre, String pNacionaliad, String pResidencia, 
            Integer pTelefono, Vacuna pVacuna, int pCedula, String pNombre, String pApellido1, String pApellido2) {
        super(pCedula, pNombre, pApellido1, pApellido2);
        
        LinkedList<Integer> listaTelefono = new LinkedList<>();
        LinkedList<Vacuna> listaVacuna = new LinkedList<>();
        
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.nacionaliad = nacionaliad;
        this.residencia = residencia;
        listaTelefono.append(pTelefono);
        listaVacuna.append(pVacuna);
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public String getNacionaliad() {
        return nacionaliad;
    }

    public String getResidencia() {
        return residencia;
    }
    //REVISAR SI ESTÁ BIEN **************************************************
    public Integer getTelefono() {
        try {
            return listaTelefono.getElement();
        } catch (Exception e) {
            return null;
        }
        
    }

    public Vacuna getVacuna() {
        try {
            return listaVacuna.getElement();
        } catch (Exception e) {
            return null;
        }
        
    }
    //FIN DE LA REVISIÓN *****************************************************
    
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public void setNacionaliad(String nacionaliad) {
        this.nacionaliad = nacionaliad;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }
//No se porque no funciona el metodo *************************************
    public void setTelefono(String telefono) {
        //listaTelefono.setElement(telefono);
    }

    public void setVacuna(Vacuna vacuna) {
        
    }
  //*********************************************************************** 
}
