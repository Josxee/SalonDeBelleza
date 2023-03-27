package com.SalonDeBelleza.controller;

import com.SalonDeBelleza.entity.Administrador;
import com.SalonDeBelleza.entity.Usuario;
import com.SalonDeBelleza.service.IAdministradorService;
import com.SalonDeBelleza.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SalonController {

    @Autowired
    private IAdministradorService administradorService;

    @Autowired
    private IUsuarioService usuarioService;

    //CRUD ADMIN
    
    @GetMapping("/productos")
    public String productos(Model model) {
        return "Productos";
    }
    
    @GetMapping("/administrador")
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
        return "redirect:/administrador";
    }

    @GetMapping("/delete/{idAdmin}")
    public String eliminarAdmin(@PathVariable("idAdmin") Long idAdmin) {
        administradorService.delete(idAdmin);
        return "redirect:/administrador";
    }

    @GetMapping("/editAdmin/{idAdmin}")
    public String editarAdmin(@PathVariable("idAdmin") Long idAdmin, Model model) {
        Administrador administrador = administradorService.getAdminByID(idAdmin);
        model.addAttribute("admins", administrador);
        return "crearAdmin";
    }

    //CRUD USER
    @GetMapping("/usuario")
    public String usuarios(Model model) {
        List<Usuario> listaUsuarios = usuarioService.getAllUsuarios();
        model.addAttribute("usuarios", listaUsuarios);
        return "usuarios";
    }

    @GetMapping("/usuarioN")
    public String crearUsuario(Model model) {
        model.addAttribute("users", new Usuario());
        return "crearUsuario";
    }

    @PostMapping("/saveUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/deleteUsuario/{idUsuario}")
    public String eliminarUsuario(@PathVariable("idUsuario") Long idUsuario) {
        usuarioService.delete(idUsuario);
        return "redirect:/usuario";
    }

    @GetMapping("/editUsuario/{idUsuario}")
    public String editarUsuario(@PathVariable("idUsuario") Long idUsuario, Model model) {
        Usuario usuario = usuarioService.getUsuarioByID(idUsuario);
        model.addAttribute("users", usuario);
        return "crearUsuario";
    }

}
