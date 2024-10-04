/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParcialEscueladeCanto;

/**
 *
 * @author Luka
 */
public class Estudiante {
    private String nombre;
    private String apellido;
    private int dni;

    public Estudiante(String unNombre, String unApellido, int unDni) {
        this.setNombre(unNombre);
        this.setApellido(unApellido);
        this.setDni(unDni);
    }

    public Estudiante() {
        this.setNombre("sinNombre");
        this.setApellido("sinApellido");
        this.setDni(-1);
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        String aux;
        aux= "El Estudiante de nombre: " + nombre + ", Apellido: " + apellido + ", DNI: " + dni + " .";
        return aux;
    }
    
    
    
    
}
