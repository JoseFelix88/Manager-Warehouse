

package com.managerwarehouse.model.inventario.salidaautorizada;

import com.managerwarehouse.model.inventario.Lotealmacenado;
import com.managerwarehouse.model.producto.ProductoDTO;

public class DetalleSalidaAutorizada {
    
    private int iddetallesalidaautorizada;
    private SalidaAutorizada salidaAutorizada;
    private ProductoDTO producto;
    private Lotealmacenado lotealmacenado;
    private int cantidad;
    private int vrunidad;

    public DetalleSalidaAutorizada() {
        salidaAutorizada = new SalidaAutorizada();
        producto = new ProductoDTO();
        lotealmacenado = new Lotealmacenado();
    }

    public DetalleSalidaAutorizada(int iddetallesalidaautorizada, SalidaAutorizada salidaAutorizada, ProductoDTO producto, Lotealmacenado lotealmacenado, int cantidad, int vrunidad) {
        this.iddetallesalidaautorizada = iddetallesalidaautorizada;
        this.salidaAutorizada = salidaAutorizada;
        this.producto = producto;
        this.lotealmacenado = lotealmacenado;
        this.cantidad = cantidad;
        this.vrunidad = vrunidad;
    }

    public int getIddetallesalidaautorizada() {
        return iddetallesalidaautorizada;
    }

    public void setIddetallesalidaautorizada(int iddetallesalidaautorizada) {
        this.iddetallesalidaautorizada = iddetallesalidaautorizada;
    }

    public SalidaAutorizada getSalidaAutorizada() {
        return salidaAutorizada;
    }

    public void setSalidaAutorizada(SalidaAutorizada salidaAutorizada) {
        this.salidaAutorizada = salidaAutorizada;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public Lotealmacenado getLotealmacenado() {
        return lotealmacenado;
    }

    public void setLotealmacenado(Lotealmacenado lotealmacenado) {
        this.lotealmacenado = lotealmacenado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getVrunidad() {
        return vrunidad;
    }

    public void setVrunidad(int vrunidad) {
        this.vrunidad = vrunidad;
    }
    
}
