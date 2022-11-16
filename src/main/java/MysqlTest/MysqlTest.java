/*EJECUCIÓN DE MÉTODOS*/
package MysqlTest;

import ManejoArchivos.ManejoDeArchivos;
import datos.ClienteDao;
import datos.DepartamentoDao;
import datos.EmpleadoDao;
import datos.LaboratorioDao;
import datos.ProductoDao;
import dominio.Cliente;
import dominio.Departamento;
import dominio.Empleado;
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

/**
 *
 * @author Nicolas Correa
 */
public class MysqlTest {

    static Scanner sm = new Scanner(System.in);
    static ArrayList<Cliente> Col1 = new ArrayList<Cliente>();
    static ArrayList<Producto> Col2 = new ArrayList<Producto>();
    static ArrayList<Empleado> Col3 = new ArrayList<Empleado>();
    static ArrayList<Laboratorio> Lab = new ArrayList<Laboratorio>();
    static ArrayList<Departamento> Dep = new ArrayList<Departamento>();
    static ClienteDao clienteDao = new ClienteDao();
    static Cliente CC = new Cliente();

    public static Scanner ent = new Scanner(System.in);
    static String nombreArchivo = "CLIENTES.txt";

    public static void main(String[] args) {

        //ManejoDeArchivos.crearArchivo(nombreArchivo);
        menuPrincipal();

        //===================================TABLA PRODUCTOS========================================================//
        /*ProductoDao productoDao = new ProductoDao();
        Date date2 = new Date(2032 - 1900, 9, 12);
        Producto p1 = new Producto(1, "Up-600", 70, date2);
        Producto p2 = new Producto(2, "Artiflex", 90, date2);
        //productoDao.insert(p2);
        //productoDao.eliminar(p1);
        //productoDao.actualizar(p1);
        //LISTAR OBJETOS Y CREAR ARCHIVO

        Col2.add(p1);
        Col2.add(p2);
        String nombreArchivo2 = "PRODUCTOS.txt";
        ManejoDeArchivos.crearArchivo(nombreArchivo2);
        //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
        ManejoDeArchivos.escribirArchivo(nombreArchivo2, Col2);
        ManejoDeArchivos.leerArchivo(nombreArchivo2);*/
        //===================================TABLA EMPLEADO========================================================//
        /* EmpleadoDao empleadoDao = new EmpleadoDao();
        Date date3 = new Date(2002 - 1900, 07, 31);
        Empleado E1 = new Empleado("U1234561T", "Jorge", "Torres", "105746923", "Calle Alonso Cano 13 ", "jorge@gmail.com", date3);
        Empleado E2 = new Empleado("Q8092134T", "Camilo", "Pardo", "635989812", "Calle Rodolfo Alvarez 14", "Camilo@gmail.com", date3);
        //clienteDao.insert(c1);
        //clienteDao.eliminar(c1);
        //clienteDao.actualizar(c1);
        //LISTAR OBJETOS Y CREAR ARCHIVO

        Col3.add(E1);
        Col3.add(E2);
        String nombreArchivo3 = "EMPLEADOS.txt";
        ManejoDeArchivos.crearArchivo(nombreArchivo3);
        //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
        ManejoDeArchivos.escribirArchivo(nombreArchivo3, Col3);
        ManejoDeArchivos.leerArchivo(nombreArchivo3);*/
        //===================================TABLA LABORATORIO========================================================//
        /*LaboratorioDao laboratorioDao = new LaboratorioDao();
        Laboratorio L1 = new Laboratorio(1, "Kuantum Pharma", "Kra 76", "607873151");
        //laboratorioDao.insert(L1);
        laboratorioDao.actualizar(L1);

        //laboratorioDao.eliminar(L1);
        Lab.add(L1);
        String nombreArchivo4 = "LABORATORIOS.txt";
        ManejoDeArchivos.crearArchivo(nombreArchivo4);
        //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
        ManejoDeArchivos.escribirArchivo(nombreArchivo4, Lab);
        ManejoDeArchivos.leerArchivo(nombreArchivo4);*/
        //===================================TABLA DEPARTAMENTO========================================================//  
        /*DepartamentoDao departamentoDao = new DepartamentoDao();
        Departamento D1 = new Departamento(1, "Administración", "Gestión administrativa del laboratorio");
        Departamento D2 = new Departamento(2, "Contabilidad", "Gestión contable del laboratorio");
        //departamentoDao.insert(D2);
        //departamentoDao.actualizar(D2);
        //departamentoDao.eliminar(D1);

        Dep.add(D1);
        Dep.add(D2);

        String nombreArchivo5 = "DEPARTAMENTOS.txt";
        ManejoDeArchivos.crearArchivo(nombreArchivo5);
        //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
        ManejoDeArchivos.escribirArchivo(nombreArchivo5, Dep);
        ManejoDeArchivos.leerArchivo(nombreArchivo5);
        System.out.println("");
        System.out.println("");*/
    }

