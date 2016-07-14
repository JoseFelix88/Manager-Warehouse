package com.managerwarehouse.util;

import com.birosoft.liquid.LiquidLookAndFeel;
import com.tekde.linet.components.JFileChooserCus;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Servidor-PC
 */
public class Edicion extends database {

    public int v = 1;

    public void llenartabla(JTable tabla, List<Object> list) {
        if (list != null) {

            limpiar_tablas(tabla);

            DefaultTableModel tableModel = (DefaultTableModel) tabla.getModel();

            for (Iterator<Object> it = list.iterator(); it.hasNext();) {
                Object[] data = {it.next()};
                tableModel.addRow(data);
            }
        }

    }

    boolean isNumeric(String cadena) {
        try {

            Integer.parseInt(ReemplazarCarateres(cadena));
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public int toNumeroEntero(String entero) {

        if (isNumeric(entero)) {

            return Integer.parseInt(ReemplazarCarateres(entero));
        } else {

            mensajes(3, "ingrese solo numeros: " + entero);
        }

        return 0;
    }

    boolean isNumericFloat(String cadena) {
        try {

            Float.parseFloat(ReemplazarCarateres(cadena));
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public float toNumeroFloat(String decimal) {

        if (isNumericFloat(decimal)) {

            return Float.parseFloat(ReemplazarCarateres(decimal));
        } else {

            mensajes(3, "ingrese solo numeros: " + ReemplazarCarateres(decimal));
        }

        return 0;
    }

    public String ReemplazarCarateres(String cadena) {

        String numero = cadena.replace(".", "").replace("%", "").replace(" ", "").
                replace("$", "").replace("$ ", "");

        return numero;
    }

    public void abrirVtn(JFrame vtn) {

        if (vtn == null) {

            vtn = new JFrame();
            vtn.setVisible(true);

        } else {

            if (vtn.getState() == 1) {

                vtn.setState(JFrame.NORMAL);

            } else {

                vtn.setVisible(true);
            }

        }

    }

    public long diferencia_entre_fechas(Date f1, JDateChooser f2) {

        long diferencia;

        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 

        java.util.Date hoy = f1; //Fecha de hoy 

        int año = f2.getCalendar().get(Calendar.YEAR);

        int mes = f2.getDate().getMonth() + 1;

        int dia = f2.getDate().getDate(); //Fecha anterior 

        Calendar calendar = new GregorianCalendar(año, mes - 1, dia);

        java.sql.Date fecha = new java.sql.Date(calendar.getTimeInMillis());

        diferencia = (fecha.getTime() - hoy.getTime()) / MILLSECS_PER_DAY;

        System.out.println(diferencia);

        //mensajes(2, ""+diferencia);
        return diferencia;

    }

    public Date formatearFechaSQL(String fecha) {

        try {
            System.out.println(fecha);
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            java.sql.Date fechaConFormato = (java.sql.Date) formato.parse(fecha);

            return fechaConFormato;

        } catch (Exception er) {
            System.out.println("error al formatear fecha: "+er);
        }

        return null;
    }

    public Date CambiarTipoFecha(Object fecha) {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {

            if (fecha != null) {

                Date fechaforma = formato.parse(fecha.toString());
                return fechaforma;
            }

        } catch (Exception e) {
            System.out.println("error al convertir " + e);
        }

        return null;
    }

    public Object[] desmenusarFecha(Date fecha) {

        Object[] desmenusa = new Object[3];
        Calendar c = new GregorianCalendar();
        c.setTime(fecha);

        int anio = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH) + 1;
        int dia = c.get(Calendar.DAY_OF_MONTH);

        desmenusa[0] = anio;
        desmenusa[1] = mes;
        desmenusa[2] = dia;

        return desmenusa;
    }

    public void mensajes(int tipo, String sms) {

        sms = sms.toUpperCase();

        if (tipo == 1) {

            // mensaje de adventencia
            JOptionPane.showMessageDialog(null, sms, "Advertencia", JOptionPane.WARNING_MESSAGE);

        }

        if (tipo == 2) {

            // mensaje de informacion
//                event = new NiconEvent("info..", sms, NiconEvent.NOTIFY_DEFAULT);
            JOptionPane.showMessageDialog(null, sms, "Info...", JOptionPane.INFORMATION_MESSAGE);

        }

        if (tipo == 3) {

            // mensaje de Excepcion
            JOptionPane.showMessageDialog(null, sms, "Error...", JOptionPane.ERROR_MESSAGE);

        }

        if (tipo == 4) {

            // mensaje de Excepcion
            System.out.println(sms);

        }

    }

    CambiaFormatoTexto formatoNum = new CambiaFormatoTexto();

    public String formatearFecha(Date fecha) {

        try {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            String fechaConFormato = formato.format(fecha);

            return fechaConFormato;

        } catch (Exception er) {
            System.out.println("error en conversion de fecha: " + er);
        }

        return null;
    }

    public String formatearFechaSQL(Date fecha) {

        try {

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            String fechaConFormato = formato.format(fecha);

            return fechaConFormato;

        } catch (Exception er) {
        }

        return null;
    }

    public void Lanzador(JasperReport masterReport, Map param) {

        try {

            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, param,
                    getConnection());//fillReport(masterReport, param, Conec);

            JasperViewer jviewer = new JasperViewer(jasperPrint, false);

//            jviewer.setTitle(variables_globales.title.replace(".jasper", "").replace("_", " "));
            jviewer.setVisible(true);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "NO FUE POSIBLE ABRIR EL INFORME \n(error en el lanzador) \n" + ex, "Error", JOptionPane.ERROR_MESSAGE);

            System.out.println("Error En El Lanzador Del Reporte: " + ex);

        }

    }

    public void salir() {

        int r = JOptionPane.showConfirmDialog(null, " ESTA SEGURO QUE DESEAS SALIR ?", "Confirmar...", JOptionPane.YES_NO_OPTION);

        if (r == JOptionPane.YES_NO_OPTION) {

            try {

                /*
                 String inst;
                 
                 inst="delete from secion_actual";
                 todo.ejecutar(inst);
                 inst="truncate table secion_actual";
                 todo.ejecutar(inst);
                 conexcion.Conec.commit();
                 */
                System.exit(1);

            } catch (Exception ex) {
                System.out.println("ERROR: " + ex);
            }

        }

    }

    public String pasar_str(Double num) {

        return String.valueOf(num);

    }

    public double Redondear(double numero) {

        return Math.round(numero * 10 / 10);

    }

    public void calcula_total(JTable Tabla, JLabel label, JTextField jtotal, int a) {

        try {

            double acum = 0;
            int total = 0;

            for (int i = 0; i <= Tabla.getRowCount() - 1; i++) {

                String t = String.valueOf(Tabla.getValueAt(i, a));

                double tv = Double.parseDouble(t);

                acum = acum + tv;

                total = total + 1;

            }

            if (v == 1) {

                label.setText(formatoNum.numerico(total) + " ");
                jtotal.setText("$ " + formatoNum.numerico(acum) + " ");

            }

            if (v == 2) {

                label.setText(formatoNum.numerico(total));
                jtotal.setText(formatoNum.numerico(acum));

            }

        } catch (Exception e) {

            System.out.println(e);
        }

    }

    public String fechas_calendario(JCalendar fecha) {

        String fecha1 = null;

        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha.getDate());

        int dia = cal.get(Calendar.DAY_OF_MONTH);

        int mes = cal.get(Calendar.MONTH) + 1;

        String sDia = "";
        String sMes = "";

        if (dia < 10) {
            sDia = "0";
        }
        sDia += dia;

        if (mes < 10) {
            sMes = "0";
        }
        sMes += mes;

        fecha1 = cal.get(Calendar.YEAR) + "-" + sMes + "-" + sDia + "";
        return fecha1;
    }

