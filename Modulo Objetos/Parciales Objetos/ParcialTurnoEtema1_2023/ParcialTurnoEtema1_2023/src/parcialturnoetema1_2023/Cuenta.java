/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoetema1_2023;

/**
 *
 * @author Luka
 */
public class Cuenta {
    private int cbu;
    private String alias;
    private int dni;
    private String moneda;
    private double monto;

    public Cuenta(int unCbu, String unAlias, int unDni, String unaMoneda, double unMonto) {
        this.setCbu(unCbu);
        this.setAlias(unAlias);
        this.setDni(unDni);
        this.setMoneda(unaMoneda);
        this.setMonto(unMonto);
    }


    
    
    
    
    public int getCbu() {
        return cbu;
    }

    public void setCbu(int cbu) {
        this.cbu = cbu;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        String aux;
        aux= " CBU: " + this.getCbu() + ", Alias: " + this.getAlias() + ", DNI: " + this.getDni() + ", Moneda: " + moneda;
        aux+=     ", Monto: " + this.getMonto() + " ";
        return aux;
    }
    
    
    
}
