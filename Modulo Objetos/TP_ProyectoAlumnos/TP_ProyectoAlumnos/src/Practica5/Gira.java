/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

/**
 *
 * @author Luka
 */
public class Gira extends Recital {
    private String nombreGira;
    private Fecha[] fechas;
    private int cantFechasMax;
    private int actual=0;
    private int cantFechas=0;
    
    
    
    public Gira(String unaBanda, int cantTemas, String unNombreGira, int unasCantFechasMax) {
        super(unaBanda, cantTemas);
        this.setNombreGira(unNombreGira);
        this.setCantFechasMax(unasCantFechasMax);
        this.setFechas(unasCantFechasMax);
        for (int i=0; i<this.getCantFechasMax();i++){
            this.setFecha(i, new Fecha());
        }
    }

    public void setFecha (int i, Fecha fecha) {
        this.fechas[i] = fecha;
    }
    
    public String getNombreGira() {
        return nombreGira;
    }

    public void setNombreGira(String nombreGira) {
        this.nombreGira = nombreGira;
    }

    public int getCantFechasMax() {
        return cantFechasMax;
    }

    public void setCantFechasMax(int cantFechasMax) {
        this.cantFechasMax = cantFechasMax;
    }
    
    public void setFechas (int i){
        this.fechas = new Fecha [i];
    }
    
    public Fecha[] getFechas (){
        return this.fechas;        
    }

    public int getCantFechas() {
        return cantFechas;
    }

    public void setCantFechas(int cantFechas) {
        this.cantFechas = cantFechas;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }
    
    
    
    public boolean hayEspacioFecha (){
       return this.getCantFechas() < this.getCantFechasMax();
    }
    
    public void agregarFecha (Fecha fecha){
        if (this.hayEspacioFecha()){
            this.setFecha(this.getCantFechas(), fecha);
            this.setCantFechas(this.getCantFechas()+1);
        }
    }
    @Override
    public String actuar (){
        String aux = "";
      for (int i=0; i<this.getCantTemas();i++){
         aux+= " Buenas Noches, "+ this.getFechas()[i].getCiudad();
         aux += super.actuar();
         this.setActual(i+1);
      }
      aux +="";
      return aux;
    }

    @Override
    public double calcularCosto() {
        double costo=0;
        for (int i=0; i<this.getCantFechas();i++){
            if (this.getFechas()[i].getDia() != -1){
                costo = costo + 30000;
            }
        }
        return costo;
    }
    
    
}
