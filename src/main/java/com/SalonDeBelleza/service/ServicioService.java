package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.Servicio;
import com.SalonDeBelleza.repository.ServicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioService implements IServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> getAllServicios() {
        return (List<Servicio>) servicioRepository.findAll();
    }

    @Override
    public Servicio getServicioByID(long id) {
        return servicioRepository.findById(id).orElse(null);
    }

    @Override
    public void saveServicio(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Override
    public void delete(long id) {
        servicioRepository.deleteById(id);
    }

}
