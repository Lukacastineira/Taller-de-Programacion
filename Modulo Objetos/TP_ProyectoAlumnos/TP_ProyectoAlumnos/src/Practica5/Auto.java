/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

/**
 *
 * @author Luka
 */
public class Auto {
    private String nomDuenio;
    private String patente;

    public Auto (){
        this.setNomDuenio("sinNombre");
        this.setPatente("sinPatente");
    }
    
    public Auto (String unNombre, String unaPatente){
        this.setNomDuenio(unNombre);
        this.setPatente(unaPatente);
    }
    
    public String getNomDuenio() {
        return nomDuenio;
    }

    public void setNomDuenio(String nomDuenio) {
        this.nomDuenio = nomDuenio;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        String aux = " El auto de duenio: " + nomDuenio + " y patente=" + patente;
        return aux;
    }

    
}
