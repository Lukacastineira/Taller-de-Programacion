/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

/**
 *
 * @author Luka
 */
public class EventoOcasional extends Recital {
    private String motivo;
    private String nombreContratante;
    private int diaEvento;

    public EventoOcasional(String unaBanda, int cantTemas, String unMotivo, String unNombreContratante, int unDiaEvento) {
        super(unaBanda,cantTemas);
        this.setMotivo(unMotivo);
        this.setNombreContratante(unNombreContratante);
        this.setDiaEvento(unDiaEvento);
    }

    
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNombreContratante() {
        return nombreContratante;
    }

    public void setNombreContratante(String nombreContratante) {
        this.nombreContratante = nombreContratante;
    }

    public int getDiaEvento() {
        return diaEvento;
    }

    public void setDiaEvento(int diaEvento) {
        this.diaEvento = diaEvento;
    }
    
    @Override
    public String actuar (){
        String aux = "";
        if (this.getMotivo().equals("a beneficio")){
            aux += " Recuerden colaborar con, "+ this.getNombreContratante();
        }
        else if (this.getMotivo().equals("show de TV")){
            aux += " Saludos amigos televidentes, ";
        }
        else if (this.getMotivo().equals("show privado")){
            aux += " Un feliz cumpleanios para, " + this.getNombreContratante();
        }
        aux += "" + super.actuar();
        return aux;
    }

    @Override
    public double calcularCosto() {
        double costo;
        if (this.getMotivo().equals("a beneficio")){
            costo = 0;
        }
        else if (this.getMotivo().equals("show de TV")){
            costo = 50000;
        }
        else if (this.getMotivo().equals("show privado")){
           costo = 150000;
        }
        else 
           costo=-1;
        return costo;
    }
    
    
    
}
