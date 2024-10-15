/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnobtema2_2022;

/**
 *
 * @author Luka
 */
public class Lote {
    private double precio;
    private Comprador comp;

    public Lote() {
        this.setPrecio(50000);
        this.comp=null;
    }
   
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void agregarComp (Comprador C){
        this.comp = C;
    }
    
    public boolean verificar(){
        return this.comp == null;
    }

    public String hayComprador (){
        String aux;
        if (this.comp != null){
           aux = this.comp.toString();
        }else {
            aux = " Disponible para la venta. ";
        }
        return aux;
    }
    
    @Override
    public String toString() {
        String aux;
        aux= " Precio: " + this.getPrecio() + ", Comprador: " + this.hayComprador() + " ";
        return aux;
    }
    
    
    
    
}
