package com.farmacia.join_entidades;


public class ListarKardex {
    
    //13 variables
    Long id_kardex;
    Long id_producto;
    String nombre_Producto;
    String descripcion;
    String tipo;
    String presentacion;
    Long cantidad;
    String iva;
    Long id_precio;
    Double precio_compra;
    Double precio_venta;
    Double total;
    Long compra;
    Long venta;

    public ListarKardex() {
    }

    public ListarKardex(Long id_kardex, Long id_producto, String nombre_Producto, String descripcion, String tipo, String presentacion, Long cantidad, String iva,Long id_precio, Double precio_compra, Double precio_venta, Double total, Long compra, Long venta) {
        this.id_kardex = id_kardex;
        this.id_producto = id_producto;
        this.nombre_Producto = nombre_Producto;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
        this.iva = iva;
        this.id_precio = id_precio;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
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

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
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
