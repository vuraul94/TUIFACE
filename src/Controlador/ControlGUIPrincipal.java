/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Compra;
import Vista.GUIPrincipal;
import Vista.Inventario;
import Vista.RegistroProductos;
import Vista.RegistroProveedores;
import Vista.Reporte;
import Vista.Venta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            RegistroProveedores regProveedores = new RegistroProveedores();
            regProveedores.setVisible(true);
        }
        if (e.getActionCommand().equals(GUIPrincipal.MNI_REG_PRODUCTO)) {
            RegistroProductos regProductos = new RegistroProductos();
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
            Venta venta = new Venta();
            venta.setVisible(true);
        }
        if (e.getActionCommand().equals(GUIPrincipal.MNI_INVENTARIO)
                || e.getActionCommand().equals(GUIPrincipal.BTN_INVENTARIO)) {
            Inventario inventario = new Inventario();
            inventario.setVisible(true);
        }
    }

}
