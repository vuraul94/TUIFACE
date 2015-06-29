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
public class Procesadores extends Producto{
    
    int nucleos;
    int frecuencia;

    public Procesadores(String idProducto,String nombre, String descripcion, String marca, int precio, int cantidad, int nucleos, int frecuencia) {
        super(idProducto, nombre, descripcion, marca, precio, cantidad);
        this.nucleos=nucleos;
        this.frecuencia=frecuencia;
    }

    public int getNucleos() {
        return nucleos;
    }

    public void setNucleos(int nucleos) {
        this.nucleos = nucleos;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
    
    
}
