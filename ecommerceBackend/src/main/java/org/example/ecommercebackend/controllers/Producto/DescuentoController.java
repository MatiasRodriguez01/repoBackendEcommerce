package org.example.ecommercebackend.controllers.Producto;


import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Producto.Descuento;
import org.example.ecommercebackend.services.Producto.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/descuentos")
public class DescuentoController extends BaseController<Descuento,Long> {

    @Autowired
    private DescuentoService descuentoService;

    public DescuentoController(DescuentoService descuentoService) {
        super(descuentoService);
    }
}
