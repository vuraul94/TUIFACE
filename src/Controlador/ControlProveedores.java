/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Proveedores;
import Modelo.RegistroProveedores;
import Modelo.Validador;
import Vista.GUIRegistroProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Né
 */
public class ControlProveedores implements ActionListener {

    private GUIRegistroProveedores guiProveedores;
    private RegistroProveedores regProveedores;
    private Validador validador;

    public ControlProveedores(GUIRegistroProveedores guiProveedores) throws SQLException, ClassNotFoundException {
        this.guiProveedores = guiProveedores;
        this.regProveedores = new RegistroProveedores();
        this.validador = new Validador();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(GUIRegistroProveedores.BTN_BUSCAR)) {
            Proveedores proveedor = regProveedores.verificarID(guiProveedores.getTxtID());
            if (proveedor != null) {
                if (validador.validarID(guiProveedores.getTxtID())) {
                    guiProveedores.setTxtNombre(proveedor.getNombre());
                    guiProveedores.setTxtDireccion(proveedor.getDireccion());
                    guiProveedores.setTxtCorreo(proveedor.getCorreo());
                    guiProveedores.setTxtTelefono(proveedor.getTelefono());
                }else guiProveedores.mensaje("El id tiene el formato incorrecto");
            } else {
                guiProveedores.mensaje("El proveedor no existe");
            }
        }
        if (e.getActionCommand().equals(GUIRegistroProveedores.BTN_REGISTRAR)) {
            if (regProveedores.verificarID(guiProveedores.getTxtID()) == null) {
                if (validador.validarID(guiProveedores.getTxtID())) {
                    if (validador.validarNombre(guiProveedores.getTxtNombre())) {
                        if (validador.validarDireccion(guiProveedores.getTxtDireccion())) {
                            if (validador.validarCorreo(guiProveedores.getTxtCorreo())) {
                                if (validador.validarTelefono(guiProveedores.getTxtTelefono())) {
                                    Proveedores proveedor = new Proveedores(guiProveedores.getTxtID(), guiProveedores.getTxtNombre(), guiProveedores.getTxtDireccion(), guiProveedores.getTxtCorreo(), guiProveedores.getTxtTelefono());
                                    GUIRegistroProveedores.mensaje(regProveedores.incluirProveedores(proveedor));
                                    guiProveedores.limpiar();
                                }else guiProveedores.mensaje("El telefono tiene el formato incorrecto");
                            }else guiProveedores.mensaje("El correo tiene el formato incorrecto");
                        }else guiProveedores.mensaje("La dirección tiene el formato incorrecto");
                    }else guiProveedores.mensaje("El nombre tiene el formato incorrecto");
                }else guiProveedores.mensaje("El id tiene el formato incorrecto");
            } else {
                guiProveedores.mensaje("El proveedor ya existe");
                guiProveedores.limpiar();
            }
        }
        if (e.getActionCommand().equals(GUIRegistroProveedores.BTN_MODIFICAR)) {
            if (regProveedores.verificarID(guiProveedores.getTxtID()) != null) {
                if (validador.validarID(guiProveedores.getTxtID())) {
                    if (validador.validarNombre(guiProveedores.getTxtNombre())) {
                        if (validador.validarDireccion(guiProveedores.getTxtDireccion())) {
                            if (validador.validarCorreo(guiProveedores.getTxtCorreo())) {
                                if (validador.validarTelefono(guiProveedores.getTxtTelefono())) {
                                    Proveedores proveedor = new Proveedores(guiProveedores.getTxtID(), guiProveedores.getTxtNombre(), guiProveedores.getTxtDireccion(), guiProveedores.getTxtCorreo(), guiProveedores.getTxtTelefono());
                                    GUIRegistroProveedores.mensaje(regProveedores.modificarPoveedores(proveedor));
                                    guiProveedores.limpiar();
                                }else guiProveedores.mensaje("El telefono tiene el formato incorrecto");
                            }else guiProveedores.mensaje("El correo tiene el formato incorrecto");
                        }else guiProveedores.mensaje("La dirección tiene el formato incorrecto");
                    }else guiProveedores.mensaje("El nombre tiene el formato incorrecto");
                }else guiProveedores.mensaje("El id tiene el formato incorrecto");
            } else {
                guiProveedores.mensaje("El proveedor no existe");
            }
        }
        if (e.getActionCommand().equals(GUIRegistroProveedores.BTN_ELIMINAR)) {
            if (regProveedores.verificarID(guiProveedores.getTxtID()) != null) {
                Proveedores proveedor = new Proveedores(guiProveedores.getTxtID(), guiProveedores.getTxtNombre(), guiProveedores.getTxtDireccion(), guiProveedores.getTxtCorreo(), guiProveedores.getTxtTelefono());
                GUIRegistroProveedores.mensaje(regProveedores.eliminarProveedores(proveedor));
            } else {
                guiProveedores.mensaje("El proveedor no existe");
            }
            guiProveedores.limpiar();
        }
    }
}
