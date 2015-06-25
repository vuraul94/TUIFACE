/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Compra;
import Vista.GUIPrincipal;
import Vista.Inventario;
import Vista.GUIRegistroProductos;
import Vista.GUIRegistroProveedores;
import Vista.Reporte;
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
public class ControlGUIPrincipal implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(GUIPrincipal.MNI_SALIR)) {
            System.exit(0);
        }
        if (e.getActionCommand().equals(GUIPrincipal.MNI_REG_PROVEEDORES)) {
            try {
                GUIRegistroProveedores regProveedores = new GUIRegistroProveedores();
                regProveedores.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ControlGUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControlGUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equals(GUIPrincipal.MNI_REG_PRODUCTO)) {
            GUIRegistroProductos regProductos = new GUIRegistroProductos();
            regProductos.setVisible(true);
        }
        if (e.getActionCommand().equals(GUIPrincipal.MNI_REPORTE)) {
            Reporte reporte = new Reporte();
            reporte.setVisible(true);
        }
        if (e.getActionCommand().equals(GUIPrincipal.MNI_COMPRA)
                || e.getActionCommand().equals(GUIPrincipal.BTN_COMPRA)) {
            Compra compra = new Compra();
            compra.setVisible(true);
        }  
        if (e.getActionCommand().equals(GUIPrincipal.MNI_VENTA)
                || e.getActionCommand().equals(GUIPrincipal.BTN_VENTA)) {
            try {
                GUIVenta venta = new GUIVenta();
                venta.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ControlGUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControlGUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equals(GUIPrincipal.MNI_INVENTARIO)
                || e.getActionCommand().equals(GUIPrincipal.BTN_INVENTARIO)) {
            try {
                Inventario inventario = new Inventario();
                inventario.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ControlGUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControlGUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
