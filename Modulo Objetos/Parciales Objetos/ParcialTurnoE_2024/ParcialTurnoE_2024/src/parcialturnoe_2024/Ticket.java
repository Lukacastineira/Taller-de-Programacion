/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoe_2024;

/**
 *
 * @author Luka
 */
public class Ticket {
    private int nTicket;
    private int cuitCliente;
    private int cantProductosComp;
    private double montoAbonado;
    private String medioDePago;  //debito credito efectivo 

    public Ticket(int nTicket, int cuitCliente, int cantProductosComp, double montoAbonado, String medioDePago) {
        this.setnTicket(nTicket);
        this.setCuitCliente(cuitCliente);
        this.setCantProductosComp(cantProductosComp);
        this.setMontoAbonado(montoAbonado);
        this.setMedioDePago(medioDePago);
    }

    
    public int getnTicket() {
        return nTicket;
    }

    public void setnTicket(int nTicket) {
        this.nTicket = nTicket;
    }

    public int getCuitCliente() {
        return cuitCliente;
    }

    public void setCuitCliente(int cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    public int getCantProductosComp() {
        return cantProductosComp;
    }

    public void setCantProductosComp(int cantProductosComp) {
        this.cantProductosComp = cantProductosComp;
    }

    public double getMontoAbonado() {
        return montoAbonado;
    }

    public void setMontoAbonado(double montoAbonado) {
        this.montoAbonado = montoAbonado;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

    @Override
    public String toString() {
        String aux;
        aux = " Numero de Ticket: " + (this.getnTicket()+1) + ", CUIT: " + this.getCuitCliente();
        aux += ", la cantidad de productos: " + this.getCantProductosComp() ;
        aux += " Monto Abonado: " + this.getMontoAbonado() + ", Medio de Pago: " + this.getMedioDePago();
        return aux;
    }
    
    
    
    
    
    
    
}
