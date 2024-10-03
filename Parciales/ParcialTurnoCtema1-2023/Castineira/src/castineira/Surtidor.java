/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package castineira;

/**
 *
 * @author Luka
 */
public class Surtidor {
    private String combustible;
    private double precioPorLitro;
    private int cantMaxVentas;
    private int cantVentas=0;
    private Venta [] ventas;

    public Surtidor(String unCombustible, double unPrecioPorLitro, int unasCantMaxVentas) {
        this.setCombustible(unCombustible);
        this.setPrecioPorLitro(unPrecioPorLitro);
        this.setCantMaxVentas(unasCantMaxVentas);
        this.setVenta(this.getCantMaxVentas());
    }

    
    
    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public double getPrecioPorLitro() {
        return precioPorLitro;
    }

    public void setPrecioPorLitro(double precioPorLitro) {
        this.precioPorLitro = precioPorLitro;
    }

    public int getCantMaxVentas() {
        return cantMaxVentas;
    }

    public void setCantMaxVentas(int cantMaxVentas) {
        this.cantMaxVentas = cantMaxVentas;
    }

    public Venta[] getVentas() {
        return ventas;
    }

    public void setVentas(Venta[] ventas) {
        this.ventas = ventas;
    }
    
    public void setVenta (int i){
        this.ventas = new Venta[i];
    }

    public int getCantVentas() {
        return cantVentas;
    }

    public void setCantVentas(int cantVentas) {
        this.cantVentas = cantVentas;
    }
    
    
    
    public void agregarVenta (Venta vent){
        if (this.getCantVentas() < this.getCantMaxVentas())
          this.ventas[this.getCantVentas()]= vent;
    }
    
    public double getTotal (){
        double montoTotal=0;
        for (int i=0; i<this.getCantVentas();i++){
           montoTotal = this.getVentas()[i].getMontoAbonado();
        }
        return montoTotal;
    }

    @Override
    public String toString() {
        String aux;
        aux = " combustible: " + this.getCombustible() + ", precioPorLitro: " + this.getPrecioPorLitro();
           for (int i=0; i<this.getCantVentas();i++){
              aux += " Venta: " + (i+1) + " "+ this.getVentas()[i].toString() + "\n";
           }
        aux += "";
        return aux;
    }
    
    
    
}
