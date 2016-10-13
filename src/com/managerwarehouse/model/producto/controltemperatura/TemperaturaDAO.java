package com.managerwarehouse.model.producto.controltemperatura;

import com.managerwarehouse.util.database;
import java.util.ArrayList;
import java.util.List;

public class TemperaturaDAO extends database {
    
    public boolean CRUD_TEMPERATURA(Object[] key){
        return insertSP("", key);
    }
    
    public Object[][] LISTADO_TEMPERATURA(){
        Object[][] rs = select("temperaturas", "descripcion", null);
        return rs;
    }
    
    public Temperatura LEER_TEMPERATURA(Object key){
        Temperatura temp = null;
        Object[][] rs = select("temperaturas", "itemtemperatura, descripcion, minimo, maxima, unidadmedida", 
                "descripcion = '"+key+"'");
        if (rs.length > 0) {
            temp = new Temperatura();
            temp.setItemtemperatura(Integer.parseInt(rs[0][0].toString()));
            temp.setDescripcion(rs[0][1].toString());
            temp.setMinimo(Integer.parseInt(rs[0][2].toString()));
            temp.setMaximo(Integer.parseInt(rs[0][3].toString()));
            temp.setUnidadMedida(rs[0][4].toString());
        }
        return temp;
    }
}
