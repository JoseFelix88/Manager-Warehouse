package com.managerwarehouse.vista.factura_de_compra;

import com.managerwarehouse.controlador.index.ControllerContenedor;
import com.managerwarehouse.model.factura_de_compra.FacturaCompraDAO;
import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.model.producto.ProductoDTO;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.Variables_Gloabales;
import com.managerwarehouse.util.reportes.GenerarReporte;
import com.managerwarehouse.vista.index.util.FormSeleccionarFecha;
import com.managerwarehouse.vista.producto.Formlotealmacenado;
import com.managerwarehouse.vista.salidas_producto.FormSalidasProducto;

import java.beans.PropertyVetoException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

public class Formconsultacompraproducto extends javax.swing.JInternalFrame {

    Edicion edicion = new Edicion();
    FacturaCompraDAO fcDAO;
    ProductoDAO pdao;

    public Date fechaini;
    public Date fechafin;
    
    public Formconsultacompraproducto() {
        fcDAO = new FacturaCompraDAO();
        pdao = new ProductoDAO();
        initComponents();
        if (Variables_Gloabales.EMPLEADO.getNivel() != 2) {
            jb_imprimir.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_CompraProducto = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtreferencia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtplu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jb_imprimir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtcantunds = new javax.swing.JTextField();
        txtcostototal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb_item = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtlaboratorio = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consultar Compra - Producto");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COMPRAS DE PRODUCTOS");

        TB_CompraProducto.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        TB_CompraProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Factura", "F. Factura", "F. Entrada", "Proveedor", "Cod. Referencia", "No. de Lote", "F.V", "Cant. Unds", "$ x Unds", "$ Total", "Embalaje", "No. Cajas", "$ x Caja", "Ingresado Por"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TB_CompraProducto.setRowHeight(22);
        TB_CompraProducto.getTableHeader().setReorderingAllowed(false);
        TB_CompraProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_CompraProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TB_CompraProducto);
        if (TB_CompraProducto.getColumnModel().getColumnCount() > 0) {
            TB_CompraProducto.getColumnModel().getColumn(3).setMinWidth(130);
            TB_CompraProducto.getColumnModel().getColumn(4).setMinWidth(100);
        }

        jLabel2.setText("REFERENCIA");

        txtreferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtreferenciaActionPerformed(evt);
            }
        });

        jLabel3.setText("PLU");

        txtplu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpluActionPerformed(evt);
            }
        });

        jLabel4.setText("DESCRIPCIÓN");

        txtdescripcion.setEditable(false);

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/embudo-filtrante-icono-4497-32.png"))); // NOI18N
        jButton1.setToolTipText("Filtrar");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jb_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/imprimir-icono-3650-32.png"))); // NOI18N
        jb_imprimir.setToolTipText("Imprimir");
        jb_imprimir.setFocusable(false);
        jb_imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_imprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_imprimirActionPerformed(evt);
            }
        });
        jToolBar1.add(jb_imprimir);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/salir-de-mi-perfil-icono-3964-48.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jLabel5.setText("Total Cant. Unds:");

        txtcantunds.setEditable(false);
        txtcantunds.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtcantunds.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtcantunds.setText("0");

        txtcostototal.setEditable(false);
        txtcostototal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtcostototal.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtcostototal.setText("0");

        jLabel6.setText("Costo Total");

        jLabel7.setText("ITEM:");

        lb_item.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lb_item.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_item.setText("0");

        jLabel8.setText("LABORATORIO");

        txtlaboratorio.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel2)
                .addGap(92, 92, 92)
                .addComponent(jLabel3)
                .addGap(129, 129, 129)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(191, 191, 191))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_item, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcostototal, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(txtcantunds))
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtplu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtlaboratorio))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtplu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtlaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcantunds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcostototal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_item, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtreferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreferenciaActionPerformed
        // TODO add your handling code here:
        ProductoDTO pdto = pdao.read(txtreferencia.getText());
        if (pdto != null) {
            txtdescripcion.setText(pdto.getDescripcion());
            txtplu.setText(pdto.getPlu());
            txtlaboratorio.setText(pdto.getLaboratorio());
            Object[] key = {null, txtreferencia.getText(), null, null};
            Object[][] rs = fcDAO.compras_producto(key);
            if (rs != null) {
                edicion.llenarTabla(TB_CompraProducto, rs);
                totalizarcompra();
            }
        }
    }//GEN-LAST:event_txtreferenciaActionPerformed

    private void txtpluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpluActionPerformed
        // TODO add your handling code here:
        ProductoDTO pdto = pdao.read(txtplu.getText());
        if (pdto != null) {
            txtdescripcion.setText(pdto.getDescripcion());
            txtreferencia.setText(null);
            txtlaboratorio.setText(null);
            Object[] key = {txtplu.getText(), null, null, null};
            Object[][] rs = fcDAO.compras_producto(key);
            if (rs != null) {
                edicion.llenarTabla(TB_CompraProducto, rs);
                totalizarcompra();
            }else{
                edicion.mensajes(1, "el producto "+pdto.getDescripcion()+", no registra ninguna compra.");
            }
        }
    }//GEN-LAST:event_txtpluActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FormSeleccionarFecha fsf;
        // TODO add your handling code here:
        JInternalFrame ji = validador.getJInternalFrame(Formlotealmacenado.class.getName());

        if (ji == null || ji.isClosed()) {
            ji = new FormSeleccionarFecha(this, fcDAO);
            ControllerContenedor.getjDesktopPane1().add(ji, 0);
            validador.addJIframe(Formlotealmacenado.class.getName(), ji);
            ji.setVisible(true);

        } else {

            ji.show(true);
            try {
                ji.setIcon(false);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(FormSalidasProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TB_CompraProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_CompraProductoMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            ProductoDTO pdto = pdao.read(TB_CompraProducto.getValueAt(TB_CompraProducto.getSelectedRow(), 4));
            if (pdto != null) {
                txtreferencia.setText(pdto.getCodigobarras());
                txtplu.setText(pdto.getPlu());
                txtdescripcion.setText(pdto.getDescripcion());
                txtlaboratorio.setText(pdto.getLaboratorio());
                        
            }
        }
    }//GEN-LAST:event_TB_CompraProductoMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jb_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_imprimirActionPerformed
        GenerarReporte gr = new GenerarReporte();
        Object[] key = {txtplu.getText(), txtreferencia.getText(), fechaini, fechafin};
        gr.compraproducto(key);
    }//GEN-LAST:event_jb_imprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TB_CompraProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jb_imprimir;
    public javax.swing.JLabel lb_item;
    public javax.swing.JTextField txtcantunds;
    public javax.swing.JTextField txtcostototal;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtlaboratorio;
    public javax.swing.JTextField txtplu;
    public javax.swing.JTextField txtreferencia;
    // End of variables declaration//GEN-END:variables

    private void totalizarcompra() {
        edicion.calcula_total(TB_CompraProducto, lb_item, txtcantunds, 7);
        edicion.calcula_total(TB_CompraProducto, lb_item, txtcostototal, 9);
        String replace = txtcantunds.getText().replace("$", "");
        txtcantunds.setText(replace);
        fechaini = null;
        fechafin = null;
    }
}

class validador {

    public static java.util.HashMap<String, javax.swing.JInternalFrame> jIframes = new java.util.HashMap<>();

    public static void addJIframe(String key, javax.swing.JInternalFrame jiframe) {
        jIframes.put(key, jiframe);
    }

    public static javax.swing.JInternalFrame getJInternalFrame(String key) {
        return jIframes.get(key);
    }
}
