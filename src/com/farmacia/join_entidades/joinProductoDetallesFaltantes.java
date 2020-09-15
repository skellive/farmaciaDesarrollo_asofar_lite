/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.join_entidades;

import java.math.BigDecimal;

/**
 *
 * @author josel
 */
public class joinProductoDetallesFaltantes {
    private Long id_detalle_faltantes;
    private Long id_tipo;
    private String nombre_tipo;
    private Long id_producto;
    private String nombre_producto;
    private Integer cantidad;
    private String estado;
    private Long id_marcas;
    private String marca;
    
      private Long id_categoria;
    private String nombrecategoria;
    private Long id_medida;
    private String medida;
    private Long id_envase;
    private String envase;
    private Long id_precios;
    private BigDecimal precios;
    private String iva;
    private Integer bono;
    private BigDecimal importe;
    private BigDecimal porcentaje_descuento;
    private BigDecimal valor_descuento;
    private BigDecimal PrecioBono;
    private BigDecimal Precioiva;
    
    public joinProductoDetallesFaltantes() {
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

  

    public joinProductoDetallesFaltantes(Long id_detalle_faltantes, Long id_tipo, String nombre_tipo, Long id_producto, String nombre_producto, Integer cantidad, String estado, Long id_marcas, String marca, Long id_categoria, String nombrecategoria, Long id_medida, String medida, Long id_envase, String envase, Long id_precios, BigDecimal precios, String iva, Integer bono, BigDecimal importe, BigDecimal porcentaje_descuento, BigDecimal valor_descuento, BigDecimal PrecioBono, BigDecimal Precioiva) {
        this.id_detalle_faltantes = id_detalle_faltantes;
        this.id_tipo = id_tipo;
        this.nombre_tipo = nombre_tipo;
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.cantidad = cantidad;
        this.estado = estado;
        this.id_marcas = id_marcas;
        this.marca = marca;
        this.id_categoria = id_categoria;
        this.nombrecategoria = nombrecategoria;
        this.id_medida = id_medida;
        this.medida = medida;
        this.id_envase = id_envase;
        this.envase = envase;
        this.id_precios = id_precios;
        this.precios = precios;
        this.iva = iva;
        this.bono = bono;
        this.importe = importe;
        this.porcentaje_descuento = porcentaje_descuento;
        this.valor_descuento = valor_descuento;
        this.PrecioBono = PrecioBono;
        this.Precioiva = Precioiva;
    }

    public String getNombrecategoria() {
        return nombrecategoria;
    }

    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }

   

    public Long getId_detalle_faltantes() {
        return id_detalle_faltantes;
    }

    public void setId_detalle_faltantes(Long id_detalle_faltantes) {
        this.id_detalle_faltantes = id_detalle_faltantes;
    }

    public Long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId_marcas() {
        return id_marcas;
    }

    public void setId_marcas(Long id_marcas) {
        this.id_marcas = id_marcas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Long getId_medida() {
        return id_medida;
    }

    public void setId_medida(Long id_medida) {
        this.id_medida = id_medida;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public Long getId_envase() {
        return id_envase;
    }

    public void setId_envase(Long id_envase) {
        this.id_envase = id_envase;
    }

    public String getEnvase() {
        return envase;
    }

    public void setEnvase(String envase) {
        this.envase = envase;
    }

    public Long getId_precios() {
        return id_precios;
    }

    public void setId_precios(Long id_precios) {
        this.id_precios = id_precios;
    }

    public BigDecimal getPrecios() {
        return precios;
    }

    public void setPrecios(BigDecimal precios) {
        this.precios = precios;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public Integer getBono() {
        return bono;
    }

    public void setBono(Integer bono) {
        this.bono = bono;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public BigDecimal getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(BigDecimal porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public BigDecimal getValor_descuento() {
        return valor_descuento;
    }

    public void setValor_descuento(BigDecimal valor_descuento) {
        this.valor_descuento = valor_descuento;
    }

    public BigDecimal getPrecioBono() {
        return PrecioBono;
    }

    public void setPrecioBono(BigDecimal PrecioBono) {
        this.PrecioBono = PrecioBono;
    }

    public BigDecimal getPrecioiva() {
        return Precioiva;
    }

    public void setPrecioiva(BigDecimal Precioiva) {
        this.Precioiva = Precioiva;
    }

    
}
