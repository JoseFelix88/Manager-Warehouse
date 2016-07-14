package com.managerwarehouse.model.factura_de_compra;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.util.Variables_Gloabales;
import com.managerwarehouse.util.database;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FacturaCompraDAO extends database implements crud<FacturaCompraDTO> {

    private final String INSERTAR_FACTURA_ENCABEZADO
            = "INSERT INTO FACTURAS_COMPRAS(fechaemision,fechavencimiento,fechaingreso,"
            + "proveedor,numero_factura,tipopago,subtotal,descuento,iva,retefte,reteiva,reteica,"
            + "totalnetopagar,numeroremesa,usuario,horaingreso)"
            + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURRENT_TIME())";

    private final String INSERTAR_FACTURA_DETALLE
            = "INSERT INTO DETALLECOMPRAS(idfactura,producto,lote,fechavencimiento,unidcomprada,"
            + "cantcajas,embalaje,costounidad,costocaja,costototal,porcdescuento,valordescuento) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

    private final String UPDATE_FACTURA = "";

    private final String CONSULTA_FACTURA_ENCABEZADO = "SELECT\n"
            + "facturascompras.idcompra,\n"
            + "facturascompras.fechaemision,\n"
            + "facturascompras.fechavencimiento,\n"
            + "facturascompras.fechaingreso,\n"
            + "proveedores.razonsocial,\n"
            + "facturascompras.numero_factura,\n"
            + "facturascompras.tipopago,\n"
            + "facturascompras.subtotal,\n"
            + "facturascompras.iva,\n"
            + "facturascompras.descuento,\n"
            + "facturascompras.retefte,\n"
            + "facturascompras.reteiva,\n"
            + "facturascompras.reteica,\n"
            + "facturascompras.totalnetopagar,\n"
            + "facturascompras.numeroremesa,\n"
            + "facturascompras.usuario,\n"
            + "facturascompras.horaingreso\n"
            + "FROM\n"
            + "facturas_compras facturascompras,"
            + "proveedores\n"
            + "WHERE "
            + "proveedores.idproveedor = facturascompras.proveedor and \n"
            + "facturascompras.numero_factura = ? ";

    private final String CONSULTA_FACTURA_DETALLE = "SELECT\n"
            + "detallecompras.idcompradetalle,\n"
            + "productosbase.codigobarras,\n"
            + "productosbase.descripcion,\n"
            + "detallecompras.unidcomprada,\n"
            + "detallecompras.cantcajas,\n"
            + "detallecompras.embalaje,\n"
            + "detallecompras.lote,\n"
            + "detallecompras.fechavencimiento,\n"
            + "detallecompras.costocaja,\n"
            + "detallecompras.costounidad,\n"
            + "detallecompras.porcdescuento,\n"
            + "detallecompras.costototal,\n"
            + "detallecompras.valordescuento\n"
            + "FROM\n"
            + "detallecompras ,\n"
            + "facturas_compras facturascompras ,\n"
            + "productosbase\n"
            + "WHERE\n"
            + "detallecompras.idfactura = facturascompras.idcompra AND\n"
            + "detallecompras.producto = productosbase.codigobarras AND\n"
            + "facturascompras.idcompra = ?";

    private final String LISTAR_FACTURAS = "SELECT\n"
            + "facturascompras.numero_factura,\n"
            + "facturascompras.fechaemision,\n"
            + "facturascompras.fechavencimiento,\n"
            + "facturascompras.fechaingreso,\n"
            + "proveedores.razonsocial,\n"
            + "facturascompras.tipopago,\n"
            + "facturascompras.subtotal,"
            + "facturascompras.descuento,\n"
            + "facturascompras.totalnetopagar,"
            + "facturascompras.numeroremesa,\n"
            + "empleados.nombre as usuarioSystem,\n"
            + "facturascompras.horaingreso\n"
            + "FROM\n"
            + "empleados ,\n"
            + "facturas_compras facturascompras ,\n"
            + "proveedores\n"
            + "WHERE\n"
            + "facturascompras.proveedor = proveedores.idproveedor AND\n"
            + "empleados.id = facturascompras.usuario AND\n"
            + "facturascompras.fechaingreso BETWEEN ? AND ?";

    public FacturaCompraDAO() {
    }

    @Override
    public boolean create(FacturaCompraDTO dTO) {

        FacturaCompraDTO compraDTO = dTO;
        try {

            if (read(dTO.getNumeroFactura()) == null) {

                PreparedStatement ps = getConnection().prepareStatement(INSERTAR_FACTURA_ENCABEZADO);
                ps.setObject(1, dTO.getFechaFactura());
                ps.setObject(2, dTO.getFechaVenceFactura());
                ps.setObject(3, dTO.getFechaIngreso());
                ps.setInt(4, dTO.getProveedorDAO().getProveedorDTO().getIdproveedor());
                ps.setString(5, dTO.getNumeroFactura());
                ps.setString(6, dTO.getTipoPago());
                ps.setInt(7, dTO.getSubtotal());
                ps.setInt(8, dTO.getDescuento());
                ps.setFloat(9, dTO.getIva());
                ps.setFloat(10, dTO.getReteFTE());
                ps.setFloat(11, dTO.getReteIVA());
                ps.setFloat(12, dTO.getReteICA());
                ps.setInt(13, dTO.getTotalnetoPago());
                ps.setString(14, dTO.getNumeroRemesa());
                ps.setString(15, Variables_Gloabales.EMPLEADO.getIdusuario());

                ps.execute();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FacturaCompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public boolean ingresarDetalleCompra(FacturaCompraDTO dTO) {

        try {

            if (dTO != null) {

                PreparedStatement ps = getConnection().prepareStatement(INSERTAR_FACTURA_DETALLE);
                ps.setInt(1, read(dTO.getNumeroFactura()).getIdcompra());
                ps.setString(2, dTO.getDetalleCompraDTO().getProductoDAO().getProductoDTO().getCodigobarras());
                ps.setString(3, dTO.getDetalleCompraDTO().getNumeroLote());
                ps.setObject(4, dTO.getDetalleCompraDTO().getFechaVenceLote());
                ps.setInt(5, dTO.getDetalleCompraDTO().getCantComprada());
                ps.setInt(6, dTO.getDetalleCompraDTO().getCantCajas());
                ps.setInt(7, dTO.getDetalleCompraDTO().getEmbalajeCaja());
                ps.setFloat(8, dTO.getDetalleCompraDTO().getCostoUnidad());
                ps.setFloat(9, dTO.getDetalleCompraDTO().getCostoCaja());
                ps.setFloat(10, dTO.getDetalleCompraDTO().getCostoTotal());
                ps.setFloat(11, dTO.getDetalleCompraDTO().getPorcDescuento());
                ps.setFloat(12, dTO.getDetalleCompraDTO().getValorDescuento());

                ps.execute();
                return true;
            }

        } catch (Exception e) {

            System.out.println("Error en Insertar Detalle:\n " + e.getLocalizedMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return Delete("facturas_compras", "numero_factura = '" + key + "'");
    }

    public boolean deleteDetalleCompra(Object key) {
        return Delete("detallecompras", "idcompradetalle = " + key + "");
    }

    @Override
    public boolean update(FacturaCompraDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FacturaCompraDTO read(Object key) {
        database conexcionSQL = new database();
        FacturaCompraDTO dTO = null;
        try {

            PreparedStatement ps = conexcionSQL.getConnection().prepareStatement(CONSULTA_FACTURA_ENCABEZADO);
            ps.setString(1, key.toString());
            //  System.out.println("sql: "+ps);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                dTO = new FacturaCompraDTO(rs.getInt("idcompra"), rs.getDate("fechaemision"), rs.getDate("fechavencimiento"),
                        rs.getDate("fechaingreso"), rs.getString("razonsocial"),
                        rs.getString("numero_factura"), rs.getString("tipopago"), rs.getInt("subtotal"), rs.getFloat("iva"),
                        rs.getInt("descuento"), rs.getFloat("retefte"), rs.getFloat("reteiva"), rs.getFloat("reteica"),
                        rs.getInt("totalnetopagar"), rs.getString("numeroremesa"), rs.getString("usuario"), rs.getTime("horaingreso"));
            }
//            dTO.setListDetalle(readDetalle(dTO));
        } catch (Exception e) {
            System.out.println("error en la consulta:\n" + e);
        } finally {
            conexcionSQL.desconectar();
        }

        return dTO;
    }

    public Object[][] readDetalle(FacturaCompraDTO dTO) {
        Object[][] list = null;
        try {

            if (Variables_Gloabales.EMPLEADO.getNivel() != 1) {

                list = select("detallecompras ,facturas_compras facturascompras ,productosbase",
                        "detallecompras.idcompradetalle,\n"
                        + "productosbase.codigobarras,\n"
                        + "productosbase.descripcion,\n"
                        + "detallecompras.unidcomprada,\n"
                        + "detallecompras.costounidad,\n"
                        + "detallecompras.cantcajas,\n"
                        + "detallecompras.embalaje,\n"
                        + "detallecompras.costocaja,\n"
                        + "detallecompras.valordescuento,\n"
                        + "detallecompras.porcdescuento,\n"
                        + "detallecompras.costototal,\n"
                        + "detallecompras.lote,\n"
                        + "detallecompras.fechavencimiento\n",
                        "detallecompras.idfactura = facturascompras.idcompra AND\n"
                        + "detallecompras.producto = productosbase.codigobarras AND\n"
                        + "facturascompras.idcompra = " + dTO.getIdcompra() + " order by productosbase.descripcion");
            } else {
                list = select("detallecompras ,facturas_compras facturascompras ,productosbase",
                        "detallecompras.idcompradetalle,\n"
                        + "productosbase.codigobarras,\n"
                        + "productosbase.descripcion,\n"
                        + "detallecompras.unidcomprada,\n"
                        + "0,\n"
                        + "detallecompras.cantcajas,\n"
                        + "detallecompras.embalaje,\n"
                        + "0,\n"
                        + "0,\n"
                        + "0,\n"
                        + "0,\n"
                        + "detallecompras.lote,\n"
                        + "detallecompras.fechavencimiento\n",
                        "detallecompras.idfactura = facturascompras.idcompra AND\n"
                        + "detallecompras.producto = productosbase.codigobarras AND\n"
                        + "facturascompras.idcompra = " + dTO.getIdcompra() + " order by productosbase.descripcion");

            }
        } catch (Exception e) {
            System.out.println("Error al cargar detalle de factura: " + e);
        }

        return list;
    }

    public List<FacturaCompraDTO> readAll(Date fecha1, Date fecha2) {
        List<FacturaCompraDTO> list = null;

        try {

            PreparedStatement ps = getConnection().prepareStatement(LISTAR_FACTURAS);
            ps.setDate(1, fecha1);
            ps.setDate(2, fecha2);
            ResultSet rs = ps.executeQuery();

            list = new ArrayList<>();
            FacturaCompraDTO dTO = new FacturaCompraDTO();

            while (rs.next()) {

                dTO.setNumeroFactura(rs.getString("numero_factura"));//1
                dTO.setFechaFactura(rs.getDate("fechaemision"));//2
                dTO.setFechaVenceFactura(rs.getDate("fechavencimiento"));//3
                dTO.setFechaIngreso(rs.getDate("fechaingreso"));//4
                dTO.setProveedor(rs.getString("razonsocial"));//5
                dTO.setTipoPago(rs.getString("tipopago"));//6
                dTO.setSubtotal(rs.getInt("subtotal"));//7
                dTO.setDescuento(rs.getInt("descuento"));//8
                dTO.setTotalnetoPago(rs.getInt("totalnetopagar"));//9
                dTO.setNumeroRemesa(rs.getString("numeroremesa"));//10
                dTO.setUsuario(rs.getString("usuarioSystem"));//11
                dTO.setHoraingreso(rs.getTime("horaingreso"));//12

                list.add(dTO);
            }

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(FacturaCompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    @Override
    public List<FacturaCompraDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FacturaCompraDTO> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object[][] compras_producto(Object[] key) {
        Object[][] rs;

        if (Variables_Gloabales.EMPLEADO.getNivel() != 1) {

            rs = select("proveedores ,\n"
                    + "productosbase ,\n"
                    + "facturas_compras ,\n"
                    + "detallecompras, empleados", "facturas_compras.numero_factura,\n"
                    + "facturas_compras.fechaemision,\n"
                    + "facturas_compras.fechaingreso,\n"
                    + "proveedores.razonsocial,\n"
                    + "productosbase.codigobarras,\n"
                    + "detallecompras.lote,\n"
                    + "CONCAT(MONTH(detallecompras.fechavencimiento),'-',YEAR(detallecompras.fechavencimiento)) as fechavencimiento,\n"
                    + "detallecompras.unidcomprada,\n"
                    + "detallecompras.costounidad,\n"
                    + "detallecompras.unidcomprada*\n"
                    + "detallecompras.costounidad AS $_costoTotal,"
                    + "concat('X',detallecompras.embalaje),"
                    + "detallecompras.cantcajas,"
                    + "detallecompras.costocaja, empleados.nombre", "facturas_compras.usuario = empleados.id and detallecompras.idfactura = facturas_compras.idcompra AND\n"
                    + "detallecompras.producto = productosbase.codigobarras AND\n"
                    + "facturas_compras.proveedor = proveedores.idproveedor AND\n"
                    + "(productosbase.plu = '" + key[0] + "' OR productosbase.codigobarras = '" + key[1] + "' OR \n"
                    + "facturas_compras.fechaingreso BETWEEN '" + key[2] + "' AND '" + key[3] + "')\n"
                    + "ORDER BY\n"
                    + "facturas_compras.fechaingreso DESC");
        } else {
            rs = select("proveedores ,\n"
                    + "productosbase ,\n"
                    + "facturas_compras ,\n"
                    + "detallecompras,  empleados", "facturas_compras.numero_factura,\n"
                    + "facturas_compras.fechaemision,\n"
                    + "facturas_compras.fechaingreso,\n"
                    + "proveedores.razonsocial,\n"
                    + "productosbase.codigobarras,\n"
                    + "detallecompras.lote,\n"
                    + "CONCAT(MONTH(detallecompras.fechavencimiento),'-',YEAR(detallecompras.fechavencimiento)) as fechavencimiento,\n"
                    + "detallecompras.unidcomprada,\n"
                    + "0,\n"
                    + "detallecompras.unidcomprada*\n"
                    + "0 AS $_costoTotal,"
                    + "concat('X',detallecompras.embalaje),"
                    + "detallecompras.cantcajas,"
                    + "0,empleados.nombre", 
                    "facturas_compras.usuario = empleados.id and detallecompras.idfactura = facturas_compras.idcompra AND\n"
                    + "detallecompras.producto = productosbase.codigobarras AND\n"
                    + "facturas_compras.proveedor = proveedores.idproveedor AND\n"
                    + "(productosbase.plu = '" + key[0] + "' OR productosbase.codigobarras = '" + key[1] + "' OR \n"
                    + "facturas_compras.fechaingreso BETWEEN '" + key[2] + "' AND '" + key[3] + "')\n"
                    + "ORDER BY\n"
                    + "facturas_compras.fechaingreso DESC");
        }

        if (rs.length > 0) {
            return rs;
        }
        return null;
    }

    public boolean Valorizar_Producto(Object[] key) {
        CallableStatement cs = null;
        try {
            cs = getConnection().prepareCall("CALL VALORIZAR_FACTURA_COMPRA(?,?,?)");
            cs.setObject(1, key[0]);
            cs.setObject(2, key[1]);
            cs.setObject(3, key[2]);
            return cs.execute();
        } catch (Exception e) {
            System.out.println("Error al ejecutar SP " + cs + "\n" + e);
        }
        return true;
    }

}
