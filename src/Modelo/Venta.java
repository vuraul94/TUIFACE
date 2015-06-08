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
    
    ArrayList<Producto> productosVendidos;
    int montoTotalAdquirido;

    
    public Venta(ArrayList<Producto> productosVendidos, int montoTotalAdquirido) {
        this.productosVendidos = productosVendidos;
        this.montoTotalAdquirido = montoTotalAdquirido;
    }

    public ArrayList<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(ArrayList<Producto> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    public int getMontoAdquirido() {
        return montoTotalAdquirido;
    }

    public void setMontoAdquirido(int montoAdquirido) {
        this.montoTotalAdquirido = montoAdquirido;
    }


    
    
    
}
