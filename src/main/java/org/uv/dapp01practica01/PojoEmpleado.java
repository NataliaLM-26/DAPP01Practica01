package org.uv.dapp01practica01;

/**
 * @author miran
 * 
 * Plain Old Java Object
 * DTO
 * Maping --- ORM
 */
public class PojoEmpleado {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return 
                "id:" + id +
                ", nombre: " + nombre + 
                ", direccion:" + direccion +
                ", telefono:" + telefono + '\n';
    }
}
