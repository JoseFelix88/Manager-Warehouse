package com.managerwarehouse.controlador.factura_de_compra;

import com.managerwarehouse.controlador.index.ControllerContenedor;
import com.managerwarehouse.model.factura_de_compra.DetalleCompraDTO;
import com.managerwarehouse.model.factura_de_compra.FacturaCompraDAO;
import com.managerwarehouse.model.factura_de_compra.FacturaCompraDTO;
import com.managerwarehouse.model.producto.DispensarDAO;
import com.managerwarehouse.model.producto.DispensarDTO;
import com.managerwarehouse.util.CambiaFormatoTexto;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.Variables_Gloabales;
import com.managerwarehouse.vista.factura_de_compra.FormAddCantidadCompra;
import com.managerwarehouse.vista.factura_de_compra.FormFacturaCompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import javax.swing.JInternalFrame;
import javax.swing.SwingWorker;

public final class controlAddCantidadCompra extends SwingWorker<Object, Object> {

    FormAddCantidadCompra formAddCantidadCompra = new FormAddCantidadCompra();
    DetalleCompraDTO dTO;
    Edicion edicion = new Edicion();
    FormFacturaCompra facturaCompra;
    FacturaCompraDTO compraDTO;
    FacturaCompraDAO compraDAO = new FacturaCompraDAO();
    DispensarDAO dispensarDAO = new DispensarDAO();
    CambiaFormatoTexto formatoTexto = new CambiaFormatoTexto();

    public controlAddCantidadCompra(FormFacturaCompra facturaCompra, FacturaCompraDTO compraDTO) {
        this.facturaCompra = facturaCompra;
        this.compraDTO = compraDTO;
        accionesFormulario();

        if (Variables_Gloabales.EMPLEADO.getNivel() != 2) {
            formAddCantidadCompra.txtcostocaja.setEnabled(false);
            formAddCantidadCompra.txtcostounidad.setEnabled(false);
            formAddCantidadCompra.txtporcdescuento.setEnabled(false);
            formAddCantidadCompra.txtvrdescuento.setEnabled(false);
            formAddCantidadCompra.txtcostototal.setEnabled(false);
        }
    }

    public controlAddCantidadCompra() {
    }

    @Override
    protected Object doInBackground() throws Exception {

        JInternalFrame ji = validador.getJInternalFrame(FormAddCantidadCompra.class.getName());

        if (ji == null || ji.isClosed()) {
            ji = formAddCantidadCompra;
            ControllerContenedor.getjDesktopPane1().add(ji, 0);
            validador.addJIframe(FormAddCantidadCompra.class.getName(), ji);

            ji.setVisible(true);

        } else {

            ji.show(true);
            ji.setIcon(false);
        }

        return ji;
    }

