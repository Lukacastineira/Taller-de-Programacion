/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnok_2024;

/**
 *
 * @author Luka
 */
public class Lider extends Programador{
    private int antiguedad; 
    private int proyectosDirigidos;

    public Lider(String nombre, int dni, double sueldoBasico, int cantLineasCodidoHora, String lenguaje, int unaAntiguedad, int unosProyectosDirigidos) {
        super(nombre, dni, sueldoBasico, cantLineasCodidoHora, lenguaje);
        this.setAntiguedad(unaAntiguedad);
        this.setProyectosDirigidos(unosProyectosDirigidos);
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getProyectosDirigidos() {
        return proyectosDirigidos;
    }

    public void setProyectosDirigidos(int proyectosDirigidos) {
        this.proyectosDirigidos = proyectosDirigidos;
    }
    
    public double getfinalSueldo (){
        double finall;
        finall= super.getSueldoFinal() + (this.getAntiguedad()*10000)  +  (this.getProyectosDirigidos()*20000);
        return finall;
    }    
    
    
    
    
}
