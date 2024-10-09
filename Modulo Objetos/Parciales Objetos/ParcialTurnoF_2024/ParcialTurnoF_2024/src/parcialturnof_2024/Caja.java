/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnof_2024;

/**
 *
 * @author Luka
 */
public class Caja {
    private boolean disponible;
    private int cantMaxTickets;
    private int cantTickets;
    private Ticket [] tickets;

    public Caja(int cantMaxTickets) {
        this.setDisponible(true);
        this.setCantMaxTickets(cantMaxTickets);
        this.setCantTickets(0);
        this.tickets = new Ticket[this.getCantMaxTickets()];
        this.inicializarTickets();
    }

    public void inicializarTickets (){
        for (int i=0; i<this.getCantMaxTickets();i++){
            this.tickets[i]=null;
        }
    }
    
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getCantMaxTickets() {
        return cantMaxTickets;
    }

    public void setCantMaxTickets(int cantMaxTickets) {
        this.cantMaxTickets = cantMaxTickets;
    }

    public int getCantTickets() {
        return cantTickets;
    }

    public void setCantTickets(int cantTickets) {
        this.cantTickets = cantTickets;
    }
    
    public void agregarTicket (int dni, int cantComprada, double monto, String fPago, int nVentaActual){
        if (this.getCantTickets() < this.getCantMaxTickets()){
            this.tickets[this.getCantTickets()] = new Ticket (nVentaActual,dni,cantComprada,monto,fPago);
            this.setCantTickets(this.getCantTickets()+1);
        }
    }
    
    public int getTotal (){
        int total=0;
        for (int i=0; i<this.getCantTickets();i++){
            total = total + this.tickets[i].getCantLibrosComprados();
        }
        return total;
    }
    
    public Ticket getMaxTicket (){
        double max=0; int nTicket=0; Ticket tick=null;
        for (int i=0;i<this.getCantTickets();i++){
            if (max < this.tickets[i].getMontoAbonado()){
                max = this.tickets[i].getMontoAbonado();
                nTicket= i;
            }
        }
        tick = this.tickets[nTicket];
        return tick;
    }

    @Override
    public String toString() {
        String aux;
        aux = " Disponible: " + this.isDisponible();
        for (int i=0; i<this.getCantTickets();i++){
            aux += " Tickets emitidos: "+ this.tickets[i].toString() + "\n";
        }
        return aux;
    }
    
    
    
}
