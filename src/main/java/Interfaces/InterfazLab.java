/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import dominio.Laboratorio;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface InterfazLab {
    public List<Laboratorio> seleccionar() throws SQLException;
    public int insert(Laboratorio object);     
    public int actualizar(Laboratorio object);     
    public int eliminar(Laboratorio object);     
}
