/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnobtema2_2022;

/**
 *
 * @author Luka
 */
public class Comprador {
    private int dni;
    private String nombre;
    private String apellido;
    private String ciudad;

    public Comprador(int dni, String nombre, String apellido, String ciudad) {
        this.setDni(dni);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCiudad(ciudad);
    }

    
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        String aux;
        aux = " DNI: " + this.getDni() + ", Nombre: " + this.getNombre() + ", Apellido: " + this.getApellido() + ", Ciudad: " + this.getCiudad() + " ";
        return aux;
    }
    
    
    
}
