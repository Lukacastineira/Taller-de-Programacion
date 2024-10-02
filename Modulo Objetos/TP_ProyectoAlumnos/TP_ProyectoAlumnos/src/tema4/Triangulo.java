/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author Luka
 */
public class Triangulo extends Figura {
    private double lado1,lado2,lado3; 

    
    public Triangulo(String unCR, String unCL, double unLado1, double unLado2, double unLado3) {
        super(unCR, unCL);
        this.setLado1(unLado1);
        this.setLado2(unLado2);
        this.setLado3(unLado3);     
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    @Override
    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2;        
        return Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
    }

    @Override
    public double calcularPerimetro() {
          return (lado1 + lado2 + lado3);
    }

    @Override
    public String toString() {
        String aux = " Triangulo: " + super.toString() ;
               aux += " El lado 1: " + lado1 + ", El lado 2: " + lado2 + ", El lado 3: " + lado3 ;
        return aux;      
    }
    
    
    
    
    
    
}
