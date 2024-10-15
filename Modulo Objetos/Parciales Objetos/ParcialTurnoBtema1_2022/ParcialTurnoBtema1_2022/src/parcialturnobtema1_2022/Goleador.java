/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnobtema1_2022;

/**
 *
 * @author Luka
 */
public class Goleador {
    private String nombre;
    private String equipo;
    private int cantGolesFecha;

    public Goleador(String nombre, String equipo, int cantGolesFecha) {
        this.setNombre(nombre);
        this.setEquipo(equipo);
        this.setCantGolesFecha(cantGolesFecha);
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getCantGolesFecha() {
        return cantGolesFecha;
    }

    public void setCantGolesFecha(int cantGolesFecha) {
        this.cantGolesFecha = cantGolesFecha;
    }

    @Override
    public String toString() {
        String aux;
        aux= " Nombre: " + this.getNombre() + ", Equipo: " + this.getEquipo()+ ", Cantidad de Goles: " + this.getCantGolesFecha() + " ";
        return aux;
    }
    
    
    
    
}
