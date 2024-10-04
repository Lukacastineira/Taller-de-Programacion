/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialturnoftema1_2023;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
public class ParcialTurnoFtema1_2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        System.out.println("Ingrese nombre, direccion");
        System.out.println("Ingrese nombre, dni, anio ingreso , sueldo basico, monto viaticos");
        System.out.println("Ingrese numero de sucursales");
        Empresa emp = new Empresa(Lector.leerString(),Lector.leerString(),new Director(Lector.leerString(),Lector.leerInt(),Lector.leerInt(),Lector.leerDouble(),Lector.leerDouble()),Lector.leerInt());
        
        for (int i=0; i<5 ;i++){
            System.out.println("Ingrese nombre, dni, anio ingreso , sueldo basico, cantidad de empleados a cargo");
            emp.asignarEncargado(new Encargado(Lector.leerString(),Lector.leerInt(),Lector.leerInt(),Lector.leerDouble(),Lector.leerInt()), (i+1));
        }
        
        System.out.println(emp.toString());
        
        
    }
    
}
