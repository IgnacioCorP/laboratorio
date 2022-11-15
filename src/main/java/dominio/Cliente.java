                                /* ENTIDAD CLIENTE - COMPRA PRODUCTOS */


package dominio;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Nicolas Correa
 */
public class Cliente {
    private String Nif;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Email;
    private Date Fecha_nac;

    public Cliente() {
    }

    public Cliente(String Nif, String Nombre, String Apellido, String Telefono, String Email, Date Fecha_nac) {
        this.Nif = Nif;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Fecha_nac = Fecha_nac;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getFecha_nac() {
        return Fecha_nac;
    }

    public void setFecha_nac(Date Fecha_nac) {
        this.Fecha_nac = Fecha_nac;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.Nif);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.Nif, other.Nif)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "%Cliente: " + "Nif: " + Nif + ", Nombre: " + Nombre + ", Apellido: " + Apellido + ", Telefono: " + Telefono + ", Email: " + Email + ", Fecha_nac: " + Fecha_nac;
    }
    
    
    
    
}
