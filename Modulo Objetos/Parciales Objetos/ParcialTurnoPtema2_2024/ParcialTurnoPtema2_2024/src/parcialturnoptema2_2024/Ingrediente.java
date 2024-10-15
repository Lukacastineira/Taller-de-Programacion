/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoptema2_2024;

/**
 *
 * @author Luka
 */
public class Ingrediente extends Componente{
    private String grupo; // A o B

    public Ingrediente(String nombre, double costo, String grupo) {
        super(nombre,costo);
        this.setGrupo(grupo);
    }

    
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public double getCostoFinal() {
        double costoF;
        if (this.getGrupo().equals("B")){
            costoF = this.getCosto() * 1.10;
        }else{
            costoF = this.getCosto();
        }
        return costoF;
    }

    @Override
    public String toString() {
        String aux;
        aux = " Grupo: " + this.getGrupo()+ super.toString();
        return aux;
    }
    
    
    
    
}
