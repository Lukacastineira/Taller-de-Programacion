/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoftema1_2023;

/**
 *
 * @author Luka
 */
public class Encargado extends Empleado {
    private int cantEmpleadosaCargo;

    public Encargado(String nombre, int dni, int anioIngreso, double sueldoBasico, int empleadosACargo) {
        super(nombre, dni, anioIngreso, sueldoBasico);
        this.setCantEmpleadosaCargo(empleadosACargo);
    }

    public int getCantEmpleadosaCargo() {
        return cantEmpleadosaCargo;
    }

    public void setCantEmpleadosaCargo(int cantEmpleadosaCargo) {
        this.cantEmpleadosaCargo = cantEmpleadosaCargo;
    }

    @Override
    public double getSueldoaCobrarFinal() {
       double sueldoFinal= this.getSueldoaCobrar(); 
       sueldoFinal= sueldoFinal + (this.getCantEmpleadosaCargo()*1000);
       return sueldoFinal;
    }

    @Override
    public String toString() {
        String aux;
        aux = super.toString() + " sueldo a cobrar: " + this.getSueldoaCobrarFinal();
        return aux;
    }
    
    
    
    
}
