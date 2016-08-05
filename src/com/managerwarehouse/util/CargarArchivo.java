package com.managerwarehouse.util;

import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class CargarArchivo {

    private JFileChooser fileChooser = new JFileChooser();
    private Workbook wbook;

    public File CARGAR_EXCEL() {
        try {
            File archivo = new File("");
            fileChooser.setCurrentDirectory(archivo);
            int answer = this.fileChooser.showDialog(null, "Cargar");
            if (answer == JFileChooser.APPROVE_OPTION) {
                archivo = fileChooser.getSelectedFile();
                if (archivo != null) {
                    return archivo;
                }
            }
        } catch (Exception e) {
            System.out.println("Error en Cargar Archivo: "+e);
        }
        return null;
    }

    public Vector MONTAR_ARCHIVO_EN_TABLA() {
        Vector vector = null;
        File file = CARGAR_EXCEL();
        try {
            if (file != null) {
                Vector columna = new Vector();  //  @jve:decl-index=0:
                Vector fila = new Vector();
                //getting the workbook
                wbook = Workbook.getWorkbook(file);
                //una hoja en especifico
                final Sheet hoja = wbook.getSheet(0);
                columna.clear();
                for (int i = 0; i < hoja.getColumns(); i++) {
                    Cell cell1 = hoja.getCell(i, 0);
                    columna.add(cell1.getContents());
                }
                fila.clear();
                for (int j = 1; j < hoja.getRows(); j++) {
                    vector = new Vector();
                    for (int i = 0; i < hoja.getColumns(); i++) {
                        Cell cell = hoja.getCell(i, j);
                        vector.add(cell.getContents());
                    }
                    vector.add("\n");
                }
            }
        } catch (IOException | BiffException | IndexOutOfBoundsException e) {
            System.out.println("Error en Montar Archivo: "+e);
        }
        return vector;
    }
}
