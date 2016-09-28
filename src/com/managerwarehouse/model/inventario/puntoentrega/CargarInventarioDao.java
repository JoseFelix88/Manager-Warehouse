package com.managerwarehouse.model.inventario.puntoentrega;

import com.managerwarehouse.util.database;

public class CargarInventarioDao extends database {

    public boolean REGISTRAR_CARGA_ENCABEZADO(String values) {
        return insert("inventariospuntoentrega", "idinventariopunto,fechainicio, fechafinal, puntoentrega", values);
    }

    public boolean REGISTRAR_CARGA_DETALLE(String values) {
        return insert("detalle_inventario_puntos", "INVENTARIO, PLU, INVENTARIOINICIAL,"
                + " ENTRADA, DEVOLUCIONENTRADA, SALIDA, DEVOLUCIONSALIDA, Salidasautorizada,"
                + "INVENTARIOFINAL,INVENTARIOFISICO,SOBRANTE,FALTANTE", values);
    }

    public Object NUMERO_CARGA() {
        Object[][] rs = select("inventariospuntoentrega", "max(idinventariopunto)+1", null);
        if (rs.length > 0) {
            return rs[0][0];
        }
        return null;
    }
}
