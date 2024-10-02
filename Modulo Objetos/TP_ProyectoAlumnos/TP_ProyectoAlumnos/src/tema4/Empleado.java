/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author Luka
 */
public abstract class Empleado {
    private String nombre; 
    private double sueldoBasico;
    private int antiguedad;

    public Empleado(String unNombre, double unSueldoBasico, int unaAntiguedad) {
        this.setNombre(unNombre);
        this.setSueldoBasico(unSueldoBasico);
        this.setAntiguedad(unaAntiguedad);
    }

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public abstract double calcularEfectividad ();
    
    public double sueldoBase (){
        return this.getSueldoBasico() * (this.getAntiguedad()*1.1);
    }
    
    public abstract double calcularSueldoACobrar ();
    
    @Override
    public String toString() {
        String aux = " Nombre: " + this.getNombre();
               aux+= ", sueldo a Cobrar: " + this.calcularSueldoACobrar() + ", Efectividad: " ;
                 aux+= this.calcularEfectividad();
        return aux;
    }
  
    
    
}
