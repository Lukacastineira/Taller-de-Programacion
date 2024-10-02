/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author Luka
 */
public abstract class SistemaReporte {
    private Estacion estacion1;
    private double [][] temperaturas; 
    private int anio;
    private int cantAnios;

    public SistemaReporte(Estacion estacion1, int unAnio) {
        this.setEstacion1(estacion1);
        this.setAnio(unAnio);
        this.setCantAnios(2024-this.getAnio());
        this.temperaturas = new double [this.getCantAnios()][12];
        for (int i= 0; i < this.getCantAnios(); i++){
          for (int j=0; j < 12; j++)
              this.setTemperatura(500.50, i, j);
        }
    }
    
    public Estacion getEstacion1() {
        return estacion1;
    }

    public void setEstacion1(Estacion estacion1) {
        this.estacion1 = estacion1;
    }

    public double getTemperatura(int anio, int mes){
        return this.temperaturas[anio][mes];
    }

    public void setTemperatura(double temperatura, int anio, int mes) {
        this.temperaturas[anio][mes]= temperatura;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantAnios() {
        return cantAnios;
    }

    public void setCantAnios(int cantAnios) {
        this.cantAnios = cantAnios;
    }

    public String mayorTemperatura() {
        double mayorTemp=0; int mayorA=0; int mayorM=0;
        for (int i=0; i<this.getCantAnios();i++){
            for (int j=0; j < 12; j++){ 
               if (mayorTemp < this.getTemperatura(i, j)){
                   mayorTemp = this.getTemperatura(i, j);
                   mayorA=i; mayorM=j;
               }
            }  
        }
        String aux= "La mayor temperatura registrada es: " + mayorTemp;
        aux += " y fue en el anio: " + mayorA + " en el mes: " + mayorM;
        return aux;
    }

    public abstract String reportePromedios ();
}
    
