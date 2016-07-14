package com.managerwarehouse.model.producto;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.model.inventario.Lotealmacenado;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO extends database implements crud<ProductoDTO> {

    private final String READALL = "SELECT "
            + "productosbase.itemproducto,\n"
            + "productosbase.plu,\n"
            + "productosbase.codigobarras,\n"
            + "productosbase.principioactivo,\n"
            + "productosbase.comercial,\n"
            + "productosbase.laboratorio,\n"
            + "upper(productosbase.presentacion) as presentacion,\n"
            + "productosbase.cum,\n"
            + "productosbase.atc,\n"
            + "productosbase.canal,\n"
            + "productosbase.pos,\n"
            + "productosbase.elaborado,\n"
            + "productosbase.controltecnico,\n"
            + "productosbase.registrosanitario,\n"
            + "productosbase.viaadministracion,\n"
            + "productosbase.unidad,\n"
            + "productosbase.concentracion,\n"
            + "productosbase.descripcionatc,\n"
            + "productosbase.unidadmedida,\n"
            + "productosbase.cantidadconcentrada,\n"
            + "productosbase.unidadreferencia,\n"
            + "productosbase.formafarmaceutica,\n"
            + "productosbase.descripcion,\n"
            + "productosbase.embalaje,\n"
            + "productosbase.precio_venta,\n"
            + "productosbase.costo,"
            + "cantidadactual, "
            + "cantidadminima, "
            + "cantidadaviso,"
            + " ubicacion,"
            + " tiporol,"
            + " modalidad,"
            + "estadoregistro, estadocum\n"
            + "FROM\n"
            + "productosbase  ORDER BY\n"
            + "productosbase.descripcion ASC";

    private static final String READ = "SELECT"
            + " productosbase.itemproducto,\n"
            + "productosbase.plu,\n"
            + "productosbase.codigobarras,\n"
            + "productosbase.principioactivo,\n"
            + "productosbase.comercial,\n"
            + "productosbase.laboratorio,\n"
            + "upper(productosbase.presentacion) as presentacion,\n"
            + "productosbase.cum,\n"
            + "productosbase.atc,\n"
            + "productosbase.canal,\n"
            + "productosbase.pos,\n"
            + "productosbase.elaborado,\n"
            + "productosbase.controltecnico,\n"
            + "productosbase.registrosanitario,\n"
            + "productosbase.viaadministracion,\n"
            + "productosbase.unidad,\n"
            + "productosbase.concentracion,\n"
            + "productosbase.descripcionatc,\n"
            + "productosbase.unidadmedida,\n"
            + "productosbase.cantidadconcentrada,\n"
            + "productosbase.unidadreferencia,\n"
            + "productosbase.formafarmaceutica,\n"
            + "productosbase.descripcion,\n"
            + "productosbase.embalaje,\n"
            + "productosbase.precio_venta,\n"
            + "productosbase.costo,\n"
            + "stocktotallotesalmacenados(productosbase.plu) AS cantidadactual, "
            + "cantidadminima, "
            + "cantidadaviso,"
            + " ubicacion,"
            + " tiporol,"
            + " modalidad,estadoregistro, estadocum "
            + "FROM\n"
            + "productosbase where productosbase.itemproducto = ? or productosbase.codigobarras = ? or productosbase.plu = ? or productosbase.descripcion = ?";

    private static final String UPDATE = "UPDATE PRODUCTOSBASE SET "
            + "             productosbase.plu = ?,\n"
            + "             productosbase.codigobarras = ?,\n"
            + "             productosbase.principioactivo = ?,\n"
            + "             productosbase.comercial = ?,\n"
            + "             productosbase.laboratorio = ?,\n"
            + "             productosbase.presentacion = upper(?),\n"
            + "             productosbase.cum = ?,\n"
            + "             productosbase.atc = ?,\n"
            + "             productosbase.canal = ?,\n"
            + "             productosbase.pos = ?,\n"
            + "             productosbase.elaborado = ?,\n"
            + "             productosbase.controltecnico = ?,\n"
            + "             productosbase.registrosanitario = ?,\n"
            + "             productosbase.viaadministracion = ?,\n"
            + "             productosbase.descripcionatc = ?,\n"
            + "             productosbase.unidadmedida = ?,\n"
            + "             productosbase.cantidadconcentrada = ?,\n"
            + "             productosbase.formafarmaceutica = ?,\n"
            + "             productosbase.descripcion = ?,\n"
            + "             productosbase.embalaje = ?,\n"
            + "             productosbase.precio_venta = ?,\n"
            + "             productosbase.costo = ?, "
            + "             productosbase.cantidadactual = ?, "
            + "             productosbase.cantidadminima = ?, "
            + "             productosbase.cantidadaviso = ?,"
            + "             productosbase.ubicacion = ?,"
            + "             productosbase.tiporol = ?, "
            + "             productosbase.modalidad = ?,"
            + "             productosbase.estadoregistro = ?,"
            + "             productosbase.estadocum = ? "
            + "WHERE        productosbase.itemproducto = ?";

    private static final String INSERT = "INSERT INTO PRODUCTOSBASE (" + "productosbase.plu,\n"
            + "productosbase.codigobarras,\n"
            + "productosbase.principioactivo,\n"
            + "productosbase.comercial,\n"
            + "productosbase.laboratorio,\n"
            + "productosbase.presentacion,\n"
            + "productosbase.cum,\n"
            + "productosbase.atc,\n"
            + "productosbase.canal,\n"
            + "productosbase.pos,\n"
            + "productosbase.elaborado,\n"
            + "productosbase.controltecnico,\n"
            + "productosbase.registrosanitario,\n"
            + "productosbase.viaadministracion,\n"
            + "productosbase.descripcionatc,\n"
            + "productosbase.unidadmedida,\n"
            + "productosbase.cantidadconcentrada,\n"
            + "productosbase.formafarmaceutica,\n"
            + "productosbase.descripcion,\n"
            + "productosbase.embalaje,\n"
            + "productosbase.precio_venta,\n"
            + "productosbase.costo,"
            + "cantidadactual, "
            + "cantidadminima, "
            + "cantidadaviso,"
            + " ubicacion,tiporol, modalidad,estadoregistro,estadocum"
            + "" + ") values (?,?,?,?,?,upper(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String GENERARPLU = "SELECT PLU FROM PRODUCTOSBASE WHERE PLU = ?";

    private static final String INSERTAR_DISPENSACION_DE_PRODUCTO = "INSERT INTO DISPENSAR_PRODUCTOS("
            + ")";

    private static final database con = new database();

    @Override
    public boolean create(ProductoDTO c) {

        boolean rs = false;
        PreparedStatement ps;

        try {
            ps = con.getConnection().prepareStatement(INSERT);
            ps.setString(1, c.getPlu());
            ps.setString(2, c.getCodigobarras());
            ps.setString(3, c.getPrincipioactivo());
            ps.setString(4, c.getComercial());
            ps.setString(5, c.getLaboratorio());
            ps.setString(6, c.getPresentacion());
            ps.setString(7, c.getCum());
            ps.setString(8, c.getAtc());
            ps.setString(9, c.getCanal());
            ps.setString(10, c.getPos());
            ps.setString(11, c.getElaborado());
            ps.setString(12, c.getControltecnico());
            ps.setString(13, c.getRegistrosanitario());
            ps.setString(14, c.getViaadministracion());
            ps.setString(15, c.getDescripcionatc());
            ps.setString(16, c.getUnidadmedida());
            ps.setString(17, c.getCantidadconcentrada());
            ps.setString(18, c.getFormafarmaceutica());
            ps.setString(19, c.getDescripcion());
            ps.setString(20, c.getEmbalaje());
            ps.setInt(21, c.getPrecioVenta());
            ps.setFloat(22, c.getCosto());
            ps.setInt(23, c.getCantidadActual());
            ps.setInt(24, c.getCantidadMinima());
            ps.setInt(25, c.getCantiadAvisar());
            ps.setString(26, c.getUbicacion());
            ps.setString(27, c.getTiporol());
            ps.setString(28, c.getModalidad());
            ps.setString(29, c.getEstadoregistro());
            ps.setString(30, c.getEstadocum());

            rs = ps.execute();

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return rs;

    }

    @Override
    public boolean delete(Object key) {
        try {
            PreparedStatement ps;
            ps = con.getConnection().prepareStatement("DELETE FROM PRODUCTOSBASE  WHERE ITEMPRODUCTO = ?");
            ps.setString(1, key.toString());

            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean update(ProductoDTO c) {

        boolean rs = false;
        PreparedStatement ps;

        try {
            ps = con.getConnection().prepareStatement(UPDATE);
            ps.setString(1, c.getPlu());
            ps.setString(2, c.getCodigobarras());
            ps.setString(3, c.getPrincipioactivo());
            ps.setString(4, c.getComercial());
            ps.setString(5, c.getLaboratorio());
            ps.setString(6, c.getPresentacion());
            ps.setString(7, c.getCum());
            ps.setString(8, c.getAtc());
            ps.setString(9, c.getCanal());
            ps.setString(10, c.getPos());
            ps.setString(11, c.getElaborado());
            ps.setString(12, c.getControltecnico());
            ps.setString(13, c.getRegistrosanitario());
            ps.setString(14, c.getViaadministracion());
            ps.setString(15, c.getDescripcionatc());
            ps.setString(16, c.getUnidadmedida());
            ps.setString(17, c.getCantidadconcentrada());
            ps.setString(18, c.getFormafarmaceutica());
            ps.setString(19, c.getDescripcion());
            ps.setString(20, c.getEmbalaje());
            ps.setInt(21, c.getPrecioVenta());
            ps.setFloat(22, c.getCosto());
            ps.setInt(23, c.getCantidadActual());
            ps.setInt(24, c.getCantidadMinima());
            ps.setInt(25, c.getCantiadAvisar());
            ps.setString(26, c.getUbicacion());
            ps.setString(27, c.getTiporol());
            ps.setString(28, c.getModalidad());
            ps.setString(29, c.getEstadoregistro());
            ps.setString(30, c.getEstadocum());
            ps.setInt(31, c.getItemproducto());

            rs = ps.execute();

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return rs;

    }

    @Override
    public ProductoDTO read(Object key) {

        PreparedStatement ps;
        ProductoDTO productos = null;
        ResultSet rs;

        try {
            if (key != null) {
                ps = con.getConnection().prepareStatement(READ);
                ps.setString(1, key.toString());
                ps.setString(2, key.toString());
                ps.setString(3, key.toString());
                ps.setString(4, key.toString());
                rs = ps.executeQuery();
                while (rs.next()) {
                    productos = new ProductoDTO(rs.getInt("itemproducto"), rs.getString("plu"), rs.getString("codigobarras"), rs.getString("principioactivo"),
                            rs.getString("comercial"), rs.getString("laboratorio"), rs.getString("presentacion"), rs.getString("cum"),
                            rs.getString("atc"), rs.getString("canal"), rs.getString("pos"), rs.getString("elaborado"), rs.getString("controltecnico"),
                            rs.getString("registrosanitario"), rs.getString("viaadministracion"), rs.getString("unidad"), rs.getString("concentracion"),
                            rs.getString("descripcionatc"), rs.getString("unidadmedida"), rs.getString("cantidadconcentrada"), rs.getString("unidadreferencia"),
                            rs.getString("formafarmaceutica"), rs.getString("descripcion"), rs.getString("embalaje"), rs.getInt("precio_venta"),
                            rs.getFloat("costo"), rs.getInt("cantidadactual"), rs.getInt("cantidadminima"), rs.getInt("cantidadaviso"), rs.getString("ubicacion"),
                            rs.getString("tiporol"), rs.getString("modalidad"), rs.getString("estadoregistro"), rs.getString("estadocum"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return productos;
    }

    @Override
    public List<ProductoDTO> readAll() {

        PreparedStatement ps;
        List<ProductoDTO> listproductos = null;
        ResultSet rs;

        try {
            ps = con.getConnection().prepareCall(READALL);
            rs = ps.executeQuery();
            listproductos = new ArrayList();
            while (rs.next()) {

                listproductos.add(new ProductoDTO(rs.getInt("itemproducto"), rs.getString("plu"), rs.getString("codigobarras"), rs.getString("principioactivo"),
                        rs.getString("comercial"), rs.getString("laboratorio"), rs.getString("presentacion"), rs.getString("cum"),
                        rs.getString("atc"), rs.getString("canal"), rs.getString("pos"), rs.getString("elaborado"), rs.getString("controltecnico"),
                        rs.getString("registrosanitario"), rs.getString("viaadministracion"), rs.getString("unidad"), rs.getString("concentracion"),
                        rs.getString("descripcionatc"), rs.getString("unidadmedida"), rs.getString("cantidadconcentrada"), rs.getString("unidadreferencia"),
                        rs.getString("formafarmaceutica"), rs.getString("descripcion"), rs.getString("embalaje"), rs.getInt("precio_venta"),
                        rs.getFloat("costo"), rs.getInt("cantidadactual"), rs.getInt("cantidadminima"), rs.getInt("cantidadaviso"),
                        rs.getString("ubicacion"), rs.getString("tiporol"), rs.getString("modalidad"), rs.getString("estadoregistro"), rs.getString("estadocum")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listproductos;
    }

    public boolean GenararPlu(ProductoDTO dTO) {

        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.getConnection().prepareStatement(GENERARPLU);
            ps.setString(1, dTO.getPlu());
            rs = ps.executeQuery();

            while (rs.next()) {

                return true;
            }

        } catch (Exception e) {
        }

        return false;
    }

    public boolean VerificarCodigoBarras(String codigo) {

        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.getConnection().prepareStatement("Select CodigoBarras from ProductosBase where codigoBarras = ?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {

                return true;
            }

        } catch (Exception e) {
        }

        return false;

    }

    public boolean AsiganarCodigoBarras(ProductoDTO c) {

        PreparedStatement ps;
        try {

            ps = con.getConnection().prepareStatement("UPDATE PRODUCTOSBASE SET CODIGOBARRAS = ? WHERE ITEMPRODUCTO = ?");
            ps.setString(1, c.getCodigobarras());
            ps.setInt(2, c.getItemproducto());

            System.out.println("ASIGANAR CODIGO BARRAS: " + ps);
            System.out.println("Codigo de Barras: " + c.getCodigobarras());
            return ps.execute();

        } catch (Exception e) {
        }

        return true;
    }

    public List<ProductoDTO> CanalPos() {

        PreparedStatement ps;
        List<ProductoDTO> listcanalpos = null;
        ResultSet rs;

        try {
            String sql = "SELECT\n"
                    + "productosbase.canal,\n"
                    + "productosbase.pos\n"
                    + "FROM `productosbase`\n"
                    + "GROUP BY\n"
                    + "productosbase.canal,\n"
                    + "productosbase.pos";

            ps = con.getConnection().prepareCall(sql);
            rs = ps.executeQuery();
            listcanalpos = new ArrayList();
            while (rs.next()) {
                ProductoDTO dTO = new ProductoDTO();

                dTO.setCanal(rs.getString("canal"));
                dTO.setPos(rs.getString("pos"));

                listcanalpos.add(dTO);
            }

        } catch (Exception e) {

        }
        return listcanalpos;

    }

    private ProductoDTO productoDTO = new ProductoDTO();

    public Object[][] PresentacionesDisponibles(String registroSanitario) {

        String sql_TABLAS = "db_invima.registros_sanitarios,db_invima.notificaciones ",
                sql_CAMPOS = "CONCAT(db_invima.registros_sanitarios.EXPEDIENTE,'-',\n"
                + "db_invima.registros_sanitarios.CONSECUTIVO) AS CODIGO_CUM,\n"
                + "db_invima.registros_sanitarios.CANTIDAD AS EMBALAJE_X_PRESENTACION,\n"
                + "UPPER(db_invima.registros_sanitarios.`DESCRIPCIÓNPRESENTACIÓNCOMERCIAL`) AS PRESENTACION,\n"
                + "UPPER(db_invima.registros_sanitarios.ESTADOCUM) AS ESTADOCUM,\n"
                + "db_invima.registros_sanitarios.TITULAR,\n"
                + "db_invima.registros_sanitarios.NOMBREROL,\n"
                + "db_invima.registros_sanitarios.TIPOROL,"
                + "db_invima.registros_sanitarios.MODALIDAD,\n"
                + "db_invima.registros_sanitarios.ATC,\n"
                + "db_invima.registros_sanitarios.`DESCRIPCIÓNATC`,\n"
                + "db_invima.registros_sanitarios.PRINCIPIOACTIVO,\n"
                + "db_invima.registros_sanitarios.UNIDADMEDIDA,\n"
                + "db_invima.registros_sanitarios.`VÍAADMINISTRACIÓN`,\n"
                + "db_invima.registros_sanitarios.`FORMAFARMACÉUTICA`,\n"
                + "db_invima.registros_sanitarios.CANTIDADconcentrada,"
                + "db_invima.registros_sanitarios.producto,"
                + "db_invima.registros_sanitarios.ESTADOREGISTRO,"
                + "db_invima.notificaciones.versionbd",
                sql_WHERE = "db_invima.registros_sanitarios.REGISTROSANITARIO LIKE '%" + registroSanitario + "%'";

        Object[][] rs = con.select(sql_TABLAS, sql_CAMPOS, sql_WHERE);

        if (rs.length > 0) {
            productoDTO.setCum(rs[0][0].toString());
            productoDTO.setEmbalaje(rs[0][1].toString());
            productoDTO.setPresentacion(rs[0][2].toString());
            productoDTO.setEstadocum(rs[0][3].toString());
            productoDTO.setLaboratorio(rs[0][4].toString());
            productoDTO.setElaborado(rs[0][5].toString());
            productoDTO.setTiporol(rs[0][6].toString());
            productoDTO.setModalidad(rs[0][7].toString());
            productoDTO.setAtc(rs[0][8].toString());
            productoDTO.setDescripcionatc(rs[0][9].toString());
            productoDTO.setPrincipioactivo(rs[0][10].toString());
            productoDTO.setUnidadmedida(rs[0][11].toString());
            productoDTO.setViaadministracion(rs[0][12].toString());
            productoDTO.setFormafarmaceutica(rs[0][13].toString());
            productoDTO.setCantidadconcentrada(rs[0][14].toString());
            productoDTO.setComercial(rs[0][15].toString());
            productoDTO.setEstadoregistro(rs[0][16].toString());
            productoDTO.setVersionBDinvima(rs[0][17].toString());

            setProductoDTO(productoDTO);
            return rs;

        }

        return null;
    }

    public Object[][] PLUS_ASOCIADOS(String PLU) {

        String SQL_TABLA = "productosbase, db_invima.registros_sanitarios",
                SQL_CAMPOS = "productosbase.itemproducto,\n"
                + "productosbase.plu,\n"
                + "productosbase.codigobarras,\n"
                + "productosbase.descripcion,\n"
                + "productosbase.cum,UPPER(db_invima.registros_sanitarios.ESTADOCUM ) AS ESTADOCUM ,\n"
                + " productosbase.registrosanitario,\n"
                + "UPPER(db_invima.registros_sanitarios.ESTADOREGISTRO) AS ESTADOREGISTRO",
                SQL_WHERE = "productosbase.plu = '" + PLU + "' AND \n"
                + "CONCAT(db_invima.registros_sanitarios.EXPEDIENTE,'-',db_invima.registros_sanitarios.CONSECUTIVO) = productosbase.cum\n"
                + "GROUP BY productosbase.cum";

        Object rs[][] = con.select(SQL_TABLA, SQL_CAMPOS, SQL_WHERE);

        if (rs.length > 0) {
            return rs;
        }

        return null;
    }

    public ProductoDTO getProductoDTO() {
        return productoDTO;
    }

    public void setProductoDTO(ProductoDTO productoDTO) {
        this.productoDTO = productoDTO;
    }

    Edicion edicion = new Edicion();

    public Object[][] lotesalmacenados(Object key) {
        /* List<Object> list = null;
         Lotealmacenado lote;
         PreparedStatement ps;
         ResultSet rs;
         String SQL = "SELECT\n"
         + "lotes_almacenados.idlotealmacenado,\n"
         + "lotes_almacenados.CODIGOBARRAS,\n"
         + "lotes_almacenados.PLU,\n"
         + "lotes_almacenados.DESCRIPCION,\n"
         + "lotes_almacenados.NUMEROLOTE,\n"
         + "lotes_almacenados.FECHAVENCE,\n"
         + "lotes_almacenados.STOCKLOTE\n"
         + "FROM `lotes_almacenados`\n"
         + "WHERE\n"
         + "lotes_almacenados.CODIGOBARRAS = ? OR\n"
         + "lotes_almacenados.PLU = ? AND\n"
         + "lotes_almacenados.STOCKLOTE > 0";
         try {
         ps = getConnection().prepareStatement(SQL);
         ps.setObject(1, key);
         ps.setObject(2, key);

         rs = ps.executeQuery();
         list = new ArrayList<>();
         while (rs.next()) {
         lote = new Lotealmacenado();
         lote.setIdlotealmacenado(rs.getInt("idlotealmacenado"));
         lote.setCodigoProducto(rs.getString("codigobarras"));
         lote.setNumerolote(rs.getString("numerolote"));
         lote.setFecha_vencimiento(rs.getDate("fechavence"));
         lote.setStocklote(rs.getInt("stocklote"));
         list.add(lote);
         }
         } catch (Exception e) {
         edicion.mensajes(3, "IMPOSIBLE CARGAR LOS LOTES ALMACENADOS.\n" + e);
         }
         return list;*/

        Object[][] rs = select("lotes_almacenados",
                "lotes_almacenados.idlotealmacenado,\n"
                + "lotes_almacenados.CODIGOBARRAS,\n"
                + "lotes_almacenados.NUMEROLOTE,\n"
                + "DATE_FORMAT(lotes_almacenados.FECHAVENCE,'%Y-%m-%d') as FECHAVENCE,\n"
                + "sum(lotes_almacenados.STOCKLOTE)",
                "(lotes_almacenados.CODIGOBARRAS = '" + key + "' OR\n"
                + "lotes_almacenados.PLU = '" + key + "') AND\n"
                + "lotes_almacenados.STOCKLOTE >= 1 "
                + "group by lotes_almacenados.NUMEROLOTE, lotes_almacenados.CODIGOBARRAS order by fechavence");

        return rs;
    }

    public Lotealmacenado leerlotereferencia(Object referencia, Object lotealmacen) {
        Lotealmacenado lote = null;
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "SELECT\n"
                + "lotes_almacenados.CODIGOBARRAS,\n"
                + "lotes_almacenados.NUMEROLOTE,\n"
                + "lotes_almacenados.FECHAVENCE,\n"
                + "lotes_almacenados.STOCKLOTE,\n"
                + "lotes_almacenados.PLU,\n"
                + "lotes_almacenados.idlotealmacenado\n"
                + "FROM `lotes_almacenados` where codigobarras = ? and numerolote = ? and stocklote > 0";
        try {
            ps = getConnection().prepareStatement(SQL);
            ps.setObject(1, referencia);
            ps.setObject(2, lotealmacen);
            rs = ps.executeQuery();

            if (rs.next()) {
                lote = new Lotealmacenado();
                lote.setCodigoProducto(rs.getString("codigobarras"));
                lote.setNumerolote(rs.getString("numerolote"));
                lote.setFecha_vencimiento(rs.getDate("fechavence"));
                lote.setStocklote(rs.getInt("stocklote"));
                lote.setIdlotealmacenado(rs.getInt("idlotealmacenado"));
            }
        } catch (Exception e) {
            System.out.println("Error al momento de consultar el Lote: " + e);
        }

        return lote;
    }

    @Override
    public List<ProductoDTO> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Lotealmacenado leerlotealmacenado(Object key) {
        Lotealmacenado lote = null;
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "SELECT\n"
                + "lotes_almacenados.CODIGOBARRAS,\n"
                + "lotes_almacenados.NUMEROLOTE,\n"
                + "lotes_almacenados.FECHAVENCE,\n"
                + "lotes_almacenados.STOCKLOTE,\n"
                + "lotes_almacenados.PLU,\n"
                + "lotes_almacenados.idlotealmacenado\n"
                + "FROM `lotes_almacenados` where codigobarras = ?";
        try {
            ps = getConnection().prepareStatement(SQL);
            ps.setObject(1, key);
            rs = ps.executeQuery();

            if (rs.next()) {
                lote = new Lotealmacenado();
                lote.setCodigoProducto(rs.getString("codigobarras"));
                lote.setNumerolote(rs.getString("numerolote"));
                lote.setFecha_vencimiento(rs.getDate("fechavence"));
                lote.setStocklote(rs.getInt("stocklote"));
                lote.setIdlotealmacenado(rs.getInt("idlotealmacenado"));
            }
        } catch (Exception e) {
            System.out.println("Error al momento de consultar el Lote: " + e);
        }

        return lote;
    }

}
