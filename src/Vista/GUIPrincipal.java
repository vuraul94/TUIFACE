/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Né
 */
public class GUIPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form GUIPrincipal
     */
    public GUIPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mnArchivo = new javax.swing.JMenu();
        mniSalir = new javax.swing.JMenuItem();
        mnModulos = new javax.swing.JMenu();
        mniProductos = new javax.swing.JMenuItem();
        mniProveedores = new javax.swing.JMenuItem();
        mniCompra = new javax.swing.JMenuItem();
        mniVenta = new javax.swing.JMenuItem();
        mniReporte = new javax.swing.JMenuItem();
        mniInventario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnArchivo.setText("Archivo");

        mniSalir.setText("Salir");
        mniSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSalirActionPerformed(evt);
            }
        });
        mnArchivo.add(mniSalir);

        jMenuBar1.add(mnArchivo);

        mnModulos.setText("Modulos");

        mniProductos.setText("Registro Productos");
        mniProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniProductosActionPerformed(evt);
            }
        });
        mnModulos.add(mniProductos);

        mniProveedores.setText("Registro Proveedores");
        mniProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniProveedoresActionPerformed(evt);
            }
        });
        mnModulos.add(mniProveedores);

        mniCompra.setText("Compra");
        mnModulos.add(mniCompra);

        mniVenta.setText("Venta");
        mniVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniVentaActionPerformed(evt);
            }
        });
        mnModulos.add(mniVenta);

        mniReporte.setText("Reporte mensual");
        mnModulos.add(mniReporte);

        mniInventario.setText("Inventario");
        mnModulos.add(mniInventario);

        jMenuBar1.add(mnModulos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniProductosActionPerformed

    private void mniProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniProveedoresActionPerformed

    private void mniVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniVentaActionPerformed

    private void mniSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnArchivo;
    private javax.swing.JMenu mnModulos;
    private javax.swing.JMenuItem mniCompra;
    private javax.swing.JMenuItem mniInventario;
    private javax.swing.JMenuItem mniProductos;
    private javax.swing.JMenuItem mniProveedores;
    private javax.swing.JMenuItem mniReporte;
    private javax.swing.JMenuItem mniSalir;
    private javax.swing.JMenuItem mniVenta;
    // End of variables declaration//GEN-END:variables
}
