package com.SalonDeBelleza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SucursalesController {
    
    @GetMapping("/sucursales")
    public String sucursales(Model model) {
        return "Sucursales";
    }
    
    @GetMapping("/Sucursal1")
    public String sucursales1(Model model) {
        return "SucursalAlajuela";
    }
    
    @GetMapping("/Sucursal2")
    public String sucursales2(Model model) {
        return "SucursalFidelitasHeredia";
    }
    
    @GetMapping("/Sucursal3")
    public String sucursales3(Model model) {
        return "SucursalLimon";
    }
    
}
