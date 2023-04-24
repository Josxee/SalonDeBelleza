package com.SalonDeBelleza.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data //lombok genera automaticamente los metodos
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id //Indica el atributo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el valor se generará automaticamente
    @Column(name = "ID_Usuario")
    private Long idUsuario;

    @Column(name = "Nombre_usuario")
    private String nombreUsuario;
    @Column(name = "correo")
    private String correo;
    @Column(name = "contra")
    private String contra;

    private String rol;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombreUsuario, String correo, String contra, String rol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contra = contra;
        this.rol = rol;
    }

    public List<String> getRoleList() {
        if (this.rol.length() > 0) {
            return Arrays.asList(this.rol.split(","));
        }
        return new ArrayList<>();
    }
}
