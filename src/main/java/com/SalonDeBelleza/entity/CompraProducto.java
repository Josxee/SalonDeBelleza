package com.SalonDeBelleza.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Compras_de_productos")
public class CompraProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_compra_producto")
    private int idCompraProducto;

    @Column(name = "Fecha_compra")
    private Date fechaCompra;

    @ManyToOne
    @JoinColumn(name = "ID_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_producto")
    private Producto producto;
}
