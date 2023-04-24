package com.SalonDeBelleza.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data //lombok genera automáticamente los métodos
@Entity
@Table(name = "administradores")
public class Administrador implements Serializable {

    @Id //Indica el atributo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el valor se generará automáticamente
    @Column(name = "ID_administrador")
    private Long idAdmin;

    @Column(name = "Nombre_administrador")
    private String nombreAdmin;

    @Column(name = "Email_administrador")
    private String emailAdmin;

    @Column(name = "Password_administrador")
    private String contraAdmin;

}
