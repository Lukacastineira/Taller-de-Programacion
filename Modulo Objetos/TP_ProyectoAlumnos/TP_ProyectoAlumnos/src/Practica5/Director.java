/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

/**
 *
 * @author Luka
 */
public class Director {
    private String nombre;
    private int dni;
    private int edad;
    private int antiguedad;

    public Director(String unNombre, int unDni, int unaEdad, int unaAntiguedad) {
        this.setNombre(unNombre);
        this.setDni(unDni);
        this.setEdad(unaEdad);
        this.setAntiguedad(unaAntiguedad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return  nombre + ", DNI: " + dni + ", Edad: " + edad + " y Antiguedad: " + antiguedad;
    }
    
    
    
}
