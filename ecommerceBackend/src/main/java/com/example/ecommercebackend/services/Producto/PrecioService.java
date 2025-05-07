package org.example.ecommercebackend.services.Producto;

import org.example.ecommercebackend.entities.Producto.Precio;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.example.ecommercebackend.repositories.Producto.PrecioRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrecioService extends BaseService<Precio, Long> {


    @Autowired
    private PrecioRepository precioRepository;

    public PrecioService(PrecioRepository precioRepository) {
        super(precioRepository);
    }
}
