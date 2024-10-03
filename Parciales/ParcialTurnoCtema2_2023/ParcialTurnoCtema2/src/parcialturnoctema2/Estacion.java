/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoctema2;

public class Estacion {
    private String direc;
    private double precio;
    private Surtidor [] surtidores;
    private int cantSurtidoresMax;
    private int cantSurtidores=0;
    private int maxVentasSurtidor;

    public Estacion(String direc, double precio, int cantSurtidoresMax, int unaMaxVentaSurtidor) {
        this.setDirec(direc);
        this.setPrecio(precio);
        this.setCantSurtidoresMax(cantSurtidoresMax);
        this.setMaxVentasSurtidor(unaMaxVentaSurtidor);
        this.surtidores = new Surtidor [this.getCantSurtidoresMax()];
        for (int i=0; i<this.getCantSurtidoresMax(); i++){
            this.agregarSurtidor(new Surtidor (true,this.getMaxVentasSurtidor()));
        }
        
    }
  
    
    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Surtidor[] getSurtidores() {
        return surtidores;
    }

    public int getCantSurtidoresMax() {
        return cantSurtidoresMax;
    }

    public void setCantSurtidoresMax(int cantSurtidoresMax) {
        this.cantSurtidoresMax = cantSurtidoresMax;
    }

    public int getCantSurtidores() {
        return cantSurtidores;
    }

    public void setCantSurtidores(int cantSurtidores) {
        this.cantSurtidores = cantSurtidores;
    }

    public int getMaxVentasSurtidor() {
        return maxVentasSurtidor;
    }

    public void setMaxVentasSurtidor(int maxVentasSurtidor) {
        this.maxVentasSurtidor = maxVentasSurtidor;
    }

  
    public void agregarSurtidor (Surtidor surti){
        if (this.getCantSurtidores()<this.getCantSurtidoresMax()){
            this.getSurtidores()[this.getCantSurtidores()]= surti;
            this.setCantSurtidores(this.getCantSurtidores()+1);
        }
    }
    
    public void incisoA (int unDni,int nSurtidor, double cantCargada, String formaPago){
        this.getSurtidores()[nSurtidor-1].agregarVenta(new Venta (unDni,cantCargada,cantCargada * this.getPrecio(),formaPago));
    }
    
    public void incisoB (int X){
        for (int i=0;i<this.getCantSurtidores();i++){
            if (X > this.getSurtidores()[i].getTotalCargado()){
                this.getSurtidores()[i].setenServicio(false);
            }
        }
    }
    
    public Venta incisoC (){
        double maxVenta=0; Venta maxVent=null;
        for (int i=0;i<this.getCantSurtidores();i++){
           if (maxVenta < this.getSurtidores()[i].getMaxVenta().getMontoAbonado()){
               maxVenta = this.getSurtidores()[i].getMaxVenta().getMontoAbonado();
               maxVent =this.getSurtidores()[i].getMaxVenta();
           }
                  
        }
        return maxVent;
    }

    @Override
    public String toString() {
        String aux;
        aux = "Estacion direccion: " + direc + ", precio m3 de gas: " + precio + "\n";
        for (int i=0;i < this.getCantSurtidores();i++){
            aux += " Surtidor " + (i+1) + this.getSurtidores()[i].toString() + "\n";
        }
        return aux;
    }
    
    
    
}
