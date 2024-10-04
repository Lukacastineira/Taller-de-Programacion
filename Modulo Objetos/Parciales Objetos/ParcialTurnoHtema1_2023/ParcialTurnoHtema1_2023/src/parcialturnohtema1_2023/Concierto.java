/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnohtema1_2023;

/**
 *
 * @author Luka
 */
public class Concierto {
    private String nomArtista;
    private double precioEntrada;
    private int cantEntradasVendidas;

    public Concierto(String nomArtista, double precioEntrada, int cantEntradasVendidas) {
        this.setNomArtista(nomArtista);
        this.setPrecioEntrada(precioEntrada);
        this.setCantEntradasVendidas(cantEntradasVendidas);
    }

    
    
    
    public String getNomArtista() {
        return nomArtista;
    }

    public void setNomArtista(String nomArtista) {
        this.nomArtista = nomArtista;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public int getCantEntradasVendidas() {
        return cantEntradasVendidas;
    }

    public void setCantEntradasVendidas(int cantEntradasVendidas) {
        this.cantEntradasVendidas = cantEntradasVendidas;
    }

    @Override
    public String toString() {
        String aux;
        aux=" El Artista: " + nomArtista + ", Las entradas cuestan: " + precioEntrada +"$";
        aux+= ", Cantidad Vendida: " + cantEntradasVendidas+ " ";
        return aux;
    }
    
    
    
    
    
}
