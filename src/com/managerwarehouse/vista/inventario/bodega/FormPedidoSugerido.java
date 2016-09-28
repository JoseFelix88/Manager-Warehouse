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

public class FormPedidoSugerido extends javax.swing.JInternalFrame {

    InventarioDAO ipedao;
    Edicion edicion = new Edicion();

    public FormPedidoSugerido() {

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
        jLabel4 = new javax.swing.JLabel();
        JD_fecha3 = new com.toedter.calendar.JDateChooser();
        JD_fecha4 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtporcentaje = new javax.swing.JTextField();
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
        setTitle("Pedido  Sugerido");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CALCULO DEL PEDIDO SUGERIDO");

        jLabel3.setText("PERIODO DE INVENTARIO ACTUAL");

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

        jLabel4.setBackground(new java.awt.Color(255, 153, 102));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 153));
        jLabel4.setText("PERIODO DE COMPORTAMIENTO");

        JD_fecha3.setBackground(new java.awt.Color(255, 153, 102));
        JD_fecha3.setForeground(new java.awt.Color(204, 153, 0));
        JD_fecha3.setDateFormatString("EEE, dd MMM yyyy");

        JD_fecha4.setBackground(new java.awt.Color(255, 153, 102));
        JD_fecha4.setForeground(new java.awt.Color(204, 153, 0));
        JD_fecha4.setDateFormatString("EEE, dd MMM yyyy");

        jLabel2.setBackground(new java.awt.Color(255, 153, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 153));
        jLabel2.setText("PORCENTAJE (%) DE AUMENTO");

        txtporcentaje.setBackground(new java.awt.Color(255, 153, 102));
        txtporcentaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtporcentaje.setForeground(new java.awt.Color(255, 255, 255));
        txtporcentaje.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtporcentaje.setText("0%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(JD_fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JD_fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JD_fecha3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JD_fecha4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtporcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(JD_fecha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JD_fecha4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtporcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TB_detalleConsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PLU", "DESCRIPCIÓN", "STOCK PUNTOS", "STOCK BODEGA", "STOCK GENERAL", "CONSUMO PROMEDIO", "PEDIDO SUGERIDO", "COSTO UNIDAD", "COSTO TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
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
    private com.toedter.calendar.JDateChooser JD_fecha3;
    private com.toedter.calendar.JDateChooser JD_fecha4;
    private javax.swing.JMenuItem JM_MONITOR;
    private javax.swing.JTable TB_detalleConsumo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtporcentaje;
    // End of variables declaration//GEN-END:variables
    private void consumossaldos(int i) {
        if (JD_fecha1.getDate() == null | JD_fecha2.getDate() == null) {
            edicion.mensajes(1, "seleccione un periodo de inventario valido");
            return;
        }
        if (JD_fecha3.getDate() == null | JD_fecha4.getDate() == null) {
            edicion.mensajes(1, "seleccione un periodo de comportamiento valido");
            return;
        }
        float porcentaje = edicion.toNumeroFloat(txtporcentaje.getText());
        if (porcentaje < 1) {
            edicion.mensajes(1, "el porcentaje de aumento debe ser mayor a cero(0).");
            return;
        }
        Object[] key = {edicion.formatearFechaSQL(JD_fecha1.getDate()),
            edicion.formatearFechaSQL(JD_fecha2.getDate()), edicion.formatearFechaSQL(JD_fecha3.getDate()),
            edicion.formatearFechaSQL(JD_fecha4.getDate()), porcentaje/100};
        edicion.llenarTabla(TB_detalleConsumo, ipedao.CALCULO_PEDIDO_SUGERIDO(key));
    }
}
