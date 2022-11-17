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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    static EmpleadoDao empleadoDao = new EmpleadoDao();
    static ProductoDao productoDao = new ProductoDao();
    static Cliente CC = new Cliente();
    static Empleado EE = new Empleado();

    public static Scanner ent = new Scanner(System.in);
    static String nombreArchivo = "CLIENTES.txt";
    static String nombreArchivo2 = "EMPLEADOS.txt";
    static String nombreArchivo3 = "PRODUCTOS.txt";

    public static void main(String[] args) {

        //ManejoDeArchivos.crearArchivo(nombreArchivo);
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
                    System.out.println("INTRODUZCA SU ID DE EMPRESA: ");
                    String NIF = ent.nextLine();
                    String contraseña;
                    for (int i = 0; i < Empleado.listarEmpleadosDec().size(); i++) {
                        if (NIF.equals(Empleado.listarEmpleadosDec().get(i).getNif())) {
                            System.out.println("INTRODUZCA SU CONTRASEÑA: ");
                            contraseña = ent.nextLine();
                            while (!contraseña.equals(Empleado.listarEmpleadosDec().get(i).getClave())) {
                                System.out.println("PORFAVOR INTRODUZCA DE NUEVO LA CONTRASEÑA: ");
                                contraseña = ent.nextLine();
                            }

                            menuAdmin(Empleado.listarEmpleadosDec().get(i));

                        }
                    }
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
                case 4:
                    System.out.println("INTRODUZCA NIF: ");
                    niff = ent.nextLine();
                    EE.setNif(niff);

                    System.out.println("INTRODUZCA NOMBRE: ");
                    Nombres = String.valueOf(ent.nextLine());
                    EE.setNombre(Nombres);

                    System.out.println("INTRODUZCA APELLIDO: ");
                    Apellidos = String.valueOf(ent.nextLine());
                    EE.setApellido(Apellidos);

                    System.out.println("INTRODUZCA TELÉFONO: ");
                    Telefonos = String.valueOf(ent.nextLine());
                    EE.setTelefono(Telefonos);

                    System.out.println("INTRODUZCA DIRECCIÓN: ");
                    String Direccion = String.valueOf(ent.nextLine());
                    EE.setDireccion(Direccion);

                    System.out.println("INTRODUZCA EMAIL: ");
                    Emails = String.valueOf(ent.nextLine());
                    EE.setEmail(Emails);

                    System.out.println("INTRODUZCA FECHA DE NACIMIENTO (AÑO-MES-DÍA): ");
                    Scanner Fechs = new Scanner(System.in);
                    Date fecs = Date.valueOf(Fechs.nextLine());
                    EE.setFecha_Nac(fecs);

                    System.out.println("CREE SU CONTRASEÑA: ");
                    Claves = String.valueOf(ent.nextLine());
                    EE.setClave(Claves);

                    System.out.println("=============USUARIO AÑADIDO CORRECTAMENTE=========================");

                    Col3.add(EE);
                    empleadoDao.insert(EE);

                    //LISTAR OBJETOS Y CREAR ARCHIVO
                    //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
                    ManejoDeArchivos.agregarArchivo(nombreArchivo2, EE.toString());
                    ManejoDeArchivos.leerArchivo(nombreArchivo2);
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
            System.out.println("4) PRODUCTOS");
            System.out.println("0) VOLVER");
            System.out.println("SELECCIONE LA OPCIÓN QUE DESEE: ");
            opc = sm.nextInt();
            switch (opc) {

                case 1:
                    menuActualizar(c);
                    clienteDao.actualizar(c);
                    ManejoDeArchivos.escribirArchivo(nombreArchivo, c.toString());
                    break;
                case 2:
                    System.out.println("¿DESEA ELIMINAR SU CUENTA Yes(Y) o Not(N)?");
                    char y = ent.nextLine().charAt(0);
                    ;
                    if (y == 'Y' || y == 'y') {
                        clienteDao.eliminar(c);
                        ManejoDeArchivos.escribirArchivo(nombreArchivo, c.toString());
                        System.out.println("SE HA ELIMINADO CORREACTAMENTE");
                        System.exit(0);
                    } else if (y == 'N' || y == 'n') {
                        System.out.println("No se ha eliminado el usuario");
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
                case 4:
                    try {
                    List<Producto> productos = productoDao.seleccionar();
                    productos.forEach(producto -> {
                        System.out.println("producto = " + producto);
                    }
                    );
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
            System.out.println("=====================MENÚ USUARIO=====================");
            System.out.println("1) NIF");
            System.out.println("2) NOMBRE");
            System.out.println("3) APELLIDO");
            System.out.println("4) TELÉFONO");
            System.out.println("5) EMAIL");
            System.out.println("6) FECHA DE NACIMIENTO");
            System.out.println("7) CLAVE");
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

    private static void menuActualizar2(Empleado e) {
        int opc = -1;
        while (opc != 0) {
            System.out.println("=====================MENÚ USUARIO=====================");
            System.out.println("1) NIF");
            System.out.println("2) NOMBRE");
            System.out.println("3) APELLIDO");
            System.out.println("4) TELÉFONO");
            System.out.println("5) DIRECCIÓN");
            System.out.println("6) EMAIL");
            System.out.println("7) FECHA DE NACIMIENTO");
            System.out.println("8) CLAVE");
            System.out.println("0) VOLVER");
            System.out.println("SELECCIONE LA OPCIÓN QUE DESEE: ");
            opc = sm.nextInt();
            System.out.println("====================================================");

            switch (opc) {

                case 1:
                    System.out.println("INTRODUZCA NIF: ");
                    Scanner niF = new Scanner(System.in);
                    String niff = niF.nextLine();
                    e.setNif(niff);

                    break;
                case 2:
                    System.out.println("INTRODUZCA NOMBRE: ");
                    Scanner Nombre = new Scanner(System.in);
                    String Nombres = String.valueOf(Nombre.nextLine());
                    e.setNombre(Nombres);

                    break;

                case 3:

                    System.out.println("INTRODUZCA APELLIDO: ");
                    Scanner Apellido = new Scanner(System.in);
                    String Apellidos = String.valueOf(Apellido.nextLine());
                    e.setApellido(Apellidos);

                    break;

                case 4:

                    System.out.println("INTRODUZCA TELÉFONO: ");
                    Scanner Telefono = new Scanner(System.in);
                    String Telefonos = String.valueOf(Telefono.nextLine());
                    e.setTelefono(Telefonos);

                    break;
                case 5:

                    System.out.println("INTRODUZCA DIRECCIÓN: ");
                    Scanner Direccion = new Scanner(System.in);
                    String Direcciones = String.valueOf(Direccion.nextLine());
                    e.setDireccion(Direcciones);

                    break;

                case 6:
                    System.out.println("INTRODUZCA EMAIL: ");
                    Scanner Email = new Scanner(System.in);
                    String Emails = String.valueOf(Email.nextLine());
                    e.setEmail(Emails);

                    break;
                case 7:

                    System.out.println("INTRODUZCA FECHA DE NACIMIENTO (AÑO-MES-DÍA): ");
                    Scanner Fech = new Scanner(System.in);
                    Date fec = Date.valueOf(Fech.nextLine());
                    e.setFecha_Nac(fec);

                    break;
                case 8:

                    System.out.println("CREE SU CONTRASEÑA: ");
                    Scanner Clave = new Scanner(System.in);
                    String Claves = String.valueOf(Clave.nextLine());
                    e.setClave(Claves);

                    break;

                case 0:
                    //se sale del programa
                    break;
                default:
                    System.out.println("Elija una opción valida");

            }

        }
    }

    private static void menuAdmin(Empleado e) {
        int opc = -1;
        while (opc != 0) {
            System.out.println("=====================MENÚ ADMINISTRADOR=====================");
            System.out.println("=====================BIENVENIDO=====================");
            System.out.println("1) ACTUALIZAR CUENTA");
            System.out.println("2) ELIMINAR CUENTA");
            System.out.println("3) MI CUENTA");
            System.out.println("4) TABLAS");
            System.out.println("0) VOLVER");
            System.out.println("SELECCIONE LA OPCIÓN QUE DESEE: ");
            opc = sm.nextInt();
            System.out.println("====================================================");

            switch (opc) {

                case 1:
                    menuActualizar2(e);
                    empleadoDao.actualizar(e);
                    ManejoDeArchivos.escribirArchivo(nombreArchivo2, e.toString());
                    break;
                case 2:

                    System.out.println("¿DESEA ELIMINAR SU CUENTA Yes(Y) o Not(N)?");
                    char y = ent.nextLine().charAt(0);
                    ;
                    if (y == 'Y' || y == 'y') {
                        empleadoDao.eliminar(e);
                        System.out.println("SE HA ELIMINADO CORREACTAMENTE");
                        System.exit(0);
                    } else if (y == 'N' || y == 'n') {
                        System.out.println("No se ha eliminado el usuario");
                    }

                    break;
                case 3:
                    try {
                    List<Empleado> usuarios = empleadoDao.seleccionar();
                    System.out.println("persona = " + e);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                break;

                case 4:
                    menuTablas(e);
                    break;

                case 0:
                    //se sale del programa
                    break;
                default:
                    System.out.println("Elija una opción valida");

            }

        }
    }

    private static void menuTablas(Empleado e) {
        int opc = -1;
        while (opc != 0) {
            System.out.println("=====================MENÚ ADMINISTRADOR=====================");
            System.out.println("1) EMPLEADOS");
            System.out.println("2) CLIENTES");
            System.out.println("3) PRODUCTOS");
            System.out.println("4) LABORATORIOS");
            System.out.println("5) DEPARTAMENTOS");
            System.out.println("0) VOLVER");
            System.out.println("SELECCIONE LA OPCIÓN QUE DESEE: ");
            opc = sm.nextInt();
            System.out.println("====================================================");

            switch (opc) {

                case 1:
                      try {
                    List<Empleado> emp = empleadoDao.seleccionar();
                    System.out.println("persona = " + emp);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                    break;
                case 2:
                     try {
                    List<Cliente> cl = clienteDao.seleccionar();
                    cl.forEach(cliente -> {
                        System.out.println("Cliente = " + cliente);
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                    
                    break;

                case 3:
                    //===================================TABLA PRODUCTOS========================================================//
                    /* ProductoDao productoDao = new ProductoDao();
                    //LISTAR OBJETOS Y CREAR ARCHIVO
                    //productoDao.insert(p2);
                    //productoDao.eliminar(p1);
                    //productoDao.actualizar(p1);
                    Col2.add(p1);
                    Col2.add(p2);*/
                    Date date2 = new Date(2032 - 1900, 9, 12);
                    Producto p1 = new Producto(1, "Up-600", 70, date2);
                    Producto p2 = new Producto(2, "Artiflex", 90, date2);
                    //ManejoDeArchivos.crearArchivo(nombreArchivo3);
                    //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
                    ManejoDeArchivos.agregarArchivo(nombreArchivo3, p2.toString());
                    ManejoDeArchivos.leerArchivo(nombreArchivo3);
                    break;

                case 4:
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
                    break;

                case 5:
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
