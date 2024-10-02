/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;

import PaqueteLectura.*;
public class Ayuda {


    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int dia = 5;
        int entrevistas = 8;
        int entrevistados = 0;
        
        Persona [][] entrevistado = new Persona[dia][entrevistas];
        int [] vecDiml = new int[dia];
        
        int i;
        for (i = 0; i < 5; i++) {
            vecDiml[i] = 0;
        }
        
        String nom = Lector.leerString();
        
        while(!nom.equals("ZZZ")&&(entrevistados < 10)) {
            System.out.println("Ingrese dia para anotarse: ");
            int diaSelec = Lector.leerInt();
            if(vecDiml[diaSelec] < 8) {
                entrevistado[diaSelec][vecDiml[diaSelec]] = new Persona(nom, GeneradorAleatorio.generarInt(30), GeneradorAleatorio.generarInt(100));
                vecDiml[diaSelec]++;
                entrevistados++;
            } else
                System.out.println("No hay mas turnos disponibles para el dia " + diaSelec);
            nom = Lector.leerString();
        }
        
        for(int a = 0; a < 5; a++) {
            for(int b = 0; b < vecDiml[a]; b++) {
                System.out.println("Dia " + a + " entrevista " + b + " es de la persona: " + entrevistado[a][b].getNombre());
            }
            System.out.println("Para el dia " + a + " hubo " + vecDiml[a] + " inscriptos al casting");
        }
    }
}
    

