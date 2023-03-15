package com.SalonDeBelleza.controller;

import com.SalonDeBelleza.entity.Administrador;
import com.SalonDeBelleza.service.IAdministradorService;
import com.SalonDeBelleza.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalonController {

    @Autowired
    private IAdministradorService administradorService;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/administradores")
    public String administradores(Model model) {
        List<Administrador> listaAdministradores = administradorService.getAllAdmins();
        model.addAttribute("administradores", listaAdministradores);
        return "administradores";
    }
}
