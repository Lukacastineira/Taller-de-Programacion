/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author Luka
 */
public class SistemaAnio extends SistemaReporte{

    public SistemaAnio(Estacion estacion1, int unAnio) {
        super(estacion1, unAnio);
    }

    @Override
    public String reportePromedios() {
       double tempAnual;
       String aux= this.getEstacion1().toString();
       for (int i=0; i < this.getCantAnios(); i++){
           tempAnual=0;
           for (int j=0; j < 12; j++){
               tempAnual= tempAnual + this.getTemperatura(i, j);
               
           } 
           tempAnual = tempAnual / 12;
           int anioActual = (i+this.getAnio());
           aux += " Anio: "+anioActual+": " + tempAnual + "\n";
       }
      aux += "";
      return aux;
    }
}
  