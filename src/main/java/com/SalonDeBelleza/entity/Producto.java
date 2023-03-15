package com.SalonDeBelleza.entity;

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
    
    @Id //Indica el atributo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el valor se generará automaticamente
    private long idProducto;

    private String nombreProducto;
    private String precioProducto;
    private String descripcionProducto;
    private int idAdmin;
    private int idUsuario;
    
    @ManyToOne
    @JoinColumn(name = "ID_administrador")
    private Administrador administrador;
    
    @ManyToOne
    @JoinColumn(name = "ID_usuario")
    private Usuario usuario;
}
