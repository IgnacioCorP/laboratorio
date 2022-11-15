/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Interfaces.InterfazPro;
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class ProductoDao implements InterfazPro {

    private static final String SQL_SELECT = "SELECT * FROM producto";
    private static final String SQL_INSERT = "INSERT into producto(ID_pro,Nombre,Precio,Fecha_caducidad) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE producto SET Nombre = ?, Precio = ?, Fecha_caducidad = ?  where ID_pro = ?";
    private static final String SQL_DELETE = "DELETE FROM producto where ID_pro = ?";

    //MÉTODO QUE NOS LISTA TODAS LOS CLIENTES DE NUESTRO SISTEMA Y LOS VISUALIZA
    public List<Producto> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto prodcuto = null;
        List<Producto> productos = new ArrayList<>();

        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();

        while (rs.next()) {
            int ID_pro = rs.getInt("ID_pro");
            String Nombre = rs.getString("Nombre");
            Double Precio = rs.getDouble("Precio");
            Date Fecha_caducidad = rs.getDate("Fecha_caducidad");

            //INSTANCIAR OBJETO//
            productos.add(new Producto(ID_pro, Nombre, Precio, Fecha_caducidad));
        }
        close(rs);
        close(stmt);
        close(conn);

        return productos;
    }

    //MÉTODO PARA INSERTAR CLIENTES EN MI SISTEMA
    public int insert(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            //Establecer la conexión
            conn = getConnection();
            //Preparo mi instrucción para ejecutarlo con la base de datos
            stmt = conn.prepareStatement(SQL_INSERT);
            //Asignar los valores interrogantes ? de la consulta
            stmt.setInt(1, producto.getID_pro());
            stmt.setString(2, producto.getNombre());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setDate(4, (java.sql.Date) producto.getFecha_caducidad());

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
    public int actualizar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setDate(3, (java.sql.Date) producto.getFecha_caducidad());
            stmt.setInt(4, producto.getID_pro());
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
    public int eliminar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, producto.getID_pro());

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
