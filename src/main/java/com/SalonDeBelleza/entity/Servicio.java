package com.SalonDeBelleza.entity;

import jakarta.persistence.Column;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_servicio")
    private int idServicio;

    @Column(name = "Nombre_servicio")
    private String nombreServicio;

    @Column(name = "Precio_servicio")
    private double precioServicio;

    @Column(name = "Descripcion_servicio")
    private String descripcionServicio;

    @ManyToOne
    @JoinColumn(name = "ID_administrador")
    private Administrador administrador;

    @ManyToOne
    @JoinColumn(name = "ID_usuario")
    private Usuario usuario;
}
