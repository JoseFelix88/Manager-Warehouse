
package com.managerwarehouse.model.inventario;

import java.util.Date;


public class Lotealmacenado {

    private int idlotealmacenado;
    private String codigoProducto;
    private String numerolote;
    private Date fecha_vencimiento;
    private int stocklote;

    public Lotealmacenado() {
    }

    public int getIdlotealmacenado() {
        return idlotealmacenado;
    }

    public void setIdlotealmacenado(int idlotealmacenado) {
        this.idlotealmacenado = idlotealmacenado;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNumerolote() {
        return numerolote;
    }

    public void setNumerolote(String numerolote) {
        this.numerolote = numerolote;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getStocklote() {
        return stocklote;
    }

    public void setStocklote(int stocklote) {
        this.stocklote = stocklote;
    }
    
    
    
}
