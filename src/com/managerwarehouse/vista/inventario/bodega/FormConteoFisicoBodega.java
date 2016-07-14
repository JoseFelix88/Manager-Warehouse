package com.managerwarehouse.vista.inventario.bodega;

import com.managerwarehouse.controlador.index.ControllerContenedor;
import com.managerwarehouse.model.inventario.ConteoFisico;
import com.managerwarehouse.model.inventario.ConteoFisicoDAO;
import com.managerwarehouse.model.inventario.DetalleConteoFisico;
import com.managerwarehouse.model.inventario.DetalleConteoFisicoDAO;
import com.managerwarehouse.model.inventario.InventarioDAO;
import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.model.producto.ProductoDTO;
import com.managerwarehouse.model.usuario_system.EmpleadoDAO;
import com.managerwarehouse.model.usuario_system.EmpleadoDTO;
import com.managerwarehouse.util.CambiaFormatoTexto;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.Variables_Gloabales;
import com.managerwarehouse.vista.producto.Formlotealmacenado;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;

public class FormConteoFisicoBodega extends javax.swing.JInternalFrame {

    ProductoDAO pdao;
    EmpleadoDAO empdao;
    ConteoFisicoDAO cfdao;
    DetalleConteoFisicoDAO dcfdao;
    Edicion edicion = new Edicion();
    ConteoFisico conteoFisico;
    DetalleConteoFisico detalleConteoFisico;
    ProductoDTO producto;
    CambiaFormatoTexto formatoTexto = new CambiaFormatoTexto();
    InventarioDAO inventario;
    
    public FormConteoFisicoBodega() {
        //Inicializar DAOs
        pdao = new ProductoDAO();
        empdao = new EmpleadoDAO();
        cfdao = new ConteoFisicoDAO();
        dcfdao = new DetalleConteoFisicoDAO();
        inventario = new InventarioDAO();
        //Inicializar POJOS
        conteoFisico = new ConteoFisico();
        detalleConteoFisico = new DetalleConteoFisico();
        producto = new ProductoDTO();

        initComponents();
        llenarcombo();

        txtconteo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                txtconteo.setText(formatoTexto.numerico(
                        edicion.toNumeroEntero(txtconteo.getText())));

            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        JM_Eliminar = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TB_conteofisico = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtconteo = new javax.swing.JTextField();
        JC_FechaVence = new com.toedter.calendar.JDateChooser();
        txtnumlote = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        txtreferencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboresponsable = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_trazaTotalizada = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtnum_conteo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JC_FechaInicio = new com.toedter.calendar.JDateChooser();
        JC_FechaFinal = new com.toedter.calendar.JDateChooser();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        JM_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/Qx9 Vista Bin2 Full.png"))); // NOI18N
        JM_Eliminar.setText("ELIMINAR");
        JM_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_EliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(JM_Eliminar);

        setClosable(true);
        setIconifiable(true);
        setTitle("Conteo Fisico - Bodega");

        TB_conteofisico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Plu", "Referencia", "Descripción", "No. Lote", "F.V", "Conteo Fisico", "RESPONSABLE", "ID. detalle conteo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TB_conteofisico.setComponentPopupMenu(jPopupMenu1);
        TB_conteofisico.setRowHeight(22);
        TB_conteofisico.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TB_conteofisico);
        if (TB_conteofisico.getColumnModel().getColumnCount() > 0) {
            TB_conteofisico.getColumnModel().getColumn(0).setMaxWidth(50);
            TB_conteofisico.getColumnModel().getColumn(2).setMinWidth(200);
            TB_conteofisico.getColumnModel().getColumn(4).setMaxWidth(70);
            TB_conteofisico.getColumnModel().getColumn(5).setMaxWidth(90);
            TB_conteofisico.getColumnModel().getColumn(7).setMaxWidth(45);
        }

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REFERENCIA");

        jLabel6.setText("DESCRIPCIÓN");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("No. LOTE");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("F.V");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CONTEO FISICO");

