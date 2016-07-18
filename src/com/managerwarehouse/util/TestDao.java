/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managerwarehouse.util;

import com.managerwarehouse.model.factura_de_compra.Orden_de_Compra;
import com.managerwarehouse.model.factura_de_compra.Orden_de_CompraDAO;
import com.managerwarehouse.model.inventario.Lotealmacenado;
import com.managerwarehouse.model.producto.ProductoDAO;
import com.managerwarehouse.model.salida.DetalleSalida;
import com.managerwarehouse.model.salida.DetalleSalidaDAO;
import com.managerwarehouse.model.salida.Salida;
import com.managerwarehouse.model.salida.SalidaDAO;
import com.managerwarehouse.model.usuario_system.EmpleadoDAO;
import com.managerwarehouse.model.usuario_system.EmpleadoDTO;
import com.managerwarehouse.util.notificaciones.NoficacionesProductos;
import java.sql.Array;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author beatriz elena
 */
public class TestDao {

    public static void main(String args[]) {
        /*Orden_de_CompraDAO dAO = new Orden_de_CompraDAO();
        
         for (Orden_de_Compra listado : dAO.Listar_Detalle_Orden(4)) {
         System.out.println(listado.getProveedor().getRazonSocial());
         }*/

        ProductoDAO producto = new ProductoDAO();
        Lotealmacenado lotesalmacenado = producto.leerlotealmacenado("7703145001262");
        NoficacionesProductos np = new NoficacionesProductos();
        System.out.println("F.V Producto: " + lotesalmacenado.getFecha_vencimiento());
        System.out.println(DateUtil.newDateTime());
        Edicion edicion = new Edicion();
//        edicion.mensajes(1, "");
        /* SalidaDAO dAO = new SalidaDAO();
        
         DetalleSalidaDAO dsdao = new DetalleSalidaDAO();
         Calendar c = new GregorianCalendar();
         Salida s = new Salida(1243, c.getTime(), "FARMACIA CERETE", "11555", 2, "1102819530", "123666", 1, null);
         System.out.println("Encabezado de la salida creado? "+dAO.create(s));
         DetalleSalidaDAO dsdao = new DetalleSalidaDAO();
         DetalleSalida ds = new DetalleSalida(0, 1243, "7703038010302", 943, 20, 1, "DORA OVIEDO");
         System.out.println("Detalle de la salida creado? "+dsdao.create(ds));
      
          
         for (Object[] objects : dsdao.listardetalle(1243)) {
         System.out.println("Detalle de la Salida\n"
         + "iddetallesalida: "+objects[0]+"\nCodigo: "+objects[1]+"\nProducto: "+objects[2]+"\n"
         + "Lote No: "+objects[3]+"\nCantidad: "+objects[4]+"\nOperador: "+objects[6]);
         }
        EmpleadoDAO edao = new EmpleadoDAO();
        for (EmpleadoDTO cargarOperadore : edao.cargarOperadores()) {
            System.out.println(cargarOperadore.getPassword());
        }*/

    }
}
