/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author Luka
 */
public class Circulo {
    private double radio=0;
    private String colorRelleno="Sin Color de Relleno";
    private String colorLinea= "Sin Color de Linea"; 

    public Circulo (){
    }
    
    public Circulo(double radio, String colorRelleno, String colorLinea) {
        this.radio = radio;
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }
    
    public double calcularPerimetro(){
        double pi= Math.PI;
        double perimetro;
        perimetro = (2*pi*radio);
        return perimetro;
    }
    
    public double calcularArea (){
        double pi= Math.PI;
        double area;
        area = (pi*(radio*radio));
        return area;
    }
   
}
