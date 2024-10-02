/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

/**
 *
 * @author Luka
 */
public abstract class Coro {
    private String nombre;
    private Director director;

    public Coro (String nombreCoro, Director unDirec){
        this.setNombre(nombreCoro);
        this.setDirector(unDirec);
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Director getDirector() {
        return this.director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
    
    
    
    public abstract boolean estaLleno ();
    
    public abstract void agregarCorista(Corista co);
    
    public abstract boolean bienFormado ();

    @Override
    public String toString() {
        String aux;
        aux = " El coro de nombre, " + nombre + " y director: " + this.getDirector().toString();
        return aux;
    }
    
    
    
}   

