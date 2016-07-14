package com.managerwarehouse.model.inventario.puntoentrega;

import com.managerwarehouse.model.producto.ProductoDTO;

public class DetallePedidoPuntoEntrega {

    private int iddetallepedido;
    private PedidoPuntoEntrega pedido;
    private ProductoDTO producto;
    private int cantdespachada;
    private int cantidadpendiente;

    public DetallePedidoPuntoEntrega() {
    }

    public DetallePedidoPuntoEntrega(int iddetallepedido, PedidoPuntoEntrega pedido, ProductoDTO producto, int cantdespachada, int cantidadpendiente) {
        this.iddetallepedido = iddetallepedido;
        this.pedido = pedido;
        this.producto = producto;
        this.cantdespachada = cantdespachada;
        this.cantidadpendiente = cantidadpendiente;
    }

    public int getIddetallepedido() {
        return iddetallepedido;
    }

    public void setIddetallepedido(int iddetallepedido) {
        this.iddetallepedido = iddetallepedido;
    }

    public PedidoPuntoEntrega getPedido() {
        return pedido;
    }

    public void setPedido(PedidoPuntoEntrega pedido) {
        this.pedido = pedido;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public int getCantdespachada() {
        return cantdespachada;
    }

    public void setCantdespachada(int cantdespachada) {
        this.cantdespachada = cantdespachada;
    }

    public int getCantidadpendiente() {
        return cantidadpendiente;
    }

    public void setCantidadpendiente(int cantidadpendiente) {
        this.cantidadpendiente = cantidadpendiente;
    }
}
