package com.SalonDeBelleza.repository;

import com.SalonDeBelleza.entity.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Long>{
    
}
