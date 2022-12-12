/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NegocioInterfaces;

import dominio.Departamento;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface InterfazNeDep {
     public  List<Departamento> listarDepartamentosDec();
     public Departamento crear();
     public Departamento actualizar2();
     public Departamento eliminar2();
     public Departamento visualizar2();
     public Departamento buscar2();
}
