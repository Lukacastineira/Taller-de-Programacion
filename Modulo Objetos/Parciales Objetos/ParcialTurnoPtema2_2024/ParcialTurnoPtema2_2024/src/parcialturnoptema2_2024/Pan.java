/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoptema2_2024;

/**
 *
 * @author Luka
 */
public class Pan extends Componente{
    private String calidad; // Premium o Normal

    public Pan(String nombre, double costo, String calidad) {
        super(nombre,costo);
        this.setCalidad(calidad);
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    @Override
    public double getCostoFinal() {
        double costoF;
        if (this.getCalidad().equals("Premium")){
            costoF = this.getCosto() * 1.20;
        }else{
            costoF = this.getCosto();
        }
        return costoF;
    }

    @Override
    public String toString() {
        String aux;
        aux = " Calidad=" + this.getCalidad() + super.toString();
        return aux;
    }
    
    
    
    
    
}
