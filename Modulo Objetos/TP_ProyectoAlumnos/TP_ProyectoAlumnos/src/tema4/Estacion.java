/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author Luka
 */
public class Estacion {
    private String nombre;
    private double latitud;
    private double longitud;

    public Estacion(String nombre, double latitud, double longitud) {
        this.setNombre(nombre);
        this.setLatitud(latitud); 
        this.setLongitud(longitud);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        String aux =  " Estacion: " +  nombre + ", (latitud: " + latitud; 
               aux += ", longitud: " + longitud + ")";
        return aux;
    }
    
    
    
}
