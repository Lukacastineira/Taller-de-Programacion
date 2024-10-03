/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialturnoctema2;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

public class ParcialTurnoCtema2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        System.out.println ("Ingrese Direccion, Precio por m3 y cantidad de ventas maxima por surtidor");
        Estacion est = new Estacion (Lector.leerString(),Lector.leerDouble(),6,Lector.leerInt());
        
        for (int i=0; i<6 ; i++){
            System.out.println ("Ingrese Medio de Pago: ");
            est.getSurtidores()[i].agregarVenta(new Venta (GeneradorAleatorio.generarInt((80000000)+1000000),GeneradorAleatorio.generarDouble((250)+3),GeneradorAleatorio.generarDouble((250000)+6000), Lector.leerString()));
            System.out.println (est.getSurtidores()[i].getCantVentas());
        }
        System.out.println ("Ingrese dni, surtidor, cant m3 cargada, forma de pago ");
        est.incisoA(Lector.leerInt(), Lector.leerInt(), Lector.leerDouble(), Lector.leerString());
        
        System.out.println ("Ingrese cant m3 X ");
        est.incisoB(Lector.leerInt());
        
        
        System.out.println ("La venta con mayor monto de toda la estacion es: " + est.incisoC().toString());
        
        System.out.println (est.toString());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
