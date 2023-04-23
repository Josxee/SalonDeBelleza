package com.SalonDeBelleza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiciosController {
    
    @GetMapping("/servicios")
    public String servicios(Model model) {
        return "Servicios";
    }
}
