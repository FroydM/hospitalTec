/**
 *
 * @author march
 */
package aplicacion;
import modelo.CentroAtencion;
import modelo.LinkedList;
import dao.TribunalSupremoEleccionesDAO;
public class Aplicacion {
    public static void main(String[] args){
        
        try {
            
            /**CentroAtencion newCentro = new CentroAtencion("Hospital Mexico","Uruca,San jose",600,"Hospital");
            if(newCentro.guardar()){
                System.out.println("Exito al guardar area");
            }
            LinkedList<CentroAtencion> listado = CentroAtencion.getListado();
            for(int item =0; item< listado.getSize();item++){
                System.out.println(listado.getElement(item).toString());
            }**/
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
