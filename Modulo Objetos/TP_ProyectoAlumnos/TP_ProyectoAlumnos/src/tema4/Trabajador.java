/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author Luka
 */
public class Trabajador extends Persona{
      private String tareaRealizada;
    public Trabajador(String unNombre, int unDni, int unaEdad, String tarea) {
        super(unNombre, unDni, unaEdad);
        this.setTareaRealizada(tarea);
    }

    public String getTareaRealizada() {
        return tareaRealizada;
    }

    public void setTareaRealizada(String tareaRealizada) {
        this.tareaRealizada = tareaRealizada;
    }

    @Override
    public String toString() {
        String aux = super.toString()+  " soy " + this.getTareaRealizada();
        return aux;
    }
    
}
