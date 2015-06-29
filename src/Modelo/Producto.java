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
public class Producto {

    private String idProducto;
    private String nombre;
    private String descripcion;
    private String marca;
    private int precio;
    private int cantidad;
    private static String[] etiquetas = {"ID", "Nombre", "Marca", "Precio", "Cantidad"};

    public Producto(String idProducto, String nombre, String descripcion, String marca, int precio, int cantidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public static String[] getEtiquetas() {
        return etiquetas;
    }

    public String getAtributo(int numeroAtributo) {
        switch (numeroAtributo) {
            case 0:
                return idProducto;
            case 1:
                return nombre;
            case 2:
                return marca;
            case 3:
                return String.valueOf(precio);
            case 4:
                return String.valueOf(cantidad);
            default:
                return null;
        }
    }

    public static int getNumeroAtributos() {
        return etiquetas.length;
    }

}
