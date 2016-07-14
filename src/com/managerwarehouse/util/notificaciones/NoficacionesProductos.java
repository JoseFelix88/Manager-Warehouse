
package com.managerwarehouse.util.notificaciones;

import com.managerwarehouse.util.DateUtil;
import com.managerwarehouse.util.Edicion;
import java.awt.Color;
import java.awt.color.ColorSpace;
import java.util.Date;
import javax.swing.JOptionPane;



public class NoficacionesProductos {
    Edicion edicion = new Edicion();

    public NoficacionesProductos() {
    }
    
    public Color Semaforizacion(Date FECHA_VENCE){
        int diferencia_dia = DateUtil.daysDiff(DateUtil.newDate(), FECHA_VENCE);
        if (diferencia_dia < 91) {
            return Color.RED;
        }
        if (diferencia_dia >= 91 && diferencia_dia <= 180) {
            return Color.YELLOW;
        }
        return Color.GREEN;
    }
    
        public int Alerta_Vencimiento(Date FECHA_VENCE){
        int diferencia_dia = DateUtil.daysDiff(DateUtil.newDate(), FECHA_VENCE);
        if (diferencia_dia < 91) {
            return JOptionPane.ERROR_MESSAGE;
        }
        if (diferencia_dia > 91 && diferencia_dia < 180) {
           return JOptionPane.WARNING_MESSAGE;
        }
        return 14;
    }
}
