package com.SalonDeBelleza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalonController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
}