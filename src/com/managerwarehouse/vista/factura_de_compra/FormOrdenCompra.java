package com.managerwarehouse.vista.factura_de_compra;

import com.managerwarehouse.model.factura_de_compra.Orden_de_Compra;
import com.managerwarehouse.model.factura_de_compra.Orden_de_CompraDAO;
import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.model.producto.ProductoDTO;
import com.managerwarehouse.model.proveedor.ProveedorDAO;
import com.managerwarehouse.model.proveedor.ProveedorDTO;
import com.managerwarehouse.util.CambiaFormatoTexto;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.Variables_Gloabales;
import com.managerwarehouse.util.reportes.GenerarReporte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFileChooser;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class FormOrdenCompra extends javax.swing.JInternalFrame {

    Edicion edicion = new Edicion();
    ProveedorDAO proveedorDAO;
    ProductoDAO productoDAO;
    Orden_de_CompraDAO compraDAO;
    Orden_de_Compra compra;

    GenerarReporte gr = new GenerarReporte();

    public FormOrdenCompra() {
        proveedorDAO = new ProveedorDAO();
        productoDAO = new ProductoDAO();
        compraDAO = new Orden_de_CompraDAO();
        compra = new Orden_de_Compra();
        initComponents();
        llenarcombo();
        AutoCompleteDecorator.decorate(combodescripcion);
        combodescripcion.getEditor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtprecio.setText("$ 0");
                consultaproducto();

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnumorden = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboproveedor = new javax.swing.JComboBox();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtplu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        combodescripcion = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtstockactual = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtprecioventa = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_DetalleOrden = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TB_historial = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TB_detalleCarritoCompra = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        LBproductos = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/Qx9 Vista Bin2 Full.png"))); // NOI18N
        jMenuItem1.setText("ELIMINAR");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/Qx9 Vista Bin2 Full.png"))); // NOI18N
        jMenuItem2.setText("ELIMINAR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        setClosable(true);
        setIconifiable(true);
        setTitle("Orden de Compra");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("No. de Oferta");

        txtnumorden.setEditable(false);
        txtnumorden.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("PROVEEDOR");

        comboproveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboproveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproveedorItemStateChanged(evt);
            }
        });

        jToolBar1.setRollover(true);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/nuevo-archivo-de-documento-escrito-en-papel-pluma-icono-3934-32.png"))); // NOI18N
        jButton1.setToolTipText("Nuevo");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton4.setBackground(new java.awt.Color(102, 153, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/compras-icono-7322-32.png"))); // NOI18N
        jButton4.setToolTipText("Agregar al Carrito de Compras");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setBackground(new java.awt.Color(102, 153, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/la-unidad-monetaria-de-efectivo-en-dolares-icono-5184-32.png"))); // NOI18N
        jButton5.setToolTipText("Orden de Pedido Valorizada");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton3.setBackground(new java.awt.Color(102, 153, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/liberacion-de-la-puerta-icono-9156-32.png"))); // NOI18N
        jButton3.setToolTipText("Salir");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ORDEN DE COMPRA");

        jPanel3.setBackground(new java.awt.Color(204, 51, 0));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PLU");

        txtplu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtplu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpluActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DESCRIPCIÓN");

        combodescripcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combodescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combodescripcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtplu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(111, 111, 111))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combodescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtplu)
                    .addComponent(combodescripcion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setText("PRECIO/OFERTA");

        txtprecio.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtprecio.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtprecio.setText("$ 0");
        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("STOCK ACTUAL:");

        txtstockactual.setEditable(false);
        txtstockactual.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtstockactual.setForeground(new java.awt.Color(204, 0, 0));
        txtstockactual.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtstockactual.setText("0");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("$ DE VENTA");

        txtprecioventa.setEditable(false);
        txtprecioventa.setBackground(new java.awt.Color(102, 102, 255));
        txtprecioventa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtprecioventa.setForeground(new java.awt.Color(255, 255, 255));
        txtprecioventa.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtprecioventa.setText("$ 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnumorden, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtprecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtstockactual, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnumorden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtstockactual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtprecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Ofertas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        TB_DetalleOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PROVEEDOR", "PRECIO/OFERTA", "F. INGRESO", "F. ACTUALIZACION", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
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
        TB_DetalleOrden.setComponentPopupMenu(jPopupMenu1);
        TB_DetalleOrden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TB_DetalleOrden.setRowHeight(25);
        TB_DetalleOrden.getTableHeader().setReorderingAllowed(false);
        TB_DetalleOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_DetalleOrdenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TB_DetalleOrden);
        if (TB_DetalleOrden.getColumnModel().getColumnCount() > 0) {
            TB_DetalleOrden.getColumnModel().getColumn(0).setMinWidth(140);
            TB_DetalleOrden.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Historial de Compras", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        TB_historial.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        TB_historial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PROVEEDOR", "COSTO UND", "F. ENTRADA", "UNDs. COMPRADA", "TOTAL COMPRA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TB_historial.setRowHeight(22);
        TB_historial.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TB_historial);
        if (TB_historial.getColumnModel().getColumnCount() > 0) {
            TB_historial.getColumnModel().getColumn(0).setMinWidth(150);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carrito de Compras", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        jLabel7.setText("SUB-TOTAL");

        txtsubtotal.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtsubtotal.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtsubtotal.setText("$ 0");

        TB_detalleCarritoCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "PLU", "DESCRIPCION", "CANT. PEDIDA", "COSTO UND", "TOTAL COMPRA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TB_detalleCarritoCompra.setComponentPopupMenu(jPopupMenu2);
        TB_detalleCarritoCompra.setRowHeight(22);
        jScrollPane4.setViewportView(TB_detalleCarritoCompra);
        if (TB_detalleCarritoCompra.getColumnModel().getColumnCount() > 0) {
            TB_detalleCarritoCompra.getColumnModel().getColumn(0).setMaxWidth(40);
            TB_detalleCarritoCompra.getColumnModel().getColumn(1).setMaxWidth(50);
            TB_detalleCarritoCompra.getColumnModel().getColumn(2).setMinWidth(150);
        }

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("PRODUCTOS AGREGADOS");

        LBproductos.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        LBproductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBproductos.setText("0");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cerrar.png"))); // NOI18N
        jButton6.setText("Cerrar Carro");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/imprimir-icono-3650-32.png"))); // NOI18N
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setLabel("Imprimir Pedido");
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/PDF File.png"))); // NOI18N
        jButton8.setToolTipText("Guardar Pedido Como PDF");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LBproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jButton6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBproductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpluActionPerformed
        // TODO add your handling code here:
        txtprecio.setText("$ 0");
        ProductoDTO dTO = productoDAO.read(txtplu.getText());
        CambiaFormatoTexto ft = new CambiaFormatoTexto();
        if (dTO != null) {
            cargarlista();
            combodescripcion.setSelectedItem(dTO.getDescripcion());
            txtstockactual.setText(ft.numerico(dTO.getCantidadActual()));
            txtprecioventa.setText("$ " + ft.numerico(dTO.getPrecioVenta()));
            txtprecio.selectAll();
            txtprecio.requestFocus();
        } else {
            edicion.mensajes(1, "el producto no se encuentra registrado.");

        }
    }//GEN-LAST:event_txtpluActionPerformed

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        if (validarordencompra() != false) {

            if (verificaoferta() == null) {
                if (compraDAO.gestionarOrden(0, SetearOrdenCompra()) != true) {
                    cargarlista();
                    edicion.mensajes(2, "oferta agregada a la lista.");
                    txtprecio.setText("$ " + 0);
                    txtplu.setText(null);
                    combodescripcion.setSelectedItem(null);
                    txtplu.grabFocus();
                    edicion.limpiar_tablas(TB_DetalleOrden);
                    edicion.limpiar_tablas(TB_historial);
                    txtstockactual.setText("0");
                }
            } else {
                edicion.mensajes(1, "la oferta del proveedor " + compra.getProveedor().getRazonSocial() + " "
                        + "por el producto\n" + compra.getProducto().getDescripcion() + " ya hacido agregada a la lista.");
                txtplu.selectAll();
                txtplu.requestFocus();
            }
        }
    }//GEN-LAST:event_txtprecioActionPerformed

    private void TB_DetalleOrdenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_DetalleOrdenMouseClicked
        try {
            if (evt.getClickCount() > 0) {
                CambiaFormatoTexto cft = new CambiaFormatoTexto();
                int row = TB_DetalleOrden.getSelectedRow();
                txtnumorden.setText(TB_DetalleOrden.getValueAt(row, 4).toString());
                comboproveedor.setSelectedItem(TB_DetalleOrden.getValueAt(row, 0).toString());
                txtprecio.setText("$ " + cft.numerico(TB_DetalleOrden.getValueAt(row, 1).toString()));
            }
        } catch (Exception e) {
            System.out.println("error al cargar campos: " + e);
        }

    }//GEN-LAST:event_TB_DetalleOrdenMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        llenarcombo();
        txtplu.setText(null);
        combodescripcion.setSelectedItem(null);
        txtprecio.setText("$ " + 0);
        txtprecioventa.setText("$ " + 0);
        edicion.limpiar_tablas(TB_DetalleOrden);
        edicion.limpiar_tablas(TB_historial);
        edicion.limpiar_tablas(TB_detalleCarritoCompra);
        txtplu.grabFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void comboproveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproveedorItemStateChanged
        if (comboproveedor.getSelectedItem() != null) {
            cargarcarritocompra();
            txtplu.selectAll();
            txtplu.requestFocus();
        }
    }//GEN-LAST:event_comboproveedorItemStateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int CONFIRMAR = (int) edicion.msjQuest(1, "esta seguro que desea eliminar la oferta?");
        if (CONFIRMAR == 0) {
            if (compraDAO.gestionarOrden(3, SetearOrdenCompra()) != true) {
                edicion.menu_emergente(TB_DetalleOrden);
                edicion.mensajes(2, "oferta eliminada correctamente.");
                cargarlista();
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (validarordencompra() != false) {
            Object cantidadpedida = edicion.msjQuest(2, "ingresa la cantidad pedida.");
            if (cantidadpedida != null) {
                compra.setCantidadPedida(edicion.toNumeroEntero(cantidadpedida.toString()));
                compra.setProveedor(proveedorDAO.read(comboproveedor.getSelectedItem()));
                compra.setProducto(productoDAO.read(txtplu.getText()));
                compra.setPrecio(edicion.toNumeroEntero(txtprecio.getText()));
                if (compra.getPrecio() <= 0) {
                    edicion.mensajes(1, "por favor selecciona una oferta de la lista o ingresa un precio mayor a cero(0)");
                } else {
                    for (int i = 0; i < TB_detalleCarritoCompra.getRowCount(); i++) {
                        Object codproducto = TB_detalleCarritoCompra.getValueAt(i, 1);
                        if (codproducto.equals(compra.getProducto().getPlu())) {
                            edicion.mensajes(1, "el producto " + compra.getProducto().getDescripcion() + " se encuentra agregado al carro de compras.");
                            return;
                        }
                    }
                    if (compraDAO.GestionarCarritoCompra(0, compra) != true) {
                        cargarcarritocompra();
                        txtprecio.setText("$ 0");
                        edicion.mensajes(2, "producto agregado al carrito correctamente.");
                    }
                }
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int CONFIRMAR = (int) edicion.msjQuest(1, "esta seguro que desea eliminar el producto del carrito?");
        int row = TB_detalleCarritoCompra.getSelectedRow();
        if (CONFIRMAR == 0) {
            compra.setIddetallecompra(edicion.toNumeroEntero(TB_detalleCarritoCompra.getValueAt(row, 0).toString()));
            compra.setCantidadPedida(edicion.toNumeroEntero(TB_detalleCarritoCompra.getValueAt(row, 3).toString()));
            compra.setPrecio(edicion.toNumeroEntero(TB_detalleCarritoCompra.getValueAt(row, 4).toString()));
            compra.setProducto(productoDAO.read(TB_detalleCarritoCompra.getValueAt(row, 1)));
            if (compraDAO.GestionarCarritoCompra(1, compra) != true) {
                edicion.mensajes(2, "producto eliminado del carrito.");
                edicion.menu_emergente(TB_detalleCarritoCompra);
                cargarcarritocompra();
                if (TB_detalleCarritoCompra.getRowCount() < 1) {
                    compraDAO.BORRAR_ORDEN_DE_COMPRA(proveedorDAO.read(comboproveedor.getSelectedItem()).getIdproveedor());
                }
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int SI_NO = (int) edicion.msjQuest(1, "estas seguro que deseas cerrar el carro de compras?");
        if (SI_NO == 0) {
            compra.setIddetallecompra(0);
            compra.setCantidadPedida(0);
            compra.setPrecio(0);
            compra.setProducto(new ProductoDTO());
            compra.setProveedor(proveedorDAO.read(comboproveedor.getSelectedItem()));
            if (compraDAO.GestionarCarritoCompra(2, compra) != true) {
                edicion.mensajes(2, "carrito cerrado correctamente");
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (validarCarroCompra() != false) {
            gr.pedido_proveedor(proveedorDAO.read(comboproveedor.getSelectedItem()).getIdproveedor());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (validarCarroCompra() != false) {
            JFileChooser jfc = new JFileChooser();
            Calendar c = new GregorianCalendar();
            int anio = c.get(Calendar.YEAR);
            int mes = c.get(Calendar.MONTH);
            ProveedorDTO pdto = proveedorDAO.read(comboproveedor.getSelectedItem());
            gr.NOMBRE_DEL_ARCHIVO_EXPORTADO = "ORDEN DE PEDIDO No. "
                    + "" + compraDAO.numerodeordenpedidoproveedor(pdto.getIdproveedor()) + " - " + comboproveedor.getSelectedItem();
            gr.NOMBRE_REPORTE = "Compras/Pedido Proveedor.jasper";
            gr.DIRECTORIO_POR_DEFECTO = jfc.getCurrentDirectory().getPath() + "/PEDIDOS PROVEEDORES/" + anio + "/" + edicion.mesDeFecha(mes) + "/" + comboproveedor.getSelectedItem() + "/";
            gr.PARAMETROS.put("proveedor", pdto.getIdproveedor());
            gr.PARAMETROS.put("userlogin", Variables_Gloabales.EMPLEADO.getNombreCompleto());

            gr.Exportar();
        }
        /*
         HABILITAR OPCIÓN PARA GUARDAR DONDE SE REQUIERA.
         int opcion = jfc.showSaveDialog(this);
         if (opcion == JFileChooser.APPROVE_OPTION) {
         System.out.println(JFileChooser.APPROVE_OPTION);
         }*/
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (validarCarroCompra() != false) {
            gr.ORDEN_DE_PEDIDO_PROVEEDOR_CON_PRECIO(proveedorDAO.read(comboproveedor.getSelectedItem()).getIdproveedor());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void combodescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combodescripcionActionPerformed

    }//GEN-LAST:event_combodescripcionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBproductos;
    private javax.swing.JTable TB_DetalleOrden;
    private javax.swing.JTable TB_detalleCarritoCompra;
    private javax.swing.JTable TB_historial;
    private javax.swing.JComboBox combodescripcion;
    private javax.swing.JComboBox comboproveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtnumorden;
    private javax.swing.JTextField txtplu;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtprecioventa;
    private javax.swing.JTextField txtstockactual;
    private javax.swing.JTextField txtsubtotal;
    // End of variables declaration//GEN-END:variables

    private void llenarcombo() {
        combodescripcion.removeAllItems();
        combodescripcion.addItem("");
        comboproveedor.removeAllItems();
        comboproveedor.addItem(null);
        for (ProveedorDTO proveedor : proveedorDAO.readAll()) {
            comboproveedor.addItem(proveedor.getRazonSocial());
        }
        for (ProductoDTO pdto : productoDAO.readAll()) {
            combodescripcion.addItem(pdto.getDescripcion());
        }
        txtnumorden.setText(compraDAO.numeroOrdenCompra().toString());
    }

    private Orden_de_Compra SetearOrdenCompra() {
        return compra = new Orden_de_Compra(edicion.toNumeroEntero(txtnumorden.getText()),
                proveedorDAO.read(comboproveedor.getSelectedItem()), productoDAO.read(txtplu.getText()),
                edicion.toNumeroEntero(txtprecio.getText()), 0, null, null);
    }

    private boolean validarordencompra() {
        if (comboproveedor.getSelectedItem() == null) {
            edicion.mensajes(1, "por favor selecciona un proveedor.");
            return false;
        }
        if ("".equals(txtplu.getText())) {
            edicion.mensajes(1, "ingresa el codigo del producto.");
            return false;
        }
        if (edicion.toNumeroEntero(txtprecio.getText()) < 1) {
            edicion.mensajes(1, "el precio u oferta debe ser mayor a cero (0)");
            return false;
        }
        return true;
    }

    private void cargarlista() {

        Object[][] rs_oferta = compraDAO.listarOrdenesRegistradas(txtplu.getText());
        Object[][] rs_historial = compraDAO.historialDeCompras(txtplu.getText());
        if (rs_historial != null) {
            edicion.llenarTabla(TB_historial, rs_historial);
        } else {
            edicion.limpiar_tablas(TB_historial);
        }
        if (rs_oferta != null) {
            edicion.llenarTabla(TB_DetalleOrden, rs_oferta);
            txtnumorden.setText(compraDAO.numeroOrdenCompra().toString());
        } else {
            edicion.limpiar_tablas(TB_DetalleOrden);
        }
    }

    private Object verificaoferta() {
        compra = SetearOrdenCompra();
        Object[] key = {compra.getProveedor().getIdproveedor(), compra.getProducto().getPlu()};
        Orden_de_Compra dao = compraDAO.consultaordencompra(key);
        return dao;
    }

    private void cargarcarritocompra() {
        edicion.limpiar_tablas(TB_detalleCarritoCompra);
        compra.setProveedor(proveedorDAO.read(comboproveedor.getSelectedItem()));
        edicion.llenarTabla(TB_detalleCarritoCompra, compraDAO.DetalleCarritoCompra(compra.getProveedor().getIdproveedor()));
        edicion.calcula_total(TB_detalleCarritoCompra, LBproductos, txtsubtotal, 5);
    }

    private boolean validarCarroCompra() {
        if (comboproveedor.getSelectedItem() == null) {
            edicion.mensajes(1, "por favor seleccione un proveedor.");
            return false;
        }
        if (TB_detalleCarritoCompra.getRowCount() <= 0) {
            edicion.mensajes(1, "el carro de compras esta vacio.");
            return false;
        }
        return true;
    }

    private void consultaproducto() {
        ProductoDTO dTO = productoDAO.read(combodescripcion.getSelectedItem());
        CambiaFormatoTexto ft = new CambiaFormatoTexto();
        if (dTO != null) {
            txtplu.setText(dTO.getPlu());
            txtstockactual.setText(ft.numerico(dTO.getCantidadActual()));
            txtprecioventa.setText("$ " + ft.numerico(dTO.getPrecioVenta()));
            txtprecio.selectAll();
            txtprecio.requestFocus();
            cargarlista();
        }
    }
}