    public Object fechas(JDateChooser fecha) {

        Object fecha1 = null;

        try {

            Calendar cal = Calendar.getInstance();
            cal.setTime(fecha.getDate());

            int dia = cal.get(Calendar.DAY_OF_MONTH);

            int mes = cal.get(Calendar.MONTH) + 1;

            String sDia = "";
            String sMes = "";

            if (dia < 10) {
                sDia = "0";
            }
            sDia += dia;

            if (mes < 10) {
                sMes = "0";
            }
            sMes += mes;

            fecha1 = cal.get(Calendar.YEAR) + "-" + sMes + "-" + sDia + "";

        } catch (Exception e) {

//            mensajes(1, "seleccione una fecha");
        }
        return fecha1;

    }

    /*public void Leer_Excel() {
     try {

     InputStream in = new FileInputStream("fichero.xls");
     System.out.println("ley archivo");
     Workbook workbook = Workbook.getWorkbook(in);
     System.out.println("liea 2");
     Sheet sheet = workbook.getSheet(0);
     Cell cell = sheet.getCell(0, 0);
     String content = cell.getContents();
     Cell cell2 = sheet.getCell(1, 0);
     String strnum = cell2.getContents();
     NumberCell numCell = (NumberCell) cell2;

     Double num = numCell.getValue();
     } catch (Exception er) {
     System.out.println(er);
     }
     }
     /*
     public void Excel() throws IOException, WriteException, BiffException{
     try {
          
     OutputStream out = new FileOutputStream("fichero.xls");
     WritableWorkbook workbook = Workbook.createWorkbook(out);
     WritableSheet Sheet = workbook.createSheet("hoja 1", 0);
     Label texto = new Label(0,0, "celda A1");
     Number numero = new Number(1, 0, Double.valueOf(5.00));
     Sheet.addCell(texto);
     Sheet.addCell(numero);
            
         
            
     } catch (FileNotFoundException ex) {
     Logger.getLogger(Edicion.class.getName()).log(Level.SEVERE, null, ex);
     }
        
        
     }
    
     */
    public void cambiar_skin(int param) {

        try {

            if (param == 1) {

                UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");

                //líneas para el cambio visual   
                //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                LiquidLookAndFeel.setLiquidDecorations(true, "panther");
                LiquidLookAndFeel.setShowTableGrids(true);
                SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceGreenTheme");

            }

            if (param == 2) {

                // marca de agua
                // TODO code application logic here
                for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {

                    if ("Windows".equals(laf.getName())) {
                        try {

                            UIManager.setLookAndFeel(laf.getClassName());

                            JFrame.setDefaultLookAndFeelDecorated(true);

                            //                   System.out.println("ejecutado");
                        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {

                        }
                    }

                }
//                UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
            }

            if (param == 3) {

                JFrame.setDefaultLookAndFeelDecorated(true);
                //Aplicamos un skin a nuestra ventana, en este caso SaharaSkin
                SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.NebulaBrickWallSkin");
//              SubstanceLookAndFeel.setCurrentTheme( "org.jvnet.substance.theme.SubstanceGreenTheme" );

            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {

            System.out.println(e.getMessage());

        }

    }

    public boolean compararDatosTabla(Object data, Object plu[]) {

        try {

            for (int j = 0; j < plu.length; j++) {

                Object codigo = plu[j];

                if (data.equals(codigo)) {

                    return true;

                }

            }

        } catch (Exception e) {

            System.out.println("error en metodo comparador " + e);
        }
        return false;

    }

    public long conversor_de_numeros(JTextField txt) {

        try {

            long numero = Long.parseLong(txt.getText().replace("%", "").replace("$ ", "").replace(".", "").replace(" ", ""));

            return numero;

        } catch (NumberFormatException e) {

            this.mensajes(3, "solo ingrese valores numericos.");

            txt.setText("");
            txt.selectAll();
            txt.requestFocus();

            return 0;
        }

    }

    public float conversor_de_numeros_decimales(JTextField txt) {

        try {

            float numero = Float.parseFloat(txt.getText().replace("%", "").replace("$ ", "").replace(" ", ""));

            return numero;

        } catch (Exception e) {

            this.mensajes(3, "solo ingrese valores numericos.");

            txt.selectAll();
            txt.requestFocus();
            txt.setText("0");
            return 0;
        }

    }

    public double conversor_de_numeros_decimal(JTextField txt) {

        try {

            double numero = Double.parseDouble(txt.getText().replace("%", "").replace("$ ", "").replace(" ", ""));

            return numero;

        } catch (Exception e) {

            this.mensajes(3, "solo ingrese valores numericos.");

            txt.selectAll();
            txt.requestFocus();
            txt.setText("0");
            return 0;
        }

    }

    public void menu_emergente(JTable jTable) {

        try {

            DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
            System.out.println("seleccion " + jTable.getSelectedRow());
            modelo.removeRow(jTable.getSelectedRow());
            System.out.println("seleccion " + jTable.getSelectedRow());
            jTable.addRowSelectionInterval(0, 0);

            modelo = null;

        } catch (Exception l) {

            System.out.println("ERROR AL BORRAR DE LA TABLA: " + l);

        }

    }

    public void limpiar_tablas(JTable jTable) {

        DefaultTableModel temp1 = (DefaultTableModel) jTable.getModel();
        temp1.setRowCount(0);

    }

    public void llenarTabla(JTable table, Object[][] data) {

        if (data != null) {

            limpiar_tablas(table);

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            for (Object[] data1 : data) {

                tableModel.addRow(data1);

            }

        }

    }

    /* public ResultSet llenar_tablas(JTable jTable, String consulta) {

     Sql con = new Sql();

     java.sql.ResultSet result = (java.sql.ResultSet) con.consulta(consulta, false);

     limpiar_tablas(jTable);

     try {

     int b = jTable.getColumnCount();

     while (result.next()) {

     DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();

     Object[] fila = new Object[b];

     for (int i = 0; i < b; i++) {

     fila[i] = result.getObject(i + 1);

     }

     modelo.addRow(fila);

     }

     } catch (Exception e) {

     System.out.println("Error: Al llenar la Tabla \n" + e);
     }

     return (ResultSet) result;

     }

     public List<Object[]> llenarcombos(String sql) {

     List<Object[]> lista = null;
     Object[] listllena = null;

     try {

     lista = new ArrayList<Object[]>();
     Sql con = new Sql();

     lista = con.consulta(sql, false);

     for (Object[] lista1 : lista) {

     lista.add(lista1);

     }

     } catch (Exception e) {
     System.out.println("Error: " + e);
     }

     return lista;
     }*/
    public void Evento_Tablas(final JTable tabla, final JLabel label, final JLabel label2, final JLabel label3, final JTextField foco) {

        tabla.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tabla.rowAtPoint(e.getPoint());

                label.setText(tabla.getValueAt(row, 0).toString());
                label2.setText(tabla.getValueAt(row, 1).toString());
                label3.setText(tabla.getValueAt(row, 2).toString() + "  ");
                foco.selectAll();
                foco.requestFocus();

            }
        });

    }

