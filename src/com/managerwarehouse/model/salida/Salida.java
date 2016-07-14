
package com.managerwarehouse.model.salida;

import java.util.Date;



public class Salida {
    
    private int idsalida;
    private Date fechaemision;
    private String puntoentrega;
    private String numpedido;
    private int cantcajas;
    private String realizado;
    private String verificado;
    private int estado;      
    private Date fechahoraingreso;

    private DetalleSalida detalleSalida;
    
    public Salida() {
    }

    public Salida(int idsalida, Date fechaemision, String puntoentrega, String numpedido, int cantcajas, String realizado, String verificado, int estado, Date fechahoraingreso) {
        this.idsalida = idsalida;
        this.fechaemision = fechaemision;
        this.puntoentrega = puntoentrega;
        this.numpedido = numpedido;
        this.cantcajas = cantcajas;
        this.realizado = realizado;
        this.verificado = verificado;
        this.estado = estado;
        this.fechahoraingreso = fechahoraingreso;
    }

    public int getIdsalida() {
        return idsalida;
    }

    public void setIdsalida(int idsalida) {
        this.idsalida = idsalida;
    }

    public Date getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(Date fechaemision) {
        this.fechaemision = fechaemision;
    }

    public String getPuntoentrega() {
        return puntoentrega;
    }

    public void setPuntoentrega(String puntoentrega) {
        this.puntoentrega = puntoentrega;
    }

    public String getNumpedido() {
        return numpedido;
    }

    public void setNumpedido(String numpedido) {
        this.numpedido = numpedido;
    }

    public int getCantcajas() {
        return cantcajas;
    }

    public void setCantcajas(int cantcajas) {
        this.cantcajas = cantcajas;
    }

    public String getRealizado() {
        return realizado;
    }

    public void setRealizado(String realizado) {
        this.realizado = realizado;
    }

    public String getVerificado() {
        return verificado;
    }

    public void setVerificado(String verificado) {
        this.verificado = verificado;
    }

    public Date getFechahoraingreso() {
        return fechahoraingreso;
    }

    public void setFechahoraingreso(Date fechahoraingreso) {
        this.fechahoraingreso = fechahoraingreso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public DetalleSalida getDetalleSalida() {
        return detalleSalida;
    }

    public void setDetalleSalida(DetalleSalida detalleSalida) {
        this.detalleSalida = detalleSalida;
    }
    
    
}
