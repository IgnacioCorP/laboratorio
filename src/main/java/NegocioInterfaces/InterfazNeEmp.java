/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NegocioInterfaces;

import dominio.Empleado;

/**
 *
 * @author Alumno Mañana
 */
public interface InterfazNeEmp {
    public Empleado sesion();
    public Empleado Login();
    public void menuAdmin(Empleado e);
    public void menuActualizar2(Empleado e);
    public void menuTablas(Empleado e);
    public void menuCrud(String entidad);
}
