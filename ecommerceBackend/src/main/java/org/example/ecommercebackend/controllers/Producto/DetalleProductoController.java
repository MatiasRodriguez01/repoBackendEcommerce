package org.example.ecommercebackend.controllers.Producto;

import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Producto.*;
import org.example.ecommercebackend.repositories.Producto.DetalleProductoRepository;
import org.example.ecommercebackend.services.Producto.DetalleProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/detalleProducto")
public class DetalleProductoController extends BaseController<DetalleProducto, Long> {

    private final DetalleProductoService detalleProductoService;
    private final DetalleProductoRepository detalleProductoRepository;

    public DetalleProductoController(DetalleProductoService detalleProductoService, DetalleProductoRepository detalleProductoRepository) {
        super(detalleProductoService);
        this.detalleProductoService = detalleProductoService;
        this.detalleProductoRepository = detalleProductoRepository;
    }

    // ------------------------- Ordenar por tipo de producto -----------------------------------

    @GetMapping("/filter")
    public ResponseEntity<?> filtrarDetalleProducto(@RequestParam String seccion,
                                                     @RequestParam String categoria,
                                                     @RequestParam String talle,
                                                     @RequestParam String tipo,
                                                     @RequestParam String orden,
                                                     @RequestParam String buscador,
                                                     @RequestParam Integer precioMaximo){
        try{

            seccion = seccion.toUpperCase();
            categoria = categoria.toLowerCase();
            talle = talle.matches("\\d+") ? talle : talle.toUpperCase();
            tipo = tipo.toUpperCase();
            orden = orden.toLowerCase();
            List<DetalleProducto> listaDetalles = detalleProductoService.ordenarDetallesProductos(seccion, categoria, talle, tipo, orden, buscador, precioMaximo);
            System.out.println("Lista de detalles en el controller: " + listaDetalles);
            return ResponseEntity.ok(listaDetalles);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al filtrar productos");
        }
}



    // ======================= TALLESDETALLEPRODUCTOS ==================================
    @PutMapping("/{detalleId}/agregarTalle")
    public ResponseEntity<?> agregarTalle(@PathVariable Long detalleId, @RequestBody Talles talle) {
        System.out.println("Talle recibido: " + talle);
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

    //ELIMINADO LOGICO
    @PatchMapping("/{detalleId}/eliminadoLogico")
    public ResponseEntity<?> eliminadoLogico(@PathVariable Long detalleId){
        DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado"));

        detalle.setEstado(false);

        detalleProductoRepository.save(detalle);

        return ResponseEntity.ok(detalle);
    }
}