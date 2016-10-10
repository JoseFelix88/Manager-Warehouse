/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managerwarehouse.vista.salidas_producto;

import com.managerwarehouse.controlador.index.ControllerContenedor;
import com.managerwarehouse.model.inventario.Lotealmacenado;
import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.model.puntoentrega.PuntoEntrega;
import com.managerwarehouse.model.puntoentrega.PuntoEntregaDAO;
import com.managerwarehouse.model.salida.DetalleSalida;
import com.managerwarehouse.model.salida.DetalleSalidaDAO;
import com.managerwarehouse.model.salida.Salida;
import com.managerwarehouse.model.salida.SalidaDAO;
import com.managerwarehouse.model.usuario_system.EmpleadoDAO;
import com.managerwarehouse.model.usuario_system.EmpleadoDTO;
import com.managerwarehouse.util.CambiaFormatoTexto;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.Variables_Gloabales;
import com.managerwarehouse.util.reportes.GenerarReporte;
import com.managerwarehouse.vista.producto.Formlotealmacenado;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 *
 * @author Jose Felix
 */
public class FormSalidasProducto extends javax.swing.JInternalFrame {

    Formlotealmacenado formlote;
    SalidaDAO sdao;
    DetalleSalidaDAO dsdao;
    Salida salida;
    DetalleSalida detallesalida;
    PuntoEntregaDAO puntoDao;
    CambiaFormatoTexto formatoTexto = new CambiaFormatoTexto();
    GenerarReporte reporte = new GenerarReporte();

