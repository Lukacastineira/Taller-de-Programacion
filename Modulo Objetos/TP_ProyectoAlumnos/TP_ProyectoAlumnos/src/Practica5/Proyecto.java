/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

import PaqueteLectura.GeneradorAleatorio;
public class Proyecto {
    private String nombre;
    private int codigo;
    private String nomCompletoDirector;
    private int cantInvestigadores=0;
    private Investigador [] investigadores;

    
    public Proyecto(String unNombre, int unCodigo, String unNomCompletoDirector) {
        this.setNombre(unNombre);
        this.setCodigo(unCodigo);
        this.setNomCompletoDirector(unNomCompletoDirector);
        this.investigadores = new Investigador [50];
    }
    
    public boolean investLleno (){
        return this.getCantInvestigadores() <50;
    }
    
    public void agregarInvestigador (Investigador invest){
        if (this.investLleno()){
          this.setInvestigadores(invest);
          this.setCantInvestigadores(this.getCantInvestigadores()+1);
        }
    }
    
    public void otorgarTodos (String nombre_completo){
        int i=0; GeneradorAleatorio.iniciar();
        while ((i < this.getCantInvestigadores())&& (this.getInvestigadores()[i].getNomCompleto().equals(nombre_completo))){
            i++;
        }
        if (i<this.getCantInvestigadores())
            while (this.getInvestigadores()[i].permitidoAgregar()){
                this.getInvestigadores()[i].agrgarSubsidio(new Subsidio(GeneradorAleatorio.generarDouble(50000),"Se lo Merece."));
            }
        else 
          System.out.println("no existe este investigador");
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomCompletoDirector() {
        return nomCompletoDirector;
    }

    public void setNomCompletoDirector(String nomCompletoDirector) {
        this.nomCompletoDirector = nomCompletoDirector;
    }

    public int getCantInvestigadores() {
        return cantInvestigadores;
    }

    public void setCantInvestigadores(int cantInvestigadores) {
        this.cantInvestigadores = cantInvestigadores;
    }

    public Investigador[] getInvestigadores() {
        return investigadores;
    }
   
    
    public void setInvestigadores(Investigador investigadores) {
        this.investigadores[this.getCantInvestigadores()] = investigadores;
    }

    public double totalDineroOtorgado (){
        double aux=0;
        for (int i=0; i < this.getCantInvestigadores(); i++){
            aux = aux + this.getInvestigadores()[i].dineroTotalOtorgado();
        }
        return aux;
    }
    
    public String investTotaltoString (){
        String aux ="";
        for (int i=0; i<this.getCantInvestigadores(); i++){
           aux += this.getInvestigadores()[i].toString()+"\n";
        }
        aux += "";
        return aux;
    }
    
    @Override
    public String toString() {  
       String aux = "EL Proyecto: "+nombre+ " con codigo: " + codigo ; 
               aux += " y Director: "+nomCompletoDirector+ this.totalDineroOtorgado();
               aux += this.investTotaltoString() ;
       return aux;
    }
            
    
    
    
}
