package com.managerwarehouse.vista.salidas_producto.autorizada;

import com.managerwarehouse.controlador.index.ControllerContenedor;
import com.managerwarehouse.controlador.producto.ControllerProducto;
import com.managerwarehouse.model.inventario.Lotealmacenado;
import com.managerwarehouse.model.inventario.salidaautorizada.DetalleSalidaAutorizada;
import com.managerwarehouse.model.inventario.salidaautorizada.DetalleSalidaAutorizadaDAO;
import com.managerwarehouse.model.inventario.salidaautorizada.SalidaAutorizada;
import com.managerwarehouse.model.inventario.salidaautorizada.SalidaAutorizadaDAO;
import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.model.producto.ProductoDTO;
import com.managerwarehouse.util.CambiaFormatoTexto;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.Metodos;
import com.managerwarehouse.util.Variables_Gloabales;
import com.managerwarehouse.util.reportes.GenerarReporte;
import com.managerwarehouse.vista.index.Contenedor;
import com.managerwarehouse.vista.producto.FormAsignarCUM;
import com.managerwarehouse.vista.producto.FormListarPlu;
import com.managerwarehouse.vista.producto.FormProducto;
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
public class FormSalidasAutorizada extends javax.swing.JInternalFrame {

    Formlotealmacenado formlote;
    SalidaAutorizadaDAO sadao;
    DetalleSalidaAutorizadaDAO ddsadao;
    SalidaAutorizada salidaAutorizada;
    DetalleSalidaAutorizada dtautorizada;
    Lotealmacenado lotealmacenado;
    CambiaFormatoTexto formatoTexto = new CambiaFormatoTexto();
    GenerarReporte reporte = new GenerarReporte();
    ProductoDAO producto;

