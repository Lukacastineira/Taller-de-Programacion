/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialturnohtema1_2023;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
        
public class ParcialTurnoHtema1_2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        System.out.println("Ingrese Nombre de Estadio, Direccion y Capacidad ");
        Estadio est = new Estadio (Lector.leerString(),Lector.leerString(),Lector.leerInt());
        
        for (int i=1; i<13 ; i++){
            System.out.println("Ingrese Nombre de Artista, Precio de Entradas y Cantidad Vendidas ");
            est.agregarConcierto(new Concierto(Lector.leerString(),Lector.leerDouble(),Lector.leerInt()), i);
        }    
        for (int i1=1; i1<13 ;i1++){
           System.out.println(est.getGanaciaEstadio(i1));
        }
            
            
        System.out.println(est.toString());
       
    }
    
}
