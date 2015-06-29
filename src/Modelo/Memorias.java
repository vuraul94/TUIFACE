/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Raul
 */
public class Memorias  extends Producto {

    String capacidad;
    
    public Memorias(String idProducto,String nombre, String descripcion, String marca, int precio, int cantidad, String capacidad) {
        super(idProducto,nombre, descripcion, marca, precio, cantidad);
        this.capacidad=capacidad;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
    
    
}
