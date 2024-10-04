/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ParcialTurnoCTema1_2023;

import  PaqueteLectura.Lector;

public class ParcialTurnoCTema1_2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println ("Ingrese Direccion de la estacion.");
        Estacion estacion = new Estacion (Lector.leerInt());
        
        for (int i=0; i<6;i++){
            System.out.println ("Ingrese Combustible, precio por litro, cantidad maxima de ventas.");
            estacion.agregarSurtidor(new Surtidor (Lector.leerString(),Lector.leerDouble(),Lector.leerInt()));
            int nVentas = Lector.leerInt();
            System.out.println ("Ingrese numero de ventas.");
            for (int i1=0; i1<nVentas; i1++){
              System.out.println ("Ingrese DNI, litros cargados, cmonto abonado, medio de pago.");
              estacion.getSurtidores()[i1].agregarVenta(new Venta (Lector.leerInt(),Lector.leerDouble(),Lector.leerDouble(),Lector.leerString()));
        }
        }
        System.out.println ("Ingrese numero de surtidor, DNI de cliente, litros cargados, medio de pago.");
        estacion.agregarVentaSurtidor(Lector.leerInt(), Lector.leerInt(),Lector.leerDouble(), Lector.leerString());
        
        System.out.println ("El numero de surtidor que recaudo un mayor monto en efectivo es: " + (estacion.mayorMontoEfectivo()+1));
        
        System.out.println (estacion.toString());
    }   
}
