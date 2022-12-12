/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import static MysqlTest.MysqlTest.ent;
import static MysqlTest.MysqlTest.menuAdmin;
import NegocioInterfaces.InterfazNeEmp;
import dominio.Empleado;

/**
 *
 * @author Alumno Mañana
 */
public class EmpleadoNegocio implements InterfazNeEmp{
    public Empleado sesion(){
        System.out.println("INTRODUZCA  NIF CON EL QUE SE REGISTRO: ");
        String NIF = ent.nextLine();
        String contraseña;
        //RECORRER LISTA DE EMPLEADOS MEDIANTE UN MÉTODO QUE SE HA CREADO EN LA CLASE EMPLEADO
        for (int i = 0; i < Empleado.listarEmpleadosDec().size(); i++) {
            //SI ESE EMPLEADO EXISTE, ENTRA EN LA CONDICIÓN
            if (NIF.equals(Empleado.listarEmpleadosDec().get(i).getNif())) {
                System.out.println("INTRODUZCA SU CONTRASEÑA: ");
                contraseña = ent.nextLine();
                //MIENTRAS LA CONTRASEÑA SEA INCORRECTA, VUELVA A INTRODUCIR LA CONTRASEÑA
                while (!contraseña.equals(Empleado.listarEmpleadosDec().get(i).getClave())) {
                    System.out.println("PORFAVOR INTRODUZCA DE NUEVO LA CONTRASEÑA: ");
                    contraseña = ent.nextLine();
                }

                menuAdmin(Empleado.listarEmpleadosDec().get(i));

            }
        }
        return null;
    }
}
