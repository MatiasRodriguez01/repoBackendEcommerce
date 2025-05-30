package org.example.ecommercebackend.repositories.Usuario;

import org.example.ecommercebackend.entities.Usuario.Usuario;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    Optional<Usuario> findByNombre(String nombre);
}
