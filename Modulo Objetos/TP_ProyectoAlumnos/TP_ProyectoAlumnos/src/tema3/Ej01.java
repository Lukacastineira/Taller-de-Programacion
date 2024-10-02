/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema3;

import PaqueteLectura.Lector;
public class Ej01 {

  
    public static void main(String[] args) {
        double lado1 = Lector.leerDouble();
        double lado2 = Lector.leerDouble();
        double lado3 = Lector.leerDouble();
        String colorR = Lector.leerString(); 
        String colorL = Lector.leerString();
        Triangulo triangulo1 = new Triangulo(lado1,lado2,lado3,colorR, colorL);
        
        System.out.println("El Area del Triangulo es: " + triangulo1.calcularArea() + " El Perimetro del Triangulo es: " + triangulo1.calcularPerimetro()); 
    }
    
}
