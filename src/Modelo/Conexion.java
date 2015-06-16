/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Raul
 */
public class Conexion {
    
    private String driver;
    private String baseDatos;
    private String usuario;
    private String password;

    public Conexion() {
        
        this.driver = "com.mysql.jdbc.Driver";
        this.baseDatos = "jdbc:mysql://localhost/TUIFACE";
        this.usuario = "root";
        this.password = "";
        
    }

    public Conexion(String driver, String baseDatos, String usuario, String passwd) {
        this.driver = driver;
        this.baseDatos = baseDatos;
        this.usuario = usuario;
        this.password = passwd;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasswd() {
        return password;
    }

    public void setPasswd(String password) {
        this.password = password;
    }
    
}
