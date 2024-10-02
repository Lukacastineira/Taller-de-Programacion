/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

/**
 *
 * @author Luka
 */
public class Investigador {
    private String nomCompleto;
    private int categoria;
    private String especialidad;
    private int cantSubsidios=0;
    private Subsidio [] subsidios;

    public Investigador(String unNomCompleto, int cat, String esp) {
        this.setNomCompleto(unNomCompleto);
        this.setCategoria(cat);
        this.setEspecialidad(esp);
        this.subsidios = new Subsidio[5];
        for (int i=0; i<5;i++){
            this.setSubsidio(i);
            
        }
        
    }

    public void setSubsidio (int i){
        this.subsidios[i]= new Subsidio(1,"Sin Motivo");
    }
    
    public String getNomCompleto() {
        return nomCompleto;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Subsidio [] getSubsidio(){
        return this.subsidios;
    }

    public int getCantSubsidios() {
        return cantSubsidios;
    }

    public void setCantSubsidios(int cantSubsidios) {
        this.cantSubsidios = cantSubsidios;
    }
    
    public boolean permitidoAgregar (){
        return this.getCantSubsidios()<5;
    }
    
   public void agrgarSubsidio (Subsidio subsidio){
      if (this.permitidoAgregar()){
         this.getSubsidio()[this.getCantSubsidios()] = subsidio;
         this.getSubsidio()[this.getCantSubsidios()].setOtorgado(true);
         this.setCantSubsidios(this.getCantSubsidios()+1);
      }
   }
    
   public double dineroTotalOtorgado (){
       double aux=0;
       for (int i=0; i<this.getCantSubsidios();i++){
           aux = aux +  this.getSubsidio()[i].getMontoPedido();
       }
       return aux;      
   }
   
   
  

    @Override
    public String toString() {
        String aux = " Investigador de nombre: " + nomCompleto + ", categoria: " ;
        aux += categoria + ", especialidad: " + especialidad + " el total de dinero otorgado es: "+ this.dineroTotalOtorgado()+ " ";
        return aux;
    }
   
}
