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
    
  

    public String agregarCompra( int IdProducto, int cantidad, int precio) throws SQLException {
        salida = "";


            sql = "select Precio from tb_productos where id_producto=" + IdProducto;
            resultado = this.consulta(sql);
            resultado.next();
            System.out.println(resultado.getDouble("Precio"));
            double monto = 0;
            monto = (resultado.getDouble("precio"));
            monto = monto + precio;
            monto = monto * cantidad;

            sql = "update producto set cantidad = cantidad +'"
                    + cantidad + "'where IdProducto='"
                    + IdProducto+ "';";
            this.proceso(sql);
            salida = "se agrego";
        
        return salida;

    }

    public Compra verificarIdProducto(String idPro) {
        try {
            sql = "select * from tb_productos where id_producto=" + idPro;
            resultado = this.consulta(sql);
            while (resultado.next()) {
                return new Compra(resultado.getString("id_producto"), resultado.getInt("precio"), resultado.getInt("cantidad de productos"), resultado.getString(null), resultado.getString(null), resultado.getString(null), resultado.getInt(null), resultado.getInt(null));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    

}
