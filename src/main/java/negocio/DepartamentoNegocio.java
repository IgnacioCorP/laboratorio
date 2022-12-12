package negocio;

import Interfaces.InterfazDep;
import ManejoArchivos.ManejoDeArchivos;
import static MysqlTest.MysqlTest.ent;
import NegocioInterfaces.InterfazNeDep;
import datos.DepartamentoDao;
import dominio.Departamento;
import dominio.Producto;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DepartamentoNegocio implements InterfazNeDep {

    Departamento DD = new Departamento();
    InterfazDep departamentoDao = new DepartamentoDao();
    String nombreArchivo4 = "DEPARTAMENTOS.txt";

    public List<Departamento> listarDepartamentosDec() {
        DepartamentoDao departamentoDao = new DepartamentoDao();
        List<Departamento> departamentos = null;

        try {
            departamentos = departamentoDao.seleccionar();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return departamentos;
    }

    public Departamento crear() {
        System.out.println("INTRODUZCA NOMBRE DEL DEPARTAMENTO: ");
        Scanner NOM = new Scanner(System.in);
        String NOMS = String.valueOf(NOM.nextLine());
        DD.setNombre(NOMS);

        System.out.println("INTRODUZCA DESCRIPCIÓN DEL DEPARTAMENTO: ");
        Scanner Des = new Scanner(System.in);
        String DESC = String.valueOf(Des.nextLine());
        DD.setDescripcion(DESC);

        System.out.println("=============DEPARTAMENTO AÑADIDO CORRECTAMENTE=========================");

        departamentoDao.insert(DD);
        ManejoDeArchivos.escribirArchivo(nombreArchivo4, DD.toString());
        return null;
    }

    public Departamento actualizar2() {
        Scanner sm = new Scanner(System.in);
        System.out.println("INTRODUZCA ID DE DEPARTAMENTO: ");
        int idd = sm.nextInt();
        for (int i = 0; i < listarDepartamentosDec().size(); i++) {
            if (idd == listarDepartamentosDec().get(i).getID_dep()) {
                DD = listarDepartamentosDec().get(i);

                System.out.println("INTRODUZCA NOMBRE DEL DEPARTAMENTO: ");
                Scanner NOMs = new Scanner(System.in);
                String NOMS = String.valueOf(NOMs.nextLine());
                DD.setNombre(NOMS);

                System.out.println("INTRODUZCA DESCRIPCIÓN DEL DEPARTAMENTO: ");
                Scanner DesS = new Scanner(System.in);
                String DESCS = String.valueOf(DesS.nextLine());
                DD.setDescripcion(DESCS);

                departamentoDao.actualizar(DD);
                ManejoDeArchivos.escribirArchivo(nombreArchivo4, DD.toString());

            }
        }
        return null;
    }

    public Departamento eliminar2() {
        System.out.println("INTRODUZCA ID DE DEPARTAMENTO: ");
        int iiidd = ent.nextInt();
        int y;
        for (int i = 0; i < listarDepartamentosDec().size(); i++) {
            if (iiidd == listarDepartamentosDec().get(i).getID_dep()) {
                DD = listarDepartamentosDec().get(i);
                System.out.println("¿Desea eliminar " + listarDepartamentosDec().get(i).getNombre() + "?  / 'SI(0)' o 'NO(1)'");
                y = ent.nextInt();
                if (y == 0) {
                    departamentoDao.eliminar(DD);
                    ManejoDeArchivos.escribirArchivo(nombreArchivo4, DD.toString());
                    System.out.println("SE HA ELIMINADO CORREACTAMENTE");

                } else if (y == 1) {
                    System.out.println("NO SE HA ELIMINADO");
                }
            }
        }
        return null;
    }

    public Departamento visualizar2() {
        try {
            List<Departamento> departamentos = departamentoDao.seleccionar();
            departamentos.forEach(Departamento -> {
                System.out.println("Departamento = " + Departamento);
            }
            );
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
