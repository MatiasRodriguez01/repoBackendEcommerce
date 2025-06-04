package org.example.ecommercebackend.controllers.Producto;

import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Producto.*;
import org.example.ecommercebackend.services.Producto.DetalleProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalleProducto")
@CrossOrigin(origins = "http://localhost:5173")
public class DetalleProductoController extends BaseController<DetalleProducto, Long> {

    private final DetalleProductoService detalleProductoService;

    public DetalleProductoController(DetalleProductoService detalleProductoService) {
        super(detalleProductoService);
        this.detalleProductoService = detalleProductoService;
    }

    // ------------------------- Ordenar por tipo de producto -----------------------------------
    @GetMapping(params={"seccion", "categoria", "talle", "tipo", "orden"})
    public ResponseEntity<?> filtrarDetalleProducto(@RequestParam(required = false) String seccion,
                                                    @RequestParam(required = false) String categoria,
                                                    @RequestParam(required = false) String talle,
                                                    @RequestParam(required = false) String tipo,
                                                    @RequestParam(required = false) String orden) {
        try {

            if ((seccion == "") || (categoria == "")){
                return ResponseEntity.ok(List.of());
            }
            if ((talle == "") && (tipo == "") && (orden == "")) {
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetallesPorProducto(seccionUpper, categoriaLower);
                return ResponseEntity.ok(lista);
            }
            if ((tipo == "") && (orden == "")){
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                List<DetalleProducto> lista = detalleProductoService.ordernarDetallesPorTalleDeProducto(seccionUpper, categoriaLower, talleFormat);
                return ResponseEntity.ok(lista);
            }
            if ((talle == "") && (orden == "")) {
                String tipoUpper = tipo.toUpperCase();
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetallePorTipodeproducto(seccionUpper, categoriaLower, tipoUpper);
                return ResponseEntity.ok(lista);
            }
            if ((talle == "") && (tipo == "")) {
                String seccionUpper = seccion.toUpperCase();
                String ordenToLower = orden.toLowerCase();
                String categoriaLower = categoria.toLowerCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetallePorPrecio(seccionUpper, categoriaLower, ordenToLower);
                return ResponseEntity.ok(lista);
            }
            if (talle == ""){
                String seccionUpper = seccion.toUpperCase();
                String tipoUpper = tipo.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinTalle(seccionUpper, categoriaLower, tipoUpper, orden);
                return ResponseEntity.ok(lista);
            }
            if (tipo == ""){
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinTipo(seccionUpper, categoriaLower, talleFormat, orden);
                return ResponseEntity.ok(lista);
            }
            if (orden == ""){
                String seccionUpper = seccion.toUpperCase();
                String tipoUpper = tipo.toUpperCase();
                String categoriaLower = categoria.toLowerCase();

                List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinOrden(seccionUpper, categoriaLower, talle, tipoUpper);
                return ResponseEntity.ok(lista);
            }
            String seccionUpper = seccion.toUpperCase();
            String tipoUpper = tipo.toUpperCase();
            String categoriaLower = categoria.toLowerCase();
            String ordenToLower = orden.toLowerCase();
            String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
            List<DetalleProducto> lista = detalleProductoService.filtarDetalleProducto(seccionUpper, categoriaLower, talleFormat, tipoUpper, ordenToLower);
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    // ======================= TALLESDETALLEPRODUCTOS ==================================
    @PutMapping("/{detalleID}/agregarTalle")
    public ResponseEntity<?> agregarTalle(@PathVariable Long detalleId, @RequestBody Talles talle) {
        try {
            DetalleProducto detalleActualizado = detalleProductoService.agregarTalles(detalleId, talle);
            return ResponseEntity.ok(detalleActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{detalleID}/eliminarTalle")
    public ResponseEntity<?> sacarTalle(@PathVariable Long detalleId, @RequestBody Talles talle) {
        try {
            DetalleProducto detalleActualizado = detalleProductoService.sacarTalles(detalleId, talle);
            return ResponseEntity.ok(detalleActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // ===================== PRODUCTO =====================

    @PutMapping("/{detalleId}/asociarProducto")
    public ResponseEntity<?> asociarProducto(@PathVariable Long detalleId, @RequestBody Producto producto) {
        try {
            DetalleProducto detalleActualizado = detalleProductoService.asociarProducto(detalleId, producto);
            return ResponseEntity.ok(detalleActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{detalleId}/desasociarProducto")
    public ResponseEntity<?> desasociarProducto(@PathVariable Long detalleId) {
        try {
            DetalleProducto detalleActualizado = detalleProductoService.desasociarProducto(detalleId);
            return ResponseEntity.ok(detalleActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ===================== PRECIO =====================

    @PutMapping("/{detalleId}/asociarPrecio")
    public ResponseEntity<?> asociarPrecio(@PathVariable Long detalleId, @RequestBody Precio precio) {
        try {
            DetalleProducto detalleActualizado = detalleProductoService.asociarPrecio(detalleId, precio);
            return ResponseEntity.ok(detalleActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{detalleId}/desasociarPrecio")
    public ResponseEntity<?> desasociarPrecio(@PathVariable Long detalleId) {
        try {
            DetalleProducto detalleActualizado = detalleProductoService.desasociarPrecio(detalleId);
            return ResponseEntity.ok(detalleActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ===================== IMAGEN PRODUCTO =====================

    @PutMapping("/{detalleId}/asociarImagen")
    public ResponseEntity<?> asociarImagen(@PathVariable Long detalleId, @RequestBody ImagenProducto imagen) {
        try {
            DetalleProducto detalleActualizado = detalleProductoService.asocialImagen(detalleId, imagen);
            return ResponseEntity.ok(detalleActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{detalleId}/desasociarImagen")
    public ResponseEntity<?> desasociarImagen(@PathVariable Long detalleId) {
        try {
            DetalleProducto detalleActualizado = detalleProductoService.desasocialImagen(detalleId);
            return ResponseEntity.ok(detalleActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}