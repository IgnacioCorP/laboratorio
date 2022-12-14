/*EJECUCIÓN DE MÉTODOS*/
package MysqlTest;

import Interfaces.InterfazCli;
import Interfaces.InterfazDep;
import Interfaces.InterfazEmp;
import Interfaces.InterfazLab;
import Interfaces.InterfazPro;
import ManejoArchivos.ManejoDeArchivos;
import NegocioInterfaces.InterfazNeCli;
import NegocioInterfaces.InterfazNeDep;
import NegocioInterfaces.InterfazNeEmp;
import datos.ClienteDao;
import datos.DepartamentoDao;
import datos.EmpleadoDao;
import datos.LaboratorioDao;
import datos.ProductoDao;
import dominio.Cliente;
import dominio.Departamento;
import dominio.Empleado;
import static dominio.Empleado.listarEmpleadosDec;
import dominio.Laboratorio;
import dominio.Producto;
import java.time.Instant;
import java.sql.Date;
import java.sql.SQLException;
import static java.time.Clock.system;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.ClienteNegocio;
import negocio.DepartamentoNegocio;
import negocio.EmpleadoNegocio;

/**
 * 1
 *
 * @author Nicolas Correa
 */
public class MysqlTest {

    static Scanner sm = new Scanner(System.in);
    static InterfazNeCli negocioCliente = new ClienteNegocio();
    static InterfazNeEmp negocioEmpleado = new EmpleadoNegocio();
    public static Scanner ent = new Scanner(System.in);
 
    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opc = -1;
        while (opc != 0) {
            System.out.println("=====================INGRESAR COMO=====================");
            System.out.println("1) INICIAR SESIÓN COMO ADMINISTRADOR (EMPLEADO)");
            System.out.println("2) INICIAR SESIÓN COMO CLIENTE");
            System.out.println("3) REGISTRAR NUEVO USUARIO");
            System.out.println("4) REGISTRAR NUEVO EMPLEADO");
            System.out.println("0) SALIR DE LA APLICACIÓN");
            System.out.println("SELECCIONE LA OPCIÓN QUE DESEE: ");
            opc = sm.nextInt();
            switch (opc) {

                case 1:
                    negocioEmpleado.sesion();
                    break;
                case 2:
                    negocioCliente.sesion();
                    break;
                case 3:
                    //CREAR OBJETO CLIENTE 
                    negocioCliente.Login();

                    break;
                case 4:
                    //CREAR OBJETO EMPLEADO 
                    negocioEmpleado.Login();
                    break;
                case 0:
                    //SALIR DEL PROGRAMA
                    break;
                default:
                    System.out.println("ELIJA UNA OPCIÓN VÁLIDA");
            }
        }
    }}
