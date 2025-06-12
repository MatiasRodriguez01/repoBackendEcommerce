package org.example.ecommercebackend.controllers.Usuario;

import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Producto.DetalleProducto;
import org.example.ecommercebackend.entities.Producto.Talles;
import org.example.ecommercebackend.entities.Usuario.UsuarioDireccion;
import org.example.ecommercebackend.services.Usuario.UsuarioDireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/usuarioDireccion")
public class UsuarioDireccionController extends BaseController<UsuarioDireccion,Long> {

    @Autowired
    private UsuarioDireccionService usuarioDireccionService;

    public UsuarioDireccionController(UsuarioDireccionService usuarioDireccionService) {
        super(usuarioDireccionService);
    }
    

}