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

    int capacidad;
    
    public Memorias(String nombre, String descripcion, String marca, int precio, int cantidad, int capacidad) {
        super(nombre, descripcion, marca, precio, cantidad);
        this.capacidad=capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
}
