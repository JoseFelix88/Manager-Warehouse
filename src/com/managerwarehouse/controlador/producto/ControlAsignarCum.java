package com.managerwarehouse.controlador.producto;

import com.managerwarehouse.controlador.index.ControllerContenedor;
import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.vista.producto.FormAsignarCUM;
import javax.swing.JInternalFrame;
import javax.swing.SwingWorker;

public class ControlAsignarCum extends SwingWorker<Object, Object> {

    FormAsignarCUM formAsignarCUM;
    Edicion edicion = new Edicion();
    ProductoDAO dAO;

    public ControlAsignarCum(FormAsignarCUM formAsignarCUM, ProductoDAO dAO) {
        this.formAsignarCUM = formAsignarCUM;
        this.dAO = dAO;
    }

    @Override
    protected Object doInBackground() throws Exception {

        JInternalFrame ji = validador.getJInternalFrame(FormAsignarCUM.class.getName());

        if (ji == null || ji.isClosed()) {

            if (llenarpresentaciones()) {
                ji = formAsignarCUM;
                ControllerContenedor.getjDesktopPane1().add(ji, 0);
                validador.addJIframe(FormAsignarCUM.class.getName(), ji);

                ji.setVisible(true);

                return true;
            } else {
                edicion.mensajes(1, "el numero de registro " + dAO.getProductoDTO().getRegistrosanitario() + "\n"
                        + "no produjo ningun resultado, Verificalo.");
            }

        } else {

            ji.setIcon(false);
        }

        return false;
    }

    private boolean llenarpresentaciones() {

        Object data[][] = dAO.PresentacionesDisponibles(dAO.getProductoDTO().getRegistrosanitario());

        if (data != null) {

            edicion.llenarTabla(formAsignarCUM.TB_Presentacion, data);
            return true;
        }

        return false;
    }

}
