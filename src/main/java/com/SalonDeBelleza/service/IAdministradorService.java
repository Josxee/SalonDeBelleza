package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.Administrador;
import java.util.List;

public interface IAdministradorService {
    public List<Administrador> getAllAdmins();
    public Administrador getAdminByID(long id);
    public void saveAdmin(Administrador administrador);
    public void delete(long id);
}
