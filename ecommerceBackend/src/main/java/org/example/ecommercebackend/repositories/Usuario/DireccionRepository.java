package org.example.ecommercebackend.repositories.Usuario;

import org.example.ecommercebackend.entities.Usuario.Direccion;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends BaseRepository<Direccion, Long> {
}
