package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.CompraServicio;
import com.SalonDeBelleza.repository.CompraServicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServicioService implements ICompraServicioService {

    @Autowired
    private CompraServicioRepository compraServicioRepository;

    @Override
    public List<CompraServicio> getAllCompraServicios() {
        return (List<CompraServicio>) compraServicioRepository.findAll();
    }

    @Override
    public CompraServicio getCompraServicioByID(long id) {
        return compraServicioRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCompraServicio(CompraServicio compraServicio) {
        compraServicioRepository.save(compraServicio);
    }

    @Override
    public void delete(long id) {
        compraServicioRepository.deleteById(id);
    }

}
