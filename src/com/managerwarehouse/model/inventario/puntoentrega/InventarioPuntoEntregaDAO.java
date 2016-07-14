package com.managerwarehouse.model.inventario.puntoentrega;

import com.managerwarehouse.util.database;

public class InventarioPuntoEntregaDAO extends database {

    public Object[][] ConsumosYSaldosMensuales(Object[] key) {

        Object[][] rs = select("detalle_inventario_puntos\n"
                + "INNER JOIN inventariospuntoentrega ON detalle_inventario_puntos.inventario = inventariospuntoentrega.idinventariopunto\n"
                + "INNER JOIN puntos ON puntos.COD_PUNTO = inventariospuntoentrega.puntoentrega\n"
                + "INNER JOIN productosbase ON detalle_inventario_puntos.Plu = productosbase.plu",
                "productosbase.plu,\n"
                + "productosbase.descripcion,\n"
                + "sum(IFNULL(detalle_inventario_puntos.Salida,0)) AS salida,\n"
                + "detalle_inventario_puntos.inventariofisico",
                "puntos.NOMBRE = '" + key[0] + "' AND\n"
                + "inventariospuntoentrega.fechainicio BETWEEN '" + key[1] + "' AND '" + key[2] + "'\n"
                + "GROUP BY\n"
                + "productosbase.plu\n"
                + "ORDER BY\n"
                + "productosbase.descripcion ASC");

        return rs;
    }

   
    public Object[][] ConsumosYSaldosMensualesFiltrado(Object[] key) {

        Object[][] rs = select("detalle_inventario_puntos\n"
                + "INNER JOIN inventariospuntoentrega ON detalle_inventario_puntos.inventario = inventariospuntoentrega.idinventariopunto\n"
                + "INNER JOIN puntos ON puntos.COD_PUNTO = inventariospuntoentrega.puntoentrega\n"
                + "INNER JOIN productosbase ON detalle_inventario_puntos.Plu = productosbase.plu",
                "productosbase.plu,\n"
                + "productosbase.descripcion,\n"
                + "sum(IFNULL(detalle_inventario_puntos.Salida,0)) AS salida,\n"
                + "detalle_inventario_puntos.inventariofisico",
                "puntos.NOMBRE = '" + key[0] + "' AND\n"
                + "inventariospuntoentrega.fechainicio BETWEEN '" + key[1] + "' AND '" + key[2] + "' and productosbase.plu = '" + key[3] + "'\n"
                + "GROUP BY\n"
                + "productosbase.plu\n"
                + "ORDER BY\n"
                + "productosbase.descripcion ASC");

        return rs;
    }

    public Object[][] ConsultarInventarioPuntoEntrega(Object[] key) {
        Object[][] rs = select("detalle_inventario_puntos ,\n"
                + "inventariospuntoentrega ,\n"
                + "puntos ,\n"
                + "productosbase", "productosbase.plu,\n"
                + "productosbase.descripcion,\n"
                + "ifnull(detalle_inventario_puntos.InventarioInicial,0),\n"
                + "ifnull(detalle_inventario_puntos.Entrada,0),\n"
                + "ifnull(detalle_inventario_puntos.Devolucionentrada,0),\n"
                + "ifnull(detalle_inventario_puntos.Salida,0),\n"
                + "ifnull(detalle_inventario_puntos.Devolucionsalida,0),\n"
                + "ifnull(detalle_inventario_puntos.Salidasautorizada,0),\n"
                + "ifnull(detalle_inventario_puntos.inventariofinal,0),\n"
                + "ifnull(detalle_inventario_puntos.inventariofisico,0),\n"
                + "ifnull(detalle_inventario_puntos.Sobrante,0),\n"
                + "ifnull(detalle_inventario_puntos.Faltante,0)", "detalle_inventario_puntos.inventario = inventariospuntoentrega.idinventariopunto AND\n"
                + "detalle_inventario_puntos.Plu = productosbase.plu AND\n"
                + "inventariospuntoentrega.puntoentrega = puntos.COD_PUNTO AND\n"
                + "inventariospuntoentrega.fechainicio BETWEEN '" + key[1] + "' AND '" + key[2] + "' AND\n"
                + "puntos.NOMBRE = '" + key[0] + "'\n"
                + "GROUP BY\n"
                + "productosbase.plu ORDER BY productosbase.descripcion");
        if (rs.length > 0) {
            return rs;
        }
        return null;
    }

}
