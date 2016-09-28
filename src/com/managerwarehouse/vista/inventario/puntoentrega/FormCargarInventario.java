package com.managerwarehouse.vista.inventario.puntoentrega;

import com.managerwarehouse.model.inventario.puntoentrega.CargarInventarioDao;
import com.managerwarehouse.model.puntoentrega.PuntoEntrega;
import com.managerwarehouse.model.puntoentrega.PuntoEntregaDAO;
import com.managerwarehouse.util.CargarArchivo;
import com.managerwarehouse.util.Edicion;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FormCargarInventario extends javax.swing.JInternalFrame {

    CargarArchivo cargarArchivo = null;
    Edicion edicion = new Edicion();
    JFileChooser fileChooser = new JFileChooser();
    Workbook wbook;
    CargarInventarioDao CargaDao;
    PuntoEntregaDAO puntoDao;

    public FormCargarInventario() {
        puntoDao = new PuntoEntregaDAO();
        CargaDao = new CargarInventarioDao();
        initComponents();
        llenarcombos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnuminventario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jdFechainicio = new com.toedter.calendar.JDateChooser();
        jdFechaFinal = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        combopuntoentrega = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtruta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_DetalleInventario = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setTitle("Cargar Inventario");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CARGAR INVENTARIO PUNTO DE ENTREGA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Verdana", 0, 18))); // NOI18N

        jLabel1.setText("No. de Inventario");

        txtnuminventario.setEditable(false);
        txtnuminventario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnuminventario.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jLabel2.setText("Periodo de Inventario");

        jdFechainicio.setDateFormatString("EEE dd MMM yyyy");

        jdFechaFinal.setDateFormatString("EEE dd MMM yyyy");

        jLabel3.setText("Punto de Entrega");

        jLabel4.setText("Seleccionar Inventario");

        txtruta.setEditable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Download.png"))); // NOI18N
        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnuminventario, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combopuntoentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jdFechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtruta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnuminventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdFechainicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdFechaFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combopuntoentrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Inventario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Light", 0, 18))); // NOI18N

        TB_DetalleInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PLU", "DESCRIPCIÓN", "INV. INICIAL", "ENTRADAS", "DEV. ENTRADA", "SALIDAS", "DEV. SALIDAS", "SAL. AUTO", "INV. FINAL", "INV. FISICO", "SOBRANTE ", "FALTANTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TB_DetalleInventario.setRowHeight(22);
        TB_DetalleInventario.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TB_DetalleInventario);
        if (TB_DetalleInventario.getColumnModel().getColumnCount() > 0) {
            TB_DetalleInventario.getColumnModel().getColumn(1).setMinWidth(200);
            TB_DetalleInventario.getColumnModel().getColumn(1).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jToolBar1.setRollover(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar-nuevo-documento-de-archivo-mas-icono-6249-32.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Buscar.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cerrar.png"))); // NOI18N
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/exit.png"))); // NOI18N
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 63, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CARGAR_INVENTARIO();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        registrarInventario();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        llenarcombos();
        edicion.limpiar_tablas(TB_DetalleInventario);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TB_DetalleInventario;
    private javax.swing.JComboBox combopuntoentrega;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private com.toedter.calendar.JDateChooser jdFechaFinal;
    private com.toedter.calendar.JDateChooser jdFechainicio;
    private javax.swing.JTextField txtnuminventario;
    private javax.swing.JTextField txtruta;
    // End of variables declaration//GEN-END:variables

    private void llenarcombos() {
        combopuntoentrega.removeAllItems();
        combopuntoentrega.addItem(null);
        for (PuntoEntrega readAll : puntoDao.readAll()) {
            combopuntoentrega.addItem(readAll.getNombre());
        }
        txtnuminventario.setText(CargaDao.NUMERO_CARGA().toString());
    }

    private void CARGAR_INVENTARIO() {

        File archivo = new File("D:\\BODEGA\\INVENTARIOS");
        fileChooser.setCurrentDirectory(archivo);
        int answer = fileChooser.showDialog(null, "Importar");
        if (answer == JFileChooser.APPROVE_OPTION) {
            archivo = fileChooser.getSelectedFile();
            if (archivo != null) {
                createTableModel(archivo);
            }
        }
    }

    private void createTableModel(File archivo) {
        edicion.limpiar_tablas(TB_DetalleInventario);
        try {
            Vector columna = new Vector();
            Vector fila = new Vector();
            wbook = Workbook.getWorkbook(archivo);
            final Sheet hoja = wbook.getSheet(0);
            columna.clear();
            for (int i = 0; i < hoja.getColumns(); i++) {
                Cell cell1 = hoja.getCell(i, 0);
                columna.add(cell1.getContents());
            }
            fila.clear();
            for (int j = 1; j < hoja.getRows(); j++) {
                Vector d = new Vector();
                for (int i = 0; i < hoja.getColumns(); i++) {
                    Cell cell = hoja.getCell(i, j);
                    d.add(cell.getContents());
                }
                d.add("\n");
                fila.add(d);
                DefaultTableModel temp = (DefaultTableModel) TB_DetalleInventario.getModel();
                temp.addRow(d);

            }

        } catch (IOException | BiffException | IndexOutOfBoundsException ex) {
            System.out.println("Error en la Carga del Archivo: " + ex);
        }
    }

    private void registrarInventario() {

        int contador = 0;
        int filas = TB_DetalleInventario.getRowCount();
        String valuesdetalle = "", valuesEncabezado;
        valuesEncabezado = txtnuminventario.getText() + ",'" + edicion.formatearFechaSQL(jdFechainicio.getDate()) + "',"
                + "'" + edicion.formatearFechaSQL(jdFechaFinal.getDate()) + "'," + puntoDao.read(combopuntoentrega.getSelectedItem()).getIdpunto();
        if (CargaDao.REGISTRAR_CARGA_ENCABEZADO(valuesEncabezado) != false) {

            for (int i = 0; i < filas; i++) {
                if (contador == (filas - 1)) {
                    valuesdetalle = valuesdetalle + "(" + txtnuminventario.getText() + ",'" + TB_DetalleInventario.getValueAt(i, 0) + "'," + TB_DetalleInventario.getValueAt(i, 2) + ","
                            + "" + TB_DetalleInventario.getValueAt(i, 3) + "," + TB_DetalleInventario.getValueAt(i, 4) + "," + TB_DetalleInventario.getValueAt(i, 5) + ","
                            + "" + TB_DetalleInventario.getValueAt(i, 6) + "," + TB_DetalleInventario.getValueAt(i, 7) + "," + TB_DetalleInventario.getValueAt(i, 8) + ","
                            + "" + TB_DetalleInventario.getValueAt(i, 9) + "," + TB_DetalleInventario.getValueAt(i, 10) + "," + TB_DetalleInventario.getValueAt(i, 11) + ");";
                    System.out.println("dentro de if - for" + valuesdetalle);
                    if (CargaDao.REGISTRAR_CARGA_DETALLE(valuesdetalle) == true) {
                        edicion.mensajes(2, "inventario cargado correctamente.");
                    } else {
                        edicion.mensajes(3, "inventario no fue cargado correctamente.");
                    }
                }
                valuesdetalle = valuesdetalle + "(" + txtnuminventario.getText() + ",'" + TB_DetalleInventario.getValueAt(i, 0) + "'," + TB_DetalleInventario.getValueAt(i, 2) + ","
                        + "" + TB_DetalleInventario.getValueAt(i, 3) + "," + TB_DetalleInventario.getValueAt(i, 4) + "," + TB_DetalleInventario.getValueAt(i, 5) + ","
                        + "" + TB_DetalleInventario.getValueAt(i, 6) + "," + TB_DetalleInventario.getValueAt(i, 7) + "," + TB_DetalleInventario.getValueAt(i, 8) + ","
                        + "" + TB_DetalleInventario.getValueAt(i, 9) + "," + TB_DetalleInventario.getValueAt(i, 10) + "," + TB_DetalleInventario.getValueAt(i, 11) + "),\n";
                contador++;
            }

        }

    }

}
