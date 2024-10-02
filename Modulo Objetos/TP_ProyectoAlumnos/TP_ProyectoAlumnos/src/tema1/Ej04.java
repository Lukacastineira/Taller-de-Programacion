/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1;

import PaqueteLectura.GeneradorAleatorio;
public class Ej04 {

    
   public static void main(String[] args){
   
      /*        4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso
                (1..4). Realice un programa que permita informar la cantidad de personas que
                concurrieron a cada oficina de cada piso. Para esto, simule la llegada de personas al
                edificio de la siguiente manera: a cada persona se le pide el nro. de piso y nro. de
                oficina a la cual quiere concurrir. La llegada de personas finaliza al indicar un nro.
                de piso 9. Al finalizar la llegada de personas, informe lo pedido    */
        int[][] oficinas = new int [8][4];
        GeneradorAleatorio.iniciar();
        int i; int j; 
        for (i=0;i<8;i++)
            for (j=0;j<4;j++)
                oficinas[i][j]=0;
        i = (GeneradorAleatorio.generarInt(9));   
        while (i!=8) { // El 8 seria el piso 9.
             j = (GeneradorAleatorio.generarInt(3)); 
             oficinas[i][j]  =   oficinas[i][j] + 1;
             i = (GeneradorAleatorio.generarInt(9)); 
        }
        System.out.println ("|------------------|");
        System.out.println ("\\\\\\" + i + "\\\\\\ ");
        for (i=0;i<8;i++){
            System.out.println ("|------------------|");
            for (j=0;j<4;j++)
                if (oficinas[i][j] > 0)
                   System.out.println ("El Numero de personas en el piso "+ i + " y la oficina "+ j +" es: " + oficinas[i][j]+ '|');
                else  System.out.println ("No se encontraron personas en el piso "+ i + " y la oficina "+ j + '|');
        }
        
   }

    
}
