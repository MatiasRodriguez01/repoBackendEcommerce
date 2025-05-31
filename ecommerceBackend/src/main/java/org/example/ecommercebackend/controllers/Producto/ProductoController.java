package org.example.ecommercebackend.controllers.Producto;

import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Producto.Categoria;
import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.entities.Producto.Producto;
import org.example.ecommercebackend.services.Producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5174")
@RestController
@RequestMapping("/producto")
public class ProductoController extends BaseController<Producto, Long> {

    @Autowired
    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        super(productoService);
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) throws Exception {
        System.out.println("Producto recibido: " + producto);
        Producto creado = productoService.crear(producto);
        return ResponseEntity.ok(creado);
    }

    // CATEGORIA
    @PutMapping("/{productoId}/asociar-categoria")
    public Producto asociarCategoria(@PathVariable Long productoId, @RequestBody Categoria categoria) throws Exception {
        return productoService.asociarCategoria(productoId, categoria);
    }

    @PutMapping("/{productoId}/desasociar-categoria")
    public Producto desasociarCategoria(@PathVariable Long productoId) throws Exception {
        return productoService.desasocialCategoria(productoId);
    }

    // DETALLE PRODUCTO
    @PutMapping("/{productoId}/agregar-detalle")
    public Producto agregarDetalle(@PathVariable Long productoId, @RequestBody DetalleProducto detalle) throws Exception {
        return productoService.agregarDetalleProducto(productoId, detalle);
    }

    @PutMapping("/{productoId}/eliminar-detalle")
    public Producto eliminarDetalle(@PathVariable Long productoId, @RequestBody DetalleProducto detalle) throws Exception {
        return productoService.sacarDetalleProducto(productoId, detalle);
    }
}

