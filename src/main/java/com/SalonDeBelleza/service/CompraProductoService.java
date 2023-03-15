package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.CompraProducto;
import com.SalonDeBelleza.repository.CompraProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraProductoService implements ICompraProductoService {

    @Autowired
    private CompraProductoRepository compraProductoRepository;

    @Override
    public List<CompraProducto> getAllCompraProductos() {
        return (List<CompraProducto>) compraProductoRepository.findAll();
    }

    @Override
    public CompraProducto getCompraProductoByID(long id) {
        return compraProductoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCompraProducto(CompraProducto compraProducto) {
        compraProductoRepository.save(compraProducto);
    }

    @Override
    public void delete(long id) {
        compraProductoRepository.deleteById(id);
    }

}
