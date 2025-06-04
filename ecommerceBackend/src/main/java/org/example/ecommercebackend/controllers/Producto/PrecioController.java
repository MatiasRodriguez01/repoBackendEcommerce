package org.example.ecommercebackend.controllers.Producto;

import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Producto.Precio;
import org.example.ecommercebackend.services.Producto.PrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/precio")
public class PrecioController extends BaseController<Precio,Long> {

    @Autowired
    private PrecioService precioService;

    public PrecioController(PrecioService precioService) {
        super(precioService);
    }
}
