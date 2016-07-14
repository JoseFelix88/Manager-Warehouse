package com.managerwarehouse.model.producto.devoluciones.puntoentrega;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.model.puntoentrega.PuntoEntregaDAO;
import com.managerwarehouse.util.database;
import java.sql.PreparedStatement;
import java.util.List;

public class DetalleDevolucionPuntoDao extends database implements crud<DetalleDevolucionPuntoEntrega> {

    DevolucionPuntoEntregaDao dpedao;
    PuntoEntregaDAO pedao;

    @Override
    public boolean create(DetalleDevolucionPuntoEntrega c) {

        PreparedStatement ps;
        String SQL = "Insert Into detalledevolucionpuntos (devolucion, producto, "
                + "cantidad, lote, fechavence, vrunidad) values (?,?,?,?,?,?)";
        try {
            ps = getConnection().prepareStatement(SQL);
            ps.setInt(1, c.getDevolucion().getIddevolucion());
            ps.setString(2, c.getProducto().getCodigobarras());
            ps.setInt(3, c.getCantidad_devuelta());
            ps.setObject(4, c.getLote());
            ps.setObject(5, c.getFechavence());
            ps.setInt(6, c.getVrunidad());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error en la Insercion del Detalle de Devolucion: " + e);
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return Delete("detalledevolucionpuntos", "iddetalledevolucion = " + key + "");
    }

    @Override
    public boolean update(DetalleDevolucionPuntoEntrega c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleDevolucionPuntoEntrega read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleDevolucionPuntoEntrega> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleDevolucionPuntoEntrega> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object[][] listardetalledevolucion(Object key) {
        return select("detalledevolucionpuntos ,"
                + "productosbase ,"
                + "devolucionespunto",
                "detalledevolucionpuntos.iddetalledevolucion,\n"
                + "productosbase.codigobarras,\n"
                + "productosbase.descripcion,\n"
                + "detalledevolucionpuntos.lote,\n"
                + "detalledevolucionpuntos.fechavence,\n"
                + "detalledevolucionpuntos.cantidad",
                "detalledevolucionpuntos.devolucion = devolucionespunto.iddevolucionpunto AND\n"
                + "detalledevolucionpuntos.producto = productosbase.codigobarras AND\n"
                + "devolucionespunto.iddevolucionpunto = " + key + ""
                + " order by productosbase.descripcion, detalledevolucionpuntos.lote ");
    }
}
