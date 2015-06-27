/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raul
 */
public class RegistroVenta extends RegistroBD {

    String salida = "";
    private ResultSet resultado;
    private String sql;

    public RegistroVenta() throws SQLException, ClassNotFoundException {
        super();
    }

    public void crearNuevaVenta() throws SQLException {
        sql = "insert into tb_venta(fecha,total) values(date(sysdate()),0);";
        this.proceso(sql);
    }

    public double getTotal() throws SQLException {
        sql = "select total from tb_venta where id_venta=(select max(id_venta) from tb_venta)";
        resultado = this.consulta(sql);
        resultado.next();
        return resultado.getDouble("total");
    }

    public void incluirProducto(int codigo, int cantidad) throws SQLException {
        sql = "select Precio from tb_productos where id_producto=" + codigo;
        resultado = this.consulta(sql);
        resultado.next();
        System.out.println(resultado.getDouble("Precio"));
        double monto = 0;
        monto = (resultado.getDouble("precio"));
        monto = monto + monto * 0.10 + monto * 0.13;
        monto = monto * cantidad;
        sql = "insert into tb_factura(ID_Venta,id_Producto,cantidad,monto) values"
                + "((select max(id_venta) from tb_venta)," + codigo + "," + cantidad + "," + monto + ")";
        this.proceso(sql);
        sql = "select total, id_venta from tb_venta where id_venta=(select max(id_venta) from tb_venta)";
        resultado = this.consulta(sql);
        resultado.next();
        double total = (resultado.getFloat("total"));
        total = total + monto;
        sql = "SET SQL_SAFE_UPDATES=0;";
        this.proceso(sql);
        sql = "update tb_venta set total= " + total
                + " where id_venta="
                + "(select max(id_Venta) from(select * from tb_venta)as x)";
        this.proceso(sql);
    }

    public ArrayList<String[]> consultarFactura() {
        String[] datos = new String[4];
        ArrayList<String[]> listaProductos = new ArrayList<String[]>();
        try {
            sql = "select F.id_producto,P.nombre,F.cantidad,F.monto from tb_factura F, tb_productos P \n"
                    + "where F.id_Producto=P.id_Producto \n"
                    + "and ID_Venta=\n"
                    + "(select max(id_Venta) from(select * from tb_venta)as x)\n"
                    + "group by F.fila;";
            resultado = this.consulta(sql);
            while(resultado.next()){
            datos[0] = resultado.getString("id_producto");
            datos[1] = resultado.getString("nombre");
            datos[2] = resultado.getString("cantidad");
            datos[3] = resultado.getString("monto");
            listaProductos.add(datos);
            datos=new String[4];
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductos;
    }

    public String[][] getMatrizFactura() {
        ArrayList<String[]> listaProductos = consultarFactura();
        String[][] matriz = new String[listaProductos.size()][Venta.getNumeroAtributos()];
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = listaProductos.get(fila)[columna];
            }
        }
        return matriz;
    }

}
