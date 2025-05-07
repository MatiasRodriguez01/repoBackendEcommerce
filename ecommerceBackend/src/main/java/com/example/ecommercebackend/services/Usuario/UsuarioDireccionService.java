package org.example.ecommercebackend.services.Usuario;

import org.example.ecommercebackend.entities.Usuario.UsuarioDireccion;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.example.ecommercebackend.repositories.Usuario.UsuarioDireccionRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDireccionService extends BaseService<UsuarioDireccion, Long> {

    @Autowired
    private UsuarioDireccionRepository usuarioDireccionRepository;

    public UsuarioDireccionService(UsuarioDireccionRepository usuarioDireccionRepository) {
        super(usuarioDireccionRepository);
    }
}
