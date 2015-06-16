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
}
