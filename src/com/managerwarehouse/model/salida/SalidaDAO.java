package com.managerwarehouse.model.salida;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.model.puntoentrega.PuntoEntregaDAO;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.database;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalidaDAO extends database implements crud<Salida> {

    Edicion edicion = new Edicion();
    PuntoEntregaDAO punto = new PuntoEntregaDAO();

    @Override
    public boolean create(Salida c) {
        PreparedStatement ps;
        String SQL = "INSERT INTO SALIDAS(IDSALIDA,FECHAEMISION,PUNTOENTREGA,NUMPEDIDO,CAJAS,REALIZADO,VERIFICADO,ESTADO,fechaingreso) VALUES(?,?,?,?,?,?,?,?,now())";
        try {
            ps = getConnection().prepareStatement(SQL);
            ps.setInt(1, c.getIdsalida());
            ps.setObject(2, edicion.formatearFechaSQL(c.getFechaemision()));
            ps.setInt(3, punto.read(c.getPuntoentrega()).getIdpunto());
            ps.setString(4, c.getNumpedido());
            ps.setInt(5, c.getCantcajas());
            ps.setString(6, c.getRealizado());
            ps.setString(7, c.getVerificado());
            ps.setInt(8, 1);

            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {

        return Delete("salidas", "idsalida = " + key + "");
    }

    @Override
    public boolean update(Salida c) {
        PreparedStatement ps;
        String SQL = "UPDATE SALIDAS SET FechaEmision = ?, PuntoEntrega = ?, Numpedido = ?, cajas = ? where idsalida = ?";
        try {
            ps = getConnection().prepareStatement(SQL);
            ps.setObject(1, edicion.CambiarTipoFecha(c.getFechaemision()));
            ps.setInt(2, punto.read(c.getPuntoentrega()).getIdpunto());
            ps.setString(3, c.getNumpedido());
            ps.setInt(4, c.getCantcajas());
            ps.setInt(5, c.getIdsalida());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SalidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Salida read(Object key) {
        Salida s = null;
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "SELECT idsalida, FechaEmision, PuntoEntrega, NumPedido, "
                + "contarcajas(idsalida) as cajas, realizado, verificado, estado, fechaingreso FROM SALIDAS "
                + "where idsalida = ?";
        try {
            ps = getConnection().prepareStatement(SQL);
            ps.setObject(1, key);
            rs = ps.executeQuery();
            if (rs.next()) {
                s = new Salida(rs.getInt("idsalida"), rs.getDate("fechaemision"),
                        punto.read(rs.getInt("puntoentrega")).getNombre(), rs.getString("numpedido"),
                        rs.getInt("cajas"), rs.getString("realizado"), rs.getString("verificado"),
                        rs.getInt("estado"), rs.getDate("fechaingreso"));
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta de la salida Encabezado: " + e);
        }
        return s;
    }

    @Override
    public List<Salida> readAll() {
        Salida s;
        List<Salida> list = null;
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "SELECT idsalida, DATE_FORMAT(FechaEmision,'%d-%m-%Y') as fechaemision, "
                + "PuntoEntrega, NumPedido, "
                + "cajas, realizado, verificado, estado, fechaingreso FROM SALIDAS ";
        try {
            ps = getConnection().prepareStatement(SQL);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                s = new Salida(rs.getInt("idsalida"), rs.getDate("fechaemision"),
                        punto.read(rs.getInt("puntoentrega")).getNombre(), rs.getString("numpedido"),
                        rs.getInt("cajas"), rs.getString("realizado"), rs.getString("verificado"),
                        rs.getInt("estado"), rs.getDate("fechaingreso"));
                list.add(s);
            }
        } catch (Exception e) {

        }
        return list;
    }

    public int proximasalida() {
        Object[][] rs = select("salidas", "IFNULL(MAX(idsalida)+1,1)", null);
        int idsalida = 0;
        if (rs.length > 0) {
            idsalida = Integer.parseInt(rs[0][0].toString());
        }
        return idsalida;
    }

    public Object[][] SalidasAbiertas() {
        Object[][] rs = select("salidas, puntos", "salidas.idsalida,salidas.fechaemision, puntos.nombre",
                "puntos.cod_punto = salidas.puntoentrega and salidas.estado = 1");
        return rs;
    }

    public boolean cerrarSalida() {
        return update("salidas", "estado = 0", "estado = 1");
    }

    @Override
    public List<Salida> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object[][] despachos_de_producto(Object[] key) {

        Object[][] rs = select("salidas ,\n"
                + "productosbase ,\n"
                + "lotes_almacenados ,\n"
                + "detallesalidas ,\n"
                + "puntos",
                "salidas.idsalida,\n"
                + "salidas.fechaemision,\n"
                + "puntos.NOMBRE AS puntoentrega,\n"
                + "productosbase.codigobarras,\n"
                + "lotes_almacenados.NUMEROLOTE,\n"
                + "CONCAT(MONTH(lotes_almacenados.FECHAVENCE),'-',YEAR(lotes_almacenados.FECHAVENCE)) AS FECHAVENCE,\n"
                + "detallesalidas.cantidad,\n"
                + "detallesalidas.caja", 
                "detallesalidas.salida = salidas.idsalida AND\n"
                + "detallesalidas.producto = productosbase.codigobarras AND\n"
                + "detallesalidas.lote = lotes_almacenados.idlotealmacenado AND\n"
                + "salidas.puntoentrega = puntos.COD_PUNTO AND\n"
                + "(productosbase.plu = '"+key[0]+"' OR\n"
                + "productosbase.codigobarras = '"+key[1]+"') ORDER BY  idsalida DESC  LIMIT 0,"+key[2]+"");
        if (rs.length > 0) {
            return rs;
        }
        return null;
    }

}
