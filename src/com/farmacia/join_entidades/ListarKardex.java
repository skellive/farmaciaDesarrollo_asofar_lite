package com.farmacia.join_entidades;


public class ListarKardex {
    
    //13 variables
    Long id_kardex;
    Long id_producto;
    String codigo_barra;
    String nombre_Producto;
    String descripcion;
    String tipo;
    String presentacion;
    Long unidad_aceptada;
    Long cantidad;
    Long cantidad_unidad;
    String iva;
    Long id_precio;
    Double precio_compra;
    Double precio_venta;
    Double precio_venta_unidad;
    Double total;
    Long compra;
    Long venta;

    public ListarKardex() {
    }

    public ListarKardex(Long id_kardex, Long id_producto,String codigo_barra ,String nombre_Producto, String descripcion, String tipo, String presentacion,Long unidad_aceptada ,Long cantidad, Long cantidad_unidad, String iva,Long id_precio, Double precio_compra, Double precio_venta,Double precio_venta_unidad,Double total, Long compra, Long venta) {
        this.id_kardex = id_kardex;
        this.id_producto = id_producto;//codigo_barra
        this.codigo_barra = codigo_barra;
        this.nombre_Producto = nombre_Producto;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.presentacion = presentacion;
        this.unidad_aceptada = unidad_aceptada;
        this.cantidad = cantidad;
        this.cantidad_unidad = cantidad_unidad;
        this.iva = iva;
        this.id_precio = id_precio;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.precio_venta_unidad = precio_venta_unidad;
        this.total = total;
        this.compra = compra;
        this.venta = venta;
    }

    public Long getId_kardex() {
        return id_kardex;
    }

    public void setId_kardex(Long id_kardex) {
        this.id_kardex = id_kardex;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public Long getId_precio() {
        return id_precio;
    }

    public void setId_precio(Long id_precio) {
        this.id_precio = id_precio;
    }

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Double getPrecio_venta_unidad() {
        return precio_venta_unidad;
    }

    public void setPrecio_venta_unidad(Double precio_venta_unidad) {
        this.precio_venta_unidad = precio_venta_unidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getCompra() {
        return compra;
    }

    public void setCompra(Long compra) {
        this.compra = compra;
    }

    public Long getVenta() {
        return venta;
    }

    public void setVenta(Long venta) {
        this.venta = venta;
    }

    
}
