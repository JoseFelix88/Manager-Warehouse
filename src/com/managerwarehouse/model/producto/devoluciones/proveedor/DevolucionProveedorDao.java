package com.managerwarehouse.model.producto.devoluciones.proveedor;

import com.managerwarehouse.model.proveedor.ProveedorDAO;
import com.managerwarehouse.model.usuario_system.EmpleadoDAO;
import com.managerwarehouse.util.DateUtil;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.database;

public class DevolucionProveedorDao extends database {

    Edicion edicion = new Edicion();

    public boolean CRUD_DEVOLUCION(Object[] key) {
        return insertSP("CRUD_DEVOLUCION_PROVEEDOR", key);
    }

    public DevolucionProveedor READ_DEVOLUCION(Object key) {
        DevolucionProveedor dp = null;
        ProveedorDAO pdao;
        EmpleadoDAO empdao;
        Object[][] rs = select("devoluciones_proveedor", "iddevolucionproveedor,"
                + " fechaemision, proveedor, concepto, realizado, fechahoraingreso",
                  " iddevolucionproveedor = " + key + "");
        if (rs.length > 0) {
            pdao = new ProveedorDAO();
            empdao = new EmpleadoDAO();
            dp = new DevolucionProveedor(edicion.toNumeroEntero(rs[0][0].toString()), DateUtil.getDate(rs[0][1]),
                    pdao.read(rs[0][2]), rs[0][3].toString(), empdao.read(rs[0][4]), DateUtil.getDateTime(rs[0][5]));
        }
        return dp;
    }

    public Object[][] DETALLE_DE_DEVOLUCION(Object key) {
        Object[][] rs = select("devoluciones_proveedor devolucion, detalledevolucionesproveedor detalle,"
                + " productosbase producto, lotes_almacenados lote",
                " detalle.iddetalledevolucion, producto.codigobarras, producto.descripcion, "
                + " lote.NUMEROLOTE,lote.fechavence, detalle.cantidad",
                " devolucion.iddevolucionproveedor = " + key + " and devolucion.iddevolucionproveedor = detalle.devolucion and "
                + " detalle.producto = producto.codigobarras and detalle.lote = lote.idlotealmacenado");
        if (rs.length > 0) {
            return rs;
        }
        return null;
    }

    public String PROXIMA_DEVOLUCION() {
        Object[][] rs = select("devoluciones_proveedor", "ifnull(max(iddevolucionproveedor)+1,1)", null);
        if (rs.length > 0) {
            return rs[0][0].toString();
        }
        return null;
    }
}
