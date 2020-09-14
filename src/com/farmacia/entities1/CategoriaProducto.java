/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

/**
 *
 * @author cizaguirre
 */
public class CategoriaProducto {
      private Long id_categoria;
    private String nombrecategoria;

    public CategoriaProducto(Long id_categoria, String nombrecategoria) {
        this.id_categoria = id_categoria;
        this.nombrecategoria = nombrecategoria;
    }

    public CategoriaProducto() {
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombrecategoria() {
        return nombrecategoria;
    }

    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }

 
    
    
    
    
    
    
}
