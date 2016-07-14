
package com.managerwarehouse.model.producto.devoluciones.proveedor;

import com.managerwarehouse.model.proveedor.ProveedorDTO;
import com.managerwarehouse.model.usuario_system.EmpleadoDTO;
import java.util.Date;


public class DevolucionProveedor {
    private int iddevolucionproveedor;
    private Date fechaemision;
    private ProveedorDTO proveedor;
    private String concepto;
    private EmpleadoDTO empleado;
    private Date fechahoraingreso;

    public DevolucionProveedor() {
    }

    public DevolucionProveedor(int iddevolucionproveedor, Date fechaemision, ProveedorDTO proveedor, String concepto, EmpleadoDTO empleado, Date fechahoraingreso) {
        this.iddevolucionproveedor = iddevolucionproveedor;
        this.fechaemision = fechaemision;
        this.proveedor = proveedor;
        this.concepto = concepto;
        this.empleado = empleado;
        this.fechahoraingreso = fechahoraingreso;
    }

    public int getIddevolucionproveedor() {
        return iddevolucionproveedor;
    }

    public void setIddevolucionproveedor(int iddevolucionproveedor) {
        this.iddevolucionproveedor = iddevolucionproveedor;
    }

    public Date getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(Date fechaemision) {
        this.fechaemision = fechaemision;
    }

    public ProveedorDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedor = proveedor;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
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
}
