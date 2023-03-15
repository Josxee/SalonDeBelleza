package com.SalonDeBelleza.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data //lombok genera automaticamente los metodos
@Entity
@Table(name = "servicios")
public class Servicio implements Serializable {

    @Id //Indica el atributo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el valor se generará automaticamente
    private long idServicio;

    private String nombreServicio;
    private String precioServicio;
    private String descripcionServicio;
    private int idAdmin;
    private int idUsuario;
    
    @ManyToOne
    @JoinColumn(name = "ID_administrador")
    private Administrador administrador;
    
    @ManyToOne
    @JoinColumn(name = "ID_usuario")
    private Usuario usuario;
}
