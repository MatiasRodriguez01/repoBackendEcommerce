package org.example.ecommercebackend.controllers.Usuario;

import org.example.ecommercebackend.controllers.BaseController;
import org.example.ecommercebackend.entities.Usuario.UsuarioDireccion;
import org.example.ecommercebackend.services.Usuario.UsuarioDireccionService;
<<<<<<< HEAD
import org.example.ecommercebackend.services.Usuario.UsuarioService;
import org.example.ecommercebackend.services.Usuario.UsuarioDireccionService;
=======
>>>>>>> a25746ff0f44d019280bbef5eb6e1f7b2fe29eea
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuarioDireccion")
public class UsuarioDireccionController extends BaseController<UsuarioDireccion,Long> {

    @Autowired
    private UsuarioDireccionService usuarioDireccionService;

    public UsuarioDireccionController(UsuarioDireccionService usuarioDireccionService) {
        super(usuarioDireccionService);
    }
}