package com.SalonDeBelleza.controller;

import com.SalonDeBelleza.entity.Faq;
import com.SalonDeBelleza.service.IFaqService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FAQController {
    
    @Autowired  
    private IFaqService faqService;
    
    @GetMapping("/Faqs")
    public String FAQ(Model model) {
        List<Faq> listaFaq = faqService.getAllFaq();
        model.addAttribute("faq", listaFaq);
        return "FAQ";
    }

    @GetMapping("/FaqNuevo")
    public String crearFaq(Model model) {
        model.addAttribute("faq", new Faq());
        return "Agregar_Faq";
    }

    @GetMapping("/FaqAdmin")
    public String faqAdmin(Model model) {
        List<Faq> listaFaq = faqService.getAllFaq();
        model.addAttribute("faq", listaFaq);
        return "Admin_Faq";
    }

    @PostMapping("/saveFaq")
    public String guardarFaq(@ModelAttribute Faq faq) {
        faqService.saveFaq(faq);
        return "redirect:/Faqs";
    }

    @GetMapping("/deleteFaq/{ID_faq}")
    public String eliminarFaq(@PathVariable("ID_faq") Long ID_faq) {
        faqService.delete(ID_faq);
        return "redirect:/Faq/admin";
    }

    @GetMapping("/editFaq/{ID_faq}")
    public String editarFaq(@PathVariable("ID_faq") Long ID_faq, Model model) {
        Faq faq = faqService.getFaqByID(ID_faq);
        model.addAttribute("faq", faq);
        return "Agregar_Faq";
    }
}
