package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.Usuario;
import java.util.List;

public interface IUsuarioService {
    public List<Usuario> getAllUsuarios();
    public Usuario getUsuarioByID(long id);
    public void saveUsuario(Usuario usuario);
    public void delete(long id);
}
