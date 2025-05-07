package org.example.ecommercebackend.repositories.Usuario;

import org.example.ecommercebackend.entities.Usuario.OrdenCompraDetalle;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompraDetalleRepository extends BaseRepository<OrdenCompraDetalle, Long> {
}
