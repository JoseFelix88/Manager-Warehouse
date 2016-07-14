package com.managerwarehouse.vista.inventario.puntoentrega;

import com.managerwarehouse.model.inventario.puntoentrega.TrasladoProducto;
import com.managerwarehouse.model.inventario.puntoentrega.TrasladoProductoDao;
import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.model.producto.ProductoDTO;
import com.managerwarehouse.model.puntoentrega.PuntoEntrega;
import com.managerwarehouse.model.puntoentrega.PuntoEntregaDAO;
import com.managerwarehouse.util.CambiaFormatoTexto;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.Variables_Gloabales;
import com.managerwarehouse.util.reportes.GenerarReporte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFileChooser;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class FormTrasladoMercancias extends javax.swing.JInternalFrame {

    Edicion edicion = new Edicion();
    PuntoEntregaDAO pedao;
    TrasladoProducto trasladoProducto;
    TrasladoProductoDao trasladoDao;
    ProductoDAO productoDAO;
    private Object id_detalletraslado;
    CambiaFormatoTexto formatoTexto = new CambiaFormatoTexto();
    GenerarReporte gr = new GenerarReporte();

    public FormTrasladoMercancias() {
        productoDAO = new ProductoDAO();
        pedao = new PuntoEntregaDAO();
        trasladoDao = new TrasladoProductoDao();
        initComponents();
        AutoCompleteDecorator.decorate(combodescripcion);
        combodescripcion.getEditor().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDTO dTO = productoDAO.read(combodescripcion.getSelectedItem());
                if (dTO != null) {
                    txtplu.setText(dTO.getPlu());
                    txtcantidad.grabFocus();
                } else {
                    edicion.mensajes(1, "el producto no se encuentra registrado.");
                }

            }
        });
        txtcantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                txtcantidad.setText(formatoTexto.numerico(edicion.toNumeroEntero(txtcantidad.getText())));
            }
        });
        llenar_combos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnumtraslado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JD_FechaEmision = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        comboOrigen = new javax.swing.JComboBox();
        combodestino = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtautoriza = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_DETALLE_TRASLADO = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtplu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        combodescripcion = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/Qx9 Vista Bin2 Full.png"))); // NOI18N
        jMenuItem7.setText("ELIMINAR");
        jMenuItem7.setToolTipText("");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);

        setTitle("Traslados de Productos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 4), "TRASLADOS DE PRODUCTOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 18))); // NOI18N

        jLabel1.setText("No. DE TRASLADO");

        jLabel2.setText("FECHA DE EMISION");

        JD_FechaEmision.setDateFormatString("EEE, dd MMM yyyy");

        jLabel3.setText("FARMACIA DE ORIGEN");

        jLabel4.setText("FARMACIA DE DESTINO");

        jLabel5.setText("AUTORIZADO POR:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combodestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtnumtraslado, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JD_FechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtautoriza, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumtraslado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JD_FechaEmision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combodestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtautoriza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE DEL TRASLADO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 18))); // NOI18N

        TB_DETALLE_TRASLADO.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        TB_DETALLE_TRASLADO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID. TRP", "PLU", "DESCRIPCION", "CANTIDAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TB_DETALLE_TRASLADO.setComponentPopupMenu(jPopupMenu1);
        TB_DETALLE_TRASLADO.setRowHeight(22);
        TB_DETALLE_TRASLADO.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TB_DETALLE_TRASLADO);
        if (TB_DETALLE_TRASLADO.getColumnModel().getColumnCount() > 0) {
            TB_DETALLE_TRASLADO.getColumnModel().getColumn(0).setMaxWidth(50);
            TB_DETALLE_TRASLADO.getColumnModel().getColumn(1).setMaxWidth(75);
            TB_DETALLE_TRASLADO.getColumnModel().getColumn(2).setMinWidth(300);
        }

        jPanel3.setBackground(new java.awt.Color(204, 51, 0));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PLU");

        txtplu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtplu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpluActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DESCRIPCIÓN");

        combodescripcion.setEditable(true);
        combodescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combodescripcionActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CANT. TRASLADADA");

        txtcantidad.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtcantidad.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtcantidad.setText("0");
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtplu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combodescripcion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtplu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combodescripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/nuevo-archivo-de-documento-escrito-en-papel-pluma-icono-3934-32.png"))); // NOI18N
        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/Qx9 Vista Mail.png"))); // NOI18N
        jMenuItem5.setText("Enviar ");
        jMenu1.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/PDF File.png"))); // NOI18N
        jMenuItem6.setText("Guardar Como PDF");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Refresh.png"))); // NOI18N
        jMenuItem2.setText("Modificar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/investigacion-icono-8491-48.png"))); // NOI18N
        jMenuItem3.setText("Consultar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/liberacion-de-la-puerta-icono-9156-48.png"))); // NOI18N
        jMenuItem4.setText("Salir");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpluActionPerformed
        ProductoDTO dTO = productoDAO.read(txtplu.getText());
        if (dTO != null) {
            combodescripcion.setSelectedItem(dTO.getDescripcion());
            txtcantidad.grabFocus();
        } else {
            edicion.mensajes(1, "el producto no se encuentra registrado.");
        }
    }//GEN-LAST:event_txtpluActionPerformed

    private void combodescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combodescripcionActionPerformed

    }//GEN-LAST:event_combodescripcionActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Object numtraslado = edicion.msjQuest(2, "ingresa el numero del traslado.");
        if (consulta_traslado(numtraslado) != false) {
            LOAD_COMPONET();
        } else {
            edicion.mensajes(1, "el traslado aun no se ha registrado.");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        if (edicion.toNumeroEntero(txtcantidad.getText()) < 1) {
            edicion.mensajes(1, "la cantidad a trasladar debe ser mayor a cero (0).");
            return;
        }
        if (validar_traslado() != false) {
            if (trasladoDao.CRUD_TRASLADO(MONTAR_TRASLADO(0)) != false) {
                consulta_traslado(txtnumtraslado.getText());
                LOAD_COMPONET();
                txtplu.setText(null);
                combodescripcion.setSelectedItem(null);
                txtcantidad.setText("0");
                txtplu.grabFocus();
            }
        }
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (validar_traslado() != false) {
            int SI_NO = (int) edicion.msjQuest(1, "estas seguro que desea MODIFICAR EL TRASLADO.");
            if (SI_NO == 0) {
                if (consulta_traslado(txtnumtraslado.getText()) != false) {
                    if (trasladoDao.CRUD_TRASLADO(MONTAR_TRASLADO(1)) != false) {
                        edicion.mensajes(2, "traslado modificado correctamente.");
                    }
                } else {
                    edicion.mensajes(1, "el traslado aun no hacido registrado");
                }
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {
            int SI_NO = (int) edicion.msjQuest(1, "estas seguro que desea eliminar el producto.");
            if (SI_NO == 0) {
                id_detalletraslado = TB_DETALLE_TRASLADO.getValueAt(TB_DETALLE_TRASLADO.getSelectedRow(), 0);
                if (trasladoDao.CRUD_TRASLADO(MONTAR_TRASLADO(2)) != false) {
                    edicion.menu_emergente(TB_DETALLE_TRASLADO);
                }
            }
        } catch (Exception e) {
            edicion.mensajes(3, "selecciona un producto de la lista.");
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        nuevo();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        JFileChooser jfc = new JFileChooser();
        Calendar c = new GregorianCalendar();
        int anio = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);

        gr.NOMBRE_DEL_ARCHIVO_EXPORTADO = "TRASLADO DE PRODUCTOS No. "
                + "" + txtnumtraslado.getText() + " - " + comboOrigen.getSelectedItem()+" hacia "+combodestino.getSelectedItem();
        gr.NOMBRE_REPORTE = "inventario/traslado de productos.jasper";
        gr.DIRECTORIO_POR_DEFECTO = jfc.getCurrentDirectory().getPath() + "/TRASLADO DE PRODUCTOS/" + anio + "/" + edicion.mesDeFecha(mes) + "/PUNTOS DE ENTREGA/FARMACIA ORIGEN/" +comboOrigen.getSelectedItem() + "/";
        gr.PARAMETROS.put("id_traslado", txtnumtraslado.getText());
        
        gr.Exportar();
    }//GEN-LAST:event_jMenuItem6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JD_FechaEmision;
    private javax.swing.JTable TB_DETALLE_TRASLADO;
    private javax.swing.JComboBox comboOrigen;
    private javax.swing.JComboBox combodescripcion;
    private javax.swing.JComboBox combodestino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtautoriza;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtnumtraslado;
    private javax.swing.JTextField txtplu;
    // End of variables declaration//GEN-END:variables

    private boolean validar_traslado() {
        if (comboOrigen.getSelectedItem() == null) {
            edicion.mensajes(1, "selecciona la bodega de origen.");
            return false;
        }
        if (combodestino.getSelectedItem() == null) {
            edicion.mensajes(1, "selecciona la bodega de destino.");
            return false;
        }
        if (combodestino.getSelectedItem().equals(comboOrigen.getSelectedItem())) {
            edicion.mensajes(1, "la farmacia de destino no puede ser la misma que la de origen");
            return false;
        }
        if (txtautoriza.getText() == null | txtautoriza.getText().isEmpty()) {
            edicion.mensajes(1, "ingresa el nombre de quien autoriza el traslado");
            return false;
        }

        return true;
    }
    Calendar calendar = new GregorianCalendar();

    private void llenar_combos() {

        JD_FechaEmision.setDate(calendar.getTime());
        comboOrigen.addItem(null);
        combodestino.addItem(null);
        combodescripcion.addItem(null);
        for (PuntoEntrega readAll : pedao.readAll()) {
            comboOrigen.addItem(readAll.getNombre());
            combodestino.addItem(readAll.getNombre());
        }
        for (ProductoDTO readAll : productoDAO.readAll()) {
            combodescripcion.addItem(readAll.getDescripcion());
        }
        txtnumtraslado.setText(trasladoDao.NUMERO_TRASLADO());
    }

    private boolean consulta_traslado(Object key) {
        trasladoProducto = trasladoDao.CONSULTA_TRASLADO(key);
        return trasladoProducto != null;
    }

    private void LOAD_COMPONET() {
        txtautoriza.setText(trasladoProducto.getAutorizado());
        txtnumtraslado.setText(trasladoProducto.getIdtraslado());
        if (trasladoProducto.getBodegaOrigen() == null | trasladoProducto.getBodegaDestino() == null) {
            comboOrigen.setSelectedItem(null);
            combodestino.setSelectedItem(null);
        } else {
            comboOrigen.setSelectedItem(trasladoProducto.getBodegaOrigen().getNombre());
            combodestino.setSelectedItem(trasladoProducto.getBodegaDestino().getNombre());
        }

        JD_FechaEmision.setDate(calendar.getTime());
        edicion.llenarTabla(TB_DETALLE_TRASLADO, trasladoDao.DETALLE_TRASLADO(txtnumtraslado.getText()));
    }

    private void nuevo() {
        trasladoProducto = new TrasladoProducto();
        LOAD_COMPONET();
        txtnumtraslado.setText(trasladoDao.NUMERO_TRASLADO());
        edicion.limpiar_tablas(TB_DETALLE_TRASLADO);
    }

    private Object[] MONTAR_TRASLADO(int opcion) {
        Object[] key = new Object[10];
        PuntoEntregaDAO puntodao = new PuntoEntregaDAO();
        if (opcion == 0) {
            key[0] = 0;
            key[9] = 0;
        }
        if (opcion == 1) {
            key[0] = 1;
            key[9] = 0;
        }
        if (opcion == 2) {
            key[0] = 2;
            key[9] = id_detalletraslado;
        }

        key[1] = "'" + txtnumtraslado.getText() + "'";
        key[2] = "'" + edicion.formatearFechaSQL(JD_FechaEmision.getDate()) + "'";
        key[3] = puntodao.read(comboOrigen.getSelectedItem()).getIdpunto();
        key[4] = puntodao.read(combodestino.getSelectedItem()).getIdpunto();
        key[5] = "'" + txtautoriza.getText().toUpperCase() + "'";
        key[6] = Variables_Gloabales.EMPLEADO.getIdusuario();
        key[7] = "'" + txtplu.getText() + "'";
        key[8] = edicion.toNumeroEntero(txtcantidad.getText());
        return key;
    }

}
