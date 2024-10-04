/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoetema1_2023;

/**
 *
 * @author Luka
 */
public abstract class Banco {
    private String nombre;
    private int cantEmpleados;
    private Cuenta [] cuentas;
    private int numeroCuentas;

    public Banco(String nombre, int cantEmpleados, int nCuentas) {
        this.setNombre(nombre);
        this.setCantEmpleados(cantEmpleados);
        this.setNumeroCuentas(nCuentas);
        this.cuentas = new Cuenta[this.getNumeroCuentas()];
        for (int i=0; i<this.getNumeroCuentas();i++){
            this.getCuentas()[i]= null;
        }
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }

    public void setCantEmpleados(int cantEmpleados) {
        this.cantEmpleados = cantEmpleados;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public int getNumeroCuentas() {
        return numeroCuentas;
    }

    public void setNumeroCuentas(int numeroCuentas) {
        this.numeroCuentas = numeroCuentas;
    }

    public String verificarCuenta (int i){
        String aux;
        if (this.getCuentas()[i]==null){
            aux = " No Hay Cuenta ";
        }
        else {
            aux=this.getCuentas()[i].toString();
        }
        return aux;
    }
    
    public abstract boolean agregarCuenta (Cuenta cuent);
    
    
    public abstract Cuenta obtenerCuenta (int cbu);
    

    public abstract void depositarDinero(int cbu, double monto);
    
    
    public abstract boolean puedeRecibirTarjeta(int cbu);
    
    @Override
    public String toString() {
        String aux;
        aux = "Banco: " + nombre + ", cantidad de empleados: " + cantEmpleados + " ";
        for (int i=0; i<this.getNumeroCuentas(); i++){
            if (this.getCuentas()[i]!=null){
               aux += " Cuenta " + (i+1)+ " " + this.verificarCuenta(i) + "\n";
            }
        }
        return aux;
    }  
    
     
    
}
