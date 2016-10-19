package com.managerwarehouse.model.contabilidad.activofijo;

import com.managerwarehouse.util.database;

public class SubCategoriaAFDao extends database {

    public boolean CRUD_CATEGORIA(Object[] key) {
        return insertSP("CRUD_SUBCATEGORIA_ACTIVOS_FIJOS", key);
    }

    public Object[][] LISTAR_CATEGORIAS() {
        Object[][] rs = select("subcategorias_af", "descripcion", null);
        if (rs.length > 0) {
            return rs;
        }
        return null;
    }
    
    public SubcategoriaAF SUBCATEGORIA(Object key) {
        SubcategoriaAF saf  = null;
        Object[][] rs = select("subcategorias_af", "itemsubcat, descripcion, prefijo, categoria",
                "descripcion = '"+key+"'");
        if (rs.length > 0) {
            saf = new SubcategoriaAF();
            saf.setItemsubcategoria(Integer.parseInt(rs[0][0].toString()));
            saf.setDescripcion(rs[0][1].toString());
            saf.setPrefijo(rs[0][2].toString());
            saf.setCategoria(new CategoriaDao().CATEGORIA(rs[0][3]));
        }
        return saf;
    }
    
}
