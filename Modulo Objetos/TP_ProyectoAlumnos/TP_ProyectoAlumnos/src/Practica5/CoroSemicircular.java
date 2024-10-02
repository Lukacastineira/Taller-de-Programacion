/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

/**
 *
 * @author Luka
 */
public class CoroSemicircular extends Coro{
    private Corista [] coristasSemicircular;
    private int cantCoristasMax;
    private int cantCoristas=0;
    
    public CoroSemicircular(String nombreCoro, Director unDirec, int unaCantCoristas) {
        super(nombreCoro,unDirec);
        this.setCantCoristasMax(unaCantCoristas);
        this.setCoristasSemicircular(new Corista[this.getCantCoristasMax()]);
        for (int i=0; i < this.getCantCoristasMax(); i++){
            this.setCorista(new Corista(), i);
        }
    }

    public Corista[] getCoristasSemicircular() {
        return coristasSemicircular;
    }

    public void setCoristasSemicircular(Corista[] coristasSemicircular) {
        this.coristasSemicircular = coristasSemicircular;
    }

    public int getCantCoristasMax() {
        return cantCoristasMax;
    }

    public void setCantCoristasMax(int cantCoristasMax) {
        this.cantCoristasMax = cantCoristasMax;
    }

    public int getCantCoristas() {
        return cantCoristas;
    }

    public void setCantCoristas(int cantCoristas) {
        this.cantCoristas = cantCoristas;
    }

    public void setCorista (Corista co,int i){
        this.getCoristasSemicircular()[i]=co;
    }
    
    public Corista getCorista (int i){
        return this.getCoristasSemicircular()[i];
    }
    
    @Override
    public boolean estaLleno() {
        return !(this.getCantCoristas() < this.getCantCoristasMax());
    }
    
    
    @Override
    public void agregarCorista(Corista co) {
        if (!this.estaLleno()){
            this.setCorista(co, this.getCantCoristas());
            this.setCantCoristas(this.getCantCoristas()+1);
        }
    }

    @Override
    public boolean bienFormado() {
       int i=0; boolean cumple=true; int tonoActual=999;
       while ((i<this.getCantCoristas()) && (cumple)){
           if (this.getCoristasSemicircular()[i].getTono()< tonoActual){
               tonoActual= this.getCoristasSemicircular()[i].getTono();
           } else {
              cumple = false;
           }
           i++;
       }
       return cumple;
    }

    @Override
    public String toString() {
        String aux;
           aux = super.toString();
           for (int i=0; i < this.getCantCoristas(); i++){
               aux += this.getCoristasSemicircular()[i].toString() + "\n";
           }
        return  aux;
    }
    
    

}
