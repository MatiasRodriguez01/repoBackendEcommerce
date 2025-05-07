package org.example.ecommercebackend.services.Usuario;

import org.example.ecommercebackend.entities.Usuario.OrdenCompra;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.example.ecommercebackend.repositories.Usuario.OrdenCompraRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraService extends BaseService<OrdenCompra, Long> {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    public OrdenCompraService(OrdenCompraRepository ordenCompraRepository) {
        super(ordenCompraRepository);
    }
}