    private static void menuPrincipal() {
        int opc = -1;
        while (opc != 0) {
            System.out.println("=====================INGRESAR COMO=====================");
            System.out.println("1) INICIAR SESIÓN COMO ADMINISTRADOR");
            System.out.println("2) INICIAR SESIÓN COMO USUARIO");
            System.out.println("3) REGISTRAR NUEVO USUARIO");
            System.out.println("0) SALIR DE LA APLICACIÓN");
            System.out.println("SELECCIONE LA OPCIÓN QUE DESEE: ");
            opc = sm.nextInt();
            switch (opc) {

                case 1:
                    menuAdmin();
                    break;
                case 2:
                    System.out.println("INTRODUZCA EL NIF CON EL QUE SE REGISTRO: ");
                    String nif = ent.nextLine();
                    String clave;
                    for (int i = 0; i < Cliente.listarClientesDec().size(); i++) {
                        if (nif.equals(Cliente.listarClientesDec().get(i).getNif())) {
                            System.out.println("INTRODUZCA SU CONTRASEÑA: ");
                            clave = ent.nextLine();
                            while (!clave.equals(Cliente.listarClientesDec().get(i).getClave())) {
                                System.out.println("PORFAVOR INTRODUZCA DE NUEVO LA CONTRASEÑA: ");
                                clave = ent.nextLine();
                            }

                            menuUsuario(Cliente.listarClientesDec().get(i));

                        }
                    }

                    break;
                case 3:

                    System.out.println("INTRODUZCA NIF: ");
                    Scanner niF = new Scanner(System.in);
                    String niff = niF.nextLine();
                    CC.setNif(niff);

                    System.out.println("INTRODUZCA NOMBRE: ");
                    Scanner Nombre = new Scanner(System.in);
                    String Nombres = String.valueOf(Nombre.nextLine());
                    CC.setNombre(Nombres);

                    System.out.println("INTRODUZCA APELLIDO: ");
                    Scanner Apellido = new Scanner(System.in);
                    String Apellidos = String.valueOf(Apellido.nextLine());
                    CC.setApellido(Apellidos);

                    System.out.println("INTRODUZCA TELÉFONO: ");
                    Scanner Telefono = new Scanner(System.in);
                    String Telefonos = String.valueOf(Telefono.nextLine());
                    CC.setTelefono(Telefonos);

                    System.out.println("INTRODUZCA EMAIL: ");
                    Scanner Email = new Scanner(System.in);
                    String Emails = String.valueOf(Email.nextLine());
                    CC.setEmail(Emails);

                    System.out.println("INTRODUZCA FECHA DE NACIMIENTO (AÑO-MES-DÍA): ");
                    Scanner Fech = new Scanner(System.in);
                    Date fec = Date.valueOf(Fech.nextLine());
                    CC.setFecha_nac(fec);

                    System.out.println("CREE SU CONTRASEÑA: ");
                    Scanner Clave = new Scanner(System.in);
                    String Claves = String.valueOf(Clave.nextLine());
                    CC.setClave(Claves);

                    System.out.println("=============USUARIO AÑADIDO CORRECTAMENTE=========================");

                    Col1.add(CC);
                    clienteDao.insert(CC);

                    //LISTAR OBJETOS Y CREAR ARCHIVO
                    //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
                    ManejoDeArchivos.agregarArchivo(nombreArchivo, CC.toString());
                    ManejoDeArchivos.leerArchivo(nombreArchivo);
                    break;
                case 0:
                    //se sale del programa
                    break;
                default:
                    System.out.println("Elija una opción valida");
            }
        }
    }

