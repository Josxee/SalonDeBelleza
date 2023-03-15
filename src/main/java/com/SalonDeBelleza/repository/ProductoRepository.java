package com.SalonDeBelleza.repository;

import com.SalonDeBelleza.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{
    
}