    public void actualizar_tablas(JTable tabla1, JTable tabla2) {

        try {

            int fila = tabla2.getSelectedRow();
            int fila2 = tabla1.getRowCount();

            String codi = null, acucant;
            String cod = null, cant;

            for (int j = 0; j < fila2; j++) {

                codi = tabla1.getValueAt(j, 0).toString();
                acucant = tabla1.getValueAt(j, 2).toString();
                String costo = tabla1.getValueAt(j, 3).toString();

                int cantiext = Integer.parseInt(acucant);
                Double coste = Double.parseDouble(costo);

                cod = tabla2.getValueAt(fila, 0).toString();
                cant = tabla2.getValueAt(fila, 2).toString();

                int canti = Integer.parseInt(cant);

                if (cod == null ? codi == null : cod.equals(codi)) {

                    int acumcant = cantiext + canti;
                    Double totalcos = coste * acumcant;

                    tabla1.setValueAt(acumcant, j, 2);
                    tabla1.setValueAt(Redondear(totalcos), j, 4);

                    menu_emergente(tabla2);

                    return;

                }

            }

            if (cod == null ? codi != null : !cod.equals(codi)) {
                menu_emergente(tabla2);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, " SELECCIONE EL PRODUCTO ", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    // poner un icono a una ventana
    public void imagen(JLabel label) {

        ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("/imagenes/sello_facturado.jpg"));
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(170, 100, Image.SCALE_SMOOTH));
        label.setIcon(iconoEscalado);

    }

    public boolean Insertar_Imagen(JFileChooserCus file, String sentenciaSQL) {

        boolean rpta = false;

        try {

            File fichero = file.GetFileSelected();

            FileInputStream streamEntrada = new FileInputStream(fichero);

            CallableStatement pstmt = getConnection().prepareCall(sentenciaSQL);

            pstmt.setBinaryStream(1, streamEntrada, (int) fichero.length());

            pstmt.executeUpdate();

            pstmt.close();

            streamEntrada.close();

            rpta = true;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "NO ASIGNASTES EL LOGO ");

        }

        return rpta;

    }

