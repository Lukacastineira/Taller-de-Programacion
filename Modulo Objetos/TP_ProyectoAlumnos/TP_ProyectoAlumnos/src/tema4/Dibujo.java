/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author Luka
 */
public class Dibujo{
    private String titulo;
    private Figura [] vector;
    private int guardadas;
    private int capacidadMaxima=10;
      //inicia el dibujo, sin figuras
      public Dibujo (String titulo){
          this.setCapacidadMaxima(this.getCapacidadMaxima());
          vector = new Figura [this.getCapacidadMaxima()];
          this.setGuardadas(0);
      }

    public int getGuardadas() {
        return guardadas;
    }

    public void setGuardadas(int guardadas) {
        this.guardadas = guardadas;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
      //agrega la figura al dibujo
      public void agregar(Figura f){
         this.vector[this.guardadas++]=f;
         System.out.println("la figura"+ f.toString() + "se ha guardado");
      }
      
      
      //calcula el área del dibujo:
      //suma de las áreas de sus figuras
      public double calcularArea(){
        double areasTotales=0;
        for (int i=0; i<this.getGuardadas();i++)
            areasTotales = areasTotales + this.vector[i].calcularArea();
        return areasTotales;
      }
      
      
      //imprime el título, representación
      //de cada figura, y área del dibujo
      public void mostrar(){
        for (int i=0; i < this.getGuardadas();i++){
            System.out.println (this.vector[i].toString());
        }     
      }
      //retorna está lleno el dibujo
      public boolean estaLleno() {
      return (this.getGuardadas() == this.getCapacidadMaxima());
      }

  

}
