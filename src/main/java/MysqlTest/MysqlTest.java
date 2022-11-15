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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Nicolas Correa
 */
public class MysqlTest {

    public static void main(String[] args) {

        //===================================TABLA CLIENTES========================================================//
        ClienteDao clienteDao = new ClienteDao();
        Date date = new Date(2002 - 1900, 07, 31);
        Cliente c1 = new Cliente("Y8087469Q", "Nicolás", "Correa", "666666666", "nachitoficopal@gmail.com", date);
        Cliente c2 = new Cliente("Q8092134T", "Mónica", "Suarez", "777777777", "monisu@gmail.com", date);
        //clienteDao.insert(c1);
        //clienteDao.eliminar(c1);
        //clienteDao.actualizar(c1);
        //LISTAR OBJETOS Y CREAR ARCHIVO
        ArrayList<Cliente> Col1 = new ArrayList<Cliente>();
        Col1.add(c1);
        Col1.add(c2);
        String nombreArchivo = "CLIENTES.txt";
        ManejoDeArchivos.crearArchivo(nombreArchivo);
        //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
        ManejoDeArchivos.escribirArchivo(nombreArchivo, Col1);
        ManejoDeArchivos.leerArchivo(nombreArchivo);

        //===================================TABLA PRODUCTOS========================================================//
        ProductoDao productoDao = new ProductoDao();
        Date date2 = new Date(2032 - 1900, 9, 12);
        Producto p1 = new Producto(1, "Up-600", 70, date2);
        Producto p2 = new Producto(2, "Artiflex", 90, date2);
        //productoDao.insert(p2);
        //productoDao.eliminar(p1);
        //productoDao.actualizar(p1);
        //LISTAR OBJETOS Y CREAR ARCHIVO
        ArrayList<Producto> Col2 = new ArrayList<Producto>();
        Col2.add(p1);
        Col2.add(p2);
        String nombreArchivo2 = "PRODUCTOS.txt";
        ManejoDeArchivos.crearArchivo(nombreArchivo2);
        //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
        ManejoDeArchivos.escribirArchivo(nombreArchivo2, Col2);
        ManejoDeArchivos.leerArchivo(nombreArchivo2);

        //===================================TABLA EMPLEADO========================================================//
        EmpleadoDao empleadoDao = new EmpleadoDao();
        Date date3 = new Date(2002 - 1900, 07, 31);
        Empleado E1 = new Empleado("U1234561T", "Jorge", "Torres", "105746923", "Calle Alonso Cano 13 ", "jorge@gmail.com", date3);
        Empleado E2 = new Empleado("Q8092134T", "Camilo", "Pardo", "635989812", "Calle Rodolfo Alvarez 14", "Camilo@gmail.com", date3);
        //clienteDao.insert(c1);
        //clienteDao.eliminar(c1);
        //clienteDao.actualizar(c1);
        //LISTAR OBJETOS Y CREAR ARCHIVO
        ArrayList<Empleado> Col3 = new ArrayList<Empleado>();
        Col3.add(E1);
        Col3.add(E2);
        String nombreArchivo3 = "EMPLEADOS.txt";
        ManejoDeArchivos.crearArchivo(nombreArchivo3);
        //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
        ManejoDeArchivos.escribirArchivo(nombreArchivo3, Col3);
        ManejoDeArchivos.leerArchivo(nombreArchivo3);
         //===================================TABLA LABORATORIO========================================================//
         LaboratorioDao laboratorioDao = new LaboratorioDao();
         Laboratorio L1 = new Laboratorio(1,"Kuantum Pharma","Kra 76","607873151");
         //laboratorioDao.insert(L1);
         laboratorioDao.actualizar(L1);
         
        //laboratorioDao.eliminar(L1);
         ArrayList<Laboratorio> Lab = new ArrayList<Laboratorio>();
         Lab.add(L1);
        String nombreArchivo4 = "LABORATORIOS.txt";
        ManejoDeArchivos.crearArchivo(nombreArchivo4);
        //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
        ManejoDeArchivos.escribirArchivo(nombreArchivo4, Lab);
        ManejoDeArchivos.leerArchivo(nombreArchivo4);
        //===================================TABLA DEPARTAMENTO========================================================//  
        DepartamentoDao departamentoDao = new DepartamentoDao();
        Departamento D1 = new Departamento(1,"Administración","Gestión administrativa del laboratorio");
        Departamento D2 = new Departamento(2,"Contabilidad","Gestión contable del laboratorio");
        //departamentoDao.insert(D2);
        //departamentoDao.actualizar(D2);
        //departamentoDao.eliminar(D1);
        ArrayList<Departamento> Dep = new ArrayList<Departamento>();
        Dep.add(D1);
        Dep.add(D2);
        
        String nombreArchivo5 = "DEPARTAMENTOS.txt";
        ManejoDeArchivos.crearArchivo(nombreArchivo5);
        //ENVIO PARAMETROS DEL NOMBRE DEL ARCHIVO, EL TOSTRING DEL OBJETO Y TEXTO QUE SE VISUALIZARA EN EL ARCHIVO      
        ManejoDeArchivos.escribirArchivo(nombreArchivo5, Dep);
        ManejoDeArchivos.leerArchivo(nombreArchivo5);
    }
     
    public static int alea(int li, int ls){//función de JAVA
        return (int)((Math.round(Math.random()*(ls-li))+li));
    }
    
}