    public void accionesFormulario() {

        formAddCantidadCompra.txtundcompradas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                compraDTO.setDetalleCompraDTO(getDetalleCompra());

                llenarTablaDetalle();
            }
        });

        formAddCantidadCompra.txtcostocaja.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calcularvaloresdetalle();
            }
        });

        formAddCantidadCompra.txtporcdescuento.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calcularvaloresdetalle();
            }
        });

        formAddCantidadCompra.txtcostocaja.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                formAddCantidadCompra.txtcostocaja.setText("$ "
                        + formatoTexto.numerico(
                                edicion.toNumeroEntero(formAddCantidadCompra.txtcostocaja.getText())));

            }

        });

    }

    void calcularvaloresdetalle() {
        int cantcajas = edicion.toNumeroEntero(formAddCantidadCompra.txtcantcajas.getText());
        int embalaje = edicion.toNumeroEntero(formAddCantidadCompra.txtembalaje.getText());
        int costoXcaja = edicion.toNumeroEntero(formAddCantidadCompra.txtcostocaja.getText());
        int undcompradas = cantcajas * embalaje;

        int totalcompra = costoXcaja * cantcajas;
        float costoXunidad = costoXcaja/embalaje;
        float porcDescuento = edicion.toNumeroFloat(formAddCantidadCompra.txtporcdescuento.getText()) / 100;
        if (porcDescuento > 1.0) {
            edicion.mensajes(1, "el % de descuento no puede ser mayor al 100%");
            return;
        }
        float descuento = totalcompra * porcDescuento;
//        System.out.println("TotalCompra: $ " + totalcompra + "\n%descuento: " + porcDescuento + "\nValor desCuento: $ " + descuento);
        float costoTotal = totalcompra - descuento;

        formAddCantidadCompra.txtvrdescuento.setText("$ "+formatoTexto.numerico(String.valueOf(descuento)));
        formAddCantidadCompra.txtundcompradas.setText(formatoTexto.numerico(String.valueOf(undcompradas)));
        formAddCantidadCompra.txtcostounidad.setText("$ " + formatoTexto.numerico(String.valueOf(costoXunidad)));
        formAddCantidadCompra.txtcostototal.setText("$ " + formatoTexto.numerico(String.valueOf(costoTotal)));

    }

    public DetalleCompraDTO getDetalleCompra() {

        if (dTO == null) {
            dTO = compraDTO.getDetalleCompraDTO();
        }

        dTO.setCodigoproducto(compraDTO.getDetalleCompraDTO().getCodigoproducto());
        dTO.setNumeroLote(formAddCantidadCompra.txtnumlote.getText());
        dTO.setFechaVenceLote(Date.valueOf(edicion.formatearFechaSQL(formAddCantidadCompra.JDfechavenceproducto.getDate())));
        dTO.setCantComprada(edicion.toNumeroEntero(formAddCantidadCompra.txtundcompradas.getText()));
        dTO.setCantCajas(edicion.toNumeroEntero(formAddCantidadCompra.txtcantcajas.getText()));
        dTO.setEmbalajeCaja(edicion.toNumeroEntero(formAddCantidadCompra.txtembalaje.getText()));
        dTO.setCostoCaja(edicion.toNumeroFloat(formAddCantidadCompra.txtcostocaja.getText()));
        dTO.setCostoTotal(edicion.toNumeroFloat(formAddCantidadCompra.txtcostototal.getText()));
        dTO.setCostoUnidad(edicion.toNumeroFloat(formAddCantidadCompra.txtcostounidad.getText()));
        dTO.setPorcDescuento(edicion.toNumeroFloat(formAddCantidadCompra.txtporcdescuento.getText()));
        dTO.setValorDescuento(edicion.toNumeroFloat(formAddCantidadCompra.txtvrdescuento.getText()));
//        dTO.getProductoDAO().getProductoDTO().getDispensarDTO().setLugar(formAddCantidadCompra.comboubicacion.getSelectedItem().toString());
        dTO.getProductoDAO().getProductoDTO().getDispensarDTO().setProducto(dTO.getProductoDAO().getProductoDTO().getItemproducto());

        if (formAddCantidadCompra.comboubicacion.getSelectedItem().equals("ALMACEN")) {

            Object cantenvia = edicion.msjQuest(2, "que cantidad vas a enviar al almacen?");

//            System.out.println(""+cantenvia.isEmpty());
            if (cantenvia != null | !cantenvia.toString().isEmpty()) {

                int cantidad_almacen = Integer.parseInt(cantenvia.toString());

                if (cantidad_almacen > dTO.getCantComprada()) {

                    edicion.mensajes(3, "la cantidad enviada al almacen no puede ser mayor a las unidades compradas.");

                } else {

                    // int unidades_almacenadas = dTO.getCantComprada() - cantidad_almacen;
                    dTO.getProductoDAO().getProductoDTO().setDispensarDTO(new DispensarDTO(formAddCantidadCompra.comboubicacion.getSelectedItem().toString(),
                            dTO.getNumeroLote(), cantidad_almacen, dTO.getProductoDAO().getProductoDTO().getDispensarDTO().getProducto()));
                }
            }
        }

        /*String dispensacion = "Ubicacion del producto:" + dTO.getProductoDAO().getProductoDTO().getDispensarDTO().getLugar() + "\n"
         + "No. de Lote: " + dTO.getNumeroLote() + "\nunidades compradas = " + dTO.getCantComprada() + "\n"
         + "cantidad enviada a almacen = " + dTO.getProductoDAO().getProductoDTO().getDispensarDTO().getCantidad_Almacen() + "\n"
         + "producto = " + dTO.getProductoDAO().getProductoDTO().getDispensarDTO().getProducto();*/
        //  edicion.mensajes(4, dispensacion);
        return dTO;
    }

    private void llenarTablaDetalle() {
        Object[][] dataTable;

        if (compraDAO.create(compraDTO)) {

            compraDAO.ingresarDetalleCompra(compraDTO);
           
            if (compraDTO.getDetalleCompraDTO().getProductoDAO().getProductoDTO().getDispensarDTO().getLugar() != null) {
                dispensarDAO.create(compraDTO.getDetalleCompraDTO().getProductoDAO().getProductoDTO().getDispensarDTO());
            }
            dataTable = compraDAO.readDetalle(compraDAO.read(compraDTO.getNumeroFactura()));

        } else {

            for (int i = 0; i < facturaCompra.TablaDetalle.getRowCount(); i++) {
                Object lote = facturaCompra.TablaDetalle.getValueAt(i, 11);
                Object codigobarra = facturaCompra.TablaDetalle.getValueAt(i, 1);
                Object porc_descuento = facturaCompra.TablaDetalle.getValueAt(i, 9);

                if (lote.equals(compraDTO.getDetalleCompraDTO().getNumeroLote())
                        && codigobarra.equals(compraDTO.getDetalleCompraDTO().getCodigoproducto()) && porc_descuento.equals(0)) {

                    edicion.mensajes(1, "el producto: " + compraDTO.getDetalleCompraDTO().getCodigoproducto() + " - "
                            + "" + facturaCompra.TablaDetalle.getValueAt(i, 2) + "\n"
                            + "con Lote # " + compraDTO.getDetalleCompraDTO().getNumeroLote() + "\n"
                            + "se encuentra agregado al detalle de la factura.");
                    return;
                }
            }

            compraDAO.ingresarDetalleCompra(compraDTO);
            if (compraDTO.getDetalleCompraDTO().getProductoDAO().getProductoDTO().getDispensarDTO().getLugar() != null) {
                dispensarDAO.create(compraDTO.getDetalleCompraDTO().getProductoDAO().getProductoDTO().getDispensarDTO());
            }

            dataTable = compraDAO.readDetalle(compraDAO.read(compraDTO.getNumeroFactura()));
        }
        edicion.llenarTabla(facturaCompra.TablaDetalle, dataTable);
        edicion.calcula_total(facturaCompra.TablaDetalle, facturaCompra.lbitem, facturaCompra.txtsubtotal, 10);
        edicion.calcula_total(facturaCompra.TablaDetalle, facturaCompra.lbitem, facturaCompra.txtdescuentototal, 8);
        int totalpagarfactura = edicion.toNumeroEntero(facturaCompra.txtsubtotal.getText()) - 
                edicion.toNumeroEntero(facturaCompra.txtdescuentototal.getText());
        facturaCompra.txttotalpagar.setText("$ "+formatoTexto.numerico(String.valueOf(totalpagarfactura)));
        formAddCantidadCompra.dispose();
        facturaCompra.txtcodigobarra.selectAll();
        facturaCompra.txtcodigobarra.requestFocus();

    }
}
