package org.example.ecommercebackend.repositories.Usuario;

import org.example.ecommercebackend.entities.Usuario.Usuario;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
}
