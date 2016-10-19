package com.managerwarehouse.util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Unknown
 */
public class CambiaColorTabla extends DefaultTableCellRenderer {

    Edicion edicion = new Edicion();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (table.getRowCount() > 0) {

            
                int valorpromedio = edicion.toNumeroEntero(table.getValueAt(row, 9).toString());
                int valormax = edicion.toNumeroEntero(table.getValueAt(row, 8).toString());
                int valormin = edicion.toNumeroEntero(table.getValueAt(row, 5).toString());

                if (valorpromedio > valormax | valorpromedio < valormin) {
                    setBackground(Color.red);
                } else {
                    setBackground(Color.white);
                }
            
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }

}
