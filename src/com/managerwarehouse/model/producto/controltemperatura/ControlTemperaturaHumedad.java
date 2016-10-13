package com.managerwarehouse.model.producto.controltemperatura;

import com.managerwarehouse.model.usuario_system.EmpleadoDTO;
import java.util.Date;

public class ControlTemperaturaHumedad {
    
    private int idcontroltemp;
    private Date fecharegistro;
    private int valorAM;
    private int valorPM;
    private Date fechahoraingreso;
    private EmpleadoDTO empleado;
    private Temperatura temperatura;

    public int getIdcontroltemp() {
        return idcontroltemp;
    }

    public void setIdcontroltemp(int idcontroltemp) {
        this.idcontroltemp = idcontroltemp;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public int getValorAM() {
        return valorAM;
    }

    public void setValorAM(int valorAM) {
        this.valorAM = valorAM;
    }

    public int getValorPM() {
        return valorPM;
    }

    public void setValorPM(int valorPM) {
        this.valorPM = valorPM;
    }

    public Date getFechahoraingreso() {
        return fechahoraingreso;
    }

    public void setFechahoraingreso(Date fechahoraingreso) {
        this.fechahoraingreso = fechahoraingreso;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
    }
    
}
