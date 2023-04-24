package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.Producto;
import com.SalonDeBelleza.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Producto getProductoByID(long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void delete(long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> findByNombreProducto(String nombreProducto) {
        if (nombreProducto != null) {
            return (List<Producto>) productoRepository.findByNombreProducto(nombreProducto);
        }
        return (List<Producto>) productoRepository.findAll();
    }

}
