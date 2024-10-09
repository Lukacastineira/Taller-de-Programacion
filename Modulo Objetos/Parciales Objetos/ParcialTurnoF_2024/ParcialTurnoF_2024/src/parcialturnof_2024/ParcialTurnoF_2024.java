/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialturnof_2024;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class ParcialTurnoF_2024 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        System.out.println ("Ingrese nombre de libreria y cantidad maxima de tickets por caja: ");
        Libreria libreria = new Libreria (Lector.leerString(),Lector.leerInt());
        
        for (int i=1; i<5; i++){
           for (int j=0; j<2;j++){  
              System.out.println ("Ingrese forma de pago: ");
              libreria.generTicket(i, GeneradorAleatorio.generarInt((90000000)+1000000), GeneradorAleatorio.generarInt((25)+1), GeneradorAleatorio.generarDouble((35000)+35), Lector.leerString());
           }
        }  
        
        
        System.out.println ("Ingrese numero de venta de libros a superar por caja: ");
        libreria.deshabilitarCajas(Lector.leerInt());
        
        System.out.println ("Ticket con mayor monto abonado: " + libreria.getMaxTicket().toString());
        
        System.out.println (libreria.toString());
          
    }
    
}
