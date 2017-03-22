package com.managerwarehouse.controlador.index;

import com.managerwarehouse.controlador.factura_de_compra.ControllerFacturaCompra;
import com.managerwarehouse.controlador.producto.ControllerProductoAux;
import static com.managerwarehouse.util.Metodos.Obtener_Estado_Formulario;
import com.managerwarehouse.util.Variables_Gloabales;
import com.managerwarehouse.vista.contabilidad.activosfijos.FormActivoFijo;
import com.managerwarehouse.vista.factura_de_compra.FormCompras;
import com.managerwarehouse.vista.factura_de_compra.FormFacturaCompra;
import com.managerwarehouse.vista.factura_de_compra.FormOrdenCompra;
import com.managerwarehouse.vista.factura_de_compra.Formconsultacompraproducto;
import com.managerwarehouse.vista.index.Contenedor;
import com.managerwarehouse.vista.inventario.bodega.FormConsumoSaldoGeneral;
import com.managerwarehouse.vista.inventario.bodega.FormConteoFisicoBodega;
import com.managerwarehouse.vista.inventario.bodega.FormInventarioBodega;
import com.managerwarehouse.vista.inventario.bodega.FormPedidoSugerido;
import com.managerwarehouse.vista.inventario.puntoentrega.FormConsumoSaldoPunto;
import com.managerwarehouse.vista.inventario.puntoentrega.FormInventarioPuntoEntrega;
import com.managerwarehouse.vista.inventario.puntoentrega.FormPedidoPuntoEntrega;
import com.managerwarehouse.vista.inventario.puntoentrega.FormTrasladoMercancias;
import com.managerwarehouse.vista.producto.FormAsignarCUM;
import com.managerwarehouse.vista.producto.FormListarPlu;
import com.managerwarehouse.vista.producto.FormProducto;
import com.managerwarehouse.vista.producto.FormTemperaturaHumedad;
import com.managerwarehouse.vista.producto.Formlotealmacenado;
import com.managerwarehouse.vista.producto.devoluciones.FormDevolucionPunto;
import com.managerwarehouse.vista.producto.devoluciones.proveedor.FormDevolucionProveedor;
import com.managerwarehouse.vista.salidas_producto.FormConsultaSalidaProducto;
import com.managerwarehouse.vista.salidas_producto.FormSalidasProducto;
import com.managerwarehouse.vista.salidas_producto.autorizada.FormSalidasAutorizada;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.SwingWorker;

public class ControllerContenedor extends SwingWorker<Object, Object> {

    private static Contenedor contenedor;

    public static Contenedor getContenedor() {
        return contenedor;
    }
    FormProducto formProducto;
    FormAsignarCUM formAsignarCUM;
    FormListarPlu formListarPlu;
    FormFacturaCompra formFacturaCompra;
    Formlotealmacenado formlotealmacenado;
    FormSalidasProducto formSalidasProducto;
    FormDevolucionPunto formDevolucionPunto;
    FormSalidasAutorizada formSalidasAutorizada;
    Formconsultacompraproducto formconsultacompraproducto;
    FormConsultaSalidaProducto formConsultaSalidaProducto;
    FormConteoFisicoBodega formConteoFisicoBodega;
    FormConsumoSaldoPunto formConsumoSaldoPunto;
    FormInventarioPuntoEntrega formInventarioPuntoEntrega;
    FormInventarioBodega formInventarioBodega;
    FormPedidoPuntoEntrega formPedidoPuntoEntrega;
    FormConsumoSaldoGeneral formConsumoSaldoGeneral;
    FormOrdenCompra formOrdenCompra;
    FormTrasladoMercancias formTrasladoMercancias;
    FormDevolucionProveedor formDevolucionProveedor;
    FormPedidoSugerido formPedidoSugerido;
    FormTemperaturaHumedad formTemperaturaHumedad;
    FormCompras formCompras;
    FormActivoFijo formActivoFijo;

    private static JDesktopPane jDesktopPane1;

    public ControllerContenedor() {
    }

