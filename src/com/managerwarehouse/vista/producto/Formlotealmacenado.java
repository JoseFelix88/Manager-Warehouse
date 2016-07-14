package com.managerwarehouse.vista.producto;

import com.managerwarehouse.model.inventario.Lotealmacenado;
import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.model.producto.ProductoDTO;
import com.managerwarehouse.util.CambiaFormatoTexto;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.reportes.GenerarReporte;
import com.managerwarehouse.vista.inventario.bodega.FormConteoFisicoBodega;
import com.managerwarehouse.vista.producto.devoluciones.FormDevolucionPunto;
import com.managerwarehouse.vista.producto.devoluciones.proveedor.FormDevolucionProveedor;
import com.managerwarehouse.vista.salidas_producto.FormSalidasProducto;
import com.managerwarehouse.vista.salidas_producto.autorizada.FormSalidasAutorizada;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;

public class Formlotealmacenado extends javax.swing.JInternalFrame {

    ProductoDAO dAO;
    ProductoDTO dTO;
    CambiaFormatoTexto formatoTexto = new CambiaFormatoTexto();
    FormSalidasProducto formrsalidaproducto;
    FormSalidasAutorizada formSalidasAutorizada;
    FormConteoFisicoBodega formInventarioBodega;
    FormDevolucionProveedor formDevolucionProveedor;

    public Formlotealmacenado(FormDevolucionProveedor formDevolucionProveedor) {
        this.formDevolucionProveedor = formDevolucionProveedor;
        initComponents();

        accionesFormulario();
    }

    public Formlotealmacenado(FormConteoFisicoBodega formInventarioBodega) {
        this.formInventarioBodega = formInventarioBodega;
        initComponents();

        accionesFormulario();
    }

    public Formlotealmacenado(FormSalidasProducto producto) {
        this.formrsalidaproducto = producto;
        initComponents();
        accionesFormulario();
    }

    public Formlotealmacenado(FormSalidasAutorizada producto) {
        this.formSalidasAutorizada = producto;
        initComponents();
        accionesFormulario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtdescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_lotes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtstocktotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lb_cantlotes = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtpresentacion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtplu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtreferencia = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Lotes - Producto");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtdescripcion.setEditable(false);
        txtdescripcion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        TB_lotes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        TB_lotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID. Lote", "Referencia", "Lote No.", "Fecha Vence", "Stock Actual"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TB_lotes.setRowHeight(25);
        TB_lotes.getTableHeader().setReorderingAllowed(false);
        TB_lotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_lotesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TB_lotes);
        if (TB_lotes.getColumnModel().getColumnCount() > 0) {
            TB_lotes.getColumnModel().getColumn(0).setMaxWidth(50);
            TB_lotes.getColumnModel().getColumn(1).setMinWidth(150);
        }

        jLabel3.setText("STOCK TOTAL:");

        txtstocktotal.setEditable(false);
        txtstocktotal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtstocktotal.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtstocktotal.setText("0");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("PARA SELECCIONAR UN LOTE POR FAVOR HAGA DOBLE CLICK.");

        lb_cantlotes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lb_cantlotes.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_cantlotes.setText("0");

        jLabel2.setText("CANTIDAD DE LOTES");

        txtpresentacion.setColumns(20);
        txtpresentacion.setLineWrap(true);
        txtpresentacion.setRows(5);
        jScrollPane2.setViewportView(txtpresentacion);

        jLabel5.setText("PLU");

        jLabel6.setText("DESCRIPCION");

        jLabel7.setText("PRESENTACION DE LA REFERENCIA SELECCIONADA");

