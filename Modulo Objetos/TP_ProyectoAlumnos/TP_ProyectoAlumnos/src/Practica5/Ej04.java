/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica5;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ej04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      GeneradorAleatorio.iniciar();
     // System.out.println ("Ingrese nombre del coro, nombre director, dni, edad, antiguedad y cantidad de coristas");
     //  CoroSemicircular coroS = new CoroSemicircular(Lector.leerString(),new Director(Lector.leerString(),Lector.leerInt(),Lector.leerInt(),Lector.leerInt()), Lector.leerInt());      
       System.out.println ("Ingrese nombre del coro, nombre director, dni, edad, antiguedad y cantidad hileras");
       CoroHileras coroH = new CoroHileras (Lector.leerString(),new Director(Lector.leerString(),Lector.leerInt(),Lector.leerInt(),Lector.leerInt()),Lector.leerInt());      
     //  for (int i=0; i< coroS.getCantCoristasMax(); i++){
      //   System.out.println (" Ingrese nombre, dni, edad, tono");
     //    coroS.agregarCorista(new Corista(Lector.leerString(),Lector.leerInt(),Lector.leerInt(),Lector.leerInt()));
     // }
      for (int i=0; i< coroH.getCantHileras(); i++){
            for (int j=0; j < coroH.getCantHileras(); j++){
              System.out.println (" Ingrese nombre, dni, edad, tono");
                coroH.agregarCorista(new Corista(Lector.leerString(),Lector.leerInt(),Lector.leerInt(),Lector.leerInt()));
          }
       } 
     //   System.out.println (coroS.toString() + coroS.bienFormado());
        System.out.println (coroH.toString() + coroH.bienFormado());
    }
    
}
