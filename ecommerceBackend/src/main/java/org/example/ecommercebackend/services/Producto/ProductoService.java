package org.example.ecommercebackend.services.Producto;

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
}
