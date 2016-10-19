package com.managerwarehouse.model.contabilidad.activofijo;

public class SubcategoriaAF {
    
    private int itemsubcategoria;
    private String descripcion;
    private Categoria categoria;
    private String prefijo;

    public int getItemsubcategoria() {
        return itemsubcategoria;
    }

    public void setItemsubcategoria(int itemsubcategoria) {
        this.itemsubcategoria = itemsubcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }
    
    
}
