package com.managerwarehouse.model.usuario_system;


public class EmpleadoDTO {
    
    private String idusuario;
    private String password;
    private String primerNombre;
    private String segungoNombre;
    private String primerApellido;
    private String segungoApellido;
    private String direccion;
    private String telefono;
    private String celular;
    private String email;
    private String cargo;
    private String estado;
    private String nombreCompleto;
    private int nivel;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(String idusuario, String password, String primerNombre, String segungoNombre, String primerApellido, String segungoApellido, String direccion, String telefono, String celular, String email, String cargo, String estado) {
        this.idusuario = idusuario;
        this.password = password;
        this.primerNombre = primerNombre;
        this.segungoNombre = segungoNombre;
        this.primerApellido = primerApellido;
        this.segungoApellido = segungoApellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.cargo = cargo;
        this.estado = estado;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegungoNombre() {
        return segungoNombre;
    }

    public void setSegungoNombre(String segungoNombre) {
        this.segungoNombre = segungoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegungoApellido() {
        return segungoApellido;
    }

    public void setSegungoApellido(String segungoApellido) {
        this.segungoApellido = segungoApellido;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCompleto() {
//        nombreCompleto = getPrimerNombre()+" "+getPrimerApellido();
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
    
}
