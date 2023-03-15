package com.SalonDeBelleza.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data //lombok genera automáticamente los métodos
@Entity
@Table(name = "administradores")
public class Administrador implements Serializable {

    @Id //Indica el atributo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el valor se generará automáticamente
    @Column(name = "ID_administrador")
    private long idAdmin;

    @Column(name = "Nombre_administrador")
    private String nombreAdmin;

    @Column(name = "Email_administrador")
    private String emailAdmin;

    @Column(name = "Password_administrador")
    private String contraAdmin;

}
