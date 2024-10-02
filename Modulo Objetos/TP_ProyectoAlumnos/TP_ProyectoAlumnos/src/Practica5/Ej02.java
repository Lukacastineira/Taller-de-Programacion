/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica5;
import PaqueteLectura.Lector;
public class Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println ("Ingrese nombre, direccion, hora de apertura, cierre.");
        Estacionamiento estacionamiento = new Estacionamiento(Lector.leerString(),Lector.leerString(),Lector.leerInt(),Lector.leerInt(),3,3);
        for (int i=0; i<6;i++){
            System.out.println ("Ingrese piso, plaza, nombre y patente.");
            int piso = Lector.leerInt()-1; int plaza = Lector.leerInt()-1;
            estacionamiento.registrarAuto(new Auto(Lector.leerString(),Lector.leerString()), piso, plaza);    
        }
    System.out.println (estacionamiento.toString());
    System.out.println ("La cantida de autos de la plaza 1 es: " + estacionamiento.cantAutosPlaza(0));
    System.out.println ("Ingrese Patente a buscar");
    System.out.println (estacionamiento.obtenerString(Lector.leerString()));
}
}
