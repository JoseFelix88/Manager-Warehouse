package com.managerwarehouse.vista.producto;

import com.managerwarehouse.model.producto.controltemperatura.ControlTHDao;
import com.managerwarehouse.model.producto.controltemperatura.ControlTemperaturaHumedad;
import com.managerwarehouse.model.producto.controltemperatura.TemperaturaDAO;
import com.managerwarehouse.util.CambiaColorTabla;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.Variables_Gloabales;
import com.managerwarehouse.util.reportes.GenerarReporte;
import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FormTemperaturaHumedad extends javax.swing.JInternalFrame {

    Edicion edicion = new Edicion();
    ControlTHDao tHDao;
    ControlTemperaturaHumedad ctrlTH;
    TemperaturaDAO temperaturaDAO;

    int equivalencia = 0;
    Calendar cal = new GregorianCalendar();
    CambiaColorTabla cct = new CambiaColorTabla();
    DefaultTableModel dt;

    public FormTemperaturaHumedad() {
        temperaturaDAO = new TemperaturaDAO();
        ctrlTH = new ControlTemperaturaHumedad();
        tHDao = new ControlTHDao();
        initComponents();
        llenarcombos();
        dt = (DefaultTableModel) jTable1.getModel();
        jTable1.setDefaultRenderer(Object.class, cct);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtitemnum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JD_fechareg = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        Comboconcepto = new javax.swing.JComboBox();
        radioAm = new javax.swing.JRadioButton();
        RadioPM = new javax.swing.JRadioButton();
        txtvalorAM = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtvalorPM = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        JD_fecha1 = new com.toedter.calendar.JDateChooser();
        JD_fecha2 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        combofiltroconcepto = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Control de Temperatura & Humedad");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel3.setBackground(new java.awt.Color(255, 166, 61));

        jLabel2.setText("Item No.");

        txtitemnum.setEditable(false);
        txtitemnum.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jLabel3.setText("Fecha Captura");

        JD_fechareg.setDateFormatString("EEEE, dd MMM yyyy");

        jLabel4.setText("Concepto");

        Comboconcepto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(radioAm);
        radioAm.setText("AM");
        radioAm.setEnabled(false);
        radioAm.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioAmItemStateChanged(evt);
            }
        });

        buttonGroup1.add(RadioPM);
        RadioPM.setText("PM");
        RadioPM.setEnabled(false);
        RadioPM.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RadioPMItemStateChanged(evt);
            }
        });

        txtvalorAM.setEditable(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar-nuevo-documento-de-archivo-mas-icono-6249-32.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/liberacion-de-la-puerta-icono-9156-32.png"))); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtvalorPM.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtitemnum, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JD_fechareg, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Comboconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(radioAm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtvalorAM, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RadioPM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtvalorPM, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButton4))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtitemnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JD_fechareg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(Comboconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(radioAm)
                                    .addComponent(RadioPM)
                                    .addComponent(txtvalorAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtvalorPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Control", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID. Reg.", "Fecha Reg.", "Dia ", "Hora AM", "Hora PM", "Minimo", "Valor AM", "Valor PM", "Maximo", "Promedio", "Und. Medida", "Realizado"
            }
        ));
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setText("PERIODO");

        JD_fecha1.setDateFormatString("EEE, dd MMM yyyy");

        JD_fecha2.setDateFormatString("EEE, dd MMM yyyy");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/embudo-filtrante-icono-4497-32.png"))); // NOI18N
        jLabel6.setText("CONCEPTO");

        combofiltroconcepto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/investigacion-icono-8491-48.png"))); // NOI18N
        jButton3.setText("CONSULTAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/estadisticas-icono-7540-32.png"))); // NOI18N
        jButton5.setText("GRAFICO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/liberacion-de-la-puerta-icono-9156-32.png"))); // NOI18N
        jButton6.setText("SALIR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combofiltroconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(JD_fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JD_fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JD_fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JD_fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(combofiltroconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Historico", jPanel2);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/thermometer64.png"))); // NOI18N
        jLabel1.setText("CONTROL DE TEMPERATURA & HUMEDAD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (ValidarFormulario() != false) {
            if (tHDao.CRUD_CTRL_T_H(cargardatostemperatura(0)) != false) {
                edicion.mensajes(2, "datos registrados correctamente.");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void radioAmItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioAmItemStateChanged
        // TODO add your handling code here:
        txtvalorAM.setEditable(true);
        txtvalorPM.setEditable(false);
        txtvalorPM.setText("");
    }//GEN-LAST:event_radioAmItemStateChanged

    private void RadioPMItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RadioPMItemStateChanged
        // TODO add your handling code here:
        txtvalorPM.setEditable(true);
        txtvalorAM.setEditable(false);
        txtvalorAM.setText("");
    }//GEN-LAST:event_RadioPMItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        nuevo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (validarParametroHistorico() != false) {
            Object[] key = {"'" + edicion.formatearFechaSQL(JD_fecha1.getDate()) + "'",
                "'" + edicion.formatearFechaSQL(JD_fecha2.getDate()) + "'",
                "'" + combofiltroconcepto.getSelectedItem() + "'"};
            Object[][] rs = tHDao.HISTORICO_TEMPERATURAS(key);

            if (rs.length > 0) {
                    edicion.llenarTabla(jTable1, rs);
             

            } else {
                edicion.limpiar_tablas(jTable1);
                edicion.mensajes(1, "no se encontraron registros para el periodo de fechas y concepto establecidos.");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (validarParametroHistorico() != false) {
            Object[] key = {"'" + edicion.formatearFechaSQL(JD_fecha1.getDate()) + "'",
                "'" + edicion.formatearFechaSQL(JD_fecha2.getDate()) + "'",
                "'" + combofiltroconcepto.getSelectedItem() + "'"};
            Object[][] rs = tHDao.HISTORICO_TEMPERATURAS(key);
            if (rs.length > 0) {
                edicion.llenarTabla(jTable1, rs);
                GenerarReporte gr = new GenerarReporte();
                gr.GRAFRICO_TEMPERATURA_HUMEDAD(JD_fecha1.getDate(),
                        JD_fecha2.getDate(),
                        combofiltroconcepto.getSelectedItem().toString());
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Comboconcepto;
    private com.toedter.calendar.JDateChooser JD_fecha1;
    private com.toedter.calendar.JDateChooser JD_fecha2;
    private com.toedter.calendar.JDateChooser JD_fechareg;
    private javax.swing.JRadioButton RadioPM;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combofiltroconcepto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioAm;
    private javax.swing.JTextField txtitemnum;
    private javax.swing.JTextField txtvalorAM;
    private javax.swing.JTextField txtvalorPM;
    // End of variables declaration//GEN-END:variables

    private boolean ValidarFormulario() {
        if (Comboconcepto.getSelectedItem().equals("")) {
            edicion.mensajes(1, "por favor selecciona un concepto.");
            return false;
        }
        if (radioAm.isSelected() != false & txtvalorAM.getText().isEmpty() != false) {
            edicion.mensajes(1, "ingresa el valor de la medicion AM.");
            return false;
        }
        if (RadioPM.isSelected() != false & txtvalorPM.getText().isEmpty() != false) {
            edicion.mensajes(1, "ingresa el valor de la medicion PM.");
            return false;
        }

        return true;
    }

    private void AM_PM() {
        cal = new GregorianCalendar();
        int am_pm = cal.get(Calendar.AM_PM);
        if (am_pm == 0) {
            radioAm.setSelected(true);
            txtvalorAM.setText(null);
        } else {
            RadioPM.setSelected(true);
            txtvalorPM.setText(null);
        }
    }

    private void llenarcombos() {
        Comboconcepto.removeAllItems();
        Comboconcepto.addItem("");
        combofiltroconcepto.removeAllItems();
        combofiltroconcepto.addItem("");
        for (Object[] LISTADO_TEMPERATURA : temperaturaDAO.LISTADO_TEMPERATURA()) {
            Comboconcepto.addItem(LISTADO_TEMPERATURA[0]);
            combofiltroconcepto.addItem(LISTADO_TEMPERATURA[0]);
        }
        AM_PM();
        JD_fechareg.setDate(cal.getTime());
        txtitemnum.setText(tHDao.numeroRegistro());
    }

    private Object[] cargardatostemperatura(int opcion) {
        Object[] key = new Object[6];
        int valorAM = 0, valorPM = 0;
        if (opcion == 0) {
            key[0] = opcion;
        }
        key[1] = "'" + edicion.formatearFechaSQL(JD_fechareg.getDate()) + "'";
        key[2] = temperaturaDAO.LEER_TEMPERATURA(Comboconcepto.getSelectedItem()).getItemtemperatura();
        if (radioAm.isSelected()) {
            valorAM = edicion.toNumeroEntero(txtvalorAM.getText());
        } else {
            valorPM = edicion.toNumeroEntero(txtvalorPM.getText());
        }
        key[3] = valorAM;
        key[4] = valorPM;
        key[5] = "'" + Variables_Gloabales.EMPLEADO.getIdusuario() + "'";
        return key;
    }

    private void nuevo() {
        llenarcombos();
    }

    private boolean validarParametroHistorico() {
        if (JD_fecha1.getDate() == null | JD_fecha2.getDate() == null) {
            edicion.mensajes(1, "selecciona un periodo de fechas valido.");
            return false;
        }
        if (JD_fecha1.getDate().after(JD_fecha2.getDate())) {
            edicion.mensajes(1, "él periodo de fechas no es valido.");
            return false;
        }
        if (combofiltroconcepto.getSelectedItem().equals("")) {
            edicion.mensajes(1, "por favor selecciona un concepto.");
            return false;
        }
        return true;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        // SI EN CADA FILA DE LA TABLA LA CELDA 5 ES IGUAL A ACTIVO COLOR AZUL
        if (String.valueOf(table.getValueAt(row, 5)).equals("ACTIVO")) {
            setForeground(Color.blue);
        } // SI NO ES ACTIVO ENTONCES COLOR ROJO
        else {
            setForeground(Color.red);
        }

        return this;
    }
}
