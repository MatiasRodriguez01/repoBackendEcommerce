package org.example.ecommercebackend.services.Usuario;

import org.example.ecommercebackend.entities.Usuario.Usuario;
import org.example.ecommercebackend.repositories.Usuario.UsuarioRepository;
import org.example.ecommercebackend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario, Long> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }
}
