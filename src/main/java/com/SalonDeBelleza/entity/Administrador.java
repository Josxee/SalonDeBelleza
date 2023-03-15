package com.SalonDeBelleza.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data //lombok genera automaticamente los metodos
@Entity
@Table(name = "administradores")
public class Administrador implements Serializable {

    @Id //Indica el atributo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el valor se generará automaticamente
    private long idAdmin;

    private String nombreAdmin;
    private String emailAdmin;
    private String contraAdmin;

}
