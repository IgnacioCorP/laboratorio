/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NegocioInterfaces;

import dominio.Cliente;
import java.util.List;


/**
 *
 * @author Alumno Mañana
 */
public interface InterfazNeCli {
    public  List<Cliente> listarClientesDec();
    public List<Cliente> listarClientes();
    public Cliente sesion();
    public Cliente Login();
    public void menuUsuario(Cliente c);
    public  void menuActualizar(Cliente c);
}
