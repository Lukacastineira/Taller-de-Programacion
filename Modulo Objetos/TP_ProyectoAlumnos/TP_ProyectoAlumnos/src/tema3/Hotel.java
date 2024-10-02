/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author Luka
 */
public class Hotel {
    private Habitacion[] habitaciones; 
    private int numHabitaciones=10; 

    public Hotel(int i) {
        numHabitaciones = i;
        habitaciones = new Habitacion[i];
        habitaciones = new Habitacion [i];
        for (int j = 0; j < i; j++) {
           habitaciones[j] = new Habitacion(); // inicializar cada habitación
       }
    }
    
    public Hotel () {
       habitaciones = new Habitacion[numHabitaciones];
   }
    
    public void ingresarCliente (Persona C, int X){
        if (!habitaciones[X].getOcupada()) {
            habitaciones[X].setCliente(C);
            habitaciones[X].ocupar();
        }  
    }
    
    public void aumentarPrecio(double aumento){
        for (int i=0; i<numHabitaciones; i++){
            habitaciones[i].setCostoNoche(habitaciones[i].getCostoNoche() + aumento);
        }
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }
    
    public String toStrin (){
        String aux = ".";
        for (int i=0; i < numHabitaciones; i++){
          aux += " La habitacion " + (i+1)+ ":" + this.habitaciones[i].toString()+"\n";
        }
        return aux;
    }
    
}
