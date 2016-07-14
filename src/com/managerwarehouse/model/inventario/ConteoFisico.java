
package com.managerwarehouse.model.inventario;

import java.util.Date;



public class ConteoFisico {
    private int idconteofisico;
    private Date fechainicio;
    private Date fechafinal;
    private String realizado;
    private Date fechaingreso;

    public ConteoFisico() {
    }

    public ConteoFisico(int idconteofisico, Date fechainicio, Date fechafinal, String realizado, Date fechaingreso) {
        this.idconteofisico = idconteofisico;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.realizado = realizado;
        this.fechaingreso = fechaingreso;
    }

    public int getIdconteofisico() {
        return idconteofisico;
    }

    public void setIdconteofisico(int idconteofisico) {
        this.idconteofisico = idconteofisico;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public String getRealizado() {
        return realizado;
    }

    public void setRealizado(String realizado) {
        this.realizado = realizado;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    
}
