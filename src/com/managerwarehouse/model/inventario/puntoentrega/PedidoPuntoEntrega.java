

package com.managerwarehouse.model.inventario.puntoentrega;

import com.managerwarehouse.model.puntoentrega.PuntoEntrega;
import java.util.Date;

public class PedidoPuntoEntrega {
    
    private int numpedido;
    private Date fechaemision;
    private PuntoEntrega puntoEntrega;
    private Object fechaini;
    private Object fechafin;
    private String porcenvio;

    public PedidoPuntoEntrega(int numpedido, Date fechaemision, PuntoEntrega puntoEntrega, Object fechaini, Object fechafin, String porcenvio) {
        this.numpedido = numpedido;
        this.fechaemision = fechaemision;
        this.puntoEntrega = puntoEntrega;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
        this.porcenvio = porcenvio;
    }
            

    public PedidoPuntoEntrega() {
    }

    public PedidoPuntoEntrega(int numpedido, Date fechaemision, PuntoEntrega puntoEntrega) {
        this.numpedido = numpedido;
        this.fechaemision = fechaemision;
        this.puntoEntrega = puntoEntrega;
    }

    public int getNumpedido() {
        return numpedido;
    }

    public void setNumpedido(int numpedido) {
        this.numpedido = numpedido;
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

    public Object getFechaini() {
        return fechaini;
    }

    public void setFechaini(Object fechaini) {
        this.fechaini = fechaini;
    }

    public Object getFechafin() {
        return fechafin;
    }

    public void setFechafin(Object fechafin) {
        this.fechafin = fechafin;
    }

    public String getPorcenvio() {
        return porcenvio;
    }

    public void setPorcenvio(String porcenvio) {
        this.porcenvio = porcenvio;
    }
}
