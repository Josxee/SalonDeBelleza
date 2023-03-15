package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.CompraProducto;
import java.util.List;

public interface ICompraProductoService {
    public List<CompraProducto> getAllCompraProductos();
    public CompraProducto getCompraProductoByID(long id);
    public void saveCompraProducto(CompraProducto compraProducto);
    public void delete(long id);
}
