/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroVenta;
import Modelo.Venta;
import Vista.GUIVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raul
 */
public class ControlVenta implements ActionListener {

    GUIVenta guiVenta;
    RegistroVenta registro;

    public ControlVenta(GUIVenta guiVenta) throws SQLException, ClassNotFoundException {
        this.guiVenta = guiVenta;
        this.registro = new RegistroVenta();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(GUIVenta.BTN_NUEVA_VENTA)) {
            try {
                this.guiVenta.enableTodo();
                registro.crearNuevaVenta();
                this.guiVenta.setlbMontoFinal(String.valueOf(registro.getTotal()));
            } catch (SQLException ex) {
                Logger.getLogger(ControlVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equals(GUIVenta.BTN_AGREGAR)) {
            try {
                registro.incluirProducto(guiVenta.getTxtIDProducto(), guiVenta.getTxtCantidad());
                guiVenta.setlbMontoFinal(String.valueOf(registro.getTotal()));
                guiVenta.setValores(registro.getMatrizFactura(), Venta.getEtiquetasFactura());
                guiVenta.limpiar();
            } catch (SQLException ex) {
                Logger.getLogger(ControlVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equals(GUIVenta.BTN_FACTURAR)) {
            try {
                String[][] matrizVacia = new String[0][0];
                guiVenta.setValores(matrizVacia, Venta.getEtiquetasFactura());
                guiVenta.disableTodo();
                guiVenta.mensaje("Debe pagar un total de:\n " + registro.getTotal() + " colones");
            } catch (SQLException ex) {
                Logger.getLogger(ControlVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equals(GUIVenta.BTN_CANCELAR)) {
            try {
                String[][] matrizVacia = new String[0][0];
                guiVenta.setValores(matrizVacia, Venta.getEtiquetasFactura());
                guiVenta.disableTodo();
                registro.cancelarVenta();
            } catch (SQLException ex) {
                Logger.getLogger(ControlVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