    public FormSalidasProducto() {
        sdao = new SalidaDAO();
        salida = new Salida();
        dsdao = new DetalleSalidaDAO();
        puntoDao = new PuntoEntregaDAO();
        initComponents();
        llenarcombo();

        txtcantdespacho.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                txtcantdespacho.setText(formatoTexto.numerico(
                        edicion.toNumeroEntero(txtcantdespacho.getText())));

            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_salidasAbierta = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnumsalida = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JDfechaemision = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        combopuntoentrega = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        txtpedido = new javax.swing.JTextField();
        jToolBar2 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TB_detallesalida = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtreferencia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtplu = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtlote = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtcantdespacho = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtnumcaja = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        comboOperador = new javax.swing.JComboBox<String>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtstocklote = new javax.swing.JTextField();
        JDfechavence = new com.toedter.calendar.JDateChooser();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Minimizar.png"))); // NOI18N
        jMenuItem1.setText("ELIMINAR");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Salida - Producto");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Bodoni MT Black", 0, 24)); // NOI18N
        jLabel1.setText("SALIDAS DE PRODUCTOS");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SALIDAS ABIERTAS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Verdana", 0, 14))); // NOI18N

        TB_salidasAbierta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        TB_salidasAbierta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No. Salida", "Fecha de Emision", "Punto de Entrega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TB_salidasAbierta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TB_salidasAbierta.setRowHeight(25);
        TB_salidasAbierta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_salidasAbiertaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TB_salidasAbierta);
        if (TB_salidasAbierta.getColumnModel().getColumnCount() > 0) {
            TB_salidasAbierta.getColumnModel().getColumn(0).setMaxWidth(70);
            TB_salidasAbierta.getColumnModel().getColumn(1).setMinWidth(100);
            TB_salidasAbierta.getColumnModel().getColumn(1).setMaxWidth(85);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("No. de Salida");

        txtnumsalida.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtnumsalida.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Fecha de Emision");

        JDfechaemision.setDateFormatString("EEEE dd MMMM yyyy");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Punto de Entrega");

        combopuntoentrega.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        combopuntoentrega.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("No. de Pedido");

        txtpedido.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/nuevo-archivo-de-documento-escrito-en-papel-pluma-icono-3934-32.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/docs.png"))); // NOI18N
        jButton2.setText("Acta de Recepción");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton2);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/imprimir-icono-3650-32.png"))); // NOI18N
        jButton4.setText("Imprimir Salida");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton4);
        jToolBar2.add(jSeparator2);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/busqueda-de-grafico-circular-icono-5421-32.png"))); // NOI18N
        jButton5.setText("Consultar");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton5);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/relaciondecarga.png"))); // NOI18N
        jButton7.setText("Relacion de Carga");
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton7);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/liberacion-de-la-puerta-icono-7259-48.png"))); // NOI18N
        jButton8.setToolTipText("SALIR");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton8);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnumsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDfechaemision, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combopuntoentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnumsalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(JDfechaemision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combopuntoentrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtpedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE SALIDA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        TB_detallesalida.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        TB_detallesalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID. Salida", "Codigo de Barras", "Descripcion", "Lote No.", "Cant. Despachada", "Caja No.", "Empacado Por"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TB_detallesalida.setComponentPopupMenu(jPopupMenu1);
        TB_detallesalida.setRowHeight(25);
        TB_detallesalida.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TB_detallesalida);
        if (TB_detallesalida.getColumnModel().getColumnCount() > 0) {
            TB_detallesalida.getColumnModel().getColumn(0).setMaxWidth(60);
            TB_detallesalida.getColumnModel().getColumn(1).setMinWidth(55);
            TB_detallesalida.getColumnModel().getColumn(1).setPreferredWidth(15);
            TB_detallesalida.getColumnModel().getColumn(2).setMinWidth(300);
            TB_detallesalida.getColumnModel().getColumn(3).setMaxWidth(100);
            TB_detallesalida.getColumnModel().getColumn(4).setMaxWidth(100);
            TB_detallesalida.getColumnModel().getColumn(5).setMaxWidth(55);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CODIGO DE BARRAS");

        txtreferencia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtreferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtreferenciaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("PLU");

        txtplu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("DESCRIPCION");

        txtdescripcion.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setText("LOTE No.");

        txtlote.setEditable(false);
        txtlote.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("CANT. DESPACHADA");

        txtcantdespacho.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtcantdespacho.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtcantdespacho.setText("0");
        txtcantdespacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantdespachoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("CAJA No");

        txtnumcaja.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtnumcaja.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtnumcaja.setText("1");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ClickAqui.png"))); // NOI18N
        jButton6.setText("Cerrar Caja");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setText("EMPACADO POR");

        comboOperador.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboOperador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        comboOperador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboOperadorItemStateChanged(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("FECHA VENCIMIENTO");

        jLabel15.setText("STOCK LOTE");

        txtstocklote.setEditable(false);
        txtstocklote.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtstocklote.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtstocklote.setText("0");

        JDfechavence.setDateFormatString("MM-yyyy");
        JDfechavence.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnumcaja, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcantdespacho, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtreferencia)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtplu, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel8)
                                .addGap(161, 161, 161)
                                .addComponent(jLabel9)
                                .addGap(144, 144, 144)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(JDfechavence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtstocklote, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel15)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtplu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtstocklote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDfechavence, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnumcaja)
                        .addComponent(jButton6)
                        .addComponent(jLabel13)
                        .addComponent(comboOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txtcantdespacho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtreferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreferenciaActionPerformed
        // TODO add your handling code here:
        JInternalFrame ji = validador.getJInternalFrame(Formlotealmacenado.class.getName());

        if (ji == null || ji.isClosed()) {

            ji = formlote;
            ji = new Formlotealmacenado(this);
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

    }//GEN-LAST:event_txtreferenciaActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        reporte.ContenidoDeCaja(txtnumsalida.getText(), txtnumcaja.getText());
        txtnumcaja.setText(String.valueOf(contarcaja()));
        txtreferencia.selectAll();
        txtreferencia.requestFocus();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtcantdespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantdespachoActionPerformed
        // TODO add your handling code here:
        if (validacionforml() != false) {
            registrarSalida();
        }
    }//GEN-LAST:event_txtcantdespachoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        nuevo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TB_salidasAbiertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_salidasAbiertaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            int row = TB_salidasAbierta.getSelectedRow();
            salida = sdao.read(TB_salidasAbierta.getValueAt(row, 0));
            if (salida != null) {
                txtnumsalida.setText(String.valueOf(salida.getIdsalida()));
                txtnumcaja.setText(String.valueOf(salida.getCantcajas()));
                JDfechaemision.setDate(salida.getFechaemision());
                combopuntoentrega.setSelectedItem(salida.getPuntoentrega());
                txtpedido.setText(salida.getNumpedido());
                edicion.llenarTabla(TB_detallesalida, dsdao.listardetalle(salida.getIdsalida()));
            }

        }
    }//GEN-LAST:event_TB_salidasAbiertaMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int row = TB_detallesalida.getSelectedRow();
        int O_P = (int) edicion.msjQuest(1, "Estas seguro que deseas eliminar el producto?");

        if (O_P == 0) {

            dsdao.delete(TB_detallesalida.getValueAt(row, 0));
            edicion.menu_emergente(TB_detallesalida);

            if (TB_detallesalida.getRowCount() <= 0) {
                sdao.delete(txtnumsalida.getText());
            }
            edicion.llenarTabla(TB_salidasAbierta, sdao.SalidasAbiertas());
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void comboOperadorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboOperadorItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() > 0) {
            txtcantdespacho.selectAll();
            txtcantdespacho.requestFocus();
        }
    }//GEN-LAST:event_comboOperadorItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        reporte.Salidas_Producto(txtnumsalida.getText());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Object numsalida = edicion.msjQuest(2, "ingresa el numero de la salida.");
        salida = sdao.read(numsalida);
        if (salida != null) {
            txtnumsalida.setText(String.valueOf(salida.getIdsalida()));
            txtnumcaja.setText(String.valueOf(salida.getCantcajas()));
            JDfechaemision.setDate(salida.getFechaemision());
            combopuntoentrega.setSelectedItem(salida.getPuntoentrega());
            txtpedido.setText(salida.getNumpedido());
            edicion.llenarTabla(TB_detallesalida, dsdao.listardetalle(salida.getIdsalida()));
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int opcion = (int) edicion.msjQuest(1, "¿esta seguro que desea imprimir la relacion de carga?");
        if (opcion == 0) {
            reporte.relacion_de_carga();

        }
        int opcionII = (int) edicion.msjQuest(1, "¿los pedidos se despacharon correctamente?");
        if (opcionII == 0) {
            sdao.cerrarSalida();
            edicion.limpiar_tablas(TB_salidasAbierta);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       this.reporte.ACTA_DE_RECEPCION_PUNTO_DE_ENTREGA(txtnumsalida.getText());
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDfechaemision;
    public com.toedter.calendar.JDateChooser JDfechavence;
    private javax.swing.JTable TB_detallesalida;
    private javax.swing.JTable TB_salidasAbierta;
    public javax.swing.JComboBox<String> comboOperador;
    private javax.swing.JComboBox<String> combopuntoentrega;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar2;
    public javax.swing.JTextField txtcantdespacho;
    public javax.swing.JTextField txtdescripcion;
    public javax.swing.JTextField txtlote;
    private javax.swing.JTextField txtnumcaja;
    private javax.swing.JTextField txtnumsalida;
    private javax.swing.JTextField txtpedido;
    public javax.swing.JTextField txtplu;
    public javax.swing.JTextField txtreferencia;
    public javax.swing.JTextField txtstocklote;
    // End of variables declaration//GEN-END:variables

    private void llenarcombo() {
        txtnumsalida.setText(String.valueOf(sdao.proximasalida()));
        Calendar c = new GregorianCalendar();
        JDfechaemision.setDate(c.getTime());

        combopuntoentrega.removeAllItems();
        combopuntoentrega.addItem("");
        for (PuntoEntrega puntoEntrega : puntoDao.readAll()) {
            combopuntoentrega.addItem(puntoEntrega.getNombre());
        }
        EmpleadoDAO edao = new EmpleadoDAO();
        comboOperador.removeAllItems();
        comboOperador.addItem("");
        for (EmpleadoDTO cargarOperadore : edao.cargarOperadores()) {
            comboOperador.addItem(cargarOperadore.getPassword());
        }
        edicion.llenarTabla(TB_salidasAbierta, sdao.SalidasAbiertas());
    }

    public int idLote;
    Edicion edicion = new Edicion();

    private Salida seteardatosEncabezado() {
        salida = new Salida(edicion.toNumeroEntero(txtnumsalida.getText()), JDfechaemision.getDate(),
                combopuntoentrega.getSelectedItem().toString(), txtpedido.getText(), 0,
                Variables_Gloabales.EMPLEADO.getIdusuario(), null, 1, null);

        return salida;
    }

    private DetalleSalida setardatosDetalle() {
        detallesalida = new DetalleSalida(0, edicion.toNumeroEntero(txtnumsalida.getText()), txtreferencia.getText(),
                idLote, edicion.toNumeroEntero(txtcantdespacho.getText()), edicion.toNumeroEntero(txtnumcaja.getText()),
                comboOperador.getSelectedItem().toString());
        return detallesalida;
    }

    private void registrarSalida() {
        if (sdao.read(txtnumsalida.getText()) == null) {
            sdao.create(seteardatosEncabezado());
            dsdao.create(setardatosDetalle());
        } else {
            dsdao.create(setardatosDetalle());
        }
        limpiarparcial();
        edicion.llenarTabla(TB_detallesalida, dsdao.listardetalle(txtnumsalida.getText()));
        edicion.llenarTabla(TB_salidasAbierta, sdao.SalidasAbiertas());
    }

    private boolean validacionforml() {

        ProductoDAO pdao = new ProductoDAO();
        Lotealmacenado loteAlmacen = pdao.leerlotereferencia(txtreferencia.getText(), txtlote.getText());
        txtstocklote.setText(String.valueOf(loteAlmacen.getStocklote()));

        if (edicion.toNumeroEntero(txtcantdespacho.getText()) > loteAlmacen.getStocklote()) {
            edicion.mensajes(1, "la cantidad a despachar del lote no puede ser mayor al stock o existencia actual.");
            return false;
        }

        if ("" == comboOperador.getSelectedItem()) {
            edicion.mensajes(1, "seleccione el operador.");
            return false;
        }

        if (TB_detallesalida.getRowCount() > 0) {
            for (int i = 0; i < TB_detallesalida.getRowCount(); i++) {
                Object codigo = TB_detallesalida.getValueAt(i, 1);
                Object lote = TB_detallesalida.getValueAt(i, 3);
                Object caja = TB_detallesalida.getValueAt(i, 5);

                if (codigo.equals(txtreferencia.getText()) && lote.equals(txtlote.getText())) {
                    String msj = "el producto " + TB_detallesalida.getValueAt(i, 2) + "\n"
                            + "con lote #: " + lote + ", se encuentra ingresado y/o empacado "
                            + "en la caja #: " + caja + ".\n\n"
                            + "*NOTA: si el producto pertenece a un saldo o refuerzo por favor eliminalo y vuelve a ingresarlo.";
                    edicion.mensajes(1, msj);
                    return false;
                }
            }
        }
        if (edicion.toNumeroEntero(txtcantdespacho.getText()) < 1) {
            edicion.mensajes(1, "la cantidad despachada debe ser mayor a cero (0).");
            return false;
        }

        return true;
    }

    private void nuevo() {
        llenarcombo();
        txtnumcaja.setText("1");
        txtcantdespacho.setText("0");
        txtdescripcion.setText(null);
        txtlote.setText(null);
        txtpedido.setText(null);
        txtplu.setText(null);
        txtreferencia.setText(null);
        txtstocklote.setText("0");
        comboOperador.setSelectedItem(null);
        combopuntoentrega.setSelectedItem(null);
        JDfechavence.setDate(null);
        edicion.limpiar_tablas(TB_detallesalida);
    }

    private void limpiarparcial() {
        txtcantdespacho.setText("0");
        txtdescripcion.setText(null);
        txtlote.setText(null);
        JDfechavence.setDate(null);
        txtplu.setText(null);
        txtreferencia.setText(null);
        txtstocklote.setText("0");
//        comboOperador.setSelectedItem(null);
        txtreferencia.grabFocus();
    }

    private int contarcaja() {
        int caja = edicion.toNumeroEntero(txtnumcaja.getText());
        caja = caja + 1;
        return caja;
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
