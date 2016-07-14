package com.managerwarehouse.controlador.producto;

import com.managerwarehouse.util.CambiaFormatoTexto;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.Test_CodigoAleatorio;

import com.managerwarehouse.vista.producto.FormAsignarCUM;
import com.managerwarehouse.vista.producto.FormListarPlu;
import com.managerwarehouse.vista.producto.FormProducto;
import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.model.producto.ProductoDTO;
import com.managerwarehouse.vista.index.Contenedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import javax.swing.SwingWorker;

public class ControllerProducto extends SwingWorker<Object, Object> {

    FormProducto formProducto;
    FormAsignarCUM formAsignarCUM;
    FormListarPlu formListarPlu;
    Edicion edicion = new Edicion();
    ProductoDAO productoDAO = new ProductoDAO();
    int SI_O_NO;
    CambiaFormatoTexto formatoTexto = new CambiaFormatoTexto();
    Test_CodigoAleatorio codigoAleatorio = new Test_CodigoAleatorio();

    ControlLlenarPlusAsociados mostrarPlus;
    ControlAsignarCum controlAsignarCum;

    public ControllerProducto() {
    }

    public ControllerProducto(FormProducto formProducto, FormAsignarCUM formAsignarCUM, FormListarPlu flp) {
        this.formProducto = formProducto;
        this.formAsignarCUM = formAsignarCUM;
        this.formListarPlu = flp;
    }

    public void GO() {

        //RestrictedTextField restrictedTextField = new RestrictedTextField(formProducto.txt_plu);
        accionesFormulario();
        nuevo();
    }

