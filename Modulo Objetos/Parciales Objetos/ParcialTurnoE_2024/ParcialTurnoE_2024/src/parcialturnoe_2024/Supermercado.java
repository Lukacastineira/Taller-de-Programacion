/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoe_2024;

/**
 *
 * @author Luka
 */
public class Supermercado {
    private String direccion;
    private int nVentaActual;
    private int cantMaxCajas;
    private int cantCajas;
    private Caja [] cajas;

    public Supermercado(String direccion) {
        this.setDireccion(direccion);
        this.setCantMaxCajas(5);
        this.cajas = new Caja [this.getCantMaxCajas()];
        this.inicializarCaja(this.getCantMaxCajas());
        this.setnVentaActual(0);
    }

    
    
    public void inicializarCaja (int i){
        for (i=0;i<this.getCantMaxCajas();i++){
            this.cajas[i]=null;
        }
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getnVentaActual() {
        return nVentaActual;
    }

    public void setnVentaActual(int nVentaActual) {
        this.nVentaActual = nVentaActual;
    }

    public int getCantMaxCajas() {
        return cantMaxCajas;
    }

    public void setCantMaxCajas(int cantMaxCajas) {
        this.cantMaxCajas = cantMaxCajas;
    }

    public int getCantCajas() {
        return cantCajas;
    }

    public void setCantCajas(int cantCajas) {
        this.cantCajas = cantCajas;
    }
    
    public void agregarCaja (Caja caja){
        if (this.getCantCajas() < this.getCantMaxCajas()){
            this.cajas[this.getCantCajas()]=caja;
            this.setCantCajas(this.getCantCajas()+1);
        }
    }
    
    public void agregarenCajaEspecifica (int nCaja, int cuit, int cantProduct, double monto, String formaPago){
        this.cajas[nCaja-1].agregarTicket(new Ticket (this.getnVentaActual(),cuit,cantProduct,monto,formaPago));
        this.setnVentaActual(this.getnVentaActual()+1);
    }
    
    public int nCajaMenorTickets (){
        int nCaja=0; int min=9999;
        for (int i=0; i<this.getCantCajas();i++){
            if (min > this.cajas[i].getTotal()){
                min = this.cajas[i].getTotal();
                nCaja = (i+1);
            }
                
        }
        return nCaja;
    }

    @Override
    public String toString() {
        String aux;
        aux = "Supermercado: con direccion: " + this.getDireccion() + " y una cantidad de " + this.getCantCajas() + " cajas. \n";
        for (int i=0; i<this.getCantCajas();i++){
            aux += "Caja " + (i+1) + ":" + this.cajas[i].toString() + "\n";
        }
        return aux;
    }
    
    
    
    
}
