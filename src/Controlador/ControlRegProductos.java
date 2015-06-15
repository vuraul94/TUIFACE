/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.RegistroMemorias;
import Vista.RegistroOtros;
import Vista.RegistroComputadores;
import Vista.RegistroProcesadores;
import Vista.RegistroProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Raul
 */
public class ControlRegProductos implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(RegistroProductos.BTN_PROCESADORES)) {
            RegistroProcesadores procesadores=new RegistroProcesadores();
            procesadores.setVisible(true);
        }
        if (e.getActionCommand().equals(RegistroProductos.BTN_MEMORIAS)) {
            RegistroMemorias memorias=new RegistroMemorias();
            memorias.setVisible(true);
        }
        if (e.getActionCommand().equals(RegistroProductos.BTN_COMPUTADORES)) {
            RegistroComputadores computadores=new RegistroComputadores();
            computadores.setVisible(true);
        }
        if (e.getActionCommand().equals(RegistroProductos.BTN_OTROS)) {
            RegistroOtros otros=new RegistroOtros();
            otros.setVisible(true);
        }
    }
    
    
}
