package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.Administrador;
import com.SalonDeBelleza.repository.AdministradorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService implements IAdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public List<Administrador> getAllAdmins() {
        return (List<Administrador>) administradorRepository.findAll();
    }

    @Override
    public Administrador getAdminByID(long id) {
        return administradorRepository.findById(id).orElse(null);
    }

    @Override
    public void saveAdmin(Administrador administrador) {
        administradorRepository.save(administrador);
    }

    @Override
    public void delete(long id) {
        administradorRepository.deleteById(id);
    }

}
