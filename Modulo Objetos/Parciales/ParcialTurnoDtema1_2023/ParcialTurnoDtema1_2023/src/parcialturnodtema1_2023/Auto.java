/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnodtema1_2023;

/**
 *
 * @author Luka
 */
public class Auto {
    private String patente;
    private int cantHoras;
    private String marca;
    private String modelo;

    public Auto(String unaPatente, int unasCantHoras, String unaMarca, String unModelo) {
        this.setPatente(unaPatente);
        this.setCantHoras(unasCantHoras);
        this.setMarca(unaMarca);
        this.setModelo(unModelo);
    }

    public Auto() {
        this.setPatente("sinPatente");
        this.setCantHoras(-1);
        this.setMarca("sinMarca");
        this.setModelo("sinModelo");
    }

    
    
    
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        String aux;
        aux = " Patente: " + this.getPatente() + ", cantidad de Horas: " + this.getCantHoras() + ", Marca: "; 
        aux+=  this.getMarca() + ", Modelo: " + this.getModelo() ;
        return aux;   
    }
    
    
    
}
