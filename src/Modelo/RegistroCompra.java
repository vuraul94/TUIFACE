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
 * @author Né
 */
public class RegistroCompra extends RegistroBD {

    String salida = "";
    private ResultSet resultado;
    private String sql;

    public RegistroCompra() throws SQLException, ClassNotFoundException {
        super();
    }

    public void agregarCompra(String producto, int cantidad, double monto, String proveedor) throws SQLException {
        int stock;
        sql = "insert into tb_compra (fecha ,cantidad, monto, ID_Proveedor , ID_Producto) "
                + "values((select(date(sysdate()))),"
                + cantidad + ","
                + monto + ",'"
                + proveedor + "','"
                + producto + "');";
        this.proceso(sql);
        sql = "update tb_productos set precio= " + monto
                + " where id_producto= '" + producto + "' ;";
        this.proceso(sql);
        sql = "select cantidad from tb_productos where id_producto= '"
                + producto + "';";
        resultado = this.consulta(sql);
        resultado.next();
        stock = resultado.getInt("cantidad");
        sql = "update tb_productos set cantidad= " + (stock + cantidad)
                + " where id_producto= '" + producto + "' ;";
        this.proceso(sql);
    }

    public Compra verificarIdProducto(String idPro) {
        try {
            sql = "select * from tb_productos where id_producto='" + idPro + "'";
            resultado = this.consulta(sql);
            while (resultado.next()) {
                return new Compra(resultado.getString("id_producto"), resultado.getInt("precio"), resultado.getInt("cantidad de productos"), resultado.getString(null), resultado.getString(null), resultado.getString(null), resultado.getInt(null), resultado.getInt(null));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String[] listaProveedores() throws SQLException {
        ArrayList<String> proveedores = new ArrayList<String>();
        String[] id_proveedores;
        sql = "select ID_Proveedor from tb_proveedor";
        resultado = this.consulta(sql);
        while (resultado.next()) {
            proveedores.add(resultado.getString("ID_Proveedor"));
        }
        id_proveedores = new String[proveedores.size()];
        id_proveedores = proveedores.toArray(id_proveedores);
        return id_proveedores;
    }

}
