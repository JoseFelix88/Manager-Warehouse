package com.managerwarehouse.util.reportes;

import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.Variables_Gloabales;
import com.managerwarehouse.util.database;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class GenerarReporte extends database {

    static String RUTA_REPORTE = "C:\\Reportes MW/";
    public String NOMBRE_REPORTE;
    public String NOMBRE_DEL_ARCHIVO_EXPORTADO;
    public HashMap PARAMETROS = new HashMap();
    public String DIRECTORIO_POR_DEFECTO;
    JasperReport masterReport = null;

    Edicion edicion = new Edicion();

    public GenerarReporte() {
    }

    public boolean Exportar() {

        try {
            JFileChooser fileChooser = new JFileChooser();

            FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter(".pdf", ".pdf");
            fileChooser.setFileFilter(extensionFilter);
            fileChooser.setName(NOMBRE_DEL_ARCHIVO_EXPORTADO);
            System.out.println("Directorio por defecto: " + DIRECTORIO_POR_DEFECTO);

            File file = new File(DIRECTORIO_POR_DEFECTO);

            if (file.exists() != true) {

                file.mkdirs();
            }

            String archivo = DIRECTORIO_POR_DEFECTO + ""
                    + fileChooser.getName() + "" + fileChooser.getFileFilter().getDescription();

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(RUTA_REPORTE + "" + NOMBRE_REPORTE);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, PARAMETROS, getConnection());

            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRCsvExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(archivo));
            System.out.println("Archivo generado: " + archivo);
            exporter.exportReport();
            try {

                File path = new File(archivo);

                path.isDirectory();
                Desktop.getDesktop().open(path);

            } catch (IOException ex) {
                Logger.getLogger(GenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
            }

            return true;
        } catch (JRException ex) {
            Logger.getLogger(GenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public void vistaprevia() {
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(RUTA_REPORTE + "" + NOMBRE_REPORTE);
            edicion.Lanzador(jasperReport, PARAMETROS);
        } catch (JRException ex) {
            Logger.getLogger(GenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ContenidoDeCaja(String numero, String numcaja) {

        try {

            String Ubicacion = RUTA_REPORTE + "/";
            String reporte = "Contenido de Cajas.jasper";
            masterReport = (JasperReport) JRLoader.loadObject(Ubicacion.concat(reporte));
            PARAMETROS.put("numSalida", numero);
            PARAMETROS.put("numCaja", numcaja);

            JasperPrint jPrint = JasperFillManager.fillReport(masterReport, PARAMETROS, getConnection());
            JasperPrintManager.printReport(jPrint, false);

        } catch (Exception j) {
            edicion.mensajes(3, "NO SE PUEDE LANZAR EL INFORME del contenido de las cajas.\n" + j);
            System.out.println("Mensaje de Error:" + j);
        }
    }

    public void Salidas_Producto(Object numero) {
        try {
            String Ubicacion = RUTA_REPORTE + "/";
            String reporte = "salidas de producto.jasper";
            masterReport = (JasperReport) JRLoader.loadObject(Ubicacion.concat(reporte));
            PARAMETROS.put("numSalida", numero);
            edicion.Lanzador(masterReport, PARAMETROS);
        } catch (Exception e) {
            edicion.mensajes(3, "error no se pudo lanzar el traslado.\n" + e);
        }
    }

    public void relacion_de_carga() {
        try {

            String Ubicacion = RUTA_REPORTE + "/";
            String reporte = "relacion de carga.jasper";
            masterReport = (JasperReport) JRLoader.loadObject(Ubicacion.concat(reporte));

            JasperPrint jPrint = JasperFillManager.fillReport(masterReport, null, getConnection());
            JasperPrintManager.printReport(jPrint, false);

        } catch (Exception j) {
            edicion.mensajes(3, "NO SE PUEDE LANZAR EL INFORME del contenido de las cajas.\n" + j);
            System.out.println("Mensaje de Error:" + j);
        }
    }

    public void compraproducto(Object[] key) {
        try {
            String Ubicacion = RUTA_REPORTE + "/compras/";
            String reporte = "Compra Producto.jasper";
            masterReport = (JasperReport) JRLoader.loadObject(Ubicacion.concat(reporte));
            PARAMETROS.put("codplu", key[0]);
            PARAMETROS.put("codref", key[1]);
            PARAMETROS.put("f1", key[2]);
            PARAMETROS.put("f2", key[3]);
            edicion.Lanzador(masterReport, PARAMETROS);
        } catch (Exception e) {
            edicion.mensajes(3, "error no se pudo lanzar el traslado.\n" + e);
        }
    }

    public void lotesalmacenados() {
        try {
            String Ubicacion = RUTA_REPORTE + "/inventario/";
            String reporte = "lotes almacenados.jasper";
            masterReport = (JasperReport) JRLoader.loadObject(Ubicacion.concat(reporte));
            edicion.Lanzador(masterReport, PARAMETROS);
        } catch (Exception e) {
            edicion.mensajes(3, "error no se pudo lanzar el informe de lotes almacenados.\n" + e);
        }
    }

    public void diferencia_inventario_puntoentrega(Object[] key) {
        String reporte = "Diferencia inventario punto entrega.jasper";
        try {
            String Ubicacion = RUTA_REPORTE + "/inventario/";
            masterReport = (JasperReport) JRLoader.loadObject(Ubicacion.concat(reporte));
            PARAMETROS.put("puntoentrega", key[0]);
            PARAMETROS.put("f1", key[1]);
            PARAMETROS.put("f2", key[2]);
            edicion.Lanzador(masterReport, PARAMETROS);
        } catch (Exception e) {
            edicion.mensajes(3, "error no se pudo lanzar el informe " + reporte + ".\n" + e);
        }
    }

    public void diferencia_inventario_Bodega(Object[] key) {
        String reporte = "Diferencias inventario bodega.jasper";
        try {
            String Ubicacion = RUTA_REPORTE + "/inventario/";
            masterReport = (JasperReport) JRLoader.loadObject(Ubicacion.concat(reporte));
            PARAMETROS.put("F1", key[0]);
            PARAMETROS.put("F2", key[1]);
            edicion.Lanzador(masterReport, PARAMETROS);
        } catch (Exception e) {
            edicion.mensajes(3, "error no se pudo lanzar el informe " + reporte + ".\n" + e);
        }
    }

    public void pedido_puntos(Object key) {
        String reporte = "Pedido Punto de Entrega.jasper";
        try {
            String Ubicacion = RUTA_REPORTE + "/";
            masterReport = (JasperReport) JRLoader.loadObject(Ubicacion.concat(reporte));
            PARAMETROS.put("pedido", key);
            edicion.Lanzador(masterReport, PARAMETROS);
        } catch (Exception e) {
            edicion.mensajes(3, "error no se pudo lanzar el informe " + reporte + ".\n" + e);
        }

    }

    public void pedido_proveedor(Object key) {
        String reporte = "Pedido Proveedor.jasper";
        try {
            String Ubicacion = RUTA_REPORTE + "/compras/";
            masterReport = (JasperReport) JRLoader.loadObject(Ubicacion.concat(reporte));
            PARAMETROS.put("proveedor", key);
            PARAMETROS.put("userlogin", Variables_Gloabales.EMPLEADO.getNombreCompleto());
            edicion.Lanzador(masterReport, PARAMETROS);
        } catch (Exception e) {
            edicion.mensajes(3, "error no se pudo lanzar el informe " + reporte + ".\n" + e);
        }

    }

    public void ORDEN_DE_PEDIDO_PROVEEDOR_CON_PRECIO(Object key) {
        String reporte = "Orden de Pedido Proveedor.jasper";
        try {
            String Ubicacion = RUTA_REPORTE + "/compras/";
            masterReport = (JasperReport) JRLoader.loadObject(Ubicacion.concat(reporte));
            PARAMETROS.put("proveedor", key);
            PARAMETROS.put("userlogin", Variables_Gloabales.EMPLEADO.getNombreCompleto());
            edicion.Lanzador(masterReport, PARAMETROS);
        } catch (Exception e) {
            edicion.mensajes(3, "error no se pudo lanzar el informe " + reporte + ".\n" + e);
        }

    }

    public void ACTA_DE_RECEPCION_BODEGA(Object key) {
        String reporte = "Acta de Recepcion bodega.jasper";
        try {
            String Ubicacion = RUTA_REPORTE + "/compras/";
            masterReport = (JasperReport) JRLoader.loadObject(Ubicacion.concat(reporte));
            PARAMETROS.put("NUMFACTURA", key.toString());
            edicion.Lanzador(masterReport, PARAMETROS);
        } catch (Exception e) {
            edicion.mensajes(3, "error no se pudo lanzar el informe " + reporte + ".\n" + e);
        }

    }

    public void ACTA_DE_RECEPCION_PUNTO_DE_ENTREGA(Object key) {
        String reporte = "Acta de Recepcion punto de entrega.jasper";
        try {
            String Ubicacion = RUTA_REPORTE + "/";
            masterReport = (JasperReport) JRLoader.loadObject(Ubicacion.concat(reporte));
            PARAMETROS.put("NUMFACTURA", key.toString());
            edicion.Lanzador(masterReport, PARAMETROS);
        } catch (Exception e) {
            edicion.mensajes(3, "error no se pudo lanzar el informe " + reporte + ".\n" + e);
        }

    }

    public void GRAFRICO_TEMPERATURA_HUMEDAD(Object f1, Object f2, String key) {
        String reporte = "Grafico Temperatura y Humedad.jasper";
        try {
            String Ubicacion = RUTA_REPORTE + "/utilidades/";
            masterReport = (JasperReport) JRLoader.loadObject(Ubicacion.concat(reporte));
            PARAMETROS.put("fec1", f1);
            PARAMETROS.put("fec2", f2);
            PARAMETROS.put("IDCONCEPTO", key);
            System.out.println(PARAMETROS);
            edicion.Lanzador(masterReport, PARAMETROS);
        } catch (Exception e) {
            edicion.mensajes(3, "error no se pudo lanzar el informe " + reporte + ".\n" + e);
        }

    }
}
