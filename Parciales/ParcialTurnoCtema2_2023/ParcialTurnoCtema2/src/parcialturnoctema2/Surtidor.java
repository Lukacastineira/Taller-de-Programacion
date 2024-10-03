/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoctema2;

/**
 *
 * @author Luka
 */
public class Surtidor {
    private boolean enServicio;
    private Venta [] ventas;
    private int maxVentas;
    private int cantVentas=0;

    public Surtidor(boolean enServicio, int maxVentas) {
        this.setenServicio(enServicio);
        this.setMaxVentas(maxVentas);
        this.ventas = new Venta [this.getMaxVentas()];
        for (int i=0; i<this.getMaxVentas();i++){
            this.getVentas()[i]=null;
        }
    }

    
    
    
    
    public boolean isEnServicio() {
        return enServicio;
    }

    public void setenServicio(boolean fueradeServicio) {
        this.enServicio = fueradeServicio;
    }

    public int getMaxVentas() {
        return maxVentas;
    }

    public void setMaxVentas(int maxVentas) {
        this.maxVentas = maxVentas;
    }

    public int getCantVentas() {
        return cantVentas;
    }

    public void setCantVentas(int cantVentas) {
        this.cantVentas = cantVentas;
    }

    public Venta[] getVentas() {
        return ventas;
    }

    public void agregarVenta (Venta vent){
        if (this.getCantVentas()<this.getMaxVentas()){
          this.getVentas()[this.getCantVentas()]=vent;
          this.setCantVentas(this.getCantVentas()+1);
        }
    }
    
    public double getTotalCargado (){
        double total=0;
        for (int i=0; i<this.getCantVentas();i++){
              total = (total + this.getVentas()[i].getCantcargada());
        }
        return total;
    }
    
    public Venta getMaxVenta (){
        double maxVenta=0; Venta maxVent=null;
        for (int i=0;i<this.getCantVentas();i++){
            if (maxVenta < this.getVentas()[i].getMontoAbonado()){
                maxVenta = this.getVentas()[i].getMontoAbonado();
                maxVent=this.getVentas()[i];
            }
        }
        return maxVent;
    }

    @Override
    public String toString() {
        String aux;
        aux = "En Servicio: " + enServicio;
        for (int i=0; i<this.getCantVentas();i++){
            aux+=  " Venta "+ (i+1)+ " : "+this.getVentas()[i].toString() + "\n";
        }
        return aux;
    }
    
    
    
}
