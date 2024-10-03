/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castineira;

/**
 *
 * @author Luka
 */
public class Venta {
    private int dni;
    private double cantLitrosCargados;
    private double montoAbonado;
    private String mediodePago;

    public Venta(int unDni, double unasCantLitrosCargados, double unMontoAbonado, String unMediodePago) {
        this.setDni(unDni);
        this.setCantLitrosCargados(unasCantLitrosCargados);
        this.setMontoAbonado(unMontoAbonado);
        this.setMediodePago(unMediodePago);  
    }


 
    
    
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getCantLitrosCargados() {
        return cantLitrosCargados;
    }

    public void setCantLitrosCargados(double cantLitrosCargados) {
        this.cantLitrosCargados = cantLitrosCargados;
    }

    public double getMontoAbonado() {
        return montoAbonado;
    }

    public void setMontoAbonado(double montoAbonado) {
        this.montoAbonado = montoAbonado;
    }

    public String getMediodePago() {
        return mediodePago;
    }

    public void setMediodePago(String mediodePago) {
        this.mediodePago = mediodePago;
    }

    @Override
    public String toString() {
        String aux;
        aux= " DNI: " + this.getDni() + ", Litros Cargados: " + this.getCantLitrosCargados() + ", monto: ";
        aux += + this.getMontoAbonado() + ", medio de Pago: " + this.getMediodePago() + " ";
        return aux;
    }
    
    
    
}