    // ***AUN SIN IMPLEMENTAR!***
    public static float Redondear_Sifras(int decimales_a_dejar, double Ynumero) {

        String esqueletoF = "#.";

        for (int i = 0; i < decimales_a_dejar; i++) {
            esqueletoF += "0";
        }

        DecimalFormat formato = new DecimalFormat(esqueletoF);

        return Float.parseFloat(formato.format(Ynumero).replace(",", "."));

    }

    public void calcula_total_con_promedio(JTable Tabla, JLabel label, JTextField jtotal, int a, JTextField prome) {

        try {

            double acum = 0;
            int total = 0;
            long prom = 0;

            for (int i = 0; i <= Tabla.getRowCount() - 1; i++) {

                String t = String.valueOf(Tabla.getValueAt(i, a));
                double tv = Double.parseDouble(t);

                acum = acum + tv;

                total = total + 1;

                prom = (long) acum / total;
//        System.out.println(prom);
            }

            label.setText(formatoNum.numerico(total) + " ");
            jtotal.setText("$  " + formatoNum.numerico(Redondear(acum)) + " ");
            prome.setText("$  " + formatoNum.numerico(Redondear(prom)) + " ");

        } catch (Exception e) {

            System.out.println(e);
        }

    }

    /* public void TablasSql(String sql, JTable tabla) {

     try {

     Sql con = new Sql();

     DefaultTableModel model = (DefaultTableModel) tabla.getModel();

     List<Object[]> os = con.consulta(sql, false);
     for (Object[] objects : os) {

     model.addRow(objects);
     }

     } catch (Exception e) {
     }
     }*/
    public Object msjQuest(int opcion, Object msj) {

        msj = msj.toString().toUpperCase();
        Object r = 0;

        try {

            if (opcion == 1) {

                r = JOptionPane.showConfirmDialog(null, msj, "confirmar...", JOptionPane.YES_NO_OPTION);
                int rs = Integer.parseInt(r.toString());
                if (rs == JOptionPane.YES_OPTION) {
                    return r;
                }

            } else if (opcion == 2) {

                r = JOptionPane.showInputDialog(null, msj.toString().toUpperCase(), "Ingresar", JOptionPane.QUESTION_MESSAGE);
                System.out.println("precione cancelar " + r);
                if (r != null) {
                    int option = Integer.parseInt(r.toString());
                    if (option == JOptionPane.YES_NO_OPTION) {
                        return r;
                    }
                }
            }

        } catch (HeadlessException | NumberFormatException error) {

            mensajes(4, error.toString());
        }
        return r;
    }

