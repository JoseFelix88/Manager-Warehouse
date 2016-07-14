

package com.managerwarehouse.model.producto;

import com.managerwarehouse.dao.crud.crud;
import com.managerwarehouse.util.database;
import java.util.List;

public class DispensarDAO implements crud<DispensarDTO>{

    @Override
    public boolean create(DispensarDTO c) {
        database db = new database();
        
        String values = "'"+c.getLugar()+"','"+c.getLote()+"',"+c.getCantidad_Almacen()+","
                + ""+c.getProducto()+",now()";
        
        return db.insert("dispensacion_productos", 
                "lugar, lotedispensado, cantidad, producto, fecha_hora", 
                values);
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(DispensarDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DispensarDTO read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DispensarDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DispensarDTO> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
