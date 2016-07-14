

package com.managerwarehouse.model.producto.devoluciones.puntoentrega;

import com.managerwarehouse.model.puntoentrega.PuntoEntrega;
import java.util.Date;

public class DevolucionPuntoEntrega {
    
    private int iddevolucion;
    private Date fechaemision;
    private PuntoEntrega puntoEntrega = new PuntoEntrega();
    private String concepto;
    private String realizado;
    private Date fechahoraIngreso;

    public DevolucionPuntoEntrega() {
        
    }

    public DevolucionPuntoEntrega(int iddevolucion, Date fechaemision, PuntoEntrega puntoEntrega, String concepto, String realizado, Date fechahoraIngreso) {
        this.iddevolucion = iddevolucion;
        this.fechaemision = fechaemision;
        this.puntoEntrega = puntoEntrega;
        this.concepto = concepto;
        this.realizado = realizado;
        this.fechahoraIngreso = fechahoraIngreso;
    }

    public int getIddevolucion() {
        return iddevolucion;
    }

    public void setIddevolucion(int iddevolucion) {
        this.iddevolucion = iddevolucion;
    }

    public Date getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(Date fechaemision) {
        this.fechaemision = fechaemision;
    }

    public PuntoEntrega getPuntoEntrega() {
        return puntoEntrega;
    }

    public void setPuntoEntrega(PuntoEntrega puntoEntrega) {
        this.puntoEntrega = puntoEntrega;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getRealizado() {
        return realizado;
    }

    public void setRealizado(String realizado) {
        this.realizado = realizado;
    }

    public Date getFechahoraIngreso() {
        return fechahoraIngreso;
    }

    public void setFechahoraIngreso(Date fechahoraIngreso) {
        this.fechahoraIngreso = fechahoraIngreso;
    }
   
}
