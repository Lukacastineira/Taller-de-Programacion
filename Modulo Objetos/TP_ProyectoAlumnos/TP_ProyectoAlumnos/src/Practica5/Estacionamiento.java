/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

/**
 *
 * @author Luka
 */
public class Estacionamiento {
    private String nombre;
    private String direccion;
    private int horaApertura;
    private int horaCierre;
    private Auto [][] autos;
    private int cantPisos;
    private int cantPlazas;

    public Estacionamiento (String nom, String direc){
        this.setNombre(nom);
        this.setDireccion(direc);
        this.setCantPisos(5);
        this.setCantPlazas(10);
        this.setHoraApertura(8);
        this.setHoraCierre(21);
        this.iniciarAutos(this.getCantPisos(),this.getCantPlazas());
        for (int i=0; i<this.getCantPisos(); i++){
            for (int j=0; j < this.getCantPlazas(); j++){
                this.setAuto(new Auto(), i, j);
            }
        }
    }
    
    public Estacionamiento (String nom, String direc, int apertura, int cierre, int pisos, int plazas){
         this.setNombre(nom);
         this.setDireccion(direc);
         this.setHoraApertura(apertura);
         this.setHoraCierre(cierre);
         this.setCantPisos(pisos);
         this.setCantPlazas(plazas);
         this.iniciarAutos(this.getCantPisos(), this.getCantPlazas());
         for (int i=0; i<this.getCantPisos(); i++){
            for (int j=0; j < this.getCantPlazas(); j++){
                this.setAuto(new Auto(), i, j);
            }
        }
    }
    
    public void iniciarAutos (int piso, int plaza){
        this.autos = new Auto [piso][plaza];
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(int horaApertura) {
        this.horaApertura = horaApertura;
    }

    public int getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(int horaCierre) {
        this.horaCierre = horaCierre;
    }

    public Auto[][] getAutos() {
        return this.autos;
    }

    public void setAuto(Auto aut, int piso, int plaza) {
        this.autos[piso][plaza] = aut;
    }

    public int getCantPisos() {
        return cantPisos;
    }

    public void setCantPisos(int cantPisos) {
        this.cantPisos = cantPisos;
    }

    public int getCantPlazas() {
        return cantPlazas;
    }

    public void setCantPlazas(int cantPlazas) {
        this.cantPlazas = cantPlazas;
    }
    
    public void registrarAuto (Auto aut, int piso, int plaza){
        if (this.getAutos()[piso][plaza].getNomDuenio().equals("sinNombre")){
            this.setAuto(aut, piso, plaza);
        }
        else 
          System.out.println ("Plaza ocupada.");
    }
    
    
    public String obtenerString (String patente){
        int i=0;  int j=0;
        String aux = "";
        while ((i<this.getCantPisos()) && (!this.getAutos()[i][j].getPatente().equals(patente)) ){
             i=i+1;
             while ((j<this.getCantPisos()) && (!this.getAutos()[i][j].getPatente().equals(patente)) ){
                 j=j+1;
             }
        }
        if (i<this.getCantPisos()){
           aux+= "El Auto de patente" +patente + "Se encuentra en el piso "+ (i+1) + " y en la plaza "+ (j+1);
        }
        else 
          aux+= "El auto de patente" +patente +"no existe";
        return aux;
        }
    
    @Override
    public String toString (){
        String aux = "";
        for (int i=0;i<this.getCantPisos();i++){
            for (int j=0; j<this.getCantPlazas();j++){
                if (this.getAutos()[i][j].getNomDuenio().equals("sinNombre"))
                    aux+= " Piso " + (i+1) + " Plaza "+ (j+1) + " Libre. \n";
                else
                    aux+= " Piso " + (i+1) + " Plaza "+ (j+1) + this.getAutos()[i][j].toString()+ "\n";
            }
           
        }
        return aux;
    }
    
    public int cantAutosPlaza (int plaza){
        int cant=0;
        for (int i=0;i<this.getCantPisos();i++){
             if (!this.getAutos()[i][plaza].getNomDuenio().equals("sinNombre"))
                cant = cant +1; 
        }
        return cant;
    }
    
    
    }
    
    
    

