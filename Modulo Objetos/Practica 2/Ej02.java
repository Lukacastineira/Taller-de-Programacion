/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;
public class Ej02 {
    public static void main (String[]args){
      GeneradorAleatorio.iniciar();
      int dimf = 15; int diml=0; int edad;
      Persona [] personas;
        personas = new Persona [15];
      edad = GeneradorAleatorio.generarInt(99);
      while ((diml <dimf ) && (edad != 0)) {
          String nombre = GeneradorAleatorio.generarString((6)+1);
          int dni = GeneradorAleatorio.generarInt((50000000)+1000000);
          personas[diml]= new Persona (nombre,dni,edad);
          diml++;
          edad = GeneradorAleatorio.generarInt(99);
      }  
      int cant = 0;  int min = 90000000; int pos=0;
      for (int i=0; i < diml;i++){
         if ( personas[i].getEdad() > 65 ) {
          } else {
             cant++;
          }
         if (personas[i].getDNI()<min)
            pos = i;
      }
      System.out.println ("La cantidad de personas mayores de 65 anios es: " + cant);
      System.out.println(personas[pos].toString());
    }
    
}
