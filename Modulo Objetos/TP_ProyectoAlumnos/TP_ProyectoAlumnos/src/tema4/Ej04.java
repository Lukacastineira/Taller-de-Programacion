/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema4;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Ej04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        System.out.println ("Ingrese nombre de estacion, Latitud y Longitud");
        Estacion estacion1 = new Estacion (Lector.leerString(),Lector.leerDouble(),Lector.leerDouble());
        System.out.println ("Ingrese Anio desde el cual quiere saber los promedios de temperaturas.");
        SistemaAnio sistemaAnual = new SistemaAnio (estacion1, Lector.leerInt());
        System.out.println ("Ingrese nombre de estacion, Latitud y Longitud");
        Estacion estacion2 = new Estacion (Lector.leerString(),Lector.leerDouble(),Lector.leerDouble());
        System.out.println ("Ingrese Anio desde el cual quiere saber los promedios de temperaturas.");
        SistemaMes sistemaMensual = new SistemaMes (estacion2, Lector.leerInt());
        
        for (int i=0; i< sistemaAnual.getCantAnios(); i++){
            for (int j=0; j<12; j++){
                sistemaAnual.setTemperatura(GeneradorAleatorio.generarDouble(105),i,j);
                sistemaMensual.setTemperatura(GeneradorAleatorio.generarDouble(120),i,j);
            }
        }
        System.out.println (sistemaAnual.reportePromedios());
        System.out.println (sistemaMensual.reportePromedios());
    }
}