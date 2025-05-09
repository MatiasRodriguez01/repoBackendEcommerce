package org.example.ecommercebackend.services.Producto;

import jakarta.transaction.Transactional;
import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.entities.Producto.ImagenProducto;
import org.example.ecommercebackend.entities.Producto.Precio;
import org.example.ecommercebackend.entities.Producto.Producto;
import org.example.ecommercebackend.repositories.Producto.DetalleProductoRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleProductoService extends BaseService<DetalleProducto, Long> {

    @Autowired
    private DetalleProductoRepository detalleProductoRepository;

    public DetalleProductoService(DetalleProductoRepository detalleProductoRepository) {
        super(detalleProductoRepository);
    }


    // METODOS PARA PRODUCTO
    // Metodo para asocial un producto
    @Transactional
    public DetalleProducto asociarProducto(Long detalleId, Producto producto) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));

            if (detalle.getProducto() != null) {
                throw new Exception("Este detalle ya tiene un producto asociado");
            }
            detalle.setProducto(producto);
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (asociarProducto): " + ex.getMessage());
        }

    }
    // metodo para desasocial un producto
    @Transactional
    public DetalleProducto desasociarProducto(Long detalleId) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));

            detalle.setProducto(null);
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (desasocialProducto): " + ex.getMessage());
        }

    }

    // METODOS PARA PRECIO
    // metodos para asocial un precio
    @Transactional
    public DetalleProducto asociarPrecio(Long detalleId, Precio precio) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));

            if (detalle.getPrecio() != null) {
                throw new Exception("Este detalle ya tiene un precio asociado");
            }
            detalle.setPrecio(precio);
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (asocialPrecio): " + ex.getMessage());
        }
    }
    // metodo para desasocial un precio
    @Transactional
    public DetalleProducto desasociarPrecio(Long detalleId) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));

            detalle.setPrecio(null);
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (desasocialPrecio): " + ex.getMessage());
        }

    }

    // METODOS PARA IMAGEN___PRODUCTO
    // metodo para asociar una imagen
    @Transactional
    public DetalleProducto asocialImagen(Long detalleId, ImagenProducto imagen) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));
            if (detalle.getImagenProducto() != null) {
                throw new Exception("El detalle " + detalle.getId() + " ya tiene una imagen asociada");
            }
            detalle.setImagenProducto(imagen);
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (asocialImagen): " + ex.getMessage());
        }

    }
    // metodo para eliminar imagen
    public DetalleProducto desasocialImagen(Long detalleId) throws Exception {
        try {
            DetalleProducto detalle = detalleProductoRepository.findById(detalleId)
                    .orElseThrow(() -> new Exception("DetalleProducto no encontrado con id: " + detalleId));

            detalle.setImagenProducto(null);
            return detalleProductoRepository.save(detalle);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (desasocialImagen): " + ex.getMessage());
        }

    }
}
