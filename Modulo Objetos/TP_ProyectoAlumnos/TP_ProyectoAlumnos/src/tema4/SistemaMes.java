/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author Luka
 */
public class SistemaMes extends SistemaReporte {
    
    private String[] meses = new String[]{"Enero", "Febrero", "Marzo",
        "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
        "Octubre", "Noviembre", "Diciembre"};
    
    public SistemaMes(Estacion estacion1, int unAnio) {
        super(estacion1, unAnio);
    }

    @Override
    public String reportePromedios() {
        double tempMeses;
        String aux = this.getEstacion1().toString()+"\n";
        for (int j=0; j<12; j++){
            tempMeses=0;
            for (int i=0; i< this.getCantAnios(); i++){
                tempMeses = tempMeses + this.getTemperatura(i, j);
            }
            tempMeses = tempMeses / this.getCantAnios();
            aux+= meses[j]+": "+ tempMeses +"°C \n";
        }
        aux+="";
        return aux;
    }
    
}
