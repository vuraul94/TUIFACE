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
 * @author raul
 */
public class Validador {
    private static Pattern patron;
    private static Matcher match;
    
    public static boolean validarID(int ID){
        patron=Pattern.compile("\\d\\d\\d\\d");
        match=patron.matcher(String.valueOf(ID));
        if(match.find()){
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
    
    public static boolean validarTelefono(String telefono){
        patron=Pattern.compile("^\\+\\d{1,3}-\\d{4}-\\d{4}$");
        match=patron.matcher(telefono);
        if(match.find()){
            return true;
        }
        return false;
    }
    
    public static boolean validarEdad(String edad){
        patron=Pattern.compile("Wd{1,3}$");
        match=patron.matcher(edad);
        if(match.find()){
            return true;
        }
        return false;
    }
}