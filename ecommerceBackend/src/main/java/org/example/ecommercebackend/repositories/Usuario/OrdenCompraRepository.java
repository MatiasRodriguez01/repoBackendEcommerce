package org.example.ecommercebackend.repositories.Usuario;

import org.example.ecommercebackend.entities.Usuario.OrdenCompra;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompraRepository extends BaseRepository<OrdenCompra, Long> {
}