    public Contenedor Go() {

        if (contenedor == null) {

            contenedor = new Contenedor();
            contenedor.setVisible(true);
            Obtener_Eventos_De_SubMenu(contenedor.R_Producto);
            Obtener_Eventos_De_SubMenu(contenedor.JM_OrdenCompra);
            Obtener_Eventos_De_SubMenu(contenedor.R_compra);
            Obtener_Eventos_De_SubMenu(contenedor.R_Salida);
            Obtener_Eventos_De_SubMenu(contenedor.JM_conteofisico);
            Obtener_Eventos_De_SubMenu(contenedor.JMReporte);
            Obtener_Eventos_De_SubMenu(contenedor.JMReporteInOut);
            Obtener_Eventos_De_SubMenu(contenedor.JMReporteInvFisico);
            Obtener_Eventos_De_SubMenu(contenedor.JM_Lotes);
            Obtener_Eventos_De_SubMenu(contenedor.JM_DevolucionPunto);
            Obtener_Eventos_De_SubMenu(contenedor.JM_SalidaAutorizada);
            Obtener_Eventos_De_SubMenu(contenedor.JM_CompraProducto);
            Obtener_Eventos_De_SubMenu(contenedor.JM_despachoproducto);
            Obtener_Eventos_De_SubMenu(contenedor.JM_conteofisico);
            Obtener_Eventos_De_SubMenu(contenedor.JM_consumosaldopunto);
            Obtener_Eventos_De_SubMenu(contenedor.JM_inventariopunto);
            Obtener_Eventos_De_SubMenu(contenedor.JM_inventariobodega);
            Obtener_Eventos_De_SubMenu(contenedor.JM_pedidoPunto);
            Obtener_Eventos_De_SubMenu(contenedor.JM_ConsumoSaldoGeneral);
            Obtener_Eventos_De_SubMenu(contenedor.JM_OrdenCompra);
            Obtener_Eventos_De_SubMenu(contenedor.JM_trasladoproducto);
            Obtener_Eventos_De_SubMenu(contenedor.JM_DevolucionProveedor);
            Obtener_Eventos_De_SubMenu(contenedor.JM_pedidosugerido);
            Obtener_Eventos_De_SubMenu(contenedor.JM_temperaturahumedad);
            Obtener_Eventos_De_SubMenu(contenedor.JM_auxcompra);
            Obtener_Eventos_De_SubMenu(contenedor.JMACTIVOFIJO);
            contenedor.JM_Profile.setText(Variables_Gloabales.EMPLEADO.getNombreCompleto());
        } else {
            contenedor.setVisible(true);
        }
        return contenedor;
    }

