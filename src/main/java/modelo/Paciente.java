/**
 *
 * @author Froyd-Melanie
 */
package modelo;

import java.time.LocalDate;
import dao.PacienteDAO;
import dao.TribunalSupremoEleccionesDAO;
import java.sql.SQLException;

public class Paciente extends Persona{
    
    private LocalDate fechaNacimiento;
    private String tipoSangre;
    private String nacionaliad;
    private String residencia;
    private LinkedList<Integer> telefonos;
    private LinkedList<Vacuna> vacunas;
    private String correo;
    public Paciente(){
        super(0, "", "", "");
        this.fechaNacimiento=LocalDate.now();
        this.tipoSangre="";
        this.nacionaliad="";
        this.residencia="";
        this.telefonos=new LinkedList<>();
        this.vacunas=new LinkedList<>();
        this.correo = "";
    }

    public Paciente(LocalDate fechaNacimiento, String tipoSangre, String nacionaliad, String residencia, 
        int pCedula, String pNombre, String pApellido1, String pApellido2,String correo) {
        super(pCedula, pNombre, pApellido1, pApellido2);
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.nacionaliad = nacionaliad;
        this.residencia = residencia;
        this.telefonos=new LinkedList<>();
        this.vacunas =new LinkedList<>();
        this.correo = correo;
    }
    public boolean guardar() {
        try {
            PacienteDAO.insertar(getCedula(), getNombre(), getApellido1(), getApellido2(), getTipoSangre(), fechaNacimiento, nacionaliad, residencia, correo);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static LinkedList<Paciente> getListado() {
        try {
            return PacienteDAO.obtener();
        } catch (SQLException e) {
            return null;
        }
    }
    
    public boolean agregarTelefono(int telefono){
        try {
            PacienteDAO.annadirTelefono(getCedula(),telefono);
            actualizarTelefonos();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean agregarVacuna(String nombre,String famaceutica,String numeroLote) {
        try {
            PacienteDAO.annadirVacuna(getCedula(), LocalDate.now(), nombre, famaceutica, numeroLote);
            actulizarVacunas();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public void actualizarTelefonos() {
        try {
            telefonos = PacienteDAO.obtenerTelefonosById(getCedula());
        } catch (SQLException e) {
            System.out.println("Error al cargar telefonos");
        }
    }
    
    public void actulizarVacunas() {
        try {
            vacunas = PacienteDAO.obtenerVacunasById(getCedula());
        } catch (SQLException e) {
            System.out.println("Error al cargar vacunas");
        }
    }
    
    public static Paciente obtenerInfo(int cedula) {
        return TribunalSupremoEleccionesDAO.obtenerPacienteInfoByIdentificacion(cedula);
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

    public LinkedList<Integer> getTelefonos() {
        return telefonos;
    }

    public LinkedList<Vacuna> getVacunas() {
        return vacunas;
    }

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    @Override
   public String toString() {
       String msg = super.toString();
       msg += "Fecha Nacimiento: " +getFechaNacimiento().toString() + "\n";
       msg += "tipoSangre: "+getTipoSangre() + "\n";
       msg += "Nacionalidad: " +getNacionaliad() + "\n";
       msg += "Residencia: " +getResidencia() +"\n";
       msg += "Correo electronico:" + getCorreo() + "\n";
       return msg;
   }
}
