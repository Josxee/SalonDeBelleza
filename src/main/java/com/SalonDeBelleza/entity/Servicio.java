package com.SalonDeBelleza.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
