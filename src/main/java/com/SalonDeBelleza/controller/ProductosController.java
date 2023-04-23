package com.SalonDeBelleza.controller;

import com.SalonDeBelleza.entity.Producto;
import com.SalonDeBelleza.service.IProductoService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class ProductosController {
    
    @Autowired
    private IProductoService productoService;
    
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

    @GetMapping("/productosAdmin")
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
    @GetMapping("/detalleProducto{idProducto}")
    public String detalleProducto(@PathVariable("idProducto") Long idProducto, Model model) {
        Producto producto = productoService.getProductoByID(idProducto);
        model.addAttribute("products", producto);
        return "Detalle_Producto";
    }
}
