/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Modelo.RegistroProductos;
import Vista.Descripcion;
import Vista.Inventario;
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
 * @author raul
 */
public class ControlInventario implements ActionListener, ItemListener, MouseListener {

    private RegistroProductos registroProductos;
    private Inventario inventario;
    private int controlBusca = 0;

    public ControlInventario(Inventario inventario) throws SQLException, ClassNotFoundException {
        this.registroProductos = new RegistroProductos();
        this.inventario = inventario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase(Inventario.BTN_BUSCAR)) {
            if (controlBusca == 1) {
                inventario.setValores(
                        registroProductos.getMatrizBuscar(inventario.getTxtBuscar(), 1),
                        Producto.getEtiquetas());
                //inventario.limpiar();
            }
            if (controlBusca == 2) {
                inventario.setValores(
                        registroProductos.getMatrizBuscar(inventario.getTxtBuscar(), 2),
                        Producto.getEtiquetas());
                //inventario.limpiar();
            }
            if (controlBusca == 3) {
                inventario.setValores(
                        registroProductos.getMatrizBuscar(inventario.getTxtBuscar(), 3),
                        Producto.getEtiquetas());
                //inventario.limpiar();
            }
            if (controlBusca == 4) {
                inventario.setValores(
                        registroProductos.getMatrizBuscar(inventario.getTxtBuscar(), 4),
                        Producto.getEtiquetas());
                //inventario.limpiar();
            }
            if (controlBusca == 5) {
                inventario.setValores(
                        registroProductos.getMatrizBuscar(inventario.getTxtBuscar(), 5),
                        Producto.getEtiquetas());
                //inventario.limpiar();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == ItemEvent.SELECTED) {
            System.err.println(ie.getItem().toString());

            if (ie.getItem().toString().equalsIgnoreCase("All")) {
//                Agregar.mensaje("All");
                inventario.enableCampoBuscar(false);

                inventario.setValores(registroProductos.getMatrizProductos(), Producto.getEtiquetas());
            }
            if (this.inventario.getCboxCategoria().equalsIgnoreCase("ID")) {
                inventario.setLbCategoria("ID:");
                inventario.enableCampoBuscar(true);
                controlBusca = 1;

            }
            if (this.inventario.getCboxCategoria().equalsIgnoreCase("Nombre")) {
                inventario.setLbCategoria("Nombre:");
                inventario.enableCampoBuscar(true);
                controlBusca = 2;
            }
            if (this.inventario.getCboxCategoria().equalsIgnoreCase("Marca")) {
                inventario.setLbCategoria("Marca:");
                inventario.enableCampoBuscar(true);
                controlBusca = 3;
            }
            if (this.inventario.getCboxCategoria().equalsIgnoreCase("Precio")) {
                inventario.setLbCategoria("Precio:");
                inventario.enableCampoBuscar(true);
                controlBusca = 4;
            }
            if (this.inventario.getCboxCategoria().equalsIgnoreCase("Cantidad")) {
                inventario.setLbCategoria("Cantidad:");
                inventario.enableCampoBuscar(true);
                controlBusca = 5;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        try {
        int ID = inventario.getIdSelected();
        System.out.println(ID);
        String descripcion= registroProductos.verificarID(ID).getDescripcion();
        Descripcion guiDescripcion= new Descripcion((inventario), true);
        guiDescripcion.setLbDescripcion(descripcion);
        guiDescripcion.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
