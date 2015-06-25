/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Raul
 */
public class Venta {
    
    int montoTotalAdquirido;

    
    public Venta(int montoTotalAdquirido) {
        this.montoTotalAdquirido = montoTotalAdquirido;
    }

    public int getMontoAdquirido() {
        return montoTotalAdquirido;
    }

    public void setMontoAdquirido(int montoAdquirido) {
        this.montoTotalAdquirido = montoAdquirido;
    }


    
    
    
}
