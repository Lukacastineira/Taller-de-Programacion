/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;

import PaqueteLectura.Lector;
public class Ej05 {
    public static void main (String[]args){
        int dimf=20;
        Partido[] partidos = new Partido [dimf];
        int diml=0; 
        System.out.println("Ingrese Visitante:");
        String visitante = Lector.leerString();
        while ((diml<20)&&(!visitante.equals("ZZZ"))){
           System.out.println("Ingrese Local:");
           String local = Lector.leerString();
           System.out.println("Ingrese Goles Local:");
           int golesL = Lector.leerInt();
           System.out.println("Ingrese Goles Visitante:");
           int golesV = Lector.leerInt();
           partidos[diml] = new Partido (local,visitante,golesL,golesV);
           diml++;
           System.out.println("Ingrese Visitante:");
           visitante = Lector.leerString();   
        }
        int cantRiver = 0 ;  int golesBoca=0;
        for (int i=0; i < diml;i++){
           System.out.println(partidos[i].getLocal()+" "+partidos[i].getGolesLocal()+ " VS " + partidos[i].getVisitante()+" " +partidos[i].getGolesVisitante());
           if (partidos[i].getGanador().equals("River"))
                cantRiver++;
           if (partidos[i].getLocal().equals("Boca"))
               golesBoca = golesBoca + partidos[i].getGolesLocal();
           if (partidos[i].getVisitante().equals("Boca"))
               golesBoca = golesBoca + partidos[i].getGolesVisitante();
        }
        System.out.println ("La cantidad de partidos que gano river es: "+ cantRiver);
        System.out.println ("La cantidad de goles que hizo boca es: "+ golesBoca);
}
}