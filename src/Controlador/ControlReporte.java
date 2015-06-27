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
            int year= Integer.parseInt(this.reporte.getCboxYear());
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Enero")) {
                reporte.setValores(registro.getMatrizVentas(1,year), Venta.getEtiquetas());
                reporte.setlbTotal(String.valueOf(registro.totalVentas(1,year)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Febrero")) {
                reporte.setValores(registro.getMatrizVentas(2,year), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(2,year)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Marzo")) {
                reporte.setValores(registro.getMatrizVentas(3,year), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(3,year)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Abril")) {
                reporte.setValores(registro.getMatrizVentas(4,year), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(4,year)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Mayo")) {
                reporte.setValores(registro.getMatrizVentas(5,year), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(5,year)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Junio")) {
                reporte.setValores(registro.getMatrizVentas(6,year), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(6,year)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Julio")) {
                reporte.setValores(registro.getMatrizVentas(7,year), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(7,year)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Agosto")) {
                reporte.setValores(registro.getMatrizVentas(8,year), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(8,year)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Septiembre")) {
                reporte.setValores(registro.getMatrizVentas(9,year), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(9,year)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Octubre")) {
                reporte.setValores(registro.getMatrizVentas(10,year), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(10,year)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Noviembre")) {
                reporte.setValores(registro.getMatrizVentas(11,year), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(11,year)));
            }
            if (this.reporte.getCboxCategoria().equalsIgnoreCase("Diciembre")) {
                reporte.setValores(registro.getMatrizVentas(12,year), Venta.getEtiquetas());
                 reporte.setlbTotal(String.valueOf(registro.totalVentas(12,year)));
            }
        }
    }

}
