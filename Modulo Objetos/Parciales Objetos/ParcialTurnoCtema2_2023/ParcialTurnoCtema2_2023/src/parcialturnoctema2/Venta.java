/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoctema2;

/**
 *
 * @author Luka
 */
public class Venta {
    private int dni;
    private double cantcargada;
    private double montoAbonado;
    private String medioPago;

    public Venta(int unDni, double unaCantcargada, double unMontoAbonado, String unMedioPago) {
        this.setDni(unDni);
        this.setCantcargada(unaCantcargada);
        this.setMontoAbonado(unMontoAbonado);
        this.setMedioPago(unMedioPago);     
    }

    public Venta() {
        this.setDni(-1);
        this.setCantcargada(-1);
        this.setMontoAbonado(-1);
        this.setMedioPago("sinMediodePago  "); 
    }

    
    
    
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getCantcargada() {
        return cantcargada;
    }

    public void setCantcargada(double cantcargada) {
        this.cantcargada = cantcargada;
    }

    public double getMontoAbonado() {
        return montoAbonado;
    }

    public void setMontoAbonado(double montoAbonado) {
        this.montoAbonado = montoAbonado;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    @Override
    public String toString() {
        String aux;
        aux= " DNI: " + dni + ", cantidad cargada: " + cantcargada + ", monto Abonado: ";
        aux+=  + montoAbonado + ", Medio de Pago: " + medioPago + " .";
        return aux;
    }
    
    
    
}
