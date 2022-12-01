
package negocio;

import static MysqlTest.MysqlTest.ent;
import NegocioInterfaces.InterfazNeCli;
import datos.ClienteDao;
import dominio.Cliente;
import java.sql.SQLException;
import java.util.List;



public class ClienteNegocio implements InterfazNeCli {

   public  List<Cliente> listarClientesDec() {
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> usuarios = null;

        try {
            usuarios = clienteDao.seleccionardesencriptar();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return usuarios;
    }
     
}
