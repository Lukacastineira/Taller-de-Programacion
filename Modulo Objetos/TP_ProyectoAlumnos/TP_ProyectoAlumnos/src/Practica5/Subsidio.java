/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5;

/**
 *
 * @author Luka
 */
public class Subsidio {
    private double montoPedido;
    private String motivo;
    private boolean otorgado;

    public Subsidio(double unMontoPedido, String unMotivo) {
        this.setMontoPedido(unMontoPedido);
        this.setMotivo(unMotivo);
        this.setOtorgado(false);
    }

    
    public double getMontoPedido() {
        return montoPedido;
    }

    public void setMontoPedido(double montoPedido) {
        this.montoPedido = montoPedido;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isOtorgado() {
        return otorgado;
    }

    public void setOtorgado(boolean otorgado) {
        this.otorgado = otorgado;
    }
    
    
    
}
