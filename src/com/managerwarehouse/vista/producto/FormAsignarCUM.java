/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managerwarehouse.vista.producto;

/**
 *
 * @author Servidor-PC
 */
public class FormAsignarCUM extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormAsignarCUM
     */
    public FormAsignarCUM() {
        initComponents();
        
       /*   String[] columnas = new String[]{
            "CUM",
            "CANTIDAD",
            "PRESENTACION",
            "ESTADO CUM",
            ""};
          
        final Class[] tiposColumnas = new Class[]{
            java.lang.Object.class,
            java.lang.Object.class,
            java.lang.Object.class,
            Object.class,
            JButton.class // <- noten que aquí se especifica que la última columna es un botón
        };

        // Agrego los registros que contendrá la grilla.
        // Observen que el último campo es un botón
        
        Object[][] datos;
        JButton button = new JButton();
        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Download.png")));
       

        datos = new Object[][]{
            {null,null, null,null, 2, button}
        };

        // Defino el TableModel y le indico los datos y nombres de columnas
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                columnas) {
                    // Esta variable nos permite conocer de antemano los tipos de datos
                    //de cada columna, dentro del TableModel
                    Class[] tipos = tiposColumnas;

                    @Override
                    public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                        // observen que estamos retornando la clase que definimos de antemano.
                        return tipos[columnIndex];
                    }

                    @Override
                    public boolean isCellEditable(int row, int column) {
                        // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                        return !(this.getColumnClass(column).equals(JButton.class));
                    }
                });

        // El objetivo de la siguiente línea es indicar el CellRenderer que será utilizado para dibujar el botón
        jTable1.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                /**
                 * Observen que todo lo que hacemos en éste método es retornar
                 * el objeto que se va a dibujar en la celda. Esto significa que
                 * se dibujará en la celda el objeto que devuelva el TableModel.
                 * También significa que este renderer nos permitiría dibujar
                 * cualquier objeto gráfico en la grilla, pues retorna el objeto
                 * tal y como lo recibe.
                 */
          /*      return (Component) objeto;
            }
        });
        
        
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = jTable1.rowAtPoint(e.getPoint());
                int columna = jTable1.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el
                 * botón, si tuviéramos más de un botón por fila tendríamos que
                 * además preguntar por el contenido del botón o el nombre de la
                 * columna
                 */
               /* if (jTable1.getModel().getColumnClass(columna).equals(JButton.class)) {
                    /**
                     * Aquí pueden poner lo que quieran, para efectos de este
                     * ejemplo, voy a mostrar en un cuadro de dialogo todos los
                     * campos de la fila que no sean un botón.
                     */
                  /*  StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < jTable1.getModel().getColumnCount(); i++) {
                        if (!jTable1.getModel().getColumnClass(i).equals(JButton.class)) {
                            sb.append("\n").append(jTable1.getModel().getColumnName(i)).append(": ").append(jTable1.getModel().getValueAt(fila, i));
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Seleccionada la fila " + fila + sb.toString());
                }
            }
        });*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_Presentacion = new javax.swing.JTable();
        lbVersionBD = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Seleccionar Presentacion");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/CLICK.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRESENTACIONES DISPONIBLES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Verdana", 0, 14), java.awt.Color.black)); // NOI18N

        TB_Presentacion.setBackground(new java.awt.Color(204, 204, 255));
        TB_Presentacion.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        TB_Presentacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CUM", "EMB. X CAJA ", "PRESENTACION", "ESTADO CUM", "TITULAR", "NOMBRE ROL", "TIPO ROL", "MODALIDAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TB_Presentacion.setToolTipText("DOBLE CLICK PARA SELECCIONAR PRESENTACION");
        TB_Presentacion.setRowHeight(25);
        jScrollPane1.setViewportView(TB_Presentacion);
        if (TB_Presentacion.getColumnModel().getColumnCount() > 0) {
            TB_Presentacion.getColumnModel().getColumn(0).setMaxWidth(85);
            TB_Presentacion.getColumnModel().getColumn(1).setMaxWidth(80);
            TB_Presentacion.getColumnModel().getColumn(2).setMinWidth(250);
            TB_Presentacion.getColumnModel().getColumn(3).setMaxWidth(80);
            TB_Presentacion.getColumnModel().getColumn(6).setMaxWidth(80);
            TB_Presentacion.getColumnModel().getColumn(7).setMinWidth(90);
        }

        lbVersionBD.setBackground(new java.awt.Color(0, 153, 204));
        lbVersionBD.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbVersionBD.setForeground(new java.awt.Color(255, 255, 255));
        lbVersionBD.setText("Versión de la base de datos del INVIMA: ");
        lbVersionBD.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbVersionBD, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbVersionBD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TB_Presentacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbVersionBD;
    // End of variables declaration//GEN-END:variables
}
