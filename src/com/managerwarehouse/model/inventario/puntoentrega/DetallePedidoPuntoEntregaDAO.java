package com.managerwarehouse.model.inventario.puntoentrega;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.util.database;
import java.util.List;

public class DetallePedidoPuntoEntregaDAO extends PedidoPuntoEntregaDAO implements crud<DetallePedidoPuntoEntrega> {

    @Override
    public boolean create(DetallePedidoPuntoEntrega c) {
        String values = "" + c.getPedido().getNumpedido() + ",'" + c.getProducto().getPlu() + "',"
                + "" + c.getCantdespachada() + "," + c.getCantidadpendiente() + "";
        return insert("detalle_pedidos_puntos", "pedido, producto, cantdespachada, cantpendiente", values);
    }

    @Override
    public boolean delete(Object key) {
        return Delete("detalle_pedidos_puntos", "itemdetallepedidopunto = " + key + "");
    }

    @Override
    public boolean update(DetallePedidoPuntoEntrega c) {
        return update("detalle_pedidos_puntos", "cantdespachada = " + c.getCantdespachada() + "",
                "producto = " + c.getProducto().getPlu() + " AND pedido = " + c.getPedido().getNumpedido() + "");
    }

    @Override
    public DetallePedidoPuntoEntrega read(Object key) {
        DetallePedidoPuntoEntrega dppe = null;
       return null;
    }

    @Override
    public List<DetallePedidoPuntoEntrega> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetallePedidoPuntoEntrega> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object[][] ConsultaDetallePedido(){
         Object[][] rs = select("detalle_pedidos_puntos", null, null);
         
         return rs;
    }
}
