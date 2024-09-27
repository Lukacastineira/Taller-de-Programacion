/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Ej04 {
    public static void main (String[]args) {
        GeneradorAleatorio.iniciar();
        Persona [][] Casting = new Persona [5][8];
        int [] vecdim = new int [5];
      
        int diml =0; 
        
        
        for (int indice=0; indice < 5; indice++)
            vecdim[indice] = 0;
        
        
        System.out.println ("Ingrese Nombre");
        String nombre = Lector.leerString();
        int i=0;
        while ((!nombre.equals("ZZZ")) && (diml<10) && (i<5)){
          int dni = GeneradorAleatorio.generarInt((60000000)+1000000);
          int edad = GeneradorAleatorio.generarInt((100)+18); 
          System.out.println ("Ingrese Dia");
          i=Lector.leerInt();
          if (vecdim[i] < 8){
              Casting[i][vecdim[i]] = new  Persona(nombre,dni,edad);
              vecdim[i]++;
               diml++;
          } else if (vecdim[i]>=7)
              System.out.println ("El dia: " + i + " esta completo.");
          
          System.out.println ("Ingrese Nombre");
          nombre = Lector.leerString();
        }
     System.out.println (diml);
     
     for (int i2=0; i2<5;i2++){
          for (int j2=0; j2 < vecdim[i2]; j2++){ 
             System.out.println ("En el dia " + i2 + " esta inscripto " + Casting[i2][j2].getNombre()+ " en el turno: "+ j2);
          }
          System.out.println ("La cantidad de inscriptos el dia:" + i2 + " es: "+vecdim[i2]);
    }   
    }    
}
