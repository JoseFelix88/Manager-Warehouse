package com.managerwarehouse.main;

import com.managerwarehouse.controlador.index.ControllerContenedor;
import com.managerwarehouse.model.factura_de_compra.FacturaCompraDAO;
import com.managerwarehouse.model.factura_de_compra.FacturaCompraDTO;
import com.managerwarehouse.model.proveedor.ProveedorDAO;
import com.managerwarehouse.model.proveedor.ProveedorDTO;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.escaneo_de_soportes.EscanearSoportes;
import com.managerwarehouse.vista.index.FormAcceso;
import com.tekde.linet.components.JFileChooserCus;
import com.tekde.linet.components.JFileChooserCusListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

public class ManagerWarehouse {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        /*File archivo = new File("Z://");
         JFileChooser chooser = new JFileChooser();

         chooser.setCurrentDirectory(archivo);
         int guardar = chooser.showSaveDialog(chooser);

         if (guardar == JFileChooser.APPROVE_OPTION) {

         archivo = chooser.getSelectedFile();
         EscanearSoportes soportes = new EscanearSoportes();

         if (archivo != null) {
         File destino = new File("E://moverficheros/factura No."+soportes.getExtencionFile(archivo.getPath())+"");
         soportes.fileMove(archivo.getPath(),destino.getPath());
         }

         }*/
        
        
        Edicion edicion = new Edicion();
        edicion.cambiar_skin(2);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

//        new controllerProducto().GO();
                new FormAcceso().setVisible(true);
            }
        });
    }

}
