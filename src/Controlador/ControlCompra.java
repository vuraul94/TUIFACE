/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Compra;
import Modelo.Producto;
import Modelo.RegistroCompra;
import Modelo.RegistroProductos;
import Modelo.Venta;
import Vista.GUICompra;
import Vista.GUIPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Né
 */
public class ControlCompra implements ActionListener {
    
    private RegistroCompra registroCompra;
    private Compra compra;
    private GUICompra guiCompra;
    private Producto producto;

    public ControlCompra(GUICompra guiCompra) throws SQLException, ClassNotFoundException {
        this.registroCompra= new RegistroCompra();
        this.guiCompra= guiCompra;
        this.producto= producto;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {

    if (e.getActionCommand().equalsIgnoreCase(GUICompra.BTN_REGISTRAR)) {
        try {
            registroCompra.agregarCompra(guiCompra.getTxtIdProducto(),guiCompra.getTxtCantidad(),guiCompra.getTxtPrecio());
        } catch (SQLException ex) {
            Logger.getLogger(ControlCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
                    guiCompra.limpiar();
                  

    }
        if (e.getActionCommand().equalsIgnoreCase(GUICompra.BTN_SALIR)) {
            this.guiCompra.dispose();
        }
    
    }
    
}

