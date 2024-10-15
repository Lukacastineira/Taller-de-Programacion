/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnobtema2_2022;

/**
 *
 * @author Luka
 */
public class Empresa {
    private String nombreBarrio;
    private int numeroMaxManzanas;
    private int lotesPorManzanaMax;
    private Lote [][] barrio;

    public Empresa(String nombreBarrio, int numeroMaxManzanas, int lotesPorManzanaMax) {
        this.setNombreBarrio(nombreBarrio);
        this.setNumeroMaxManzanas(numeroMaxManzanas);
        this.setLotesPorManzanaMax(lotesPorManzanaMax);
        this.barrio = new Lote [this.getNumeroMaxManzanas()][this.getLotesPorManzanaMax()];
        this.inicializarLotes();
        
        
    }

    
    public void inicializarLotes (){
        for (int i=0;i<this.getNumeroMaxManzanas();i++){
            for (int j=0;j<this.getLotesPorManzanaMax();j++){
                this.barrio[i][j]= new Lote();
            }
        }
    }
    
    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    public int getNumeroMaxManzanas() {
        return numeroMaxManzanas;
    }

    public void setNumeroMaxManzanas(int numeroMaxManzanas) {
        this.numeroMaxManzanas = numeroMaxManzanas;
    }

    public int getLotesPorManzanaMax() {
        return lotesPorManzanaMax;
    }

    public void setLotesPorManzanaMax(int lotesPorManzanaMax) {
        this.lotesPorManzanaMax = lotesPorManzanaMax;
    }
    
    public void agregarComprador (Comprador C, int Y, int X){
        this.barrio[Y-1][X-1].agregarComp(C);
    }
    
    public void aumentarPrecioManzana (int X, double P){
        for (int j=0; j<this.getLotesPorManzanaMax();j++){
            if (this.barrio[X-1][j].verificar())
              this.barrio[X-1][j].setPrecio(this.barrio[X-1][j].getPrecio()*P);
        }
    }
    
    public double getTotalVendido (){
        double total=0;
        for (int i=0;i<this.getNumeroMaxManzanas();i++){
            for (int j=0; j<this.getLotesPorManzanaMax();j++){
                 if (this.barrio[i][j]!=null){
                     total = total + this.barrio[i][j].getPrecio();
                 }
            }
        }
        return total;
    }

    @Override
    public String toString() {
        String aux;
        aux = " Barrio: " + this.getNombreBarrio() + "\n";
        aux += " Recaudacion Total: " + this.getTotalVendido()+ "\n";
        for (int i=0; i < this.getNumeroMaxManzanas();i++){
            aux += " Manzana " + (i+1) + " \n";
            for (int j=0;j<this.getLotesPorManzanaMax();j++){
                aux += " Lote #" + (j+1) + " "+this.barrio[i][j].toString() + " \n";
            }
        }
        return aux;
    }
    
    
    
    
    
    
}
