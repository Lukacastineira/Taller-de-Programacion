/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnohtema1_2023;

/**
 *
 * @author Luka
 */
public class Estadio {
    private String nombre;
    private String direccion;
    private int capacidad;
    private Concierto [][] conciertos;

    public Estadio(String nombre, String direccion, int capacidad) {
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setCapacidad(capacidad);
        this.conciertos = new Concierto [12][31];
        for (int i=0; i<12;i++){
            for (int j=0; j<31;j++){
                this.getConciertos()[i][j]=null;
            }
        }
    }
  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Concierto[][] getConciertos() {
        return conciertos;
    }

    public void agregarConcierto (Concierto con, int M){
        int j=0;
        while ((j<31) && (this.getConciertos()[M-1][j])!=null){
         j++;
        }
        if (j<31){
           this.getConciertos()[M-1][j]=con;
        }else{
            System.out.println(" El mes "+ M + " Esta Completo. ");
        }
    }

    public String huboConcierto (int M, int j){
        String aux;
        if (this.getConciertos()[M][j]==null){
           aux = " No Hubo Concierto ";
        }else{
            aux = this.getConciertos()[M][j].toString();
        }
        return aux;
    }
    
    public String listaConciertosM(int M) {
        String aux;
        aux = " Mes " + M + " \n";
        for (int j=0; j<31; j++){
           aux += " Dia " + (j+1)+ ": " + this.huboConcierto((M-1), j) + " \n";
        }
        return aux;
    }
    
    public double getGanaciaEstadio (int M){
        double totalGanancia=0;
        for (int j=0; j<31;j++){
            if (this.getConciertos()[M-1][j] != null){
                totalGanancia = totalGanancia + (this.getConciertos()[M-1][j].getCantEntradasVendidas()*this.getConciertos()[M-1][j].getPrecioEntrada());
            }
        }
        totalGanancia = totalGanancia / 2;
        return totalGanancia;
    }

    @Override
    public String toString() {
        String aux;
        aux= " Estadio: " + this.getNombre() + ", Su direccion es:" + this.getDireccion() + " y su Capacidad: " + this.getCapacidad() + " ";
        for (int i=0; i<12 ;i++){
          aux+=  this.listaConciertosM((i+1));
        }
        return aux;
    }
    
    
    
    
}
