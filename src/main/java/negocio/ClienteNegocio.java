package negocio;

import static MysqlTest.MysqlTest.ent;
import static MysqlTest.MysqlTest.menuUsuario;
import NegocioInterfaces.InterfazNeCli;
import datos.ClienteDao;
import dominio.Cliente;
import java.sql.SQLException;
import java.util.List;

public class ClienteNegocio implements InterfazNeCli {

    public List<Cliente> listarClientesDec() {
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> usuarios = null;

        try {
            usuarios = clienteDao.seleccionardesencriptar();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return usuarios;
    }

    public List<Cliente> listarClientes() {
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> usuarios = null;

        try {
            clienteDao.seleccionar();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return usuarios;
    }

    public Cliente sesion() {
        //RECORRER LISTA DE EMPLEADOS MEDIANTE UN MÉTODO QUE SE HA CREADO EN LA CLASE CLIENTE
        System.out.println("INTRODUZCA  NIF CON EL QUE SE REGISTRO: ");
        String nif = ent.nextLine();
        String clave;
        Cliente cliente = null;
        boolean existe = false;

        for (int i = 0; i < listarClientesDec().size(); i++) {
            //SI ESE CLIENTE EXISTE, ENTRA EN LA CONDICIÓN
            if (nif.equals(listarClientesDec().get(i).getNif())) {
                System.out.println("INTRODUZCA SU CONTRASEÑA: ");
                clave = ent.nextLine();
                existe = true;
                //MIENTRAS LA CONTRASEÑA SEA INCORRECTA, VUELVA A INTRODUCIR LA CONTRASEÑA
                while (!clave.equals(listarClientesDec().get(i).getClave())) {
                    System.out.println("PORFAVOR INTRODUZCA DE NUEVO LA CONTRASEÑA: ");
                    clave = ent.nextLine();
                }
                menuUsuario(listarClientesDec().get(i));
                
                //cliente = listarClientesDec().get(i);

            }
  
        }
        if(existe == false){
            System.out.println("ESTE USUARIO NO EXISTE");
        }
        return cliente;

    }
}
