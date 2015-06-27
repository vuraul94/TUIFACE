/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Né
 */
public class Compra extends Producto{
    private int cantidadCompra;
    private int precioCompra;

    public Compra(int idProducto, int precioCompra ,int cantidadCompra, String nombre, String descripcion, String marca, int precio, int cantidad) {
        super(idProducto, nombre, descripcion, marca, precio, cantidad);
        this.cantidadCompra = cantidadCompra;
        this.precioCompra = precioCompra;
        
    }

    public int getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(int cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }
    
    
    
    

    
}
