package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.Servicio;
import java.util.List;

public interface IServicioService {
    public List<Servicio> getAllServicios();
    public Servicio getServicioByID(long id);
    public void saveServicio(Servicio servicio);
    public void delete(long id);
}
