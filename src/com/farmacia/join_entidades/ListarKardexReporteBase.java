package com.farmacia.join_entidades;


public class ListarKardexReporteBase {
    
    Long id_producto;
    String codigo_barra;
    String nombre_Producto;
    String tipo;
    String presentacion;
    Long unidad_aceptada;
    Long cantidad;
    Long cantidad_unidad;

    public ListarKardexReporteBase() {
    }

    public ListarKardexReporteBase(Long id_producto, String codigo_barra, String nombre_Producto, String tipo, String presentacion, Long unidad_aceptada, Long cantidad, Long cantidad_unidad) {
        this.id_producto = id_producto;
        this.codigo_barra = codigo_barra;
        this.nombre_Producto = nombre_Producto;
        this.tipo = tipo;
        this.presentacion = presentacion;
        this.unidad_aceptada = unidad_aceptada;
        this.cantidad = cantidad;
        this.cantidad_unidad = cantidad_unidad;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public String getNombre_Producto() {
        return nombre_Producto;
    }

    public void setNombre_Producto(String nombre_Producto) {
        this.nombre_Producto = nombre_Producto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Long getUnidad_aceptada() {
        return unidad_aceptada;
    }

    public void setUnidad_aceptada(Long unidad_aceptada) {
        this.unidad_aceptada = unidad_aceptada;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getCantidad_unidad() {
        return cantidad_unidad;
    }

    public void setCantidad_unidad(Long cantidad_unidad) {
        this.cantidad_unidad = cantidad_unidad;
    }

    
}
