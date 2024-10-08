/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoe_2024;

/**
 *
 * @author Luka
 */
public class Caja {
    private String nombreCajero;
    private int cantMaxTickets;
    private int cantTickets;
    private Ticket [] tickets;

    public Caja(String nombreCajero,int cantMaxTickets) {
        this.setNombreCajero(nombreCajero);
        this.setCantMaxTickets(cantMaxTickets);
        this.setCantTickets(0);
        this.tickets = new Ticket [this.getCantMaxTickets()];
        this.inicializarTickets(this.getCantMaxTickets());
    }
     
    public void agregarTicket (Ticket ticket){
        if (this.getCantTickets() < this.getCantMaxTickets()){
            this.tickets[this.getCantTickets()]=ticket;
            this.setCantTickets(this.getCantTickets()+1);
        }
        
    }
    
    
    public void inicializarTickets (int i){
        for (i=0;i<this.getCantMaxTickets();i++){
            this.tickets[i]=null;
        }
    }

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
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
    
    
    public int getTotal (){
        int total=0;
        for (int i=0; i<this.getCantTickets();i++){
            if (this.tickets[i].getMedioDePago().equals("credito")){
                total = total + 1;
            }
        }
        return total;
    }


    
    @Override
    public String toString() {
        String aux;
        aux = " Nombre Cajero: " + this.getNombreCajero() + ", Tickets Emitidos: \n";
        for (int i=0; i<this.getCantTickets();i++){
            aux += this.tickets[i].toString()+ "\n";
        }
       return aux;
    }
    
    
    
}
