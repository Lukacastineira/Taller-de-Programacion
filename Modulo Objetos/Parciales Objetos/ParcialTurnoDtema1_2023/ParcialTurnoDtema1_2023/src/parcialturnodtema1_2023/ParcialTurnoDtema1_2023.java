/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialturnodtema1_2023;

import PaqueteLectura.Lector;
public class ParcialTurnoDtema1_2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println ("Ingrese Direccion, costo por hora, cantidad de sectores y cantidad de autos por sector");
        Estacionamiento est = new Estacionamiento (Lector.leerString(),Lector.leerDouble(),Lector.leerInt(),Lector.leerInt());
        
        
        for (int i=1; i<3 ; i++){
            for (int j=1; j<3; j++){
                 System.out.println ("Ingrese Patente, cantidad de horas que se quedara, marca y modelo");
                est.agregarAuto(i, j, new Auto(Lector.leerString(),Lector.leerInt(),Lector.leerString(),Lector.leerString()));

            }
        }
        System.out.println (est.toString());
        
        
        System.out.println ("Ingrese marca a eliminar");
        est.liberarEspacios(Lector.leerString());
        
        System.out.println ("El sector que mas recaudo fue" + (est.getMaxTotal()+1));
        
        
        
         System.out.println (est.toString());

    }
    
}
