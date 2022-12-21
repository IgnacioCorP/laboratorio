
package negocio;

import Interfaces.InterfazCli;
import Interfaces.InterfazEmp;
import Interfaces.InterfazLab;
import Interfaces.InterfazPro;
import ManejoArchivos.ManejoDeArchivos;
import static MysqlTest.MysqlTest.ent;
import NegocioInterfaces.InterfazNeDep;
import NegocioInterfaces.InterfazNeEmp;
import datos.ClienteDao;
import datos.EmpleadoDao;
import datos.LaboratorioDao;
import datos.ProductoDao;
import dominio.Cliente;
import dominio.Empleado;
import dominio.Laboratorio;
import dominio.Producto;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/*
@author Nicolás Correa
 */
public class EmpleadoNegocio implements InterfazNeEmp {

    static Scanner sm = new Scanner(System.in);
    Empleado EE = new Empleado();
    InterfazEmp empleadoDao = new EmpleadoDao();
    String nombreArchivo2 = "EMPLEADOS.txt";
    static Producto pp = new Producto();
    static InterfazCli clienteDao = new ClienteDao();
    static InterfazPro productoDao = new ProductoDao();
    static String nombreArchivo3 = "PRODUCTOS.txt";
    static String nombreArchivo5 = "LABORATORIOS.txt";
    static InterfazNeDep negocioDepartamento = new DepartamentoNegocio();
    static InterfazLab laboratorioDao = new LaboratorioDao();
    static Laboratorio LL = new Laboratorio();

