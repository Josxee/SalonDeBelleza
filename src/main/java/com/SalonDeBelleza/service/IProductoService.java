package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.Producto;
import java.util.List;

public interface IProductoService {
    public List<Producto> getAllProductos();
    public Producto getProductoByID(long id);
    public void saveProducto(Producto producto);
    public void delete(long id);
    
    public Producto getArticulo(Producto articulo); 
    
    public List<Producto> findByNombreProducto (String nombreProducto);
}
