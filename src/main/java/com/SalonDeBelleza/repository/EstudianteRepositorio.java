package com.SalonDeBelleza.repository;

import com.SalonDeBelleza.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long>{
    
}
