/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Compra;
import Modelo.RegistroProductos;
import Vista.GUICompra;
import Vista.GUIPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

/**
 *
 * @author Né
 */
public class ControlCompra implements ActionListener {
    
    private RegistroProductos registroProductos;
    private Compra compra;
    private GUICompra guicompra;

    public ControlCompra(GUICompra guicompra) throws SQLException, ClassNotFoundException {
        this.registroProductos = new RegistroProductos();
        this.guicompra= guicompra;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {

    if (e.getActionCommand().equalsIgnoreCase(GUICompra.BTN_REGISTRAR)) {
            
        }
        if (e.getActionCommand().equalsIgnoreCase(GUICompra.BTN_SALIR)) {
            this.guicompra.dispose();
        }
    
    }

  
   
    
}