    private void Obtener_Eventos_De_SubMenu(javax.swing.JMenuItem SubMenu) {
        SubMenu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evento) {
                try {
                    Obtener_Resultado_Click(evento);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(ControllerContenedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
    }

    private void Obtener_Resultado_Click(java.awt.event.ActionEvent evt) throws PropertyVetoException {
        switch (evt.getActionCommand()) {
            case "Gestionar Producto":
                if (Obtener_Estado_Formulario(this.formProducto, Contenedor.Panel_Contenedor)) {
                    formProducto = new FormProducto();
                    formAsignarCUM = new FormAsignarCUM();
                    formListarPlu = new FormListarPlu();
                    new ControllerProductoAux(formProducto, formAsignarCUM, formListarPlu).GO();
                    formProducto.show();
                    Contenedor.Panel_Contenedor.add(formProducto);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formProducto.getSize();
                    formProducto.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formProducto.setIcon(false);
                }
                break;
            case "Compra":
                if (Obtener_Estado_Formulario(this.formFacturaCompra, Contenedor.Panel_Contenedor)) {
                    formFacturaCompra = new FormFacturaCompra();
                    new ControllerFacturaCompra(formFacturaCompra).execute();
                } else {
                    formFacturaCompra.setIcon(false);
                }
                break;
            case "Lotes Almacenados":
                if (Obtener_Estado_Formulario(this.formlotealmacenado, Contenedor.Panel_Contenedor)) {
                    formSalidasProducto = new FormSalidasProducto();
                    formlotealmacenado = new Formlotealmacenado(formSalidasProducto);
                    formlotealmacenado.show();
                    Contenedor.Panel_Contenedor.add(formlotealmacenado);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formlotealmacenado.getSize();
                    formlotealmacenado.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formlotealmacenado.setIcon(false);
                }

                break;
            case "Generar Salida":
                if (Obtener_Estado_Formulario(this.formSalidasProducto, Contenedor.Panel_Contenedor)) {
                    formSalidasProducto = new FormSalidasProducto();
                    formSalidasProducto.show();
                    Contenedor.Panel_Contenedor.add(formSalidasProducto);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formSalidasProducto.getSize();
                    formSalidasProducto.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formSalidasProducto.setIcon(false);
                }
                break;
            case "devolucionpunto":
                if (Obtener_Estado_Formulario(this.formDevolucionPunto, Contenedor.Panel_Contenedor)) {
                    formDevolucionPunto = new FormDevolucionPunto();
                    formDevolucionPunto.show();
                    Contenedor.Panel_Contenedor.add(formDevolucionPunto);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formDevolucionPunto.getSize();
                    formDevolucionPunto.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formDevolucionPunto.setIcon(false);
                }
                break;
            case "Salida Autorizada":
                if (Obtener_Estado_Formulario(this.formSalidasAutorizada, Contenedor.Panel_Contenedor)) {
                    formSalidasAutorizada = new FormSalidasAutorizada();
                    formSalidasAutorizada.show();
                    Contenedor.Panel_Contenedor.add(formSalidasAutorizada);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formSalidasAutorizada.getSize();
                    formSalidasAutorizada.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formSalidasAutorizada.setIcon(false);
                }
                break;
            case "CompraProductos":
                if (Obtener_Estado_Formulario(this.formconsultacompraproducto, Contenedor.Panel_Contenedor)) {
                    formconsultacompraproducto = new Formconsultacompraproducto();
                    formconsultacompraproducto.show();
                    Contenedor.Panel_Contenedor.add(formconsultacompraproducto);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formconsultacompraproducto.getSize();
                    formconsultacompraproducto.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formconsultacompraproducto.setIcon(false);
                }
                break;
            case "Despachosproducto":
                if (Obtener_Estado_Formulario(this.formConsultaSalidaProducto, Contenedor.Panel_Contenedor)) {
                    formConsultaSalidaProducto = new FormConsultaSalidaProducto();
                    formConsultaSalidaProducto.show();
                    Contenedor.Panel_Contenedor.add(formConsultaSalidaProducto);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formConsultaSalidaProducto.getSize();
                    formConsultaSalidaProducto.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formConsultaSalidaProducto.setIcon(false);
                }
                break;
            case "Formconteofisico":
                if (Obtener_Estado_Formulario(this.formConteoFisicoBodega, Contenedor.Panel_Contenedor)) {
                    formConteoFisicoBodega = new FormConteoFisicoBodega();
                    formConteoFisicoBodega.show();
                    Contenedor.Panel_Contenedor.add(formConteoFisicoBodega);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formConteoFisicoBodega.getSize();
                    formConteoFisicoBodega.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formConteoFisicoBodega.setIcon(false);
                }
                break;
            case "formconsumosaldo":
                if (Obtener_Estado_Formulario(this.formConsumoSaldoPunto, Contenedor.Panel_Contenedor)) {
                    formConsumoSaldoPunto = new FormConsumoSaldoPunto();
                    formConsumoSaldoPunto.show();
                    Contenedor.Panel_Contenedor.add(formConsumoSaldoPunto);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formConsumoSaldoPunto.getSize();
                    formConsumoSaldoPunto.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formConsumoSaldoPunto.setIcon(false);
                }
                break;
            case "forminventariopunto":
                if (Obtener_Estado_Formulario(this.formInventarioPuntoEntrega, Contenedor.Panel_Contenedor)) {
                    formInventarioPuntoEntrega = new FormInventarioPuntoEntrega();
                    formInventarioPuntoEntrega.show();
                    Contenedor.Panel_Contenedor.add(formInventarioPuntoEntrega);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formInventarioPuntoEntrega.getSize();
                    formInventarioPuntoEntrega.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formInventarioPuntoEntrega.setIcon(false);
                }
                break;

            case "Forminventariobodega":
                if (Obtener_Estado_Formulario(this.formInventarioBodega, Contenedor.Panel_Contenedor)) {
                    formInventarioBodega = new FormInventarioBodega();
                    formInventarioBodega.show();
                    Contenedor.Panel_Contenedor.add(formInventarioBodega);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formInventarioBodega.getSize();
                    formInventarioBodega.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formInventarioBodega.setIcon(false);
                }
                break;

            case "formpedidopunto":
                if (Obtener_Estado_Formulario(this.formPedidoPuntoEntrega, Contenedor.Panel_Contenedor)) {
                    formPedidoPuntoEntrega = new FormPedidoPuntoEntrega();
                    formPedidoPuntoEntrega.show();
                    Contenedor.Panel_Contenedor.add(formPedidoPuntoEntrega);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formPedidoPuntoEntrega.getSize();
                    formPedidoPuntoEntrega.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formPedidoPuntoEntrega.setIcon(false);
                }
                break;

            case "formconsumosaldogeneral":
                if (Obtener_Estado_Formulario(this.formConsumoSaldoGeneral, Contenedor.Panel_Contenedor)) {
                    formConsumoSaldoGeneral = new FormConsumoSaldoGeneral();
                    formConsumoSaldoGeneral.show();
                    Contenedor.Panel_Contenedor.add(formConsumoSaldoGeneral);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formConsumoSaldoGeneral.getSize();
                    formConsumoSaldoGeneral.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formConsumoSaldoGeneral.setIcon(false);
                }
                break;

            case "Orden de Compra":
                if (Obtener_Estado_Formulario(this.formOrdenCompra, Contenedor.Panel_Contenedor)) {
                    formOrdenCompra = new FormOrdenCompra();
                    formOrdenCompra.show();
                    Contenedor.Panel_Contenedor.add(formOrdenCompra);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formOrdenCompra.getSize();
                    formOrdenCompra.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formOrdenCompra.setIcon(false);
                }

                break;

            case "TrasladosProductos":
                if (Obtener_Estado_Formulario(this.formTrasladoMercancias, Contenedor.Panel_Contenedor)) {
                    formTrasladoMercancias = new FormTrasladoMercancias();
                    formTrasladoMercancias.show();
                    Contenedor.Panel_Contenedor.add(formTrasladoMercancias);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formTrasladoMercancias.getSize();
                    formTrasladoMercancias.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formTrasladoMercancias.setIcon(false);
                }
                break;

            case "FormDevoproveedor":
                if (Obtener_Estado_Formulario(this.formDevolucionProveedor, Contenedor.Panel_Contenedor)) {
                    formDevolucionProveedor = new FormDevolucionProveedor();
                    formDevolucionProveedor.show();
                    Contenedor.Panel_Contenedor.add(formDevolucionProveedor);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formDevolucionProveedor.getSize();
                    formDevolucionProveedor.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formDevolucionProveedor.setIcon(false);
                }

                break;
            case "pedidosugerido":
                if (Obtener_Estado_Formulario(this.formPedidoSugerido, Contenedor.Panel_Contenedor)) {
                    formPedidoSugerido = new FormPedidoSugerido();
                    formPedidoSugerido.show();
                    Contenedor.Panel_Contenedor.add(formPedidoSugerido);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formPedidoSugerido.getSize();
                    formPedidoSugerido.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formPedidoSugerido.setIcon(false);
                }

                break;

            case "ctrltemphum":
                if (Obtener_Estado_Formulario(this.formTemperaturaHumedad, Contenedor.Panel_Contenedor)) {
                    formTemperaturaHumedad = new FormTemperaturaHumedad();
                    formTemperaturaHumedad.show();
                    Contenedor.Panel_Contenedor.add(formTemperaturaHumedad);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formTemperaturaHumedad.getSize();
                    formTemperaturaHumedad.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formTemperaturaHumedad.setIcon(false);
                }

                break;

            case "compraaux":
                if (Obtener_Estado_Formulario(this.formCompras, Contenedor.Panel_Contenedor)) {
                    formCompras = new FormCompras();
                    formCompras.show();
                    Contenedor.Panel_Contenedor.add(formCompras);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formCompras.getSize();
                    formCompras.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formCompras.setIcon(false);
                }

                break;
                
                 case "Formactivofijo":
                if (Obtener_Estado_Formulario(this.formActivoFijo, Contenedor.Panel_Contenedor)) {
                    formActivoFijo = new FormActivoFijo();
                    formActivoFijo.show();
                    Contenedor.Panel_Contenedor.add(formActivoFijo);
                    java.awt.Dimension Tamaño_Panel = Contenedor.Panel_Contenedor.getSize();
                    java.awt.Dimension Tamaño_InternalFrame = formActivoFijo.getSize();
                    formActivoFijo.setLocation((Tamaño_Panel.width - Tamaño_InternalFrame.width) / 2,
                            (Tamaño_Panel.height - Tamaño_InternalFrame.height) / 2);
                } else {
                    formActivoFijo.setIcon(false);
                }

                break;

            case "Salir":
                System.exit(0);
        }

    }

    public static JDesktopPane getjDesktopPane1() {
        jDesktopPane1 = Contenedor.Panel_Contenedor;
        return jDesktopPane1;
    }

    @Override
    protected Object doInBackground() throws Exception {

        Go();

        return this;
    }

}
