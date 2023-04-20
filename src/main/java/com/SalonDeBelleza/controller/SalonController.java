package com.SalonDeBelleza.controller;

import com.SalonDeBelleza.entity.Administrador;
import com.SalonDeBelleza.entity.Comentario;
import com.SalonDeBelleza.entity.Faq;
import com.SalonDeBelleza.entity.Producto;
import com.SalonDeBelleza.entity.Usuario;
import com.SalonDeBelleza.service.IAdministradorService;
import com.SalonDeBelleza.service.IComentarioService;
import com.SalonDeBelleza.service.IFaqService;
import com.SalonDeBelleza.service.IProductoService;
import com.SalonDeBelleza.service.IUsuarioService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SalonController {

    @Autowired
    private IAdministradorService administradorService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IComentarioService comentarioService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IFaqService faqService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    //Comentarios
    @GetMapping("/comentarios")
    public String comentarios(Model model) {
        List<Comentario> listaComentarios = comentarioService.getAllComentarios();
        model.addAttribute("comentarios", listaComentarios);
        return "comentarios";
    }

    @GetMapping("/crearComentario")
    public String crearComentario(Model model) {
        model.addAttribute("comentario", new Comentario());
        return "crearComentario";
    }

    @PostMapping("/guardarComentario")
    public String guardarComentario(@ModelAttribute Comentario comentario) {
        comentario.setCalificacionComentario(comentario.getCalificacionComentario());
        //
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fecha.format(formatter);
        comentario.setFechaComentario(fechaFormateada);
        //
        comentarioService.saveComentario(comentario);
        return "redirect:/comentarios";
    }

    @GetMapping("/eliminarComentario/{idComentario}")
    public String eliminarComentario(@PathVariable("idComentario") Long idComentario) {
        comentarioService.delete(idComentario);
        return "redirect:/comentarios";
    }

    @GetMapping("/editarComentario/{idComentario}")
    public String editarComentario(@PathVariable("idComentario") Long idComentario, Model model) {
        Comentario comentario = comentarioService.getComentarioByID(idComentario);
        model.addAttribute("comentario", comentario);
        return "crearComentario";
    }

    //Productos
    @GetMapping("/productos")
    public String productos(Model model) {
        List<Producto> listaProducto = productoService.getAllProductos();
        model.addAttribute("productos", listaProducto);
        return "Productos";
    }

    @GetMapping("/productosNuevo")
    public String crearProducto(Model model) {
        model.addAttribute("products", new Producto());
        return "Agregar_Producto";
    }

    @GetMapping("/productos/admin")
    public String productosAdmin(Model model) {
        List<Producto> listaProducto = productoService.getAllProductos();
        model.addAttribute("productos", listaProducto);
        return "Admin_Productos";
    }

    @PostMapping("/saveProducto")
    public String guardarProducto(@ModelAttribute Producto producto,
            @RequestParam("file") MultipartFile imagen) {

        if (!imagen.isEmpty()) {
            Path directorioImagenes = Paths.get("src//main//resources//static/images/producto");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);

                producto.setImagenProducto("images/producto/" + imagen.getOriginalFilename());
            } catch (IOException e) {
            }
        }
        productoService.saveProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/deleteProducto/{idProducto}")
    public String eliminarProducto(@PathVariable("idProducto") Long idProducto) {
        productoService.delete(idProducto);
        return "redirect:/productos/admin";
    }

    @GetMapping("/editProducto/{idProducto}")
    public String editarProducto(@PathVariable("idProducto") Long idProducto, Model model) {
        Producto producto = productoService.getProductoByID(idProducto);
        model.addAttribute("products", producto);
        return "Agregar_Producto";
    }

    //Detalle producto
    @GetMapping("/detalleProducto/{idProducto}")
    public String detalleProducto(@PathVariable("idProducto") Long idProducto, Model model) {
        Producto producto = productoService.getProductoByID(idProducto);
        model.addAttribute("products", producto);
        return "Detalle_Producto";
    }

    //CRUD ADMIN
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

    //CRUD USER
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

    //FAQS
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

    @GetMapping("/Faq/admin")
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
