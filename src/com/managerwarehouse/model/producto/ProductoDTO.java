package com.managerwarehouse.model.producto;

public class ProductoDTO {

    private int itemproducto;
    private String plu;
    private String codigobarras;
    private String principioactivo;
    private String comercial;
    private String laboratorio;
    private String presentacion;
    private String cum;
    private String atc;
    private String canal;
    private String pos;
    private String elaborado;
    private String controltecnico;
    private String registrosanitario;
    private String viaadministracion;
    private String unidad;
    private String concentracion;
    private String descripcionatc;
    private String unidadmedida;
    private String cantidadconcentrada;
    private String unidadreferencia;
    private String formafarmaceutica;
    private String descripcion;
    private String embalaje;
    private int precioVenta;
    private float costo;
    private int cantidadActual;
    private int cantidadMinima;
    private int cantiadAvisar;
    private String ubicacion;
    private String estadocum;
    private String estadoregistro;
    private String modalidad;
    private String tiporol;
    private String versionBDinvima;
    
    private DispensarDTO dispensarDTO;

    public ProductoDTO() {
        this.dispensarDTO = new DispensarDTO();
    }

    public ProductoDTO(String codigobarras) {
        this.dispensarDTO = new DispensarDTO();
        this.codigobarras = codigobarras;
    }

    public ProductoDTO(int itemproducto, String plu, String codigobarras, 
            String principioactivo, String comercial, String laboratorio,
            String presentacion, String cum, String atc, String canal, 
            String pos, String elaborado, String controltecnico, String registrosanitario, 
            String viaadministracion, String unidad, String concentracion, String descripcionatc, 
            String unidadmedida, String cantidadconcentrada, String unidadreferencia, 
            String formafarmaceutica, String descripcion, String embalaje, int precioVenta,
            float costo, int cantidadActual, int cantidadMinima, int cantiadAvisar, 
            String ubicacion,String tiporol, String modalidad, String estadoregistro, String estadoCum) {
        this.dispensarDTO = new DispensarDTO();
        
        this.itemproducto = itemproducto;
        this.plu = plu;
        this.codigobarras = codigobarras;
        this.principioactivo = principioactivo;
        this.comercial = comercial;
        this.laboratorio = laboratorio;
        this.presentacion = presentacion;
        this.cum = cum;
        this.atc = atc;
        this.canal = canal;
        this.pos = pos;
        this.elaborado = elaborado;
        this.controltecnico = controltecnico;
        this.registrosanitario = registrosanitario;
        this.viaadministracion = viaadministracion;
        this.unidad = unidad;
        this.concentracion = concentracion;
        this.descripcionatc = descripcionatc;
        this.unidadmedida = unidadmedida;
        this.cantidadconcentrada = cantidadconcentrada;
        this.unidadreferencia = unidadreferencia;
        this.formafarmaceutica = formafarmaceutica;
        this.descripcion = descripcion;
        this.embalaje = embalaje;
        this.precioVenta = precioVenta;
        this.costo = costo;
        this.cantidadActual = cantidadActual;
        this.cantidadMinima = cantidadMinima;
        this.cantiadAvisar = cantiadAvisar;
        this.ubicacion = ubicacion;
        this.tiporol = tiporol;
        this.modalidad = modalidad;
        this.estadoregistro = estadoregistro;
        this.estadocum = estadoCum;
    }

    
    
   
    

    public int getItemproducto() {
        return itemproducto;
    }

    public void setItemproducto(int itemproducto) {
        this.itemproducto = itemproducto;
    }

    public String getPlu() {
        return plu;
    }

    public void setPlu(String plu) {
        this.plu = plu;
    }

    public String getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    public String getPrincipioactivo() {
        return principioactivo;
    }

    public void setPrincipioactivo(String principioactivo) {
        this.principioactivo = principioactivo;
    }

    public String getComercial() {
        return comercial;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getCum() {
        return cum;
    }

    public void setCum(String cum) {
        this.cum = cum;
    }

    public String getAtc() {
        return atc;
    }

    public void setAtc(String atc) {
        this.atc = atc;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getElaborado() {
        return elaborado;
    }

    public void setElaborado(String elaborado) {
        this.elaborado = elaborado;
    }

    public String getControltecnico() {
        return controltecnico;
    }

    public void setControltecnico(String controltecnico) {
        this.controltecnico = controltecnico;
    }

    public String getRegistrosanitario() {
        return registrosanitario;
    }

    public void setRegistrosanitario(String registrosanitario) {
        this.registrosanitario = registrosanitario;
    }

    public String getViaadministracion() {
        return viaadministracion;
    }

    public void setViaadministracion(String viaadministracion) {
        this.viaadministracion = viaadministracion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getDescripcionatc() {
        return descripcionatc;
    }

    public void setDescripcionatc(String descripcionatc) {
        this.descripcionatc = descripcionatc;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public String getCantidadconcentrada() {
        return cantidadconcentrada;
    }

    public void setCantidadconcentrada(String cantidadconcentrada) {
        this.cantidadconcentrada = cantidadconcentrada;
    }

    public String getUnidadreferencia() {
        return unidadreferencia;
    }

    public void setUnidadreferencia(String unidadreferencia) {
        this.unidadreferencia = unidadreferencia;
    }

    public String getFormafarmaceutica() {
        return formafarmaceutica;
    }

    public void setFormafarmaceutica(String formafarmaceutica) {
        this.formafarmaceutica = formafarmaceutica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(String embalaje) {
        this.embalaje = embalaje;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public int getCantiadAvisar() {
        return cantiadAvisar;
    }

    public void setCantiadAvisar(int cantiadAvisar) {
        this.cantiadAvisar = cantiadAvisar;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstadocum() {
        return estadocum;
    }

    public void setEstadocum(String estadocum) {
        this.estadocum = estadocum;
    }

    public String getEstadoregistro() {
        return estadoregistro;
    }

    public void setEstadoregistro(String estadoregistro) {
        this.estadoregistro = estadoregistro;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getTiporol() {
        return tiporol;
    }

    public void setTiporol(String tiporol) {
        this.tiporol = tiporol;
    }

    public String getVersionBDinvima() {
        return versionBDinvima;
    }

    public void setVersionBDinvima(String versionBDinvima) {
        this.versionBDinvima = versionBDinvima;
    }

    public DispensarDTO getDispensarDTO() {
        return dispensarDTO;
    }

    public void setDispensarDTO(DispensarDTO dispensarDTO) {
        this.dispensarDTO = dispensarDTO;
    }

}
