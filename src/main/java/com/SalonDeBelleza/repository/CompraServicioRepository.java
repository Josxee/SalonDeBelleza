package com.SalonDeBelleza.repository;

import com.SalonDeBelleza.entity.CompraServicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraServicioRepository extends CrudRepository<CompraServicio, Long>{
    
}
