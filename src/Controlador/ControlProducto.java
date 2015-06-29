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
            if (producto != null) {
                if (validador.validarID(guiOtros.getTxtIdProducto())) {
                    guiOtros.setTxtNombre(producto.getNombre());
                    guiOtros.setTxtMarca(producto.getMarca());
                    guiOtros.setTxtDescripcion(producto.getDescripcion());
                    guiOtros.setTxtPrecio(String.valueOf(producto.getPrecio()));
                    guiOtros.setTxtCantidad(String.valueOf(producto.getCantidad()));
                } else GUIRegistroOtros.mensaje("ID Formato Incorrecto");
            } else GUIRegistroOtros.mensaje("El producto no se encuentra registrado");
        }

        if (e.getActionCommand().equals(GUIRegistroOtros.BTN_REGISTRAR)) {
            if (validador.validarID(guiOtros.getTxtIdProducto())) {
                if (validador.validarNombre(guiOtros.getTxtNombre())) {
                    if (validador.validarNombre(guiOtros.getTxtMarca())) {
                        if (validador.validarNumeros(String.valueOf(guiOtros.getTxtPrecio()))) {
                            if (validador.validarNumeros(String.valueOf(guiOtros.getTxtCantidad()))) {
                                Producto producto = new Producto(guiOtros.getTxtIdProducto(), guiOtros.getTxtNombre(), guiOtros.getTxtDescripcion(), guiOtros.getTxtMarca(), Integer.parseInt(guiOtros.getTxtPrecio()), Integer.parseInt(guiOtros.getTxtCantidad()));
                                if (regProducto.incluirProductos(producto)) {
                                    GUIRegistroOtros.mensaje("Registro exitoso");
                                    guiOtros.limpiar();
                                } else {
                                    GUIRegistroOtros.mensaje("Ese producto ya fue registrado");
                                } 
                            } else guiOtros.mensaje("Cantidad Formato incorrecto");
                        } else guiOtros.mensaje("Precio Formato incorrecto");
                    } else guiOtros.mensaje("Marca Formato incorrecto");
                } else guiOtros.mensaje("Nombre Formato incorrecto");
            } else guiOtros.mensaje("ID Formato incorrecto");
        }
        if (e.getActionCommand().equals(GUIRegistroOtros.BTN_MODIFICAR)) {
            if (validador.validarID(guiOtros.getTxtIdProducto())) {
                if (validador.validarNombre(guiOtros.getTxtNombre())) {
                    if (validador.validarNombre(guiOtros.getTxtMarca())) {
                        if (validador.validarNumeros(String.valueOf(guiOtros.getTxtPrecio()))) {
                            if (validador.validarNumeros(String.valueOf(guiOtros.getTxtCantidad()))) {
                                Producto producto = new Producto(guiOtros.getTxtIdProducto(), guiOtros.getTxtNombre(), guiOtros.getTxtDescripcion(), guiOtros.getTxtMarca(), Integer.parseInt(guiOtros.getTxtPrecio()), Integer.parseInt(guiOtros.getTxtCantidad()));
                                GUIRegistroOtros.mensaje(regProducto.modificarPoductos(producto));
                                guiOtros.limpiar();
                            } else guiOtros.mensaje("Cantidad Formato incorrecto");
                        } else guiOtros.mensaje("Precio Formato incorrecto");
                    } else guiOtros.mensaje("Marca Formato incorrecto");
                } else guiOtros.mensaje("Nombre Formato incorrecto");
            } else guiOtros.mensaje("ID Formato incorrecto");
        }
        if (e.getActionCommand().equals(GUIRegistroOtros.BTN_ELIMINAR)) {
            if (validador.validarID(guiOtros.getTxtIdProducto())) {
                Producto producto = new Producto(guiOtros.getTxtIdProducto(), guiOtros.getTxtNombre(), guiOtros.getTxtDescripcion(), guiOtros.getTxtMarca(), Integer.parseInt(guiOtros.getTxtPrecio()), Integer.parseInt(guiOtros.getTxtCantidad()));
                if (producto != null) {
                        GUIRegistroOtros.mensaje(regProducto.eliminarProductos(producto));
                        guiOtros.limpiar();          
                } else GUIRegistroOtros.mensaje("El producto no se encuentra registrado");    
            }else GUIRegistroOtros.mensaje("ID Formato Incorrecto");
        }

        if (e.getActionCommand().equals(GUIRegistroProcesadores.BTN_BUSCAR)) {
            if (validador.validarID(guiProcesadores.getTxtIdProducto())) {
                Procesadores procesador = regProducto.verificarIDProcesador(guiProcesadores.getTxtIdProducto());
                if (procesador != null) {
                    guiProcesadores.setTxtNombre(procesador.getNombre());
                    guiProcesadores.setTxtMarca(procesador.getMarca());
                    guiProcesadores.setTxtDescripcion(procesador.getDescripcion());
                    guiProcesadores.setTxtPrecio(String.valueOf(procesador.getPrecio()));
                    guiProcesadores.setTxtCantidad(String.valueOf(procesador.getCantidad()));
                    guiProcesadores.setTxtNucleos(String.valueOf(procesador.getNucleos()));
                    guiProcesadores.setTxtFrecuencia(String.valueOf(procesador.getFrecuencia()));
                } else GUIRegistroOtros.mensaje("El producto no se encuentra registrado ó pertenece a otra categoria");    
            }else GUIRegistroOtros.mensaje("ID Formato Incorrecto");
        }

        if (e.getActionCommand().equals(GUIRegistroProcesadores.BTN_REGISTRAR)) {
            if (validador.validarID(guiProcesadores.getTxtIdProducto())) {
                if (validador.validarNombre(guiProcesadores.getTxtNombre())) {
                    if (validador.validarNombre(guiProcesadores.getTxtMarca())) {
                        if (validador.validarNumeros(String.valueOf(guiProcesadores.getTxtPrecio()))) {
                            if (validador.validarNumeros(String.valueOf(guiProcesadores.getTxtCantidad()))) {
                                if (validador.validarNumeros(String.valueOf(guiProcesadores.getTxtNucleos()))) {
                                    if (validador.validarNumeros(String.valueOf(guiProcesadores.getTxtFrecuencia()))) {
                                        Procesadores procesador = new Procesadores(guiProcesadores.getTxtIdProducto(), guiProcesadores.getTxtNombre(), guiProcesadores.getTxtDescripcion(), guiProcesadores.getTxtMarca(), Integer.parseInt(guiProcesadores.getTxtPrecio()), Integer.parseInt(guiProcesadores.getTxtCantidad()), Integer.parseInt(guiProcesadores.getTxtNucleos()), Integer.parseInt(guiProcesadores.getTxtFrecuencia()));
                                        if (regProducto.incluirProductos(procesador)) {
                                            GUIRegistroProcesadores.mensaje(regProducto.incluirProcesador(procesador));
                                        } else {
                                            GUIRegistroProcesadores.mensaje("El producto ya fue registrado");
                                        }
                                        guiProcesadores.limpiar();
                                    } else guiProcesadores.mensaje("Frecuencia Formato incorrecto");
                                } else guiProcesadores.mensaje("Nucleos Formato incorrecto");
                            } else guiProcesadores.mensaje("Cantidad Formato incorrecto");
                        } else guiProcesadores.mensaje("Precio Formato incorrecto");
                    } else guiProcesadores.mensaje("Marca Formato incorrecto");
                } else guiProcesadores.mensaje("Nombre Formato incorrecto");
            } else guiProcesadores.mensaje("ID Formato incorrecto");
        }

        if (e.getActionCommand().equals(GUIRegistroProcesadores.BTN_MODIFICAR)) {
            if (validador.validarID(guiProcesadores.getTxtIdProducto())) {
                if (validador.validarNombre(guiProcesadores.getTxtNombre())) {
                    if (validador.validarNombre(guiProcesadores.getTxtMarca())) {
                        if (validador.validarNumeros(String.valueOf(guiProcesadores.getTxtPrecio()))) {
                            if (validador.validarNumeros(String.valueOf(guiProcesadores.getTxtCantidad()))) {
                                if (validador.validarNumeros(String.valueOf(guiProcesadores.getTxtNucleos()))) {
                                    if (validador.validarNumeros(String.valueOf(guiProcesadores.getTxtFrecuencia()))) {
                                        Procesadores procesador = new Procesadores(guiProcesadores.getTxtIdProducto(), guiProcesadores.getTxtNombre(), guiProcesadores.getTxtDescripcion(), guiProcesadores.getTxtMarca(), Integer.parseInt(guiProcesadores.getTxtPrecio()), Integer.parseInt(guiProcesadores.getTxtCantidad()), Integer.parseInt(guiProcesadores.getTxtNucleos()), Integer.parseInt(guiProcesadores.getTxtFrecuencia()));
                                        GUIRegistroProcesadores.mensaje(regProducto.modificarPocesadores(procesador));
                                        guiProcesadores.limpiar();
                                    } else guiProcesadores.mensaje("Frecuencia Formato incorrecto");
                                } else guiProcesadores.mensaje("Nucleos Formato incorrecto");
                            } else guiProcesadores.mensaje("Cantidad Formato incorrecto");
                        } else guiProcesadores.mensaje("Precio Formato incorrecto");
                    } else guiProcesadores.mensaje("Marca Formato incorrecto");
                } else guiProcesadores.mensaje("Nombre Formato incorrecto");
            } else guiProcesadores.mensaje("ID Formato incorrecto");
        }

        if (e.getActionCommand().equals(GUIRegistroProcesadores.BTN_ELIMINAR)) {
            Procesadores procesador = new Procesadores(guiProcesadores.getTxtIdProducto(), guiProcesadores.getTxtNombre(), guiProcesadores.getTxtDescripcion(), guiProcesadores.getTxtMarca(), Integer.parseInt(guiProcesadores.getTxtPrecio()), Integer.parseInt(guiProcesadores.getTxtCantidad()), Integer.parseInt(guiProcesadores.getTxtNucleos()), Integer.parseInt(guiProcesadores.getTxtFrecuencia()));
            GUIRegistroProcesadores.mensaje(regProducto.eliminarProcesador(procesador));
            regProducto.eliminarProductos(procesador);
            guiProcesadores.limpiar();
        }

        if (e.getActionCommand().equals(GUIRegistroMemorias.BTN_BUSCAR)) {
            if (validador.validarID(guiMemorias.getTxtIdProducto())) {
                Memorias memoria = regProducto.verificarIDMemoria(guiMemorias.getTxtIdProducto());
                if (memoria != null) {
                    guiMemorias.setTxtNombre(memoria.getNombre());
                    guiMemorias.setTxtMarca(memoria.getMarca());
                    guiMemorias.setTxtDescripcion(memoria.getDescripcion());
                    guiMemorias.setTxtPrecio(String.valueOf(memoria.getPrecio()));
                    guiMemorias.setTxtCantidad(String.valueOf(memoria.getCantidad()));
                    guiMemorias.setTxtCapacidad(memoria.getCapacidad());
                } else GUIRegistroMemorias.mensaje("El producto no se encuentra registrado ó pertenece a otra categoria");    
            }else GUIRegistroMemorias.mensaje("ID Formato Incorrecto");
        }

        if (e.getActionCommand().equals(GUIRegistroMemorias.BTN_REGISTRAR)) {
            if (validador.validarID(guiMemorias.getTxtIdProducto())) {
                if (validador.validarNombre(guiMemorias.getTxtNombre())) {
                    if (validador.validarNombre(guiMemorias.getTxtMarca())) {
                        if (validador.validarNumeros(String.valueOf(guiMemorias.getTxtPrecio()))) {
                            if (validador.validarNumeros(String.valueOf(guiMemorias.getTxtCantidad()))) {
                                if (validador.validarNumeros(guiMemorias.getTxtCapacidad())) {
                                    Memorias memoria = new Memorias(guiMemorias.getTxtIdProducto(), guiMemorias.getTxtNombre(), guiMemorias.getTxtDescripcion(), guiMemorias.getTxtMarca(), Integer.parseInt(guiMemorias.getTxtPrecio()), Integer.parseInt(guiMemorias.getTxtCantidad()), guiMemorias.getTxtCapacidad());
                                    if (regProducto.incluirProductos(memoria)) {
                                        GUIRegistroMemorias.mensaje(regProducto.incluirMemorias(memoria));
                                        guiMemorias.limpiar();
                                    } else {
                                        GUIRegistroMemorias.mensaje("El producto ya fue registrado");
                                    }
                                } else guiMemorias.mensaje("Capacidad Formato incorrecto");
                            } else guiMemorias.mensaje("Cantidad Formato incorrecto");
                        } else guiMemorias.mensaje("Precio Formato incorrecto");
                    } else guiMemorias.mensaje("Marca Formato incorrecto");
                } else guiMemorias.mensaje("Nombre Formato incorrecto");
            } else guiMemorias.mensaje("ID Formato incorrecto");
        }

        if (e.getActionCommand().equals(GUIRegistroMemorias.BTN_MODIFICAR)) {
            if (validador.validarID(guiMemorias.getTxtIdProducto())) {
                if (validador.validarNombre(guiMemorias.getTxtNombre())) {
                    if (validador.validarNombre(guiMemorias.getTxtMarca())) {
                        if (validador.validarNumeros(String.valueOf(guiMemorias.getTxtPrecio()))) {
                            if (validador.validarNumeros(String.valueOf(guiMemorias.getTxtCantidad()))) {
                                if (validador.validarNumeros(guiMemorias.getTxtCapacidad())) {
                                    Memorias memoria = new Memorias(guiMemorias.getTxtIdProducto(), guiMemorias.getTxtNombre(), guiMemorias.getTxtDescripcion(), guiMemorias.getTxtMarca(), Integer.parseInt(guiMemorias.getTxtPrecio()), Integer.parseInt(guiMemorias.getTxtCantidad()), guiMemorias.getTxtCapacidad());
                                    GUIRegistroMemorias.mensaje(regProducto.modificarMemorias(memoria));
                                    guiMemorias.limpiar();
                                } else guiMemorias.mensaje("Capacidad Formato incorrecto");
                            } else guiMemorias.mensaje("Cantidad Formato incorrecto");
                        } else guiMemorias.mensaje("Precio Formato incorrecto");
                    } else guiMemorias.mensaje("Marca Formato incorrecto");
                } else guiMemorias.mensaje("Nombre Formato incorrecto");
            } else guiMemorias.mensaje("ID Formato incorrecto");
        }

        if (e.getActionCommand().equals(GUIRegistroMemorias.BTN_ELIMINAR)) {
            if (validador.validarID(guiMemorias.getTxtIdProducto())) {
                Memorias memoria = new Memorias(guiMemorias.getTxtIdProducto(), guiMemorias.getTxtNombre(), guiMemorias.getTxtDescripcion(), guiMemorias.getTxtMarca(), Integer.parseInt(guiMemorias.getTxtPrecio()), Integer.parseInt(guiMemorias.getTxtCantidad()), guiMemorias.getTxtCapacidad());
                if (memoria != null) {
                    GUIRegistroMemorias.mensaje(regProducto.eliminarMemorias(memoria));
                    regProducto.eliminarProductos(memoria);
                    guiMemorias.limpiar();} 
                else GUIRegistroOtros.mensaje("El producto no se encuentra registrado");    
            }else GUIRegistroOtros.mensaje("ID Formato Incorrecto");
        }

        if (e.getActionCommand().equals(GUIRegistroComputadores.BTN_BUSCAR)) {
            if (validador.validarID(guiComputadores.getTxtIdProducto())) {
                Computador computador = regProducto.verificarIDComputador(guiComputadores.getTxtIdProducto());
                if (computador != null) {
                    guiComputadores.setTxtNombre(computador.getNombre());
                    guiComputadores.setTxtMarca(computador.getMarca());
                    guiComputadores.setTxtDescripcion(computador.getDescripcion());
                    guiComputadores.setTxtPrecio(String.valueOf(computador.getPrecio()));
                    guiComputadores.setTxtCantidad(String.valueOf(computador.getCantidad()));
                    guiComputadores.setTxtRam(String.valueOf(computador.getRam()));
                    guiComputadores.setTxtRom(String.valueOf(computador.getRom()));
                    guiComputadores.setTxtProcesador(computador.getProcesador());
                } else GUIRegistroOtros.mensaje("El producto no se encuentra registrado ó pertenece a otra categoria");    
            }else GUIRegistroOtros.mensaje("ID Formato Incorrecto");
        }

        if (e.getActionCommand().equals(GUIRegistroComputadores.BTN_REGISTRAR)) {
            if (validador.validarID(guiComputadores.getTxtIdProducto())) {
                if (validador.validarNombre(guiComputadores.getTxtNombre())) {
                    if (validador.validarNombre(guiComputadores.getTxtMarca())) {
                        if (validador.validarNumeros(String.valueOf(guiComputadores.getTxtPrecio()))) {
                            if (validador.validarNumeros(String.valueOf(guiComputadores.getTxtCantidad()))) {
                                if (validador.validarNumeros(String.valueOf(guiComputadores.getTxtRom()))) {
                                    if (validador.validarNumeros(String.valueOf(guiComputadores.getTxtRam()))) {
                                        if (validador.validarNombre(guiComputadores.getTxtProcesador())) { 
                                            Computador computador = new Computador(guiComputadores.getTxtIdProducto(), guiComputadores.getTxtNombre(), guiComputadores.getTxtDescripcion(), guiComputadores.getTxtMarca(), Integer.parseInt(guiComputadores.getTxtPrecio()), Integer.parseInt(guiComputadores.getTxtCantidad()), Integer.parseInt(guiComputadores.getTxtRom()), Integer.parseInt(guiComputadores.getTxtRam()), guiComputadores.getTxtProcesador());
                                            if (regProducto.incluirProductos(computador)) {
                                                GUIRegistroComputadores.mensaje(regProducto.incluirComputadores(computador));
                                            } else {
                                                GUIRegistroMemorias.mensaje("El producto ya fue registrado");
                                            }
                                            guiComputadores.limpiar();
                                        } else guiComputadores.mensaje("Procesador Formato incorrecto");
                                    } else guiComputadores.mensaje("Memoria Ram Formato incorrecto");
                                } else guiComputadores.mensaje("Memoria Rom Formato incorrecto"); 
                            } else guiComputadores.mensaje("Cantidad Formato incorrecto");
                        } else guiComputadores.mensaje("Precio Formato incorrecto");
                    } else guiComputadores.mensaje("Marca Formato incorrecto");
                } else guiComputadores.mensaje("Nombre Formato incorrecto");
            } else guiComputadores.mensaje("ID Formato incorrecto");
        }

        if (e.getActionCommand().equals(GUIRegistroComputadores.BTN_MODIFICAR)) {
            if (validador.validarID(guiComputadores.getTxtIdProducto())) {
                if (validador.validarNombre(guiComputadores.getTxtNombre())) {
                    if (validador.validarNombre(guiComputadores.getTxtMarca())) {
                        if (validador.validarNumeros(String.valueOf(guiComputadores.getTxtPrecio()))) {
                            if (validador.validarNumeros(String.valueOf(guiComputadores.getTxtCantidad()))) {
                                if (validador.validarNumeros(String.valueOf(guiComputadores.getTxtRom()))) {
                                    if (validador.validarNumeros(String.valueOf(guiComputadores.getTxtRam()))) {
                                        if (validador.validarNombre(guiComputadores.getTxtProcesador())) {
                                            Computador computador = new Computador(guiComputadores.getTxtIdProducto(), guiComputadores.getTxtNombre(), guiComputadores.getTxtDescripcion(), guiComputadores.getTxtMarca(), Integer.parseInt(guiComputadores.getTxtPrecio()), Integer.parseInt(guiComputadores.getTxtCantidad()), Integer.parseInt(guiComputadores.getTxtRom()), Integer.parseInt(guiComputadores.getTxtRam()), guiComputadores.getTxtProcesador());
                                            GUIRegistroComputadores.mensaje(regProducto.modificarComputadores(computador));
                                            guiComputadores.limpiar();
                                        } else guiComputadores.mensaje("Procesador Formato incorrecto");
                                    } else guiComputadores.mensaje("Memoria Ram Formato incorrecto");
                                } else guiComputadores.mensaje("Memoria Rom Formato incorrecto"); 
                            } else guiComputadores.mensaje("Cantidad Formato incorrecto");
                        } else guiComputadores.mensaje("Precio Formato incorrecto");
                    } else guiComputadores.mensaje("Marca Formato incorrecto");
                } else guiComputadores.mensaje("Nombre Formato incorrecto");
            } else guiComputadores.mensaje("ID Formato incorrecto");
        }

        if (e.getActionCommand().equals(GUIRegistroComputadores.BTN_ELIMINAR)) {
            if (validador.validarID(guiMemorias.getTxtIdProducto())) {
                Computador computador = new Computador(guiComputadores.getTxtIdProducto(), guiComputadores.getTxtNombre(), guiComputadores.getTxtDescripcion(), guiComputadores.getTxtMarca(), Integer.parseInt(guiComputadores.getTxtPrecio()), Integer.parseInt(guiComputadores.getTxtCantidad()), Integer.parseInt(guiComputadores.getTxtRom()), Integer.parseInt(guiComputadores.getTxtRam()), guiComputadores.getTxtProcesador());
                if (computador != null) {
                    GUIRegistroComputadores.mensaje(regProducto.eliminarComputadores(computador));
                    regProducto.eliminarProductos(computador);
                    guiComputadores.limpiar();
                } else GUIRegistroOtros.mensaje("El producto no se encuentra registrado");    
            }else GUIRegistroOtros.mensaje("ID Formato Incorrecto");
        }
    }
}
