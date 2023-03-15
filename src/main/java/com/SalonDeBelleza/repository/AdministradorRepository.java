package com.SalonDeBelleza.repository;

import com.SalonDeBelleza.entity.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, Long>{
    
}
