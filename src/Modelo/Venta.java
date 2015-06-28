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

    private String idVenta;
    private String fecha;
    private int montoTotalAdquirido;

    private static String[] etiquetasFactura = {"ID Producto", "Nombre", "Cantidad", "Monto"};

    public Venta(String idVenta, String fecha, int montoTotalAdquirido) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.montoTotalAdquirido = montoTotalAdquirido;
    }

    public int getMontoAdquirido() {
        return montoTotalAdquirido;
    }

    public void setMontoAdquirido(int montoAdquirido) {
        this.montoTotalAdquirido = montoAdquirido;
    }

    public static String[] getEtiquetasFactura() {
        return etiquetasFactura;
    }

    public static int getNumeroAtributos() {
        return etiquetasFactura.length;
    }

}
