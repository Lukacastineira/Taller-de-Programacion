/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;

import PaqueteLectura.Lector;
public class Ej01 {
    public static void main (String[]args){
      Persona p1; 
      p1 = new Persona ();
      p1.setNombre(Lector.leerString());
      p1.setDNI(Lector.leerInt());
      p1.setEdad(Lector.leerInt());
      System.out.println(p1.toString());
    }
}
