package org.example.ecommercebackend.services.Producto;

import jakarta.transaction.Transactional;
import org.example.ecommercebackend.entities.Producto.Categoria;
import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.entities.Producto.Producto;
import org.example.ecommercebackend.repositories.Producto.ProductoRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService extends BaseService<Producto, Long> {

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        super(productoRepository);
    }

    // METODOS para categoria
    // agregaron una categoria
    @Transactional
    public Producto asociarCategoria(Long idProducto, Categoria newCategoria) throws Exception {
        try {
            Producto producto = productoRepository.findById(idProducto)
                    .orElseThrow(() -> new Exception("Producto no encontrado con id: " + idProducto));

            if (producto.getCategoria() != null){
                throw new Exception("El producto " + producto.getNombre() + " tiene una categoria!");
            }
            producto.setCategoria(newCategoria);
            return productoRepository.save(producto);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (asociarCategoria): " + ex.getMessage());
        }

    }
    // metodo para sacar la categoria existente
    @Transactional
    public Producto desasocialProducto(Long idProducto) throws Exception {
        try {
            Producto producto = productoRepository.findById(idProducto)
                    .orElseThrow(() -> new Exception("Producto no encontrado con id: " + idProducto));

            producto.setCategoria(null);
            return productoRepository.save(producto);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (desasocialProducto): " + ex.getMessage());
        }
    }

    ///  METODOS PARA DETALLEPRODUCTOS
    // metodos para agregar un detalle
    @Transactional
    public Producto agregarDetalleProducto(Long idProducto, DetalleProducto newDetalle) throws Exception {
        try {
            Producto producto = productoRepository.findById(idProducto)
                    .orElseThrow(() -> new Exception("Producto no encontrado con id: " + idProducto));
            producto.getDetallesProductos().add(newDetalle);
            return productoRepository.save(producto);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (agregarDetalleProducto): " + ex.getMessage());
        }

    }
    @Transactional
    public Producto sacarDetalleProducto(Long idProducto, DetalleProducto detalleEliminar) throws Exception {
        try {
            Producto producto = productoRepository.findById(idProducto)
                    .orElseThrow(() -> new Exception("Producto no encontrado con id: " + idProducto));
            producto.getDetallesProductos().removeIf(detalle -> detalle.getId() == detalleEliminar.getId());
            return productoRepository.save(producto);
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error en el servicio (sacarDetalleProducto): " + ex.getMessage());
        }
    }
}
