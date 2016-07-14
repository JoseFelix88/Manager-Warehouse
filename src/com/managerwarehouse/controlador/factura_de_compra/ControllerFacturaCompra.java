package com.managerwarehouse.controlador.factura_de_compra;

import com.managerwarehouse.controlador.index.ControllerContenedor;
import com.managerwarehouse.controlador.producto.ControlAsignarCum;
import com.managerwarehouse.controlador.producto.ControllerProducto;
import com.managerwarehouse.model.factura_de_compra.DetalleCompraDTO;
import com.managerwarehouse.model.factura_de_compra.FacturaCompraDAO;
import com.managerwarehouse.model.factura_de_compra.FacturaCompraDTO;
import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.model.producto.ProductoDTO;
import com.managerwarehouse.model.proveedor.ProveedorDTO;
import com.managerwarehouse.util.CambiaFormatoTexto;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.Metodos;
import com.managerwarehouse.util.Variables_Gloabales;
import com.managerwarehouse.vista.factura_de_compra.FormAddCantidadCompra;
import com.managerwarehouse.vista.factura_de_compra.FormFacturaCompra;
import com.managerwarehouse.vista.factura_de_compra.FormValorizarFactura;
import com.managerwarehouse.vista.index.Contenedor;
import com.managerwarehouse.vista.producto.FormAsignarCUM;
import com.managerwarehouse.vista.producto.FormListarPlu;
import com.managerwarehouse.vista.producto.FormProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.SwingWorker;

public class ControllerFacturaCompra extends SwingWorker<Object, Object> {

    public FormFacturaCompra formFacturaCompra;
    Edicion edicion = new Edicion();
    FacturaCompraDTO compraDTO = new FacturaCompraDTO();
    FacturaCompraDAO FcompraDAO = new FacturaCompraDAO();
    controlAddCantidadCompra addCantidadCompra = new controlAddCantidadCompra();
    ControllerProducto controllerProducto = new ControllerProducto();
    CambiaFormatoTexto formatoTexto = new CambiaFormatoTexto();
    FormProducto formProducto;

    public ControllerFacturaCompra() {
    }

    public ControllerFacturaCompra(FormFacturaCompra formFacturaCompra) {
        this.formFacturaCompra = formFacturaCompra;
        compraDTO.setDetalleCompraDTO(new DetalleCompraDTO());

    }

