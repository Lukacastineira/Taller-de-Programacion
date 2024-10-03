/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package castineira;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

public class Castineira {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       GeneradorAleatorio.iniciar();
       System.out.println("Ingrese num Categorias y num Canciones por categoria");
       ConcursodeCanto concurCanto = new ConcursodeCanto (Lector.leerInt(),Lector.leerInt());
       
        for (int i=0; i < 5;i++){
             System.out.println("Ingrese nombre de Cancion, compositor y numero de identificacion"); 
             concurCanto.agregarCancion(GeneradorAleatorio.generarInt(3), GeneradorAleatorio.generarInt(5), new Cancion (Lector.leerString(),Lector.leerString(),Lector.leerInt()));    
        }
        System.out.println("Ingrese num ident cancion");
        int aux  = Lector.leerInt();
        while (aux != 0) {
            System.out.println("Ingrese nombre, apellido, dni del estudiante y puntaje otorgado por los profesores ");
            concurCanto.InterpretarCancion(aux, new Estudiante (Lector.leerString(),Lector.leerString(),Lector.leerInt()), Lector.leerInt());
            System.out.println("Ingrese num ident cancion");
            aux  = Lector.leerInt();
        }
        System.out.println("Ingrese num ident cancion");
        int numGanador = Lector.leerInt();
        if (concurCanto.getEstudianteGanador(numGanador)!=null){
           System.out.println(concurCanto.getEstudianteGanador(numGanador).toString());
        }else{
             System.out.println("Nadie.");
        }
        
   // for (int num=0; num<3; num++)   {
        System.out.println(concurCanto.getCancionCategoria(1).toString() + " Categoria "+ (2+1));
   // }
       
       
       
    }
    
}
