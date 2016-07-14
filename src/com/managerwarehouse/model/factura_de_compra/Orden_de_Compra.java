

package com.managerwarehouse.model.factura_de_compra;

import com.managerwarehouse.model.producto.ProductoDTO;
import com.managerwarehouse.model.proveedor.ProveedorDTO;
import java.util.Date;

public class Orden_de_Compra {
    private int idordencompra;
    private ProveedorDTO proveedor;
    private ProductoDTO producto;
    private int precio;
    private int cantidadPedida;
    private Date fechaingreso;
    private Date fechaModificacion;
    private int iddetallecompra;

    public Orden_de_Compra() {
    }

    public Orden_de_Compra(int idordencompra, ProveedorDTO proveedor, ProductoDTO producto, int precio, int cantidadPedida, Date fechaingreso, Date fechaModificacion) {
        this.idordencompra = idordencompra;
        this.proveedor = proveedor;
        this.producto = producto;
        this.precio = precio;
        this.cantidadPedida = cantidadPedida;
        this.fechaingreso = fechaingreso;
        this.fechaModificacion = fechaModificacion;
    }

    

    public int getIdordencompra() {
        return idordencompra;
    }

    public void setIdordencompra(int idordencompra) {
        this.idordencompra = idordencompra;
    }

    public ProveedorDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedor = proveedor;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getCantidadPedida() {
        return cantidadPedida;
    }

    public void setCantidadPedida(int cantidadPedida) {
        this.cantidadPedida = cantidadPedida;
    }

    public int getIddetallecompra() {
        return iddetallecompra;
    }

    public void setIddetallecompra(int iddetallecompra) {
        this.iddetallecompra = iddetallecompra;
    }
    
}
