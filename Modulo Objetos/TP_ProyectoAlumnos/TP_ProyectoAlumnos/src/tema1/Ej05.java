/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1;

import PaqueteLectura.Lector;
public class Ej05 {
   public static void main (String[] args) {
    /*  5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen
        (con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad
        de la comida (2) Precio (3) Ambiente.
        Escriba un programa que lea desde teclado las calificaciones de los cinco clientes
        para cada uno de los aspectos y almacene la información en una estructura. Luego
        imprima la calificación promedio obtenida por cada aspecto.   */
    int[][] puntajes = new int[5][4];
    int i; int j;  int client; int prom;
    for (i=0;i<5;i++){
        client = i +1; prom=0;
        for (j=0;j<4;j++){
            System.out.println (" Ingrese el puntaje cliente " + client + " Aspecto: " + j);
            puntajes[i][j]= Lector.leerInt();
            prom = prom + puntajes[i][j];
        }
      prom = prom / 4;
    System.out.println (" El promedio de puntaje del cliente " + client + " es: " + prom);
    }
    
    
    
    
    
   }
    
}
