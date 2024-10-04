/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialturnoetema1_2023;

import PaqueteLectura.Lector;
public class ParcialTurnoEtema1_2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println ("Ingrese nombre, cantidad de empleados, numero de cuentas, direccionweb");
        BancoDigital digital = new BancoDigital(Lector.leerString(),Lector.leerInt(),Lector.leerInt(),Lector.leerString());
        System.out.println ("Ingrese nombre, cantidad de empleados, numero de cuentas, direccion y localidad");
        BancoTradicional tradicional = new BancoTradicional(Lector.leerString(),Lector.leerInt(),Lector.leerInt(),Lector.leerString(),Lector.leerString());
        
        for (int i=0; i<1; i++){
            System.out.println ("Ingrese CBU, ALIAS, DNI, MONEDA y MONTO");
            digital.agregarCuenta(new Cuenta(Lector.leerInt(),Lector.leerString(),Lector.leerInt(),Lector.leerString(),Lector.leerDouble()));
        }
        
        for (int i=0; i<1; i++){
            System.out.println ("Ingrese CBU, ALIAS, DNI, MONEDA y MONTO");
            tradicional.agregarCuenta(new Cuenta(Lector.leerInt(),Lector.leerString(),Lector.leerInt(),Lector.leerString(),Lector.leerDouble()));
        }
        System.out.println (digital.getCantCuentas());
        System.out.println (tradicional.getCantCuentas());
        
        
        
        System.out.println (digital.toString());
        System.out.println (tradicional.toString());
        
        System.out.println ("Ingrese CBU y MONTO a aumentar");
        digital.depositarDinero(Lector.leerInt(), Lector.leerDouble());
        
        System.out.println ("Ingrese CBU y MONTO a aumentar");
        tradicional.depositarDinero(Lector.leerInt(), Lector.leerDouble());
        System.out.println ("Ingrese CBU");
        System.out.println (digital.puedeRecibirTarjeta(Lector.leerInt()));
        System.out.println ("Ingrese CBU ");
        System.out.println (tradicional.puedeRecibirTarjeta(Lector.leerInt()));
        
        System.out.println (digital.toString());
        System.out.println (tradicional.toString());
    }
    
}
