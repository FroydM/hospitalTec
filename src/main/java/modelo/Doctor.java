/**
 *
 * @author Froyd-Melanie
 */
package modelo;

import dao.DoctorDAO;
import java.sql.SQLException;
import java.time.LocalDate;

public class Doctor extends Funcionario{
    
    private int codigo;
    private LinkedList<String> especialidad;
    
    public Doctor(){
        super();
        this.codigo=0;
        this.especialidad=new LinkedList<>();
    }

    public Doctor(int codigo) {
        this.codigo = codigo;
        this.especialidad =new LinkedList<>();
    }
    /**
     * Se encarga de almacenar el objeto en la base de datos
     * @return True: Si funciona todo correctamente & False: Si existe un error;
     */
    public boolean guardar(){
        try {
            DoctorDAO.insertar(getCedula(), getNombre(), getApellido1(), getApellido2(),
                    getTipo(), getFechaIngreso(), getArea().getCodigo(), codigo);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    /**
     * Extrae de la base de datos todos los objetos de tipo doctor
     * @return Listado de todos los doctores registrados
     */
    public static LinkedList<Doctor> getListado() {
        try {
            return DoctorDAO.obtener();
        } catch (SQLException e) {
            return null;
        }
    }
    
    public boolean agregarEspecialidad(String pNombreEspecialidad) {
        try {
            DoctorDAO.annadirEspecialidad(codigo, pNombreEspecialidad);
            actualizarEspecialidades();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public void actualizarEspecialidades() {
        try {
            especialidad = DoctorDAO.obtenerEspecialidadesByCodigoMedico(codigo);
        } catch (SQLException e) {
            System.out.println("Error al actualizar especialidad");
        }
    }
    public int getCodigo() {
        return codigo;
    }

    public LinkedList<String> getEspecialidad() {
        return especialidad;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        String msg = super.toString();
        msg += "Codigo de medico: " +getCodigo();
        return msg;
    }
}
