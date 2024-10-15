/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoptema2_2024;

/**
 *
 * @author Luka
 */
public abstract class Componente {
    private String nombre;
    private double costo;

    public Componente(String nombre, double costo) {
        this.setNombre(nombre);
        this.setCosto(costo);
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public abstract double getCostoFinal ();

    @Override
    public String toString() {
        String aux;
        aux = " Nombre: " + this.getNombre() + ", Costo: " + this.getCosto() + " ";
        return aux;
    }
    
    
    
    
    
    
    
}
