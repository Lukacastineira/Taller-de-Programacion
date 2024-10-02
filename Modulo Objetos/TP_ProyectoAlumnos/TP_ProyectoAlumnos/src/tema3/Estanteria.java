/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author Luka
 */
public class Estanteria {
    private Libro [] libros; 
    private int cantLibros=0;
    private int cantMaxLibros =20;

    public Estanteria() {
        libros = new Libro [cantMaxLibros];
    }
    
    public Estanteria (int i){
        cantMaxLibros = i;
        libros = new Libro [i];
    }
    
    public  int getCantLibros (){
        return cantLibros;
    }
    
    public boolean getEstanteriaLlena (){
        return (cantLibros == cantMaxLibros);
    }
    
    public Libro agregarLibro (Libro unLibro){
        libros[cantLibros] = unLibro; 
        cantLibros = cantLibros + 1;
        return unLibro;
    }

    public Libro getTituloEspecifico (String unTitulo){
        int i=0;  
        while ((i < cantMaxLibros) &&  (!unTitulo.equals(this.libros[i].getTitulo()))) {
            i++;
            }
        if (i < cantLibros){
          return libros[i];
        }
        else 
          return null;
    }
}
