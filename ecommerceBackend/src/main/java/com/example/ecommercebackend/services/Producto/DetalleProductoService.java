package org.example.ecommercebackend.services.Producto;

import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.repositories.BaseRepository;
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
}
