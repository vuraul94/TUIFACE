/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Né
 */
public class Validador {

    private static Pattern patron;
    private static Matcher match;

    public static boolean validarID(String ID) {
        patron = Pattern.compile("\\d{4}");
        match = patron.matcher(String.valueOf(ID));
        if (match.find()) {
            return true;
        }
        return false;
    }

    public static boolean validarCorreo(String correo) {
        String patronV = "";
        patronV = "^[\\w-]+(\\.[w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z0-9]{2,})$";
        patron = Pattern.compile(patronV);
        match = patron.matcher(correo);
        if (match.find()) {
            return true;
        }
        return false;
    }

    public static boolean validarTelefono(String telefono) {
        patron = Pattern.compile("^\\+\\d{1,3}-\\d{4}-\\d{2}-\\d{2}$");
        match = patron.matcher(telefono);
        if (match.find()) {
            return true;
        }
        return false;
    }

    public static boolean validarNumeros(String num) {
        patron = Pattern.compile("^[0-9]+$");
        match = patron.matcher(num);
        if (match.find()) {
            return true;
        }
        return false;
    }
    

    public static boolean validarDireccion(String direccion) {
        String patronV = "(^[0-9+-,|°¬!#$%&/()=¡*¨_:;~^@]{2,100})$";
        patron = Pattern.compile(patronV);
        match = patron.matcher(direccion);
        if (match.find()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarNombre(String nombre) {
        String patronV = "(^[0-9+-,|°¬!#$%&/()=¡*¨_:;~^@]{2,100})$";
        patron = Pattern.compile(patronV);
        match = patron.matcher(nombre);
        if (match.find()) {
            return false;
        } else {
            return true;
        }
    }

}
