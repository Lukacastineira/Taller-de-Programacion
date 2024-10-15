/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoptema2_2024;

/**
 *
 * @author Luka
 */
public class Sandwich {
    private String nombre;
    private Pan pan;
    private Ingrediente [] ingredientes;
    private int cantMaxIngredientes;
    private int cantIngredientes;

    public Sandwich(String nombre, int cantMaxIngredientes, Pan pancito) {
        this.setNombre(nombre);
        this.setCantMaxIngredientes(cantMaxIngredientes);
        this.pan = pancito;
        this.ingredientes = new Ingrediente[this.getCantMaxIngredientes()];
        this.inicializarIngredientes();
        this.setCantIngredientes(0);
    }
 
    public void inicializarIngredientes (){
        for (int i=0; i<this.getCantMaxIngredientes();i++){
           this.ingredientes[i]=null;
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantMaxIngredientes() {
        return cantMaxIngredientes;
    }

    public void setCantMaxIngredientes(int cantMaxIngredientes) {
        this.cantMaxIngredientes = cantMaxIngredientes;
    }

    public int getCantIngredientes() {
        return cantIngredientes;
    }

    public void setCantIngredientes(int cantIngredientes) {
        this.cantIngredientes = cantIngredientes;
    }
    
     
    
    public void agregarIngrediente (Ingrediente ingre){
        if (this.getCantIngredientes() < this.getCantMaxIngredientes()){
            this.ingredientes[this.getCantIngredientes()]=ingre;
            this.setCantIngredientes(this.getCantIngredientes()+1);
        }
    }

    @Override
    public String toString() {
        String aux; double costoF=0;
        aux = " Sandwich: " + this.getNombre() + "\n";
        aux += " Pan: " + this.pan.toString() + "\n";
        costoF = costoF + this.pan.getCostoFinal();
        for (int i=0; i<this.getCantIngredientes();i++){
            aux += " Ingrediente: " + this.ingredientes[i].toString() + "\n";
            costoF = costoF + this.ingredientes[i].getCostoFinal();
        }   
        aux += " Costo Final: " + costoF + "$ " + "\n";
        return aux;
    }
    
    
    
    
    
}
