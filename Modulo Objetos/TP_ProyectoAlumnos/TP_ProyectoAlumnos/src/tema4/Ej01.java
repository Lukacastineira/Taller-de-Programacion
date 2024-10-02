/*
 F- Realizar un programa que instancie un triángulo y un círculo. Muestre en consola la
representación String de cada uno. Pruebe el funcionamiento del método despintar.

 */
package tema4;

import PaqueteLectura.Lector;
public class Ej01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         System.out.println ("Ingrese color de relleno, color de linea y tres Lados del triangulo: ");
         Triangulo triangulo1 = new Triangulo(Lector.leerString(),Lector.leerString(),Lector.leerDouble(),Lector.leerDouble(),Lector.leerDouble());
         System.out.println ("Ingrese color de relleno, color de linea y radio del circulo: ");
         Circulo circulo1 = new Circulo(Lector.leerString(),Lector.leerString(),Lector.leerDouble());
         triangulo1.calcularArea(); triangulo1.calcularPerimetro();
         circulo1.calcularArea(); circulo1.calcularPerimetro();
         
         System.out.println (triangulo1.toString());
         
         System.out.println (circulo1.toString());
         
         triangulo1.despintar();
         
         circulo1.despintar();
         
         System.out.println (triangulo1.toString());
         
         System.out.println (circulo1.toString());
         
    }
    
}
