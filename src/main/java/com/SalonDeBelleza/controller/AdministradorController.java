package com.SalonDeBelleza.controller;

import com.SalonDeBelleza.entity.Administrador;
import com.SalonDeBelleza.service.IAdministradorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdministradorController {
    
    @Autowired
    private IAdministradorService administradorService;
    
    @GetMapping("/administradores")
    public String administradores(Model model) {
        List<Administrador> listaAdministradores = administradorService.getAllAdmins();
        model.addAttribute("administradores", listaAdministradores);
        return "administradores";
    }

    @GetMapping("/adminN")
    public String crearAdmin(Model model) {
        model.addAttribute("admins", new Administrador());
        return "crearAdmin";
    }

    @PostMapping("/save")
    public String guardarAdmin(@ModelAttribute Administrador administrador) {
        administradorService.saveAdmin(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/delete/{idAdmin}")
    public String eliminarAdmin(@PathVariable("idAdmin") Long idAdmin) {
        administradorService.delete(idAdmin);
        return "redirect:/administradores";
    }

    @GetMapping("/editAdmin/{idAdmin}")
    public String editarAdmin(@PathVariable("idAdmin") Long idAdmin, Model model) {
        Administrador administrador = administradorService.getAdminByID(idAdmin);
        model.addAttribute("admins", administrador);
        return "crearAdmin";
    }
}
