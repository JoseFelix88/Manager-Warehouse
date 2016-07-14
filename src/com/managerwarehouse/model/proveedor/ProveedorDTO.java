
package com.managerwarehouse.model.proveedor;


public class ProveedorDTO {

    private int idproveedor;
    private String nit;
    private String RazonSocial;
    private String direccion;
    private String telefono;
    private String emailempresa;
    private String contacto;
    private String telContacto;
    private String emailContacto;
    
    public ProveedorDTO() {
    }

    public ProveedorDTO(int idproveedor, String nit, String RazonSocial, String direccion, String telefono, String emailempresa, String contacto, String telContacto, String emailContacto) {
        this.idproveedor = idproveedor;
        this.nit = nit;
        this.RazonSocial = RazonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.emailempresa = emailempresa;
        this.contacto = contacto;
        this.telContacto = telContacto;
        this.emailContacto = emailContacto;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmailempresa() {
        return emailempresa;
    }

    public void setEmailempresa(String emailempresa) {
        this.emailempresa = emailempresa;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelContacto() {
        return telContacto;
    }

    public void setTelContacto(String telContacto) {
        this.telContacto = telContacto;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    
    
}
