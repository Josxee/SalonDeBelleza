package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.Comentario;
import com.SalonDeBelleza.repository.ComentarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService implements IComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public List<Comentario> getAllComentarios() {
        return (List<Comentario>) comentarioRepository.findAll();
    }

    @Override
    public Comentario getComentarioByID(long id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    @Override
    public void saveComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    @Override
    public void delete(long id) {
        comentarioRepository.deleteById(id);
    }
}
