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
    private ResultSet resultado2;
    private String sql2;

    public RegistroProductos() throws SQLException, ClassNotFoundException {
        super();
    }

    //***************************************************Otros
    public boolean incluirProductos(Producto producto) {
        try {
            if (verificarID(producto.getIdProducto()) == null) {
                sql = "insert into tb_productos values("
                        + producto.getIdProducto()
                        + ",'" + producto.getNombre()
                        + "','" + producto.getMarca()
                        + "','" + producto.getPrecio()
                        + "','" + producto.getCantidad()
                        + "','" + producto.getDescripcion()
                        + "');";
                this.proceso(sql);
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    public String modificarPoductos(Producto producto) {
        salida = "";
        try {
            if (verificarID(producto.getIdProducto()) != null) {
                sql = "update tb_productos set nombre='" + producto.getNombre()
                        + "', marca='" + producto.getMarca()
                        + "', precio='" + producto.getPrecio()
                        + "',cantidad='" + producto.getCantidad()
                        + "',descripcion='" + producto.getDescripcion()
                        + "' where id_producto not in (select id_producto from tb_procesadores) and id_producto=" + producto.getIdProducto() + ";";
                this.proceso(sql);
                salida = "La información se actualizó correctamente.";
            } else {
                salida = "El id no existe en la base de datos.";
            }
        } catch (SQLException ex) {
            salida = "Error al modificar la información.";
        }
        return salida;
    }

    public String eliminarProductos(Producto producto) {
        salida = "";
        try {
            if (verificarID(producto.getIdProducto()) != null) {
                sql = "delete from tb_productos where id_producto not in (select id_producto from tb_procesadores) and ID_Producto=" + producto.getIdProducto() + ";";
                this.proceso(sql);
                salida = "Se borró la información correctamente.";
            } else {
                salida = "El id no existe en la base de datos.";
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
                listaProductos.add(new Producto(resultado.getInt("id_producto"), resultado.getString("nombre"), resultado.getString("descripcion"), resultado.getString("marca"), resultado.getInt("precio"), resultado.getInt("cantidad")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductos;
    }

    public Producto verificarID(int id) {
        try {
            sql = "select * from tb_productos where id_producto not in (select id_producto from tb_procesadores) and id_producto=" + id;
            resultado = this.consulta(sql);
            while (resultado.next()) {
                return new Producto(resultado.getInt("id_producto"), resultado.getString("nombre"), resultado.getString("descripcion"), resultado.getString("marca"), resultado.getInt("precio"), resultado.getInt("cantidad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getListaProductos() {
        salida = "";
        for (Producto producto : this.consultarProductos()) {
            salida += "ID_Producto: " + producto.getIdProducto() + "\tNombre: " + producto.getNombre() + "\n";
        }
        return salida;
    }

    //***************************************************Procesadores
    public String incluirProcesador(Procesadores procesador) {
        salida = "";
        try {
            if (verificarIDProcesador(procesador.getIdProducto()) == null) {
                sql = "insert into tb_procesadores values("
                        + procesador.getIdProducto()
                        + ",'" + procesador.getNucleos()
                        + "','" + procesador.getFrecuencia()
                        + "');";
                this.proceso(sql);
                salida = "La información se agregó correctamente.";
            } else {
                salida = "El producto ya se encuentra registrado.";
            }
        } catch (SQLException ex) {
            salida = "Error al incluir la información.";
        }
        return salida;
    }

    public String modificarPocesadores(Procesadores procesador) {
        salida = "";
        try {
            if (verificarIDProcesador(procesador.getIdProducto()) != null) {
                sql = "update tb_procesadores set nucleos='" + procesador.getNucleos()
                        + "', frecuencia='" + procesador.getFrecuencia() 
                        +"' where id_producto=" + procesador.getIdProducto() + ";";
                this.proceso(sql);
                sql2 = "update tb_productos set nombre='" + procesador.getNombre()
                        + "', marca='" + procesador.getMarca()
                        + "', precio='" + procesador.getPrecio()
                        + "',cantidad='" + procesador.getCantidad()
                        + "',descripcion='" + procesador.getDescripcion()
                        + "' where id_producto=" + procesador.getIdProducto() + ";";
                this.proceso(sql2);
                
                salida = "La información se actualizó correctamente.";
            } else {
                salida = "El id no existe en la base de datos.";
            }
        } catch (SQLException ex) {
            salida = "Error al modificar la información.";
        }
        return salida;
    }

    public String eliminarProcesador(Procesadores procesador) {
        salida = "";
        try {
            if (verificarID(procesador.getIdProducto()) != null) {
                sql = "delete from tb_procesadores where ID_Producto=" + procesador.getIdProducto() + ";";
                this.proceso(sql);
                salida = "Se borró la información correctamente.";
            } else {
                salida = "El id no existe en la base de datos.";
            }

        } catch (SQLException ex) {
            salida = "Error al eliminar la información.";
        }
        return salida;
    }

    public Procesadores verificarIDProcesador(int id) {
        try {
            sql = "select * from tb_productos Pd,tb_procesadores Pr where Pr.ID_Producto in (select ID_Producto from tb_procesadores)"
                    + "and Pd.ID_Producto= Pr.ID_Producto and Pd.id_producto=" + id;
            resultado = this.consulta(sql);
            while (resultado.next()) {
                return new Procesadores(resultado.getInt("id_producto"), resultado.getString("nombre"), resultado.getString("descripcion"), resultado.getString("marca"), resultado.getInt("precio"), resultado.getInt("cantidad"), resultado.getInt("nucleos"), resultado.getInt("frecuencia"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //***************************************************Memorias
    public String incluirMemorias(Memorias memoria) {
        salida = "";
        try {
            if (verificarIDMemoria(memoria.getIdProducto()) == null) {
                sql = "insert into tb_memorias values("
                        + memoria.getIdProducto()
                        + ",'" + memoria.getCapacidad()
                        + "');";
                this.proceso(sql);
                salida = "La información se agregó correctamente.";
            } else {
                salida = "El producto ya se encuentra registrado.";
            }
        } catch (SQLException ex) {
            salida = "Error al incluir la información.";
        }
        return salida;
    }

    public String modificarMemorias(Memorias memoria) {
        salida = "";
        try {
            if (verificarIDMemoria(memoria.getIdProducto()) != null) {
                sql = "update tb_memorias set capacidad='" + memoria.getCapacidad() 
                        +"' where id_producto=" + memoria.getIdProducto() + ";";
                this.proceso(sql);
                sql2 = "update tb_productos set nombre='" + memoria.getNombre()
                        + "', marca='" + memoria.getMarca()
                        + "', precio='" + memoria.getPrecio()
                        + "',cantidad='" + memoria.getCantidad()
                        + "',descripcion='" + memoria.getDescripcion()
                        + "' where id_producto=" + memoria.getIdProducto() + ";";
                this.proceso(sql2);
                
                salida = "La información se actualizó correctamente.";
            } else {
                salida = "El id no existe en la base de datos.";
            }
        } catch (SQLException ex) {
            salida = "Error al modificar la información.";
        }
        return salida;
    }

    public String eliminarMemorias(Memorias memoria) {
        salida = "";
        try {
            if (verificarID(memoria.getIdProducto()) != null) {
                sql = "delete from tb_memorias where ID_Producto=" + memoria.getIdProducto() + ";";
                this.proceso(sql);
                salida = "Se borró la información correctamente.";
            } else {
                salida = "El id no existe en la base de datos.";
            }

        } catch (SQLException ex) {
            salida = "Error al eliminar la información.";
        }
        return salida;
    }

    public Memorias verificarIDMemoria(int id) {
        try {
            sql = "select * from tb_productos Pd,tb_memorias M where M.ID_Producto in (select ID_Producto from tb_memorias)"
                    + "and Pd.ID_Producto= M.ID_Producto and M.id_producto=" + id;
            resultado = this.consulta(sql);
            while (resultado.next()) {
                return new Memorias(resultado.getInt("id_producto"), resultado.getString("nombre"), resultado.getString("descripcion"), resultado.getString("marca"), resultado.getInt("precio"), resultado.getInt("cantidad"), resultado.getString("capacidad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
