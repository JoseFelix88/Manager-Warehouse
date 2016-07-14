package com.managerwarehouse.model.inventario;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.util.Edicion;
import com.managerwarehouse.util.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConteoFisicoDAO extends database implements crud<ConteoFisico> {

    @Override
    public boolean create(ConteoFisico c) {
        PreparedStatement ps;
        String SQL = "INSERT INTO CONTEOS_FISICOS (idconteofisico,FECHAINICIO, FECHAFIN, REALIZADO, fechahoraingreso) VALUES (?,?,?,?,NOW())";
        try {
            ps = getConnection().prepareStatement(SQL);
            ps.setObject(1, c.getIdconteofisico());
            ps.setObject(2, c.getFechainicio());
            ps.setObject(3, c.getFechafinal());
            ps.setString(4, c.getRealizado());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al Insertar el Conteo Fisico. " + e);
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return Delete("conteos_fisicos", "idconteofisico = " + key + "");
    }

    @Override
    public boolean update(ConteoFisico c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConteoFisico read(Object key) {
        ConteoFisico cf = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = getConnection().prepareStatement("SELECT idconteofisico, fechainicio, fechafin, realizado, fechahoraingreso "
                    + "FROM conteos_fisicos where idconteofisico = ?");
            ps.setObject(1, key);
            rs = ps.executeQuery();
            if (rs.next()) {
                cf = new ConteoFisico(rs.getInt("idconteofisico"), rs.getDate("fechainicio"),
                        rs.getDate("fechafin"), rs.getString("realizado"), rs.getDate("fechahoraingreso"));
            }
        } catch (Exception e) {
            System.out.println("Error al consultar conteo fisico. " + e);
        }
        return cf;
    }

    @Override
    public List<ConteoFisico> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConteoFisico> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object SiguienteConteo() {
        Object[][] rs = select("conteos_fisicos", "ifnull(max(idconteofisico) + 1,1)", null);
        return rs[0][0];
    }
}
