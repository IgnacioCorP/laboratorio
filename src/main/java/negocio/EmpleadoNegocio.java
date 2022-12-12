/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Interfaces.InterfazEmp;
import ManejoArchivos.ManejoDeArchivos;
import static MysqlTest.MysqlTest.ent;
import static MysqlTest.MysqlTest.menuAdmin;
import NegocioInterfaces.InterfazNeEmp;
import datos.EmpleadoDao;
import dominio.Empleado;
import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author Alumno Mañana
 */
public class EmpleadoNegocio implements InterfazNeEmp {

    Empleado EE = new Empleado();
    InterfazEmp empleadoDao = new EmpleadoDao();
    String nombreArchivo2 = "EMPLEADOS.txt";



    public Empleado sesion() {
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

    public Empleado Login() {
        System.out.println("INTRODUZCA NIF: ");
        Scanner niF = new Scanner(System.in);
        String niff = niF.nextLine();
        EE.setNif(niff);

        System.out.println("INTRODUZCA NOMBRE: ");
        Scanner Nombre = new Scanner(System.in);
        String Nombres = Nombre.nextLine();
        EE.setNombre(Nombres);

        System.out.println("INTRODUZCA APELLIDO: ");
        Scanner Apellido = new Scanner(System.in);
        String Apellidos = Apellido.nextLine();
        EE.setApellido(Apellidos);

        System.out.println("INTRODUZCA TELÉFONO: ");
        Scanner Telefono = new Scanner(System.in);
        String Telefonos = Telefono.nextLine();
        EE.setTelefono(Telefonos);

        System.out.println("INTRODUZCA DIRECCIÓN: ");
        Scanner Dir = new Scanner(System.in);
        String Direccion = Dir.nextLine();
        EE.setDireccion(Direccion);

        System.out.println("INTRODUZCA EMAIL: ");
        Scanner Email = new Scanner(System.in);
        String Emails = Email.nextLine();
        EE.setEmail(Emails);

        System.out.println("INTRODUZCA FECHA DE NACIMIENTO (AÑO-MES-DÍA): ");
        Scanner Fechs = new Scanner(System.in);
        Date fecs = Date.valueOf(Fechs.nextLine());
        EE.setFecha_Nac(fecs);

        System.out.println("CREE SU CONTRASEÑA: ");
        Scanner Clave = new Scanner(System.in);
        String Claves = Clave.nextLine();
        EE.setClave(Claves);

        System.out.println("=============USUARIO AÑADIDO CORRECTAMENTE=========================");

        empleadoDao.insert(EE);

        //LISTAR OBJETOS Y CREAR ARCHIVO
        //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
        ManejoDeArchivos.agregarArchivo(nombreArchivo2, EE.toString());
        ManejoDeArchivos.leerArchivo(nombreArchivo2);
        return null;
    }
}
