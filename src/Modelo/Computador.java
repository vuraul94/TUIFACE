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
    
    Memorias rom;
    Memorias ram;
    Producto tarjetaMadre;
    Procesadores procesador;
    

    public Computador(String nombre, String descripcion, String marca, int precio, int cantidad, Memorias rom, Memorias ram, Producto tarjetaMadre,Procesadores procesador) {
        super(nombre, descripcion, marca, precio, cantidad);
        this.rom=rom;
        this.ram=ram;
        this.tarjetaMadre=tarjetaMadre;
        this.procesador=procesador;
    }

    public Memorias getRom() {
        return rom;
    }

    public void setRom(Memorias rom) {
        this.rom = rom;
    }

    public Memorias getRam() {
        return ram;
    }

    public void setRam(Memorias ram) {
        this.ram = ram;
    }

    public Producto getTarjetaMadre() {
        return tarjetaMadre;
    }

    public void setTarjetaMadre(Producto tarjetaMadre) {
        this.tarjetaMadre = tarjetaMadre;
    }

    public Procesadores getProcesador() {
        return procesador;
    }

    public void setProcesador(Procesadores procesador) {
        this.procesador = procesador;
    }
    
}
