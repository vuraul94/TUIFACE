/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Computador;
import Modelo.Memorias;
import Modelo.Procesadores;
import Modelo.Producto;
import Modelo.RegistroProductos;
import Modelo.Validador;
import Vista.GUIRegistroComputadores;
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
    private GUIRegistroComputadores guiComputadores;
    private RegistroProductos regProducto;
    private Validador validador;

    public ControlProducto(GUIRegistroOtros guiOtros) throws SQLException, ClassNotFoundException {
        this.guiOtros = guiOtros;
        this.regProducto = new RegistroProductos();
        this.validador = new Validador();
    }

    public ControlProducto(GUIRegistroProcesadores guiProcesadores) throws SQLException, ClassNotFoundException {
        this.guiProcesadores = guiProcesadores;
        this.regProducto = new RegistroProductos();
        this.validador = new Validador();
    }

    public ControlProducto(GUIRegistroMemorias guiMemorias) throws SQLException, ClassNotFoundException {
        this.guiMemorias = guiMemorias;
        this.regProducto = new RegistroProductos();
        this.validador = new Validador();
    }

    public ControlProducto(GUIRegistroComputadores guiComputadores) throws SQLException, ClassNotFoundException {
        this.guiComputadores = guiComputadores;
        this.regProducto = new RegistroProductos();
        this.validador = new Validador();
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
            if (validador.validarID(guiOtros.getTxtIdProducto())) {
                Producto producto = new Producto(guiOtros.getTxtIdProducto(), guiOtros.getTxtNombre(), guiOtros.getTxtDescripcion(), guiOtros.getTxtMarca(), guiOtros.getTxtPrecio(), guiOtros.getTxtCantidad());
                if (regProducto.incluirProductos(producto)) {
                    GUIRegistroOtros.mensaje("Ok");
                } else {
                    GUIRegistroOtros.mensaje("No");
                }
                guiOtros.limpiar();
            }else{
                guiOtros.mensaje("ID Formato incorrecto");
            }
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
                GUIRegistroProcesadores.mensaje(regProducto.incluirProcesador(procesador));
            }
            guiProcesadores.limpiar();
        }

        if (e.getActionCommand().equals(GUIRegistroProcesadores.BTN_MODIFICAR)) {
            Procesadores procesador = new Procesadores(guiProcesadores.getTxtIdProducto(), guiProcesadores.getTxtNombre(), guiProcesadores.getTxtDescripcion(), guiProcesadores.getTxtMarca(), guiProcesadores.getTxtPrecio(), guiProcesadores.getTxtCantidad(), guiProcesadores.getTxtNucleos(), guiProcesadores.getTxtFrecuencia());
            GUIRegistroProcesadores.mensaje(regProducto.modificarPocesadores(procesador));
            guiProcesadores.limpiar();
        }

        if (e.getActionCommand().equals(GUIRegistroProcesadores.BTN_ELIMINAR)) {
            Procesadores procesador = new Procesadores(guiProcesadores.getTxtIdProducto(), guiProcesadores.getTxtNombre(), guiProcesadores.getTxtDescripcion(), guiProcesadores.getTxtMarca(), guiProcesadores.getTxtPrecio(), guiProcesadores.getTxtCantidad(), guiProcesadores.getTxtNucleos(), guiProcesadores.getTxtFrecuencia());
            GUIRegistroProcesadores.mensaje(regProducto.eliminarProcesador(procesador));
            regProducto.eliminarProductos(procesador);
            guiProcesadores.limpiar();
        }

        if (e.getActionCommand().equals(GUIRegistroMemorias.BTN_BUSCAR)) {
            Memorias memoria = regProducto.verificarIDMemoria(guiMemorias.getTxtIdProducto());
            guiMemorias.setTxtNombre(memoria.getNombre());
            guiMemorias.setTxtMarca(memoria.getMarca());
            guiMemorias.setTxtDescripcion(memoria.getDescripcion());
            guiMemorias.setTxtPrecio(String.valueOf(memoria.getPrecio()));
            guiMemorias.setTxtCantidad(String.valueOf(memoria.getCantidad()));
            guiMemorias.setTxtCapacidad(memoria.getCapacidad());;
        }

        if (e.getActionCommand().equals(GUIRegistroMemorias.BTN_REGISTRAR)) {
            Memorias memoria = new Memorias(guiMemorias.getTxtIdProducto(), guiMemorias.getTxtNombre(), guiMemorias.getTxtDescripcion(), guiMemorias.getTxtMarca(), guiMemorias.getTxtPrecio(), guiMemorias.getTxtCantidad(), guiMemorias.getTxtCapacidad());
            if (regProducto.incluirProductos(memoria)) {
                GUIRegistroMemorias.mensaje(regProducto.incluirMemorias(memoria));
            }
            guiMemorias.limpiar();
        }

        if (e.getActionCommand().equals(GUIRegistroMemorias.BTN_MODIFICAR)) {
            Memorias memoria = new Memorias(guiMemorias.getTxtIdProducto(), guiMemorias.getTxtNombre(), guiMemorias.getTxtDescripcion(), guiMemorias.getTxtMarca(), guiMemorias.getTxtPrecio(), guiMemorias.getTxtCantidad(), guiMemorias.getTxtCapacidad());
            GUIRegistroMemorias.mensaje(regProducto.modificarMemorias(memoria));
            guiMemorias.limpiar();
        }

        if (e.getActionCommand().equals(GUIRegistroMemorias.BTN_ELIMINAR)) {
            Memorias memoria = new Memorias(guiMemorias.getTxtIdProducto(), guiMemorias.getTxtNombre(), guiMemorias.getTxtDescripcion(), guiMemorias.getTxtMarca(), guiMemorias.getTxtPrecio(), guiMemorias.getTxtCantidad(), guiMemorias.getTxtCapacidad());
            GUIRegistroMemorias.mensaje(regProducto.eliminarMemorias(memoria));
            regProducto.eliminarProductos(memoria);
            guiMemorias.limpiar();
        }

        if (e.getActionCommand().equals(GUIRegistroComputadores.BTN_BUSCAR)) {
            Computador computador = regProducto.verificarIDComputador(guiComputadores.getTxtIdProducto());
            guiComputadores.setTxtNombre(computador.getNombre());
            guiComputadores.setTxtMarca(computador.getMarca());
            guiComputadores.setTxtDescripcion(computador.getDescripcion());
            guiComputadores.setTxtPrecio(String.valueOf(computador.getPrecio()));
            guiComputadores.setTxtCantidad(String.valueOf(computador.getCantidad()));
            guiComputadores.setTxtRam(String.valueOf(computador.getRam()));
            guiComputadores.setTxtRom(String.valueOf(computador.getRom()));
            guiComputadores.setTxtProcesador(computador.getProcesador());
        }

        if (e.getActionCommand().equals(GUIRegistroComputadores.BTN_REGISTRAR)) {
            Computador computador = new Computador(guiComputadores.getTxtIdProducto(), guiComputadores.getTxtNombre(), guiComputadores.getTxtDescripcion(), guiComputadores.getTxtMarca(), guiComputadores.getTxtPrecio(), guiComputadores.getTxtCantidad(), guiComputadores.getTxtRom(), guiComputadores.getTxtRam(), guiComputadores.getTxtProcesador());
            if (regProducto.incluirProductos(computador)) {
                GUIRegistroComputadores.mensaje(regProducto.incluirComputadores(computador));
            }
            guiComputadores.limpiar();
        }

        if (e.getActionCommand().equals(GUIRegistroComputadores.BTN_MODIFICAR)) {
            Computador computador = new Computador(guiComputadores.getTxtIdProducto(), guiComputadores.getTxtNombre(), guiComputadores.getTxtDescripcion(), guiComputadores.getTxtMarca(), guiComputadores.getTxtPrecio(), guiComputadores.getTxtCantidad(), guiComputadores.getTxtRom(), guiComputadores.getTxtRam(), guiComputadores.getTxtProcesador());
            GUIRegistroComputadores.mensaje(regProducto.modificarComputadores(computador));
            guiComputadores.limpiar();
        }

        if (e.getActionCommand().equals(GUIRegistroComputadores.BTN_ELIMINAR)) {
            Computador computador = new Computador(guiComputadores.getTxtIdProducto(), guiComputadores.getTxtNombre(), guiComputadores.getTxtDescripcion(), guiComputadores.getTxtMarca(), guiComputadores.getTxtPrecio(), guiComputadores.getTxtCantidad(), guiComputadores.getTxtRom(), guiComputadores.getTxtRam(), guiComputadores.getTxtProcesador());
            GUIRegistroComputadores.mensaje(regProducto.eliminarComputadores(computador));
            regProducto.eliminarProductos(computador);
            guiComputadores.limpiar();
        }
    }
}
