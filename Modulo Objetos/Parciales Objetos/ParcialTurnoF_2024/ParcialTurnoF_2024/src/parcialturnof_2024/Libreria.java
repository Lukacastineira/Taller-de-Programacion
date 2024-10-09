/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnof_2024;

/**
 *
 * @author Luka
 */
public class Libreria {
    private String nombre;
    private int nVentaAcutal;
    private int cantCajas;
    private Caja [] cajas;

    public Libreria(String nombre, int maxTicketsCaja) {
        this.setNombre(nombre);
        this.setCantCajas(4);
        this.setnVentaAcutal(0);
        this.cajas = new Caja [this.getCantCajas()];
        this.inicializarCajas(maxTicketsCaja);
    }

    public void inicializarCajas (int m){
        for (int i=0; i<this.getCantCajas();i++){
            this.cajas[i]= new Caja(m);
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getnVentaAcutal() {
        return nVentaAcutal;
    }

    public void setnVentaAcutal(int nVentaAcutal) {
        this.nVentaAcutal = nVentaAcutal;
    }

    public int getCantCajas() {
        return cantCajas;
    }

    public void setCantCajas(int cantCajas) {
        this.cantCajas = cantCajas;
    }
    
    public void generTicket (int nCaja, int dni, int cantComprada, double monto, String fPago){
        this.cajas[nCaja-1].agregarTicket(dni,cantComprada,monto,fPago,this.getnVentaAcutal());
        this.setnVentaAcutal(this.getnVentaAcutal()+1);
    }
    
    public void deshabilitarCajas (int X){
        for (int i=0; i<this.getCantCajas();i++){
            if (this.cajas[i].getTotal()<X){
                this.cajas[i].setDisponible(false);
            }
        }
    }
    
    public Ticket getMaxTicket (){
        Ticket max=null; double maxMonto=0;
        for (int i=0; i<this.getCantCajas(); i++){
            if (maxMonto < this.cajas[i].getMaxTicket().getMontoAbonado()){
                maxMonto = this.cajas[i].getMaxTicket().getMontoAbonado();
                max = this.cajas[i].getMaxTicket();
            }
        }  
        return max;
    }

    @Override
    public String toString() {
        String aux;
        aux= " Libreria: " + this.getNombre();
        for (int i=0; i<this.getCantCajas();i++){
            aux+= " Caja " + (i+1) + ": "  + this.cajas[i].toString() + "\n";
        }
        return aux;
    }
    
    
    
    
}
