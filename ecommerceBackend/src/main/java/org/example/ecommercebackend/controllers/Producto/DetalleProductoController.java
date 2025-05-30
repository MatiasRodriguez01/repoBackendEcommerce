package org.example.ecommercebackend.controllers.Producto;

import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Producto.*;
import org.example.ecommercebackend.services.Producto.DetalleProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/detalleProducto")
public class DetalleProductoController extends BaseController<DetalleProducto, Long> {

    private final DetalleProductoService detalleProductoService;

    public DetalleProductoController(DetalleProductoService detalleProductoService) {
        super(detalleProductoService);
        this.detalleProductoService = detalleProductoService;
    }

    // ------------------------- Ordenar por tipo de producto -----------------------------------
    @GetMapping("/filter")
    public ResponseEntity<?> filtrarDetalleProducto(@RequestParam(required = false) String seccion,
                                                    @RequestParam(required = false) String categoria,
                                                    @RequestParam(required = false) String talle,
                                                    @RequestParam(required = false) String tipo,
                                                    @RequestParam(required = false) String orden,
                                                    @RequestParam(required = false) String buscador) {

        try {
            if (seccion.equals("") && categoria.equals("")){
                if ((tipo == "") && (orden == "") && (buscador == "")){
                    String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                    List<DetalleProducto> lista = detalleProductoService.ordernarDetallesPorTalleDeProductoCatalogoCompleto(talleFormat);
                    return ResponseEntity.ok(lista);
                }
                if ((tipo == "") && (orden == "")){
                    String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                    List<DetalleProducto> lista = detalleProductoService.ordernarDetallesPorTalleDeProductoCatalogoCompletoBuscador(talleFormat, buscador);
                    return ResponseEntity.ok(lista);
                }
                if ((talle == "") && (orden == "") && (buscador == "")) {
                    String tipoUpper = tipo.toUpperCase();
                    List<DetalleProducto> lista = detalleProductoService. ordenarDetallesPorTipodeproductoCatalogoCompleto(tipoUpper);
                    return ResponseEntity.ok(lista);
                }
                if((talle == "" ) && (orden == "")){
                    String tipoUpper = tipo.toUpperCase();
                    List<DetalleProducto> lista = detalleProductoService. ordenarDetallesPorTipodeproductoCatalogoCompletoBuscador(tipoUpper, buscador);
                    return ResponseEntity.ok(lista);
                }
                if ((talle == "") && (tipo == "") && (buscador == "")) {
                    String ordenToLower = orden.toLowerCase();
                    List<DetalleProducto> lista = detalleProductoService.ordenarDetallePorPrecioCatalogoCompleto(ordenToLower);
                    return ResponseEntity.ok(lista);
                }

                if((talle == "") && (tipo == "")){
                    String ordenToLower = orden.toLowerCase();
                    List<DetalleProducto> lista = detalleProductoService.ordenarDetallePorPrecioCatalogoCompletoBuscador(ordenToLower, buscador);
                    return ResponseEntity.ok(lista);
                }
                if ((talle == "") && (orden == "") && (tipo == "")){
                    List<DetalleProducto> lista = detalleProductoService.filtrarDetallesPorBusquedaCatalogoCompleto(buscador);
                    return ResponseEntity.ok(lista);
                }
                if ((talle == "") && (buscador == "")) {
                    String ordenToLower = orden.toLowerCase();
                    String tipoUpper = tipo.toUpperCase();
                    List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinTalleCatalogoCompleto(tipoUpper, ordenToLower);
                    return ResponseEntity.ok(lista);
                }

                if ((talle == "")) {
                    String ordenToLower = orden.toLowerCase();
                    String tipoUpper = tipo.toUpperCase();
                    List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinTalleCatalogoCompletoBuscador(tipoUpper, ordenToLower, buscador);
                    return ResponseEntity.ok(lista);
                }

                if ((tipo == "") && (buscador == "")){
                    String ordenToLower = orden.toLowerCase();
                    String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                    List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinTipoCatalogoCompleto(talleFormat, ordenToLower);
                    return ResponseEntity.ok(lista);
                }

                if ((tipo == "")){
                    String ordenToLower = orden.toLowerCase();
                    String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                    List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinTipoCatalogoCompletoBuscador(talleFormat, ordenToLower, buscador);
                    return ResponseEntity.ok(lista);
                }
                if ((orden == "") && (buscador == "")){
                    String tipoUpper = tipo.toUpperCase();
                    String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                    List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinOrdenCatalogoCompleto(talleFormat, tipoUpper);
                    return ResponseEntity.ok(lista);
                }
                if ((orden == "")){
                    String tipoUpper = tipo.toUpperCase();
                    String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                    List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinOrdenCatalogoCompletoBuscador(talleFormat, tipoUpper, buscador);
                    return ResponseEntity.ok(lista);
                }
                String seccionUpper = seccion.toUpperCase();
                String tipoUpper = tipo.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                String ordenToLower = orden.toLowerCase();
                String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                List<DetalleProducto> lista = detalleProductoService.filtarDetalleProducto(seccionUpper, categoriaLower, talleFormat, tipoUpper, ordenToLower, buscador);
                return ResponseEntity.ok(lista);
            }
            if ((talle == "") && (tipo == "") && (orden == "") && (buscador == "")) {
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetallesPorProducto(seccionUpper, categoriaLower);
                return ResponseEntity.ok(lista);
            }
            if ((talle == "") && (tipo == "") && (orden == "")) {
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetallesPorProductoBuscador(seccionUpper, categoriaLower, buscador);
                return ResponseEntity.ok(lista);
            }
            if ((tipo == "") && (orden == "") && (buscador == "")){
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                List<DetalleProducto> lista = detalleProductoService.ordernarDetallesPorTalleDeProducto(seccionUpper, categoriaLower, talleFormat);
                return ResponseEntity.ok(lista);
            }
            if ((tipo == "") && (orden == "")){
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                List<DetalleProducto> lista = detalleProductoService.ordernarDetallesPorTalleDeProductoBuscador(seccionUpper, categoriaLower, talleFormat, buscador);
                return ResponseEntity.ok(lista);
            }
            if ((talle == "") && (orden == "") && (buscador == "")) {
                String tipoUpper = tipo.toUpperCase();
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetallePorTipodeproducto(seccionUpper, categoriaLower, tipoUpper);
                return ResponseEntity.ok(lista);
            }
            if ((talle == "") && (orden == "")) {
                String tipoUpper = tipo.toUpperCase();
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetallePorTipodeproductoBuscador(seccionUpper, categoriaLower, tipoUpper, buscador);
                return ResponseEntity.ok(lista);
            }
            if ((talle == "") && (tipo == "") && (buscador == "")) {
                String seccionUpper = seccion.toUpperCase();
                String ordenToLower = orden.toLowerCase();
                String categoriaLower = categoria.toLowerCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetallePorPrecio(seccionUpper, categoriaLower, ordenToLower);
                return ResponseEntity.ok(lista);
            }
            if ((talle == "") && (tipo == "")) {
                String seccionUpper = seccion.toUpperCase();
                String ordenToLower = orden.toLowerCase();
                String categoriaLower = categoria.toLowerCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetallePorPrecioBuscador(seccionUpper, categoriaLower, ordenToLower, buscador);
                return ResponseEntity.ok(lista);
            }
            if ((talle == "") && (buscador == "")){
                String seccionUpper = seccion.toUpperCase();
                String tipoUpper = tipo.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                String ordenToLower = orden.toLowerCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinTalle(seccionUpper, categoriaLower, tipoUpper, ordenToLower);
                return ResponseEntity.ok(lista);
            }
            if ((talle == "") && (buscador == "")){
                String seccionUpper = seccion.toUpperCase();
                String tipoUpper = tipo.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                String ordenToLower = orden.toLowerCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinTalleBuscador(seccionUpper, categoriaLower, tipoUpper, ordenToLower, buscador);
                return ResponseEntity.ok(lista);
            }
            if ((tipo == "") && (buscador == "")){
                String ordenToLower = orden.toLowerCase();
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinTipo(seccionUpper, categoriaLower, talleFormat, ordenToLower);
                return ResponseEntity.ok(lista);
            }
            if ((tipo == "")){
                String ordenToLower = orden.toLowerCase();
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinTipoBuscador(seccionUpper, categoriaLower, talleFormat, ordenToLower, buscador);
                return ResponseEntity.ok(lista);
            }
            if ((orden == "") && (buscador == "")){
                String seccionUpper = seccion.toUpperCase();
                String tipoUpper = tipo.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();

                List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinOrden(seccionUpper, categoriaLower, talleFormat, tipoUpper);
                return ResponseEntity.ok(lista);
            }
            if ((orden == "")){
                String seccionUpper = seccion.toUpperCase();
                String tipoUpper = tipo.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();

                List<DetalleProducto> lista = detalleProductoService.ordenarDetalleSinOrdenBuscador(seccionUpper, categoriaLower, talleFormat, tipoUpper, buscador);
                return ResponseEntity.ok(lista);
            }
            String seccionUpper = seccion.toUpperCase();
            String tipoUpper = tipo.toUpperCase();
            String categoriaLower = categoria.toLowerCase();
            String ordenToLower = orden.toLowerCase();
            String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
            List<DetalleProducto> lista = detalleProductoService.filtarDetalleProducto(seccionUpper, categoriaLower, talleFormat, tipoUpper, ordenToLower, buscador);
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