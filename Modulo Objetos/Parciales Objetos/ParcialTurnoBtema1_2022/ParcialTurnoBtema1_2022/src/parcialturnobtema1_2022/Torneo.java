/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnobtema1_2022;

/**
 *
 * @author Luka
 */
public class Torneo {
    private String nombre;
    private int numeroFechasMax;
    private int cantGoleadoresFechaMax;
    private Goleador [][] tabla; 
    private int [] cantGoleadoresRegistrados;

    public Torneo(String nombre, int numeroFechasMax, int cantGoleadoresFechaMax) {
        this.setNombre(nombre);
        this.setNumeroFechasMax(numeroFechasMax);
        this.setCantGoleadoresFechaMax(cantGoleadoresFechaMax);
        this.tabla = new Goleador [this.getNumeroFechasMax()][this.getCantGoleadoresFechaMax()];
        this.inicializarTabla();
        this.cantGoleadoresRegistrados = new int [this.getNumeroFechasMax()];
        this.inicializarCantGoleadores();
    }
       
    public void agregarGoleador (int X, Goleador jug){
        this.tabla[X-1][this.cantGoleadoresRegistrados[X-1]]= jug;
        this.cantGoleadoresRegistrados[X-1]= this.cantGoleadoresRegistrados[X-1] + 1;
        
    }
    
    public Goleador getMenorCantGoles (int X){
        int min=9999; Goleador menosG=null;
            for (int j=0; j<this.getCantGoleadoresFechaMax();j++){
                if ((this.tabla[X-1][j] != null) && (this.tabla[X-1][j].getCantGolesFecha()<min)){
                    min = this.tabla[X-1][j].getCantGolesFecha();
                    menosG=this.tabla[X-1][j];
                }
            }
        return menosG;
    }
    
    public int getCantTotalGoleadores (){
        int cantTotal=0;
        for (int i=0; i<this.getNumeroFechasMax();i++){
            cantTotal = cantTotal + this.cantGoleadoresRegistrados[i];
        }
        return cantTotal;
    }
    
    public void inicializarCantGoleadores (){
        for (int i=0; i<this.getNumeroFechasMax();i++){
            this.cantGoleadoresRegistrados[i]=0;
        }
    }
    
    
    public void inicializarTabla (){
        for (int i=0; i<this.getNumeroFechasMax();i++){
            for (int j=0; j<this.getCantGoleadoresFechaMax();j++){
                this.tabla[i][j] =null;
            }
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroFechasMax() {
        return numeroFechasMax;
    }

    public void setNumeroFechasMax(int numeroFechasMax) {
        this.numeroFechasMax = numeroFechasMax;
    }

    public int getCantGoleadoresFechaMax() {
        return cantGoleadoresFechaMax;
    }

    public void setCantGoleadoresFechaMax(int cantGoleadoresFechaMax) {
        this.cantGoleadoresFechaMax = cantGoleadoresFechaMax;
    }

    public String verificaGoleador (int i, int j){
        String aux;
        if (this.tabla[i][j]!= null){
           aux = this.tabla[i][j].toString();
        }else {
            aux = " ";
        }
        return aux;
    }
    
    @Override
    public String toString() {
        String aux;
        aux= " Torneo 2022: " + this.getNombre() + "\n";
        for (int i=0; i<this.getNumeroFechasMax();i++){
            aux += " Fecha #" + (i+1) + ": " + this.cantGoleadoresRegistrados[i];
            for (int j=0; j<this.getCantGoleadoresFechaMax();j++){
                aux +=  this.verificaGoleador(i, j) + "\n";
            }
        }
        return aux;
    }
    
    
    
    
    
}
