/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema3;
    
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;


/*  3-A- Defina una clase para representar estantes. Un estante almacena a lo sumo 20 libros.
    Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:

    (i) devolver la cantidad de libros que almacenados (ii) devolver si el estante está lleno


    (iii) agregar un libro al estante (iv) devolver el libro con un título particular que se recibe.

    B- Realice un programa que instancie un estante. Cargue varios libros. A partir del estante,
    busque e informe el autor del libro “Mujercitas”.
    
    C- Piense: ¿Qué modificaría en la clase definida para ahora permitir estantes que
    almacenen como máximo N libros? ¿Cómo instanciaría el estante?

 */
public class Ej03 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Estanteria estante = new Estanteria(5);
        
        for (int i=0; i<5; i++){
            String nombreAutor = Lector.leerString();
            String bio = GeneradorAleatorio.generarString(5);
            String origen = GeneradorAleatorio.generarString(5);       
            Autor autor = new Autor (nombreAutor,bio,origen);
            
            String titulo = Lector.leerString();
            String editorial = GeneradorAleatorio.generarString(5);
            String isbn =  GeneradorAleatorio.generarString(5);
            Libro libro = new Libro (titulo,editorial,autor,isbn);
            estante.agregarLibro(libro);
        }
        System.out.println (estante.getCantLibros());
        if (estante.getEstanteriaLlena()==true){
            System.out.println("Estanteria Llena");
        }
        else 
            System.out.println("La Estanteria no esta Llena");
        System.out.println (estante.getTituloEspecifico("Mujercitas").getprimerAutor().getNombre());
    }
    
}
