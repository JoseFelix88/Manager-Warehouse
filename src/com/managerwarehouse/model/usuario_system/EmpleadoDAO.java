package com.managerwarehouse.model.usuario_system;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.util.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO extends database implements crud<EmpleadoDTO> {

    @Override
    public boolean create(EmpleadoDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(EmpleadoDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EmpleadoDTO read(Object key) {
        EmpleadoDTO edto = null;
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "Select id, nombre, correo_empresa, password,cargo, nivel from empleados where id = ?";
        try {
            ps = getConnection().prepareStatement(SQL);
            ps.setObject(1, key);

            rs = ps.executeQuery();
            if (rs.next()) {
                edto = new EmpleadoDTO();
                edto.setIdusuario(rs.getString("id"));
                edto.setNombreCompleto(rs.getString("nombre"));
                edto.setEmail(rs.getString("correo_empresa"));
                edto.setPassword(rs.getString("password"));
                edto.setCargo(rs.getString("cargo"));
                edto.setNivel(rs.getInt("nivel"));
            }
        } catch (Exception e) {
            System.out.println("error al consultar el empleado: "+e);
        }
        return edto;
    }

    @Override
    public List<EmpleadoDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<EmpleadoDTO> cargarOperadores() {
        EmpleadoDTO dto;
        List<EmpleadoDTO> list = null;
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "SELECT NOMBRE FROM EMPLEADOS WHERE CARGO = 1";
        try {
            ps = getConnection().prepareStatement(SQL);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                dto = new EmpleadoDTO(SQL, rs.getString("nombre"), SQL, SQL, SQL, SQL, SQL, SQL, SQL, SQL, SQL, SQL);

                list.add(dto);
            }
        } catch (Exception e) {
            System.out.println("error al cargar lista de operadores. " + e);
        }
        return list;
    }

    @Override
    public List<EmpleadoDTO> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public EmpleadoDTO ValidarAccesoEmpleado(Object[] key) {
        EmpleadoDTO edto = null;
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "Select id, nombre, correo_empresa, password,cargo, nivel, estado from empleados where id = ? and clave = md5(?)";
        try {
            ps = getConnection().prepareStatement(SQL);
            ps.setObject(1, key[0]);
            ps.setObject(2, key[1]);
            rs = ps.executeQuery();
            if (rs.next()) {
                edto = new EmpleadoDTO();
                edto.setIdusuario(rs.getString("id"));
                edto.setNombreCompleto(rs.getString("nombre"));
                edto.setEmail(rs.getString("correo_empresa"));
                edto.setPassword(rs.getString("password"));
                edto.setCargo(rs.getString("cargo"));
                edto.setEstado(rs.getString("estado"));
                edto.setNivel(rs.getInt("nivel"));
            }
        } catch (Exception e) {
            System.out.println("error al consultar logeo del empleado: "+e);
        }
        return edto;
    }
}
