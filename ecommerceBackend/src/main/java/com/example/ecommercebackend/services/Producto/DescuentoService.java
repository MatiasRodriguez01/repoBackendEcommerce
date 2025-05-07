package org.example.ecommercebackend.services.Producto;

import org.example.ecommercebackend.entities.Producto.Descuento;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.example.ecommercebackend.repositories.Producto.DescuentoRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescuentoService extends BaseService<Descuento, Long> {

    @Autowired
    private DescuentoRepository descuentoRepository;

    public DescuentoService(DescuentoRepository descuentoRepository) {
        super(descuentoRepository);
    }


}
