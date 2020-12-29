/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.validaciones;

import com.farmacia.dao.CRUD;
import com.farmacia.join_entidades.JoinListarDetalleNotaPedido;
import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.join_entidades.joinProductoParaNotaPedido;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author alumno
 */
public class ComponentesFaltantes {

    joinProductoDetallesFaltantes objeto = null;

    public static String validarListaFaltantes(JTable tabla, String id_producto) {
        String o, msg = null;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            o = (String) tabla.getValueAt(i, 0);
            if (o.equals(id_producto)) {
                msg = "El producto ya fue Seleccionado!";
                break;
            }
        }
        return msg;
    }

    public static String validarListaFaltantesNota(ArrayList<joinProductoParaNotaPedido> lista1, String id_precio) {
        String o, msg = null;
        for (int i = 0; i < lista1.size(); i++) {

            o = lista1.get(i).getId_precios().toString();
            if (o.equals(id_precio)) {
                msg = "El producto ya fue Seleccionado!!!";
                break;
            }

        }

        return msg;
    }

    public static String validarProductoParaAgregar(ArrayList<joinProductoParaNotaPedido> Array2, String id_producto) {
        //JoinListarDetalleNotaPedido
        String o, msg = null;
        Integer cantActual = null;
        for (int i = 0; i < Array2.size(); i++) {
            o = Array2.get(i).getId_producto().toString();
            System.out.println(o + " o");
            if (o.equals(id_producto)) {
                 //cantActual = Array2.get(i).getCantidad();
                //Array2.get(i).setCantidad(cantidad+cantActual);
                msg = "El producto ya esta agregado";
                break;
            }
        }
        return msg;
    }
    
    public static String validarProductoParaAgregar2(ArrayList<JoinListarDetalleNotaPedido> Array2, String id_producto,int num) {
        //JoinListarDetalleNotaPedido
        String o, msg = null;
        Integer cantActual = null;
        if(num==1){//cantidad
        for (int i = 0; i < Array2.size(); i++) {
            o = Array2.get(i).getId_producto().toString();
            cantActual = Array2.get(i).getCantidad();
            System.out.println(o + " o");
            if (o.equals(id_producto) && cantActual>0) {
                 //cantActual = Array2.get(i).getCantidad();
                //Array2.get(i).setCantidad(cantidad+cantActual);
                msg = "El producto ya esta agregado";
                break;
            }
        }    
        }else{//unidad
        for (int i = 0; i < Array2.size(); i++) {
            o = Array2.get(i).getId_producto().toString();
            cantActual = Array2.get(i).getUnidad();
            System.out.println(o + " o");
            if (o.equals(id_producto) && cantActual>0) {
                 //cantActual = Array2.get(i).getCantidad();
                //Array2.get(i).setCantidad(cantidad+cantActual);
                msg = "El producto ya esta agregado";
                break;
            }
        }    
        }
        
        return msg;
    }

    public static String validarListaCompras(JTable tabla, String id_producto) {
        String o, msg = null;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            o = (String) tabla.getValueAt(i, 0);

            System.out.println((i + 1) + " prueba " + o + "   " + tabla.getRowCount());
            if (o.equals(id_producto)) {
                msg = "El producto ya fue Seleccionado!";
                break;
            }

        }

        return msg;
    }

}
