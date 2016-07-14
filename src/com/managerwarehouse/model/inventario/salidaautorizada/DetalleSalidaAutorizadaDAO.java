package com.managerwarehouse.model.inventario.salidaautorizada;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.model.inventario.Lotealmacenado;
import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.util.database;
import java.sql.PreparedStatement;
import java.util.List;

public class DetalleSalidaAutorizadaDAO extends database implements crud<DetalleSalidaAutorizada> {

    SalidaAutorizadaDAO sadao;
    ProductoDAO prodao;
    Lotealmacenado lote;

    @Override
    public boolean create(DetalleSalidaAutorizada c) {

        PreparedStatement ps;
        String SQL = "Insert Into detallesalidasautorizadas (salidaautoriza, producto, cantidad, lote, vrunidad) values (?,?,?,?,?)";
        try {
           
            ps = getConnection().prepareStatement(SQL);
            ps.setInt(1, c.getSalidaAutorizada().getIdsalidaautorizada());
            ps.setString(2, c.getProducto().getCodigobarras());
            ps.setInt(3, c.getCantidad());
            ps.setObject(4, c.getLotealmacenado().getIdlotealmacenado());
            ps.setInt(5, c.getVrunidad());
            ps.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println("Error en la Insercion del Detalle de Devolucion: " + e);
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return Delete("detallesalidasautorizadas", "iddetallesalidaautoriza = " + key + "");
    }

    @Override
    public boolean update(DetalleSalidaAutorizada c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleSalidaAutorizada read(Object key) {
        sadao = new SalidaAutorizadaDAO();
        prodao = new ProductoDAO();
        lote = new Lotealmacenado();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleSalidaAutorizada> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleSalidaAutorizada> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object[][] listardetallesalida(Object idsalidaautorizada) {
         Object[][] rs = select("salidasautorizadas\n"
                + "INNER JOIN detallesalidasautorizadas ON detallesalidasautorizadas.salidaautoriza = salidasautorizadas.idsalidaautorizada\n"
                + "INNER JOIN productosbase ON detallesalidasautorizadas.producto = productosbase.codigobarras\n"
                + "INNER JOIN lotes_almacenados ON detallesalidasautorizadas.lote = lotes_almacenados.idlotealmacenado",
                "detallesalidasautorizadas.iddetallesalidaautoriza,\n"
                + "productosbase.codigobarras,\n"
                + "productosbase.descripcion,\n"
                + "lotes_almacenados.NUMEROLOTE,\n"
                + "lotes_almacenados.FECHAVENCE,\n"
                + "detallesalidasautorizadas.cantidad",
                "salidasautorizadas.idsalidaautorizada = "+idsalidaautorizada+" ORDER BY productosbase.descripcion");
        return rs;
    }
}
