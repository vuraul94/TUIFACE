/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GUIRegistroMemorias;
import Vista.GUIRegistroOtros;
import Vista.GUIRegistroComputadores;
import Vista.GUIRegistroProcesadores;
import Vista.GUIRegistroProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raul
 */
public class ControlRegProductos implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(GUIRegistroProductos.BTN_PROCESADORES)) {
            try {
                GUIRegistroProcesadores procesadores=new GUIRegistroProcesadores();
                procesadores.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ControlRegProductos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControlRegProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equals(GUIRegistroProductos.BTN_MEMORIAS)) {
            GUIRegistroMemorias memorias=new GUIRegistroMemorias();
            memorias.setVisible(true);
        }
        if (e.getActionCommand().equals(GUIRegistroProductos.BTN_COMPUTADORES)) {
            GUIRegistroComputadores computadores=new GUIRegistroComputadores();
            computadores.setVisible(true);
        }
        if (e.getActionCommand().equals(GUIRegistroProductos.BTN_OTROS)) {
            try {
                GUIRegistroOtros otros=new GUIRegistroOtros();
                otros.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ControlRegProductos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControlRegProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
