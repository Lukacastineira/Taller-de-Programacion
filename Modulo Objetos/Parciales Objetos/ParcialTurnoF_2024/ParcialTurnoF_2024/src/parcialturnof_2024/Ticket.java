/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnof_2024;

/**
 *
 * @author Luka
 */
public class Ticket {
    private int numeroTicket;
    private int dni;
    private int cantLibrosComprados;
    private double montoAbonado;
    private String medioPago; // (debito, credito o efectivo).

    public Ticket(int numeroTicket, int dni, int cantLibrosComprados, double montoAbonado, String medioPago) {
        this.setNumeroTicket(numeroTicket);
        this.setDni(dni);
        this.setCantLibrosComprados(cantLibrosComprados);
        this.setMontoAbonado(montoAbonado);
        this.setMedioPago(medioPago);
    }

    
    
    
    public int getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCantLibrosComprados() {
        return cantLibrosComprados;
    }

    public void setCantLibrosComprados(int cantLibrosComprados) {
        this.cantLibrosComprados = cantLibrosComprados;
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
        aux = " Numero de Ticket: " + (this.getNumeroTicket()+1) + ", DNI: " + this.getDni();
        aux += ", cantidad de Libros Comprados: " + this.getCantLibrosComprados() + ", Monto Abonado: " + this.getMontoAbonado() + ", Medio de Pago: " + this.getMedioPago();
        return aux;
    }
    
    
    
    
}
