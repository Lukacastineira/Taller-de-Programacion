/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema4;

import PaqueteLectura.Lector;
public class Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* System.out.println("Ingrese Nombre , Sueldo base, antiguedad, numero de partidos y goles anotados");
        Jugador messi = new Jugador (Lector.leerString(), Lector.leerDouble(), Lector.leerInt(), Lector.leerInt(),Lector.leerInt()); */
         System.out.println("Ingrese Nombre , Sueldo base, antiguedad, campeonatos ganados");
        Entrenador scaloni = new Entrenador (Lector.leerString(),Lector.leerDouble(),Lector.leerInt(),Lector.leerInt());
        /*messi.calcularEfectividad(); messi.calcularSueldoACobrar(); */
        scaloni.calcularEfectividad(); scaloni.calcularSueldoACobrar();
        
        /*System.out.println (messi.toString()); */
        System.out.println (scaloni.calcularEfectividad());
        System.out.println (scaloni.getAntiguedad()); 
        System.out.println (scaloni.getCampeonatosGanados());
        System.out.println (scaloni.toString());
    }
}
