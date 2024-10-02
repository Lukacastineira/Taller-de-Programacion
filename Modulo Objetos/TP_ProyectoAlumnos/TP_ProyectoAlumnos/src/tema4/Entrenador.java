/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author Luka
 */
public class Entrenador extends Empleado {
    private int campeonatosGanados;

    public Entrenador(String unNombre, double unSueldoBasico, int unaAntiguedad, int campeonatoGanado) {
        super(unNombre, unSueldoBasico, unaAntiguedad);
         this.setCampeonatosGanados(campeonatoGanado);
    }

    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }

    @Override
    public double calcularEfectividad() {
        double efectividad;
        efectividad = (double)this.getCampeonatosGanados() / (double)this.getAntiguedad();
        return efectividad; 
    }

    @Override
    public double calcularSueldoACobrar() {
        double sueldo= this.sueldoBase();
        if (this.getCampeonatosGanados( )==0 ) {
           return sueldo;
        }
        else {
            if ((this.getCampeonatosGanados() >= 1)  && (this.getCampeonatosGanados() <= 4)) {
               sueldo = sueldo + 5000;
            }
            else if((this.getCampeonatosGanados() >= 5) && (this.getCampeonatosGanados() <= 10)) {
            sueldo = sueldo + 30000;
            }
            else if (this.getCampeonatosGanados() > 10){
               sueldo = sueldo + 50000;
            } 
        }  
        return sueldo;
    }
}