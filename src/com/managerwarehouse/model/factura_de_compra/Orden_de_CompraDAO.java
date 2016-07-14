package com.managerwarehouse.model.factura_de_compra;

import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.model.proveedor.ProveedorDAO;
import com.managerwarehouse.util.Variables_Gloabales;
import com.managerwarehouse.util.database;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Orden_de_CompraDAO extends database {

    public boolean gestionarOrden(int opcion, Orden_de_Compra oc) {
        CallableStatement cs = null;
        try {
            cs = getConnection().prepareCall("CALL CRUD_ORDEN_COMPRA(?,?,?,?,?)");
            cs.setInt(1, opcion);
            cs.setInt(2, oc.getProveedor().getIdproveedor());
            cs.setString(3, oc.getProducto().getPlu());
            cs.setInt(4, oc.getPrecio());
            cs.setInt(5, oc.getIdordencompra());
//            System.out.println(cs);
            return cs.execute();
        } catch (Exception e) {
            System.out.println("Problemas al intentar gestionar orden: " + cs + "\n" + e);
        }
        return true;
    }

    public boolean GestionarCarritoCompra(int opcion, Orden_de_Compra oc) {
        CallableStatement cs = null;
        try {
            cs = getConnection().prepareCall("CALL CRUD_CARRITO_COMPRA(?,?,?,?,?,?,?)");
            cs.setInt(1, opcion);
            cs.setInt(2, oc.getProveedor().getIdproveedor());
            cs.setString(3, oc.getProducto().getPlu());
            cs.setInt(4, oc.getCantidadPedida());
            cs.setInt(5, oc.getPrecio());
            cs.setInt(6, oc.getIddetallecompra());
            cs.setString(7, Variables_Gloabales.EMPLEADO.getIdusuario());
            return cs.execute();
        } catch (Exception e) {
            System.out.println("Problemas al intentar gestionar carrito: " + cs + "\n" + e);
        }
        return true;
    }

    public Object[][] DetalleCarritoCompra(Object key) {
        Object[][] rs = select("pedido_proveedores\n"
                + "INNER JOIN detallepedidosproveedores ON pedido_proveedores.Idpedidoproveedor = detallepedidosproveedores.pedido\n"
                + "INNER JOIN productosbase ON detallepedidosproveedores.producto = productosbase.plu", "detallepedidosproveedores.iddetallepedidoproveedor,\n"
                + "productosbase.plu,\n"
                + "productosbase.descripcion,\n"
                + "detallepedidosproveedores.cantidad,\n"
                + "detallepedidosproveedores.costound,\n"
                + "detallepedidosproveedores.costototal", "pedido_proveedores.Idpedidoproveedor = numero_pedido_proveedor("+key+")\n"
                + "GROUP BY\n"
                + "productosbase.plu\n"
                + "ORDER BY\n"
                + "productosbase.descripcion ASC");
        if (rs.length > 0) {
            return rs;
        }
        return null;
    }

    public Object numeroOrdenCompra() {
        CallableStatement cs = null;
        ResultSet rs;
        try {
            cs = getConnection().prepareCall("call numero_orden_compra()");
            rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getObject("numeroorden");
            }
        } catch (Exception e) {
            System.out.println("Error al momento de ejecutar: " + cs + "\n" + e);
        }
        return null;
    }

    public List<Orden_de_Compra> Listar_Detalle_Orden(int opcion) {
        List<Orden_de_Compra> list = null;
        CallableStatement cs = null;
        ResultSet rs;
        Orden_de_Compra oc;
        ProveedorDAO proveedor = new ProveedorDAO();
        ProductoDAO producto = new ProductoDAO();

        try {

            cs = getConnection().prepareCall("CALL DETALLE_ORDEN_COMPRA(?)");
            cs.setInt(1, opcion);
            rs = cs.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                oc = new Orden_de_Compra(rs.getInt("numorden"), proveedor.read(rs.getInt("proveedor")),
                        producto.read(rs.getObject("producto")), rs.getInt("oferta"), 0, rs.getDate("fechaingreso"),
                        rs.getDate("fechamodifica"));
                System.out.println("proveedor: " + oc.getProveedor().getRazonSocial());
                list.add(oc);
            }
        } catch (SQLException e) {
            System.out.println("Error al Cargar Lista: " + cs + "\n" + e);
        }
        return list;
    }

    public Object[][] listarOrdenesRegistradas(Object key) {
        Object[][] rs = select("orden_de_compra\n"
                + "INNER JOIN productosbase ON orden_de_compra.PRODUCTO = productosbase.plu\n"
                + "INNER JOIN proveedores ON orden_de_compra.proveedor = proveedores.idproveedor\n",
                "proveedores.razonsocial,\n"
                + "orden_de_compra.oferta,"
                + "orden_de_compra.fechaingreso,\n"
                + "orden_de_compra.fechamodifica,\n"
                + "orden_de_compra.idordencompra AS numorden", "productosbase.plu = '" + key + "' GROUP BY productosbase.plu,proveedores.idproveedor "
                + "ORDER BY productosbase.descripcion ASC,orden_de_compra.oferta ASC");
        if (rs.length > 0) {
            return rs;
        }
        return null;
    }

    public Object[][] historialDeCompras(Object key) {
        Object[][] rs = select("productosbase\n"
                + "INNER JOIN detallecompras ON productosbase.codigobarras = detallecompras.producto\n"
                + "INNER JOIN facturas_compras ON detallecompras.idfactura = facturas_compras.idcompra\n"
                + "INNER JOIN proveedores ON facturas_compras.proveedor = proveedores.idproveedor",
                "proveedores.razonsocial,\n"
                + "detallecompras.costounidad,\n"
                + "facturas_compras.fechaingreso,\n"
                + "SUM(detallecompras.unidcomprada) AS UND_COMPRADAS,SUM(detallecompras.unidcomprada)*detallecompras.costounidad",
                "productosbase.plu = '" + key + "'\n"
                + "GROUP BY\n"
                + "productosbase.plu,proveedores.idproveedor\n"
                + "ORDER BY\n"
                + "facturas_compras.idcompra  DESC");
        if (rs.length > 0) {
            return rs;
        }
        return null;
    }

    public Orden_de_Compra consultaordencompra(Object[] key) {
        Orden_de_Compra oc = null;
        PreparedStatement ps;
        ResultSet rs;
        ProveedorDAO proveedor = new ProveedorDAO();
        ProductoDAO producto = new ProductoDAO();
        try {
            ps = getConnection().prepareStatement("select orden_de_compra.oferta,\n"
                    + "orden_de_compra.fechamodifica,\n"
                    + "orden_de_compra.idordencompra AS numorden,\n"
                    + "orden_de_compra.PRODUCTO,\n"
                    + "orden_de_compra.proveedor,\n"
                    + "orden_de_compra.fechaingreso from orden_de_compra where proveedor = ? and producto = ?");
            ps.setObject(1, key[0]);
            ps.setObject(2, key[1]);
            rs = ps.executeQuery();
            if (rs.next()) {
                oc = new Orden_de_Compra(rs.getInt("numorden"), proveedor.read(rs.getInt("proveedor")),
                        producto.read(rs.getObject("producto")), rs.getInt("oferta"), 0, rs.getDate("fechaingreso"),
                        rs.getDate("fechamodifica"));
            }
        } catch (Exception e) {
            System.out.println("Error al consultar orden de compra: " + e);
        }
        return oc;
    }
    
    public int numerodeordenpedidoproveedor(Object key){
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = getConnection().prepareStatement("SELECT NUMERO_PEDIDO_PROVEEDOR(?) as ordenpedido");
            ps.setObject(1, key);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ordenpedido");
            }
                    
        } catch (Exception e) {
        }
        return 0;
    }
    
    public boolean BORRAR_ORDEN_DE_COMPRA(Object key){
        return Delete("pedido_proveedores", "Idpedidoproveedor = "+numerodeordenpedidoproveedor(key)+"");
    }
}
