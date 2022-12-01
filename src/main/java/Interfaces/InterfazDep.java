/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import dominio.Departamento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface InterfazDep {
    
    public List<Departamento> seleccionar() throws SQLException;
    public List<Departamento> seleccionar2(String nombre) throws SQLException;
    public int insert(Departamento object);     
    public int actualizar(Departamento object);     
    public int eliminar(Departamento object);     
}
