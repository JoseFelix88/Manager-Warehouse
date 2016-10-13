package com.managerwarehouse.model.producto.controltemperatura;

import com.managerwarehouse.util.database;

public class ControlTHDao extends database {

    public boolean CRUD_CTRL_T_H(Object[] key) {
        return EJECUTAR_SP("CRUD_CONTROL_TEMPERATURA", key);
    }

    public Object[][] HISTORICO_TEMPERATURAS(Object[] key) {
        Object parametro = ""+key[0]+","+key[1]+","+key[2];
        return SELECT_SP("SELECT_HISTORICO_TEMPERATURA", parametro);
    }

    public String numeroRegistro() {
        return select("control_temperaturas", "LPAD(IFNULL(MAX(control_temperaturas.idcontroltemp),0)+1,4,'0')", null)[0][0].toString();
    }
    
   
}
