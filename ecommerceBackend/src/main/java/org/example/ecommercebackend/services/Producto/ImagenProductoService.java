package org.example.ecommercebackend.services.Producto;

import org.example.ecommercebackend.entities.Producto.ImagenProducto;
import org.example.ecommercebackend.repositories.Producto.ImagenProductoRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenProductoService extends BaseService<ImagenProducto, Long> {

    @Autowired
    private ImagenProductoRepository imagenProductoRepository;

    public ImagenProductoService(ImagenProductoRepository imagenProductoRepository) {
        super(imagenProductoRepository);
    }
}
