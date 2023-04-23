package com.SalonDeBelleza.controller;

import com.SalonDeBelleza.entity.Usuario;
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
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping("/usuarios")
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
        return "redirect:/usuarios";
    }

    @GetMapping("/deleteUsuario/{idUsuario}")
    public String eliminarUsuario(@PathVariable("idUsuario") Long idUsuario) {
        usuarioService.delete(idUsuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editUsuario/{idUsuario}")
    public String editarUsuario(@PathVariable("idUsuario") Long idUsuario, Model model) {
        Usuario usuario = usuarioService.getUsuarioByID(idUsuario);
        model.addAttribute("users", usuario);
        return "crearUsuario";
    }
}
