/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Modelo.RegistroProductos;
import Vista.GUIRegistroOtros;
import Vista.GUIRegistroProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Raul
 */
public class ControlProducto implements ActionListener{
    
    private GUIRegistroOtros guiOtros;
    private RegistroProductos regProducto;

    public ControlProducto(GUIRegistroOtros guiOtros) throws SQLException, ClassNotFoundException {
        this.guiOtros = guiOtros;
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
            Producto producto = new Producto(guiOtros.getTxtIdProducto(), guiOtros.getTxtNombre(), guiOtros.getTxtDescripcion(), guiOtros.getTxtMarca(), guiOtros.getTxtPrecio(),guiOtros.getTxtCantidad());
            GUIRegistroOtros.mensaje(regProducto.incluirProductos(producto));
            guiOtros.limpiar();
        }
        if(e.getActionCommand().equals(GUIRegistroOtros.BTN_MODIFICAR)){
            Producto producto = new Producto(guiOtros.getTxtIdProducto(), guiOtros.getTxtNombre(), guiOtros.getTxtDescripcion(), guiOtros.getTxtMarca(), guiOtros.getTxtPrecio(),guiOtros.getTxtCantidad());
            GUIRegistroOtros.mensaje(regProducto.modificarPoductos(producto));
            guiOtros.limpiar();
        }
        if(e.getActionCommand().equals(GUIRegistroOtros.BTN_ELIMINAR)){
            Producto producto = new Producto(guiOtros.getTxtIdProducto(), guiOtros.getTxtNombre(), guiOtros.getTxtDescripcion(), guiOtros.getTxtMarca(), guiOtros.getTxtPrecio(),guiOtros.getTxtCantidad());
            GUIRegistroOtros.mensaje(regProducto.eliminarProductos(producto));
            guiOtros.limpiar();
        }
    }
    }
    

