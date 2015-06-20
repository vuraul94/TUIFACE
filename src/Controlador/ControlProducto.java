/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Procesadores;
import Modelo.Producto;
import Modelo.RegistroProductos;
import Vista.GUIRegistroMemorias;
import Vista.GUIRegistroOtros;
import Vista.GUIRegistroProcesadores;
import Vista.GUIRegistroProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Raul
 */
public class ControlProducto implements ActionListener {

    private GUIRegistroOtros guiOtros;
    private GUIRegistroProcesadores guiProcesadores;
    private GUIRegistroMemorias guiMemorias;
    private RegistroProductos regProducto;

    public ControlProducto(GUIRegistroOtros guiOtros) throws SQLException, ClassNotFoundException {
        this.guiOtros = guiOtros;
        this.regProducto = new RegistroProductos();
    }

    public ControlProducto(GUIRegistroProcesadores guiProcesadores) throws SQLException, ClassNotFoundException {
        this.guiProcesadores = guiProcesadores;
        this.regProducto = new RegistroProductos();
    }

    public ControlProducto(GUIRegistroMemorias guiMemorias) throws SQLException, ClassNotFoundException {
        this.guiMemorias = guiMemorias;
        this.regProducto = new RegistroProductos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(GUIRegistroOtros.BTN_BUSCAR)) {
            Producto producto = regProducto.verificarID(guiOtros.getTxtIdProducto());
            guiOtros.setTxtNombre(producto.getNombre());
            guiOtros.setTxtMarca(producto.getMarca());
            guiOtros.setTxtDescripcion(producto.getDescripcion());
            guiOtros.setTxtPrecio(String.valueOf(producto.getPrecio()));
            guiOtros.setTxtCantidad(String.valueOf(producto.getCantidad()));
        }
        if (e.getActionCommand().equals(GUIRegistroOtros.BTN_REGISTRAR)) {
            Producto producto = new Producto(guiOtros.getTxtIdProducto(), guiOtros.getTxtNombre(), guiOtros.getTxtDescripcion(), guiOtros.getTxtMarca(), guiOtros.getTxtPrecio(), guiOtros.getTxtCantidad());
            if(regProducto.incluirProductos(producto)){
                GUIRegistroOtros.mensaje("Ok");
            }else{
                GUIRegistroOtros.mensaje("No");
            }
            guiOtros.limpiar();
        }
        if (e.getActionCommand().equals(GUIRegistroOtros.BTN_MODIFICAR)) {
            Producto producto = new Producto(guiOtros.getTxtIdProducto(), guiOtros.getTxtNombre(), guiOtros.getTxtDescripcion(), guiOtros.getTxtMarca(), guiOtros.getTxtPrecio(), guiOtros.getTxtCantidad());
            GUIRegistroOtros.mensaje(regProducto.modificarPoductos(producto));
            guiOtros.limpiar();
        }
        if (e.getActionCommand().equals(GUIRegistroOtros.BTN_ELIMINAR)) {
            Producto producto = new Producto(guiOtros.getTxtIdProducto(), guiOtros.getTxtNombre(), guiOtros.getTxtDescripcion(), guiOtros.getTxtMarca(), guiOtros.getTxtPrecio(), guiOtros.getTxtCantidad());
            GUIRegistroOtros.mensaje(regProducto.eliminarProductos(producto));
            guiOtros.limpiar();
        }

        if (e.getActionCommand().equals(GUIRegistroProcesadores.BTN_BUSCAR)) {
            Procesadores procesador = regProducto.verificarIDProcesador(guiProcesadores.getTxtIdProducto());
            System.out.println(procesador.getFrecuencia());
            guiProcesadores.setTxtNombre(procesador.getNombre());
            guiProcesadores.setTxtMarca(procesador.getMarca());
            guiProcesadores.setTxtDescripcion(procesador.getDescripcion());
            guiProcesadores.setTxtPrecio(String.valueOf(procesador.getPrecio()));
            guiProcesadores.setTxtCantidad(String.valueOf(procesador.getCantidad()));
            guiProcesadores.setTxtNucleos(String.valueOf(procesador.getNucleos()));
            guiProcesadores.setTxtFrecuencia(String.valueOf(procesador.getFrecuencia()));
        }

        if (e.getActionCommand().equals(GUIRegistroProcesadores.BTN_REGISTRAR)) {
            Procesadores procesador = new Procesadores(guiProcesadores.getTxtIdProducto(), guiProcesadores.getTxtNombre(), guiProcesadores.getTxtDescripcion(), guiProcesadores.getTxtMarca(), guiProcesadores.getTxtPrecio(), guiProcesadores.getTxtCantidad(), guiProcesadores.getTxtNucleos(), guiProcesadores.getTxtFrecuencia());
            if (regProducto.incluirProductos(procesador)) {
                GUIRegistroOtros.mensaje(regProducto.incluirProcesador(procesador));
            }
            guiProcesadores.limpiar();
        }
        
        if (e.getActionCommand().equals(GUIRegistroProcesadores.BTN_MODIFICAR)) {
            Procesadores procesador = new Procesadores(guiProcesadores.getTxtIdProducto(), guiProcesadores.getTxtNombre(), guiProcesadores.getTxtDescripcion(), guiProcesadores.getTxtMarca(), guiProcesadores.getTxtPrecio(), guiProcesadores.getTxtCantidad(),guiProcesadores.getTxtNucleos(),guiProcesadores.getTxtFrecuencia());
            GUIRegistroProcesadores.mensaje(regProducto.modificarPocesadores(procesador));
            guiProcesadores.limpiar();
        }
        
        if (e.getActionCommand().equals(GUIRegistroProcesadores.BTN_ELIMINAR)) {
            Procesadores procesador = new Procesadores(guiProcesadores.getTxtIdProducto(), guiProcesadores.getTxtNombre(), guiProcesadores.getTxtDescripcion(), guiProcesadores.getTxtMarca(), guiProcesadores.getTxtPrecio(), guiProcesadores.getTxtCantidad(),guiProcesadores.getTxtNucleos(),guiProcesadores.getTxtFrecuencia());
            GUIRegistroOtros.mensaje(regProducto.eliminarProcesador(procesador));
            regProducto.eliminarProductos(procesador);
            guiProcesadores.limpiar();
        }
    }
}
