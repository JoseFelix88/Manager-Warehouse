package com.managerwarehouse.model.inventario.salidaautorizada;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.util.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SalidaAutorizadaDAO extends database implements crud<SalidaAutorizada> {

    @Override
    public boolean create(SalidaAutorizada c) {
        PreparedStatement ps;
        String SQL = "Insert Into salidasautorizadas (idsalidaautorizada, fechaemision, autorizado, "
                + "concepto, realizado, fechahoraingreso) values (?,?,?,?,?,now())";
        try {
            ps = getConnection().prepareStatement(SQL);
            ps.setInt(1, c.getIdsalidaautorizada());
            ps.setObject(2, c.getFechaemision());
            ps.setString(3, c.getAutorizado());
            ps.setString(4, c.getConcepto());
            ps.setString(5, c.getRealizado());

            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("error en la creacion de la devolucion. " + e);
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return Delete("salidasautorizadas", "idsalidaautorizada = " + key + "");
    }

    @Override
    public boolean update(SalidaAutorizada c) {
        PreparedStatement ps;
        String SQL = "Update salidasautorizadas set fechaemision = ?, autorizado = ?, "
                + "concepto = ? where idsalidaautorizada = ?";
        try {

            ps = getConnection().prepareStatement(SQL);
            ps.setObject(1, c.getFechaemision());
            ps.setString(2, c.getAutorizado());
            ps.setString(3, c.getConcepto());
            ps.setString(4, c.getRealizado());
            ps.setInt(5, c.getIdsalidaautorizada());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("error en la actualizacion de la salida autorizada . " + e);
        }
        return false;
    }

    @Override
    public SalidaAutorizada read(Object key) {
        SalidaAutorizada sa = null;
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "Select idsalidaautorizada, fechaemision, autorizado, "
                + "concepto, realizado, fechahoraingreso From "
                + "salidasautorizadas Where idsalidaautorizada = ?";
        try {

            ps = getConnection().prepareStatement(SQL);
            ps.setObject(1, key);
            rs = ps.executeQuery();
            if (rs.next()) {
                sa = new SalidaAutorizada(rs.getInt("idsalidaautorizada"),
                        rs.getDate("fechaemision"), rs.getString("autorizado"),
                        rs.getString("concepto"), rs.getString("realizado"),
                        rs.getDate("fechahoraingreso"));
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta de la salida autorizada: " + e);
        }
        return sa;
    }

    @Override
    public List<SalidaAutorizada> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SalidaAutorizada> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object siguienteSalida() {
        Object[][] rs = select("salidasautorizadas", "ifnull(max(idsalidaautorizada)+1,1)", null);
        return rs[0][0];
    }
}
