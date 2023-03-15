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

@Data
@Entity
@Table(name = "compras_de_productos")
public class CompraProducto implements Serializable{
    
    @Id //Indica el atributo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el valor se generará automaticamente
    private long idCompraProducto;

    private String fechaCompraProducto;
    private int idUsuario;
    private int idServicio;
    
    @ManyToOne
    @JoinColumn(name = "ID_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_servicio")
    private Servicio servicio;
}
