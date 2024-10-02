/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema4;

import PaqueteLectura.Lector;
        
        
public class Ej03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(" Ingrese su nombre, su DNI y su edad. ");
        Persona residente = new Persona (Lector.leerString(),Lector.leerInt(),Lector.leerInt());
        System.out.println(" Ingrese su nombre, su DNI, su edad y su trabajo en el predio. ");
        Trabajador empleado = new Trabajador (Lector.leerString(),Lector.leerInt(),Lector.leerInt(),Lector.leerString());
        
        
        System.out.println(residente.toString());
        
        System.out.println(empleado.toString());
    }
    
}
