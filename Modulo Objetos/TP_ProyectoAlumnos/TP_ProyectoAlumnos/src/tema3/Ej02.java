/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema3;

/**
 *
 * @author Luka
 */
public class Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Autor autor1 = new Autor ("Luka", " Buenas Buenas ", "Argentina");
        Libro libro1 = new Libro("AguanteJava", "LaMejor", 2024, autor1,"199992453:353", 12500.50);
        System.out.println(libro1.toString());
        System.out.println(libro1.getprimerAutor().toString());
    }
    
}
