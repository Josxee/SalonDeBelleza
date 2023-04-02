package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.Comentario;
import java.util.List;

public interface IComentarioService {

    public List<Comentario> getAllComentarios();

    public Comentario getComentarioByID(long id);

    public void saveComentario(Comentario comentario);

    public void delete(long id);
}
