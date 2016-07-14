package com.managerwarehouse.model.producto.devoluciones.puntoentrega;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.model.puntoentrega.PuntoEntregaDAO;
import com.managerwarehouse.util.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DevolucionPuntoEntregaDao extends database implements crud<DevolucionPuntoEntrega> {

    PuntoEntregaDAO pedao;

    @Override
    public boolean create(DevolucionPuntoEntrega c) {
        PreparedStatement ps;
        String SQL = "Insert Into devolucionespunto (iddevolucionpunto, fechaemision, puntoentrega, "
                + "concepto, realizado, fechahoraingreso) values (?,?,?,?,?,now())";
        try {
            pedao = new PuntoEntregaDAO();
            ps = getConnection().prepareStatement(SQL);
            ps.setInt(1, c.getIddevolucion());
            ps.setObject(2, c.getFechaemision());
            ps.setInt(3, pedao.read(c.getPuntoEntrega().getNombre()).getIdpunto());
            ps.setString(4, c.getConcepto());
            ps.setString(5, c.getRealizado());

            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("error en la creacion de la devolucion. "+e);
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return Delete("devolucionespunto", "iddevolucionpunto = " + key + "");
    }

    @Override
    public boolean update(DevolucionPuntoEntrega c) {
        PreparedStatement ps;
        String SQL = "Update devolucionespunto set fechaemision = ?, puntoentrega = ?, "
                + "concepto = ? where iddevolucionpunto = ?";
        try {
            pedao = new PuntoEntregaDAO();
            ps = getConnection().prepareStatement(SQL);
            ps.setObject(1, c.getFechaemision());
            ps.setInt(2, pedao.read(c.getPuntoEntrega().getNombre()).getIdpunto());
            ps.setString(3, c.getConcepto());
            ps.setInt(4, c.getIddevolucion());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("error en la actualizacion de la devolucion. "+e);
        }
        return false;
    }

    @Override
    public DevolucionPuntoEntrega read(Object key) {
        DevolucionPuntoEntrega dpe = null;
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "Select iddevolucionpunto, fechaemision, puntoentrega, "
                + "concepto, realizado, fechahoraingreso From "
                + "devolucionespunto Where iddevolucionpunto = ?";
        try {
            
            ps = getConnection().prepareStatement(SQL);
            ps.setObject(1, key);
            rs = ps.executeQuery();
            if (rs.next()) {
                pedao = new PuntoEntregaDAO();
                dpe = new DevolucionPuntoEntrega(rs.getInt("iddevolucionpunto"),
                        rs.getDate("fechaemision"), pedao.read(rs.getInt("puntoentrega")),
                        rs.getString("concepto"), rs.getString("realizado"), rs.getDate("fechahoraingreso"));
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta de la devolucion: " + e);
        }
        return dpe;
    }

    @Override
    public List<DevolucionPuntoEntrega> readAll() {
        DevolucionPuntoEntrega dpe = null;
        List<DevolucionPuntoEntrega> list = null;
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "Select iddevolucionpunto, fechaemision, puntoentrega, concepto, realizado, fechahoraingreso From "
                + "devolucionespunto ";
        try {
            ps = getConnection().prepareStatement(SQL);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            pedao = new PuntoEntregaDAO();
            while (rs.next()) {
                dpe = new DevolucionPuntoEntrega(rs.getInt("iddevolucionpunto"),
                        rs.getDate("fechaemision"), pedao.read(rs.getInt("puntoentrega")),
                        rs.getString("concepto"), rs.getString("realizado"), rs.getDate("fechahoraingreso"));
                list.add(dpe);
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta de la devolucion: " + e);
        }
        return list;
    }

    @Override
    public List<DevolucionPuntoEntrega> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object proximadetalledevolucion() {
        Object[][] rs = select("devolucionespunto", "ifnull(max(iddevolucionpunto) + 1,1)", null);
        return rs[0][0];
    }

}
