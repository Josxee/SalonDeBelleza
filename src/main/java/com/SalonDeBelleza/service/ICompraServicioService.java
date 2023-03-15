package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.CompraServicio;
import java.util.List;

public interface ICompraServicioService {
    public List<CompraServicio> getAllCompraServicios();
    public CompraServicio getCompraServicioByID(long id);
    public void saveCompraServicio(CompraServicio compraServicio);
    public void delete(long id);
}
