/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

/**
 *
 * @author Luka
 */
public class Corista {
    private String nombre;
    private int dni;
    private int edad;
    private int tono;

    public Corista(String unNombre, int unDni, int unaEdad, int unTono) {
        this.setNombre(unNombre);
        this.setDni(unDni);
        this.setEdad(unaEdad);
        this.setTono(unTono);
    }

    public Corista() {
        this.setNombre("sinNobre");
        this.setDni(-1);
        this.setEdad(-1);
        this.setTono(-1);
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

    public int getTono() {
        return tono;
    }

    public void setTono(int tono) {
        this.tono = tono;
    }

    @Override
    public String toString() {
        String aux;
           aux=     " El Corista de Nombre=" + nombre + ", dni: " + dni;
           aux+= ", edad: " + edad + " y tono: " + tono  + "";
        return aux;
    }
    
   
}
