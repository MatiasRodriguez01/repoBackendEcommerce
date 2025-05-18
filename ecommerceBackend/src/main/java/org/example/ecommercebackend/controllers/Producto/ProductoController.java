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

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/producto")
public class ProductoController extends BaseController<Producto, Long> {

    @Autowired
    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        super(productoService);
    }

    // --------------------------  METODOS ----------------------------------
    @GetMapping(value = "{productoId}", params = {"seccion", "categoria"})
    public ResponseEntity<?> ordenarDetallePorProducto(@PathVariable Long productoId,
                                                       @RequestParam String seccion,
                                                       @RequestParam String categoria) {
        try {
            String seccionUpper = seccion.toUpperCase();
            List<DetalleProducto> lista = productoService.ordenarDetallesPorProducto(productoId, seccionUpper, categoria);
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "{productoId}", params = {"seccion", "categoria", "talle"})
    public ResponseEntity<?> ordenarDetallePorTalle(@PathVariable Long productoId,
                                                    @RequestParam String seccion,
                                                    @RequestParam String categoria,
                                                    @RequestParam String talle) {
        try {
            String seccionUpper = seccion.toUpperCase();
            if (!talle.matches("\\d+")) {
                String talleUpper = talle.toUpperCase();
                List<DetalleProducto> lista = productoService.ordernarDetallesPorTalleDeProducto(productoId, seccionUpper, categoria, talleUpper);
                return ResponseEntity.ok(lista);
            } else {
                List<DetalleProducto> lista = productoService.ordernarDetallesPorTalleDeProducto(productoId, seccionUpper, categoria, talle);
                return ResponseEntity.ok(lista);
            }

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "{productoId}", params = {"seccion", "categoria", "tipo"})
    public ResponseEntity<?> ordenarDetallePorTipo(@PathVariable Long productoId,
                                                    @RequestParam String seccion,
                                                    @RequestParam String categoria,
                                                    @RequestParam String tipo) {
        try {
            String tipoUpper = tipo.toUpperCase();
            String seccionUpper = seccion.toUpperCase();
            List<DetalleProducto> lista = productoService.ordenarDetallePorTipodeproducto(productoId, seccionUpper, categoria, tipoUpper);
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "{productoId}", params = {"seccion", "categoria", "orden"})
    public ResponseEntity<?> ordenarDetallePorPrecio(@PathVariable Long productoId,
                                                   @RequestParam String seccion,
                                                   @RequestParam String categoria,
                                                   @RequestParam String orden) {
        try {
            String seccionUpper = seccion.toUpperCase();
            String ordenToLower = orden.toLowerCase();
            List<DetalleProducto> lista = productoService.ordenarDetallePorPrecio(productoId, seccionUpper, categoria, ordenToLower);
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
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

