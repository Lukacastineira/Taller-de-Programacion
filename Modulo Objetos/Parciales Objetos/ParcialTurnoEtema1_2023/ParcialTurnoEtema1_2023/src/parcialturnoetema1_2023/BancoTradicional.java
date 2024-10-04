/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialturnoetema1_2023;

/**
 *
 * @author Luka
 */
public class BancoTradicional extends Banco {
    private String direccion;
    private String localidad;
    private int cantCuentasDolares;
    private int maxCuentaDolares=100;
    private int cantCuentas=0;

    public BancoTradicional(String nom, int cantEmpleados, int numCuentas ,String direccion, String localidad) {
        super(nom,cantEmpleados,numCuentas);
        this.setDireccion(direccion);
        this.setLocalidad(localidad);
        this.setCantCuentasDolares(0);
    }

    
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCantCuentasDolares() {
        return cantCuentasDolares;
    }

    public void setCantCuentasDolares(int cantCuentasDolares) {
        this.cantCuentasDolares = cantCuentasDolares;
    }

    public int getMaxCuentaDolares() {
        return maxCuentaDolares;
    }

    public void setMaxCuentaDolares(int maxCuentaDolares) {
        this.maxCuentaDolares = maxCuentaDolares;
    }

    public int getCantCuentas() {
        return cantCuentas;
    }

    public void setCantCuentas(int cantCuentas) {
        this.cantCuentas = cantCuentas;
    }
    
    
    
    @Override
    public boolean agregarCuenta (Cuenta cuent) {
        boolean cumple = true;
        if (this.getCantCuentas() < this.getNumeroCuentas()){
            if ((this.getCantCuentasDolares()<this.getMaxCuentaDolares())&&(this.getCantCuentas()<this.getNumeroCuentas())){
               if (cuent.getMoneda().equals("Dolares")){
                  this.getCuentas()[this.getCantCuentas()]=cuent;
                  this.setCantCuentas(this.getCantCuentas()+1);
                  this.setCantCuentasDolares(this.getCantCuentasDolares()+1);
               }
              else if(!cuent.getMoneda().equals("Dolares")){
                  this.getCuentas()[this.getCantCuentas()]=cuent;
                  this.setCantCuentas(this.getCantCuentas()+1);
              }
            }
        }
        else{
          cumple = false;
        }
        return cumple;
    }

    @Override
    public Cuenta obtenerCuenta(int cbu) {
        int i=0; boolean encontre=false; Cuenta cuentaBuscada=null;
        while ((i<this.getNumeroCuentas()) && (!encontre)) {
             if ((this.getCuentas()!=null) && (this.getCuentas()[i].getCbu()==cbu)){
                 cuentaBuscada = this.getCuentas()[i];
                 encontre =true;
             }
          i++;
        }
      return cuentaBuscada;
    }
    
    
    @Override
    public void depositarDinero(int cbu, double monto) {
        int i=0; boolean encontre = false;
        while ((i<this.getNumeroCuentas()) && (!encontre)) {
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
        while ((i<this.getNumeroCuentas()) && (!encontre)) {
             if ((this.getCuentas()[i]!=null) && (this.getCuentas()[i].getCbu()==cbu)){
                    if ((this.getCuentas()[i].getMoneda().equals("Dolares")) && (this.getCuentas()[i].getMonto()>500)){
                        encontre = true;
                    }else if((this.getCuentas()[i].getMoneda().equals("Pesos")) && (this.getCuentas()[i].getMonto()>70000)){
                        encontre = true;
                    }
                }
          i++;
        }
       return encontre;    
    }  

    @Override
    public String toString() {
        String aux;
        aux= "Banco con direccion=" + this.getDireccion() + ", y localidad: " + this.getLocalidad();
        aux += super.toString();
        return aux;
    }
    
    
}