        txtplu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpluActionPerformed(evt);
            }
        });

        jLabel8.setText("REFERENCIA");

        txtreferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtreferenciaActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cerrar.png"))); // NOI18N
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/imprimir-icono-3650-32.png"))); // NOI18N
        jButton2.setText("Imprimir Lotes Almacenados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtstocktotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_cantlotes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(188, 188, 188)
                        .addComponent(jLabel6)
                        .addGap(201, 201, 201))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtreferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtplu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtplu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_cantlotes, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtstocktotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jLabel1.setText("LOTES ALMACENADOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpluActionPerformed
        // TODO add your handling code here:
        dTO = dAO.read(txtplu.getText());
        if (dTO != null) {
            CargarLotes(dTO.getPlu());
            txtdescripcion.setText(dTO.getDescripcion());
        }
    }//GEN-LAST:event_txtpluActionPerformed

    private void TB_lotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_lotesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            int row = TB_lotes.getSelectedRow();
            dTO = dAO.read(TB_lotes.getValueAt(row, 1));
            if (dTO != null) {
                txtplu.setText(dTO.getPlu());
                txtdescripcion.setText(dTO.getDescripcion());
                txtpresentacion.setText(dTO.getPresentacion());
                txtreferencia.setText(dTO.getCodigobarras());
            }
        }

        if (evt.getClickCount() == 2) {
            int row = TB_lotes.getSelectedRow();
            Lotealmacenado lote = new Lotealmacenado();
            lote.setCodigoProducto(TB_lotes.getValueAt(row, 1).toString());
            lote.setNumerolote(TB_lotes.getValueAt(row, 2).toString());
            lote.setFecha_vencimiento(edicion.CambiarTipoFecha(TB_lotes.getValueAt(row, 3)));
            lote.setStocklote(Integer.parseInt(TB_lotes.getValueAt(row, 4).toString()));
            if (formrsalidaproducto != null) {
                formrsalidaproducto.idLote = Integer.parseInt(TB_lotes.getValueAt(row, 0).toString());
                formrsalidaproducto.txtreferencia.setText(lote.getCodigoProducto());
                formrsalidaproducto.txtplu.setText(txtplu.getText());
                formrsalidaproducto.txtdescripcion.setText(txtdescripcion.getText());
                formrsalidaproducto.txtlote.setText(lote.getNumerolote());
                formrsalidaproducto.JDfechavence.setDate(Date.valueOf(TB_lotes.getValueAt(row, 3).toString()));
                formrsalidaproducto.txtstocklote.setText(formatoTexto.numerico(lote.getStocklote()));
                formrsalidaproducto.txtcantdespacho.selectAll();
                formrsalidaproducto.txtcantdespacho.requestFocus();
            }

            if (formSalidasAutorizada != null) {
                formSalidasAutorizada.txtreferencia.setText(lote.getCodigoProducto());
                formSalidasAutorizada.txtplu.setText(txtplu.getText());
                formSalidasAutorizada.txtdescripcion.setText(txtdescripcion.getText());
                formSalidasAutorizada.txtlote.setText(lote.getNumerolote());
                formSalidasAutorizada.JDfechavence.setDate(Date.valueOf(TB_lotes.getValueAt(row, 3).toString()));
                formSalidasAutorizada.txtstocklote.setText(String.valueOf(lote.getStocklote()));
                formSalidasAutorizada.txtcantdevuelta.selectAll();
                formSalidasAutorizada.txtcantdevuelta.requestFocus();
            }
            if (formInventarioBodega != null) {
                formInventarioBodega.txtreferencia.setText(lote.getCodigoProducto());
                formInventarioBodega.txtdescripcion.setText(txtdescripcion.getText());
                formInventarioBodega.txtnumlote.setText(lote.getNumerolote());
                formInventarioBodega.JC_FechaVence.setDate(Date.valueOf(TB_lotes.getValueAt(row, 3).toString()));
                formInventarioBodega.txtconteo.selectAll();
                formInventarioBodega.txtconteo.requestFocus();
            }

            if (formDevolucionProveedor != null) {
                formDevolucionProveedor.idLote = Integer.parseInt(TB_lotes.getValueAt(row, 0).toString());
                formDevolucionProveedor.txtreferencia.setText(lote.getCodigoProducto());
                formDevolucionProveedor.txtplu.setText(txtplu.getText());
                formDevolucionProveedor.txtdescripcion.setText(txtdescripcion.getText());
                formDevolucionProveedor.txtlote.setText(lote.getNumerolote());
                formDevolucionProveedor.JDfechavence.setDate(Date.valueOf(TB_lotes.getValueAt(row, 3).toString()));
                formDevolucionProveedor.txtstocklote.setText(String.valueOf(lote.getStocklote()));
                formDevolucionProveedor.txtcantdevuelta.selectAll();
                formDevolucionProveedor.txtcantdevuelta.requestFocus();
            }

            dispose();
        }
    }//GEN-LAST:event_TB_lotesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtreferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreferenciaActionPerformed
        // TODO add your handling code here:
        dTO = dAO.read(txtreferencia.getText());
        if (dTO != null) {
            CargarLotes(dTO.getCodigobarras());
            txtpresentacion.setText(dTO.getPresentacion());
            txtplu.setText(dTO.getPlu());
            txtdescripcion.setText(dTO.getDescripcion());
        } else {
            edicion.mensajes(1, "la referencia no se encuentra registrada.");
        }

    }//GEN-LAST:event_txtreferenciaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        GenerarReporte reporte = new GenerarReporte();
        reporte.lotesalmacenados();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TB_lotes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_cantlotes;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtplu;
    private javax.swing.JTextArea txtpresentacion;
    public javax.swing.JTextField txtreferencia;
    private javax.swing.JTextField txtstocktotal;
    // End of variables declaration//GEN-END:variables

    Edicion edicion = new Edicion();

    private void CargarLotes(Object key) {

        if (txtreferencia.getText().isEmpty() != true | txtplu.getText().isEmpty() != true) {
            edicion.llenarTabla(TB_lotes, dAO.lotesalmacenados(key));
            edicion.calcula_total(TB_lotes, lb_cantlotes, txtstocktotal, 4);
            String stock = txtstocktotal.getText().replace("$", "");
            txtstocktotal.setText(stock);

            if (TB_lotes.getRowCount() < 1) {
                edicion.mensajes(1, "no hemos encontrado stock de lotes almacenados del producto");
            }
        }
    }

    private void accionesFormulario() {
        dTO = new ProductoDTO();
        dAO = new ProductoDAO();
        if (formDevolucionProveedor != null) {
            txtreferencia.setText(formDevolucionProveedor.txtreferencia.getText());
            CargarLotes(formDevolucionProveedor.txtreferencia.getText());
        }
        if (formrsalidaproducto != null) {
            txtreferencia.setText(formrsalidaproducto.txtreferencia.getText());
            CargarLotes(formrsalidaproducto.txtreferencia.getText());
        }
        if (formDevolucionProveedor != null) {
            txtreferencia.setText(formDevolucionProveedor.txtreferencia.getText());
            CargarLotes(formDevolucionProveedor.txtreferencia.getText());
        }
        if (formInventarioBodega != null) {
            txtreferencia.setText(formInventarioBodega.txtreferencia.getText());
            CargarLotes(formInventarioBodega.txtreferencia.getText());
        }
        if (formSalidasAutorizada != null) {
            txtreferencia.setText(formSalidasAutorizada.txtreferencia.getText());
            CargarLotes(formSalidasAutorizada.txtreferencia.getText());
        }
        txtplu.addKeyListener(new KeyListener() {
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
        });
    }
}
