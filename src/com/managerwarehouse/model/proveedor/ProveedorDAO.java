package com.managerwarehouse.model.proveedor;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.util.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProveedorDAO  implements crud<ProveedorDTO> {

    private final String PROVEEDORES_ALL_DATA = "SELECT * FROM PROVEEDORES order by razonsocial";
    private final String PROVEEDOR_DATA = "SELECT * FROM PROVEEDORES WHERE RAZONSOCIAL = ? or idproveedor = ? ";

    private ProveedorDTO proveedorDTO = new ProveedorDTO();
    
    public ProveedorDAO() {
    }

    database SQLConection = new database();

    @Override
    public boolean create(ProveedorDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ProveedorDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProveedorDTO read(Object key) {
        ProveedorDTO dTO = null;
        try {
            PreparedStatement ps = SQLConection.getConnection().prepareStatement(PROVEEDOR_DATA);
            ps.setString(1, key.toString());
            ps.setString(2, key.toString());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                 dTO = new ProveedorDTO(rs.getInt("idproveedor"), rs.getString("nit"), 
                        rs.getString("razonsocial"), rs.getString("direccion"), rs.getString("telefono"),
                        rs.getString("emailempresa"), rs.getString("contacto"), rs.getString("telcontacto"), rs.getString("emailcontacto"));
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         return dTO;
    }

    @Override
    public List<ProveedorDTO> readAll() {

        try {

            List<ProveedorDTO> list = new ArrayList<>();

            PreparedStatement ps = SQLConection.getConnection().prepareStatement(PROVEEDORES_ALL_DATA);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                list.add( new ProveedorDTO(rs.getInt("idproveedor"), rs.getString("nit"), 
                        rs.getString("razonsocial"), rs.getString("direccion"), rs.getString("telefono"),
                        rs.getString("emailempresa"), rs.getString("contacto"), rs.getString("telcontacto"), rs.getString("emailcontacto")));
            }
            
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ProveedorDTO getProveedorDTO() {
        return proveedorDTO;
    }

    public void setProveedorDTO(ProveedorDTO proveedorDTO) {
        this.proveedorDTO = proveedorDTO;
    }

    @Override
    public List<ProveedorDTO> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
