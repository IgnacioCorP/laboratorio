/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Interfaces.InterfazDep;
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class DepartamentoDao implements InterfazDep {
    private static final String SQL_SELECT = "SELECT * FROM departamento";
    private static final String SQL_INSERT = "INSERT into departamento(ID_dep, Nombre, Descripcion) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE departamento SET Nombre = ?, Descripcion = ? where ID_dep = ?";
    private static final String SQL_DELETE = "DELETE FROM departamento where ID_dep = ?";
   
    //MÉTODO QUE NOS LISTA TODAS LOS CLIENTES DE NUESTRO SISTEMA Y LOS VISUALIZA

    public List<Departamento> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Departamento departamento = null;
        List<Departamento> departamentos = new ArrayList<>();

        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();

        while (rs.next()) {
            int ID_dep = rs.getInt("ID_dep");
            String Nombre = rs.getString("Nombre");
            String Descripcion = rs.getString("Descripcion");
          
           
                                                                //INSTANCIAR OBJETO//
            departamentos.add(new Departamento(ID_dep, Nombre, Descripcion));
        }
        close(rs);
        close(stmt);
        close(conn);

        return departamentos;
    }

    //MÉTODO PARA INSERTAR CLIENTES EN MI SISTEMA
    public int insert(Departamento departamento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            //Establecer la conexión
            conn = getConnection();
            //Preparo mi instrucción para ejecutarlo con la base de datos
            stmt = conn.prepareStatement(SQL_INSERT);
            //Asignar los valores interrogantes ? de la consulta
            stmt.setInt(1, departamento.getID_dep());
            stmt.setString(2, departamento.getNombre());
            stmt.setString(3, departamento.getDescripcion());
           

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
    public int actualizar(Departamento departamento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
         
           
            
            stmt.setString(1, departamento.getNombre());
            stmt.setString(2, departamento.getDescripcion());
             stmt.setInt(3, departamento.getID_dep());

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
    public int eliminar(Departamento departamento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, departamento.getID_dep());

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
