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
public class RegistroProductos extends RegistroBD {
    String salida = "";
    private ResultSet resultado;
    private String sql;
    
    public RegistroProductos() throws SQLException, ClassNotFoundException {
        super();
    }
    
    public String incluirProductos(Producto producto) {
        salida="";
        try {
             if (verificarID(producto.getIdProducto()) == null) {
            sql = "insert into tb_productos values("
                    +producto.getIdProducto()
                    +",'"+producto.getNombre()
                    +"','"+producto.getMarca()
                    +"','"+producto.getPrecio()
                    +"','"+producto.getCantidad()
                    +"','"+producto.getDescripcion()+"');";
            this.proceso(sql);
            salida = "La información se agregó correctamente.";
             }else{
                 salida="El producto ya se encuentra registrada.";
             }         
        } catch (SQLException ex) {
            salida = "Error al incluir la información.";
        }
        return salida;
    }

    public String modificarPoductos(Producto producto) {
        salida="";
        try {
             if (verificarID(producto.getIdProducto()) != null) {
            sql = "update tb_productos set nombre='"+producto.getNombre()
                    +"', marca='"+producto.getMarca()
                    +"', precio='"+producto.getPrecio()
                    +"',cantidad='"+producto.getCantidad()
                    +"',descripcion='"+producto.getDescripcion()
                    +"' where id_producto="+producto.getIdProducto()+";";
            this.proceso(sql);
            salida = "La información se actualizó correctamente.";
             }else{
                  salida="El id no existe en la base de datos.";
             }
        } catch (SQLException ex) {
            salida = "Error al modificar la información.";
        }
        return salida;
    }

    public String eliminarProductos(Producto producto) {
        salida="";
        try {
            if (verificarID(producto.getIdProducto()) != null) {
                sql = "delete from tb_productos where ID_Producto="+producto.getIdProducto()+";";
                this.proceso(sql);
                salida = "Se borró la información correctamente.";
            }else{
                salida="El id no existe en la base de datos.";
            }

        } catch (SQLException ex) {
            salida = "Error al eliminar la información.";
        }
        return salida;
    }

    public ArrayList<Producto> consultarProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        try {

            sql = "select * from tb_productos";
            resultado = this.consulta(sql);
            while (resultado.next()) {
                listaProductos.add(new Producto(resultado.getInt("id_producto"), resultado.getString("nombre"),resultado.getString("descripcion"),resultado.getString("marca"),resultado.getInt("precio"),resultado.getInt("cantidad")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductos;
    }

    public Producto verificarID(int id) {
        try {
            sql = "select * from tb_productos where id_producto=" + id ;
            resultado = this.consulta(sql);
            while (resultado.next()) {
                return new Producto(resultado.getInt("id_producto"), resultado.getString("nombre"),resultado.getString("descripcion"),resultado.getString("marca"),resultado.getInt("precio"),resultado.getInt("cantidad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getListaProductos(){
        salida="";
        for (Producto producto : this.consultarProductos()) {
            salida+="ID_Producto: "+producto.getIdProducto()+"\tNombre: "+producto.getNombre()+"\n";
        }
        return salida;
    }
}
