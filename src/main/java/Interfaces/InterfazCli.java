/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import dominio.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface InterfazCli {
    public List<Cliente> seleccionar() throws SQLException;
    public int insert(Cliente object);     
    public int actualizar(Cliente object);     
    public int eliminar(Cliente object);    
}
