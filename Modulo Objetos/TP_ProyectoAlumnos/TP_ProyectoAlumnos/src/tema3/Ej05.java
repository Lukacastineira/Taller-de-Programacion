/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema3;

import PaqueteLectura.Lector;
public class Ej05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println ("Ingrese Radio del Circulo: ");
        double radio1 = Lector.leerDouble();
        System.out.println ("Ingrese Color de Relleno del Circulo: ");
        String colorR = Lector.leerString();
        System.out.println ("Ingrese Color de Linea del Circulo: ");
        String colorL = Lector.leerString();
        
        
        Circulo circulo1 = new Circulo(radio1, colorR, colorL);
        Circulo circulo2 = new Circulo();
        
        System.out.println(circulo1.calcularArea());
        System.out.println(circulo1.calcularPerimetro());
                
        System.out.println(circulo2.getColorLinea());
        System.out.println(circulo2.getColorRelleno());
        
    }
    
}
