/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.conponentes;

import static com.farmacia.conponentes.Tablas.model;
import com.farmacia.entities1.CategoriaProducto;
import com.farmacia.entities1.EnvaseProducto;
import com.farmacia.entities1.Estado_usuario;
import com.farmacia.entities1.Genero;
import com.farmacia.entities1.Iva;
import com.farmacia.entities1.Laboratorio;
import com.farmacia.entities1.MarcaProducto;
import com.farmacia.entities1.MedidaProducto;
import com.farmacia.entities1.Precios;
import com.farmacia.entities1.Rol_U;
import com.farmacia.entities1.TipoProducto;
import com.farmacia.entities1.fc_localidad_guayas;
import com.farmacia.fecha.Fecha;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Formulario {

    SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");

    public String getFecha(JDateChooser jd) {
        if (jd.getDate() != null) {
            return Formato.format(jd.getDate());
        } else {
            return null;
        }
    }
    public static DefaultComboBoxModel listarComboTipoPro(ArrayList<TipoProducto> lista) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] arreglo = arreglo1(lista);
        System.out.println(lista.size() + " tam " + arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            model.addElement(arreglo[i]);
        }
        return model;

    }

    private static Object[] arreglo1(ArrayList<TipoProducto> lista) {
        Object[] arreglo = new Object[lista.size() + 1];
        arreglo[0] = "Elija una opcion...";
        for (int i = 0; i < lista.size(); i++) {
            arreglo[(i + 1)] = lista.get(i).getNombreTipo();
        }
        return arreglo;

    }

    public static DefaultComboBoxModel listarComboMedidaPro(ArrayList<MedidaProducto> lista) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] arreglo = arreglo2(lista);
        System.out.println(lista.size() + " tam " + arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            model.addElement(arreglo[i]);
        }
        return model;

    }

    private static Object[] arreglo2(ArrayList<MedidaProducto> lista) {
        Object[] arreglo = new Object[lista.size() + 1];
        arreglo[0] = "Elija una opcion...";
        for (int i = 0; i < lista.size(); i++) {
            arreglo[(i + 1)] = lista.get(i).getNombre_medida();
        }
        return arreglo;

    }

    public static DefaultComboBoxModel listarComboEnvasePro(ArrayList<EnvaseProducto> lista) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] arreglo = arreglo3(lista);
        System.out.println(lista.size() + " tam " + arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            model.addElement(arreglo[i]);
        }
        return model;
    }

    private static Object[] arreglo3(ArrayList<EnvaseProducto> lista) {
        Object[] arreglo = new Object[lista.size() + 1];
        arreglo[0] = "Elija una opcion...";
        for (int i = 0; i < lista.size(); i++) {
            arreglo[(i + 1)] = lista.get(i).getNombreEnvase();
        }
        return arreglo;

    }

    public static DefaultComboBoxModel listarComboMarcaPro(ArrayList<MarcaProducto> lista) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] arreglo = arreglo4(lista);
        System.out.println(lista.size() + " tam " + arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            model.addElement(arreglo[i]);
        }
        return model;
    }

    private static Object[] arreglo4(ArrayList<MarcaProducto> lista) {
        Object[] arreglo = new Object[lista.size() + 1];
        arreglo[0] = "Elija una opcion...";
        for (int i = 0; i < lista.size(); i++) {
            arreglo[(i + 1)] = lista.get(i).getNombreMarca();
        }
        return arreglo;

    }
    
    
     public static DefaultComboBoxModel listarComboCategoriaPro(ArrayList<CategoriaProducto> lista) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] arreglo = arreglo5(lista);
        System.out.println(lista.size() + " tam " + arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            model.addElement(arreglo[i]);
        }
        return model;
    }

    private static Object[] arreglo5(ArrayList<CategoriaProducto> lista) {
        Object[] arreglo = new Object[lista.size() + 1];
        arreglo[0] = "Elija una opcion...";
        for (int i = 0; i < lista.size(); i++) {
            arreglo[(i + 1)] = lista.get(i).getNombrecategoria();
        }
        return arreglo;

    }
     public static DefaultComboBoxModel listarComboPrecioCompraPro(ArrayList<Precios> lista) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] arreglo = arregloCompra(lista);
        System.out.println(lista.size() + " tam " + arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            model.addElement(arreglo[i]);
        }
        return model;

    }

    private static Object[] arregloCompra(ArrayList<Precios> lista) {
        Object[] arreglo = new Object[lista.size() + 1];
        arreglo[0] = "Elija una opcion...";
        for (int i = 0; i < lista.size(); i++) {
            arreglo[(i + 1)] = ""+lista.get(i).getPrecio_compra();
        }
        return arreglo;

    }
    //listarComboPrecioVentaPro
    public static DefaultComboBoxModel listarComboPrecioVentaPro(ArrayList<Precios> lista) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] arreglo = arregloVenta(lista);
        System.out.println(lista.size() + " tam " + arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            model.addElement(arreglo[i]);
        }
        return model;

    }

    private static Object[] arregloVenta(ArrayList<Precios> lista) {
        Object[] arreglo = new Object[lista.size() + 1];
        arreglo[0] = "Elija una opcion...";
        for (int i = 0; i < lista.size(); i++) {
            arreglo[(i + 1)] = lista.get(i).getPrecio_venta();
        }
        return arreglo;

    }
    public static DefaultComboBoxModel listarComboEstadoPrecios(ArrayList<Precios> lista) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] arreglo = arregloEstadoPro(lista);
        
        for (int i = 0; i < arreglo.length; i++) {
           if("A".equals(lista.get(i).getEstado())){
           model.setSelectedItem("ACTIVO");
           }
           if("I".equals(lista.get(i).getEstado())){
           model.setSelectedItem(2);
           }
        }
        return model;

    }

    private static Object[] arregloEstadoPro(ArrayList<Precios> lista) {
        Object[] arreglo = new Object[lista.size()];
        //arreglo[0] = "Elija una opcion...";
        for (int i = 0; i < lista.size(); i++) {
            arreglo[(i)] = lista.get(i).getEstado();
        }
        return arreglo;

    }
        public static DefaultComboBoxModel listarComboTipoLocalidad(ArrayList<fc_localidad_guayas> lista) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] arreglo = arreglo10(lista);
        System.out.println(lista.size() + " tam " + arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            model.addElement(arreglo[i]);
        }
        return model;

    }

    private static Object[] arreglo10(ArrayList<fc_localidad_guayas> lista) {
        Object[] arreglo = new Object[lista.size() + 1];
        arreglo[0] = "Elija una opcion...";
        for (int i = 0; i < lista.size(); i++) {
            arreglo[(i + 1)] = lista.get(i).getLocalidad();
        }
        return arreglo;

    }
    
    private static Object[] arregloGenero(ArrayList<Genero> lista) {
        Object[] arreglo = new Object[lista.size() + 1];
        arreglo[0] = "Elija una opcion...";
        for (int i = 0; i < lista.size(); i++) {
            arreglo[(i + 1)] = lista.get(i).getGenero();
        }
        return arreglo;

    }
    
    public static DefaultComboBoxModel listarComboGenero(ArrayList<Genero> lista) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] arreglo = arregloGenero(lista);
        System.out.println(lista.size() + " tam " + arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            model.addElement(arreglo[i]);
        }
        return model;

    }
    
    private static Object[] arregloRol(ArrayList<Rol_U> lista) {
        Object[] arreglo = new Object[lista.size() + 1];
        arreglo[0] = "Elija una opcion...";
        for (int i = 0; i < lista.size(); i++) {
            arreglo[(i + 1)] = lista.get(i).getCargo();
        }
        return arreglo;

    }
    
    public static DefaultComboBoxModel listarComboRol(ArrayList<Rol_U> lista) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] arreglo = arregloRol(lista);
        System.out.println(lista.size() + " tam " + arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            model.addElement(arreglo[i]);
        }
        return model;

    }
    
    private static Object[] arregloEstado(ArrayList<Estado_usuario> lista) {
        Object[] arreglo = new Object[lista.size() + 1];
        arreglo[0] = "Elija una opcion...";
        for (int i = 0; i < lista.size(); i++) {
            arreglo[(i + 1)] = lista.get(i).getEstado();
        }
        return arreglo;

    }
    
    public static DefaultComboBoxModel listarComboEstado(ArrayList<Estado_usuario> lista) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] arreglo = arregloEstado(lista);
        System.out.println(lista.size() + " tam " + arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            model.addElement(arreglo[i]);
        }
        return model;

    }
    
    public static DefaultComboBoxModel listarComboIva(ArrayList<Iva> lista) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] arreglo = arreglo11(lista);
        System.out.println(lista.size() + " tam " + arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            model.addElement(arreglo[i]);
        }
        return model;

    }
    private static Object[] arreglo11(ArrayList<Iva> lista) {
        Object[] arreglo = new Object[lista.size() + 2];
        arreglo[0] = "Elija una opcion...";
        arreglo[1] = "NO";
        for (int i = 0; i < lista.size(); i++) {
            arreglo[(i + 2)] = lista.get(i).getIva();
        }
        return arreglo;

    }
}
