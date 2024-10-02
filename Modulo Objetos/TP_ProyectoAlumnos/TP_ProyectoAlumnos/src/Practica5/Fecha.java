/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

/**
 *
 * @author Luka
 */
public class Fecha {
    private String ciudad;
    private int dia;

    public Fecha(String unaCiudad, int unDia) {
        this.setCiudad(unaCiudad);
        this.setDia(unDia);
    }
    
    public Fecha (){
        this.setCiudad("sinCiudad");
        this.setDia(-1);
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    
    
}
