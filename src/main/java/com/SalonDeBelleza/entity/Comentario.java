package com.SalonDeBelleza.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
