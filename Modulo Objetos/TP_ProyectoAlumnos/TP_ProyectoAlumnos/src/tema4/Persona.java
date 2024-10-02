/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author Luka
 */
public class Persona {
      private String nombre; 
      private int dni;
      private int edad;

    public Persona (String unNombre, int unDni, int unaEdad){
          this.setNombre(unNombre);
          this.setDni(unDni);
          this.setEdad(unaEdad);
    }
      
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
       String aux = "Mi nombre es: " + this.getNombre() + ", mi DNI es: " + this.getDni(); 
       aux += " y tengo: " + this.getEdad() + " anios";
       return aux;
    }
      
      
}
