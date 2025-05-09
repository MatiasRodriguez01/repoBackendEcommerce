package org.example.ecommercebackend.controllers.Usuario;

import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Usuario.OrdenCompraDetalle;
import org.example.ecommercebackend.services.Usuario.OrdenCompraDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordenCompraDetalle")
public class OrdenCompraDetalleController extends BaseController<OrdenCompraDetalle,Long> {

    @Autowired
    private OrdenCompraDetalleService ordenCompraDetalleService;

    public OrdenCompraDetalleController(OrdenCompraDetalleService ordenCompraDetalleService) {
        super(ordenCompraDetalleService);
    }
}