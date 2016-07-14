

package com.managerwarehouse.model.producto;


public class DispensarDTO {

    private int idDispensar;
    private String lugar;
    private String lote;
    private int Cantidad_Almacen;
    private int producto;
    

    public DispensarDTO() {
    }

    public DispensarDTO( String lugar, String lote, int Cantidad_Almacen, int producto) {
        
        this.lugar = lugar;
        this.lote = lote;
        this.Cantidad_Almacen = Cantidad_Almacen;
        this.producto = producto;
    }
    

    public int getIdDispensar() {
        return idDispensar;
    }

    public void setIdDispensar(int idDispensar) {
        this.idDispensar = idDispensar;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getCantidad_Almacen() {
        return Cantidad_Almacen;
    }

    public void setCantidad_Almacen(int Cantidad_Almacen) {
        this.Cantidad_Almacen = Cantidad_Almacen;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }
 

    
    
}
