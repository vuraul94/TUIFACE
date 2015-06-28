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

    public String incluirCompra(Compra compra) {
        salida = "";
        try {
            if (verificarIdProducto(compra.getIdProducto()) == null) {

                sql = "insert into tb_compras values("
                        + compra.getIdProducto()
                        + "," + compra.getPrecioCompra()
                        + "," + compra.getCantidadCompra() + ");";
                this.proceso(sql);
                salida = "la informacion se agrego correctamentes";
            } else {
                salida = "la compra ya existe ";
            }
        } catch (SQLException ex) {
            salida = "Error al incluir la información.";
        }
        return salida;

    }

    public ArrayList<Compra> consultarCompra() {
        ArrayList<Compra> listaCompra = new ArrayList<Compra>();
        try {

            sql = "select * from tb_compra";
            resultado = this.consulta(sql);
            while (resultado.next()) {
                listaCompra.add(new Compra(resultado.getInt("id_producto"), resultado.getInt("precio del producto"), resultado.getInt("cantidad de productos"), resultado.getString(null), resultado.getString(null), resultado.getString(null), resultado.getInt(null), resultado.getInt(null)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCompra;
    }

    public Compra verificarIdProducto(int idPro) {
        try {
            sql = "select * from tb_compra where id_producto=" + idPro;
            resultado = this.consulta(sql);
            while (resultado.next()) {
                return new Compra(resultado.getInt("id_producto"), resultado.getInt("precio del producto"), resultado.getInt("cantidad de productos"), resultado.getString(null), resultado.getString(null), resultado.getString(null), resultado.getInt(null), resultado.getInt(null));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getListaCompras() {
        salida = "";
        for (Compra compra : this.consultarCompra()) {
            salida += "ID_Compra: " + compra.getIdProducto() + "\tPrecio: " + compra.getPrecioCompra() + "\nCantidad de la compra: " + compra.getCantidadCompra() + "\n";
        }
        return salida;
    }

}
