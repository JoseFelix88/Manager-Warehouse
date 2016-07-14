package com.managerwarehouse.model.factura_de_compra;

import com.managerwarehouse.model.proveedor.ProveedorDAO;
import com.managerwarehouse.model.proveedor.ProveedorDTO;
import com.managerwarehouse.model.usuario_system.EmpleadoDAO;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Servidor-PC
 */
public class FacturaCompraDTO {

    private int idcompra;
    private ProveedorDAO proveedorDAO = new ProveedorDAO();
    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();
    private String proveedor;
    private Date fechaFactura;
    private Date fechaVenceFactura;
    private Date fechaIngreso;
    private String numeroFactura;
    private String tipoPago;
    private int subtotal;
    private float iva;
    private int descuento;
    private float reteFTE;
    private float reteIVA;
    private float reteICA;
    private int totalnetoPago;
    private String numeroRemesa;
    private String usuario;
    private Time horaingreso;
   

    //DETALLE DE FACTURA DE COMPRA...
    private List<DetalleCompraDTO> listDetalle;

    public FacturaCompraDTO() {
    }

    public FacturaCompraDTO(int idcompra, String numeroFactura) {
        this.idcompra = idcompra;
        this.numeroFactura = numeroFactura;
    }

    public FacturaCompraDTO(int idcompra, Date fechaFactura, Date fechaVenceFactura, 
            Date fechaIngreso, String idproveedor, String numeroFactura, String tipoPago,
            int subtotal, float iva, int descuento, float reteFTE, float reteIVA, 
            float reteICA, int totalnetoPago, String numeroRemesa,String usuario, Time horaingreso) {
        
        
        this.idcompra = idcompra;
        this.fechaFactura = fechaFactura;
        this.fechaVenceFactura = fechaVenceFactura;
        this.fechaIngreso = fechaIngreso;
        this.proveedor = idproveedor;
        this.numeroFactura = numeroFactura;
        this.tipoPago = tipoPago;
        this.subtotal = subtotal;
        this.iva = iva;
        this.descuento = descuento;
        this.reteFTE = reteFTE;
        this.reteIVA = reteIVA;
        this.reteICA = reteICA;
        this.totalnetoPago = totalnetoPago;
        this.numeroRemesa = numeroRemesa;
        this.usuario = usuario;
        this.horaingreso = horaingreso;
        
    }
    
    

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Date getFechaVenceFactura() {
        return fechaVenceFactura;
    }

    public void setFechaVenceFactura(Date fechaVenceFactura) {
        this.fechaVenceFactura = fechaVenceFactura;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public float getReteFTE() {
        return reteFTE;
    }

    public void setReteFTE(float reteFTE) {
        this.reteFTE = reteFTE;
    }

    public float getReteIVA() {
        return reteIVA;
    }

    public void setReteIVA(float reteIVA) {
        this.reteIVA = reteIVA;
    }

    public float getReteICA() {
        return reteICA;
    }

    public void setReteICA(float reteICA) {
        this.reteICA = reteICA;
    }

    public int getTotalnetoPago() {
        return totalnetoPago;
    }

    public void setTotalnetoPago(int totalnetoPago) {
        this.totalnetoPago = totalnetoPago;
    }

  

    public String getNumeroRemesa() {
        return numeroRemesa;
    }

    public void setNumeroRemesa(String numeroRemesa) {
        this.numeroRemesa = numeroRemesa;
    }

   
    public List<DetalleCompraDTO> getListDetalle() {
        return listDetalle;
    }

    public void setListDetalle(List<DetalleCompraDTO> listDetalle) {
        this.listDetalle = listDetalle;
    }

    public ProveedorDAO getProveedorDAO() {
        
        return proveedorDAO;
    }

   

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Time getHoraingreso() {
        return horaingreso;
    }

    public void setHoraingreso(Time horaingreso) {
        this.horaingreso = horaingreso;
    }

    public EmpleadoDAO getEmpleadoDAO() {
        return empleadoDAO;
    }

    public DetalleCompraDTO getDetalleCompraDTO() {
        return detalleCompraDTO;
    }

    public void setDetalleCompraDTO(DetalleCompraDTO detalleCompraDTO) {
        this.detalleCompraDTO = detalleCompraDTO;
    }

   

}