        txtconteo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtconteo.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtconteo.setText("0");
        txtconteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconteoActionPerformed(evt);
            }
        });

        JC_FechaVence.setDateFormatString("MM-yyyy");

        txtdescripcion.setEditable(false);

        txtreferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtreferenciaActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RESPONSABLE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 112, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnumlote, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JC_FechaVence, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(comboresponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addComponent(jLabel6)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtconteo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(183, 183, 183))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtconteo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnumlote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboresponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(JC_FechaVence, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("Conteo Fisico", jPanel3);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Plu", "Referencia", "Descripción", "No. Lote", "Inv. Inicial", "Compras", "Dv. Punto", "Salidas", "Dv. Proveedor", "Sal. Autorizada", "Inv. Final", "Inv. Fisico", "Sobrante", "Faltante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(22);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMaxWidth(75);
            jTable2.getColumnModel().getColumn(1).setMinWidth(110);
            jTable2.getColumnModel().getColumn(2).setMinWidth(250);
            jTable2.getColumnModel().getColumn(3).setMinWidth(120);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1089, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Trazabilidad", jPanel2);

        TB_trazaTotalizada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PLU", "DESCRIPCIÓN", "Inv. Inicial", "Compras", "DV. Punto", "Salidas", "Sal. Autorizada", "Saldo Sistema", "Saldo Fisico", "Diferencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TB_trazaTotalizada.setRowHeight(22);
        TB_trazaTotalizada.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TB_trazaTotalizada);
        if (TB_trazaTotalizada.getColumnModel().getColumnCount() > 0) {
            TB_trazaTotalizada.getColumnModel().getColumn(0).setMaxWidth(50);
            TB_trazaTotalizada.getColumnModel().getColumn(1).setMinWidth(300);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Totalizar Conteo", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("No. Conteo");

        txtnum_conteo.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jLabel1.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTEO FISICO");

        JC_FechaInicio.setDateFormatString("EEE, dd MMM yyyy");

        JC_FechaFinal.setDateFormatString("EEE, dd MMM yyyy");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtnum_conteo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(JC_FechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JC_FechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnum_conteo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JC_FechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JC_FechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/nuevo-archivo-de-documento-escrito-en-papel-pluma-icono-3934-32.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/investigacion-icono-8491-48.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Refresh.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/informes.png"))); // NOI18N
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/liberacion-de-la-puerta-icono-9156-48.png"))); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(226, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtreferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreferenciaActionPerformed
        // TODO add your handling code here:
        producto = pdao.read(txtreferencia.getText());

        if (producto != null) {
            JInternalFrame ji = validador.getJInternalFrame(Formlotealmacenado.class.getName());
            if (ji == null || ji.isClosed()) {
                ji = new Formlotealmacenado(this);
                ControllerContenedor.getjDesktopPane1().add(ji, 0);
                validador.addJIframe(Formlotealmacenado.class.getName(), ji);
                ji.setVisible(true);
            } else {
                ji.show(true);
                try {
                    ji.setIcon(false);
                } catch (PropertyVetoException ex) {

                }
            }
        } else {
            edicion.mensajes(1, "la referencia del producto nose encuentra registrada.");
        }
    }//GEN-LAST:event_txtreferenciaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtconteoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconteoActionPerformed
        // TODO add your handling code here:
        if (validarformulario() != false) {
            if (cfdao.read(txtnum_conteo.getText()) == null) {
                cfdao.create(seteaencabezado());
                dcfdao.create(seteardetalle());
            } else {

                dcfdao.create(seteardetalle());
            }
            edicion.llenarTabla(TB_conteofisico, dcfdao.listar_detalle_Conteo(txtnum_conteo.getText()));
            limpiadoparcial();
        }
    }//GEN-LAST:event_txtconteoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            Object numconteo = edicion.msjQuest(2, "ingresa el numero del conteo.");
            conteoFisico = cfdao.read(numconteo);
            if (conteoFisico != null) {
                txtnum_conteo.setText(numconteo.toString());
                JC_FechaInicio.setDate(conteoFisico.getFechainicio());
                JC_FechaFinal.setDate(conteoFisico.getFechafinal());
                edicion.llenarTabla(TB_conteofisico, dcfdao.listar_detalle_Conteo(numconteo));
            } else {
                edicion.mensajes(1, "el numero de conteo '" + numconteo.toString() + "' no se encuentra registrado.");
            }
        } catch (Exception e) {
            System.out.println("Error en el numero del conteo: "+e);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void JM_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_EliminarActionPerformed
        // TODO add your handling code here:
        int row = TB_conteofisico.getSelectedRow();
        int Eliminar = (int) edicion.msjQuest(1, "estas seguro que deseas eliminar el producto?");
        if (Eliminar == 0) {
            dcfdao.delete(TB_conteofisico.getValueAt(row, 7));
            edicion.menu_emergente(TB_conteofisico);
            if (TB_conteofisico.getRowCount() < 1) {
                cfdao.delete(txtnum_conteo.getText());
            }
        }

    }//GEN-LAST:event_JM_EliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        llenarcombo();
        JC_FechaInicio.setDate(null);
        JC_FechaFinal.setDate(null);
        edicion.limpiar_tablas(TB_conteofisico);
        edicion.limpiar_tablas(TB_trazaTotalizada);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Object[] key = {edicion.formatearFechaSQL(JC_FechaInicio.getDate()), edicion.formatearFechaSQL(JC_FechaFinal.getDate())};
        edicion.llenarTabla(TB_trazaTotalizada, inventario.Trazabilidad_por_Producto_Bodega(key));
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JC_FechaFinal;
    private com.toedter.calendar.JDateChooser JC_FechaInicio;
    public com.toedter.calendar.JDateChooser JC_FechaVence;
    private javax.swing.JMenuItem JM_Eliminar;
    public javax.swing.JTable TB_conteofisico;
    private javax.swing.JTable TB_trazaTotalizada;
    private javax.swing.JComboBox comboresponsable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JTextField txtconteo;
    public javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtnum_conteo;
    public javax.swing.JTextField txtnumlote;
    public javax.swing.JTextField txtreferencia;
    // End of variables declaration//GEN-END:variables

    private void llenarcombo() {
        comboresponsable.removeAllItems();
        comboresponsable.addItem("");
        for (EmpleadoDTO cargarOperadore : empdao.cargarOperadores()) {
            comboresponsable.addItem(cargarOperadore.getPassword());
        }
        txtnum_conteo.setText(String.valueOf(edicion.toNumeroEntero(cfdao.SiguienteConteo().toString())));
    }

    private ConteoFisico seteaencabezado() {
        return new ConteoFisico(edicion.toNumeroEntero(txtnum_conteo.getText()), JC_FechaInicio.getDate(),
                JC_FechaFinal.getDate(), Variables_Gloabales.EMPLEADO.getIdusuario(), null);
    }

    private DetalleConteoFisico seteardetalle() {
        detalleConteoFisico.setResponsable(comboresponsable.getSelectedItem().toString());
        detalleConteoFisico.setConteoFisico(cfdao.read(txtnum_conteo.getText()));
        detalleConteoFisico.setProducto(pdao.read(txtreferencia.getText()));
        detalleConteoFisico.setCantidadcontada(edicion.toNumeroEntero(txtconteo.getText().replace(".", "")));
        detalleConteoFisico.setLote(txtnumlote.getText());
        detalleConteoFisico.setFechavence(JC_FechaVence.getDate());
        return detalleConteoFisico;
    }

    private boolean validarformulario() {
        if (JC_FechaInicio.getDate() == null) {
            edicion.mensajes(1, "seleccione la fecha de Inicio del conteo");
            return false;
        }
        if (JC_FechaFinal.getDate() == null) {
            edicion.mensajes(1, "seleccione la fecha de finalizacion del conteo");
            return false;
        }
        if ("".equals(txtnumlote.getText())) {
            edicion.mensajes(1, "ingresa el No de lote.");
            return false;
        }
        if (JC_FechaVence.getDate() == null) {
            edicion.mensajes(1, "selecciona la fecha de vencimiento del lote.");
            return false;
        }
        if (comboresponsable.getSelectedItem().equals("")) {
            edicion.mensajes(1, "por favor selecciona el responsable del conteo.");
            comboresponsable.grabFocus();
            return false;
        }
        if (edicion.toNumeroEntero(txtconteo.getText()) < 1) {
            edicion.mensajes(1, "el conteo fisico del lote debe ser mayor a cero (0).");
            txtconteo.selectAll();
            txtconteo.requestFocus();
            return false;
        }
        return true;
    }

    private void limpiadoparcial() {
        txtreferencia.setText(null);
        txtconteo.setText("0");
        txtdescripcion.setText(null);
        txtnumlote.setText(null);
        JC_FechaVence.setDate(null);
        comboresponsable.setSelectedItem("");
        txtreferencia.selectAll();
        txtreferencia.requestFocus();
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
