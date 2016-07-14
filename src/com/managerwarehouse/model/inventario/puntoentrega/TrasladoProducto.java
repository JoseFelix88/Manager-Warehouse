package com.managerwarehouse.model.inventario.puntoentrega;

import com.managerwarehouse.model.puntoentrega.PuntoEntrega;
import com.managerwarehouse.model.usuario_system.EmpleadoDTO;
import java.util.Date;

public class TrasladoProducto {

    private String idtraslado;
    private Date fechaemision;
    private PuntoEntrega bodegaOrigen;
    private PuntoEntrega bodegaDestino;
    private String autorizado;
    private EmpleadoDTO realizado;
    private Date fechaingreso;

    public TrasladoProducto() {
    }

    public TrasladoProducto(String idtraslado, Date fechaemision, PuntoEntrega bodegaOrigen, PuntoEntrega bodegaDestino, String autorizado, EmpleadoDTO realizado, Date fechaingreso) {
        this.idtraslado = idtraslado;
        this.fechaemision = fechaemision;
        this.bodegaOrigen = bodegaOrigen;
        this.bodegaDestino = bodegaDestino;
        this.autorizado = autorizado;
        this.realizado = realizado;
        this.fechaingreso = fechaingreso;
    }

    public String getIdtraslado() {
        return idtraslado;
    }

    public void setIdtraslado(String idtraslado) {
        this.idtraslado = idtraslado;
    }

    public Date getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(Date fechaemision) {
        this.fechaemision = fechaemision;
    }

    public PuntoEntrega getBodegaOrigen() {
        return bodegaOrigen;
    }

    public void setBodegaOrigen(PuntoEntrega bodegaOrigen) {
        this.bodegaOrigen = bodegaOrigen;
    }

    public PuntoEntrega getBodegaDestino() {
        return bodegaDestino;
    }

    public void setBodegaDestino(PuntoEntrega bodegaDestino) {
        this.bodegaDestino = bodegaDestino;
    }

    public String getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(String autorizado) {
        this.autorizado = autorizado;
    }

    public EmpleadoDTO getRealizado() {
        return realizado;
    }

    public void setRealizado(EmpleadoDTO realizado) {
        this.realizado = realizado;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
}
