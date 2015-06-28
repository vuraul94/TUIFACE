/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Venta;
import Modelo.RegistroVenta;
import Vista.Reporte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

/**
 *
 * @author Raul
 */
public class ControlReporte implements ActionListener, ItemListener {

    private Reporte reporte;
    private RegistroVenta registro;

    public ControlReporte(Reporte reporte) throws SQLException, ClassNotFoundException {
        this.reporte = reporte;
        this.registro = new RegistroVenta();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(Reporte.BTN_SALIR)){
            this.reporte.dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == ItemEvent.SELECTED) {
            System.out.println(ie);
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Enero")) {
                reporte.setValores(registro.getMatrizVentas(1), Venta.getEtiquetas());
                reporte.setlbTotal(String.valueOf(registro.totalVentas(1)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Febrero")) {
                reporte.setValores(registro.getMatrizVentas(2), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(2)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Marzo")) {
                reporte.setValores(registro.getMatrizVentas(3), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(3)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Abril")) {
                reporte.setValores(registro.getMatrizVentas(4), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(4)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Mayo")) {
                reporte.setValores(registro.getMatrizVentas(5), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(5)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Junio")) {
                reporte.setValores(registro.getMatrizVentas(6), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(6)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Julio")) {
                reporte.setValores(registro.getMatrizVentas(7), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(7)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Agosto")) {
                reporte.setValores(registro.getMatrizVentas(8), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(8)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Septiembre")) {
                reporte.setValores(registro.getMatrizVentas(9), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(9)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Octubre")) {
                reporte.setValores(registro.getMatrizVentas(10), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(10)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Noviembre")) {
                reporte.setValores(registro.getMatrizVentas(11), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(11)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Diciembre")) {
                reporte.setValores(registro.getMatrizVentas(12), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(12)));
            }
        }
    }

}
