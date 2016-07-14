
package com.managerwarehouse.model.producto.devoluciones.puntoentrega;

import com.managerwarehouse.model.producto.ProductoDTO;
import java.util.Date;

public class DetalleDevolucionPuntoEntrega {
    
    private int iddetalledevolucion;
    private DevolucionPuntoEntrega devolucion;
    private ProductoDTO producto;
    private String lote;
    private Date fechavence;
    private int cantidad_devuelta;
    private int vrunidad;

    public DetalleDevolucionPuntoEntrega() {
        devolucion = new DevolucionPuntoEntrega();
        producto = new ProductoDTO();
    }

    public DetalleDevolucionPuntoEntrega(int iddetalledevolucion, DevolucionPuntoEntrega devolucion, ProductoDTO producto, String lote, Date fechavence, int cantidad_devuelta, int vrunidad) {
        this.iddetalledevolucion = iddetalledevolucion;
        this.devolucion = devolucion;
        this.producto = producto;
        this.lote = lote;
        this.fechavence = fechavence;
        this.cantidad_devuelta = cantidad_devuelta;
        this.vrunidad = vrunidad;
    }

    public int getIddetalledevolucion() {
        return iddetalledevolucion;
    }

    public void setIddetalledevolucion(int iddetalledevolucion) {
        this.iddetalledevolucion = iddetalledevolucion;
    }

    public DevolucionPuntoEntrega getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(DevolucionPuntoEntrega devolucion) {
        this.devolucion = devolucion;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getFechavence() {
        return fechavence;
    }

    public void setFechavence(Date fechavence) {
        this.fechavence = fechavence;
    }

    public int getCantidad_devuelta() {
        return cantidad_devuelta;
    }

    public void setCantidad_devuelta(int cantidad_devuelta) {
        this.cantidad_devuelta = cantidad_devuelta;
    }

    public int getVrunidad() {
        return vrunidad;
    }

    public void setVrunidad(int vrunidad) {
        this.vrunidad = vrunidad;
    }
    
}
