
package com.managerwarehouse.model.producto.controltemperatura;


public class Temperatura {
    
    private int itemtemperatura;
    private String descripcion;
    private int minimo;
    private int maximo;
    private String unidadMedida;

    public int getItemtemperatura() {
        return itemtemperatura;
    }

    public void setItemtemperatura(int itemtemperatura) {
        this.itemtemperatura = itemtemperatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    
    
    
}
