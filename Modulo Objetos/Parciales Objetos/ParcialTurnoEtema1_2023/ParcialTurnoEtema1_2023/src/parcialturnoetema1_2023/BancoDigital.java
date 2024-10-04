/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoetema1_2023;

/**
 *
 * @author Luka
 */
public class BancoDigital extends Banco {
     private String direccionWeb;
     private int cantCuentas=0;

    public BancoDigital(String nombre, int cantEmpleados, int nCuentas, String direc) {
        super(nombre, cantEmpleados, nCuentas);
        this.setDireccionWeb(direc);
    }

     
     
     
    public String getDireccionWeb() {
        return direccionWeb;
    }

    public void setDireccionWeb(String direccionWeb) {
        this.direccionWeb = direccionWeb;
    }

    public int getCantCuentas() {
        return cantCuentas;
    }

    public void setCantCuentas(int cantCuentas) {
        this.cantCuentas = cantCuentas;
    }

    
    @Override
    public boolean agregarCuenta(Cuenta cuent) {
        boolean cumple = true;
        if (this.getCantCuentas() < this.getNumeroCuentas()){
          this.getCuentas()[this.getCantCuentas()]=cuent;
          this.setCantCuentas(this.getCantCuentas()+1);
        }
        else{
          cumple = false;
        }
        return cumple;
    }

     @Override
    public Cuenta obtenerCuenta(int cbu) {
        int i=0; Cuenta cuentBuscada=null; boolean encontre = false;
        while ((i<this.getCantCuentas()) && (!encontre)) {
             if ((this.getCuentas()!=null) && (this.getCuentas()[i].getCbu()==cbu)){
                 cuentBuscada = this.getCuentas()[i];
                 encontre =true;
             }
          i++;
        }
     return cuentBuscada;
    }

    @Override
    public void depositarDinero(int cbu, double monto) {
        int i=0; boolean encontre = false;
        while ((i<this.getCantCuentas()) && (!encontre)) {
             if ((this.getCuentas()!=null) && (this.getCuentas()[i].getCbu()==cbu)){
                 this.getCuentas()[i].setMonto(this.getCuentas()[i].getMonto()+monto);
                 encontre =true;
             }
          i++;
        }
    }

    @Override
    public boolean puedeRecibirTarjeta(int cbu) {
       int i=0; boolean encontre = false;
        while ((i<this.getCantCuentas()) && (!encontre)) {
             if ((this.getCuentas()!=null) && (this.getCuentas()[i].getCbu()==cbu)){
                if ((this.getCuentas()[i].getMoneda().equals("Pesos"))&& (this.getCuentas()[i].getMonto()>100000)){
                   encontre =true;
                }
             }
          i++;
        }
       return encontre; 
    }

     
     @Override
    public String toString (){
       String aux;
       aux = "Banco con direccion WEB:" + this.getDireccionWeb();
       aux+= super.toString();
       return aux;
    }
    
    
}
