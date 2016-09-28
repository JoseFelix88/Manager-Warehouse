package com.managerwarehouse.model.inventario.puntoentrega;

import com.managerwarehouse.model.puntoentrega.PuntoEntregaDAO;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.database;

public class PedidoPuntoEntregaDAO extends database {

    Edicion edicion = new Edicion();

    public boolean RegistrarPedido(PedidoPuntoEntrega ppe) {
        String values = "" + ppe.getNumpedido() + ",now()," + ppe.getPuntoEntrega().getIdpunto() + ", "
                + "'" + ppe.getFechaini() + "', '" + ppe.getFechafin() + "', '" + ppe.getPorcenvio() + "'";
        return insert("pedidos_puntos", "numpedido,fechaemision, puntoentrega, fechaini, fechafin, porcenvio", values);
    }

    public PedidoPuntoEntrega consultarpedidopunto(Object key) {
        PedidoPuntoEntrega ppe = null;
        PuntoEntregaDAO pedao = new PuntoEntregaDAO();
        try {

            Object[][] rs = select("pedidos_puntos", "numpedido, fechaemision,"
                    + " puntoentrega, fechaini, fechafin, porcenvio", "numpedido = " + key + "");
            if (rs.length > 0) {

                ppe = new PedidoPuntoEntrega(edicion.toNumeroEntero(rs[0][0].toString()),
                        edicion.formatearFechaSQL(rs[0][1].toString()), pedao.read(rs[0][2]),
                        rs[0][3].toString(), rs[0][4].toString(), rs[0][5].toString());
            }

        } catch (Exception e) {
            System.out.println("error en dao pedido punto: " + e);
        }
        return ppe;
    }

    public Object[][] numeropedido() {
        Object[][] rs = select("pedidos_puntos", "ifnull(max(numpedido)+1,1)", null);
        if (rs.length > 0) {
            return rs;
        }
        return null;
    }

    public Object[][] PedidoSugeridoPuntoEntrega(Object[] key) {
        float porc_envio = Float.parseFloat(key[3].toString()) / 100;
        Object[][] rs = select("productosbase\n"
                + "GROUP BY\n"
                + "productosbase.plu\n"
                + "ORDER BY\n"
                + "productosbase.descripcion ASC",
                "productosbase.plu,\n"
                + "productosbase.descripcion,\n"
                + "consumo_puntoentre_inventario(productosbase.plu,'" + key[0] + "','" + key[1] + "','" + key[2] + "') AS consumo_X_Inventario,\n"
                + "saldo_fisico_puntoentrega_inventario(productosbase.plu,'" + key[0] + "','" + key[1] + "','" + key[2] + "') AS SaldoFisicoPuntoEntrega,\n"
                + "ROUND((consumo_puntoentre_inventario(productosbase.plu,'" + key[0] + "','" + key[1] + "','" + key[2] + "') + \n"
                + "(consumo_puntoentre_inventario(productosbase.plu,'" + key[0] + "','" + key[1] + "','" + key[2] + "') * " + porc_envio + "))) AS EnvioSuguerido,"
                + "ROUND((consumo_puntoentre_inventario(productosbase.plu,'" + key[0] + "','" + key[1] + "','" + key[2] + "') + \n"
                + "(consumo_puntoentre_inventario(productosbase.plu,'" + key[0] + "','" + key[1] + "','" + key[2] + "') * " + porc_envio + ")))+\n"
                + "saldo_fisico_puntoentrega_inventario(productosbase.plu,'" + key[0] + "','" + key[1] + "','" + key[2] + "') AS STOCK_MENSUAL,"
                + "ROUND((consumo_puntoentre_inventario(productosbase.plu,'" + key[0] + "','" + key[1] + "','" + key[2] + "')+ "
                + "(consumo_puntoentre_inventario(productosbase.plu,'" + key[0] + "','" + key[1] + "','" + key[2] + "') * " + porc_envio + "))/2) AS Pedido_1,"
                + "ROUND((consumo_puntoentre_inventario(productosbase.plu,'" + key[0] + "','" + key[1] + "','" + key[2] + "') + \n"
                + "(consumo_puntoentre_inventario(productosbase.plu,'" + key[0] + "','" + key[1] + "','" + key[2] + "') * " + porc_envio + "))/2) AS Pedido_2,"
                        + "stocktotallotesalmacenados(productosbase.plu)",
                null);

        if (rs.length > 0) {
            return rs;
        }
        return null;
    }

    public void ingresarDetallePedido(Object[] key) {
        insertSP("agregar_detalle_pedido", key);
    }

    public Object[][] DetallePedido(Object key) {
        Object[][] rs = select("pedidos_puntos ,\n"
                + "detalle_pedidos_puntos ,\n"
                + "productosbase", "productosbase.plu,\n"
                + "productosbase.descripcion,0 as consumo,0 as saldofisico,0 AS sugerido,0 AS StockMensual,\n"
                + "detalle_pedidos_puntos.cantdespachada,\n"
                + "detalle_pedidos_puntos.cantpendiente", "pedidos_puntos.numpedido = detalle_pedidos_puntos.pedido AND\n"
                + "detalle_pedidos_puntos.producto = productosbase.plu AND\n"
                + "pedidos_puntos.numpedido = "+key+"\n"
                + "GROUP BY\n"
                + "productosbase.plu\n"
                + "ORDER BY\n"
                + "productosbase.descripcion ASC");
        return rs;
    }
}
