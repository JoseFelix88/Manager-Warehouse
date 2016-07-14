
package com.managerwarehouse.model.inventario;

import com.managerwarehouse.model.producto.ProductoDTO;
import java.util.Date;

public class DetalleConteoFisico {
    
    private int itemdetalleconteo;
    private ConteoFisico conteoFisico;
    private ProductoDTO producto;
    private String lote;
    private Date fechavence;
    private String responsable;
    private int cantidadcontada;

    public DetalleConteoFisico() {
    }

    public DetalleConteoFisico(int itemdetalleconteo, ConteoFisico conteoFisico, ProductoDTO producto, String lote, Date fechavence, String responsable, int cantidadcontada) {
        this.itemdetalleconteo = itemdetalleconteo;
        this.conteoFisico = conteoFisico;
        this.producto = producto;
        this.lote = lote;
        this.fechavence = fechavence;
        this.responsable = responsable;
        this.cantidadcontada = cantidadcontada;
    }

    public int getItemdetalleconteo() {
        return itemdetalleconteo;
    }

    public void setItemdetalleconteo(int itemdetalleconteo) {
        this.itemdetalleconteo = itemdetalleconteo;
    }

    public ConteoFisico getConteoFisico() {
        return conteoFisico;
    }

    public void setConteoFisico(ConteoFisico conteoFisico) {
        this.conteoFisico = conteoFisico;
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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getCantidadcontada() {
        return cantidadcontada;
    }

    public void setCantidadcontada(int cantidadcontada) {
        this.cantidadcontada = cantidadcontada;
    }
}
