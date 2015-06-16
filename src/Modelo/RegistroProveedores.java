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
public class RegistroProveedores extends RegistroBD {

    String salida = "";
    private ResultSet resultado;
    private String sql;
    
    public RegistroProveedores() throws SQLException, ClassNotFoundException {
        super();
    }
    
    public String incluirProveedores(Proveedores proveedor) {
        salida="";
        try {
             if (verificarID(proveedor.getIdProveedor()) == null) {
            sql = "insert into tb_proveedor values("
                    +proveedor.getIdProveedor()
                    +",'"+proveedor.getNombre()
                    +"','"+proveedor.getDireccion()
                    +"','"+proveedor.getCorreo()
                    +"','"+proveedor.getTelefono()+"');";
            this.proceso(sql);
            salida = "La información se agregó correctamente.";
             }else{
                 salida="La proveedor ya se encuentra registrada.";
             }         
        } catch (SQLException ex) {
            salida = "Error al incluir la información.";
        }
        return salida;
    }

    public String modificarPoveedores(Proveedores proveedor) {
        salida="";
        try {
             if (verificarID(proveedor.getIdProveedor()) != null) {
            sql = "update tb_proveedor set nombre='"+proveedor.getNombre()
                    +"', direccion='"+proveedor.getDireccion()
                    +"',correo='"+proveedor.getCorreo()
                    +"',telefono='"+proveedor.getTelefono()
                    +"' where id="+proveedor.getIdProveedor()+";";
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

    public String eliminarProveedores(Proveedores proveedor) {
        salida="";
        try {
            if (verificarID(proveedor.getIdProveedor()) != null) {
                sql = "delete from tb_proveedor where ID="+proveedor.getIdProveedor()+";";
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

    public ArrayList<Proveedores> consultarProveedores() {
        ArrayList<Proveedores> listaProveedores = new ArrayList<Proveedores>();
        try {

            sql = "select * from tb_proveedor";
            resultado = this.consulta(sql);
            while (resultado.next()) {
                listaProveedores.add(new Proveedores(resultado.getInt("id"), resultado.getString("nombre"),resultado.getString("direccion"),resultado.getString("correo"),resultado.getString("telefono")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProveedores;
    }

    public Proveedores verificarID(int id) {
        try {
            sql = "select * from tb_proveedor where id=" + id ;
            resultado = this.consulta(sql);
            while (resultado.next()) {
                return new Proveedores(resultado.getInt("id"), resultado.getString("nombre"),resultado.getString("direccion"),resultado.getString("correo"),resultado.getString("telefono"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getListaProveedores(){
        salida="";
        for (Proveedores proveedor : this.consultarProveedores()) {
            salida+="ID: "+proveedor.getIdProveedor()+"\tNombre: "+proveedor.getNombre()+"\n";
        }
        return salida;
    }

}
