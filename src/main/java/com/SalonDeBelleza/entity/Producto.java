package com.SalonDeBelleza.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_producto")
    private int idProducto;

    @Column(name = "Nombre_producto")
    private String nombreProducto;

    @Column(name = "Precio_producto")
    private double precioProducto;

    @Column(name = "Descripcion_producto")
    private String descripcionProducto;

    @ManyToOne
    @JoinColumn(name = "ID_administrador")
    private Administrador administrador;

    @ManyToOne
    @JoinColumn(name = "ID_usuario")
    private Usuario usuario;
}
