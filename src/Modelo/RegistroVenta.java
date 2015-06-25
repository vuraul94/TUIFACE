/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        sql ="select total from tb_venta where id_venta=(select max(id_venta) from tb_venta)";
        resultado= this.consulta(sql);
        return resultado.getDouble("total");
    }
    
    public void incluirProducto(int codigo,int cantidad) throws SQLException{
        sql="select Precio from tb_productos where id_producto="+codigo;
        resultado=this.consulta(sql);
        System.out.println(resultado.getDouble("Precio"));
        double monto;
        monto=(resultado.getDouble("precio"));
        monto=monto+monto*0.10+ monto*0.13;
        monto=monto*cantidad;
        sql="insert into tb_factura(id_venta,id_Producto,cantidad,monto) values"
                +"((select max(id_venta)),"+codigo+","+cantidad+","+monto+")";
        this.proceso(sql);
        sql ="select total from tb_venta where id_venta=max(id_venta)";
        resultado= this.consulta(sql);
        double total=(resultado.getFloat("total"))*cantidad;
        sql="update tb_venta set total="+(total+monto)+"where id_venta=max(id_venta)";
    }

}
