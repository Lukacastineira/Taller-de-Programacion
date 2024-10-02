/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica5;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Ej03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println ("Igrese nombre de banda, cantidad de temas, motivo, nombre contratante, dia");
        EventoOcasional evento = new EventoOcasional (Lector.leerString(),Lector.leerInt(),Lector.leerString(),Lector.leerString(),Lector.leerInt()); 
        for (int i=0; i< evento.getCantTemasMax()   ;i++){
            System.out.println ("Ingrese tema" + (i+1));
            evento.agregarTema(Lector.leerString());
        }
        
        System.out.println ("Igrese nombre de banda, cantidad de temas, nombre gira , cantidad de fechas");
        Gira gira = new Gira (Lector.leerString(),Lector.leerInt(),Lector.leerString(),Lector.leerInt());
         for (int i=0; i<gira.getCantTemasMax();i++){
            System.out.println ("Ingrese tema" + (i+1));
            gira.agregarTema(Lector.leerString());
        }       

        
        for (int i=0; i < gira.getCantFechasMax(); i++){
            String ciudad= "ciudad" + (i+1);
            gira.agregarFecha(new Fecha(ciudad, GeneradorAleatorio.generarInt(9)));
        }
      
        System.out.println ("El costo del Evento fue: " + evento.calcularCosto());
        System.out.println ("El costo de la Gira fue: " + gira.calcularCosto());
        
        System.out.println (evento.actuar());
        System.out.println (gira.actuar());
        
    }
    
}
