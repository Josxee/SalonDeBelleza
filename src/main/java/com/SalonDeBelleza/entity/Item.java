package com.SalonDeBelleza.entity;

import lombok.Data;

@Data //lombok genera automáticamente los métodos
public class Item extends Producto {

    private int cantidad;
    
    public Item() {
    }
    
    public Item(Producto producto){
        super.setIdProducto(producto.getIdProducto());
        super.setNombreProducto(producto.getNombreProducto());
        super.setDescripcionProducto(producto.getDescripcionProducto());
        super.setImagenProducto(producto.getImagenProducto());
        super.setPrecioProducto(producto.getPrecioProducto());
        super.setStock(producto.getStock());
        this.cantidad = 0;
    }
}
