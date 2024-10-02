/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

import PaqueteLectura.GeneradorAleatorio;


public class Habitacion {
    private double costoNoche;
    private boolean ocupada;
    Persona cliente;

    
    public Habitacion() {
        GeneradorAleatorio.iniciar();
        this.costoNoche = GeneradorAleatorio.generarDouble(6001)+2000;
        this.ocupada = false;
        this.cliente = null;
    }

    public double getCostoNoche() {
        return costoNoche;
    }

    public void setCostoNoche(double costoNoche) {
        this.costoNoche = costoNoche;
    }

    public boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean estado) {
        this.ocupada = estado;
    }
    
    public void ocupar(){
        this.ocupada=true;
    }
    
    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }
    
    public Persona siOcupada  () {
        if (ocupada){
            return cliente;
        }
        return null;
    }
    
    @Override
    public String toString (){
        String aux;
        if (ocupada == true) {
            aux = "El costo por noche es: " +  costoNoche  + " esta ocupada, " +  "La reservo: " + cliente.toString();          
        }
        else 
           aux = "El costo por noche es: " +  costoNoche  + " esta desocupada." ;    
        return aux;
    }
    
}
