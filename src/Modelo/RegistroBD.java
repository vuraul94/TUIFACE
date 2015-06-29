/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Raul
 */
public class RegistroBD {

    Conexion conexion;
    ResultSet resultado;
    Statement estado;
    Connection cone;

    public RegistroBD() throws SQLException, ClassNotFoundException {
        conexion = new Conexion();
        conexion();
    }

    public void conexion() throws ClassNotFoundException, SQLException {
        Class.forName(conexion.getDriver());
        cone = DriverManager.getConnection(conexion.getBaseDatos(), conexion.getUsuario(), conexion.getPasswd());
        System.err.println("Conexion realizada correctamente");
    }

    // metodo para realizar consultas a la base de datos
    public ResultSet consulta(String consultaSQL) throws SQLException {
        estado = cone.createStatement();
        resultado = estado.executeQuery(consultaSQL);
        return resultado;
    }

    // metodo para realizar modificaciones a la base de datos.
    public void proceso(String procedimientoSQL) throws SQLException {
        estado = cone.createStatement();
        estado.executeUpdate(procedimientoSQL);
        System.err.println("Proceso realizado correctamente.");
    }

    public void cerrarConexion() throws SQLException {
        estado.close();
        cone.close();
    }

    public void crearBase() throws SQLException {
        String sql;
        sql = "create database if not exists TUIFACE;";
        proceso(sql);
        sql = "create table if not exists tb_proveedor(ID_Proveedor varchar(4), Nombre varchar(100),Direccion varchar(200),Correo varchar(100),telefono varchar(15), primary key (ID_Proveedor));";
        proceso(sql);
        sql = "create table if not exists tb_productos(ID_Producto varchar(4), Nombre varchar(100),Marca varchar(100),Precio double,Cantidad int,descripcion varchar(500), primary key (ID_Producto));";
        proceso(sql);
        sql = "create table if not exists tb_memorias(ID_Producto varchar(4), capacidad varchar(10), primary key (ID_Producto));";
        proceso(sql);
        sql = "create table if not exists tb_procesadores(ID_Producto varchar(4), nucleos int, frecuencia int, primary key (ID_Producto));";
        proceso(sql);
        sql = "create table if not exists tb_computadores(ID_Producto varchar(4),rom varchar(10),ram varchar(10),procesador varchar(10), primary key (ID_Producto));";
        proceso(sql);
        sql = "alter table tb_memorias add Foreign key (ID_Producto) references tb_productos(ID_Producto);";
        proceso(sql);
        sql = "alter table tb_procesadores add Foreign key (ID_Producto) references tb_productos(ID_Producto);";
        proceso(sql);
        sql = "alter table tb_computadores add Foreign key (ID_Producto) references tb_productos(ID_Producto);";
        proceso(sql);
        sql = "create table if not exists tb_venta(ID_Venta int auto_increment,fecha date,total decimal, primary key(ID_Venta));";
        proceso(sql);
        sql = "create table if not exists tb_factura(ID_Venta int,fila int auto_increment,ID_Producto int,cantidad int, monto double, primary key(fila,ID_Venta));";
        proceso(sql);
        sql = "alter table tb_factura add Foreign key (ID_Venta) references tb_venta(ID_Venta);";
        proceso(sql);
    }
}
