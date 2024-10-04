/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoftema1_2023;

/**
 *
 * @author Luka
 */
public class Empresa {
    private String nombre;
    private String direccion;
    private Director directorEjecutivo;
    private int nSucursalesMax;
    private int nSucursales=0;
    private Encargado [] encargados;

    public Empresa(String nombre, String direccion, Director directorEjecutivo, int nSucursales) {
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setDirectorEjecutivo(directorEjecutivo);
        this.setnSucursalesMax(nSucursales);
        this.encargados = new Encargado[this.getnSucursalesMax()];
        for (int i=0; i<this.getnSucursalesMax();i++){
            this.getEncargados()[i]=null;
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

    public Director getDirectorEjecutivo() {
        return directorEjecutivo;
    }

    public void setDirectorEjecutivo(Director directorEjecutivo) {
        this.directorEjecutivo = directorEjecutivo;
    }

    public int getnSucursalesMax() {
        return nSucursalesMax;
    }

    public void setnSucursalesMax(int nSucursales) {
        this.nSucursalesMax = nSucursales;
    }

    public Encargado[] getEncargados() {
        return encargados;
    }

    public int getnSucursales() {
        return nSucursales;
    }

    public void setnSucursales(int nSucursales) {
        this.nSucursales = nSucursales;
    }

    
    
    public void asignarEncargado (Encargado enc, int X){
        if (this.getnSucursales()<this.getnSucursalesMax()){
            this.getEncargados()[X-1]=enc;
            this.setnSucursales(this.getnSucursales()+1);        
        }        
    }
    
    public String sucursalOcupada (int i){
        String aux;
        if (this.getEncargados()[i]==null){
            aux = " sin Encargado. ";
        }else{
            aux= this.getEncargados()[i].toString();
        }
        return aux;
    }

    @Override
    public String toString() {
        String aux;
        aux= "La Empresa: " + this.getNombre() + " con direccion: " + this.getDireccion() + " ";
        aux+= " Director Ejecutivo: "+ this.getDirectorEjecutivo().toString() + " ";
        for (int i=0; i<this.getnSucursalesMax(); i++){
            aux+= "Sucursal "+ (i+1) + " Encargado: "+this.sucursalOcupada(i)+ " \n";       
        }
        return aux;
    }
    
    
    
    
}
