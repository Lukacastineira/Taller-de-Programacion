/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoftema1_2023;

/**
 *
 * @author Luka
 */
public class Director extends Empleado {
    private double montoViaticos;

    public Director(String nombre, int dni, int anioIngreso, double sueldoBasico, double montoViaticos) {
        super(nombre, dni, anioIngreso, sueldoBasico);
        this.setMontoViaticos(montoViaticos);        
    }

    public double getMontoViaticos() {
        return montoViaticos;
    }

    public void setMontoViaticos(double montoViaticos) {
        this.montoViaticos = montoViaticos;
    }

    @Override
    public double getSueldoaCobrarFinal() {
        double sueldoFinal = this.getSueldoaCobrar();
        sueldoFinal = sueldoFinal + (this.getMontoViaticos());
        return sueldoFinal;
    }

    @Override
    public String toString() {
        String aux;
        aux = super.toString() + " sueldo a cobrar: " + this.getSueldoaCobrarFinal();
        return aux;
    }
    
    
    
}
