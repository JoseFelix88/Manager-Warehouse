package com.managerwarehouse.vista.inventario.bodega;

import com.managerwarehouse.vista.inventario.puntoentrega.*;
import com.managerwarehouse.controlador.index.ControllerContenedor;
import com.managerwarehouse.model.inventario.InventarioDAO;
import com.managerwarehouse.model.inventario.puntoentrega.InventarioPuntoEntregaDAO;
import com.managerwarehouse.model.puntoentrega.PuntoEntrega;
import com.managerwarehouse.model.puntoentrega.PuntoEntregaDAO;
import com.managerwarehouse.util.CambiaFormatoTexto;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.vista.inventario.bodega.FormMonitorConsumo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

public class FormConsumoSaldoGeneral extends javax.swing.JInternalFrame {

    InventarioDAO ipedao;
    Edicion edicion = new Edicion();

    public FormConsumoSaldoGeneral() {

        ipedao = new InventarioDAO();

        initComponents();

        /*txtplu.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         if (txtplu.getText().length() == 4) {
         e.consume();
         }
         }

         @Override
         public void keyPressed(KeyEvent e) {
         }

         @Override
         public void keyReleased(KeyEvent e) {
         }
         });*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        JM_MONITOR = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JD_fecha1 = new com.toedter.calendar.JDateChooser();
        JD_fecha2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_detalleConsumo = new javax.swing.JTable();

        JM_MONITOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar-sustituir-la-busqueda-icono-8806-48.png"))); // NOI18N
        JM_MONITOR.setText("Monitor de Consumos y Saldos");
        JM_MONITOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_MONITORActionPerformed(evt);
            }
        });
        jPopupMenu1.add(JM_MONITOR);

        setClosable(true);
        setIconifiable(true);
        setTitle("Consumo & Saldos");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSUMOS Y SALDOS GENERALES");

        jLabel3.setText("PERIODO DE INVENTARIO");

        JD_fecha1.setDateFormatString("EEE, dd MMM yyyy");

        JD_fecha2.setDateFormatString("EEE, dd MMM yyyy");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/investigacion-icono-8491-48.png"))); // NOI18N
        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/liberacion-de-la-puerta-icono-9156-48.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JD_fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JD_fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(JD_fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JD_fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TB_detalleConsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "PLU", "DESCRIPCIÓN", "STOCK PUNTOS", "STOCK BODEGA", "CONSUMO TOTAL", "STOCK GENERAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TB_detalleConsumo.setComponentPopupMenu(jPopupMenu1);
        TB_detalleConsumo.setRowHeight(25);
        TB_detalleConsumo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TB_detalleConsumo);
        if (TB_detalleConsumo.getColumnModel().getColumnCount() > 0) {
            TB_detalleConsumo.getColumnModel().getColumn(0).setMaxWidth(60);
            TB_detalleConsumo.getColumnModel().getColumn(1).setMinWidth(200);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        consumossaldos(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JM_MONITORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_MONITORActionPerformed
        // TODO add your handling code here:
        try {
            Object Producto = TB_detalleConsumo.getValueAt(TB_detalleConsumo.getSelectedRow(), 0);
            Object descripcion = TB_detalleConsumo.getValueAt(TB_detalleConsumo.getSelectedRow(), 1);
            Object[] key = {edicion.formatearFechaSQL(JD_fecha1.getDate()), edicion.formatearFechaSQL(JD_fecha2.getDate()), Producto,
                descripcion};
            JInternalFrame ji = validador.getJInternalFrame(FormMonitorConsumo.class.getName());

            if (ji == null || ji.isClosed()) {

                ji = new FormMonitorConsumo(key);
                ControllerContenedor.getjDesktopPane1().add(ji, 0);
                validador.addJIframe(FormMonitorConsumo.class.getName(), ji);

                ji.setVisible(true);

            } else {

                ji.show();
                try {
                    ji.setIcon(false);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(FormMonitorConsumo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (Exception e) {
            edicion.mensajes(3, "SELECCIONA UN PRODUCTO DE LA LISTA.");
        }
    }//GEN-LAST:event_JM_MONITORActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JD_fecha1;
    private com.toedter.calendar.JDateChooser JD_fecha2;
    private javax.swing.JMenuItem JM_MONITOR;
    private javax.swing.JTable TB_detalleConsumo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private void consumossaldos(int i) {

        Object[] key = {edicion.formatearFechaSQL(JD_fecha1.getDate()),
            edicion.formatearFechaSQL(JD_fecha2.getDate())};
        if (JD_fecha1.getDate() == null | JD_fecha2.getDate() == null) {
            edicion.mensajes(1, "seleccione un periodo de fechas valido");
        } else if (i == 1) {
            CambiaFormatoTexto cft = new CambiaFormatoTexto();
            edicion.llenarTabla(TB_detalleConsumo, ipedao.ConsumosYSaldosMensualesGeneral(key));
            /*for (int j = 0; j < TB_detalleConsumo.getRowCount(); j++) {
                Object valueCOnsumo = cft.numerico(TB_detalleConsumo.getValueAt(j, 2).toString());
                TB_detalleConsumo.setValueAt(valueCOnsumo, j, 2);
            }*/
        }

    }
}
