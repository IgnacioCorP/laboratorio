/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Interfaces.InterfazLab;
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Laboratorio;
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
public class LaboratorioDao implements InterfazLab{
    private static final String SQL_SELECT = "SELECT * FROM laboratorio";
    private static final String SQL_INSERT = "INSERT into laboratorio(ID_lab,Nombre_sede,Direccion,Telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE laboratorio SET Nombre_sede = ?, Direccion = ?, Telefono = ?where ID_lab = ?";
    private static final String SQL_DELETE = "DELETE FROM laboratorio where ID_lab = ?";
   
    //MÉTODO QUE NOS LISTA TODAS LOS CLIENTES DE NUESTRO SISTEMA Y LOS VISUALIZA

    public List<Laboratorio> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Laboratorio laboratorio = null;
        List<Laboratorio> laboratorios = new ArrayList<>();

        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();

        while (rs.next()) {
            int ID_lab = rs.getInt("ID_lab");
            String Nombre = rs.getString("Nombre_sede");
            String Direccion = rs.getString("Direccion");
            String Telefono = rs.getString("Telefono");
          
           
                                                                //INSTANCIAR OBJETO//
            laboratorios.add(new Laboratorio(ID_lab, Nombre, Direccion, Telefono));
        }
        close(rs);
        close(stmt);
        close(conn);

        return laboratorios;
    }

    //MÉTODO PARA INSERTAR CLIENTES EN MI SISTEMA
    public int insert(Laboratorio laboratorio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            //Establecer la conexión
            conn = getConnection();
            //Preparo mi instrucción para ejecutarlo con la base de datos
            stmt = conn.prepareStatement(SQL_INSERT);
            //Asignar los valores interrogantes ? de la consulta
            stmt.setInt(1, laboratorio.getID_lab());
            stmt.setString(2, laboratorio.getNombre_sede());
            stmt.setString(3, laboratorio.getDireccion());
            stmt.setString(4, laboratorio.getTelefono());
           

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
    public int actualizar(Laboratorio laboratorio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
         
           
            stmt.setString(1, laboratorio.getNombre_sede());
            stmt.setString(2, laboratorio.getDireccion());
            stmt.setString(3, laboratorio.getTelefono());
            stmt.setInt(4, laboratorio.getID_lab());

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

    //MÉTODO PARA ELIMINAR UNO DE LOS LABORATORIOS POR NIF
    public int eliminar(Laboratorio laboratorio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, laboratorio.getID_lab());

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
