package org.example.ecommercebackend.repositories.Producto;

import org.example.ecommercebackend.entities.Producto.Precio;
import org.example.ecommercebackend.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecioRepository extends BaseRepository<Precio, Long> {
}
