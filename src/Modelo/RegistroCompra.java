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
      
      public String agregarCompra(Producto producto,int idProducto , int cantidad ,int precio) throws SQLException{
          salida="";
          
          if(verificarIdProducto(producto.getIdProducto())==null){
              
              sql = "select Precio from tb_productos where id_producto=" + idProducto;
        resultado = this.consulta(sql);
        resultado.next();
        System.out.println(resultado.getDouble("Precio"));
        double monto = 0;
        monto = (resultado.getDouble("precio"));
        monto = monto + precio;
        monto = monto * cantidad;
        
              sql="update producto set cantidad = cantidad +'"
                      +cantidad + "'where IdProducto='"
                      +producto.getIdProducto()+"';";
              this.proceso(sql);
              salida="se agrego";
          }else{
              salida= "no se agrego";
          }
          return salida;
          
      }

   
    public Compra verificarIdProducto(int idPro) {
        try {
            sql = "select * from tb_productos where id_producto=" + idPro;
            resultado = this.consulta(sql);
            while (resultado.next()) {
                return new Compra(resultado.getInt("id_producto"), resultado.getInt("precio"), resultado.getInt("cantidad de productos"), resultado.getString(null), resultado.getString(null), resultado.getString(null), resultado.getInt(null), resultado.getInt(null));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    

}
