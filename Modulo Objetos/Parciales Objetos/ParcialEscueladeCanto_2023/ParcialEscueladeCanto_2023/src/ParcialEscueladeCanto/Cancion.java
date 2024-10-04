/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParcialEscueladeCanto;

/**
 *
 * @author Luka
 */
public class Cancion {
    private String nombre;
    private String compositor;
    private int ident;
    private Estudiante mejorInterpretacion;
    private int puntajeProfes;

    public Cancion(String unNombre, String unCompositor, int unIdent) {
        this.setNombre(unNombre);
        this.setCompositor(unCompositor);
        this.setIdent(unIdent);
        this.setPuntajeProfes(0);
        this.setEtudiante(new Estudiante());
        
    }

    public Cancion() {
       this.setNombre("sinNombre");
       this.setCompositor("sinCompositor");
       this.setIdent(-1);
       this.setPuntajeProfes(0);
       this.setEtudiante(new Estudiante());
    }

    public void setEtudiante (Estudiante est){
        this.mejorInterpretacion = new Estudiante();
    }
    
    public Estudiante getEstudiante (){
        return this.mejorInterpretacion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public int getIdent() {
        return ident;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }

    public Estudiante getMejorInterpretacion() {
        return mejorInterpretacion;
    }

    public void setMejorInterpretacion(Estudiante mejorInterpretacion) {
        this.mejorInterpretacion = mejorInterpretacion;
    }

    public int getPuntajeProfes() {
        return puntajeProfes;
    }

    public void setPuntajeProfes(int puntajeProfes) {
        this.puntajeProfes = puntajeProfes;
    }

    @Override
    public String toString() {
        String aux;
        aux = " Cancion de nombre: " + nombre + ", compositor: " + compositor + " \n";
        return aux;
    }
    
    
    
}
