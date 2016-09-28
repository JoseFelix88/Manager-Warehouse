package com.managerwarehouse.model.inventario;

import com.managerwarehouse.util.CambiaFormatoTexto;
import com.managerwarehouse.util.database;

public class InventarioDAO extends database {

    public Object[][] Trazabilidad_por_Producto_Bodega(Object[] key) {
        Object[][] rs = select("productosbase GROUP BY productosbase.plu ORDER BY productosbase.descripcion",
                "productosbase.plu,productosbase.descripcion,\n"
                + "conteo_fisico_bodega(productosbase.plu,'" + key[0] + "','" + key[1] + "') AS inventario_inicial,\n"
                + "compra_acumulada(productosbase.plu,'" + key[2] + "','" + key[3] + "') AS compra_acumulada,\n"
                + "devolucion_punto_acumulada(productosbase.plu,'" + key[2] + "','" + key[3] + "') AS devolucionespunto,\n"
                + "salida_acumulada(productosbase.plu,'" + key[2] + "','" + key[3] + "') AS salida_acumulada,0 as dev_proveedor,\n"
                + "salida_autorizada_acumulada(productosbase.plu,'" + key[2] + "','" + key[3] + "') AS salida_autorizada_acumulada,\n"
                + "saldofinal(conteo_fisico_bodega(productosbase.plu,'" + key[2] + "','" + key[3] + "'),"
                + "compra_acumulada(productosbase.plu,'" + key[0] + "','" + key[1] + "'),\n"
                + "devolucion_punto_acumulada(productosbase.plu,'" + key[2] + "','" + key[3] + "'),salida_acumulada(productosbase.plu,'" + key[0] + "','" + key[1] + "'),\n"
                + "salida_autorizada_acumulada(productosbase.plu,'" + key[0] + "','" + key[1] + "')) AS saldoFinal, "
                + "conteo_fisico_bodega(productosbase.plu,'" + key[0] + "','" + key[1] + "') as SaldoFisico, "
                + "if(diferencia_saldo_bodega(saldofinal(productosbase.plu,'" + key[0] + "','" + key[1] + "'),"
                + "saldofisicobodega(productosbase.plu,'" + key[0] + "','" + key[1] + "')) > 0,"
                + "diferencia_saldo_bodega(saldofinal(productosbase.plu,'" + key[0] + "','" + key[1] + "'),"
                + "saldofisicobodega(productosbase.plu,'" + key[0] + "','" + key[1] + "')),0 ),"
                + "IF(diferencia_saldo_bodega(saldofinal(productosbase.plu,'" + key[0] + "','" + key[1] + "'),"
                + "saldofisicobodega(productosbase.plu,'" + key[0] + "','" + key[1] + "')) < 0,"
                + "diferencia_saldo_bodega(saldofinal(productosbase.plu,'" + key[0] + "','" + key[1] + "'),"
                + "saldofisicobodega(productosbase.plu,'" + key[0] + "','" + key[1] + "'))*(-1),0)", null);
        if (rs.length > 0) {
            return rs;
        }
        return null;
    }

    public Object[][] ConsumosYSaldosMensualesGeneral(Object[] key) {

        Object[][] rs = select("productosbase\n"
                + "GROUP BY\n"
                + "productosbase.plu\n"
                + "ORDER BY\n"
                + "productosbase.descripcion ASC",
                "productosbase.plu,\n"
                + "productosbase.descripcion,\n"
                + "saldo_fisico_puntoentrega_inventario_general(productosbase.plu,'" + key[0] + "' ,'" + key[1] + "') AS Stock_puntoentrega,\n"
                + "IF(conteo_fisico_bodega(productosbase.plu,'" + key[0] + "' ,'" + key[1] + "' ) = 0,stocktotallotesalmacenados(productosbase.plu),conteo_fisico_bodega(productosbase.plu,'" + key[0] + "' ,'" + key[1] + "' )) AS stock_bodega,\n"
                + "consumo_puntoentrega_inventario_general(productosbase.plu,'" + key[0] + "' ,'" + key[1] + "' )  AS Salidas_En_PuntosEntrega,\n"
                + "saldo_fisico_puntoentrega_inventario_general(productosbase.plu,'" + key[0] + "' ,'" + key[1] + "') +\n"
                + "IF(conteo_fisico_bodega(productosbase.plu,'" + key[0] + "' ,'" + key[1] + "' ) = 0,stocktotallotesalmacenados(productosbase.plu),conteo_fisico_bodega(productosbase.plu,'" + key[0] + "' ,'" + key[1] + "' )) AS Stock_Total ",
                null);

        return rs;
    }

    public Object[][] CALCULO_PEDIDO_SUGERIDO(Object[] key) {
        Object[][] rs = select("productosbase\n"
                + "GROUP BY\n"
                + "productosbase.plu\n"
                + "ORDER BY\n"
                + "productosbase.descripcion ASC", "productosbase.plu,\n"
                + "productosbase.descripcion,\n"
                + "saldo_fisico_puntoentrega_inventario_general(productosbase.plu,'" + key[0] + "' , '" + key[1] + "') AS Stock_puntoentrega,\n"
                + "STOCK_GENERAL_BODEGA (productosbase.plu,'" + key[0] + "' , '" + key[1] + "')AS stock_bodega,\n"
                + "STOCK_GENERAL(productosbase.plu,'" + key[0] + "' , '" + key[1] + "') AS STOCK_GENERAL,\n"
                + "PROMEDIO_SALIDA_PUNTOENTREGA(productosbase.plu,'" + key[2] + "' , '" + key[3] + "') AS PROMEDIO_SALIDA_PUNTOENTREGA,\n"
                + "PEDIDO_SUGERIDO_PROVEEDOR(STOCK_GENERAL(productosbase.plu,'" + key[0] + "' , '" + key[1] + "'),"
                + "PROMEDIO_SALIDA_PUNTOENTREGA(productosbase.plu,'" + key[2] + "' , '" + key[3] + "') ," + key[4] + ") AS PEDIDO_SUGERIDO,"
                + "COSTE_NETO_PRODUCTO(productosbase.plu) AS COSTO_UNIDAD,\n"
                + "PEDIDO_SUGERIDO_PROVEEDOR(STOCK_GENERAL(productosbase.plu,'" + key[0] + "' , '" + key[1] + "'),"
                + "PROMEDIO_SALIDA_PUNTOENTREGA(productosbase.plu,'" + key[2] + "' , '" + key[3] + "') ," + key[4] + ") * COSTE_NETO_PRODUCTO(productosbase.plu) AS COSTO_TOTAL" + "", null);
        return rs;
    }

    public Object[][] Monitor_Consumos_SaldosFinales(Object[] key) {

        Object[][] rs = select("puntos,productosbase",
                "puntos.NOMBRE AS puntoentrega,\n"
                + "consumo_puntoentre_inventario(productosbase.plu,'" + key[0] + "' , '" + key[1] + "',puntos.NOMBRE ) AS Consumo,\n"
                + "saldo_fisico_puntoentrega_inventario (productosbase.plu,'" + key[0] + "' , '" + key[1] + "',puntos.NOMBRE ) AS Stock",
                "productosbase.plu = '" + key[2] + "' AND puntos.Tipo=1\n"
                + "GROUP BY\n"
                + "productosbase.plu, puntos.COD_PUNTO ORDER BY puntos.NOMBRE");

        if (rs.length > 0) {
            return rs;
        }
        return null;
    }

}
