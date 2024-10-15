/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialturnoptema2_2024;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class ParcialTurnoPtema2_2024 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        System.out.println("Ingrese Nombre del sandwich, cantida max ingredientes, nombre del pan, costo y calidad");
        Sandwich sanguchito = new Sandwich(Lector.leerString(),Lector.leerInt(),new Pan (Lector.leerString(),Lector.leerDouble(),Lector.leerString()));
        
        for (int i=0; i<5; i++){
            System.out.println(" Ingrese grupo: ");
            sanguchito.agregarIngrediente(new Ingrediente(GeneradorAleatorio.generarString(8),GeneradorAleatorio.generarDouble((1500)+1),Lector.leerString()));
        }
        
        System.out.println(sanguchito.toString());
        
        
        
    }
    
}
