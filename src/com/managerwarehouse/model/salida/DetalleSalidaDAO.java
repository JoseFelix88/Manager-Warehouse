package com.managerwarehouse.model.salida;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.util.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DetalleSalidaDAO extends database implements crud<DetalleSalida> {

    SalidaDAO salida = new SalidaDAO();

    @Override
    public boolean create(DetalleSalida c) {
        PreparedStatement ps;
        String SQL = "INSERT INTO DETALLESALIDAS (SALIDA, PRODUCTO, LOTE, CANTIDAD, CAJA, OPERADOR)"
                + " VALUES (?,?,?,?,?,?)";
        try {
            ps = getConnection().prepareStatement(SQL);
            ps.setInt(1, c.getSalida());
            ps.setString(2, c.getProducto());
            ps.setInt(3, c.getLote());
            ps.setInt(4, c.getCantidad());
            ps.setInt(5, c.getCaja());
            ps.setString(6, c.getOperador());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error en el detalle de la salida: " + e);
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return Delete("detallesalidas", "iddetallesalida = " + key + "");
    }

    @Override
    public boolean update(DetalleSalida c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleSalida read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleSalida> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object[][] listardetalle(Object key) {
        Object[][] rs = select("detallesalidas\n"
                + "INNER JOIN lotes_almacenados ON detallesalidas.lote = lotes_almacenados.idlotealmacenado\n"
                + "INNER JOIN productosbase ON detallesalidas.producto = productosbase.codigobarras\n"
                + "INNER JOIN salidas ON detallesalidas.salida = salidas.idsalida",
                "detallesalidas.iddetallesalida,\n"
                + "detallesalidas.producto,\n"
                + "productosbase.descripcion,\n"
                + "lotes_almacenados.NUMEROLOTE,\n"
                + "detallesalidas.cantidad,\n"
                + "detallesalidas.caja,\n"
                + "detallesalidas.operador",
                "salidas.idsalida = " + key + " "
                + "group by detallesalidas.iddetallesalida ORDER BY  productosbase.descripcion, detallesalidas.caja ");
        return rs;
    }

    @Override
    public List<DetalleSalida> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
