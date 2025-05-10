package org.example.ecommercebackend.controllers.Producto;

import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Producto.Categoria;
import org.example.ecommercebackend.entities.Producto.Producto;
import org.example.ecommercebackend.services.Producto.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/categorias")
public class CategoriaController extends BaseController<Categoria, Long> {

    @Autowired
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        super(categoriaService);
    }

    // Relación Categoria Padre
    @PutMapping("/agregarCategoriaPadre/{idCategoria}")
    public Categoria agregarCategoriaPadre(@PathVariable Long idCategoria, @RequestBody Categoria newCatePadre) throws Exception {
        return categoriaService.agregarCategoriaPadre(idCategoria, newCatePadre);
    }

    @PutMapping("/sacarCategoriaPadre/{idCategoria}")
    public Categoria sacarCategoriaPadre(@PathVariable Long idCategoria) throws Exception {
        return categoriaService.sacarCategoriaPadre(idCategoria);
    }

    // Relación Productos
    @PutMapping("/agregarProducto/{idCategoria}")
    public Categoria agregarProducto(@PathVariable Long idCategoria, @RequestBody Producto newProducto) throws Exception {
        return categoriaService.agregarProducto(idCategoria, newProducto);
    }

    @PutMapping("/sacarProducto/{idCategoria}")
    public Categoria sacarProducto(@PathVariable Long idCategoria, @RequestBody Producto productoEliminar) throws Exception {
        return categoriaService.sacarProducto(idCategoria, productoEliminar);
    }
}