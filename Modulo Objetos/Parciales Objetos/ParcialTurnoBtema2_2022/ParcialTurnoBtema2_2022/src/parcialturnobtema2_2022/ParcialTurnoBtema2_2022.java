/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialturnobtema2_2022;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class ParcialTurnoBtema2_2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        System.out.println (" Ingrese Nombre de Barrio, numero de manzanas y numero de lotes por manzana: ");
        Empresa barrio = new Empresa (Lector.leerString(),Lector.leerInt(),Lector.leerInt());
        
        for (int i1=0; i1<15;i1++){
          System.out.println (" Ingrese Manzana y Lote ");
          barrio.agregarComprador(new Comprador(GeneradorAleatorio.generarInt((70000000)+1000000),GeneradorAleatorio.generarString(7),GeneradorAleatorio.generarString(7),GeneradorAleatorio.generarString(8)),Lector.leerInt(),Lector.leerInt());
        }
        
        System.out.println (" Ingrese manzana a aumentar precio: ");
        barrio.aumentarPrecioManzana(Lector.leerInt(), 1.20);
        
        
        System.out.println (barrio.toString());
    }
    
}
