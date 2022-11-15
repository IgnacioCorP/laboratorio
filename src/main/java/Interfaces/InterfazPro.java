/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import dominio.Departamento;
import dominio.Producto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface InterfazPro {
     public List<Producto> seleccionar() throws SQLException;
    public int insert(Producto object);     
    public int actualizar(Producto object);     
    public int eliminar(Producto object);    
}
