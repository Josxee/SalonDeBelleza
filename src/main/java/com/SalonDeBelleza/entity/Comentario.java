package com.SalonDeBelleza.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "comentarios")
public class Comentario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "ID_comentario")
    private Long idComentario;
    
    @Column(name = "ID_usuario")
    private Integer idUsuario;
    
    @Column(name = "Fecha_comentario")
    private String fechaComentario;
    
    @Column(name = "Titulo_comentario")
    private String tituloComentario;
    
    @Column(name = "Descripcion_comentario")
    private String descripcionComentario;
    
    @Column(name = "Calificacion_comentario")
    private Integer calificacionComentario;
}
