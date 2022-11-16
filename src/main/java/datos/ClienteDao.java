/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Interfaces.InterfazCli;
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class ClienteDao implements InterfazCli {
    
    private static final String SQL_SELECT = "SELECT * FROM cliente";
    private static final String SQL_INSERT = "INSERT into cliente(Nif,Nombre,Apellido,Telefono,Email,Fecha_nac,Clave) VALUES(?,?,?,?,?,?,AES_ENCRYPT(?,'key'))";
    private static final String SQL_UPDATE = "UPDATE cliente SET Nombre = ?, Apellido = ?, Telefono = ?, Email = ?, Fecha_nac = ?, Clave = AES_ENCRYPT(?,'key')  where Nif = ?";
    private static final String SQL_DELETE = "DELETE FROM cliente where Nif = ?";
    private static final String SQL_DECRYPT = "SELECT Nif, Nombre, Apellido,Telefono,Email,Fecha_nac,CAST(AES_DECRYPT(Clave,'key')AS CHAR)AS Clave FROM cliente";
    
  

   
    //MÉTODO QUE NOS LISTA TODAS LOS CLIENTES DE NUESTRO SISTEMA Y LOS VISUALIZA

    public List<Cliente> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        
        rs = stmt.executeQuery();
        

        while (rs.next()) {
            String Nif = rs.getString("Nif");
            String Nombre = rs.getString("Nombre");
            String Apellido = rs.getString("Apellido");
            String Telefono = rs.getString("Telefono");
            String Email = rs.getString("Email");
            Date Fecha_nac = rs.getDate("Fecha_nac");
            String Clave = rs.getString("Clave");
            //INSTANCIAR OBJETO//
            clientes.add(new Cliente(Nif, Nombre, Apellido, Telefono, Email, Fecha_nac, Clave));
        }
        close(rs);
        close(stmt);
        close(conn);

        return clientes;
    }
    public List<Cliente> seleccionardesencriptar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        conn = getConnection();
        stmt = conn.prepareStatement(SQL_DECRYPT);
        
        rs = stmt.executeQuery();
        

        while (rs.next()) {
            String Nif = rs.getString("Nif");
            String Nombre = rs.getString("Nombre");
            String Apellido = rs.getString("Apellido");
            String Telefono = rs.getString("Telefono");
            String Email = rs.getString("Email");
            Date Fecha_nac = rs.getDate("Fecha_nac");
            String Clave = rs.getString("Clave");
            //INSTANCIAR OBJETO//
            clientes.add(new Cliente(Nif, Nombre, Apellido, Telefono, Email, Fecha_nac, Clave));
        }
        close(rs);
        close(stmt);
        close(conn);

        return clientes;
    }

    //MÉTODO PARA INSERTAR CLIENTES EN MI SISTEMA
    public int insert(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            //Establecer la conexión
            conn = getConnection();
            //Preparo mi instrucción para ejecutarlo con la base de datos
            stmt = conn.prepareStatement(SQL_INSERT);
            //Asignar los valores interrogantes ? de la consulta
            stmt.setString(1, cliente.getNif());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellido());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getEmail());
            stmt.setDate(6, (java.sql.Date) cliente.getFecha_nac());
            stmt.setString(7, cliente.getClave());
            //Ejecuto la query
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    //MÉTODO DONDE ACTUALIZAREMOS UN CLIENTE DE NUESTRA COLECCIÓN
    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
         
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getEmail());
            stmt.setDate(5,  cliente.getFecha_nac());
            stmt.setString(6,  cliente.getClave());
            stmt.setString(7, cliente.getNif());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;
    }

    //MÉTODO PARA ELIMINAR UNO DE LOS CLIENTES POR NIF
    public int eliminar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, cliente.getNif());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;
    }
}
