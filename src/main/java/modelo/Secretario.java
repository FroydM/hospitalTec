/**
 *
 * @author Froyd - Melanie
 */
package modelo;

import java.time.LocalDate;
import dao.SecretarioDAO;
import java.sql.SQLException;

public class Secretario extends Funcionario{

    public Secretario() {
        super();
    }

    public Secretario(int pCedula, String pNombre, String pApellido1, String pApellido2, TipoFuncionario pTipo, LocalDate pFechaIngreso, Area pArea) {
        super(pCedula, pNombre, pApellido1, pApellido2, pTipo, pFechaIngreso, pArea);
    }
    
    public boolean guardar() {
        try {
            SecretarioDAO.insertar(getCedula(), getNombre(), getApellido1(), getApellido2(), TipoFuncionario.SECRETARIO, LocalDate.now(), getArea().getCodigo());
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static LinkedList<Secretario> getListado() {
        try {
            return SecretarioDAO.obtener();
        } catch (SQLException e) {
            return null;
        }
    }
    
}
