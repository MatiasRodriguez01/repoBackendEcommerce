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

@RestController
@RequestMapping("/producto")
public class ProductoController extends BaseController<Producto, Long> {

    @Autowired
    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        super(productoService);
    }


    @GetMapping(value= "{productoId}", params={"seccion", "categoria", "talle", "tipo", "orden"})
    public ResponseEntity<?> filtrarDetalleProducto(@PathVariable Long productoId,
                                                    @RequestParam(required = false) String seccion,
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
                List<DetalleProducto> lista = productoService.ordenarDetallesPorProducto(productoId, seccionUpper, categoriaLower);
                return ResponseEntity.ok(lista);
            }
            if ((tipo == "") && (orden == "")){
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                List<DetalleProducto> lista = productoService.ordernarDetallesPorTalleDeProducto(productoId, seccionUpper, categoriaLower, talleFormat);
                return ResponseEntity.ok(lista);
            }
            if ((talle == "") && (orden == "")) {
                String tipoUpper = tipo.toUpperCase();
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                List<DetalleProducto> lista = productoService.ordenarDetallePorTipodeproducto(productoId, seccionUpper, categoriaLower, tipoUpper);
                return ResponseEntity.ok(lista);
            }
            if ((talle == "") && (tipo == "")) {
                String seccionUpper = seccion.toUpperCase();
                String ordenToLower = orden.toLowerCase();
                String categoriaLower = categoria.toLowerCase();
                List<DetalleProducto> lista = productoService.ordenarDetallePorPrecio(productoId, seccionUpper, categoriaLower, ordenToLower);
                return ResponseEntity.ok(lista);
            }
            if (talle == ""){
                String seccionUpper = seccion.toUpperCase();
                String tipoUpper = tipo.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                List<DetalleProducto> lista = productoService.ordenarDetalleSinTalle(productoId, seccionUpper, categoriaLower, tipoUpper, orden);
                return ResponseEntity.ok(lista);
            }
            if (tipo == ""){
                String seccionUpper = seccion.toUpperCase();
                String categoriaLower = categoria.toLowerCase();
                String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
                List<DetalleProducto> lista = productoService.ordenarDetalleSinTipo(productoId, seccionUpper, categoriaLower, talleFormat, orden);
                return ResponseEntity.ok(lista);
            }
            if (orden == ""){
                String seccionUpper = seccion.toUpperCase();
                String tipoUpper = tipo.toUpperCase();
                String categoriaLower = categoria.toLowerCase();

                List<DetalleProducto> lista = productoService.ordenarDetalleSinOrden(productoId, seccionUpper, categoriaLower, talle, tipoUpper);
                return ResponseEntity.ok(lista);
            }
            String seccionUpper = seccion.toUpperCase();
            String tipoUpper = tipo.toUpperCase();
            String categoriaLower = categoria.toLowerCase();
            String ordenToLower = orden.toLowerCase();
            String talleFormat = talle.matches("\\d+") ? talle : talle.toUpperCase();
            List<DetalleProducto> lista = productoService.filtarDetalleProducto(productoId, seccionUpper, categoriaLower, talleFormat, tipoUpper, ordenToLower);
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
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

