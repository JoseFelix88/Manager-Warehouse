package com.managerwarehouse.model.inventario.puntoentrega;

import com.managerwarehouse.model.puntoentrega.PuntoEntrega;
import java.util.Date;

public class CargarInventario {
    
    private int idinventario;
    private Date fechaInicio;
    private Date fechaFinal;
    private PuntoEntrega puntoEntrega;

    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public PuntoEntrega getPuntoEntrega() {
        return puntoEntrega;
    }

    public void setPuntoEntrega(PuntoEntrega puntoEntrega) {
        this.puntoEntrega = puntoEntrega;
    }
    
    
    
}
