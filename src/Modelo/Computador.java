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
public class Computador extends Producto{
    
    int rom;
    int ram;
    String procesador;
    

    public Computador(String idProducto,String nombre, String descripcion, String marca, int precio, int cantidad, int rom, int ram, String procesador) {
        super(idProducto,nombre, descripcion, marca, precio, cantidad);
        this.rom=rom;
        this.ram=ram;
        this.procesador=procesador;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
    
}
