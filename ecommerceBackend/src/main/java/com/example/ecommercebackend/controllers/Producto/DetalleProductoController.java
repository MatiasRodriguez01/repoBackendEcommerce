package org.example.ecommercebackend.controllers.Producto;

import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.services.Producto.DetalleProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalleProducto")
public class DetalleProductoController extends BaseController<DetalleProducto,Long> {

    @Autowired
    private DetalleProductoService detalleProductoService;

    public DetalleProductoController(DetalleProductoService detalleProductoService) {
        super(detalleProductoService);
    }
}

