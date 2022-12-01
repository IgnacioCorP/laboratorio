/* ENTIDAD CLIENTE - COMPRA PRODUCTOS */
package dominio;

import Interfaces.InterfazCli;
import static MysqlTest.MysqlTest.ent;
import datos.ClienteDao;
import java.sql.Date;
import java.util.Objects;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nicolas Correa
 */
public class Cliente implements Serializable {

    private String Nif;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Email;
    private Date Fecha_nac;
    private String Clave;

    public Cliente() {
    }

    public Cliente(String Nif, String Nombre, String Apellido, String Telefono, String Email, Date Fecha_nac, String Clave) {
        this.Nif = Nif;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Fecha_nac = Fecha_nac;
        this.Clave = Clave;
    }

    public Cliente(String Nif, String Clave) {
        this.Nif = Nif;
        this.Clave = Clave;
    }

    public String getNif() {
        return Nif;
    }

    public void setNif(String Nif) {
        this.Nif = Nif;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getFecha_nac() {
        return Fecha_nac;
    }

    public void setFecha_nac(Date Fecha_nac) {
        this.Fecha_nac = Fecha_nac;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.Nif);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.Nif, other.Nif)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "%" + Nif + "/" + Nombre + "/" + Apellido + "/" + Telefono + "/" + Email + "/" + Fecha_nac + "/" + Clave;
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

    public static List<Cliente> listarClientesDec() {
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> usuarios = null;

        try {
            usuarios = clienteDao.seleccionardesencriptar();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return usuarios;
    }
/*
    public static Cliente sesion() {
        //RECORRER LISTA DE EMPLEADOS MEDIANTE UN MÉTODO QUE SE HA CREADO EN LA CLASE CLIENTE
        System.out.println("INTRODUZCA  NIF CON EL QUE SE REGISTRO: ");
        String nif = ent.nextLine();
        String clave;
        Cliente cliente = null;
        for (int i = 0; i < listarClientesDec().size(); i++) {
            //SI ESE CLIENTE EXISTE, ENTRA EN LA CONDICIÓN
            if (nif.equals(listarClientesDec().get(i).getNif())) {
                System.out.println("INTRODUZCA SU CONTRASEÑA: ");
                clave = ent.nextLine();
                //MIENTRAS LA CONTRASEÑA SEA INCORRECTA, VUELVA A INTRODUCIR LA CONTRASEÑA
                while (!clave.equals(listarClientesDec().get(i).getClave())) {
                    System.out.println("PORFAVOR INTRODUZCA DE NUEVO LA CONTRASEÑA: ");
                    clave = ent.nextLine();
                }
                cliente = listarClientesDec().get(i);

            }
        }
        return cliente;

    }*/

}