    public Empleado sesion() {
        System.out.println("INTRODUZCA EMAIL: ");
        String NIF = ent.nextLine();
        String contraseña;
        //RECORRER LISTA DE EMPLEADOS MEDIANTE UN MÉTODO QUE SE HA CREADO EN LA CLASE EMPLEADO
        for (int i = 0; i < Empleado.listarEmpleadosDec().size(); i++) {
            //SI ESE EMPLEADO EXISTE, ENTRA EN LA CONDICIÓN
            if (NIF.equals(Empleado.listarEmpleadosDec().get(i).getEmail())) {
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

    public void menuAdmin(Empleado e) {
        int opc = -1;
        while (opc != 0) {
            System.out.println("=====================MENÚ ADMINISTRADOR=====================");
            System.out.println("=====================BIENVENIDO=====================");
            System.out.println("1) ACTUALIZAR CUENTA");
            System.out.println("2) ELIMINAR CUENTA");
            System.out.println("3) MI CUENTA");
            System.out.println("4) ENTIDADES");
            System.out.println("0) VOLVER");
            System.out.println("SELECCIONE LA OPCIÓN QUE DESEE: ");
            opc = sm.nextInt();
            System.out.println("====================================================");

            switch (opc) {

                case 1:
                    //ACTUALIZA A PARTIR DEL OBJETO QUE SE LE ENVÍA POR PARAMETRO
                    menuActualizar2(e);
                    empleadoDao.actualizar(e);
                    //ManejoDeArchivos.escribirArchivo(nombreArchivo2, e.toString());
                    break;
                case 2:

                    System.out.println("¿DESEA ELIMINAR SU CUENTA Yes(Y) o Not(N)?");
                    char y = ent.nextLine().charAt(0);
                    ;
                    //SI LA OPCIÓN ES IGUAL AL CARACTER, CUMPLE LA FUNCIÓN ELIMINAR EL OBJETO QUE SE LE ENVÍA POR PARÁMETRO
                    if (y == 'Y' || y == 'y') {
                        empleadoDao.eliminar(e);
                        System.out.println("SE HA ELIMINADO CORREACTAMENTE");
                        System.exit(0);
                    } else if (y == 'N' || y == 'n') {
                        System.out.println("NO SE HA ELIMINADO");
                    }

                    break;
                case 3:
                    //VER LA CUENTA DEL USUARIO QUE SE LE ENVÍA POR PARÁMETRO
                    try {
                    List<Empleado> usuarios = empleadoDao.seleccionar();
                    System.out.println("persona = " + e);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                break;

                case 4:
                    //PERMITE AL ADMINISTRADOR HACER EL CRUD DE CADA UNA DE LAS TABLAS, ENVIANDOLE EL OBJETO COMO PARÁMETRO.
                    menuTablas(e);
                    break;

                case 0:
                    break;
                default:
                    System.out.println("ELIJA UNA OPCIÓN VÁLIDA");

            }

        }
    }

    public void menuActualizar2(Empleado e) {
        //ENCARGADO DE ACTUALIZAR CADA CAMPO DEL EMPLEADO QUE SE LE ENVÍA COMO PARÁMETRO
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

    public void menuTablas(Empleado e) {
        //PERMITE AL EMPLEADO QUE SE LE ENVÍA COMO PARÁMETRO ADMINISTRAR ESTE MENÚ
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
                    //VISUALIZAR LISTA DE EMPLEADOS  
                try {
                    List<Empleado> emp = empleadoDao.seleccionar();
                    System.out.println("Empleado = " + emp);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                break;
                case 2:
                    //VISUALIZA LISTA DE CLIENTES
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
                    //GESTIONA CRUD DE LA TABLA Y SE LE ENVÍA COMO PARÁMETRO UN STRING PARA QUE ENTRE EN EL MENÚ CORRESPONDIENTE
                    menuCrud("PRODUCTOS");

                    break;

                case 4:
                    //===================================TABLA LABORATORIO========================================================//
                    //GESTIONA CRUD DE LA TABLA Y SE LE ENVÍA COMO PARÁMETRO UN STRING PARA QUE ENTRE EN EL MENÚ CORRESPONDIENTE
                    menuCrud("LABORATORIOS");
                    break;

                case 5:
                    //===================================TABLA DEPARTAMENTO========================================================//
                    menuCrud("DEPARTAMENTOS");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("ELIJA UNA OPCIÓN VÁLIDA");

            }

        }
    }

    public void menuCrud(String entidad) {
        int opc = -1;
        while (opc != 0) {
            System.out.println("=======================MENÚ=========================");
            System.out.println("=====================BIENVENIDO=====================");
            System.out.println("1) INSERTAR " + entidad);
            System.out.println("2) ACTUALIZAR " + entidad);
            System.out.println("3) ELIMINAR " + entidad);
            System.out.println("4) VISUALIZAR " + entidad);
            System.out.println("5) BUSCAR ");
            System.out.println("0) VOLVER");
            System.out.println("SELECCIONE LA OPCIÓN QUE DESEE: ");
            opc = sm.nextInt();
            System.out.println("====================================================");

            switch (entidad) {

                case "PRODUCTOS":
                    switch (opc) {
                        case 1:
                            //INSERTAR NUEVO OBJETO
                            System.out.println("INTRODUZCA NOMBRE DEL PRODUCTO: ");
                            Scanner NOM = new Scanner(System.in);
                            String NOMS = String.valueOf(NOM.nextLine());
                            pp.setNombre(NOMS);

                            System.out.println("INTRODUZCA PRECIO DEL PRODUCTO: ");
                            Scanner PRE = new Scanner(System.in);
                            double pres = Double.valueOf(PRE.nextLine());
                            pp.setPrecio(pres);

                            System.out.println("INTRODUZCA LA FECHA DE CADUCIDAD DEL PRODUCTO (AÑO-MES-DÍA): ");
                            Scanner Fechs = new Scanner(System.in);
                            Date fecs = Date.valueOf(Fechs.nextLine());
                            pp.setFecha_caducidad(fecs);

                            System.out.println("=============PRODUCTO AÑADIDO CORRECTAMENTE=========================");

                            productoDao.insert(pp);
                            ManejoDeArchivos.agregarArchivo(nombreArchivo3, pp.toString());
                            ManejoDeArchivos.leerArchivo(nombreArchivo3);
                            break;
                        case 2:
                            //ACTUALIZAR OBJETO
                            System.out.println("INTRODUZCA ID DE PRODUCTO: ");
                            int idd = ent.nextInt();
                            for (int i = 0; i < Producto.listarProductosDec().size(); i++) {
                                if (idd == Producto.listarProductosDec().get(i).getID_pro()) {
                                    pp = Producto.listarProductosDec().get(i);

                                    System.out.println("INTRODUZCA NOMBRE DEL PRODUCTO: ");
                                    Scanner NOMs = new Scanner(System.in);
                                    NOMS = String.valueOf(NOMs.nextLine());
                                    pp.setNombre(NOMS);

                                    System.out.println("INTRODUZCA PRECIO DEL PRODUCTO: ");
                                    Scanner PREs = new Scanner(System.in);
                                    pres = Double.valueOf(PREs.nextLine());
                                    pp.setPrecio(pres);

                                    System.out.println("INTRODUZCA LA FECHA DE CADUCIDAD DEL PRODUCTO (AÑO-MES-DÍA): ");
                                    Scanner Fechss = new Scanner(System.in);
                                    Date fecss = Date.valueOf(Fechss.nextLine());
                                    pp.setFecha_caducidad(fecss);

                                    productoDao.actualizar(pp);
                                    ManejoDeArchivos.escribirArchivo(nombreArchivo3, pp.toString());

                                }
                            }

                            break;
                        case 3:
                            //ELIMINAR OBJETO
                            System.out.println("INTRODUZCA ID DE PRODUCTO: ");
                            int iidd = ent.nextInt();
                            for (int i = 0; i < Producto.listarProductosDec().size(); i++) {
                                if (iidd == Producto.listarProductosDec().get(i).getID_pro()) {
                                    pp = Producto.listarProductosDec().get(i);
                                    System.out.println("¿DESEA ELIMINAR ESTE PRODUCTO Yes(0) o Not(1)?");
                                    int y;
                                    y = ent.nextInt();
                                    if (y == 0) {
                                        pp = Producto.listarProductosDec().get(i);
                                        productoDao.eliminar(pp);
                                        System.out.println("SE HA ELIMINADO CORREACTAMENTE");

                                    } else if (y == 1) {
                                        System.out.println("No se ha eliminado el producto");
                                    }
                                }
                            }
                            break;
                        case 4:
                            //VISUALIZAR OBJETO
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
                            break;
                        default:
                            System.out.println("Elija una opción valida");
                    }
                    break;
                case "DEPARTAMENTOS":
                    switch (opc) {
                        case 1:
                            negocioDepartamento.crear();

                            break;
                        case 2:
                            negocioDepartamento.actualizar2();

                            break;
                        case 3:
                            negocioDepartamento.eliminar2();

                            break;
                        case 4:
                            negocioDepartamento.visualizar2();
                            break;
                        case 5:
                            negocioDepartamento.buscar2();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("ELIJA UNA OPCIÓN VÁLIDA");
                    }
                    break;
                case "LABORATORIOS":
                    switch (opc) {
                        case 1:
                            System.out.println("INTRODUZCA NOMBRE DEL LABORATORIO: ");
                            Scanner LAB = new Scanner(System.in);
                            String LABS = String.valueOf(LAB.nextLine());
                            LL.setNombre_sede(LABS);

                            System.out.println("INTRODUZCA DIRECCIÓN DEL LABORATORIO: ");
                            Scanner DIR = new Scanner(System.in);
                            String DIRS = String.valueOf(DIR.nextLine());
                            LL.setDireccion(DIRS);

                            System.out.println("INTRODUZCA TELÉFONO DEL LABORATORIO: ");
                            Scanner TEL = new Scanner(System.in);
                            String TELS = String.valueOf(TEL.nextLine());
                            LL.setTelefono(TELS);

                            System.out.println("=============LABORATORIO AÑADIDO CORRECTAMENTE=========================");

                            laboratorioDao.insert(LL);
                            ManejoDeArchivos.escribirArchivo(nombreArchivo5, LL.toString());
                            break;
                        case 2:
                            System.out.println("INTRODUZCA ID DEL LABORATORIO: ");
                            int idd = ent.nextInt();
                            for (int i = 0; i < Laboratorio.listarLaboratoriosDec().size(); i++) {
                                if (idd == Laboratorio.listarLaboratoriosDec().get(i).getID_lab()) {
                                    LL = Laboratorio.listarLaboratoriosDec().get(i);

                                    System.out.println("INTRODUZCA NOMBRE DEL LABORATORIO: ");
                                    Scanner LABs = new Scanner(System.in);
                                    String LABSs = String.valueOf(LABs.nextLine());
                                    LL.setNombre_sede(LABSs);

                                    System.out.println("INTRODUZCA DIRECCIÓN DEL LABORATORIO: ");
                                    Scanner DIRr = new Scanner(System.in);
                                    String DIRrS = String.valueOf(DIRr.nextLine());
                                    LL.setDireccion(DIRrS);

                                    System.out.println("INTRODUZCA DIRECCIÓN DEL LABORATORIO: ");
                                    Scanner TELl = new Scanner(System.in);
                                    String TELSl = String.valueOf(TELl.nextLine());
                                    LL.setTelefono(TELSl);

                                    laboratorioDao.actualizar(LL);
                                    ManejoDeArchivos.escribirArchivo(nombreArchivo5, LL.toString());

                                }
                            }
                            break;
                        case 3:
                            System.out.println("INTRODUZCA ID DE LABORATORIO: ");
                            int iiidd = ent.nextInt();
                            for (int i = 0; i < Laboratorio.listarLaboratoriosDec().size(); i++) {
                                if (iiidd == Laboratorio.listarLaboratoriosDec().get(i).getID_lab()) {
                                    LL = Laboratorio.listarLaboratoriosDec().get(i);

                                    char y = 'Y';

                                    if (y == 'Y' || y == 'y') {
                                        LL = Laboratorio.listarLaboratoriosDec().get(i);
                                        laboratorioDao.eliminar(LL);
                                        ManejoDeArchivos.escribirArchivo(nombreArchivo5, LL.toString());
                                        System.out.println("SE HA ELIMINADO CORREACTAMENTE");

                                    } else if (y == 'n' || y == 'N') {
                                        System.out.println("NO SE HA ELIMINADO");
                                    }
                                }
                            }
                            break;
                        case 4:
                             try {
                            List<Laboratorio> laboratorios = laboratorioDao.seleccionar();
                            laboratorios.forEach(Laboratorio -> {
                                System.out.println("Laboratorio = " + Laboratorio);
                            }
                            );
                        } catch (SQLException ex) {
                            ex.printStackTrace(System.out);
                        }
                        break;

                        case 0:
                            break;
                        default:
                            System.out.println("ELIJA UNA OPCIÓN VÁLIDA");
                    }
                    break;

            }

        }
    }
}
