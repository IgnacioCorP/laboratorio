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
public class Laboratorio implements Serializable{
     private int ID_lab;
     private String Nombre_sede;
     private String Direccion;
     private String Telefono;

    public Laboratorio() {
    }

    public Laboratorio(String Nombre_sede, String Direccion, String Telefono) {
        this.Nombre_sede = Nombre_sede;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    public Laboratorio(int ID_lab, String Nombre_sede, String Direccion, String Telefono) {
        this.ID_lab = ID_lab;
        this.Nombre_sede = Nombre_sede;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    public int getID_lab() {
        return ID_lab;
    }

    public void setID_lab(int ID_lab) {
        this.ID_lab = ID_lab;
    }

    public String getNombre_sede() {
        return Nombre_sede;
    }

    public void setNombre_sede(String Nombre_sede) {
        this.Nombre_sede = Nombre_sede;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.ID_lab;
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
        final Laboratorio other = (Laboratorio) obj;
        if (this.ID_lab != other.ID_lab) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Laboratorio{" + "ID_lab=" + ID_lab + ", Nombre_sede=" + Nombre_sede + ", Direccion=" + Direccion + ", Telefono=" + Telefono + '}';
    }
     
     
     
}
