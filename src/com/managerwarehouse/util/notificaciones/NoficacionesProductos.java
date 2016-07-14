
package com.managerwarehouse.util.notificaciones;

import com.managerwarehouse.util.DateUtil;
import com.managerwarehouse.util.Edicion;
import java.util.Date;



public class NoficacionesProductos {
    Edicion edicion = new Edicion();

    public NoficacionesProductos() {
    }
    
    public void Semaforizacion(Date FECHA_VENCE){
        int diferencia_dia = DateUtil.daysDiff(DateUtil.newDate(), FECHA_VENCE);
        
        
        System.out.println("Dias de Diferencia: "+diferencia_dia);
    }
}
