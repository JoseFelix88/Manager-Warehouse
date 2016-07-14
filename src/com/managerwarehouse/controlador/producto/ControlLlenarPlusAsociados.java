
package com.managerwarehouse.controlador.producto;

import com.managerwarehouse.controlador.index.ControllerContenedor;
import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.vista.producto.FormListarPlu;
import javax.swing.JInternalFrame;
import javax.swing.SwingWorker;

public class ControlLlenarPlusAsociados extends SwingWorker<Object, Object> {
    ProductoDAO dAO;
    FormListarPlu formListarPlu;
    Edicion edicion = new Edicion();
    public ControlLlenarPlusAsociados(ProductoDAO dAO, FormListarPlu formListarPlu) {
        this.dAO = dAO;
        this.formListarPlu = formListarPlu;
    }
    @Override
    protected Boolean doInBackground() throws Exception {
        Object[][] datatable = dAO.PLUS_ASOCIADOS(dAO.getProductoDTO().getPlu());
        if (datatable != null) {
            edicion.llenarTabla(formListarPlu.TB_plus_asociados, datatable);
            JInternalFrame ji = validador.getJInternalFrame(FormListarPlu.class.getName());
            ji = formListarPlu;
            ControllerContenedor.getjDesktopPane1().add(ji, 0);
            validador.addJIframe(FormListarPlu.class.getName(), ji);
            ji.setVisible(true);
            return true;
        } else {
            edicion.mensajes(1, "el plu: " + dAO.getProductoDTO().getPlu() + " no tiene asocio con ningún producto.");
        }
        return false;
    }
}
