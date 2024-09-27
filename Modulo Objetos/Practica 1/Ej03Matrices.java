/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ej03Matrices {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        //Paso 2. iniciar el generador aleatorio     
	
        int [][] aleatorios = new int [5][5]; 
        int i; int j;
        for (i=0; i<=4; i++)
           for (j=0; j<=4; j++)
              aleatorios[i][j] = GeneradorAleatorio.generarInt(30);            
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        
        for (i=0; i<=4;i++)
           for (j=0;j<=4;j++)
             System.out.println ("La posicion: " +i+','+j+ " contiene el: " + aleatorios[i][j]);
        //Paso 4. mostrar el contenido de la matriz en consola
        
        int suma = 0;
        for (j=0;j<=4;j++)
           suma = suma +  aleatorios[1][j];
        System.out.println(suma);
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        int [] sumasJ = new int [5];
        int sumas;
        for (j=0;j<5;j++){
            sumas=0;
          for (i=0;i<=4;i++)
             sumas = sumas + aleatorios[i][j];
          sumasJ[j]=sumas;
        } 
        for (j=0;j<=4;j++)   
            System.out.println (" La columna, "+j+" su suma fue: "+sumasJ[j]);
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.
        boolean encontre=false; 
        int num7 = Lector.leerInt();
        i=0; j=0; int fila=0; int columna=0;
        while (! encontre && i<5 && j<5){
              if (num7==aleatorios[i][j]){
                  encontre=true;
                  fila=i; columna=j;
              }
              else j++; i++;
                     
        }
         if (! encontre)
           System.out.println ("No se encontro el elemento en la Matriz.");
         else
           System.out.println ("Se encontro el numero "+num7+ " En la Pos "+fila+','+columna);
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".


        
        
        
        
        
        
   }   
}
