
package tema1;

import PaqueteLectura.Lector;


public class Ej02Jugadores {

  
    public static void main(String[] args) {       
        int dimf = 15;
        double[] alturas = new double [dimf];
        
        int i; double prom = 0; double cantSupera= 0; double altura;
        for (i=0; i <= 14; i++){
            altura = Lector.leerDouble();
            alturas[i]=altura;
            prom = prom + altura;
        }
        prom = prom / dimf;
        System.out.println("El Promedio de Alturas es: " + prom);
       
        for (i=0; i<=14;i++){
            if (prom < alturas[i]) 
               cantSupera = cantSupera + 1;
        }
        System.out.println ("La cantidad de jugadores que superan la estatura de " + prom + " es: "+ cantSupera);
    }
    
}
