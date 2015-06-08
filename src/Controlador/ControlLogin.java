/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import Modelo.RegistroUsuario;
import org.jdom2.JDOMException;
import Vista.BtnsLogin;
import Vista.GUIPrincipal;
import Vista.Login;

/**
 *
 * @author raul
 */
public class ControlLogin implements ActionListener {

    private Login login;
    private BtnsLogin botones;
    private RegistroUsuario registro;

    public ControlLogin(Login login) throws JDOMException, IOException {
        this.login = login;
        
        File archivoXML = new File("usuarios.xml");
        if (archivoXML.exists()) {
            registro = RegistroUsuario.abrirDocumento("usuarios.xml");
        } else {
            registro = RegistroUsuario.crearDocumento("usuarios.xml");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase(botones.BTN_ENTRAR)) {
            if (login.getTxtUsuario().equals("")) {
                login.mensaje("Introduzca usuario");
            } else if (login.getTxtPassword().equals("")) {
                login.mensaje("Introduzca contraseña");
            } else {
                if (registro.verificarLogin(login.getTxtUsuario(),login.getTxtPassword())) {
                    GUIPrincipal guiPrincipal = new GUIPrincipal();
                    guiPrincipal.setVisible(true);
                    login.dispose();
               } else {
                    login.mensaje("usuario o contraseña no existe o es incorrecto");
                }
            }
        }
        if (e.getActionCommand().equalsIgnoreCase(botones.BTN_SALIR)) {
            System.exit(0);
        }
    }

}
