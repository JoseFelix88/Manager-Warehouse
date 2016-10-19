package com.managerwarehouse.model.contabilidad.activofijo;

import com.managerwarehouse.util.database;

public class CategoriaDao extends database {

    public boolean CRUD_CATEGORIA(Object[] key) {
        return insertSP("CRUD_CATEGORIA_ACTIVOS_FIJOS", key);
    }

    public Object[][] LISTAR_CATEGORIAS() {
        Object[][] rs = select("categorias_af", "descripcion", null);
        if (rs.length > 0) {
            return rs;
        }
        return null;
    }
    
    public Categoria CATEGORIA(Object key) {
        Categoria c = null;
        Object[][] rs = select("categorias", "itemcategoria, descripcion, prefijo, codigopuc", "descripcion = '"+key+"'");
        if (rs.length > 0) {
            c = new Categoria();
            c.setItemcategoria(Integer.parseInt(rs[0][0].toString()));
            c.setDescripcion(rs[0][1].toString());
            c.setPrefijo(rs[0][2].toString());
            c.setCodigoPuc(rs[0][3].toString());
        }
        return c;
    }
    
        public Object[][] LISTAR_SUBCATEGORIAS(String key) {
        Object[][] rs = select("categorias_af, subcategorias_af", "subcategorias_af.descripcion", 
                "categorias_af.itemcategoria = subcategorias_af.categoria and "
                        + "categorias_af.descripcion = '"+key+"'");
        if (rs.length > 0) {
            return rs;
        }
        return null;
    }
}
