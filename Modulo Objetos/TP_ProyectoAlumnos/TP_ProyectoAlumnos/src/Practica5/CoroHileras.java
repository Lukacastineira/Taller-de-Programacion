/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

/**
 *
 * @author Luka
 */
public class CoroHileras extends Coro {
    private Corista [][] coristashileras;
    private int cantHileras;
    private int cantCoristasH=0;
    private int [] cantCoristasF;   
    public CoroHileras(String nombreCoro, Director unDirec, int hileras) {
        super(nombreCoro,unDirec);
        this.setCantHileras(hileras);
        this.cantCoristasF = new int [this.getCantHileras()];
        for (int i =0 ; i<this.getCantHileras();i++){
            this.getCantCoristasF()[i] = 0;
        }
        this.setCoristashileras(new Corista[this.getCantHileras()][this.getCantHileras()]);
        for (int i=0; i<this.getCantHileras();i++){
            for (int j=0; j<this.getCantHileras();j++){
                this.setCorista(i, i, new Corista());
            }
        }
    }
    public Corista[][] getCoristashileras() {
        return coristashileras;
    }
    public void setCoristashileras(Corista[][] coristashileras) {
        this.coristashileras = coristashileras;
    }
    public void setCorista (int i,int j, Corista co){
        this.getCoristashileras()[i][j]= co;
    }    
    public int getCantHileras() {
        return cantHileras;
    }
    public void setCantHileras(int cantHileras) {
        this.cantHileras = cantHileras;
    }
    public int getCantCoristas() {
        return this.cantCoristasH;
    }
    public void setCantCoristas(int cantCoristas) {
        this.cantCoristasH = cantCoristas;
    }
    public int getCantCoristasH() {
        return cantCoristasH;
    }
    public void setCantCoristasH(int cantCoristasH) {
        this.cantCoristasH = cantCoristasH;
    }
    public int[] getCantCoristasF() {
        return cantCoristasF;
    }  
    public void setCantCoristasF(int i){
        this.getCantCoristasF()[i] = this.getCantCoristasF()[i] +1;
    }   
    @Override
    public boolean estaLleno (){
       boolean condicion=false;
       if (this.getCantCoristasF()[(this.getCantHileras()-1)] == this.getCantHileras()){
          condicion = true;
       }
       return condicion;
    }   
    @Override
    public void agregarCorista(Corista co) {
        if (!this.estaLleno()){
            this.setCorista(this.getCantCoristasH(), this.getCantCoristasF()[this.getCantCoristasH()], co);
            if (this.getCantCoristasF()[this.getCantCoristasH()] < this.getCantHileras()-1){
                this.setCantCoristasF(this.getCantCoristasH());
            }
            else 
               this.setCantCoristasH(this.getCantCoristasH()+1);
        }    
    }
    public boolean segundaCondicion (){
        int j=0; int i=0; int tonoActual=999; boolean cumple=true;
           while ((i<this.getCantCoristasH()) && (cumple)){
              if (this.getCoristashileras()[i][1].getTono() < tonoActual){
                  tonoActual=this.getCoristashileras()[i][1].getTono();
                  i++;
              }
              else 
                cumple=false;
            }
    return cumple;
    } 
    @Override
    public boolean bienFormado() {
       boolean cumple=true;
       int i=0; int j;
       int tonoActual;
       boolean dosCondiciones = false;
       while ((i<this.getCantHileras()) && (cumple)){
           j=0;
           tonoActual = this.getCoristashileras()[i][j].getTono();
           while ((j<this.getCantHileras()) && (cumple)){
              if (this.getCoristashileras()[i][j].getTono()!=tonoActual){
                  cumple = false;
              }
              else{
                 j++;
              }
            }
           i++;
       }
       if ((this.segundaCondicion()) && (cumple))
           dosCondiciones = true;
       return dosCondiciones;
    }
    @Override
    
    public String toString() {
        String aux;
        aux = super.toString() ;
        for (int i=0; i<this.getCantHileras(); i++){
            for (int j=0; j < this.getCantHileras();  j++){
                aux += this.getCoristashileras()[i][j].toString()+ "\n";
            }
        }
        return aux;       
    }    
} 
