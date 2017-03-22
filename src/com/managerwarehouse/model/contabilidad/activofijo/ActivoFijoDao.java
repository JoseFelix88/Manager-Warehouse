package com.managerwarehouse.model.contabilidad.activofijo;

import com.managerwarehouse.util.database;

public class ActivoFijoDao extends database {
    
    public boolean CRUD_ACTIVO_FIJO(Object[] values){
        return EJECUTAR_SP("CRUD_ACTIVO_FIJO", values);
    }
    
    public ActivoFijo CONSULTA_ACTIVO_FIJO(Object key){
        ActivoFijo af = null;
        
        return af;
    }
}
