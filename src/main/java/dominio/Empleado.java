/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import datos.ClienteDao;
import datos.EmpleadoDao;
import java.sql.Date;
import java.util.Objects;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Alumno Mañana
 */
public class Empleado implements Serializable{
    private String Nif;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Direccion;
    private String Email;
    private Date Fecha_Nac;
    private String Clave;

    public Empleado() {
    }

    public Empleado(String Nombre, String Apellido, String Telefono, String Direccion, String Email, Date Fecha_Nac, String Clave) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Email = Email;
        this.Fecha_Nac = Fecha_Nac;
        this.Clave = Clave;
    }

    public Empleado(String Nif, String Clave) {
        this.Nif = Nif;
        this.Clave = Clave;
    }
    

    public Empleado(String Nif, String Nombre, String Apellido, String Telefono, String Direccion, String Email, Date Fecha_Nac, String Clave) {
        this.Nif = Nif;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Email = Email;
        this.Fecha_Nac = Fecha_Nac;
    }

    public String getNif() {
        return Nif;
    }

    public void setNif(String Nif) {
        this.Nif = Nif;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getFecha_Nac() {
        return Fecha_Nac;
    }

    public void setFecha_Nac(Date Fecha_Nac) {
        this.Fecha_Nac = Fecha_Nac;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.Nif);
        hash = 41 * hash + Objects.hashCode(this.Email);
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
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.Nif, other.Nif)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        return true;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    @Override
    public String toString() {
        return "%" + Nif + "/" + Nombre + "/" + Apellido + "/" + Telefono + "/" + Direccion + "/" + Email + "/" + Fecha_Nac + "/" + Clave;
    }

   
     
     public static List<Empleado> listarClientesDec() {
        EmpleadoDao empleadoDao = new EmpleadoDao();
        List<Empleado> usuarios = null;
        
        try {
            usuarios = empleadoDao.seleccionardesencriptar();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return usuarios;
    }
    
    
}
