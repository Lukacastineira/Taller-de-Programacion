/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnok_2024;

/**
 *
 * @author Luka
 */
public class Programador {
    private String nombre;
    private int dni;
    private double sueldoBasico;
    private int cantLineasCodidoHora;
    private String lenguaje;

    public Programador(String nombre, int dni, double sueldoBasico, int cantLineasCodidoHora, String lenguaje) {
        this.setNombre(nombre);
        this.setDni(dni);
        this.setSueldoBasico(sueldoBasico);
        this.setCantLineasCodidoHora(cantLineasCodidoHora);
        this.setLenguaje(lenguaje);
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

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int getCantLineasCodidoHora() {
        return cantLineasCodidoHora;
    }

    public void setCantLineasCodidoHora(int cantLineasCodidoHora) {
        this.cantLineasCodidoHora = cantLineasCodidoHora;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
    
    public double getSueldoFinal (){
        double final1;
        if (this.getCantLineasCodidoHora()>200){
            final1 = this.getSueldoBasico() + 50000;
        }else{
            final1 = this.getSueldoBasico();
        }
        return final1;
    }

    @Override
    public String toString() {
        String aux;
        aux = " Nombre: " + this.getNombre() + ", DNI: " + this.getDni() + ", Lenguaje: " + this.getLenguaje()+ " Sueldo Final: "+ this.getSueldoFinal() + " ";
        return aux;
    }
    
    
    
    
    
}
