
package datos;

import Interfaces.InterfazEmp;
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Empleado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDao implements InterfazEmp {
     private static final String SQL_SELECT = "SELECT * FROM empleado";
    private static final String SQL_INSERT = "INSERT into empleado(Nif,Nombre,Apellido,Telefono,Direccion,Email,Fecha_nac) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET Nombre = ?, Apellido = ?, Telefono = ?, Direccion = ?, Email = ?, Fecha_Nac = ?   where Nif = ?";
    private static final String SQL_DELETE = "DELETE FROM empleado where Nif = ?";
   
    //MÉTODO QUE NOS LISTA TODAS LOS CLIENTES DE NUESTRO SISTEMA Y LOS VISUALIZA

    public List<Empleado> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        List<Empleado> clientes = new ArrayList<>();

        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();

        while (rs.next()) {
            String Nif = rs.getString("Nif");
            String Nombre = rs.getString("Nombre");
            String Apellido = rs.getString("Apellido");
            String Telefono = rs.getString("Telefono");
            String Direccion = rs.getString("Direccion");
            String Email = rs.getString("Email");
            Date Fecha_Nac = rs.getDate("Fecha_Nac");
                                                                //INSTANCIAR OBJETO//
            clientes.add(new Empleado(Nif, Nombre, Apellido, Telefono, Direccion, Email, Fecha_Nac));
        }
        close(rs);
        close(stmt);
        close(conn);

        return clientes;
    }

    //MÉTODO PARA INSERTAR CLIENTES EN MI SISTEMA
    public int insert(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            //Establecer la conexión
            conn = getConnection();
            //Preparo mi instrucción para ejecutarlo con la base de datos
            stmt = conn.prepareStatement(SQL_INSERT);
            //Asignar los valores interrogantes ? de la consulta
            stmt.setString(1, empleado.getNif());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getApellido());
            stmt.setString(4, empleado.getTelefono());
            stmt.setString(5, empleado.getDireccion());
            stmt.setString(6, empleado.getEmail());
            stmt.setDate(7, (java.sql.Date) empleado.getFecha_Nac());

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
    public int actualizar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
         
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setString(3, empleado.getTelefono());
            stmt.setString(4, empleado.getDireccion());
            stmt.setString(5, empleado.getEmail());
            stmt.setDate(6,  empleado.getFecha_Nac());
            stmt.setString(7, empleado.getNif());

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
    public int eliminar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, empleado.getNif());

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
