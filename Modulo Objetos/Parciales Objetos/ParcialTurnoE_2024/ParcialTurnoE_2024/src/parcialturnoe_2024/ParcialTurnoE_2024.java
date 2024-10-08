/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialturnoe_2024;

import PaqueteLectura.Lector;
public class ParcialTurnoE_2024 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println ("Ingrese direccion del super");
        Supermercado superm = new Supermercado (Lector.leerString());
        
        for (int i1=1; i1<2 ;i1++ ){
            System.out.println ("Ingrese nombre de Cajero y cantidad maxima de tickets. ");
            superm.agregarCaja(new Caja (Lector.leerString(),Lector.leerInt()));
            System.out.println ("Ingrese CUIT, cantidad de productos, monto, forma de pago.");
            int cuit = Lector.leerInt(); int cantProduc = Lector.leerInt(); double monto=Lector.leerDouble();
            String formaPago = Lector.leerString();
            superm.agregarenCajaEspecifica(i1,cuit,cantProduc, monto, formaPago);
        }
        
        System.out.println ("La caja con menor cantidad de tickets con forma de pago credito es: "+ superm.nCajaMenorTickets());
        
        System.out.println (superm.toString());
    }
    
}
