/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Validador;
import Vista.GUICompra;
import Vista.GUIRegistroComputadores;
import Vista.GUIRegistroMemorias;
import Vista.GUIRegistroProcesadores;
import Vista.GUIRegistroProveedores;
import Vista.GUIVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Né
 */
public class ControlValidador implements ActionListener{
    
    GUICompra guiCompra;
    GUIVenta guiVenta;
    GUIRegistroProveedores guiReProveedores;
    GUIRegistroProcesadores guiReProcesadores;
    GUIRegistroMemorias guiReMemorias;
    GUIRegistroComputadores guiReComputadores;

    public ControlValidador(GUICompra guiCompra, GUIVenta guiVenta,GUIRegistroProveedores guiRegistroProveedores,
            GUIRegistroProcesadores guiRegistroProcesadores,GUIRegistroMemorias guiReMemorias
    ,GUIRegistroComputadores guiReComputadores) {
        this.guiCompra= guiCompra;
        this.guiVenta= guiVenta;
        this.guiReProveedores= guiRegistroProveedores;
        this.guiReProcesadores =guiRegistroProcesadores;
        this.guiReMemorias=guiReMemorias;
        this.guiReComputadores= guiReComputadores;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
//       if (Validador.validarCantidad(guiCompra.getTxtCantidad())) {
//            System.out.println("la cantidad esta bien escrita");
//        } else {
//            System.out.println("hubo error al escribir la cantidad");
//        }
       
//       if (Validador.validarCantidad(guiReProcesadores.getTxtCantidad())) {     
//            System.out.println("la cantidad esta bien escrita");
//        } else {
//            System.out.println("hubo error al escribir la cantidad");
//        }
       
//       if (Validador.validarCantidad(guiVenta.getTxtCantidad())) {
//            System.out.println("la cantidad esta bien escrita");
//        } else {
//            System.out.println("hubo error al escribir la cantidad");
//        }
//       
//       
//       if (Validador.validarPrecio(guiCompra.getTxtPrecio())) {
//            System.out.println("el precio  esta bien escrito");
//        } else {
//            System.out.println("hubo error al escribir el precio");
//        }
       
//        if (Validador.validarPrecio(guiReProcesadores.getTxtPrecio())) {
//            System.out.println("el precio  esta bien escrito");
//        } else {
//            System.out.println("hubo error al escribir el precio");
//        }
//       
       if (Validador.validarCorreo(guiReProveedores.getTxtCorreo())) {
            System.out.println("Correo es Correcto");
        } else {
            System.out.println("Correo es Incorrecto");
        }
       
        if (Validador.validarNombre(guiReProveedores.getTxtNombre())) {
            System.out.println("Nombre es Correto");
        } else {
            System.out.println("Nombre es Incorrecto");
        }
        
        if (Validador.validarNombre(guiReProcesadores.getTxtNombre())) {
            System.out.println("Nombre es Correto");
        } else {
            System.out.println("Nombre es Incorrecto");
        }
        
        if (Validador.validarNombre(guiReComputadores.getTxtNombre())) {
            System.out.println("Nombre es Correto");
        } else {
            System.out.println("Nombre es Incorrecto");
        }
        
         if (Validador.validarNombre(guiReProcesadores.getTxtMarca())) {
            System.out.println("Marca es Correto");
        } else {
            System.out.println("Marca es Incorrecto");
        }
         
          if (Validador.validarNombre(guiReMemorias.getTxtMarca())) {
            System.out.println("Marca es Correto");
        } else {
            System.out.println("Marca es Incorrecto");
        }
          
           if (Validador.validarNombre(guiReComputadores.getTxtMarca())) {
            System.out.println("Marca es Correto");
        } else {
            System.out.println("Marca es Incorrecto");
        }
        
        
        if (Validador.validarTelefono(guiReProveedores.getTxtTelefono())) {
            System.out.println("Telefono es Correto");
        } else {
            System.out.println("Telefono es Incorreto");
        }
        
        
    if (Validador.validarCapacidad(guiReMemorias.getTxtCapacidad())) {
            System.out.println("capacidad es Correto");
        } else {
            System.out.println("Telefono es Incorreto");
        }
    
    }
    
     
    }
