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
    
    public boolean confirmarCantidad(int codigo,int cantidad) throws SQLException{
        sql="select cantidad from tb_productos where id_producto=" + codigo;
        resultado=this.consulta(sql);
        resultado.next();
        if(resultado.getInt("cantidad")<cantidad){
            return false;
        }else{
            return true;
        }
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
        sql="update tb_productos set cantidad=(select cantidad from(select * from tb_productos where id_producto= "+codigo+")as x)-"+cantidad+" where id_producto="+codigo+";";
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
            while (resultado.next()) {
                datos[0] = resultado.getString("id_producto");
                datos[1] = resultado.getString("nombre");
                datos[2] = resultado.getString("cantidad");
                datos[3] = resultado.getString("monto");
                listaProductos.add(datos);
                datos = new String[4];
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

    public ArrayList<String[]> consultarVentas(int mes, int año) {
        String[] datos = new String[3];
        ArrayList<String[]> listaVentas = new ArrayList<String[]>();
        try {
            sql = "select * from tb_venta ";//(select(month(sysdate())));";
            switch (mes) {
                case 0:
                    sql= sql; 
                case 1:
                    sql = sql + "where month(fecha)= 1 and year(fecha)= "+año;
                    break;
                case 2:
                    sql = sql + "where month(fecha)= 2 and year(fecha)= "+año;
                    break;
                case 3:
                    sql = sql + "where month(fecha)= 3 and year(fecha)= "+año;
                    break;
                case 4:
                    sql = sql + "where month(fecha)= 4 and year(fecha)= "+año;
                    break;
                case 5:
                    sql = sql + "where month(fecha)= 5 and year(fecha)= "+año;
                    break;
                case 6:
                    sql = sql + "where month(fecha)= 6 and year(fecha)= "+año;
                    break;
                case 7:
                    sql = sql + "where month(fecha)= 7 and year(fecha)= "+año;
                    break;
                case 8:
                    sql = sql + "where month(fecha)= 8 and year(fecha)= "+año;
                    break;
                case 9:
                    sql = sql + "where month(fecha)= 9 and year(fecha)= "+año;
                    break;
                case 10:
                    sql = sql + "where month(fecha)= 10 and year(fecha)= "+año;
                    break;
                case 11:
                    sql = sql + "where month(fecha)= 11 and year(fecha)= "+año;
                    break;
                case 12:
                    sql = sql + "where month(fecha)= 12 and year(fecha)= "+año;
                    break;
                    
            }
            resultado = this.consulta(sql);
            while (resultado.next()) {
                datos[0] = resultado.getString("id_venta");
                datos[1] = resultado.getString("fecha");
                datos[2] = resultado.getString("total");
                listaVentas.add(datos);
                datos = new String[4];
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentas;
    }
    
    public double totalVentas(int mes,int año) {
        double total=0;
        try {
            sql = "select sum(total) from tb_venta ";
            switch (mes) {
                case 0:
                    sql= sql; 
                case 1:
                    sql = sql + "where month(fecha)= 1 and year(fecha)= "+año;
                    break;
                case 2:
                    sql = sql + "where month(fecha)= 2 and year(fecha)= " +año;
                    break;
                case 3:
                    sql = sql + "where month(fecha)= 3 and year(fecha)= " +año;
                    break;
                case 4:
                    sql = sql + "where month(fecha)= 4 and year(fecha)= " +año;
                    break;
                case 5:
                    sql = sql + "where month(fecha)= 5 and year(fecha)= " +año;
                    break;
                case 6:
                    sql = sql + "where month(fecha)= 6 and year(fecha)= " +año;
                    break;
                case 7:
                    sql = sql + "where month(fecha)= 7 and year(fecha)= " +año;
                    break;
                case 8:
                    sql = sql + "where month(fecha)= 8 and year(fecha)= " +año;
                    break;
                case 9:
                    sql = sql + "where month(fecha)= 9 and year(fecha)= " +año;
                    break;
                case 10:
                    sql = sql + "where month(fecha)= 10 and year(fecha)= " +año;
                    break;
                case 11:
                    sql = sql + "where month(fecha)= 11 and year(fecha)= " +año;
                    break;
                case 12:
                    sql = sql + "where month(fecha)= 12 and year(fecha)= " +año;
                    break;          
            }
            resultado = this.consulta(sql);
            resultado.next();
            total=resultado.getDouble("sum(total)");
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public String[][] getMatrizVentas(int mes, int año) {
        ArrayList<String[]> listaVentas = consultarVentas(mes,año);
        String[][] matriz = new String[listaVentas.size()][3];
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = listaVentas.get(fila)[columna];
            }
        }
        return matriz;
    }
    
    public int getThisYear() throws SQLException{
        sql="select(year(sysdate()))";
        resultado=this.consulta(sql);
        resultado.next();
        return resultado.getInt("(year(sysdate()))");
    }
    
    public void cancelarVenta() throws SQLException{
        sql="delete from tb_venta where ID_Factura=(select max(id_Venta) from(select * from tb_venta)as x);";
        this.proceso(sql);
        sql="delete from tb_venta where ID_Venta=(select max(id_Venta) from(select * from tb_venta)as x);";
        this.proceso(sql);
    }

}