    private void accionesFormulario() {

        formProducto.txtregsanitario.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                productoDAO.getProductoDTO().setRegistrosanitario(formProducto.txtregsanitario.getText());
                controlAsignarCum = new ControlAsignarCum(formAsignarCUM, productoDAO);
                controlAsignarCum.execute();
            }
        });

        formProducto.txt_plu.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (formProducto.txt_plu.getText().length() == 4) {

                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

        formProducto.txt_plu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                productoDAO.getProductoDTO().setPlu(formProducto.txt_plu.getText());
                mostrarPlus = new ControlLlenarPlusAsociados(productoDAO, formListarPlu);
                mostrarPlus.execute();
            }
        });

        formProducto.txtCodBarras.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (formProducto.txtCodBarras.getText().equals("")) {

                    edicion.mensajes(1, "Escanea O ingresa el codigo de barras del producto");

                } else {

                    seteardatos(productoDAO.read(formProducto.txtCodBarras.getText()));
                }

            }

        });

        formProducto.lb_AsignaCodigoBarras.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                Object codbarras = edicion.msjQuest(2, "escanea o digita el codigo de barras.");

                try {
                    productoDAO.getProductoDTO().setCodigobarras(codbarras.toString());
                    if ("".equals(productoDAO.getProductoDTO().getCodigobarras())) {
                        edicion.mensajes(1, "escanea o digita el codigo de barras.");
                        return;
                    } else if (productoDAO.VerificarCodigoBarras(productoDAO.getProductoDTO().getCodigobarras()) == true) {
                        edicion.mensajes(1, "el codigo de barras está asignado a un producto por favor verificalo.");
                        seteardatos(productoDAO.read(productoDAO.getProductoDTO().getCodigobarras()));
                        return;
                    }
                    productoDAO.getProductoDTO().setItemproducto(Integer.valueOf(formProducto.txtidproducto.getText()));
                    if (productoDAO.AsiganarCodigoBarras(productoDAO.getProductoDTO()) == false) {

                        edicion.mensajes(2, "codigo de barras asignado correctamente.");
                        seteardatos(productoDAO.read(productoDAO.getProductoDTO().getCodigobarras()));

                    }
                } catch (Exception error) {
                    edicion.mensajes(3, "No fue posible asignar el codigo de barras.");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

        formListarPlu.TB_plus_asociados.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    int row = formListarPlu.TB_plus_asociados.rowAtPoint(e.getPoint());
                    if (formListarPlu.TB_plus_asociados.getValueAt(row, 5).equals("ACTIVO")) {
                        seteardatos(productoDAO.read(formListarPlu.TB_plus_asociados.getValueAt(row, 0)));
                    } else {
                        edicion.mensajes(3, "el cum se encuentra inactivo por favor verificalo.");
                    }
                }
            }
        });

        formAsignarCUM.TB_Presentacion.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    int row = formAsignarCUM.TB_Presentacion.rowAtPoint(e.getPoint());
                    tomardatospresentacion();

                }
            }

            private void tomardatospresentacion() {
                ProductoDTO dTO = productoDAO.getProductoDTO();

                int fila = formAsignarCUM.TB_Presentacion.getSelectedRow();
                JTable tabla = formAsignarCUM.TB_Presentacion;
                dTO.setEstadocum(tabla.getValueAt(fila, 3).toString());
                if (dTO.getEstadocum().equals("ACTIVO")) {

                    formProducto.txtcum.setText(tabla.getValueAt(fila, 0).toString());
                    formProducto.txtestadocum.setText(dTO.getEstadocum());
                    formProducto.txtestadoregsanitario.setText(dTO.getEstadoregistro());

                    formProducto.txtlaboratorio.setText(tabla.getValueAt(fila, 4).toString());
                    formProducto.txtpresentacion.setText(tabla.getValueAt(fila, 2).toString());
                    formProducto.txttitularreg.setText(tabla.getValueAt(fila, 4).toString());
                    if (dTO.getTiporol().equals("FABRICANTE")) {
                        formProducto.jrfabrica.setSelected(true);
                    } else {
                        formProducto.jrimporta.setSelected(true);
                    }

                    formProducto.txtcodatc.setText(dTO.getAtc());
                    formProducto.txtdescatc.setText(dTO.getDescripcionatc());
                    formProducto.txtPactivo.setText(dTO.getPrincipioactivo());
                    formProducto.txtUmedida.setText(dTO.getUnidadmedida());
                    formProducto.txtviadmin.setText(dTO.getViaadministracion());
                    formProducto.txtformafarma.setText(dTO.getFormafarmaceutica());
                    formProducto.txtcanconcentrada.setText(dTO.getCantidadconcentrada());
                    formProducto.txtnomcomercial.setText(dTO.getComercial());
                    formAsignarCUM.dispose();

                } else {

                    edicion.mensajes(3, "EL CUM NO SE ENCUENTRA ACTIVO POR FAVOR VERIFICALO.");
                }
            }

        });

        formProducto.txtregsanitario.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                formProducto.txtregsanitario.setText(
                        formProducto.txtregsanitario.getText().toUpperCase());

            }
        });

        Obtener_Eventos_De_SubMenu(formProducto.JM_Nuevo);
        Obtener_Eventos_De_SubMenu(formProducto.JM_Guardar);
        Obtener_Eventos_De_SubMenu(formProducto.JM_Modificar);
        Obtener_Eventos_De_SubMenu(formProducto.JM_Consultar);
        Obtener_Eventos_De_SubMenu(formProducto.JM_Salir);

    }

    private void Obtener_Eventos_De_SubMenu(javax.swing.JMenuItem SubMenu) {

        SubMenu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evento) {

                Obtener_Resultado_Click(evento);
            }
        });
    }

    private void Obtener_Resultado_Click(ActionEvent evento) {
        String comando = evento.getActionCommand();

        switch (comando) {

            case "Nuevo":
                nuevo();
                break;
            case "Guardar":
                SI_O_NO = (int) edicion.msjQuest(1, "estas seguro que deseas REGISTRAR EL PRODUCTO?");
                if (SI_O_NO == 0) {
                    GuardarProducto();
                }
                break;
            case "Modificar":
                SI_O_NO = (int) edicion.msjQuest(1, "estas seguro que deseas MODIFICAR EL PRODUCTO?");
                if (SI_O_NO == 0) {
                    modificarproducto();
                }
                break;

            case "Consultar":
                ConsultaProducto();
                break;
            case "Salir":
                SI_O_NO = (int) edicion.msjQuest(1, "estas seguro que deseas salir?");
                if (SI_O_NO == 0) {
                    formProducto.dispose();
                }
                break;
        }
    }

    private void nuevo() {

        seteardatos(null);
        productoDAO.getProductoDTO().setPlu(codigoAleatorio.getCodigoAleatorioNumerico());
        if (productoDAO.GenararPlu(productoDAO.getProductoDTO()) == false) {
            formProducto.txt_plu.setText(productoDAO.getProductoDTO().getPlu());
        }

    }

    private void GuardarProducto() {

        productoDAO.getProductoDTO().setPlu(formProducto.txt_plu.getText());
        productoDAO.getProductoDTO().setCodigobarras(formProducto.txtCodBarras.getText());
        if (productoDAO.VerificarCodigoBarras(productoDAO.getProductoDTO().getCodigobarras()) == false
                && productoDAO.GenararPlu(productoDAO.getProductoDTO()) == true
                | productoDAO.GenararPlu(productoDAO.getProductoDTO()) == false) {

            productoDAO.create(SetearData());
            edicion.mensajes(2, "producto registrado correctamente.");

        } else {
            edicion.mensajes(3, "el producto se encuentra registrado.");
        }
    }

    private void modificarproducto() {

        productoDAO.getProductoDTO().setPlu(formProducto.txt_plu.getText());
        productoDAO.getProductoDTO().setCodigobarras(formProducto.txtCodBarras.getText());

        if (productoDAO.VerificarCodigoBarras(productoDAO.getProductoDTO().getCodigobarras()) == true
                && productoDAO.GenararPlu(productoDAO.getProductoDTO()) == true) {

            productoDAO.update(SetearData());

            edicion.mensajes(2, "producto modificado correctamente.");
        } else {
            edicion.mensajes(3, "el plu o codigo de barras del producto aun no han sido registrados.");
        }

    }

    private boolean llenarpresentaciones() {

        Object data[][] = productoDAO.PresentacionesDisponibles(formProducto.txtregsanitario.getText());

        if (data != null) {

            formProducto.txtestadoregsanitario.setText(productoDAO.getProductoDTO().getEstadoregistro().toUpperCase());
            edicion.llenarTabla(formAsignarCUM.TB_Presentacion, data);
            return true;
        }

        return false;
    }

    private boolean LlenarPlusAsociados() {

        Object data[][] = productoDAO.PLUS_ASOCIADOS(formProducto.txt_plu.getText());

        if (data != null) {

            edicion.llenarTabla(formListarPlu.TB_plus_asociados, data);
            return true;
        }

        return false;
    }

    void seteardatos(ProductoDTO dTO) {

        /*if (dTO == null) {
            dTO = new ProductoDTO();
                    //0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, Float.NaN, 0, 0, 0, null, null, null, "", "");
        }*/

        if (dTO != null) {
            //DATOS GENERALES...
            formProducto.txtidproducto.setText(String.valueOf(dTO.getItemproducto()));
            formProducto.txt_plu.setText(dTO.getPlu());
            formProducto.txtCodBarras.setText(dTO.getCodigobarras());
            formProducto.txtdescripcion.setText(dTO.getDescripcion());
            formProducto.txtnomcomercial.setText(dTO.getComercial());
            formProducto.combocanal.setSelectedItem(dTO.getCanal());
            formProducto.combopos.setSelectedItem(dTO.getPos());

            //DATOS DEL FABRICANTO y/o IMPORTADOR...
            formProducto.txtregsanitario.setText(dTO.getRegistrosanitario());
            formProducto.txtestadoregsanitario.setText(dTO.getEstadoregistro());
            formProducto.txtcum.setText(dTO.getCum());
            formProducto.txtestadocum.setText(dTO.getEstadocum());
            formProducto.txtlaboratorio.setText(dTO.getLaboratorio());
            formProducto.txtpresentacion.setText(dTO.getPresentacion());
            formProducto.txttitularreg.setText(dTO.getLaboratorio());
            formProducto.txtnombrerol.setText(dTO.getElaborado());
            formProducto.txtmodalidad.setText(dTO.getModalidad());

            if (dTO.getTiporol() == null) {
                dTO.setTiporol("");
                formProducto.jrfabrica.setSelected(false);
                formProducto.jrimporta.setSelected(false);
            }
            if (dTO.getTiporol().equals("FABRICANTE")) {
                formProducto.jrfabrica.setSelected(true);
            } else {
                formProducto.jrimporta.setSelected(true);
            }

            //DATOS TECNICOS...
            formProducto.txtcodatc.setText(dTO.getAtc());
            formProducto.txtdescatc.setText(dTO.getDescripcionatc());
            formProducto.txtPactivo.setText(dTO.getPrincipioactivo());
            formProducto.txtUmedida.setText(dTO.getUnidadmedida());
            formProducto.txtviadmin.setText(dTO.getViaadministracion());
            formProducto.txtformafarma.setText(dTO.getFormafarmaceutica());
            formProducto.txtcanconcentrada.setText(dTO.getCantidadconcentrada());

            //DATOS CONTABLES & STOCK...
            formProducto.txtcosto.setText("$ " + CambiaFormatoTexto.numerico(dTO.getCosto()));
            formProducto.txtprecioventa.setText("$ " + formatoTexto.numerico(dTO.getPrecioVenta()));
            formProducto.txtstocactual.setText(formatoTexto.numerico(dTO.getCantidadActual()));
            formProducto.txtstockaviso.setText(formatoTexto.numerico(dTO.getCantiadAvisar()));
            formProducto.txtstockminimo.setText(formatoTexto.numerico(dTO.getCantidadMinima()));

        }
    }

    public ProductoDTO SetearData() {

        ProductoDTO dTO = new ProductoDTO();

        //DATOS GENERALES...
        
        dTO.setItemproducto(Integer.valueOf(formProducto.txtidproducto.getText()));
        dTO.setPlu(formProducto.txt_plu.getText());
        dTO.setCodigobarras(formProducto.txtCodBarras.getText());
        dTO.setDescripcion(formProducto.txtdescripcion.getText());
        dTO.setComercial(formProducto.txtnomcomercial.getText());
        dTO.setCanal(formProducto.combocanal.getSelectedItem().toString());
        dTO.setPos(formProducto.combopos.getSelectedItem().toString());

        //DATOS FABRICANTE Y/O IMPORTADOR...
        dTO.setRegistrosanitario(formProducto.txtregsanitario.getText());
        dTO.setEstadoregistro(formProducto.txtestadoregsanitario.getText());
        dTO.setLaboratorio(formProducto.txtlaboratorio.getText());
        dTO.setPresentacion(formProducto.txtpresentacion.getText());
        dTO.setCum(formProducto.txtcum.getText());
        dTO.setEstadocum(formProducto.txtestadocum.getText());
        dTO.setElaborado(formProducto.txtnombrerol.getText());

        if (formProducto.jrfabrica.isSelected() == true) {
            dTO.setTiporol(formProducto.jrfabrica.getText());
        } else {
            dTO.setTiporol(formProducto.jrimporta.getText());
        }

        dTO.setModalidad(formProducto.txtmodalidad.getText());

        //DATOS TECNICOS...
        dTO.setAtc(formProducto.txtcodatc.getText());
        dTO.setDescripcionatc(formProducto.txtdescatc.getText());
        dTO.setPrincipioactivo(formProducto.txtPactivo.getText());
        dTO.setUnidadmedida(formProducto.txtUmedida.getText());
        dTO.setViaadministracion(formProducto.txtviadmin.getText());
        dTO.setFormafarmaceutica(formProducto.txtformafarma.getText());
        dTO.setCantidadconcentrada(formProducto.txtcanconcentrada.getText());

        //DATOS CONTABLES & STOCK
        dTO.setCosto(edicion.conversor_de_numeros_decimales(formProducto.txtcosto));
        dTO.setPrecioVenta(Integer.parseInt("" + edicion.conversor_de_numeros(formProducto.txtprecioventa)));
        dTO.setCantidadActual(Integer.valueOf(formProducto.txtstocactual.getText()));
        dTO.setCantiadAvisar(Integer.valueOf(formProducto.txtstockaviso.getText()));
        dTO.setCantidadMinima(Integer.valueOf(formProducto.txtstockminimo.getText()));

        return dTO;
    }

    private void ConsultaProducto() {

        Object codbarras = edicion.msjQuest(2, "escanea o digita el codigo de barras.");

        try {
            productoDAO.getProductoDTO().setCodigobarras(codbarras.toString());
            if ("".equals(productoDAO.getProductoDTO().getCodigobarras())) {
                edicion.mensajes(1, "escanea o digita el codigo de barras.");

            } else if (productoDAO.VerificarCodigoBarras(productoDAO.getProductoDTO().getCodigobarras()) == true) {

                seteardatos(productoDAO.read(productoDAO.getProductoDTO().getCodigobarras()));

            } else {
                edicion.mensajes(3, "el codigo de barras aun no ha sido asignado aun producto.");
            }

        } catch (Exception error) {
            edicion.mensajes(3, "No fue posible encontrar el codigo de barras.");
        }
    }

    @Override
    protected Object doInBackground() throws Exception {
        formProducto.show(true);
        
        GO();
        Contenedor.Panel_Contenedor.add(formProducto);
        java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
        java.awt.Dimension Tamaño_InternalFrame = formProducto.getSize();
        formProducto.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
        return formProducto;
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
