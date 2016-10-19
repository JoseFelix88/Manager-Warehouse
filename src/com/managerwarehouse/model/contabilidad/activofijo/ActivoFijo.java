package com.managerwarehouse.model.contabilidad.activofijo;

import com.managerwarehouse.model.usuario_system.EmpleadoDTO;
import java.util.Date;

public class ActivoFijo {

    private int itemactivo;
    private String descripcion;
    private SubcategoriaAF subcategoria;
    private String marca;
    private String modelo;
    private String numeroserie;
    private String placa;
    private int valor;
    private Date fechaAdquisicion;
    private String metodoDepreciacion;
    private int porcDepreciado;
    private String Ubicacion;
    private String responsable;
    private Date fechaHoraRegistro;
    private EmpleadoDTO empleado;

    public int getItemactivo() {
        return itemactivo;
    }

    public void setItemactivo(int itemactivo) {
        this.itemactivo = itemactivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public SubcategoriaAF getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(SubcategoriaAF subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getMetodoDepreciacion() {
        return metodoDepreciacion;
    }

    public void setMetodoDepreciacion(String metodoDepreciacion) {
        this.metodoDepreciacion = metodoDepreciacion;
    }

    public int getPorcDepreciado() {
        return porcDepreciado;
    }

    public void setPorcDepreciado(int porcDepreciado) {
        this.porcDepreciado = porcDepreciado;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

}
