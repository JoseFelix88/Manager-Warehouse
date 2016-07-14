
package com.managerwarehouse.model.salida;


public class DetalleSalida {
    
    private int iddetallesalida;
    private int  salida;
    private String producto;
    private int lote;
    private int cantidad;
    private int caja;
    private String operador;

    public DetalleSalida() {
    }

    public DetalleSalida(int iddetallesalida, int salida, String producto, int lote, int cantidad, int caja, String operador) {
        this.iddetallesalida = iddetallesalida;
        this.salida = salida;
        this.producto = producto;
        this.lote = lote;
        this.cantidad = cantidad;
        this.caja = caja;
        this.operador = operador;
    }

    public int getIddetallesalida() {
        return iddetallesalida;
    }

    public void setIddetallesalida(int iddetallesalida) {
        this.iddetallesalida = iddetallesalida;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
    
}
