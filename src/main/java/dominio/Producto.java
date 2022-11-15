/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.sql.Date;

/**
 *
 * @author Alumno Mañana
 */
public class Producto {
     private int ID_pro;
     private String Nombre;
     private double Precio;
     private Date Fecha_caducidad;
     int ContProd = 0;
     
     public Producto() {
        ContProd++;
        this.ID_pro = ContProd;
    }

    public Producto(String Nombre, double Precio, Date Fecha_caducidad) {
        
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Fecha_caducidad = Fecha_caducidad;
    }

    public Producto(int ID_pro, String Nombre, double Precio, Date Fecha_caducidad) {
        
        this.ID_pro = ID_pro;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Fecha_caducidad = Fecha_caducidad;
    }

    public int getID_pro() {
        return ID_pro;
    }

    public void setID_pro(int ID_pro) {
        this.ID_pro = ID_pro;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public Date getFecha_caducidad() {
        return Fecha_caducidad;
    }

    public void setFecha_caducidad(Date Fecha_caducidad) {
        this.Fecha_caducidad = Fecha_caducidad;
    }

    public int getContProd() {
        return ContProd;
    }

    public void setContProd(int ContProd) {
        this.ContProd = ContProd;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.ID_pro;
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
        final Producto other = (Producto) obj;
        if (this.ID_pro != other.ID_pro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "%Producto" + "ID: " + ID_pro + ", Nombre: " + Nombre + ", Precio: " + Precio + ", Fecha_caducidad: " + Fecha_caducidad;
    }
     
     
     
}
