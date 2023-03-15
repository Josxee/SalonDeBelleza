package com.SalonDeBelleza.repository;

import com.SalonDeBelleza.entity.CompraProducto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraProductoRepository extends CrudRepository<CompraProducto, Long>{
    
}
