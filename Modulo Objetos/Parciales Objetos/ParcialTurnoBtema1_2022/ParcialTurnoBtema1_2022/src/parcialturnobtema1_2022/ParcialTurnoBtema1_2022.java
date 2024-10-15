/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialturnobtema1_2022;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class ParcialTurnoBtema1_2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        System.out.println ("Ingrese nombre torneo cant fechas y cant goleadores por fecha");
        Torneo torneo = new Torneo (Lector.leerString(),Lector.leerInt(),Lector.leerInt());
        
        for (int i1=0;i1<9;i1++){
          System.out.println ("Ingrese Fecha: ");
          torneo.agregarGoleador(Lector.leerInt(),new Goleador(GeneradorAleatorio.generarString(8), GeneradorAleatorio.generarString(7),GeneradorAleatorio.generarInt(9)));
        }
        System.out.println ("Ingrese Fecha: ");
        System.out.println(torneo.getMenorCantGoles(Lector.leerInt()).toString());
        
        
        System.out.println("La cantidad total de goleadores en el torneo es: " + torneo.getCantTotalGoleadores());
        
        System.out.println(torneo.toString());
         
    }
    
}
