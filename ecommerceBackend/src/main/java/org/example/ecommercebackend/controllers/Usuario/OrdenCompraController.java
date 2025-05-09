package org.example.ecommercebackend.controllers.Usuario;

import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Usuario.OrdenCompra;
import org.example.ecommercebackend.services.Usuario.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordenCompra")
public class OrdenCompraController extends BaseController<OrdenCompra,Long> {

    @Autowired
    private OrdenCompraService ordenCompraService;

    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        super(ordenCompraService);
    }
}

