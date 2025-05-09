package org.example.ecommercebackend.controllers.Usuario;

import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Usuario.Direccion;
import org.example.ecommercebackend.services.Producto.DescuentoService;
import org.example.ecommercebackend.services.Usuario.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/direccion")
public class DireccionController extends BaseController<Direccion,Long> {

    @Autowired
    private DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        super(direccionService);
    }
}

