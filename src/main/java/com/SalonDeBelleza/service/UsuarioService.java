package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.Usuario;
import com.SalonDeBelleza.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioByID(long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }

}