    public FormSalidasAutorizada() {
        producto = new ProductoDAO();
        sadao = new SalidaAutorizadaDAO();
        ddsadao = new DetalleSalidaAutorizadaDAO();
        lotealmacenado = new Lotealmacenado();
        
        initComponents();
        llenarcombo();
        txtcantdevuelta.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                txtcantdevuelta.setText(formatoTexto.numerico(
                        edicion.toNumeroEntero(txtcantdevuelta.getText())));

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
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnumsalida = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JDfechaemision = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtconcepto = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtautorizado = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TB_detallesalidaautorizada = new javax.swing.JTable();
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
        txtcantdevuelta = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        JDfechavence = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtstocklote = new javax.swing.JTextField();

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
        setResizable(true);
        setTitle("Salida Autorizada - Producto");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Bodoni MT Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("SALIDAS AUTORIZADAS DE PRODUCTOS");

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("No. de Salida Autorizada");

        txtnumsalida.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtnumsalida.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Fecha de Emision");

        JDfechaemision.setDateFormatString("EEEE dd MMMM yyyy");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Autorizado Por");

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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vista_style_business_and_data_icons_icons_pack_120673/articulo-icono-9036-32.png"))); // NOI18N
        jButton2.setText("Modificar");
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
        jButton4.setText("Imprimir");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Buscar.png"))); // NOI18N
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

        txtconcepto.setColumns(20);
        txtconcepto.setLineWrap(true);
        txtconcepto.setRows(5);
        jScrollPane3.setViewportView(txtconcepto);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Concepto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnumsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDfechaemision, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtautorizado, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE))))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtautorizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE SALIDA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        TB_detallesalidaautorizada.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        TB_detallesalidaautorizada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID. Salida", "Codigo de Barras", "Descripcion", "Lote No.", "F.V", "Cant. Autorizada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TB_detallesalidaautorizada.setComponentPopupMenu(jPopupMenu1);
        TB_detallesalidaautorizada.setRowHeight(25);
        TB_detallesalidaautorizada.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TB_detallesalidaautorizada);
        if (TB_detallesalidaautorizada.getColumnModel().getColumnCount() > 0) {
            TB_detallesalidaautorizada.getColumnModel().getColumn(0).setMaxWidth(60);
            TB_detallesalidaautorizada.getColumnModel().getColumn(1).setMinWidth(55);
            TB_detallesalidaautorizada.getColumnModel().getColumn(1).setPreferredWidth(15);
            TB_detallesalidaautorizada.getColumnModel().getColumn(2).setMinWidth(300);
            TB_detallesalidaautorizada.getColumnModel().getColumn(3).setMaxWidth(100);
            TB_detallesalidaautorizada.getColumnModel().getColumn(5).setMaxWidth(100);
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
        txtlote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloteActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("CANT. AUTORIZADA");

        txtcantdevuelta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtcantdevuelta.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtcantdevuelta.setText("0");
        txtcantdevuelta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantdevueltaActionPerformed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("FECHA VENCIMIENTO");

        JDfechavence.setDateFormatString("MM-yyyy");
        JDfechavence.setEnabled(false);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("STOCK LOTE");

        txtstocklote.setEditable(false);
        txtstocklote.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtstocklote.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtstocklote.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtreferencia)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(161, 161, 161)
                        .addComponent(jLabel9)
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(txtplu, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JDfechavence, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtstocklote, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtcantdevuelta, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(txtcantdevuelta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtplu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtlote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDfechavence, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstocklote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                
            }
        }

       /* ProductoDTO dTO = producto.read(txtreferencia.getText());
        if (dTO != null) {
            txtplu.setText(dTO.getPlu());
            txtdescripcion.setText(dTO.getDescripcion());
            txtlote.grabFocus();
        } else {
            try {
                int confirmar = Integer.parseInt(edicion.msjQuest(1,
                        "la referencia del producto no existe. deseas agregarla?").toString());

                if (confirmar == 0) {
                    this.setIcon(true);
                    FormProducto formProducto = null;
                    ControllerProducto controllerProducto = new ControllerProducto();
                    if (Metodos.Obtener_Estado_Formulario(formProducto, Contenedor.Panel_Contenedor)) {
                        formProducto = new FormProducto();
                        controllerProducto = new ControllerProducto(formProducto, new FormAsignarCUM(),
                                new FormListarPlu());
                        controllerProducto.execute();
                    } else {
                        formProducto.setIcon(false);
                    }
                }
            } catch (PropertyVetoException ex) {
                Logger.getLogger(FormDevolucionProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }//GEN-LAST:event_txtreferenciaActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtcantdevueltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantdevueltaActionPerformed
        // TODO add your handling code here:
        if (validacionforml() != false) {
            registrar();
        }
    }//GEN-LAST:event_txtcantdevueltaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        nuevo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int row = TB_detallesalidaautorizada.getSelectedRow();
        int O_P = (int) edicion.msjQuest(1, "Estas seguro que deseas eliminar el producto?");

        if (O_P == 0) {

            ddsadao.delete(TB_detallesalidaautorizada.getValueAt(row, 0));
            edicion.menu_emergente(TB_detallesalidaautorizada);

            if (TB_detallesalidaautorizada.getRowCount() <= 0) {
                sadao.delete(txtnumsalida.getText());
            }

        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtloteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloteActionPerformed
        // TODO add your handling code here:
        txtcantdevuelta.selectAll();
        txtcantdevuelta.requestFocus();
    }//GEN-LAST:event_txtloteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Object iddevolucion = edicion.msjQuest(2, "ingresa el numero de la Salida Autorizada.");
        SalidaAutorizada DTO = sadao.read(iddevolucion);
        if (DTO != null) {
            txtnumsalida.setText(String.valueOf(DTO.getIdsalidaautorizada()));
            JDfechaemision.setDate(DTO.getFechaemision());
            txtconcepto.setText(DTO.getConcepto());
            txtautorizado.setText(DTO.getAutorizado());
            edicion.llenarTabla(TB_detallesalidaautorizada,
                    ddsadao.listardetallesalida(iddevolucion));
        } else {
            edicion.mensajes(1, "la salida autorizada aun no hacido registrada.");
        }

    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDfechaemision;
    public com.toedter.calendar.JDateChooser JDfechavence;
    private javax.swing.JTable TB_detallesalidaautorizada;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTextField txtautorizado;
    public javax.swing.JTextField txtcantdevuelta;
    private javax.swing.JTextArea txtconcepto;
    public javax.swing.JTextField txtdescripcion;
    public javax.swing.JTextField txtlote;
    private javax.swing.JTextField txtnumsalida;
    public javax.swing.JTextField txtplu;
    public javax.swing.JTextField txtreferencia;
    public javax.swing.JTextField txtstocklote;
    // End of variables declaration//GEN-END:variables

    private void llenarcombo() {
        txtnumsalida.setText(String.valueOf(sadao.siguienteSalida()));
        Calendar c = new GregorianCalendar();
        JDfechaemision.setDate(c.getTime());

    }

    public int idLote;
    Edicion edicion = new Edicion();

    private SalidaAutorizada seteardatosEncabezado() {
        return new SalidaAutorizada(edicion.toNumeroEntero(txtnumsalida.getText()),
                JDfechaemision.getDate(), txtautorizado.getText().toUpperCase(),
                txtconcepto.getText(), Variables_Gloabales.EMPLEADO.getIdusuario(), null);

    }

    private DetalleSalidaAutorizada setardatosDetalle() {
        return new DetalleSalidaAutorizada(0,
                sadao.read(edicion.toNumeroEntero(txtnumsalida.getText())),
                producto.read(txtreferencia.getText()), producto.leerlotereferencia(txtreferencia.getText(), txtlote.getText()),
                edicion.toNumeroEntero(txtcantdevuelta.getText()), 0);
    }

    private void registrar() {
        if (this.sadao.read(txtnumsalida.getText()) == null) {
            sadao.create(seteardatosEncabezado());
            ddsadao.create(setardatosDetalle());
        } else {
            ddsadao.create(setardatosDetalle());
        }
        limpiarparcial();
        edicion.llenarTabla(TB_detallesalidaautorizada,
                ddsadao.listardetallesalida(txtnumsalida.getText()));
    }

    private boolean validacionforml() {

        if ("".equals(txtautorizado.getText())) {
            edicion.mensajes(1, "ingresa por favor el nombre de la persona que autorizo la salida.");
            txtautorizado.grabFocus();
            return false;
        }
        if (txtconcepto.getText().equals("")) {
            edicion.mensajes(1, "por favor debes ingresar el concepto por el cual realizas la salida.");
            txtconcepto.grabFocus();
            return false;
        }
        
        ProductoDAO pdao = new ProductoDAO();
        Lotealmacenado loteAlmacen = pdao.leerlotereferencia(txtreferencia.getText(), txtlote.getText());
        txtstocklote.setText(String.valueOf(loteAlmacen.getStocklote()));
        if (edicion.toNumeroEntero(txtcantdevuelta.getText()) > loteAlmacen.getStocklote()) {
            edicion.mensajes(1, "la cantidad que autorizar dar salida del lote no puede ser mayor al stock o existencia actual.");
            return false;
        }
        if (TB_detallesalidaautorizada.getRowCount() > 0) {
            for (int i = 0; i < TB_detallesalidaautorizada.getRowCount(); i++) {
                Object codigo = TB_detallesalidaautorizada.getValueAt(i, 1);
                Object lote = TB_detallesalidaautorizada.getValueAt(i, 3);

                if (codigo.equals(txtreferencia.getText()) && lote.equals(txtlote.getText())) {
                    String msj = "el producto " + TB_detallesalidaautorizada.getValueAt(i, 2) + "\n"
                            + "con lote #: " + lote + " se encuentra ingresado.";
                    edicion.mensajes(1, msj);
                    return false;
                }
            }
        }
        if (edicion.toNumeroEntero(txtcantdevuelta.getText()) < 1) {
            edicion.mensajes(1, "la cantidad que autorizar dar salida debe ser mayor a cero (0).");
            return false;
        }

        return true;
    }

    private void nuevo() {
        llenarcombo();
        txtcantdevuelta.setText("0");
        txtdescripcion.setText(null);
        txtautorizado.setText(null);
        txtlote.setText(null);
        txtplu.setText(null);
        txtreferencia.setText(null);
        JDfechavence.setDate(null);
        txtconcepto.setText(null);
        txtstocklote.setText(null);
        edicion.limpiar_tablas(TB_detallesalidaautorizada);
    }

    private void limpiarparcial() {
        txtcantdevuelta.setText("0");
        txtdescripcion.setText(null);
        txtlote.setText(null);
        JDfechavence.setDate(null);
        txtplu.setText(null);
        txtreferencia.setText(null);
        txtstocklote.setText(null);
        txtreferencia.grabFocus();
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
