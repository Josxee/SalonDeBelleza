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
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "compras_de_servicios")
public class CompraServicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_compra_servicio")
    private int idCompraServicio;

    @Column(name = "Fecha_compra")
    private Date fechaCompra;

    @ManyToOne
    @JoinColumn(name = "ID_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_servicio")
    private Servicio servicio;
}