    /*  public void ActivarDesactivaAlertas(int i) {
     Sql con = new Sql();

     String sql;

     if (i == 1) {

     sql = "update parametros set recordar_alerta = 1";
     con.ejecuta(sql);
     }

     if (i == 0) {

     sql = "update parametros set recordar_alerta = 0";
     con.ejecuta(sql);
     }

     }

     public int estadoAlerta() {

     Sql con = new Sql();

     String sql = "select recordar_alerta from parametros";

     return Integer.parseInt(con.getCampo(sql).toString());
     }

     public Date FormatearFechas(Object fecha) {

     Date fechaFin = null;

     SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
     SimpleDateFormat sqlformato = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

     try {

     fechaFin = sqlformato.parse(fecha.toString());

     } catch (Exception e) {

     mensajes(4, "error en formateo de fecha:\n" + e);
     }

     return fechaFin;
     }*/
    public String mesDeFecha(int mes) {
        String result = "";
        switch (mes) {

            case 0:
                result = "Enero";
                break;
            case 1:
                result = "Febrero";
                break;
            case 2:
                result = "Marzo";
                break;
            case 3:
                result = "Abril";
                break;
            case 4:
                result = "Mayo";
                break;
            case 5:
                result = "Junio";
                break;
            case 6:
                result = "Julio";
                break;
            case 7:
                result = "Agosto";
                break;
            case 8:
                result = "Septiembre";
                break;
            case 9:
                result = "Octubre";
                break;
            case 10:
                result = "Noviembre";
                break;
            case 11:
                result = "Diciembre";
                break;
            default:
                result = "Error";
                break;
        }

        return result.toUpperCase();

    }

    public String DiadeLaSemana(Date date) {
        String result = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int dia = 0;

        try {
            dia = calendar.get(Calendar.DAY_OF_WEEK);
        } catch (Exception e) {
        }

        switch (dia) {

            case 1:
                result = "Domingo";
                break;
            case 2:
                result = "Lunes";
                break;
            case 3:
                result = "Martes";
                break;
            case 4:
                result = "Miercoles";
                break;
            case 5:
                result = "Jueves";
                break;
            case 6:
                result = "viernes";
                break;
            case 7:
                result = "Sabado";
                break;
            default:
                result = "Error";
                break;
        }

        return result.toUpperCase();

    }
}
