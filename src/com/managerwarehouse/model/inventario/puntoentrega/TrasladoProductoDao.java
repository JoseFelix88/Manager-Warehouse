package com.managerwarehouse.model.inventario.puntoentrega;

import com.managerwarehouse.model.puntoentrega.PuntoEntregaDAO;
import com.managerwarehouse.model.usuario_system.EmpleadoDAO;
import com.managerwarehouse.util.DateUtil;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.database;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrasladoProductoDao extends database {

    public boolean CRUD_TRASLADO(Object[] key) {
        return insertSP("CRUD_TRASLADO_PRODUCTO", key);
    }

    public boolean DELETE_DETALLE(Object key) {
        return Delete("detalle_traslado_productos", "iddetalletraslado = "+key+"");
    }

    public TrasladoProducto CONSULTA_TRASLADO(Object key) {
        TrasladoProducto tp = null;
        PuntoEntregaDAO pedao;
        EmpleadoDAO edao;
        Object[][] rs = select("trasladoproductos", "numtraslado, "
                + "fechaemision, bodegaorigen, bodegadestino, "
                + "autorizado, realizado, fechahoraingreso",
                " numtraslado = '" + key + "'");
        if (rs.length > 0) {
            try {
                pedao = new PuntoEntregaDAO();
                edao = new EmpleadoDAO();
                tp = new TrasladoProducto(rs[0][0].toString(),
                        DateUtil.toDate(rs[0][1]), pedao.read(rs[0][2]), pedao.read(rs[0][3]),
                        rs[0][4].toString(), edao.read(rs[0][5]), DateUtil.toDateTime(rs[0][6]));
            } catch (ParseException ex) {
                Logger.getLogger(TrasladoProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tp;
    }

    public Object[][] DETALLE_TRASLADO(Object key) {
        Object[][] rs = select("detalle_traslado_productos, trasladoproductos, productosbase",
                "detalle_traslado_productos.iddetalletraslado, productosbase.plu, productosbase.descripcion,"
                + "detalle_traslado_productos.cantidad",
                "productosbase.plu = detalle_traslado_productos.producto and "
                + "detalle_traslado_productos.traslado = trasladoproductos.numtraslado and "
                + "trasladoproductos.numtraslado = '" + key + "' "
                + "group by productosbase.plu order by productosbase.descripcion");
        if (rs.length > 0) {
            return rs;
        }
        return null;
    }

    public String NUMERO_TRASLADO() {
        Object[][] rs = select("TRASLADOPRODUCTOS", "CONCAT('TP',IFNULL(MAX(IDTRASLADO)+1,1))", null);
        if (rs.length > 0) {
            return rs[0][0].toString();
        }
        return null;
    }
}
