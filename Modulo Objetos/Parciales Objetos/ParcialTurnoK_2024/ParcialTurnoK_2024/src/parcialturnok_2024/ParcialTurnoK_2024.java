/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialturnok_2024;
import PaqueteLectura.Lector;
public class ParcialTurnoK_2024 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println ("Ingrese nombre de empresa: ");
        System.out.println ("Ingrese nombre, dni, sueldo basico, cantidad de lineas por hora, lenguaje preferido, antiguedad y cantidad de proyectos");
        System.out.println ("Cantidad maxima de programadores: ");
        Empresa infoEmp = new Empresa (Lector.leerString(),new Lider (Lector.leerString(),Lector.leerInt(),Lector.leerDouble(),Lector.leerInt(),Lector.leerString(),Lector.leerInt(),Lector.leerInt()),Lector.leerInt());
        
        for (int i=0; i<2;i++){
            System.out.println ("Ingrese nombre, dni, sueldo basico, cantidad de lineas por hora, lenguaje preferido");
            infoEmp.agregarProgramador(new Programador(Lector.leerString(),Lector.leerInt(),Lector.leerDouble(),Lector.leerInt(),Lector.leerString()));
            
        }
        
        infoEmp.aumentarSueldos(25000);
        
        System.out.println (infoEmp.toString());
        
        
    }
    
}
