/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica5;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Ej01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        System.out.println("Ingrese nombre del proyecto, codigo y Nombre del director del proyecto");
        Proyecto proyecto = new Proyecto(Lector.leerString(),Lector.leerInt(),Lector.leerString());
        
        for (int i=0; i<3; i++){
          System.out.println("Ingrese nombre completo, categoria (1-5) y Especialidad");
          proyecto.agregarInvestigador(new Investigador(Lector.leerString(),Lector.leerInt(),Lector.leerString()));
        }
    
        for (int i=0; i<3; i++) {
            for (int j=0; j<2; j++){
              proyecto.getInvestigadores()[i].agrgarSubsidio(new Subsidio(GeneradorAleatorio.generarDouble(1000000),"Muy Merecido"+j));
            }
        }
        
        System.out.println (proyecto.getInvestigadores()[GeneradorAleatorio.generarInt(2)].dineroTotalOtorgado());
        
        System.out.println(proyecto.toString());
    }
}
