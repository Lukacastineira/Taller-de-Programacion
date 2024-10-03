/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnodtema1_2023;

/**
 *
 * @author Luka
 */
public class Estacionamiento {
    private String direccion;
    private double costoHora;
    private Auto[][] autos;
    private int cantSectoresMax;
    private int cantAutosMax;

    public Estacionamiento(String unaDireccion, double unCostoHora, int i, int j) {
        this.setDireccion(unaDireccion);
        this.setCostoHora(unCostoHora);
        this.setCantSectoresMax(i);
        this.setCantAutosMax(j);
        this.setAutos(this.getCantSectoresMax(), this.getCantAutosMax());
        for (int i1=0; i1<this.getCantSectoresMax();i1++){
            for (int j1=0; j1<this.getCantAutosMax(); j1++){
                 this.getAutos()[i1][j1]= null;
            }
        }
    }

    
    
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(double costoHora) {
        this.costoHora = costoHora;
    }

    public int getCantSectoresMax() {
        return cantSectoresMax;
    }

    public void setCantSectoresMax(int cantSectoresMax) {
        this.cantSectoresMax = cantSectoresMax;
    }

    public int getCantAutosMax() {
        return cantAutosMax;
    }

    public void setCantAutosMax(int cantAutosMax) {
        this.cantAutosMax = cantAutosMax;
    }

    public void setAutos (int i, int j){
        this.autos = new Auto[i][j];
    }
    
    public Auto[][] getAutos() {
        return autos;
    }


    
    public void agregarAuto (int X, int Y, Auto aut){
         this.getAutos()[X-1][Y-1]= aut;
    }
    
    public void liberarEspacios (String marca){
        for (int i=0; i <this.getCantSectoresMax(); i++){
            for (int j=0;j<this.getCantAutosMax(); j++){
                if ((this.getAutos()[i][j]!=null)&&(this.getAutos()[i][j].getMarca().equals(marca))){
                    System.out.println ("El vehiculo: " + this.getAutos()[i][j].toString() + " Ya no tiene acceso. \n");
                    this.getAutos()[i][j] = null;
                }
            }
        }
    }
    
    
    public int getMaxTotal (){
        double max; int sectorMax=0; double maxSec=0;
        for (int i=0; i<this.getCantSectoresMax();i++){
            max = 0;
            for (int j=0; j<this.getCantAutosMax(); j++){
                if (this.getAutos()[i][j]!=null){
                   max = max + (this.getAutos()[i][j].getCantHoras()* this.getCostoHora());
                }
            }
            if (maxSec < max){
                maxSec = max;
                sectorMax = i;
            }
        }
        return sectorMax;
    }

    public String verificarOcupado (int i, int j){
        String aux;
        if (this.getAutos()[i][j]==null) {
            aux= " Lugar Desocupado. ";
        }
        else{
            aux = this.getAutos()[i][j].toString();
        }
      return aux;
    }
    
    
    @Override
    public String toString() {
        String aux;
        aux= "Estacionamiento, direccion=" + direccion + ", costoHora=" + costoHora + "\n";
        for (int i=0; i<this.getCantSectoresMax();i++){
            aux += " Sector " + (i+1)+ " ";
            for (int j=0; j<this.getCantAutosMax();j++){
                aux += "Lugar " + (j+1) + " " + this.verificarOcupado(i, j) + "\n";
            }
        }
        return aux;
    }
    
    
    
    
}
