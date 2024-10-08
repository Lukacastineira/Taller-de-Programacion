/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnok_2024;

/**
 *
 * @author Luka
 */
public class Empresa {
    private String nombreEmp;
    private Lider programadorLider;
    private int cantProgramadores;
    private int canMaxProgramadores;
    private Programador [] programadores;

    public Empresa(String nombreEmp, Lider programLider, int maxProgramadores) {
        this.setNombreEmp(nombreEmp);
        this.programadorLider= programLider;
        this.setCanMaxProgramadores(maxProgramadores);
        this.programadores = new Programador [this.getCanMaxProgramadores()];
        this.inicializarProgramadores();
        this.setCantProgramadores(0);
    }

    public void inicializarProgramadores (){
        for (int i=0; i<this.getCanMaxProgramadores();i++){
            this.programadores[i]=null;
        }
    }
    
    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public int getCanMaxProgramadores() {
        return canMaxProgramadores;
    }

    public void setCanMaxProgramadores(int canMaxProgramadores) {
        this.canMaxProgramadores = canMaxProgramadores;
    }

    public int getCantProgramadores() {
        return cantProgramadores;
    }

    public void setCantProgramadores(int cantProgramadores) {
        this.cantProgramadores = cantProgramadores;
    }

    
    public void agregarProgramador (Programador programador){
        if (this.getCantProgramadores()<this.getCanMaxProgramadores()){
            this.programadores[this.getCantProgramadores()]=programador;
            this.setCantProgramadores(this.getCantProgramadores()+1);
        }
    }
    
    public double totalSueldos (){
        double montoTotal=0;
        for (int i=0; i<this.getCantProgramadores(); i++){
             montoTotal = montoTotal + this.programadores[i].getSueldoFinal();
        }
        montoTotal = montoTotal + this.programadorLider.getfinalSueldo();
      return montoTotal;  
    }
    
    public void aumentarSueldos (double M){
        this.programadorLider.setSueldoBasico(this.programadorLider.getSueldoBasico()+M);
        for (int i=0; i<this.getCantProgramadores();i++){
            this.programadores[i].setSueldoBasico(this.programadores[i].getSueldoBasico()+M);
        }
    }

    @Override
    public String toString() {
        String aux;
        aux = "Empresa: " + this.getNombreEmp() + "\n";
        aux += "Programador Lider: " + this.programadorLider.toString() + "\n";
        for (int i=0; i<this.getCantProgramadores();i++){
            aux += " Programador " + (i+1) + ": " + this.programadores[i].toString()+ "\n";
        }
        aux += " El monto total en sueldos a abonar por la empresa es: " + this.totalSueldos();
        return aux;
    }
    
    
    
}
