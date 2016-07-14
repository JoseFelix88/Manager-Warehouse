

package com.managerwarehouse.model.inventario.salidaautorizada;

import java.util.Date;

public class SalidaAutorizada {
    
    private int idsalidaautorizada;
    private Date fechaemision;
    private String autorizado;
    private String concepto;
    private String realizado;
    private Date fechahoraingreso;

    public SalidaAutorizada() {
    }

    public SalidaAutorizada(int idsalidaautorizada, Date fechaemision, String autorizado, String concepto, String realizado, Date fechahoraingreso) {
        this.idsalidaautorizada = idsalidaautorizada;
        this.fechaemision = fechaemision;
        this.autorizado = autorizado;
        this.concepto = concepto;
        this.realizado = realizado;
        this.fechahoraingreso = fechahoraingreso;
    }

   

    public int getIdsalidaautorizada() {
        return idsalidaautorizada;
    }

    public void setIdsalidaautorizada(int idsalidaautorizada) {
        this.idsalidaautorizada = idsalidaautorizada;
    }

    public Date getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(Date fechaemision) {
        this.fechaemision = fechaemision;
    }

    public String getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(String autorizado) {
        this.autorizado = autorizado;
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

    public Date getFechahoraingreso() {
        return fechahoraingreso;
    }

    public void setFechahoraingreso(Date fechahoraingreso) {
        this.fechahoraingreso = fechahoraingreso;
    }

}
