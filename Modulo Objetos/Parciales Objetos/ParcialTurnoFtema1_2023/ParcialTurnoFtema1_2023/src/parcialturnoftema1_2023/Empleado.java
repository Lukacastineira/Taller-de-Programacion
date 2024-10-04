/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoftema1_2023;

/**
 *
 * @author Luka
 */
public abstract class Empleado {
    private String nombre;
    private int dni;
    private int anioIngreso;
    private double sueldoBasico;

    public Empleado(String nombre, int dni, int anioIngreso, double sueldoBasico) {
        this.setNombre(nombre);
        this.setDni(dni);
        this.setAnioIngreso(anioIngreso);
        this.setSueldoBasico(sueldoBasico);
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

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    @Override
    public String toString() {
        String aux;
        aux= " Nombre: " + this.getNombre() + ", dni=" + this.getDni();
        return aux;
    }
    
    
    public double getSueldoaCobrar (){
        int cantAnios = 2024 - this.getAnioIngreso(); double sueldo= this.getSueldoBasico();
        if (cantAnios > 20){
           sueldo =  sueldo *1.10;
        }
      return sueldo;
    }
    
    public abstract double getSueldoaCobrarFinal();
    
}
