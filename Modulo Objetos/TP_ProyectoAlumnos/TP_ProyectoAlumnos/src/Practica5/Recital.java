/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

/**
 *
 * @author Luka
 */
public abstract class Recital {
    private String banda;
    private String [] listadeTemas;
    private int cantTemasMax;
    private int cantTemas=0;

    public Recital(String unaBanda, int unasCantTemas) {
        this.setBanda(banda);
        this.setCantTemasMax(unasCantTemas);
        this.setListadeTemas(unasCantTemas);
        for (int i=0; i < this.getCantTemasMax(); i++){
            this.setTema("sinNombreBanda", i);
        }
    }

    public void setTema (String nom, int i){
        this.getListadeTemas()[i]= nom;
    }
    
    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String[] getListadeTemas() {
        return  this.listadeTemas;
    }
    
    public void setListadeTemas (int i){
        this.listadeTemas = new String [i];
    }

    public int getCantTemasMax() {
        return cantTemasMax;
    }

    public void setCantTemasMax(int cantTemasMax) {
        this.cantTemasMax = cantTemasMax;
    }

    public int getCantTemas() {
        return cantTemas;
    }

    public void setCantTemas(int cantTemas) {
        this.cantTemas = cantTemas;
    }
  
    
    public boolean hayEspacio (){
        return this.getCantTemas() < this.getCantTemasMax();
    }
    
    
    
    public void agregarTema (String tema){
        if (this.hayEspacio()){
          this.setTema(tema, this.getCantTemas());
          this.setCantTemas(this.getCantTemas()+1);
        }
        else 
           System.out.println ("Se excedio la cantidad de Temas.");
    }
    
    public String actuar (){
        String aux ="";
        for (int i=0; i< this.getCantTemas(); i++){
            aux+= " y ahora tocaremos, " + this.getListadeTemas()[i]+ "\n";
        }
        aux += "";
        return aux;
    }
    public abstract double calcularCosto ();
}

