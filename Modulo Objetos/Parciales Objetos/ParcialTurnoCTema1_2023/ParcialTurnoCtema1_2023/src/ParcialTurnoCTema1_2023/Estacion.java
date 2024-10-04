/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParcialTurnoCTema1_2023;

/**
 *
 * @author Luka
 */
public class Estacion {
    private int direc;
    private int cantMaxSurtidores;
    private int cantSurtidores=0;
    private Surtidor [] surtidores;

    public Estacion(int unaDirec) {
        this.setDirec(unaDirec);
        this.setCantMaxSurtidores(6);
        this.setSurtidor(this.getCantMaxSurtidores());
    }   
    
    public int getDirec() {
        return direc;
    }

    public void setDirec(int direc) {
        this.direc = direc;
    }

    public int getCantMaxSurtidores() {
        return cantMaxSurtidores;
    }

    public void setCantMaxSurtidores(int cantMaxSurtidores) {
        this.cantMaxSurtidores = cantMaxSurtidores;
    }

    public Surtidor[] getSurtidores() {
        return surtidores;
    }

    public void setSurtidores(Surtidor[] surtidores) {
        this.surtidores = surtidores;
    }
    
    public void setSurtidor (int i){
        this.surtidores = new Surtidor [i];
    }

    public int getCantSurtidores() {
        return cantSurtidores;
    }

    public void setCantSurtidores(int cantSurtidores) {
        this.cantSurtidores = cantSurtidores;
    }
  
    
    
    public void agregarSurtidor (Surtidor surt){
        if (this.getCantSurtidores() < this.getCantMaxSurtidores()){
            this.getSurtidores()[this.getCantSurtidores()]= surt;
            this.setCantSurtidores(this.getCantSurtidores()+1);
        }
    }
    
    public void  agregarVentaSurtidor (int nSurtidor, int dniCliente, double cantLitros, String formPago){
        this.getSurtidores()[nSurtidor].agregarVenta(new Venta(dniCliente,cantLitros,10000,formPago));
    }
    
    public int mayorMontoEfectivo (){
        double max=0; int maxSurtidor=0;
        for (int i=0; i<this.getCantSurtidores();i++){
            if (max < this.getSurtidores()[i].getTotal()){
                max = this.getSurtidores()[i].getTotal();
                maxSurtidor = i;
            }
        }
        return maxSurtidor;
    }    

    @Override
    public String toString() {
        String aux;
        aux = "Estacion con direccion: "+this.getDirec() +" la cantidad de Surtidores es " + this.getCantSurtidores() ;
        for (int i=0;i<this.getCantSurtidores();i++){
            aux += " Surtidor " +(i+1)+this.getSurtidores()[i].toString()+ "\n";
        }
        aux += " ";
        return aux;
    }
    
    
}
