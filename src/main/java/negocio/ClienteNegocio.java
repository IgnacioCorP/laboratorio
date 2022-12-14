package negocio;

import Interfaces.InterfazCli;
import Interfaces.InterfazPro;
import ManejoArchivos.ManejoDeArchivos;
import static MysqlTest.MysqlTest.ent;
import NegocioInterfaces.InterfazNeCli;
import datos.ClienteDao;
import datos.ProductoDao;
import dominio.Cliente;
import dominio.Producto;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ClienteNegocio implements InterfazNeCli {

    static InterfazCli clienteDao = new ClienteDao();
    static Cliente CC = new Cliente();
    static String nombreArchivo = "CLIENTES.txt";
    static Scanner sm = new Scanner(System.in);
    static InterfazPro productoDao = new ProductoDao();


    public List<Cliente> listarClientesDec() {
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> usuarios = null;

        try {
            usuarios = clienteDao.seleccionardesencriptar();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return usuarios;
    }

    public List<Cliente> listarClientes() {
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> usuarios = null;

        try {
            clienteDao.seleccionar();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return usuarios;
    }

    public Cliente sesion() {
        //RECORRER LISTA DE EMPLEADOS MEDIANTE UN MÉTODO QUE SE HA CREADO EN LA CLASE CLIENTE
        System.out.println("INTRODUZCA  NIF CON EL QUE SE REGISTRO: ");
        String nif = ent.nextLine();
        String clave;
        Cliente cliente = null;
        boolean existe = false;

        for (int i = 0; i < listarClientesDec().size(); i++) {
            //SI ESE CLIENTE EXISTE, ENTRA EN LA CONDICIÓN
            if (nif.equals(listarClientesDec().get(i).getNif())) {
                System.out.println("INTRODUZCA SU CONTRASEÑA: ");
                clave = ent.nextLine();
                existe = true;
                //MIENTRAS LA CONTRASEÑA SEA INCORRECTA, VUELVA A INTRODUCIR LA CONTRASEÑA
                while (!clave.equals(listarClientesDec().get(i).getClave())) {
                    System.out.println("PORFAVOR INTRODUZCA DE NUEVO LA CONTRASEÑA: ");
                    clave = ent.nextLine();
                }
                menuUsuario(listarClientesDec().get(i));

                //cliente = listarClientesDec().get(i);
            }

        }
        if (existe == false) {
            System.out.println("ESTE USUARIO NO EXISTE");
        }
        return cliente;

    }

    public Cliente Login() {
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
        clienteDao.insert(CC);

        //LISTAR OBJETOS Y CREAR ARCHIVO
        //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
        ManejoDeArchivos.agregarArchivo(nombreArchivo, CC.toString());
        ManejoDeArchivos.leerArchivo(nombreArchivo);

        return null;
    }

    public void menuUsuario(Cliente c) {
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
                    //ACTUALIZA A PARTIR DEL OBJETO QUE SE LE ENVÍA POR PARAMETRO
                    menuActualizar(c);
                    clienteDao.actualizar(c);
                    ManejoDeArchivos.escribirArchivo(nombreArchivo, c.toString());
                    break;
                case 2:
                    System.out.println("¿DESEA ELIMINAR SU CUENTA Yes(Y) o Not(N)?");
                    char y = ent.nextLine().charAt(0);
                    ;
                    //SI LA OPCIÓN ES IGUAL AL CARACTER, CUMPLE LA FUNCIÓN ELIMINAR EL OBJETO QUE SE LE ENVÍA POR PARÁMETRO
                    if (y == 'Y' || y == 'y') {
                        clienteDao.eliminar(c);
                        ManejoDeArchivos.escribirArchivo(nombreArchivo, c.toString());
                        System.out.println("SE HA ELIMINADO CORREACTAMENTE");

                    } else if (y == 'N' || y == 'n') {
                        System.out.println("No se ha eliminado el usuario");
                    }

                    break;
                case 3:
                    //VER LA CUENTA DEL USUARIO QUE SE LE ENVÍA POR PARÁMETRO
                    try {
                    List<Cliente> usuarios = clienteDao.seleccionar();
                    System.out.println("persona = " + c);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                break;
                case 4:
                    //PERMITE AL CLIENTE VER LA LISTA DE PRODUCTOS.
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
                    System.out.println("ELIJA UNA OPCIÓN VÁLIDA");
            }
        }
    }
    
     public  void menuActualizar(Cliente c) {
        //ENCARGADO DE ACTUALIZAR CADA CAMPO DEL CLIENTE QUE SE LE ENVÍA COMO PARÁMETRO
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
}
