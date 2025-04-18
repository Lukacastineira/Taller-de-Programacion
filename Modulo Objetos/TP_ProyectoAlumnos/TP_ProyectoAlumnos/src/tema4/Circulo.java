/*
 1- Nos piden una aplicación estilo Paint, para ello necesitamos representar figuras
geométricas (cuadrados, rectángulos, círculos, triángulos). Todas las figuras tienen color
de relleno y color de línea. Además, los triángulos guardan el valor de sus tres lados, los
cuadrados el valor de su lado, los círculos el valor del radio, y los rectángulos el valor de la
base y de la altura.
Las figuras deben incluir funcionalidad para: crearla a partir de los datos necesarios
(constructor), modificar/obtener el valor de los atributos (métodos get y set), calcular el
área y devolverla (método calcularArea), calcular el perimetro y devolverlo (método
calcularPerimetro), y mostrar la representación String de la figura (método toString)
concatenando toda la información.
A- Analice la jerarquía de figuras (carpeta tema4).
B- Incluya la clase Triángulo a la jerarquía de figuras. Triángulo debe heredar de Figura
todo lo que es común y definir su constructor y sus atributos y métodos propios. Además
debe redefinir el método toString.
C- De igual manera, incluya la clase Círculo a la jerarquía de figuras.
D- Añada a la representación String el valor del perímetro. Piense ¿qué método toString
debe modificar: el de cada subclase o el de Figura?
E- Añada el método despintar que establece los colores de la figura a línea “negra” y
relleno “blanco”. Piense ¿dónde debe definir el método: en cada subclase o en Figura?
F- Realizar un programa que instancie un triángulo y un círculo. Muestre en consola la
representación String de cada uno. Pruebe el funcionamiento del método despintar.

 */
package tema4;

/**
 *
 * @author Luka
 */
public class Circulo extends Figura {
    private double radio;
    
    public Circulo(String unCR, String unCL, double unRadio) {
        super(unCR, unCL);
        this.setRadio(unRadio);
    }
    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    
    @Override
    public double calcularArea() {
        double pi= Math.PI;
        double area;
        area = (pi*(radio*radio));
        return area;
    }
    
    @Override
    public double calcularPerimetro() {
       double pi= Math.PI;
        double perimetro;
        perimetro = (2*pi*radio);
        return perimetro;
    }
    
    
        @Override
    public String toString() {
        String aux = " Circulo: " + super.toString() + "Radio=" + this.getRadio();
        return aux;
    }
    
    
}
