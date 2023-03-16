package com.SalonDeBelleza.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data //lombok genera automaticamente los metodos
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
    
    @Id //Indica el atributo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el valor se generará automaticamente
    @Column(name = "ID_Usuario")
    private Long idUsuario;

    @Column(name = "Nombre_usuario")
    private String nombreUsuario;
    @Column(name = "Email_usuario")
    private String emailUsuario;
    @Column(name = "Password_usuario")
    private String contraUsuario;
}
