package com.managerwarehouse.model.factura_de_compra;

import com.managerwarehouse.model.proveedor.ProveedorDAO;
import com.managerwarehouse.util.DateUtil;
import com.managerwarehouse.util.database;

public class CompraAuxDao extends database {

    public boolean CRUD_COMPRA_AUX(Object[] key) {
        return EJECUTAR_SP("CRUD_COMPRA", key);
    }

    public boolean ELIMINAR_PRODUCTO(Object key) {
        return Delete("detallecompraaux", "itemdetalle = " + key.toString() + "");
    }

    public Object[][] DETALLE_COMPRAAUX(Object key) {
        return SELECT_SP("SELECT_COMPRAAUX", 1 + "," + key);
    }

    public String NUMEROIDCOMPRA() {
        Object[][] rs = select("facturacompraaux limit 0,1", " IFNULL(max(facturacompraaux.idcompra)+1,1) ", null);
        return rs[0][0].toString();
    }

    public CompraAux SELECT_COMPRA(Object key) {
        CompraAux aux = null;
        Object[][] rs = SELECT_SP("SELECT_COMPRAAUX", 0 + "," + key);
        if (rs.length > 0) {
            aux = new CompraAux();
            aux.setIdcompra(Integer.parseInt(rs[0][0].toString()));
            aux.setNumeroFactura(String.valueOf(rs[0][1]));
            aux.setFechafactura(DateUtil.getDateTime(rs[0][2]));
            aux.setFechaVencimiento(DateUtil.getDateTime(rs[0][3]));
            aux.setProveedor(new ProveedorDAO().read(rs[0][4]));
        }
        return aux;
    }
}
