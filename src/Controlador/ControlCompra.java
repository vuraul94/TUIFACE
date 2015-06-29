/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Compra;
import Modelo.Producto;
import Modelo.RegistroCompra;
import Modelo.Validador;
import Vista.GUICompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private Validador validador;

    public ControlCompra(GUICompra guiCompra) throws SQLException, ClassNotFoundException {
        this.registroCompra = new RegistroCompra();
        this.validador = new Validador();
        this.guiCompra = guiCompra;
        this.producto = producto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equalsIgnoreCase(GUICompra.BTN_REGISTRAR)) {
            if (validador.validarID(guiCompra.getTxtIdProducto())) {
                if (validador.validarNumeros(guiCompra.getTxtCantidad())) {
                    if (validador.validarNumeros(guiCompra.getTxtPrecio())) {
                        try {
                            System.out.println(guiCompra.getCboxProveedorSelected());
                            registroCompra.agregarCompra(guiCompra.getTxtIdProducto(), Integer.parseInt(guiCompra.getTxtCantidad()), Double.parseDouble(guiCompra.getTxtPrecio()), guiCompra.getCboxProveedorSelected());
                        } catch (SQLException ex) {
                            Logger.getLogger(ControlCompra.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        guiCompra.limpiar();
                    }else guiCompra.mensaje("Precio formato incorrecto");
                }else guiCompra.mensaje("Cantidad formato incorrecto");
            }else guiCompra.mensaje("ID formato incorrecto");
        }
        
        if (e.getActionCommand().equalsIgnoreCase(GUICompra.BTN_SALIR)) {
            this.guiCompra.dispose();
        }

    }

}
