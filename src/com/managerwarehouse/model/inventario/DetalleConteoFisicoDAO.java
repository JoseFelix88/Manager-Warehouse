package com.managerwarehouse.model.inventario;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.util.database;
import java.sql.PreparedStatement;
import java.util.List;

public class DetalleConteoFisicoDAO extends database implements crud<DetalleConteoFisico> {

    @Override
    public boolean create(DetalleConteoFisico c) {
        PreparedStatement ps;
        String SQL = "INSERT INTO detalle_conteos_fisicos (conteo, producto, responsable, lote, fechavence, cantidadcontada) VALUES (?,?,?,?,?,?)";
        try {
            ps = getConnection().prepareStatement(SQL);
            ps.setObject(1, c.getConteoFisico().getIdconteofisico());
            ps.setObject(2, c.getProducto().getCodigobarras());
            ps.setString(3, c.getResponsable());
            ps.setString(4, c.getLote());
            ps.setObject(5, c.getFechavence());
            ps.setInt(6, c.getCantidadcontada());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al Insertar el Detalle Conteo Fisico. " + e);
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return Delete("detalle_conteos_fisicos", "itemconteodetalle = " + key + "");
    }

    @Override
    public boolean update(DetalleConteoFisico c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleConteoFisico read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleConteoFisico> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleConteoFisico> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object[][] listar_detalle_Conteo(Object key) {
        Object[][] rs = select("detalle_conteos_fisicos ,\n"
                + "productosbase ,\n"
                + "conteos_fisicos",
                "productosbase.plu,\n"
                + "productosbase.codigobarras,\n"
                + "productosbase.descripcion,\n"
                + "detalle_conteos_fisicos.lote,\n"
                + "detalle_conteos_fisicos.fechavence,\n"
                + "detalle_conteos_fisicos.cantidadcontada,\n"
                + "detalle_conteos_fisicos.responsable,\n"
                + "detalle_conteos_fisicos.itemconteodetalle", 
                "detalle_conteos_fisicos.conteo = conteos_fisicos.idconteofisico AND\n"
                + "detalle_conteos_fisicos.producto = productosbase.codigobarras AND\n"
                + "conteos_fisicos.idconteofisico = "+key+" order by productosbase.descripcion");
        if (rs.length > 0) {
            return rs;
        }
        return null;
    }
}
