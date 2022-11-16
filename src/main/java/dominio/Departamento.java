/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;
import java.io.Serializable;
/**
 *
 * @author Alumno Mañana
 */
public class Departamento implements Serializable{
    private int ID_dep;
    private String Nombre;
    private String Descripcion;

    public Departamento() {
    }

    public Departamento(String Nombre, String Descripcion) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public Departamento(int ID_dep, String Nombre, String Descripcion) {
        this.ID_dep = ID_dep;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public int getID_dep() {
        return ID_dep;
    }

    public void setID_dep(int ID_dep) {
        this.ID_dep = ID_dep;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.ID_dep;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departamento other = (Departamento) obj;
        if (this.ID_dep != other.ID_dep) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Departamento{" + "ID_dep=" + ID_dep + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + '}';
    }
    
    
    
}
