/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

import java.math.BigDecimal;

/**
 *
 * @author alumno
 */
public class Detalle_ventas {

    private Long id_detalle_venta;
    private Long id_cabecera_venta;
    private Long codigo_barras;
    private Long id_control;
    private Long id_marca;
    private String marca;
    private Long id_tipo;
    private String tipo;
    private Long id_producto;
    private String nombre_producto;
    private Long id_presentacion;
    private String presentacion;    
    private Long cantidad;
    private Long cantidad_unidad;
    private BigDecimal precio;
    private BigDecimal precio_compra;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal descuento;
    private BigDecimal total;
    private int empaque;

    public Detalle_ventas() {
    }   

    public Detalle_ventas(Long id_detalle_venta, Long id_cabecera_venta, Long codigo_barras, Long id_control, Long id_marca, String marca, Long id_tipo, String tipo, Long id_producto, String nombre_producto, Long id_presentacion, String presentacion, Long cantidad, Long cantidad_unidad, BigDecimal precio, BigDecimal precio_compra, BigDecimal subtotal, BigDecimal iva, BigDecimal descuento, BigDecimal total, int empaque) {
        this.id_detalle_venta = id_detalle_venta;
        this.id_cabecera_venta = id_cabecera_venta;
        this.codigo_barras = codigo_barras;
        this.id_control = id_control;
        this.id_marca = id_marca;
        this.marca = marca;
        this.id_tipo = id_tipo;
        this.tipo = tipo;
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.id_presentacion = id_presentacion;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
        this.cantidad_unidad = cantidad_unidad;
        this.precio = precio;
        this.precio_compra = precio_compra;
        this.subtotal = subtotal;
        this.iva = iva;
        this.descuento = descuento;
        this.total = total;
        this.empaque = empaque;
    }

    public Long getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(Long id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public Long getId_cabecera_venta() {
        return id_cabecera_venta;
    }

    public void setId_cabecera_venta(Long id_cabecera_venta) {
        this.id_cabecera_venta = id_cabecera_venta;
    }

    public Long getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(Long codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public Long getId_control() {
        return id_control;
    }

    public void setId_control(Long id_control) {
        this.id_control = id_control;
    }

    public Long getId_marca() {
        return id_marca;
    }

    public void setId_marca(Long id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Long getId_presentacion() {
        return id_presentacion;
    }

    public void setId_presentacion(Long id_presentacion) {
        this.id_presentacion = id_presentacion;
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

    public Long getCantidad_unidad() {
        return cantidad_unidad;
    }

    public void setCantidad_unidad(Long cantidad_unidad) {
        this.cantidad_unidad = cantidad_unidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(BigDecimal precio_compra) {
        this.precio_compra = precio_compra;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getEmpaque() {
        return empaque;
    }

    public void setEmpaque(int empaque) {
        this.empaque = empaque;
    }
    
}
