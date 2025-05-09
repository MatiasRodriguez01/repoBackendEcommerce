package org.example.ecommercebackend.services.Usuario;

import org.example.ecommercebackend.entities.Usuario.OrdenCompraDetalle;
import org.example.ecommercebackend.repositories.Usuario.OrdenCompraDetalleRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraDetalleService extends BaseService<OrdenCompraDetalle, Long> {

    @Autowired
    private OrdenCompraDetalleRepository ordenCompraDetalleRepository;

    public OrdenCompraDetalleService(OrdenCompraDetalleRepository ordenCompraDetalleRepository) {
        super(ordenCompraDetalleRepository);
    }
}
