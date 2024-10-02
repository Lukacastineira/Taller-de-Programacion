/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author Luka
 */
public class Jugador extends Empleado{
    private int partidosJugados;
    private int golesAnotados;

    public Jugador(String unNombre, double unSueldo, int unaAntiguedad, int partidosJugados, int golesAnotados) {
        super(unNombre,unSueldo,unaAntiguedad);
        this.setPartidosJugados(partidosJugados);
        this.setGolesAnotados(golesAnotados);
    }
 
    
    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    @Override
    public double calcularEfectividad() {
        double efectividad;
        efectividad = this.getGolesAnotados() / this.getPartidosJugados();
        return efectividad;
    }

    @Override
    public double calcularSueldoACobrar() {
        double sueldo= this.sueldoBase();
        if (this.calcularEfectividad() > 0.5){
            sueldo = sueldo + this.getSueldoBasico();
        }
        return sueldo;
    }

    
    
}
