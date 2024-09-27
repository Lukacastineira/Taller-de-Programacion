/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Ej03 {
    
    public static void main (String[]args) {
      GeneradorAleatorio.iniciar();
      Persona [][] Casting = new Persona [5][8];
      int [] vecdim = new int [5];
      
      int diml =0; int i=0; 
      for (int indice=0; indice < 5; indice++)
          vecdim[indice] = 0;
      
      String nombre = Lector.leerString();
      
      int ultdia =-1; 
      
      while ((!nombre.equals("ZZZ")) && (diml<=40) && (i<5)){
        int dni = GeneradorAleatorio.generarInt((60000000)+1000000);
        int edad = GeneradorAleatorio.generarInt((100)+18); 
        Casting[i][vecdim[i]] = new  Persona(nombre,dni,edad);
        vecdim[i]++;
        ultdia=i;
        if (vecdim[i] == 8 ){
            i++;  
        }
        nombre = Lector.leerString();
        diml++;
     }
      System.out.println (ultdia);
         for (int i2=0; i2<=ultdia;i2++){
          for (int j2=0; j2 < vecdim[i2]; j2++) 
           System.out.println (Casting[i2][j2].getNombre());
          }
        }    
    }

