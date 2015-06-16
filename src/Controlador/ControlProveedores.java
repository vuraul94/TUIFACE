/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Proveedores;
import Modelo.RegistroProveedores;
import Vista.GUIRegistroProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Raul
 */
public class ControlProveedores implements ActionListener {

    private GUIRegistroProveedores guiProveedores;
    private RegistroProveedores regProveedores;

    public ControlProveedores(GUIRegistroProveedores guiProveedores) throws SQLException, ClassNotFoundException {
        this.guiProveedores = guiProveedores;
        this.regProveedores = new RegistroProveedores();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(GUIRegistroProveedores.BTN_BUSCAR)) {
            Proveedores proveedor = regProveedores.verificarID(guiProveedores.getTxtID());
            guiProveedores.setTxtNombre(proveedor.getNombre());
            guiProveedores.setTxtDireccion(proveedor.getDireccion());
            guiProveedores.setTxtCorreo(proveedor.getCorreo());
            guiProveedores.setTxtTelefono(proveedor.getTelefono());
       }
        if (e.getActionCommand().equals(GUIRegistroProveedores.BTN_REGISTRAR)) {
            Proveedores proveedor = new Proveedores(guiProveedores.getTxtID(), guiProveedores.getTxtNombre(), guiProveedores.getTxtDireccion(), guiProveedores.getTxtCorreo(), guiProveedores.getTxtTelefono());
            GUIRegistroProveedores.mensaje(regProveedores.incluirProveedores(proveedor));
            guiProveedores.limpiar();
        }
        if(e.getActionCommand().equals(GUIRegistroProveedores.BTN_MODIFICAR)){
            Proveedores proveedor = new Proveedores(guiProveedores.getTxtID(), guiProveedores.getTxtNombre(), guiProveedores.getTxtDireccion(), guiProveedores.getTxtCorreo(), guiProveedores.getTxtTelefono());
            GUIRegistroProveedores.mensaje(regProveedores.modificarPoveedores(proveedor));
            guiProveedores.limpiar();
        }
        if(e.getActionCommand().equals(GUIRegistroProveedores.BTN_ELIMINAR)){
            Proveedores proveedor = new Proveedores(guiProveedores.getTxtID(), guiProveedores.getTxtNombre(), guiProveedores.getTxtDireccion(), guiProveedores.getTxtCorreo(), guiProveedores.getTxtTelefono());
            GUIRegistroProveedores.mensaje(regProveedores.eliminarProveedores(proveedor));
            guiProveedores.limpiar();
        }
    }
}