    private static void menuUsuario(Cliente c) {
        int opc = -1;
        while (opc != 0) {
            System.out.println("=====================BIENVENIDO=====================");
            System.out.println("1) ACTUALIZAR USUARIO");
            System.out.println("2) ELIMINAR USUARIO");
            System.out.println("3) VISUALIZAR USUARIO");
            System.out.println("0) VOLVER");
            System.out.println("SELECCIONE LA OPCIÓN QUE DESEE: ");
            opc = sm.nextInt();
            switch (opc) {

                case 1:
                    menuActualizar(c);
                    clienteDao.actualizar(c);
                    ManejoDeArchivos.agregarArchivo(nombreArchivo, c.toString());
                    break;
                case 2:
                    System.out.println("¿DESEA ELIMINAR SU CUENTA?");
                    char y = ent.nextLine().charAt(0);;   
                    if(y == 'Y'){
                        clienteDao.eliminar(c);
                        System.out.println("SE HA ELIMINADO CORREACTAMENTE");
                    }else{
                        break;
                    }
                    
                    break;
                case 3:
                    try {
                    List<Cliente> usuarios = clienteDao.seleccionar();            
                    System.out.println("persona = " + c);   
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                    break;
                case 0:
                    //se sale del programa
                    break;
                default:
                    System.out.println("Elija una opción valida");
            }
        }
    }

    private static void menuActualizar(Cliente c) {
        int opc = -1;
        while (opc != 0) {
            System.out.println("=====================MENÚ ADMINISTRADOR=====================");
            System.out.println("1) Nif");
            System.out.println("2) Nombre");
            System.out.println("3) Apellido");
            System.out.println("4) Teléfono");
            System.out.println("5) Email");
            System.out.println("6) Fecha de nacimiento");
            System.out.println("7) Clave");
            System.out.println("0) VOLVER");
            System.out.println("SELECCIONE LA OPCIÓN QUE DESEE: ");
            opc = sm.nextInt();
            System.out.println("====================================================");

            switch (opc) {

                case 1:
                    System.out.println("INTRODUZCA NIF: ");
                    Scanner niF = new Scanner(System.in);
                    String niff = niF.nextLine();
                    c.setNif(niff);

                    break;
                case 2:
                    System.out.println("INTRODUZCA NOMBRE: ");
                    Scanner Nombre = new Scanner(System.in);
                    String Nombres = String.valueOf(Nombre.nextLine());
                    c.setNombre(Nombres);

                    break;

                case 3:

                    System.out.println("INTRODUZCA APELLIDO: ");
                    Scanner Apellido = new Scanner(System.in);
                    String Apellidos = String.valueOf(Apellido.nextLine());
                    c.setApellido(Apellidos);

                    break;

                case 4:
                    System.out.println("INTRODUZCA TELÉFONO: ");
                    Scanner Telefono = new Scanner(System.in);
                    String Telefonos = String.valueOf(Telefono.nextLine());
                    c.setTelefono(Telefonos);

                    break;

                case 5:
                    System.out.println("INTRODUZCA EMAIL: ");
                    Scanner Email = new Scanner(System.in);
                    String Emails = String.valueOf(Email.nextLine());
                    c.setEmail(Emails);

                    break;
                case 6:
                    System.out.println("INTRODUZCA FECHA DE NACIMIENTO (AÑO-MES-DÍA): ");
                    Scanner Fech = new Scanner(System.in);
                    Date fec = Date.valueOf(Fech.nextLine());
                    c.setFecha_nac(fec);

                    break;
                case 7:
                    
                    System.out.println("CREE SU CONTRASEÑA: ");
                    Scanner Clave = new Scanner(System.in);
                    String Claves = String.valueOf(Clave.nextLine());
                    c.setClave(Claves);

                    break;

                case 0:
                    //se sale del programa
                    break;
                default:
                    System.out.println("Elija una opción valida");

            }

        }
    }

    private static void menuAdmin() {
        int opc = -1;
        while (opc != 0) {
            System.out.println("=====================MENÚ ADMINISTRADOR=====================");
            System.out.println("1) EMPLEADO");
            System.out.println("2) CLIENTE");
            System.out.println("3) PRODUCTO");
            System.out.println("4) LABORATORIO");
            System.out.println("5) DEPARTAMENTO");
            System.out.println("0) VOLVER");
            System.out.println("SELECCIONE LA OPCIÓN QUE DESEE: ");
            opc = sm.nextInt();
            System.out.println("====================================================");

            switch (opc) {

                case 1:

                    break;
                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 0:
                    //se sale del programa
                    break;
                default:
                    System.out.println("Elija una opción valida");

            }
            for (int i = 0; i < 3; i++) {
                System.out.println();
            }
        }
    }

    public static int alea(int li, int ls) {//función de JAVA
        return (int) ((Math.round(Math.random() * (ls - li)) + li));
    }

}
