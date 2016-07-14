/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managerwarehouse.model.factura_de_compra;

import com.managerwarehouse.model.producto.ProductoDAO;
import java.util.Date;

/**
 *
 * @author Servidor-PC
 */
public class DetalleCompraDTO {

    private final ProductoDAO productoDAO = new ProductoDAO();
    
    private int iddetallecompra;
    private String codigoproducto;
    private String descripcionproducto;
    private int IDproducto;
    private int cantComprada;
    private int cantCajas;
    private int EmbalajeCaja;
    private String NumeroLote;
    private Date FechaVenceLote;
    private float costoCaja;
    private float costoUnidad;
    private float porcDescuento;
    private float costoTotal;
    private float valorDescuento;

    public DetalleCompraDTO() {
    }

    // CONSTRUCTOR PARA CONSULTAS A LA BASE DE DATOS.
    public DetalleCompraDTO(int iddetallecompra, String codigoproducto, String producto,
            int cantComprada, int cantCajas, int EmbalajeCaja, String NumeroLote,
            Date FechaVenceLote, float costoCaja, float costoUnidad, float porcDescuento,
            float costoTotal, float valorDescuento) {

        this.iddetallecompra = iddetallecompra;
        this.codigoproducto = codigoproducto;
        this.descripcionproducto = producto;
        this.cantComprada = cantComprada;
        this.cantCajas = cantCajas;
        this.EmbalajeCaja = EmbalajeCaja;
        this.NumeroLote = NumeroLote;
        this.FechaVenceLote = FechaVenceLote;
        this.costoCaja = costoCaja;
        this.costoUnidad = costoUnidad;
        this.porcDescuento = porcDescuento;
        this.costoTotal = costoTotal;
        this.valorDescuento = valorDescuento;
    }

    //CONSTRUCTOR PARA INSERTAR EN LA BASE DE DATOS
    public DetalleCompraDTO(int iddetallecompra, int producto, int cantComprada,
            int cantCajas, int Embalaje, String NumeroLote, Date FechaVence, float costoCaja,
            float costoUnidad, float porcDescuento, float costoTotal, float valorDescuento) {

        this.iddetallecompra = iddetallecompra;
        this.IDproducto = producto;
        this.cantComprada = cantComprada;
        this.cantCajas = cantCajas;
        this.EmbalajeCaja = Embalaje;
        this.NumeroLote = NumeroLote;
        this.FechaVenceLote = FechaVence;
        this.costoCaja = costoCaja;
        this.costoUnidad = costoUnidad;
        this.porcDescuento = porcDescuento;
        this.costoTotal = costoTotal;
        this.valorDescuento = valorDescuento;
    }

    public int getIddetallecompra() {
        return iddetallecompra;
    }

    public void setIddetallecompra(int iddetallecompra) {
        this.iddetallecompra = iddetallecompra;
    }

    public int getCantComprada() {
        return cantComprada;
    }

    public void setCantComprada(int cantComprada) {
        this.cantComprada = cantComprada;
    }

    public int getCantCajas() {
        return cantCajas;
    }

    public void setCantCajas(int cantCajas) {
        this.cantCajas = cantCajas;
    }

    public int getEmbalajeCaja() {
        return EmbalajeCaja;
    }

    public void setEmbalajeCaja(int EmbalajeCaja) {
        this.EmbalajeCaja = EmbalajeCaja;
    }

    public String getNumeroLote() {
        return NumeroLote;
    }

    public void setNumeroLote(String NumeroLote) {
        this.NumeroLote = NumeroLote;
    }

    public Date getFechaVenceLote() {
        return FechaVenceLote;
    }

    public void setFechaVenceLote(Date FechaVenceLote) {
        this.FechaVenceLote = FechaVenceLote;
    }

    public float getCostoCaja() {
        return costoCaja;
    }

    public void setCostoCaja(float costoCaja) {
        this.costoCaja = costoCaja;
    }

    public float getCostoUnidad() {
        return costoUnidad;
    }

    public void setCostoUnidad(float costoUnidad) {
        this.costoUnidad = costoUnidad;
    }

    public float getPorcDescuento() {
        return porcDescuento;
    }

    public void setPorcDescuento(float porcDescuento) {
        this.porcDescuento = porcDescuento;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public float getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(float valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public String getDescripcionproducto() {
        return descripcionproducto;
    }

    public void setDescripcionproducto(String descripcionproducto) {
        this.descripcionproducto = descripcionproducto;
    }

    public ProductoDAO getProductoDAO() {
        return productoDAO;
    }

    public String getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(String codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

}
