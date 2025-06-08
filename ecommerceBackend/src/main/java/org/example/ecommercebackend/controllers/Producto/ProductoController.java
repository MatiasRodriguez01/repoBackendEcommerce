package org.example.ecommercebackend.controllers.Producto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Producto.Categoria;
import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.entities.Producto.Producto;
import org.example.ecommercebackend.services.Producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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
        // Imprimimos el JSON “crudo” que Jackson mapea a Producto
        System.out.println(">>> Request completo (antes de bind): " + new ObjectMapper().writeValueAsString(producto));

        // Luego, imprimimos cada atributo por separado:
        System.out.println("    nombre      = " + producto.getNombre());
        System.out.println("    tipoProducto= " + producto.getTipoProducto());
        System.out.println("    seccion     = " + producto.getSeccion());
        System.out.println("    categoriaID = " + (producto.getCategoria() != null ? producto.getCategoria().getId() : "null"));
        System.out.println("    #detalles   = " + (producto.getDetallesProductos() != null ? producto.getDetallesProductos().size() : "null"));
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

