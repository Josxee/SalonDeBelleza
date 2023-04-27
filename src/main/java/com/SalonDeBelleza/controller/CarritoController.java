package com.SalonDeBelleza.controller;

import com.SalonDeBelleza.entity.Item;
import com.SalonDeBelleza.entity.Producto;
import com.SalonDeBelleza.entity.Usuario;
import com.SalonDeBelleza.service.IProductoService;
import com.SalonDeBelleza.service.IUsuarioService;
import com.SalonDeBelleza.service.ItemService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarritoController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private IProductoService articuloService;
    @Autowired
    private IUsuarioService clienteService;
    @Autowired
    private HttpSession session;

//VER
    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var items = itemService.gets();
        model.addAttribute("items", items);
        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecioProducto());
        }
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return "/carrito/listado";
    }

    //AGREGAR
    @GetMapping("/carrito/agregar/{idProducto}")
    public ModelAndView agregarItem(Model model, Item item) {
        Item item2 = itemService.get(item);
        if (item2 == null) {
            Producto articulo = articuloService.getArticulo(item);
            item2 = new Item(articulo);
        }
        itemService.save(item2);
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecioProducto());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentosCarrito :: verCarrito");
    }

    //MODIFICAR
    @GetMapping("/carrito/modificar/{idProducto}")
    public String modificarItem(Item item, Model model) {
        item = itemService.get(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";
    }

    //ELIMINAR
    @GetMapping("/carrito/eliminar/{idProducto}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }

    //ACTUALIZAR
    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }

    //FACTURAR
    @GetMapping("/facturar/carrito")
    public String facturarCarrito(Model model) {
        var items = itemService.gets();
        var itemsCopia = itemService.gets();
        model.addAttribute("items", itemsCopia);

        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecioProducto());
        }
        model.addAttribute("carritoTotal", carritoTotalVenta);

        return "/carrito/fragmentosFactura";
    }

    @GetMapping("/carrito/checkin")
    public String factura() {
        ItemService.listaItems.clear();
        return "/carrito/limpiarCarrito";
    }
}