    private void accionesFormulario() {

        if (Variables_Gloabales.EMPLEADO.getNivel() != 2) {
            formFacturaCompra.JM_Valores.setEnabled(false);
        }
        llenarcombos();
        formFacturaCompra.JDfechaentrada.setDate(Calendar.getInstance().getTime());

        formFacturaCompra.txtcodigobarra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (GetFacturaCompra().getDetalleCompraDTO().getProductoDAO().getProductoDTO() != null) {
                    addCantidadCompra = new controlAddCantidadCompra(
                            formFacturaCompra, GetFacturaCompra());
                    addCantidadCompra.execute();
                }

            }
        });

        formFacturaCompra.JM_eliminar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int op = (int) edicion.msjQuest(1, "estas seguro que deseas eliminar el producto.");
                if (op == 0) {
                    int iddetalle = formFacturaCompra.TablaDetalle.getSelectedRow();
                    if (FcompraDAO.deleteDetalleCompra(formFacturaCompra.TablaDetalle.getValueAt(iddetalle, 0)) != false) {
                        edicion.menu_emergente(formFacturaCompra.TablaDetalle);
                        if (formFacturaCompra.TablaDetalle.getRowCount() <= 0) {
                            FcompraDAO.delete(formFacturaCompra.txtnumfactura.getText());
                        }
                    }
                }
            }
        });
        formFacturaCompra.JM_Valores.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int row = formFacturaCompra.TablaDetalle.getSelectedRow();
                Object[] key = {formFacturaCompra.TablaDetalle.getValueAt(row, 0), formFacturaCompra.TablaDetalle.getValueAt(row, 1),
                    formFacturaCompra.TablaDetalle.getValueAt(row, 2), formFacturaCompra.TablaDetalle.getValueAt(row, 3),
                    formFacturaCompra.TablaDetalle.getValueAt(row, 5), formFacturaCompra.TablaDetalle.getValueAt(row, 6), 
                    formFacturaCompra.txtnumfactura.getText()};

                JInternalFrame ji = validador.getJInternalFrame(FormValorizarFactura.class.getName());

                if (ji == null || ji.isClosed()) {

                    ji = new FormValorizarFactura(key,formFacturaCompra);
                    ControllerContenedor.getjDesktopPane1().add(ji, 0);
                    validador.addJIframe(FormValorizarFactura.class.getName(), ji);

                    ji.setVisible(true);

                } else {

                    ji.show(true);
                    try {
                        ji.setIcon(false);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(ControllerFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        formFacturaCompra.JM_nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compraDTO = new FacturaCompraDTO();
                formFacturaCompra.txtnumfactura.setText(compraDTO.getNumeroFactura());
                formFacturaCompra.JDfechaemision.setDate(compraDTO.getFechaFactura());
                formFacturaCompra.JDfechavencefactura.setDate(compraDTO.getFechaVenceFactura());
                formFacturaCompra.JDfechaentrada.setDate(compraDTO.getFechaIngreso());
                formFacturaCompra.txtnumremesa.setText(compraDTO.getNumeroRemesa());
                formFacturaCompra.comboproveedor.setSelectedItem(compraDTO.getProveedor());
                edicion.limpiar_tablas(formFacturaCompra.TablaDetalle);
            }
        });

        formFacturaCompra.JM_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int op = (int) edicion.msjQuest(1, "estas seguro que deseas salir?");

                if (op == 0) {
                    formFacturaCompra.dispose();
                }

            }
        });

        formFacturaCompra.JM_consultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object idfactura = edicion.msjQuest(2, "INGRESA EL NUMERO DE LA FACTURA DE COMPRA.");
                consultar_Factura(idfactura);
            }

        });
    }

    public void consultar_Factura(Object key) {
        FacturaCompraDTO dTO = FcompraDAO.read(key);
        if (dTO != null) {
            formFacturaCompra.txtnumfactura.setText(dTO.getNumeroFactura());
            formFacturaCompra.JDfechaemision.setDate(dTO.getFechaFactura());
            formFacturaCompra.JDfechavencefactura.setDate(dTO.getFechaVenceFactura());
            formFacturaCompra.JDfechaentrada.setDate(dTO.getFechaIngreso());
            formFacturaCompra.txtnumremesa.setText(dTO.getNumeroRemesa());
            formFacturaCompra.comboproveedor.setSelectedItem(dTO.getProveedor());
            edicion.llenarTabla(formFacturaCompra.TablaDetalle, FcompraDAO.readDetalle(dTO));
            edicion.calcula_total(formFacturaCompra.TablaDetalle, formFacturaCompra.lbitem,
                    formFacturaCompra.txtsubtotal, 10);
            edicion.calcula_total(formFacturaCompra.TablaDetalle, formFacturaCompra.lbitem,
                    formFacturaCompra.txtdescuentototal, 8);

            int grantotal = edicion.toNumeroEntero(formFacturaCompra.txtsubtotal.getText())
                    - edicion.toNumeroEntero(formFacturaCompra.txtdescuentototal.getText());
            formFacturaCompra.txttotalpagar.setText("$ " + formatoTexto.numerico(grantotal));
        } else {
            edicion.mensajes(1, "la factura no hacido registrada aun.");
        }
    }

    void llenarcombos() {
        List<ProveedorDTO> listdao = compraDTO.getProveedorDAO().readAll();
        for (ProveedorDTO listdao1 : listdao) {
            formFacturaCompra.comboproveedor.addItem(listdao1.getRazonSocial());
        }
    }

    @Override
    protected Object doInBackground() throws Exception {
        formFacturaCompra.show();
        accionesFormulario();
        formFacturaCompra.JM_usuario.setText("");
        Contenedor.Panel_Contenedor.add(formFacturaCompra);
        java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
        java.awt.Dimension Tamaño_InternalFrame = formFacturaCompra.getSize();
        formFacturaCompra.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
        return formFacturaCompra;
    }

    public FacturaCompraDTO GetFacturaCompra() {
        compraDTO.getDetalleCompraDTO().getProductoDAO().setProductoDTO(
                compraDTO.getDetalleCompraDTO().getProductoDAO().read(formFacturaCompra.txtcodigobarra.getText()));
        if (compraDTO.getDetalleCompraDTO().getProductoDAO().getProductoDTO() == null) {

            int confirmar = Integer.parseInt(edicion.msjQuest(1, "la referencia del producto no existe. deseas agregarla?").toString());
            if (confirmar == 0) {
                try {

                    if (Metodos.Obtener_Estado_Formulario(formProducto, Contenedor.Panel_Contenedor)) {
                        formProducto = new FormProducto();

                        controllerProducto = new ControllerProducto(formProducto, new FormAsignarCUM(),
                                new FormListarPlu());
                        controllerProducto.execute();
                        this.formFacturaCompra.setIcon(true);
                    } else {
                        formProducto.setIcon(false);
                    }

                } catch (PropertyVetoException ex) {
                    Logger.getLogger(ControllerFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else {

            compraDTO.getProveedorDAO().setProveedorDTO(compraDTO.getProveedorDAO().read(formFacturaCompra.comboproveedor.getSelectedItem()));

            formFacturaCompra.txtplu.setText(compraDTO.getDetalleCompraDTO().getProductoDAO().getProductoDTO().getPlu());
//            formFacturaCompra.txtexistencia.setText(formatoTexto.numerico(String.valueOf(compraDTO.getDetalleCompraDTO().getProductoDAO().getProductoDTO().getCantidadActual())));
            formFacturaCompra.txtdescripcion.setText(compraDTO.getDetalleCompraDTO().getProductoDAO().getProductoDTO().getDescripcion());
            compraDTO.setNumeroFactura(formFacturaCompra.txtnumfactura.getText());
            compraDTO.setFechaFactura(Date.valueOf(edicion.formatearFechaSQL(formFacturaCompra.JDfechaemision.getDate())));
            compraDTO.setFechaVenceFactura(Date.valueOf(edicion.formatearFechaSQL(formFacturaCompra.JDfechavencefactura.getDate())));
            compraDTO.setFechaIngreso(Date.valueOf(edicion.formatearFechaSQL(formFacturaCompra.JDfechaentrada.getDate())));
            compraDTO.setNumeroRemesa(formFacturaCompra.txtnumremesa.getText());
            compraDTO.setSubtotal(edicion.toNumeroEntero(formFacturaCompra.txtsubtotal.getText()));
            compraDTO.setDescuento(edicion.toNumeroEntero(formFacturaCompra.txtdescuentototal.getText()));
            compraDTO.setTotalnetoPago(edicion.toNumeroEntero(formFacturaCompra.txttotalpagar.getText()));

            if (formFacturaCompra.JRcontado.isSelected() == true) {
                compraDTO.setTipoPago(formFacturaCompra.JRcontado.getText());
            } else {
                compraDTO.setTipoPago(formFacturaCompra.JRcredito.getText());
            }

            compraDTO.setIva(edicion.toNumeroFloat(formFacturaCompra.txtIva.getText()));
            compraDTO.setReteFTE(edicion.toNumeroFloat(formFacturaCompra.txtReteFte.getText()));
            compraDTO.setReteICA(edicion.toNumeroFloat(formFacturaCompra.txtReteIca.getText()));
            compraDTO.setReteIVA(edicion.toNumeroFloat(formFacturaCompra.txtReteIva.getText()));
            compraDTO.getDetalleCompraDTO().setCodigoproducto(formFacturaCompra.txtcodigobarra.getText());

        }
        return compraDTO;

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
